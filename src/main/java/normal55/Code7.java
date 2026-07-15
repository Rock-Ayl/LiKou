package normal55;

import java.util.Arrays;

/**
 * 1930. 长度为 3 的不同回文子序列
 * 算术评级: 4
 * 第 249 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1533
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，返回 s 中 长度为 3 的不同回文子序列 的个数。
 * <p>
 * 即便存在多种方法来构建相同的子序列，但相同的子序列只计数一次。
 * <p>
 * 回文 是正着读和反着读一样的字符串。
 * <p>
 * 子序列 是由原字符串删除其中部分字符（也可以不删除）且不改变剩余字符之间相对顺序形成的一个新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的一个子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabca"
 * 输出：3
 * 解释：长度为 3 的 3 个回文子序列分别是：
 * - "aba" ("aabca" 的子序列)
 * - "aaa" ("aabca" 的子序列)
 * - "aca" ("aabca" 的子序列)
 * 示例 2：
 * <p>
 * 输入：s = "adc"
 * 输出：0
 * 解释："adc" 不存在长度为 3 的回文子序列。
 * 示例 3：
 * <p>
 * 输入：s = "bbcbaba"
 * 输出：4
 * 解释：长度为 3 的 4 个回文子序列分别是：
 * - "bbb" ("bbcbaba" 的子序列)
 * - "bcb" ("bbcbaba" 的子序列)
 * - "bab" ("bbcbaba" 的子序列)
 * - "aba" ("bbcbaba" 的子序列)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s 仅由小写英文字母组成
 */
public class Code7 {

    public int countPalindromicSubsequence(String s) {

        /**
         * 统计每个索引单词开始、结束
         */

        //每个字符开始、结束 数组
        int[] startIndexArr = new int[26];
        int[] endIndexArr = new int[26];
        //默认填充为-1
        Arrays.fill(startIndexArr, -1);
        Arrays.fill(endIndexArr, -1);
        //循环
        for (int i = 0; i < s.length(); i++) {
            //索引
            int index = s.charAt(i) - 'a';
            //如果没有开始
            if (startIndexArr[index] == -1) {
                //记录
                startIndexArr[index] = i;
            } else {
                //覆盖最远
                endIndexArr[index] = i;
            }
        }

        /**
         * 计算
         */

        //结果
        int result = 0;
        //循环
        for (int i = 0; i < startIndexArr.length; i++) {
            //获取开始、结束索引
            int startIndex = startIndexArr[i];
            int endIndex = endIndexArr[i];
            //如果没有结束
            if (endIndex == -1) {
                //本轮过
                continue;
            }
            //统计区间内不同字符数量
            result += count(s, startIndex + 1, endIndex - 1);
        }
        //返回
        return result;
    }

    //统计区间内不同字符数量
    private int count(String s, int startIndex, int endIndex) {
        //计数器数组
        int[] countArr = new int[26];
        //结果
        int count = 0;
        //循环
        for (int i = startIndex; i <= endIndex; i++) {
            //如果是第一次
            if (++countArr[s.charAt(i) - 'a'] == 1) {
                //+1
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().countPalindromicSubsequence("bbcbaba"));
    }

}
