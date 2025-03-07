package normal13;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-03-21
 * 1190. 反转每对括号间的子串
 * 给出一个字符串 s（仅含有小写英文字母和括号）。
 * <p>
 * 请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。
 * <p>
 * 注意，您的结果中 不应 包含任何括号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(abcd)"
 * 输出："dcba"
 * 示例 2：
 * <p>
 * 输入：s = "(u(love)i)"
 * 输出："iloveu"
 * 解释：先反转子字符串 "love" ，然后反转整个字符串。
 * 示例 3：
 * <p>
 * 输入：s = "(ed(et(oc))el)"
 * 输出："leetcode"
 * 解释：先反转子字符串 "oc" ，接着反转 "etco" ，然后反转整个字符串。
 * 示例 4：
 * <p>
 * 输入：s = "a(bcdefghijkl(mno)p)q"
 * 输出："apmnolkjihgfedcbq"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 2000
 * s 中只有小写英文字母和括号
 * 题目测试用例确保所有括号都是成对出现的
 */
public class Code11 {

    public String reverseParentheses(String s) {
        //缓存
        Stack<String> stack = new Stack<>();
        //当前字符
        StringBuilder str = new StringBuilder();
        //循环
        for (char c : s.toCharArray()) {
            //根据当前字符判断该操作
            if (c == '(') {
                //如果有长度
                if (str.length() > 0) {
                    //push
                    stack.push(str.toString());
                    //初始化
                    str = new StringBuilder();
                }
                //push
                stack.push(String.valueOf(c));
            } else if (c == ')') {
                //如果前面有值,并且不是(
                while (stack.isEmpty() == false && "(".equals(stack.peek()) == false) {
                    //获取字符串并组装到前面
                    str.insert(0, stack.pop());
                }
                //如果有值并且是(
                if (stack.isEmpty() == false) {
                    //删除(
                    stack.pop();
                }
                //翻转整个字符串
                str.reverse();
                //继续推送
                stack.push(str.toString());
                //初始化
                str = new StringBuilder();
            } else {
                //组装
                str.append(c);
            }
        }
        //开始整合最后结果
        while (stack.isEmpty() == false) {
            //插入前面
            str.insert(0, stack.pop());
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

}
