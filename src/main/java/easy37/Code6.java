package easy37;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2024-06-10
 * 3174. 清除数字
 * 简单
 * 相关企业
 * 提示
 * 给你一个字符串 s 。
 * <p>
 * 你的任务是重复以下操作删除 所有 数字字符：
 * <p>
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abc"
 * <p>
 * 输出："abc"
 * <p>
 * 解释：
 * <p>
 * 字符串中没有数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "cb34"
 * <p>
 * 输出：""
 * <p>
 * 解释：
 * <p>
 * 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
 * <p>
 * 然后对 s[1] 执行操作，s 变为 "" 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母和数字字符。
 * 输入保证所有数字都可以按以上操作被删除。
 */
public class Code6 {

    public String clearDigits(String s) {
        //初始化
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : s.toCharArray()) {
            //转为数字
            int number = c - '0';
            //如果是数字
            if (number >= 0 && number <= 9) {
                //删除
                stack.pop();
            } else {
                //直接加入
                stack.push(c);
            }
        }
        //初始化
        StringBuilder str = new StringBuilder();
        //循环
        for (Character letter : stack) {
            //组合
            str.append(letter);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code6().clearDigits("cd34"));
    }

}
