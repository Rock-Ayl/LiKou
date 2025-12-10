package normal48;

/**
 * @Author ayl
 * @Date 2025-12-10
 * 1208. 尽可能使字符串相等
 * 算术评级: 5
 * 第 156 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1497
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个长度相同的字符串，s 和 t。
 * <p>
 * 将 s 中的第 i 个字符变到 t 中的第 i 个字符需要 |s[i] - t[i]| 的开销（开销可能为 0），也就是两个字符的 ASCII 码值的差的绝对值。
 * <p>
 * 用于变更字符串的最大预算是 maxCost。在转化字符串时，总开销应当小于等于该预算，这也意味着字符串的转化可能是不完全的。
 * <p>
 * 如果你可以将 s 的子字符串转化为它在 t 中对应的子字符串，则返回可以转化的最大长度。
 * <p>
 * 如果 s 中没有子字符串可以转化成 t 中对应的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "bcdf", maxCost = 3
 * 输出：3
 * 解释：s 中的 "abc" 可以变为 "bcd"。开销为 3，所以最大长度为 3。
 * 示例 2：
 * <p>
 * 输入：s = "abcd", t = "cdef", maxCost = 3
 * 输出：1
 * 解释：s 中的任一字符要想变成 t 中对应的字符，其开销都是 2。因此，最大长度为 1。
 * 示例 3：
 * <p>
 * 输入：s = "abcd", t = "acde", maxCost = 0
 * 输出：1
 * 解释：a -> a, cost = 0，字符串未发生变化，所以最大长度为 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, t.length <= 10^5
 * 0 <= maxCost <= 10^6
 * s 和 t 都只含小写英文字母。
 */
public class Code20 {

    public int equalSubstring(String s, String t, int maxCost) {
        //缓存
        int[] arr = new int[s.length()];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //计算当前
            arr[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }
        //最大长度
        int maxLength = 0;
        //当前cost
        int cost = 0;
        //双指针
        int left = 0;
        int right = 0;
        //循环
        while (right < arr.length) {
            //如果可以继续加
            if (arr[right] + cost <= maxCost) {
                //刷新最大长度
                maxLength = Math.max(maxLength, (right - left + 1));
                //右滑
                cost = arr[right] + cost;
                right++;
                //本轮过
                continue;
            }
            //左滑
            cost = cost - arr[left++];
        }
        //返回
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().equalSubstring("abcd", "cdef", 3));
    }

}
