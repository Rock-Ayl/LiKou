package normal36;

/**
 * @Author ayl
 * @Date 2024-10-28
 * 1358. 包含所有三种字符的子字符串数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s ，它只包含三种字符 a, b 和 c 。
 * <p>
 * 请你返回 a，b 和 c 都 至少 出现过一次的子字符串数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcabc"
 * 输出：10
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "abc", "abca", "abcab", "abcabc", "bca", "bcab", "bcabc", "cab", "cabc" 和 "abc" (相同字符串算多次)。
 * 示例 2：
 * <p>
 * 输入：s = "aaacb"
 * 输出：3
 * 解释：包含 a，b 和 c 各至少一次的子字符串为 "aaacb", "aacb" 和 "acb" 。
 * 示例 3：
 * <p>
 * 输入：s = "abc"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 5 x 10^4
 * s 只包含字符 a，b 和 c 。
 */
public class Code16 {

    public int numberOfSubstrings(String s) {
        //本次结果
        int result = 0;
        //缓存
        int[] arr = new int[3];
        //开始、结束
        int start = 0;
        int end = 0;
        //循环
        while (end < s.length()) {
            //当前字符
            arr[s.charAt(end++) - 'a']++;
            //如果满足平衡
            while (arr[0] > 0 && arr[1] > 0 && arr[2] > 0) {
                //叠加本次数量
                result += s.length() - end + 1;
                //当前字符
                arr[s.charAt(start++) - 'a']--;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().numberOfSubstrings("abcabc"));
    }

}
