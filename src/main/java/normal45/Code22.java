package normal45;

/**
 * @Author ayl
 * @Date 2025-08-22
 * 3517. 最小回文排列 I
 * 算术评级: 4
 * 第 445 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1357
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 回文 字符串 s。
 * <p>
 * 返回 s 的按字典序排列的 最小 回文排列。
 * <p>
 * 如果一个字符串从前往后和从后往前读都相同，那么这个字符串是一个 回文 字符串。
 * <p>
 * 排列 是字符串中所有字符的重排。
 * <p>
 * 如果字符串 a 按字典序小于字符串 b，则表示在第一个不同的位置，a 中的字符比 b 中的对应字符在字母表中更靠前。
 * 如果在前 min(a.length, b.length) 个字符中没有区别，则较短的字符串按字典序更小。
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "z"
 * <p>
 * 输出： "z"
 * <p>
 * 解释：
 * <p>
 * 仅由一个字符组成的字符串已经是按字典序最小的回文。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "babab"
 * <p>
 * 输出： "abbba"
 * <p>
 * 解释：
 * <p>
 * 通过重排 "babab" → "abbba"，可以得到按字典序最小的回文。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s = "daccad"
 * <p>
 * 输出： "acddca"
 * <p>
 * 解释：
 * <p>
 * 通过重排 "daccad" → "acddca"，可以得到按字典序最小的回文。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写英文字母组成。
 * 保证 s 是回文字符串。
 */
public class Code22 {

    public String smallestPalindrome(String s) {
        //缓存
        int[] arr = new int[123];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //记录数量
            arr[s.charAt(i)]++;
        }
        //字符串
        StringBuilder left = new StringBuilder();
        //唯一的奇数
        Character mid = null;
        //循环
        for (int i = 97; i < arr.length; i++) {
            //循环
            while (arr[i] > 1) {
                //消耗
                arr[i] -= 2;
                left.append((char) i);
            }
            //如果还有1
            if (arr[i] == 1) {
                //记录
                mid = (char) i;
            }
        }
        //结果
        StringBuilder result = new StringBuilder();
        //左边
        result.append(left);
        //组装中间
        if (mid != null) {
            //中间
            result.append(mid);
        }
        //右边
        result.append(left.reverse());
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code22().smallestPalindrome("daccad"));
    }

}
