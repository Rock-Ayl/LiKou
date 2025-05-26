package normal43;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2025-05-26
 * 3561. 移除相邻字符
 * 中等
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的字符串 s。
 * <p>
 * 你 必须 在字符串 s 中至少存在两个 连续 字符时，反复执行以下操作：
 * <p>
 * 移除字符串中 最左边 的一对按照字母表 连续 的相邻字符（无论是按顺序还是逆序，例如 'a' 和 'b'，或 'b' 和 'a'）。
 * 将剩余字符向左移动以填补空隙。
 * 当无法再执行任何操作时，返回最终的字符串。
 * <p>
 * 注意：字母表是循环的，因此 'a' 和 'z' 也视为连续。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "abc"
 * <p>
 * 输出: "c"
 * <p>
 * 解释:
 * <p>
 * 从字符串中移除 "ab"，剩下 "c"。
 * 无法进行进一步操作。因此，所有可能移除操作后的最终字符串为 "c"。
 * 示例 2：
 * <p>
 * 输入: s = "adcb"
 * <p>
 * 输出: ""
 * <p>
 * 解释:
 * <p>
 * 从字符串中移除 "dc"，剩下 "ab"。
 * 从字符串中移除 "ab"，剩下 ""。
 * 无法进行进一步操作。因此，所有可能移除操作后的最终字符串为 ""。
 * 示例 3：
 * <p>
 * 输入: s = "zadb"
 * <p>
 * 输出: "db"
 * <p>
 * 解释:
 * <p>
 * 从字符串中移除 "za"，剩下 "db"。
 * 无法进行进一步操作。因此，所有可能移除操作后的最终字符串为 "db"。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成。
 */
public class Code10 {

    public String resultingString(String s) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //获取字符
            char letter = s.charAt(i);
            //如果是连续的
            if (stack.isEmpty() == false && near(stack.peek(), letter)) {
                //删除之
                stack.pop();
            } else {
                //直接加入
                stack.push(letter);
            }
        }
        //结果
        StringBuilder str = new StringBuilder();
        //循环
        for (Character letter : stack) {
            //组装结果
            str.append(letter);
        }
        //返回
        return str.toString();
    }

    //判断是否靠近
    private boolean near(char one, char two) {
        //如果是正常情况
        if (Math.abs(one - two) == 1) {
            //是
            return true;
        }
        //如果是特殊情况
        if (Math.abs(one - two) == 25) {
            //是
            return true;
        }
        //默认不是
        return false;
    }

    public static void main(String[] args) {
        System.out.println('z' - 'a');
        System.out.println(new Code10().resultingString("zadb"));
    }

}