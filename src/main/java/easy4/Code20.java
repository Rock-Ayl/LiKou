package easy4;

import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2020-12-25
 * 383. 赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
 * <p>
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
 * <p>
 * 注意：
 * <p>
 * 你可以假设两个字符串均只含有小写字母。
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * 通过次数34,729提交次数62,368
 */
public class Code20 {

    public static boolean canConstruct(String ransomNote, String magazine) {
        //杂志缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char c : magazine.toCharArray()) {
            //如果存在了
            if (map.containsKey(c)) {
                //叠加
                map.put(c, map.get(c) + 1);
            } else {
                //初始化
                map.put(c, 1);
            }
        }
        //循环
        for (char c : ransomNote.toCharArray()) {
            //如果存在了
            if (map.containsKey(c)) {
                //获取次数
                int size = map.get(c);
                //如果没有了
                if (size == 0) {
                    //不可以
                    return false;
                }
                //叠加
                map.put(c, map.get(c) - 1);
            } else {
                //不可以
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa", "aba"));
    }
}
