package normal16;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-08-26
 * 面试题 16.02. 单词频率
 * 设计一个方法，找出任意指定单词在一本书中的出现频率。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * WordsFrequency(book)构造函数，参数为字符串数组构成的一本书
 * get(word)查询指定单词在书中出现的频率
 * 示例：
 * <p>
 * WordsFrequency wordsFrequency = new WordsFrequency({"i", "have", "an", "apple", "he", "have", "a", "pen"});
 * wordsFrequency.get("you"); //返回0，"you"没有出现过
 * wordsFrequency.get("have"); //返回2，"have"出现2次
 * wordsFrequency.get("an"); //返回1
 * wordsFrequency.get("apple"); //返回1
 * wordsFrequency.get("pen"); //返回1
 * 提示：
 * <p>
 * book[i]中只包含小写字母
 * 1 <= book.length <= 100000
 * 1 <= book[i].length <= 10
 * get函数的调用次数不会超过100000
 */
public class Code5 {

    //缓存
    Map<String, Integer> bookMap;

    public Code5(String[] book) {
        //分组
        bookMap = new HashMap<>();
        //循环
        for (String word : book) {
            //+1
            bookMap.put(word, bookMap.getOrDefault(word, 0) + 1);
        }
    }

    public int get(String word) {
        //返回
        return bookMap.getOrDefault(word, 0);
    }

}
