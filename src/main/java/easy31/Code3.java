package easy31;

/**
 * @Author ayl
 * @Date 2023-05-23
 * 2697. 字典序最小回文串
 * 给你一个由 小写英文字母 组成的字符串 s ，你可以对其执行一些操作。在一步操作中，你可以用其他小写英文字母 替换  s 中的一个字符。
 * <p>
 * 请你执行 尽可能少的操作 ，使 s 变成一个 回文串 。如果执行 最少 操作次数的方案不止一种，则只需选取 字典序最小 的方案。
 * <p>
 * 对于两个长度相同的字符串 a 和 b ，在 a 和 b 出现不同的第一个位置，如果该位置上 a 中对应字母比 b 中对应字母在字母表中出现顺序更早，则认为 a 的字典序比 b 的字典序要小。
 * <p>
 * 返回最终的回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "egcfe"
 * 输出："efcfe"
 * 解释：将 "egcfe" 变成回文字符串的最小操作次数为 1 ，修改 1 次得到的字典序最小回文字符串是 "efcfe"，只需将 'g' 改为 'f' 。
 * 示例 2：
 * <p>
 * 输入：s = "abcd"
 * 输出："abba"
 * 解释：将 "abcd" 变成回文字符串的最小操作次数为 2 ，修改 2 次得到的字典序最小回文字符串是 "abba" 。
 * 示例 3：
 * <p>
 * 输入：s = "seven"
 * 输出："neven"
 * 解释：将 "seven" 变成回文字符串的最小操作次数为 1 ，修改 1 次得到的字典序最小回文字符串是 "neven" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 仅由小写英文字母组成
 */
public class Code3 {

    public String makeSmallestPalindrome(String s) {
        //转换数组
        char[] arr = s.toCharArray();
        //左右
        int left = 0;
        int right = arr.length - 1;
        //循环
        while (left < right) {
            //当前
            char one = arr[left];
            char two = arr[right];
            //如果左边比右边大
            if (one > two) {
                //左边变成右边
                arr[left] = two;
            } else {
                //右边变成左边
                arr[right] = one;
            }
            //进位
            left++;
            right--;
        }
        //返回结果
        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().makeSmallestPalindrome("abcd"));
    }
}
