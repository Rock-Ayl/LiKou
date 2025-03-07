package normal11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-01-30
 * 890. 查找和替换模式
 * 你有一个单词列表 words 和一个模式  pattern，你想知道 words 中的哪些单词与模式匹配。
 * <p>
 * 如果存在字母的排列 p ，使得将模式中的每个字母 x 替换为 p(x) 之后，我们就得到了所需的单词，那么单词与模式是匹配的。
 * <p>
 * （回想一下，字母的排列是从字母到字母的双射：每个字母映射到另一个字母，没有两个字母映射到同一个字母。）
 * <p>
 * 返回 words 中与给定模式匹配的单词列表。
 * <p>
 * 你可以按任何顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 * 输出：["mee","aqq"]
 * 解释：
 * "mee" 与模式匹配，因为存在排列 {a -> m, b -> e, ...}。
 * "ccc" 与模式不匹配，因为 {a -> c, b -> c, ...} 不是排列。
 * 因为 a 和 b 映射到同一个字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 50
 * 1 <= pattern.length = words[i].length <= 20
 * 通过次数9,368提交次数12,846
 */
public class Code2 {

    //转换
    public String convert(String word) {
        //转换缓存
        Map<Character, Character> map = new HashMap<>();
        //初始化
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < word.length(); i++) {
            //当前
            char letter = word.charAt(i);
            //如果存在
            if (map.containsKey(letter)) {
                //用已有的
                str.append(map.get(letter));
            } else {
                //初始化新的
                char init = (char) (map.size() + 'a');
                //组装
                str.append(init);
                //记录
                map.put(letter, init);
            }
        }
        //返回
        return str.toString();
    }

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        //结果
        List<String> result = new ArrayList<>();
        //转换为目标值
        String target = convert(pattern);
        //循环
        for (String word : words) {
            //如果长度不一致
            if (word.length() != pattern.length()) {
                //过
                continue;
            }
            //转换
            String value = convert(word);
            //如果一致
            if (value.equals(target)) {
                //记录
                result.add(word);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().findAndReplacePattern(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"));
    }


}
