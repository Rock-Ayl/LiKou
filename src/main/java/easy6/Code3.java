package easy6;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-01-30
 * 1624. 两个相同字符之间的最长子字符串
 * 给你一个字符串 s，请你返回 两个相同字符之间的最长子字符串的长度 ，计算长度时不含这两个字符。如果不存在这样的子字符串，返回 -1 。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aa"
 * 输出：0
 * 解释：最优的子字符串是两个 'a' 之间的空子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "abca"
 * 输出：2
 * 解释：最优的子字符串是 "bc" 。
 * 示例 3：
 * <p>
 * 输入：s = "cbzxy"
 * 输出：-1
 * 解释：s 中不存在出现出现两次的字符，所以返回 -1 。
 * 示例 4：
 * <p>
 * 输入：s = "cabbac"
 * 输出：4
 * 解释：最优的子字符串是 "abba" ，其他的非最优解包括 "bb" 和 "" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 300
 * s 只含小写英文字母
 */
public class Code3 {

    public static int maxLengthBetweenEqualCharacters(String s) {
        //转化为字符组
        char[] words = s.toCharArray();
        //左缓存
        Map<Character, List<Integer>> map = new HashMap();
        //返回值初始化
        int result = -1;
        //循环
        for (int i = 0; i < words.length; i++) {
            //当前字符
            char thisWord = words[i];
            //数组
            List<Integer> list;
            //如果存在
            if (map.containsKey(thisWord)) {
                //获取
                list = map.get(thisWord);
            } else {
                //初始化
                list = new ArrayList<>();
            }
            //记录
            list.add(i);
            //组装
            map.put(thisWord, list);
        }
        //循环
        for (Map.Entry<Character, List<Integer>> characterListEntry : map.entrySet()) {
            //获取列表
            List<Integer> list = characterListEntry.getValue();
            //如果符合左右条件
            if (characterListEntry.getValue().size() >= 2) {
                //获取最大最小值
                int max = list.get(list.size() - 1), min = list.get(0);
                //选取最大的结果
                result = Math.max(result, (max - min - 1));
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(maxLengthBetweenEqualCharacters("cabbac"));
    }
}
