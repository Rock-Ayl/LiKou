package easy26;

/**
 * @Author ayl
 * @Date 2022-12-31
 * 409. 最长回文串
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 * <p>
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入:s = "abccccdd"
 * 输出:7
 * 解释:
 * 我们可以构造的最长的回文串是"dccaccd", 它的长度是 7。
 * 示例 2:
 * <p>
 * 输入:s = "a"
 * 输入:1
 * 示例 3：
 * <p>
 * 输入:s = "aaaaaccc"
 * 输入:7
 * 提示:
 * <p>
 * 1 <= s.length <= 2000
 * s 只由小写 和/或 大写英文字母组成
 */
public class Code11 {

    public int longestPalindrome(String s) {
        //初始化缓存
        int[] arr = new int[123];
        //结果
        int count = 0;
        //循环
        for (char c : s.toCharArray()) {
            //如果有一个了
            if (arr[c] == 1) {
                //回文
                count = count + 2;
                //重置
                arr[c] = 0;
            } else {
                //记录
                arr[c]++;
            }
        }
        //如果有单个的
        if (s.length() % 2 != 0) {
            //直接返回并+1
            return count + 1;
        }
        //循环
        for (int i = 65; i < arr.length; i++) {
            //如果有1
            if (arr[i] == 1) {
                //直接返回并+1
                return count + 1;
            }
        }
        //默认
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().longestPalindrome("AB"));
    }

}
