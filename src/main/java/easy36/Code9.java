package easy36;

/**
 * @Author ayl
 * @Date 2024-02-25
 * 3042. 统计前后缀下标对 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串数组 words 。
 * <p>
 * 定义一个 布尔 函数 isPrefixAndSuffix ，它接受两个字符串参数 str1 和 str2 ：
 * <p>
 * 当 str1 同时是 str2 的前缀（
 * prefix
 * ）和后缀（
 * suffix
 * ）时，isPrefixAndSuffix(str1, str2) 返回 true，否则返回 false。
 * 例如，isPrefixAndSuffix("aba", "ababa") 返回 true，因为 "aba" 既是 "ababa" 的前缀，也是 "ababa" 的后缀，但是 isPrefixAndSuffix("abc", "abcd") 返回 false。
 * <p>
 * 以整数形式，返回满足 i < j 且 isPrefixAndSuffix(words[i], words[j]) 为 true 的下标对 (i, j) 的 数量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["a","aba","ababa","aa"]
 * 输出：4
 * 解释：在本示例中，计数的下标对包括：
 * i = 0 且 j = 1 ，因为 isPrefixAndSuffix("a", "aba") 为 true 。
 * i = 0 且 j = 2 ，因为 isPrefixAndSuffix("a", "ababa") 为 true 。
 * i = 0 且 j = 3 ，因为 isPrefixAndSuffix("a", "aa") 为 true 。
 * i = 1 且 j = 2 ，因为 isPrefixAndSuffix("aba", "ababa") 为 true 。
 * 因此，答案是 4 。
 * 示例 2：
 * <p>
 * 输入：words = ["pa","papa","ma","mama"]
 * 输出：2
 * 解释：在本示例中，计数的下标对包括：
 * i = 0 且 j = 1 ，因为 isPrefixAndSuffix("pa", "papa") 为 true 。
 * i = 2 且 j = 3 ，因为 isPrefixAndSuffix("ma", "mama") 为 true 。
 * 因此，答案是 2 。
 * 示例 3：
 * <p>
 * 输入：words = ["abab","ab"]
 * 输出：0
 * 解释：在本示例中，唯一有效的下标对是 i = 0 且 j = 1 ，但是 isPrefixAndSuffix("abab", "ab") 为 false 。
 * 因此，答案是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= words[i].length <= 10
 * words[i] 仅由小写英文字母组成。
 */
public class Code9 {

    //对比
    private boolean isPrefixAndSuffix(String left, String right) {
        //如果太长
        if (left.length() > right.length()) {
            //过
            return false;
        }
        //实现
        return right.startsWith(left) && right.endsWith(left);
    }

    public int countPrefixSuffixPairs(String[] words) {
        //结果
        int count = 0;
        //循环
        for (int i = 0; i < words.length; i++) {
            //左边
            String left = words[i];
            //循环
            for (int j = i + 1; j < words.length; j++) {
                //右边
                String right = words[j];
                //如果是
                if (isPrefixAndSuffix(left, right)) {
                    //记录
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countPrefixSuffixPairs(new String[]{"a", "abb"}));
    }

}
