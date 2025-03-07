package easy16;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-12-11
 * 720. 词典中最长的单词
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 * <p>
 * 若无答案，则返回空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * words = ["w","wo","wor","worl", "world"]
 * 输出："world"
 * 解释：
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 * 示例 2：
 * <p>
 * 输入：
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出："apple"
 * 解释：
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"的字典序小于"apply"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有输入的字符串都只包含小写字母。
 * words数组长度范围为[1,1000]。
 * words[i]的长度范围为[1,30]。
 */
public class Code9 {

    //缓存
    Map<Integer, List<String>> map = new HashMap<>();
    //最长
    int max = 0;
    //结果
    List<String> result = new ArrayList<>();

    public void next(String left) {
        //长度
        int size = left.length() + 1;
        //如果存在下一级
        if (map.containsKey(size)) {
            //下一级列表
            List<String> list = map.get(size);
            //循环
            for (String right : list) {
                //如果以这个开头
                if (right.startsWith(left)) {
                    //下一级
                    next(right);
                }
            }
        }
        //如果更新最大长度了
        if (size > max) {
            //刷新
            result.clear();
            result.add(left);
            max = size;
            return;
        }
        //如果同级
        if (size == max) {
            result.add(left);
            return;
        }
        //如果小
        return;
    }

    public String longestWord(String[] words) {
        //循环
        for (String word : words) {
            //获取列表
            List<String> list = map.getOrDefault(word.length(), new ArrayList<>());
            //组装
            list.add(word);
            //组装回缓存
            map.put(word.length(), list);
        }
        //如果不存在
        if (map.containsKey(1) == false) {
            //默认
            return "";
        }
        //循环
        for (String first : map.get(1)) {
            //开始计算
            next(first);
        }
        //排序
        Collections.sort(result);
        //默认
        return result.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));
    }

}
