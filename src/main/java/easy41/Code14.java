package easy41;

/**
 * @Author ayl
 * @Date 2025-10-02
 * 3692. 众数频率字符
 * 算术评级: 3
 * 第 166 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1384
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的字符串 s。
 * <p>
 * 对于一个值 k，频率组 是在 s 中恰好出现 k 次的字符集合。
 * <p>
 * 众数频率组 是包含 不同 字符数量最多的频率组。
 * <p>
 * 返回一个字符串，包含众数频率组中的所有字符，字符的顺序 不限 。如果两个或多个频率组的大小并列最大，则选择其频率 k 较大 的那个组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aaabbbccdddde"
 * <p>
 * 输出: "ab"
 * <p>
 * 解释:
 * <p>
 * 频率 (k)	组中不同字符	组大小	是否众数?
 * 4	{d}	1	否
 * 3	{a, b}	2	是
 * 2	{c}	1	否
 * 1	{e}	1	否
 * 字符 'a' 和 'b' 的频率相同，都为 3，它们在众数频率组中。
 * <p>
 * 示例 2:
 * <p>
 * 输入: s = "abcd"
 * <p>
 * 输出: "abcd"
 * <p>
 * 解释:
 * <p>
 * 频率 (k)	组中不同字符	组大小	是否众数?
 * 1	{a, b, c, d}	4	是
 * 所有字符的频率都相同，都为 1，它们都在众数频率组中。
 * <p>
 * 示例 3:
 * <p>
 * 输入: s = "pfpfgi"
 * <p>
 * 输出: "fp"
 * <p>
 * 解释:
 * <p>
 * 频率 (k)	组中不同字符	组大小	是否众数?
 * 2	{p, f}	2	是
 * 1	{g, i}	2	否 (组大小并列，选择频率更大的 k = 2)
 * 字符 'p' 和 'f' 的频率相同，都为 2，它们在众数频率组中。频率为 1 的组大小并列，但我们选择频率更高的组 2。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母。
 */
public class Code14 {

    public String majorityFrequencyGroup(String s) {
        //数字
        int[] arr = new int[26];
        //循环
        for (char letter : s.toCharArray()) {
            //+1
            ++arr[letter - 'a'];
        }
        //count数组
        int[] countArr = new int[101];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //记录count
            if (arr[i] > 0) {
                //记录
                countArr[arr[i]]++;
            }
        }
        //最大数量
        int maxCount = 0;
        //对应频率
        int bestFreq = 0;
        //循环
        for (int i = 1; i < countArr.length; i++) {
            //如果更大 或 相等但频率更大
            if (countArr[i] > maxCount || (countArr[i] == maxCount && i > bestFreq)) {
                //更新
                maxCount = countArr[i];
                bestFreq = i;
            }
        }
        //结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是
            if (arr[i] == bestFreq) {
                //组装
                str.append((char) (i + 'a'));
            }
        }
        //返回
        return str.toString();

    }

    public static void main(String[] args) {
        System.out.println(new Code14().majorityFrequencyGroup("aaabbbccdddde"));
    }

}
