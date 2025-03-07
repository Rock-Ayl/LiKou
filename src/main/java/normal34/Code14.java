package normal34;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-08-23
 * 3223. 操作后字符串的最短长度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 。
 * <p>
 * 你需要对 s 执行以下操作 任意 次：
 * <p>
 * 选择一个下标 i ，满足 s[i] 左边和右边都 至少 有一个字符与它相同。
 * 删除 s[i] 左边 离它 最近 且相同的字符。
 * 删除 s[i] 右边 离它 最近 且相同的字符。
 * 请你返回执行完所有操作后， s 的 最短 长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abaacbcbb"
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * 我们执行以下操作：
 * <p>
 * 选择下标 2 ，然后删除下标 0 和 3 处的字符，得到 s = "bacbcbb" 。
 * 选择下标 3 ，然后删除下标 0 和 5 处的字符，得到 s = "acbcb" 。
 * 示例 2：
 * <p>
 * 输入：s = "aa"
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * 无法对字符串进行任何操作，所以返回初始字符串的长度。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 105
 * s 只包含小写英文字母。
 */
public class Code14 {

    public int minimumLength(String s) {
        //数组
        int[] arr = new int[27];
        //循环
        for (char c : s.toCharArray()) {
            //叠加
            if (++arr[c - 'a'] == 3) {
                //删除
                arr[c - 'a'] = 1;
            }
        }
        //返回
        return Arrays.stream(arr).sum();
    }

    public static void main(String[] args) {

    }

}
