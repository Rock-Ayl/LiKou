package easy28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-02-16
 * 748. 最短补全词
 * 给你一个字符串 licensePlate 和一个字符串数组 words ，请你找出 words 中的 最短补全词 。
 * <p>
 * 补全词 是一个包含 licensePlate 中所有字母的单词。忽略 licensePlate 中的 数字和空格 。不区分大小写。如果某个字母在 licensePlate 中出现不止一次，那么该字母在补全词中的出现次数应当一致或者更多。
 * <p>
 * 例如：licensePlate = "aBc 12c"，那么它的补全词应当包含字母 'a'、'b' （忽略大写）和两个 'c' 。可能的 补全词 有 "abccdef"、"caaacab" 以及 "cbca" 。
 * <p>
 * 请返回 words 中的 最短补全词 。题目数据保证一定存在一个最短补全词。当有多个单词都符合最短补全词的匹配条件时取 words 中 第一个 出现的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：licensePlate = "1s3 PSt", words = ["step", "steps", "stripe", "stepple"]
 * 输出："steps"
 * 解释：最短补全词应该包括 "s"、"p"、"s"（忽略大小写） 以及 "t"。
 * "step" 包含 "t"、"p"，但只包含一个 "s"，所以它不符合条件。
 * "steps" 包含 "t"、"p" 和两个 "s"。
 * "stripe" 缺一个 "s"。
 * "stepple" 缺一个 "s"。
 * 因此，"steps" 是唯一一个包含所有字母的单词，也是本例的答案。
 * 示例 2：
 * <p>
 * 输入：licensePlate = "1s3 456", words = ["looks", "pest", "stew", "show"]
 * 输出："pest"
 * 解释：licensePlate 只包含字母 "s" 。所有的单词都包含字母 "s" ，其中 "pest"、"stew"、和 "show" 三者最短。答案是 "pest" ，因为它是三个单词中在 words 里最靠前的那个。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= licensePlate.length <= 7
 * licensePlate 由数字、大小写字母或空格 ' ' 组成
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 15
 * words[i] 由小写英文字母组成
 */
public class Code6 {

    public String shortestCompletingWord(String licensePlate, String[] words) {
        //排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                ////按照长度排序
                return o1.length() - o2.length();
            }
        });
        //缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            //如果是小写字母
            if (c > 96 && c < 123) {
                //记录
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        //当前map
        Map<Character, Integer> thisMap = new HashMap<>();
        //循环
        for (String word : words) {
            //循环
            for (char c : word.toLowerCase().toCharArray()) {
                //如果是目标值之一
                if (map.containsKey(c)) {
                    //记录本次
                    thisMap.put(c, thisMap.getOrDefault(c, 0) + 1);
                    //如果可能满足条件了 and 是目标
                    if (thisMap.size() == map.size() && check(map, thisMap)) {
                        //返回结果
                        return word;
                    }
                }
            }
            //删除本次所有缓存
            thisMap.clear();
        }
        //默认
        return "";
    }

    //检查
    public boolean check(Map<Character, Integer> map, Map<Character, Integer> thisMap) {
        //循环
        for (Character key : map.keySet()) {
            //如果还不够
            if (map.get(key) > thisMap.get(key)) {
                //不是
                return false;
            }
        }
        //是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().shortestCompletingWord("1s3 PSt", new String[]{"step", "steps", "stripe", "stepple"}));
        ;
    }

}
