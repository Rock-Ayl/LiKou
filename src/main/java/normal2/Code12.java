package normal2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-04-13
 * 1451. 重新排列句子中的单词
 * 「句子」是一个用空格分隔单词的字符串。给你一个满足下述格式的句子 text :
 * <p>
 * 句子的首字母大写
 * text 中的每个单词都用单个空格分隔。
 * 请你重新排列 text 中的单词，使所有单词按其长度的升序排列。如果两个单词的长度相同，则保留其在原句子中的相对顺序。
 * <p>
 * 请同样按上述格式返回新的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "Leetcode is cool"
 * 输出："Is cool leetcode"
 * 解释：句子中共有 3 个单词，长度为 8 的 "Leetcode" ，长度为 2 的 "is" 以及长度为 4 的 "cool" 。
 * 输出需要按单词的长度升序排列，新句子中的第一个单词首字母需要大写。
 * 示例 2：
 * <p>
 * 输入：text = "Keep calm and code on"
 * 输出："On and keep calm code"
 * 解释：输出的排序情况如下：
 * "On" 2 个字母。
 * "and" 3 个字母。
 * "keep" 4 个字母，因为存在长度相同的其他单词，所以它们之间需要保留在原句子中的相对顺序。
 * "calm" 4 个字母。
 * "code" 4 个字母。
 * 示例 3：
 * <p>
 * 输入：text = "To be or not to be"
 * 输出："To be or to be not"
 * <p>
 * <p>
 * 提示：
 * <p>
 * text 以大写字母开头，然后包含若干小写字母以及单词间的单个空格。
 * 1 <= text.length <= 10^5
 */
public class Code12 {

    public String arrangeWords(String text) {
        //初始化缓存
        Map<Integer, List<String>> map = new HashMap<>();
        //切割
        String[] words = text.split(" ");
        //首位小写
        words[0] = words[0].toLowerCase();
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前单词
            String word = words[i];
            //长度
            int length = word.length();
            //列表
            List<String> list;
            //如果存在
            if (map.containsKey(length)) {
                //用已有
                list = map.get(length);
            } else {
                //初始化
                list = new ArrayList<>();
            }
            //组装
            list.add(word);
            //记录
            map.put(length, list);
        }
        //初始化结果
        StringBuffer result = new StringBuffer();
        //循环
        for (Map.Entry<Integer, List<String>> integerListEntry : map.entrySet()) {
            //循环
            for (String s : integerListEntry.getValue()) {
                //组装
                result.append(s + " ");
            }
        }
        //删除最后一个space
        result.deleteCharAt(result.length() - 1);
        //替换首位
        result.setCharAt(0, (result.charAt(0) + "").toUpperCase().charAt(0));
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code12().arrangeWords("Keep calm and code on"));
    }
}
