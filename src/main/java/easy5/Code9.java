package easy5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-01-08
 * 1078. Bigram 分词
 * 给出第一个词 first 和第二个词 second，考虑在某些文本 text 中可能以 "first second third" 形式出现的情况，其中 second 紧随 first 出现，third 紧随 second 出现。
 * <p>
 * 对于每种这样的情况，将第三个词 "third" 添加到答案中，并返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "alice is a good girl she is a good student", first = "a", second = "good"
 * 输出：["girl","student"]
 * 示例 2：
 * <p>
 * 输入：text = "we will we will rock you", first = "we", second = "will"
 * 输出：["we","rock"]
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 1000
 * text 由一些用空格分隔的单词组成，每个单词都由小写英文字母组成
 * 1 <= first.length, second.length <= 10
 * first 和 second 由小写英文字母组成
 */
public class Code9 {

    public static String[] findOcurrences(String text, String first, String second) {
        //初始化返回值
        List<String> result = new ArrayList<>();
        //循环
        String[] words = text.split(" ");
        //循环
        for (int i = 0; i < words.length - 2; i++) {
            //如果是第一个词和下一个词都对上了
            if (first.equals(words[i]) && second.equals(words[i + 1])) {
                //记录结果
                result.add(words[i + 2]);
            }
        }
        //返回
        return result.stream().toArray(String[]::new);
    }

    public static void main(String[] args) {
        for (String word : findOcurrences("alice is a good girl she is a good student", "a", "good")) {
            System.out.println(word);
        }
    }
}
