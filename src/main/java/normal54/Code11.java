package normal54;

/**
 * 395. 至少有 K 个重复字符的最长子串
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 * 如果不存在这样的子字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * <p>
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 */
public class Code11 {

    public int longestSubstring(String s, int k) {
        //最大长度
        int maxLength = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //计数器
            int[] arr = new int[26];
            //满足k次的数组
            int targetCount = 0;
            //不同字符的数量
            int notSameCount = 0;
            //循环2
            for (int j = i; j < s.length(); j++) {
                //索引
                int index = s.charAt(j) - 'a';
                //+1
                arr[index]++;
                //如果第一次出现
                if (arr[index] == 1) {
                    //+1
                    notSameCount++;
                }
                //如果满足k次
                if (arr[index] == k) {
                    //+1
                    targetCount++;
                }
                //如果满足
                if (targetCount == notSameCount) {
                    //刷新最大
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        //返回最大长度
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().longestSubstring("aaabb", 3));
    }

}
