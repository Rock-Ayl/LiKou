package easy5;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created By Rock-Ayl on 2021-01-15
 * 242. 有效的字母异位词
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class Code15 {

    public static boolean isAnagram(String s, String t) {
        //如果长度不同
        if (s.length() != t.length()) {
            //当前不可以
            return false;
        }
        //缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char c : s.toCharArray()) {
            //如果存在
            if (map.containsKey(c)) {
                //+1
                map.put(c, map.get(c) + 1);
            } else {
                //初始化1
                map.put(c, 1);
            }
        }
        for (char c : t.toCharArray()) {
            //如果不存在
            if (!map.containsKey(c)) {
                //不可以
                return false;
            }
            //获取个数
            int num = map.get(c);
            //如果已经见底
            if (num == 0) {
                //不可以
                return false;
            }
            //+1
            map.put(c, map.get(c) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
    }
}
