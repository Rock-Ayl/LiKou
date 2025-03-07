package normal28;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-02-06
 * LCR 033. 字母异位词分组
 * 中等
 * 相关标签
 * 相关企业
 * 给定一个字符串数组 strs ，将 变位词 组合在一起。 可以按任意顺序返回结果列表。
 * <p>
 * 注意：若两个字符串中每个字符出现的次数都相同，则称它们互为变位词。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
 * 示例 2:
 * <p>
 * 输入: strs = [""]
 * 输出: [[""]]
 * 示例 3:
 * <p>
 * 输入: strs = ["a"]
 * 输出: [["a"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 104
 * 0 <= strs[i].length <= 100
 * strs[i] 仅包含小写字母
 * <p>
 * <p>
 * 注意：本题与主站 49 题相同： https://leetcode-cn.com/problems/group-anagrams/
 */
public class Code20 {

    //为单词分组
    private String group(String word) {
        //获取字符
        char[] charArray = word.toCharArray();
        //排序
        Arrays.sort(charArray);
        //返回
        return new String(charArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //按照条件分组
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(this::group)).values());
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Code20().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println();
    }

}
