package easy36;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-02-16
 * 2900. 最长相邻不相等子序列 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 和一个下标从 0 开始的字符串数组 words ，和一个下标从 0 开始的 二进制 数组 groups ，两个数组长度都是 n 。
 * <p>
 * 你需要从下标 [0, 1, ..., n - 1] 中选出一个 最长子序列 ，将这个子序列记作长度为 k 的 [i0, i1, ..., ik - 1] ，对于所有满足 0 < j + 1 < k 的 j 都有 groups[ij] != groups[ij + 1] 。
 * <p>
 * 请你返回一个字符串数组，它是下标子序列 依次 对应 words 数组中的字符串连接形成的字符串数组。如果有多个答案，返回任意一个。
 * <p>
 * 子序列 指的是从原数组中删掉一些（也可能一个也不删掉）元素，剩余元素不改变相对位置得到的新的数组。
 * <p>
 * 注意：words 中的字符串长度可能 不相等 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3, words = ["e","a","b"], groups = [0,0,1]
 * 输出：["e","b"]
 * 解释：一个可行的子序列是 [0,2] ，因为 groups[0] != groups[2] 。
 * 所以一个可行的答案是 [words[0],words[2]] = ["e","b"] 。
 * 另一个可行的子序列是 [1,2] ，因为 groups[1] != groups[2] 。
 * 得到答案为 [words[1],words[2]] = ["a","b"] 。
 * 这也是一个可行的答案。
 * 符合题意的最长子序列的长度为 2 。
 * 示例 2：
 * <p>
 * 输入：n = 4, words = ["a","b","c","d"], groups = [1,0,1,1]
 * 输出：["a","b","c"]
 * 解释：一个可行的子序列为 [0,1,2] 因为 groups[0] != groups[1] 且 groups[1] != groups[2] 。
 * 所以一个可行的答案是 [words[0],words[1],words[2]] = ["a","b","c"] 。
 * 另一个可行的子序列为 [0,1,3] 因为 groups[0] != groups[1] 且 groups[1] != groups[3] 。
 * 得到答案为 [words[0],words[1],words[3]] = ["a","b","d"] 。
 * 这也是一个可行的答案。
 * 符合题意的最长子序列的长度为 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == words.length == groups.length <= 100
 * 1 <= words[i].length <= 10
 * 0 <= groups[i] < 2
 * words 中的字符串 互不相同 。
 * words[i] 只包含小写英文字母。
 */
public class Code7 {

    public List<Integer> getLongestSubsequence(int[] groups) {
        //初始化结果
        List<Integer> list = new ArrayList<>();
        //默认
        list.add(0);
        //循环
        for (int i = 1; i < groups.length; i++) {
            //上一个
            int last = groups[list.get(list.size() - 1)];
            //如果不同
            if (groups[i] != last) {
                //记录
                list.add(i);
            }
        }
        //返回
        return list;
    }

    public static void main(String[] args) {
        new Code7().getLongestSubsequence(new int[]{1, 0, 1, 1});
    }

}
