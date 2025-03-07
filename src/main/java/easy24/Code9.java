package easy24;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-10-29
 * 290. 单词规律
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * <p>
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: pattern = "abba", s = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入:pattern = "abba", s = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 * <p>
 * 输入: pattern = "aaaa", s = "dog cat cat dog"
 * 输出: false
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= pattern.length <= 300
 * pattern 只包含小写英文字母
 * 1 <= s.length <= 3000
 * s 只包含小写英文字母和 ' '
 * s 不包含 任何前导或尾随对空格
 * s 中每个单词都被 单个空格 分隔
 */
public class Code9 {

    public boolean wordPattern(String pattern, String s) {
        //分割
        String[] wordsArr = s.split(" ");
        //如果长度不同
        if (wordsArr.length != pattern.length()) {
            //不是
            return false;
        }
        //缓存1,2
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();
        //循环
        for (int i = 0; i < pattern.length(); i++) {
            //当前字符
            char left = pattern.charAt(i);
            //当前单词
            String word = wordsArr[i];
            //如果都不存在
            if (map.containsKey(left) == false && map2.containsKey(word) == false) {
                //直接记录
                map.put(left, word);
                map2.put(word, left);
                //本轮过
                continue;
            }
            //如果左边有、右边没有
            if (map.containsKey(left) && map2.containsKey(word) == false) {
                //不是
                return false;
            }
            //如果右边有、左边没有
            if (map2.containsKey(word) && map.containsKey(left) == false) {
                //不是
                return false;
            }
            //获取该字符对应单词
            String firstWord = map.get(left);
            //如果不同
            if (firstWord.equals(word) == false) {
                //不是
                return false;
            }
        }
        //默认
        return true;
    }

    public static void main(String[] args) {

    }

}
