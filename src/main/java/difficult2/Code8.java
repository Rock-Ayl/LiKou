package difficult2;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2024-04-11
 * 224. 基本计算器
 * 困难
 * 相关标签
 * 相关企业
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 注意:不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "1 + 1"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：s = " 2-1 + 2 "
 * 输出：3
 * 示例 3：
 * <p>
 * 输入：s = "(1+(4+5+2)-3)+(6+8)"
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由数字、'+'、'-'、'('、')'、和 ' ' 组成
 * s 表示一个有效的表达式
 * '+' 不能用作一元运算(例如， "+1" 和 "+(2 + 3)" 无效)
 * '-' 可以用作一元运算(即 "-1" 和 "-(2 + 3)" 是有效的)
 * 输入中不存在两个连续的操作符
 * 每个数字和运行的计算将适合于一个有符号的 32位 整数
 */
public class Code8 {

    //判断字符是否为数字
    private boolean isNum(char letter) {
        //转换为数字
        int num = letter - '0';
        //判断范围
        return num >= 0 && num <= 9;
    }

    //获取纯数字
    private int countNum(Stack<Character> stack) {
        //初始化数字和,进来第一个肯定是数字
        StringBuilder sumStr = new StringBuilder();
        //如果后续是数字
        while (stack.isEmpty() == false && isNum(stack.peek())) {
            //叠加
            sumStr.append(stack.pop());
        }
        //翻转数字
        sumStr.reverse();
        //转化为数字
        int sum = Integer.valueOf(sumStr.toString());
        //如果前面还有,并且是 正负号
        while (stack.isEmpty() == false && (stack.peek().equals('-') || stack.peek().equals('+'))) {
            //获取符号
            Character first = stack.pop();
            //如果是负号
            if (first.equals('-')) {
                //变为负数
                sum = -sum;
            }
        }
        //返回结果
        return sum;
    }

    //获取括号内的数字
    private int countNext(Stack<Character> stack) {
        //删除最后一个)
        stack.pop();
        //和
        int sum = 0;
        //无线递归,直到找到目标(
        while (true) {
            //如果是(
            if (stack.peek().equals('(')) {
                //删除之
                stack.pop();
                //跳出
                break;
            }
            //如果是)
            if (stack.peek().equals(')')) {
                //递归子()并叠加
                sum += count(stack);
                //本轮过
                continue;
            }
            //计算最近的数字,并叠加
            sum += count(stack);
        }
        //如果前面还有,并且是 正负号
        while (stack.isEmpty() == false && (stack.peek().equals('-') || stack.peek().equals('+'))) {
            //删除之,并且如果是负号
            if (stack.pop().equals('-')) {
                //变为负数
                sum = -sum;
            }
        }
        //返回
        return sum;
    }

    //统一获取最近一层的内容,用来处理是数字还是子级
    private int count(Stack<Character> stack) {
        //如果到头了
        if (stack.isEmpty()) {
            //返回
            return 0;
        }
        //偷看下最后一个,如果是单纯的数字
        if (isNum(stack.peek())) {
            //返回数字
            return countNum(stack);
        } else {
            //返回括号内的内容
            return countNext(stack);
        }
    }

    public int calculate(String s) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char letter : s.toCharArray()) {
            //如果不是无效字符
            if (letter != ' ') {
                //组装
                stack.push(letter);
            }
        }
        //和
        int sum = 0;
        //如果还有
        while (stack.isEmpty() == false) {
            //计算最近的数字,并叠加
            sum += count(stack);
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().calculate("- (3 + (4 + 5))"));
    }

}
