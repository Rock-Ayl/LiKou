package normal31;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-05-04
 * 567. 字符串的排列
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "ab" s2 = "eidbaooo"
 * 输出：true
 * 解释：s2 包含 s1 的排列之一 ("ba").
 * 示例 2：
 * <p>
 * 输入：s1= "ab" s2 = "eidboaoo"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length, s2.length <= 104
 * s1 和 s2 仅包含小写字母
 */
public class Code9 {

    //统计数量,计算map的key数量,如果打平删除之
    private void countMap(Map<Character, Integer> map, Character key, int num) {
        //计算新key的数量
        int count = map.getOrDefault(key, 0) + num;
        //如果正好没有
        if (count == 0) {
            //删除之
            map.remove(key);
        } else {
            //覆盖回去
            map.put(key, count);
        }
    }

    public boolean checkInclusion(String s1, String s2) {
        //缓存
        Map<Character, Integer> map = new HashMap<>();
        //循环
        for (char letter : s1.toCharArray()) {
            //初始化
            map.put(letter, map.getOrDefault(letter, 0) - 1);
        }
        //初始化双端队列
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        //循环
        for (char letter : s2.toCharArray()) {
            //直接加入
            arrayDeque.addLast(letter);
            //统计数量
            countMap(map, letter, 1);
            //如果多一个
            if (arrayDeque.size() > s1.length()) {
                //获取最后一个,并弹出,统计数量
                countMap(map, arrayDeque.pollFirst(), -1);
            }
            //如果此时没有,视为完全一致
            if (map.isEmpty()) {
                //返回结果
                return true;
            }
        }
        //默认不行
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().checkInclusion("ab", "eidbaooo"));
    }

}
