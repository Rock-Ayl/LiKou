package normal13;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-03-27
 * 856. 括号的分数
 * 给定一个平衡括号字符串 S，按下述规则计算该字符串的分数：
 * <p>
 * () 得 1 分。
 * AB 得 A + B 分，其中 A 和 B 是平衡括号字符串。
 * (A) 得 2 * A 分，其中 A 是平衡括号字符串。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： "()"
 * 输出： 1
 * 示例 2：
 * <p>
 * 输入： "(())"
 * 输出： 2
 * 示例 3：
 * <p>
 * 输入： "()()"
 * 输出： 2
 * 示例 4：
 * <p>
 * 输入： "(()(()))"
 * 输出： 6
 * <p>
 * <p>
 * 提示：
 * <p>
 * S 是平衡括号字符串，且只含有 ( 和 ) 。
 * 2 <= S.length <= 50
 */
public class Code13 {

    public int scoreOfParentheses(String s) {
        //栈
        Stack stack = new Stack<>();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char letter = s.charAt(i);
            //如果是左
            if (letter == '(') {
                //推送
                stack.push(letter);
            } else {
                //上一个
                Object last = stack.pop();
                //如果是符号或数字
                if (last instanceof Character) {
                    //直接推送结果
                    stack.push(1);
                } else {
                    //和
                    int sum = (Integer) last;
                    //继续找
                    Object next = stack.pop();
                    //如果还是数字
                    while (next instanceof Integer) {
                        //叠加
                        sum += (Integer) next;
                        //下一个
                        next = stack.pop();
                    }
                    //计算一倍
                    sum = sum * 2;
                    //组装入数字
                    stack.push(sum);
                }
            }
        }
        //结果
        int result = 0;
        //循环
        for (Object num : stack) {
            //叠加
            result += (Integer) num;
        }
        //返回最终结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().scoreOfParentheses("(()(()))"));
    }

}
