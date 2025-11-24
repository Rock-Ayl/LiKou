package normal48;

/**
 * @Author ayl
 * @Date 2025-11-24
 * 2825. 循环增长使字符串子序列等于另一个字符串
 * 算术评级: 4
 * 第 111 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1415
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 str1 和 str2 。
 * <p>
 * 一次操作中，你选择 str1 中的若干下标。对于选中的每一个下标 i ，你将 str1[i] 循环 递增，变成下一个字符。也就是说 'a' 变成 'b' ，'b' 变成 'c' ，以此类推，'z' 变成 'a' 。
 * <p>
 * 如果执行以上操作 至多一次 ，可以让 str2 成为 str1 的子序列，请你返回 true ，否则返回 false 。
 * <p>
 * 注意：一个字符串的子序列指的是从原字符串中删除一些（可以一个字符也不删）字符后，剩下字符按照原本先后顺序组成的新字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：str1 = "abc", str2 = "ad"
 * 输出：true
 * 解释：选择 str1 中的下标 2 。
 * 将 str1[2] 循环递增，得到 'd' 。
 * 因此，str1 变成 "abd" 且 str2 现在是一个子序列。所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：str1 = "zc", str2 = "ad"
 * 输出：true
 * 解释：选择 str1 中的下标 0 和 1 。
 * 将 str1[0] 循环递增得到 'a' 。
 * 将 str1[1] 循环递增得到 'd' 。
 * 因此，str1 变成 "ad" 且 str2 现在是一个子序列。所以返回 true 。
 * 示例 3：
 * <p>
 * 输入：str1 = "ab", str2 = "d"
 * 输出：false
 * 解释：这个例子中，没法在执行一次操作的前提下，将 str2 变为 str1 的子序列。
 * 所以返回 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= str1.length <= 105
 * 1 <= str2.length <= 105
 * str1 和 str2 只包含小写英文字母。
 */
public class Code6 {

    public boolean canMakeSubsequence(String str1, String str2) {
        //索引
        int index1 = 0;
        int index2 = 0;
        //循环
        while (index1 < str1.length() && index2 < str2.length()) {
            //获取
            char a = str1.charAt(index1);
            char b = str2.charAt(index2);
            //如果相同
            if (a == b) {
                //+1
                index1++;
                index2++;
                //本轮过
                continue;
            }
            //两种情况
            if (a == 'z') {
                //如果满足
                if (b == 'a') {
                    //+1
                    index1++;
                    index2++;
                } else {
                    //+1
                    index1++;
                }
            } else {
                //如果满足
                if (b - a == 1) {
                    //+1
                    index1++;
                    index2++;
                } else {
                    //+1
                    index1++;
                }
            }
        }
        //返回结果
        return index2 == str2.length();
    }

    public static void main(String[] args) {
        System.out.println(new Code6().canMakeSubsequence("ab", "d"));
    }

}
