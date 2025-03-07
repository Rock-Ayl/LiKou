package easy3;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-11-12
 * 387. 字符串中的第一个唯一字符
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * <p>
 * 示例：
 * <p>
 * s = "leetcode"
 * 返回 0
 * <p>
 * s = "loveleetcode"
 * 返回 2
 * <p>
 * 提示：你可以假定该字符串只包含小写字母。
 */
public class Code20 {

    public static int firstUniqChar(String s) {
        //初始化缓存1 [字符,第一次出现的位置]
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        //初始化缓存2 [是否为已经重复的]
        Set<Character> set = new HashSet<>();
        //循环
        char[] chars = s.toCharArray();
        //循环
        for (int i = 0; i < chars.length; i++) {
            //当前值
            char a = chars[i];
            //如果不是重复的
            if (!set.contains(a)) {
                //如果重复了
                if (map.containsKey(a)) {
                    //删除
                    map.remove(a);
                    //记录重复
                    set.add(a);
                } else {
                    //记录
                    map.put(a, i);
                }
            }
        }
        //如果存在未重复的
        if (map.size() > 0) {
            //返回第一个元素的位置
            return map.entrySet().iterator().next().getValue();
        }
        //缺省
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }
}
