package normal34;

/**
 * @Author ayl
 * @Date 2024-08-13
 * 3163. 压缩字符串 III
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word，请你使用以下算法进行压缩：
 * <p>
 * 从空字符串 comp 开始。当 word 不为空 时，执行以下操作：
 * 移除 word 的最长单字符前缀，该前缀由单一字符 c 重复多次组成，且该前缀长度 最多 为 9 。
 * 将前缀的长度和字符 c 追加到 comp 。
 * 返回字符串 comp 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abcde"
 * <p>
 * 输出："1a1b1c1d1e"
 * <p>
 * 解释：
 * <p>
 * 初始时，comp = "" 。进行 5 次操作，每次操作分别选择 "a"、"b"、"c"、"d" 和 "e" 作为前缀。
 * <p>
 * 对每个前缀，将 "1" 和对应的字符追加到 comp。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "aaaaaaaaaaaaaabb"
 * <p>
 * 输出："9a5a2b"
 * <p>
 * 解释：
 * <p>
 * 初始时，comp = ""。进行 3 次操作，每次操作分别选择 "aaaaaaaaa"、"aaaaa" 和 "bb" 作为前缀。
 * <p>
 * 对于前缀 "aaaaaaaaa"，将 "9" 和 "a" 追加到 comp。
 * 对于前缀 "aaaaa"，将 "5" 和 "a" 追加到 comp。
 * 对于前缀 "bb"，将 "2" 和 "b" 追加到 comp。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 2 * 105
 * word 仅由小写英文字母组成。
 */
public class Code7 {

    public String compressedString(String word) {
        //初始化结果
        StringBuilder str = new StringBuilder();
        //指针
        int p = 0;
        //循环
        while (p < word.length()) {
            //当前数字
            char letter = word.charAt(p++);
            //默认连续数
            int hit = 1;
            //如果有后续
            while (hit < 9 && p < word.length() && word.charAt(p) == letter) {
                //+1
                p++;
                hit++;
            }
            //记录
            str.append(hit);
            str.append(letter);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code7().compressedString("aaaaaaaaaaaaaabb"));
    }

}
