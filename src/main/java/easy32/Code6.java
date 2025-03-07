package easy32;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-06-25
 * 6892. 最大字符串配对数目
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * <p>
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * <p>
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * <p>
 * 注意，每个字符串最多匹配一次。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cd","ac","dc","ca","zz"]
 * 输出：2
 * 解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
 * - 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
 * - 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
 * 可以证明最多匹配数目是 2 。
 * 示例 2：
 * <p>
 * 输入：words = ["ab","ba","cc"]
 * 输出：1
 * 解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
 * - 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
 * 可以证明最多匹配数目是 1 。
 * 示例 3：
 * <p>
 * 输入：words = ["aa","ab"]
 * 输出：0
 * 解释：这个例子中，无法匹配任何字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 */
public class Code6 {

    public int maximumNumberOfStringPairs(String[] words) {
        //如果太小
        if (words.length < 2) {
            //过
            return 0;
        }
        //缓存
        Map<String, Integer> endMap = new HashMap<>();
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前str
            String word = words[i];
            //覆盖位置
            endMap.put(word, i);
        }
        //结果
        int count = 0;
        //循环2
        for (int i = 0; i < words.length; i++) {
            //当前str
            String word = words[i];
            //反转
            String reverseWord = new StringBuffer(word).reverse().toString();
            //获取反转后的str的最后的位置
            int index = endMap.getOrDefault(reverseWord, -1);
            //如果在它后面
            if (index > i) {
                //记录
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().maximumNumberOfStringPairs(new String[]{"cd", "ac", "dc", "ca", "zz"}));
    }

}
