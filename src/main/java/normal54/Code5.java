package normal54;

/**
 * 2947. 统计美丽子字符串 I
 * 算术评级: 3
 * 第 373 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1451
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个正整数 k 。
 * <p>
 * 用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量。
 * <p>
 * 如果某个字符串满足以下条件，则称其为 美丽字符串 ：
 * <p>
 * vowels == consonants，即元音字母和辅音字母的数量相等。
 * (vowels * consonants) % k == 0，即元音字母和辅音字母的数量的乘积能被 k 整除。
 * 返回字符串 s 中 非空美丽子字符串 的数量。
 * <p>
 * 子字符串是字符串中的一个连续字符序列。
 * <p>
 * 英语中的 元音字母 为 'a'、'e'、'i'、'o' 和 'u' 。
 * <p>
 * 英语中的 辅音字母 为除了元音字母之外的所有字母。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "baeyh", k = 2
 * 输出：2
 * 解释：字符串 s 中有 2 个美丽子字符串。
 * - 子字符串 "baeyh"，vowels = 2（["a","e"]），consonants = 2（["y","h"]）。
 * 可以看出字符串 "aeyh" 是美丽字符串，因为 vowels == consonants 且 vowels * consonants % k == 0 。
 * - 子字符串 "baeyh"，vowels = 2（["a","e"]），consonants = 2（["b","y"]）。
 * 可以看出字符串 "baey" 是美丽字符串，因为 vowels == consonants 且 vowels * consonants % k == 0 。
 * 可以证明字符串 s 中只有 2 个美丽子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abba", k = 1
 * 输出：3
 * 解释：字符串 s 中有 3 个美丽子字符串。
 * - 子字符串 "abba"，vowels = 1（["a"]），consonants = 1（["b"]）。
 * - 子字符串 "abba"，vowels = 1（["a"]），consonants = 1（["b"]）。
 * - 子字符串 "abba"，vowels = 2（["a","a"]），consonants = 2（["b","b"]）。
 * 可以证明字符串 s 中只有 3 个美丽子字符串。
 * 示例 3：
 * <p>
 * 输入：s = "bcdf", k = 1
 * 输出：0
 * 解释：字符串 s 中没有美丽子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * 1 <= k <= 1000
 * s 仅由小写英文字母组成。
 */
public class Code5 {

    public int beautifulSubstrings(String s, int k) {
        //结果
        int result = 0;
        //元音数组
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //循环
        for (int i = 0; i < s.length(); i++) {
            //元音、辅音数量
            int a = 0;
            int b = 0;
            //循环
            for (int j = i; j < s.length(); j++) {
                //如果是元音
                if (arr[s.charAt(j) - 'a'] == 1) {
                    //+1
                    a++;
                } else {
                    //+1
                    b++;
                }
                //如果是
                if (a == b && a * b % k == 0) {
                    //+1
                    result++;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().beautifulSubstrings("baeyh", 2));
    }

}
