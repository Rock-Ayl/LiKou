package normal45;

/**
 * @Author ayl
 * @Date 2025-07-26
 * 2063. 所有子字符串中的元音
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 word ，返回 word 的所有子字符串中 元音的总数 ，元音是指 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 * 子字符串 是字符串中一个连续（非空）的字符序列。
 * <p>
 * 注意：由于对 word 长度的限制比较宽松，答案可能超过有符号 32 位整数的范围。计算时需当心。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aba"
 * 输出：6
 * 解释：
 * 所有子字符串是："a"、"ab"、"aba"、"b"、"ba" 和 "a" 。
 * - "b" 中有 0 个元音
 * - "a"、"ab"、"ba" 和 "a" 每个都有 1 个元音
 * - "aba" 中有 2 个元音
 * 因此，元音总数 = 0 + 1 + 1 + 1 + 1 + 2 = 6 。
 * 示例 2：
 * <p>
 * 输入：word = "abc"
 * 输出：3
 * 解释：
 * 所有子字符串是："a"、"ab"、"abc"、"b"、"bc" 和 "c" 。
 * - "a"、"ab" 和 "abc" 每个都有 1 个元音
 * - "b"、"bc" 和 "c" 每个都有 0 个元音
 * 因此，元音总数 = 1 + 1 + 1 + 0 + 0 + 0 = 3 。
 * 示例 3：
 * <p>
 * 输入：word = "ltcd"
 * 输出：0
 * 解释："ltcd" 的子字符串均不含元音。
 * 示例 4：
 * <p>
 * 输入：word = "noosabasboosa"
 * 输出：237
 * 解释：所有子字符串中共有 237 个元音。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 105
 * word 由小写英文字母组成
 */
public class Code9 {

    public long countVowels(String word) {
        //结果
        long result = 0L;
        //元音对照表
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //循环
        for (int i = 0; i < word.length(); i++) {
            //字符
            char letter = word.charAt(i);
            //如果不是元音
            if (arr[letter - 'a'] == 0) {
                //本轮过
                continue;
            }
            //计算本次结果
            result += count(word.length(), i);
        }
        //返回
        return result;
    }

    //计算其被引用了几次
    private long count(long length, long index) {
        //返回
        return (length - index) * (index + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countVowels("noosabasboosa"));
    }
}
