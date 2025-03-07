package easy39;

/**
 * @Author ayl
 * @Date 2025-02-09
 * 3438. 找到字符串中合法的相邻数字
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个只包含数字的字符串 s 。如果 s 中两个 相邻 的数字满足以下条件，我们称它们是 合法的 ：
 * <p>
 * 前面的数字 不等于 第二个数字。
 * 两个数字在 s 中出现的次数 恰好 分别等于这个数字本身。
 * 请你从左到右遍历字符串 s ，并返回最先找到的 合法 相邻数字。如果这样的相邻数字不存在，请你返回一个空字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "2523533"
 * <p>
 * 输出："23"
 * <p>
 * 解释：
 * <p>
 * 数字 '2' 出现 2 次，数字 '3' 出现 3 次。"23" 中每个数字在 s 中出现的次数都恰好分别等于数字本身。所以输出 "23" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "221"
 * <p>
 * 输出："21"
 * <p>
 * 解释：
 * <p>
 * 数字 '2' 出现 2 次，数字 '1' 出现 1 次。所以输出 "21" 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "22"
 * <p>
 * 输出：""
 * <p>
 * 解释：
 * <p>
 * 没有合法的相邻数字。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= s.length <= 100
 * s 只包含 '1' 到 '9' 的数字。
 */
public class Code18 {

    public String findValidPair(String s) {
        //缓存
        int[] arr = new int[27];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //+1
            arr[s.charAt(i) - '0']++;
        }
        //循环2
        for (int i = 1; i < s.length(); i++) {
            //数字
            int num = s.charAt(i) - '0';
            int last = s.charAt(i - 1) - '0';
            //如果满足
            if (num == arr[num] && num != last && last == arr[last]) {
                //返回结果
                return String.valueOf(s.charAt(i - 1)) + s.charAt(i);
            }
        }
        //默认
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Code18().findValidPair("2523533"));
    }

}
