package normal10;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-01-17
 * 1657. 确定两个字符串是否接近
 * 如果可以使用以下操作从一个字符串得到另一个字符串，则认为两个字符串 接近 ：
 * <p>
 * 操作 1：交换任意两个 现有 字符。
 * 例如，abcde -> aecdb
 * 操作 2：将一个 现有 字符的每次出现转换为另一个 现有 字符，并对另一个字符执行相同的操作。
 * 例如，aacabb -> bbcbaa（所有 a 转化为 b ，而所有的 b 转换为 a ）
 * 你可以根据需要对任意一个字符串多次使用这两种操作。
 * <p>
 * 给你两个字符串，word1 和 word2 。如果 word1 和 word2 接近 ，就返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word1 = "abc", word2 = "bca"
 * 输出：true
 * 解释：2 次操作从 word1 获得 word2 。
 * 执行操作 1："abc" -> "acb"
 * 执行操作 1："acb" -> "bca"
 * 示例 2：
 * <p>
 * 输入：word1 = "a", word2 = "aa"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * 示例 3：
 * <p>
 * 输入：word1 = "cabbba", word2 = "abbccc"
 * 输出：true
 * 解释：3 次操作从 word1 获得 word2 。
 * 执行操作 1："cabbba" -> "caabbb"
 * 执行操作 2："caabbb" -> "baaccc"
 * 执行操作 2："baaccc" -> "abbccc"
 * 示例 4：
 * <p>
 * 输入：word1 = "cabbba", word2 = "aabbss"
 * 输出：false
 * 解释：不管执行多少次操作，都无法从 word1 得到 word2 ，反之亦然。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word1.length, word2.length <= 105
 * word1 和 word2 仅包含小写英文字母
 */
public class Code5 {

    public boolean closeStrings(String word1, String word2) {
        //如果长度不一致
        if (word1.length() != word2.length()) {
            //不可能
            return false;
        }
        //缓存
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        //循环
        for (char c : word1.toCharArray()) {
            //记录缓存
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        //循环2
        for (char c : word2.toCharArray()) {
            //记录缓存
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        //如果二者长度不同
        if (map1.size() != map2.size()) {
            //不可能
            return false;
        }
        //如果他们的key不一致
        if (map1.keySet().equals(map2.keySet()) == false) {
            //不可能
            return false;
        }
        //转化为列表
        List<Integer> list1 = map1.entrySet().stream().map(p -> p.getValue()).collect(Collectors.toList());
        List<Integer> list2 = map2.entrySet().stream().map(p -> p.getValue()).collect(Collectors.toList());
        //排序
        Collections.sort(list1);
        Collections.sort(list2);
        //如果不同
        if (list1.equals(list2) == false) {
            //不可能
            return false;
        }
        //默认
        return true;
    }


}
