package easy44;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 4106. 找出两个字符串的不匹配片段
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 给你两个长度相同的字符串 s1 和 s2。
 * <p>
 * 不匹配片段 是一个 极大连续 下标区间，其中每个下标处 s1 和 s2 的字符都不相同。
 * <p>
 * 返回一个二维数组，其中包含每个不匹配片段对应的 [sub1, sub2]，sub1 和 sub2 分别是 s1 和 s2 中对应的 子字符串。请按片段起始下标的 递增 顺序返回。如果没有不匹配片段，则返回一个空数组。
 * <p>
 * 子字符串 是字符串中一个连续的 非空 字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s1 = "earth", s2 = "empty"
 * <p>
 * 输出： [["ar","mp"],["h","y"]]
 * <p>
 * 解释：
 * <p>
 * 下标 1 和 2 处的字符不同，形成不匹配片段 ["ar","mp"]。
 * 下标 4 处的字符不同，形成不匹配片段 ["h","y"]。
 * 示例 2：
 * <p>
 * 输入： s1 = "action", s2 = "nation"
 * <p>
 * 输出： [["ac","na"]]
 * <p>
 * 解释：
 * <p>
 * 下标 0 和 1 处的字符不同，形成不匹配片段 ["ac","na"]。两个字符串中其余位置的字符均相同。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s1 = "hot", s2 = "hot"
 * <p>
 * 输出： []
 * <p>
 * 解释：
 * <p>
 * 两个字符串完全相同，因此没有不匹配片段。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s1.length == s2.length <= 100
 * s1 和 s2 仅由小写英文字母组成。
 */
public class Code20 {

    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        //结果
        List<List<String>> result = new ArrayList<>();
        //索引
        int index = 0;
        //循环
        while (index < s1.length()) {
            //如果字符相同
            if (s1.charAt(index) == s2.charAt(index)) {
                //+1
                index++;
                //本轮过
                continue;
            }
            //两个字符串
            StringBuilder oneStr = new StringBuilder();
            StringBuilder twoStr = new StringBuilder();
            //循环
            while (index < s1.length() && s1.charAt(index) != s2.charAt(index)) {
                //组装
                oneStr.append(s1.charAt(index));
                twoStr.append(s2.charAt(index));
                //+1
                index++;
            }
            //添加
            result.add(Arrays.asList(oneStr.toString(), twoStr.toString()));
            //+1
            index++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {

    }

}
