package easy24;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-10-19
 * 205. 同构字符串
 * 给定两个字符串 s 和 t ，判断它们是否是同构的。
 * <p>
 * 如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。
 * <p>
 * 每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：s = "egg", t = "add"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s = "foo", t = "bar"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s = "paper", t = "title"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 104
 * t.length == s.length
 * s 和 t 由任意有效的 ASCII 字符组成
 */
public class Code5 {

    public String change(String word) {
        //缓存
        Map<Character, Integer> map = new HashMap<>();
        //左边
        StringBuilder str = new StringBuilder();
        //循环
        for (char c : word.toCharArray()) {
            //如果存在了
            if (map.containsKey(c)) {
                //直接使用
                str.append(map.get(c)+ ",");
            } else {
                //长度
                int num = map.size();
                //组装
                str.append(num + ",");
                //记录
                map.put(c, num);
            }
        }
        //返回
        return str.toString();
    }

    public boolean isIsomorphic(String s, String t) {
        //判断长度
        if (s.length() != t.length()) {
            //不是
            return false;
        }
        String one = change(s);
        String two = change(t);
        //缺省
        return one.equals(two);
    }

    public static void main(String[] args) {
        System.out.println(new Code5().isIsomorphic("abcdefghijklmnopqrstuvwxyzva", "abcdefghijklmnopqrstuvwxyzck"));
    }

}
