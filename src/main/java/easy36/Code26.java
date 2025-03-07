package easy36;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-05-11
 * 3136. 有效单词
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 有效单词 需要满足以下几个条件：
 * <p>
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 * <p>
 * 注意：
 * <p>
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "234Adas"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 这个单词满足所有条件。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "b3"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 这个单词的长度少于 3 且没有包含元音字母。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "a3$e"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 这个单词包含了 '$' 字符且没有包含辅音字母。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 20
 * word 由英文大写和小写字母、数字、'@'、'#' 和 '$' 组成。
 */
public class Code26 {

    public boolean isValid(String word) {
        //如果不够数字
        if (word.length() < 3) {
            //过
            return false;
        }
        //元音集合
        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        //元音、辅音数量
        int count1 = 0;
        int count2 = 0;
        //循环
        for (char letter : word.toCharArray()) {
            //判断是数字、大小写字母
            if (letter > 47 && letter < 58) {
                //数字直接过
                continue;
            } else if ((letter > 64 && letter < 91) || (letter > 96 && letter < 123)) {
                //如果是元音
                if (set.contains(letter)) {
                    //+1
                    count1++;
                } else {
                    //+1
                    count2++;
                }
            } else {
                //结束
                return false;
            }
        }
        //默认
        return count1 > 0 && count2 > 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code26().isValid("y0Ap"));
    }
}
