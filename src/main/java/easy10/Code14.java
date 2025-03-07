package easy10;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-07-23
 * 1935. 可以输入的最大单词数
 * 键盘出现了一些故障，有些字母键无法正常工作。而键盘上所有其他键都能够正常工作。
 * <p>
 * 给你一个由若干单词组成的字符串 text ，单词间由单个空格组成（不含前导和尾随空格）；另有一个字符串 brokenLetters ，由所有已损坏的不同字母键组成，返回你可以使用此键盘完全输入的 text 中单词的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "hello world", brokenLetters = "ad"
 * 输出：1
 * 解释：无法输入 "world" ，因为字母键 'd' 已损坏。
 * 示例 2：
 * <p>
 * 输入：text = "leet code", brokenLetters = "lt"
 * 输出：1
 * 解释：无法输入 "leet" ，因为字母键 'l' 和 't' 已损坏。
 * 示例 3：
 * <p>
 * 输入：text = "leet code", brokenLetters = "e"
 * 输出：0
 * 解释：无法输入任何单词，因为字母键 'e' 已损坏。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 104
 * 0 <= brokenLetters.length <= 26
 * text 由若干用单个空格分隔的单词组成，且不含任何前导和尾随空格
 * 每个单词仅由小写英文字母组成
 * brokenLetters 由 互不相同 的小写英文字母组成
 */
public class Code14 {

    public int canBeTypedWords(String text, String brokenLetters) {
        Set<Character> set = new HashSet<>();
        for (char c : brokenLetters.toCharArray()) {
            set.add(c);
        }
        String[] arr = text.split(" ");
        int size = 0;
        io:
        for (String s : arr) {
            for (char c : s.toCharArray()) {
                if (set.contains(c)) {
                    continue io;
                }
            }
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().canBeTypedWords("leet code", "lt"));
    }
}
