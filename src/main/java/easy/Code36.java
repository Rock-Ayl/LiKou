package easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-09-15
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串， 比如: "a" 对应 ".-", "b" 对应 "-...", "c" 对应 "-.-.", 等等。
 * <p>
 * 为了方便，所有26个英文字母对应摩尔斯密码表如下：
 * <p>
 * [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
 * 给定一个单词列表，每个单词可以写成每个字母对应摩尔斯密码的组合。例如，"cab" 可以写成 "-.-..--..."，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作单词翻译。
 * <p>
 * 返回我们可以获得所有词不同单词翻译的数量。
 * <p>
 * 例如:
 * 输入: words = ["gin", "zen", "gig", "msg"]
 * 输出: 2
 * 解释:
 * 各单词翻译如下:
 * "gin" -> "--...-."
 * "zen" -> "--...-."
 * "gig" -> "--...--."
 * "msg" -> "--...--."
 * <p>
 * 共有 2 种不同翻译, "--...-." 和 "--...--.".
 * <p>
 * 注意:
 * <p>
 * 单词列表words 的长度不会超过 100。
 * 每个单词 words[i]的长度范围为 [1, 12]。
 * 每个单词 words[i]只包含小写字母。
 */
public class Code36 {

    public static int uniqueMorseRepresentations(String[] words) {
        //缓存
        Set<String> set = new HashSet<>();
        //摩斯密码对应解码
        String[] ms = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
        //基于ascii码去计算位置
        int num = 97;
        //循环
        for (String word : words) {
            //初始化当前解码
            StringBuffer thisWordParse = new StringBuffer();
            //拆分
            char[] charArr = word.toCharArray();
            //循环
            for (char c : charArr) {
                //基于ascii码去计算位置
                int p = ((byte) c) - num;
                //获取摩斯密码
                String value = ms[p];
                //获取并组装
                thisWordParse.append(value);
            }
            //记录
            set.add(thisWordParse.toString());
        }
        //返回数量
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(uniqueMorseRepresentations(new String[]{"wo", "ai", "ni"}));
    }
}
