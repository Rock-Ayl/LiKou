package normal10;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-01-22
 * 921. 使括号有效的最少添加
 * 给定一个由 '(' 和 ')' 括号组成的字符串 S，我们需要添加最少的括号（ '(' 或是 ')'，可以在任何位置），以使得到的括号字符串有效。
 * <p>
 * 从形式上讲，只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成 AB （A 与 B 连接）, 其中 A 和 B 都是有效字符串，或者
 * 它可以被写作 (A)，其中 A 是有效字符串。
 * 给定一个括号字符串，返回为使结果字符串有效而必须添加的最少括号数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："())"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入："((("
 * 输出：3
 * 示例 3：
 * <p>
 * 输入："()"
 * 输出：0
 * 示例 4：
 * <p>
 * 输入："()))(("
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * S.length <= 1000
 * S 只包含 '(' 和 ')' 字符。
 */
public class Code10 {

    public int minAddToMakeValid(String s) {
        //初始化
        Stack<Character> stack = new Stack<>();
        //需要)的次数
        int size = 0;
        //循环
        for (char c : s.toCharArray()) {
            //如果是左
            if (c == '(') {
                //push
                stack.push(c);
            } else {
                //如果正好
                if (stack.empty() == false) {
                    //删除配对
                    stack.pop();
                } else {
                    //+1
                    size++;
                }
            }
        }
        //返回 )+剩余(
        return size + stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code10().minAddToMakeValid("()))(("));
    }
}
