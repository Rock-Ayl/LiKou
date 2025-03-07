package easy38;

/**
 * @Author ayl
 * @Date 2024-09-06
 * 1332. 删除回文子序列
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s，它仅由字母 'a' 和 'b' 组成。每一次删除操作都可以从 s 中删除一个回文 子序列。
 * <p>
 * 返回删除给定字符串中所有字符（字符串为空）的最小删除次数。
 * <p>
 * 「子序列」定义：如果一个字符串可以通过删除原字符串某些字符而不改变原字符顺序得到，那么这个字符串就是原字符串的一个子序列。
 * <p>
 * 「回文」定义：如果一个字符串向后和向前读是一致的，那么这个字符串就是一个回文。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ababa"
 * 输出：1
 * 解释：字符串本身就是回文序列，只需要删除一次。
 * 示例 2：
 * <p>
 * 输入：s = "abb"
 * 输出：2
 * 解释："abb" -> "bb" -> "".
 * 先删除回文子序列 "a"，然后再删除 "bb"。
 * 示例 3：
 * <p>
 * 输入：s = "baabb"
 * 输出：2
 * 解释："baabb" -> "b" -> "".
 * 先删除回文子序列 "baab"，然后再删除 "b"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅包含字母 'a'  和 'b'
 */
public class Code10 {

    public int next(String s) {
        //如果没有
        if (s.length() < 1) {
            //过
            return 0;
        }
        //如果只有一个
        if (s.length() == 1) {
            //过
            return 1;
        }
        //初始化剩余内容
        StringBuilder str = new StringBuilder();
        //左右区间
        int left = 0;
        int right = s.length() - 1;
        //循环
        while (left < right) {
            //如果相同
            if (s.charAt(left) == s.charAt(right)) {
                //本次都删除
                left++;
                right--;
            } else {
                //记录这个无法删除的,并移动
                str.append(s.charAt(right--));
            }
        }
        //返回
        return next(str.toString()) + 1;
    }

    public int removePalindromeSub(String s) {
        //返回
        return Math.min(Math.min(next(s), next(new StringBuffer(s).reverse().toString())), 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code10().removePalindromeSub("abbaaaab"));
    }

}
