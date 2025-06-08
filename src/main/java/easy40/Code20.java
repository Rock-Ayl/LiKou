package easy40;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-06-08
 * 3545. 不同字符数量最多为 K 时的最少删除数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s（由小写英文字母组成）和一个整数 k。
 * <p>
 * 你的任务是删除字符串中的一些字符（可以不删除任何字符），使得结果字符串中的 不同字符数量 最多为 k。
 * <p>
 * 返回为达到上述目标所需删除的 最小 字符数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "abc", k = 2
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * s 有三个不同的字符：'a'、'b' 和 'c'，每个字符的出现频率为 1。
 * 由于最多只能有 k = 2 个不同字符，需要删除某一个字符的所有出现。
 * 例如，删除所有 'c' 后，结果字符串中的不同字符数最多为 k。因此，答案是 1。
 * 示例 2：
 * <p>
 * 输入： s = "aabb", k = 2
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * s 有两个不同的字符（'a' 和 'b'），它们的出现频率分别为 2 和 2。
 * 由于最多可以有 k = 2 个不同字符，不需要删除任何字符。因此，答案是 0。
 * 示例 3：
 * <p>
 * 输入： s = "yyyzz", k = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * s 有两个不同的字符（'y' 和 'z'），它们的出现频率分别为 3 和 2。
 * 由于最多只能有 k = 1 个不同字符，需要删除某一个字符的所有出现。
 * 删除所有 'z' 后，结果字符串中的不同字符数最多为 k。因此，答案是 2。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 16
 * 1 <= k <= 16
 * s 仅由小写英文字母组成。
 */
public class Code20 {

    public int minDeletion(String s, int k) {
        //如果允许
        if (k >= 26) {
            //过
            return 0;
        }
        //缓存
        int[] arr = new int[26];
        //循环
        for (char letter : s.toCharArray()) {
            //+1
            arr[letter - 'a']++;
        }
        //排序
        Arrays.sort(arr);
        //求和
        int sum = 0;
        //循环
        for (int i = arr.length - k - 1; i >= 0; i--) {
            //数量
            int count = arr[i];
            //如果没了
            if (count == 0) {
                //跳出
                break;
            }
            //叠加
            sum += count;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().minDeletion("yyyzz", 1));
    }

}
