package easy39;

/**
 * @Author ayl
 * @Date 2025-02-08
 * 3442. 奇偶频次间的最大差值 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由小写英文字母组成的字符串 s 。请你找出字符串中两个字符的出现频次之间的 最大 差值，这两个字符需要满足：
 * <p>
 * 一个字符在字符串中出现 偶数次 。
 * 另一个字符在字符串中出现 奇数次 。
 * 返回 最大 差值，计算方法是出现 奇数次 字符的次数 减去 出现 偶数次 字符的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaaaabbc"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 字符 'a' 出现 奇数次 ，次数为 5 ；字符 'b' 出现 偶数次 ，次数为 2 。
 * 最大差值为 5 - 2 = 3 。
 * 示例 2：
 * <p>
 * 输入：s = "abcabcab"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 字符 'a' 出现 奇数次 ，次数为 3 ；字符 'c' 出现 偶数次 ，次数为 2 。
 * 最大差值为 3 - 2 = 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 100
 * s 仅由小写英文字母组成。
 * s 至少由一个出现奇数次的字符和一个出现偶数次的字符组成。
 */
public class Code17 {

    public int maxDifference(String s) {
        //缓存
        int[] arr = new int[127];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //+1
            arr[s.charAt(i)]++;
        }
        //单双最大、最小情况
        int singleMax = Integer.MIN_VALUE;
        int doubleMin = Integer.MAX_VALUE;
        //循环
        for (int i = 97; i < 123; i++) {
            //当前出现频次
            int num = arr[i];
            //如果是0
            if (num == 0) {
                //本轮过
                continue;
            }
            //判断奇偶
            if (num % 2 == 0) {
                //刷新
                doubleMin = Math.min(doubleMin, num);
            } else {
                //刷新
                singleMax = Math.max(singleMax, num);
            }
        }
        //返回
        return singleMax - doubleMin;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maxDifference("az"));
    }

}
