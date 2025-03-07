package easy7;

/**
 * Created By Rock-Ayl on 2021-03-13
 * 1768. 交替合并字符串
 * 给你两个字符串 word1 和 word2 。请你从 word1 开始，通过交替添加字母来合并字符串。如果一个字符串比另一个字符串长，就将多出来的字母追加到合并后字符串的末尾。
 * <p>
 * 返回 合并后的字符串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "pqr"
 * 输出："apbqcr"
 * 解释：字符串合并情况如下所示：
 * word1：  a   b   c
 * word2：    p   q   r
 * 合并后：  a p b q c r
 * 示例 2：
 * <p>
 * 输入：word1 = "ab", word2 = "pqrs"
 * 输出："apbqrs"
 * 解释：注意，word2 比 word1 长，"rs" 需要追加到合并后字符串的末尾。
 * word1：  a   b
 * word2：    p   q   r   s
 * 合并后：  a p b q   r   s
 * 示例 3：
 * <p>
 * 输入：word1 = "abcd", word2 = "pq"
 * 输出："apbqcd"
 * 解释：注意，word1 比 word2 长，"cd" 需要追加到合并后字符串的末尾。
 * word1：  a   b   c   d
 * word2：    p   q
 * 合并后：  a p b q c   d
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 100
 * word1 和 word2 由小写英文字母组成
 */
public class Code17 {

    public static String mergeAlternately(String word1, String word2) {
        //合并后
        StringBuffer result = new StringBuffer();
        //左右坐标
        int a = 0, b = 0;
        //循环
        while (a < word1.length() && b < word2.length()) {
            //如果a先手
            if (a <= b) {
                //组装,递增
                result.append(word1.charAt(a++));
            } else {
                //组装,递增
                result.append(word2.charAt(b++));
            }
        }
        //如果a越界了,b未越界
        if (a == word1.length() && b < word2.length()) {
            //切割最后部分组装
            result.append(word2.substring(b));
        }
        //如果b越界了,a未越界
        if (b == word2.length() && a < word1.length()) {
            //切割最后部分组装
            result.append(word1.substring(a));
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(mergeAlternately("abc", "pqrs"));
    }
}
