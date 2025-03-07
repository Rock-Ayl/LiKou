package normal25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-10-13
 * 编写一种方法，对字符串数组进行排序，将所有变位词组合在一起。变位词是指字母相同，但排列不同的字符串。
 * <p>
 * 注意：本题相对原题稍作修改
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * 说明：
 * <p>
 * 所有输入均为小写字母。
 * 不考虑答案输出的顺序。
 */
public class Code3 {

    //单词转化为wordKey
    private String wordKey(String word) {
        //获取内容
        char[] charArray = word.toCharArray();
        //排序
        Arrays.sort(charArray);
        //返回key
        return new String(charArray);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //实现
        return new ArrayList<>(Arrays
                //流
                .stream(strs)
                //按照同一变位词分组
                .collect(Collectors.groupingBy(this::wordKey))
                //转化为集合
                .values());
    }

    public static void main(String[] args) {
        List<List<String>> lists = new Code3().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        System.out.println();
    }

}
