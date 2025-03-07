package normal24;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-09-07
 * 150. 逆波兰表达式求值
 * 中等
 * 797
 * 相关企业
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * <p>
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * <p>
 * 注意：
 * <p>
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * <p>
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * <p>
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * <p>
 * <p>
 * 逆波兰表达式：
 * <p>
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 * 通过次数
 * 301.1K
 * 提交次数
 * 568.6K
 * 通过率
 * 53.0%
 */
public class Code1 {

    public int evalRPN(String[] tokens) {
        //栈
        Stack<Integer> stack = new Stack<>();
        //循环
        for (String token : tokens) {
            //根据符号处理
            switch (token) {
                case "+":
                    //上一个
                    Integer last1 = stack.pop();
                    //计算并返回
                    stack.push(stack.pop() + last1);
                    break;
                case "-":
                    //上一个
                    Integer last2 = stack.pop();
                    //计算并返回
                    stack.push(stack.pop() - last2);
                    break;
                case "*":
                    //上一个
                    Integer last3 = stack.pop();
                    //计算并返回
                    stack.push(stack.pop() * last3);
                    break;
                case "/":
                    //上一个
                    Integer last4 = stack.pop();
                    //计算并返回
                    stack.push(stack.pop() / last4);
                    break;
                //默认
                default:
                    //记录数字
                    stack.push(Integer.valueOf(token));
                    break;
            }
        }
        //结果
        return stack.peek();
    }

    public static void main(String[] args) {
        System.out.println(new Code1().evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}
