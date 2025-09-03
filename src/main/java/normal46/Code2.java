package normal46;

/**
 * @Author ayl
 * @Date 2025-09-03
 * 2559. 统计范围内的元音字符串数
 * 算术评级: 3
 * 第 331 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1435
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串数组 words 以及一个二维整数数组 queries 。
 * <p>
 * 每个查询 queries[i] = [li, ri] 会要求我们统计在 words 中下标在 li 到 ri 范围内（包含 这两个值）并且以元音开头和结尾的字符串的数目。
 * <p>
 * 返回一个整数数组，其中数组的第 i 个元素对应第 i 个查询的答案。
 * <p>
 * 注意：元音字母是 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["aba","bcb","ece","aa","e"], queries = [[0,2],[1,4],[1,1]]
 * 输出：[2,3,0]
 * 解释：以元音开头和结尾的字符串是 "aba"、"ece"、"aa" 和 "e" 。
 * 查询 [0,2] 结果为 2（字符串 "aba" 和 "ece"）。
 * 查询 [1,4] 结果为 3（字符串 "ece"、"aa"、"e"）。
 * 查询 [1,1] 结果为 0 。
 * 返回结果 [2,3,0] 。
 * 示例 2：
 * <p>
 * 输入：words = ["a","e","i"], queries = [[0,2],[0,1],[2,2]]
 * 输出：[3,2,1]
 * 解释：每个字符串都满足这一条件，所以返回 [3,2,1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 105
 * 1 <= words[i].length <= 40
 * words[i] 仅由小写英文字母组成
 * sum(words[i].length) <= 3 * 105
 * 1 <= queries.length <= 105
 * 0 <= queries[j][0] <= queries[j][1] < words.length
 */
public class Code2 {

    public int[] vowelStrings(String[] words, int[][] queries) {

        /**
         * 构建前缀和
         */

        //元音数组
        int[] cacheArr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //前缀和
        int[] arr = new int[words.length];
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前
            String word = words[i];
            //记录前缀和
            arr[i] = ((cacheArr[word.charAt(0) - 'a'] == 1) && (cacheArr[word.charAt(word.length() - 1) - 'a'] == 1) ? 1 : 0) + (i > 0 ? arr[i - 1] : 0);
        }

        /**
         * 计算每个位置的结果
         */

        //初始化结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //获取问题
            int[] query = queries[i];
            //本次问题结果
            result[i] = arr[query[1]] - (query[0] > 0 ? arr[query[0] - 1] : 0);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code2().vowelStrings(new String[]{"aba", "bcb", "ece", "aa", "e"}, new int[][]{
                new int[]{0, 2},
                new int[]{1, 4},
                new int[]{1, 1}
        });
    }

}
