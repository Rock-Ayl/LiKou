package difficult3;

import java.util.Arrays;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-09-19
 * 1106. 解析布尔表达式
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 布尔表达式 是计算结果不是 true 就是 false 的表达式。有效的表达式需遵循以下约定：
 * <p>
 * 't'，运算结果为 true
 * 'f'，运算结果为 false
 * '!(subExpr)'，运算过程为对内部表达式 subExpr 进行 逻辑非（NOT）运算
 * '&(subExpr1, subExpr2, ..., subExprn)'，运算过程为对 2 个或以上内部表达式 subExpr1, subExpr2, ..., subExprn 进行 逻辑与（AND）运算
 * '|(subExpr1, subExpr2, ..., subExprn)'，运算过程为对 2 个或以上内部表达式 subExpr1, subExpr2, ..., subExprn 进行 逻辑或（OR）运算
 * 给你一个以字符串形式表述的 布尔表达式 expression，返回该式的运算结果。
 * <p>
 * 题目测试用例所给出的表达式均为有效的布尔表达式，遵循上述约定。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：expression = "&(|(f))"
 * 输出：false
 * 解释：
 * 首先，计算 |(f) --> f ，表达式变为 "&(f)" 。
 * 接着，计算 &(f) --> f ，表达式变为 "f" 。
 * 最后，返回 false 。
 * 示例 2：
 * <p>
 * 输入：expression = "|(f,f,f,t)"
 * 输出：true
 * 解释：计算 (false OR false OR false OR true) ，结果为 true 。
 * 示例 3：
 * <p>
 * 输入：expression = "!(&(f,t))"
 * 输出：true
 * 解释：
 * 首先，计算 &(f,t) --> (false AND true) --> false --> f ，表达式变为 "!(f)" 。
 * 接着，计算 !(f) --> NOT false --> true ，返回 true 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= expression.length <= 2 * 104
 * expression[i] 为 '('、')'、'&'、'|'、'!'、't'、'f' 和 ',' 之一
 */
public class Code1 {

    //计算当前公式
    private Character count(StringBuilder str) {
        //获取首字符
        char first = str.charAt(0);
        //删除多余内容
        str.deleteCharAt(0);
        str.deleteCharAt(0);
        str.deleteCharAt(str.length() - 1);
        //拆分为对应数组,转为布尔集合
        Set<Boolean> booleanSet = Arrays.stream(str.toString()
                .split(","))
                .map("t"::equals)
                .collect(Collectors.toSet());
        //目标结果
        boolean result;
        //根据首字符处理各种情况
        switch (first) {
            case '!':
                //判断
                result = !booleanSet.contains(true);
                break;
            case '&':
                //判断
                result = !booleanSet.contains(false);
                break;
            case '|':
            default:
                //判断
                result = booleanSet.contains(true);
                break;
        }
        //返回
        return result == true ? 't' : 'f';
    }

    public boolean parseBoolExpr(String expression) {
        //缓存
        Stack<Character> stack = new Stack<>();
        //循环
        for (char letter : expression.toCharArray()) {
            //根据字符判断操作
            switch (letter) {
                //如果是某个完整公式结尾
                case ')':
                    //公式字符
                    StringBuilder str = new StringBuilder(")");
                    //如果没到头
                    while (stack.peek() != '(') {
                        //组装
                        str.append(stack.pop());
                    }
                    //加入(
                    str.append(stack.pop());
                    //加入开头符号
                    str.append(stack.pop());
                    //翻转一下
                    str.reverse();
                    //计算本公式结果,并加入队列
                    stack.push(count(str));
                    break;
                //默认字符
                default:
                    //直接加入栈
                    stack.push(letter);
                    break;
            }
        }
        //返回结果
        return stack.peek().equals('t');
    }

    public static void main(String[] args) {
        System.out.println(new Code1().parseBoolExpr("&(|(f))"));
    }

}
