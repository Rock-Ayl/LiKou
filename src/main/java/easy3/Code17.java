package easy3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-11-08
 * 389. 找不同
 * 给定两个字符串 s 和 t，它们只包含小写字母。
 * <p>
 * 字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。
 * <p>
 * 请找出在 t 中被添加的字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", t = "abcde"
 * 输出："e"
 * 解释：'e' 是那个被添加的字母。
 * 示例 2：
 * <p>
 * 输入：s = "", t = "y"
 * 输出："y"
 * 示例 3：
 * <p>
 * 输入：s = "a", t = "aa"
 * 输出："a"
 * 示例 4：
 * <p>
 * 输入：s = "ae", t = "aea"
 * 输出："a"
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 1000
 * t.length == s.length + 1
 * s 和 t 只包含小写字母
 */
public class Code17 {

    public static char findTheDifference(String s, String t) {
        //缓存
        HashMap<Character, Integer> map = new HashMap<>();
        //循环
        for (char c : s.toCharArray()) {
            //如果存在
            if (map.containsKey(c)) {
                //记录
                map.put(c, map.get(c) + 1);
            } else {
                //记录
                map.put(c, 1);
            }
        }
        //循环
        for (char c : t.toCharArray()) {
            //如果不存在
            if (!map.containsKey(c)) {
                //找到了
                return c;
            } else {
                //获取次数
                int x = map.get(c);
                //如果只有一个了
                if (x == 1) {
                    //删除
                    map.remove(c);
                } else {
                    //减一
                    map.put(c, (x - 1));
                }
            }
        }
        //缺省
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
