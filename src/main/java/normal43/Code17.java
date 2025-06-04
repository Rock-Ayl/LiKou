package normal43;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-06-04
 * 1400. 构造 K 个回文字符串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 k 。请你用 s 字符串中 所有字符 构造 k 个非空 回文串 。
 * <p>
 * 如果你可以用 s 中所有字符构造 k 个回文字符串，那么请你返回 True ，否则返回 False 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "annabelle", k = 2
 * 输出：true
 * 解释：可以用 s 中所有字符构造 2 个回文字符串。
 * 一些可行的构造方案包括："anna" + "elble"，"anbna" + "elle"，"anellena" + "b"
 * 示例 2：
 * <p>
 * 输入：s = "leetcode", k = 3
 * 输出：false
 * 解释：无法用 s 中所有字符构造 3 个回文串。
 * 示例 3：
 * <p>
 * 输入：s = "true", k = 4
 * 输出：true
 * 解释：唯一可行的方案是让 s 中每个字符单独构成一个字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 中所有字符都是小写英文字母。
 * 1 <= k <= 105
 */
public class Code17 {

    public boolean canConstruct(String s, int k) {
        //如果不够
        if (s.length() < k) {
            //过
            return false;
        }
        //缓存
        int[] arr = new int[26];
        //循环
        for (char letter : s.toCharArray()) {
            //+1
            arr[letter - 'a']++;
        }
        //奇数的数量
        int sum = Arrays.stream(arr).map(p -> p % 2).sum();
        //判断是否可以
        return k >= sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().canConstruct("annabelle", 2));
        System.out.println(new Code17().canConstruct("leetcode", 3));
    }

}
