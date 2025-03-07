package easy32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-08-12
 * 2788. 按分隔符拆分字符串
 * 提示
 * 简单
 * 5
 * 相关企业
 * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
 * <p>
 * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
 * <p>
 * 注意
 * <p>
 * separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
 * 拆分可能形成两个以上的字符串。
 * 结果字符串必须保持初始相同的先后顺序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["one.two.three","four.five","six"], separator = "."
 * 输出：["one","two","three","four","five","six"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "one.two.three" 拆分为 "one", "two", "three"
 * "four.five" 拆分为 "four", "five"
 * "six" 拆分为 "six"
 * <p>
 * 因此，结果数组为 ["one","two","three","four","five","six"] 。
 * 示例 2：
 * <p>
 * 输入：words = ["$easy$","$problem$"], separator = "$"
 * 输出：["easy","problem"]
 * 解释：在本示例中，我们进行下述拆分：
 * <p>
 * "$easy$" 拆分为 "easy"（不包括空字符串）
 * "$problem$" 拆分为 "problem"（不包括空字符串）
 * <p>
 * 因此，结果数组为 ["easy","problem"] 。
 * 示例 3：
 * <p>
 * 输入：words = ["|||"], separator = "|"
 * 输出：[]
 * 解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
 * separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）
 */
public class Code23 {

    public List<String> splitWordsBySeparator(List<String> words, char separator) {
        //初始化
        List<String> list = new ArrayList<>();
        //循环
        for (String word : words) {
            //初始化
            StringBuilder str = new StringBuilder();
            //循环
            for (int i = 0; i < word.length(); i++) {
                //当前
                char space = word.charAt(i);
                //如果是分隔符
                if (space == separator) {
                    //如果有结果
                    if (str.length() > 0) {
                        //记录
                        list.add(str.toString());
                        //初始化
                        str = new StringBuilder();
                    }
                } else {
                    //组装
                    str.append(space);
                }
            }
            //如果最后还有
            if (str.length() > 0) {
                //记录
                list.add(str.toString());
            }
        }
        //返回结果
        return list;
    }

    public static void main(String[] args) {
        List<String> six = new Code23().splitWordsBySeparator(Arrays.asList("one.two.three", "four.five", "six"), '.');
        System.out.println();
    }
}
