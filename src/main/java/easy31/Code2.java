package easy31;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-05-22
 * 6439. 删除子串后的字符串最小长度
 * 给你一个仅由 大写 英文字符组成的字符串 s 。
 * <p>
 * 你可以对此字符串执行一些操作，在每一步操作中，你可以从 s 中删除 任一个 "AB" 或 "CD" 子字符串。
 * <p>
 * 通过执行操作，删除所有 "AB" 和 "CD" 子串，返回可获得的最终字符串的 最小 可能长度。
 * <p>
 * 注意，删除子串后，重新连接出的字符串可能会产生新的 "AB" 或 "CD" 子串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ABFCACDB"
 * 输出：2
 * 解释：你可以执行下述操作：
 * - 从 "ABFCACDB" 中删除子串 "AB"，得到 s = "FCACDB" 。
 * - 从 "FCACDB" 中删除子串 "CD"，得到 s = "FCAB" 。
 * - 从 "FCAB" 中删除子串 "AB"，得到 s = "FC" 。
 * 最终字符串的长度为 2 。
 * 可以证明 2 是可获得的最小长度。
 * 示例 2：
 * <p>
 * 输入：s = "ACBBD"
 * 输出：5
 * 解释：无法执行操作，字符串长度不变。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由大写英文字母组成
 */
public class Code2 {

    public int minLength(String s) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : s.toCharArray()) {
            //判空
            if (stack.isEmpty()) {
                //直接加入
                stack.push(c);
                //本轮过
                continue;
            }
            //如果是AB组合
            if (c == 'B' && stack.peek() == 'A') {
                //删除A
                stack.pop();
                //本轮过
                continue;
            }
            //如果是CD组合
            if (c == 'D' && stack.peek() == 'C') {
                //删除C
                stack.pop();
                //本轮过
                continue;
            }
            //默认
            stack.push(c);
        }
        //返回
        return stack.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code2().minLength("ABFCACDB"));
    }

}
