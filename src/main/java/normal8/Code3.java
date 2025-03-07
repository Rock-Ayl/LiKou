package normal8;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-09-15
 * 791. 自定义字符串排序
 * 字符串S和 T 只包含小写字符。在S中，所有字符只会出现一次。
 * <p>
 * S 已经根据某种规则进行了排序。我们要根据S中的字符顺序对T进行排序。更具体地说，如果S中x在y之前出现，那么返回的字符串中x也应出现在y之前。
 * <p>
 * 返回任意一种符合条件的字符串T。
 * <p>
 * 示例:
 * 输入:
 * S = "cba"
 * T = "abcd"
 * 输出: "cbad"
 * 解释:
 * S中出现了字符 "a", "b", "c", 所以 "a", "b", "c" 的顺序应该是 "c", "b", "a".
 * 由于 "d" 没有在S中出现, 它可以放在T的任意位置. "dcba", "cdba", "cbda" 都是合法的输出。
 * 注意:
 * <p>
 * S的最大长度为26，其中没有重复的字符。
 * T的最大长度为200。
 * S和T只包含小写字符。
 */
public class Code3 {

    public String customSortString(String order, String s) {
        //缓存
        Map<Character, StringBuffer> map = new HashMap<>();
        //循环
        for (char c : s.toCharArray()) {
            //获取
            StringBuffer str = map.getOrDefault(c, new StringBuffer());
            //组装
            str.append(c);
            //返回
            map.put(c, str);
        }
        //结果
        StringBuffer result = new StringBuffer();
        //循环2
        for (char c : order.toCharArray()) {
            //获取,按顺序组装
            result.append(map.getOrDefault(c, new StringBuffer()));
            //删除
            map.remove(c);
        }
        //循环3
        for (Map.Entry<Character, StringBuffer> entry : map.entrySet()) {
            //组装
            result.append(entry.getValue());
        }
        //返回结果
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code3().customSortString("cba", "abcd"));
    }
}
