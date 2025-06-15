package easy40;

/**
 * @Author ayl
 * @Date 2025-06-15
 * 3541. 找到频率最高的元音和辅音
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母（'a' 到 'z'）组成的字符串 s。你的任务是找出出现频率 最高 的元音（'a'、'e'、'i'、'o'、'u' 中的一个）和出现频率最高的辅音（除元音以外的所有字母），并返回这两个频率之和。
 * <p>
 * 注意：如果有多个元音或辅音具有相同的最高频率，可以任选其中一个。如果字符串中没有元音或没有辅音，则其频率视为 0。
 * <p>
 * 一个字母 x 的 频率 是它在字符串中出现的次数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "successes"
 * <p>
 * 输出: 6
 * <p>
 * 解释:
 * <p>
 * 元音有：'u' 出现 1 次，'e' 出现 2 次。最大元音频率 = 2。
 * 辅音有：'s' 出现 4 次，'c' 出现 2 次。最大辅音频率 = 4。
 * 输出为 2 + 4 = 6。
 * 示例 2：
 * <p>
 * 输入: s = "aeiaeia"
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * <p>
 * 元音有：'a' 出现 3 次，'e' 出现 2 次，'i' 出现 2 次。最大元音频率 = 3。
 * s 中没有辅音。因此，最大辅音频率 = 0。
 * 输出为 3 + 0 = 3。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母
 */
public class Code21 {

    public int maxFreqSum(String s) {
        //元音辅音最大结果
        int maxLeft = 0;
        int maxRight = 0;
        //缓存
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //频率+1
            int count = ++arr[s.charAt(i) - 'a'];
            //判断元音辅音
            switch (s.charAt(i)) {
                //元音
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    //刷新
                    maxLeft = Math.max(maxLeft, count);
                    break;
                //辅音
                default:
                    //刷新
                    maxRight = Math.max(maxRight, count);
                    break;
            }
        }
        //返回
        return maxLeft + maxRight;
    }

    public static void main(String[] args) {
        System.out.println('a' - 'a');
        System.out.println('e' - 'a');
        System.out.println('i' - 'a');
        System.out.println('o' - 'a');
        System.out.println('u' - 'a');
        System.out.println(new Code21().maxFreqSum("successes"));
    }

}
