package easy29;

/**
 * @Author ayl
 * @Date 2023-04-03
 * 2609. 最长平衡子字符串
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * <p>
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * <p>
 * 返回  s 中最长的平衡子字符串长度。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * <p>
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * <p>
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * '0' <= s[i] <= '1'
 */
public class Code8 {

    public int findTheLongestBalancedSubstring(String s) {
        //指针
        int p = 0;
        //最大可能
        int maxHit = 0;
        //如果还有内容
        while (p < s.length()) {
            //先判断0连击数
            int zeroHit = 0;
            //如果继续有
            while (p < s.length() && s.charAt(p) == '0') {
                //连击
                zeroHit++;
                //下一个
                p++;
            }
            //如果到头了
            if (p == s.length()) {
                //结束
                break;
            }
            //1连击数
            int oneHit = 0;
            //如果继续有
            while (p < s.length() && s.charAt(p) == '1') {
                //连击
                oneHit++;
                //下一个
                p++;
            }
            //刷新最大可能
            maxHit = Math.max(maxHit, Math.min(zeroHit, oneHit));
        }
        //返回结果
        return maxHit * 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().findTheLongestBalancedSubstring("01000111"));
        ;
    }

}
