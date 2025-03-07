package easy4;

import jdk.nashorn.internal.runtime.linker.LinkerCallSite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-11-30
 * 884. 两句话中的不常见单词
 * 给定两个句子 A 和 B 。 （句子是一串由空格分隔的单词。每个单词仅由小写字母组成。）
 * <p>
 * 如果一个单词在其中一个句子中只出现一次，在另一个句子中却没有出现，那么这个单词就是不常见的。
 * <p>
 * 返回所有不常用单词的列表。
 * <p>
 * 您可以按任何顺序返回列表。
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = "this apple is sweet", B = "this apple is sour"
 * 输出：["sweet","sour"]
 * 示例 2：
 * <p>
 * 输入：A = "apple apple", B = "banana"
 * 输出：["banana"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A.length <= 200
 * 0 <= B.length <= 200
 * A 和 B 都只包含空格和小写字母。
 */
public class Code1 {

    public static String[] uncommonFromSentences(String A, String B) {
        //循环
        Map<String, Integer> map = new HashMap<>();
        //循环
        for (String wordA : A.split(" ")) {
            //如果有
            if (map.containsKey(wordA)) {
                //+1
                map.put(wordA, map.get(wordA) + 1);
            } else {
                //记录
                map.put(wordA, 1);
            }
        }
        //循环
        for (String wordB : B.split(" ")) {
            //如果有
            if (map.containsKey(wordB)) {
                //+1
                map.put(wordB, map.get(wordB) + 1);
            } else {
                //记录
                map.put(wordB, 1);
            }
        }
        //所有结果
        List<String> result = new ArrayList<>();
        //循环
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entrySet()) {
            //如果只存在一次
            if (stringIntegerEntry.getValue() == 1) {
                //记录
                result.add(stringIntegerEntry.getKey());
            }
        }
        //返回
        return result.toArray(new String[]{});
    }

    public static void main(String[] args) {
        for (String s : uncommonFromSentences("this apple is sweet", "this apple is sour")) {
            System.out.println(s);
        }
    }
}
