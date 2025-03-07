package easy35;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-11-26
 * 100121. 查找包含给定字符的单词
 * 提示
 * 简单
 * 0
 * 相关企业
 * 给你一个下标从 0 开始的字符串数组 words 和一个字符 x 。
 * <p>
 * 请你返回一个 下标数组 ，表示下标在数组中对应的单词包含字符 x 。
 * <p>
 * 注意 ，返回的数组可以是 任意 顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["leet","code"], x = "e"
 * 输出：[0,1]
 * 解释："e" 在两个单词中都出现了："leet" 和 "code" 。所以我们返回下标 0 和 1 。
 * 示例 2：
 * <p>
 * 输入：words = ["abc","bcd","aaaa","cbc"], x = "a"
 * 输出：[0,2]
 * 解释："a" 在 "abc" 和 "aaaa" 中出现了，所以我们返回下标 0 和 2 。
 * 示例 3：
 * <p>
 * 输入：words = ["abc","bcd","aaaa","cbc"], x = "z"
 * 输出：[]
 * 解释："z" 没有在任何单词中出现。所以我们返回空数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= words[i].length <= 50
 * x 是一个小写英文字母。
 * words[i] 只包含小写英文字母。
 */
public class Code6 {

    public List<Integer> findWordsContaining(String[] words, char x) {
        //初始化结果
        List<Integer> result = new ArrayList<>();
        //跳出
        out:
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前
            String word = words[i];
            //循环2
            for (int j = 0; j < word.length(); j++) {
                //如果是
                if (word.charAt(j) == x) {
                    //记录结果
                    result.add(i);
                    //跳出本次
                    continue out;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code6().findWordsContaining(new String[]{"leet", "code"}, 'e');
    }

}
