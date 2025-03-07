package easy3;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-11-24
 * 20. 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * 通过次数464,548提交次数1,072,789
 */
public class Code27 {

    public static boolean isValid(String s) {
        //用堆栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : s.toCharArray()) {
            //根据左右括号来操作
            switch (c) {
                //左
                case '(':
                    //提交另一半
                    stack.push(')');
                    break;
                //左
                case '[':
                    //提交另一半
                    stack.push(']');
                    break;
                //左
                case '{':
                    //提交另一半
                    stack.push('}');
                    break;
                //右括号的操作
                default:
                    //判断
                    if (stack.isEmpty() || c != stack.pop()) {
                        //直接确认
                        return false;
                    }
                    break;
            }
        }
        //根据剩没剩,判断结果
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(([]){})"));
    }
}
