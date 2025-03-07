package easy17;

/**
 * @Author ayl
 * @Date 2022-03-22
 * 2124. 检查是否所有 A 都在 B 之前
 * 给你一个 仅 由字符 'a' 和 'b' 组成的字符串  s 。如果字符串中 每个 'a' 都出现在 每个 'b' 之前，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabbb"
 * 输出：true
 * 解释：
 * 'a' 位于下标 0、1 和 2 ；而 'b' 位于下标 3、4 和 5 。
 * 因此，每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：s = "abab"
 * 输出：false
 * 解释：
 * 存在一个 'a' 位于下标 2 ，而一个 'b' 位于下标 1 。
 * 因此，不能满足每个 'a' 都出现在每个 'b' 之前，所以返回 false 。
 * 示例 3：
 * <p>
 * 输入：s = "bbb"
 * 输出：true
 * 解释：
 * 不存在 'a' ，因此可以视作每个 'a' 都出现在每个 'b' 之前，所以返回 true 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s[i] 为 'a' 或 'b'
 */
public class Code2 {

    public boolean checkString(String s) {
        //指针
        int p = 0;
        //循环1
        while (p < s.length()) {
            //如果找到了b
            if (s.charAt(p++) == 'b') {
                //循环2
                while (p < s.length()) {
                    //如果找到了a
                    if (s.charAt(p++) == 'a') {
                        //不是
                        return false;
                    }
                }

            }
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        new Code2().checkString("aaabbb");
    }

}
