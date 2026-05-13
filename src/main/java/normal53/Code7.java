package normal53;

/**
 * 1234. 替换子串得到平衡字符串
 * 算术评级: 7
 * 第 159 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1878
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 * <p>
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * <p>
 * <p>
 * <p>
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 * <p>
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 * <p>
 * 请返回待替换子串的最小可能长度。
 * <p>
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "QWER"
 * 输出：0
 * 解释：s 已经是平衡的了。
 * 示例 2：
 * <p>
 * 输入：s = "QQWE"
 * 输出：1
 * 解释：我们需要把一个 'Q' 替换成 'R'，这样得到的 "RQWE" (或 "QRWE") 是平衡的。
 * 示例 3：
 * <p>
 * 输入：s = "QQQW"
 * 输出：2
 * 解释：我们可以把前面的 "QQ" 替换成 "ER"。
 * 示例 4：
 * <p>
 * 输入：s = "QQQQ"
 * 输出：3
 * 解释：我们可以替换后 3 个 'Q'，使 s = "QWER"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * s.length 是 4 的倍数
 * s 中只含有 'Q', 'W', 'E', 'R' 四种字符
 */
public class Code7 {

    public int balancedString(String s) {

        //每种字符目标数量
        int targetCount = s.length() / 4;

        /**
         * 初始化
         */

        //符合的条件
        int count = 4;
        //统计数量数组
        int[] arr = new int[26];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //+1,如果本次超了
            if (arr[s.charAt(i) - 'A']++ == targetCount) {
                //记录不符合
                count--;
            }
        }
        //如果全部满足
        if (count == 4) {
            //直接返回
            return 0;
        }

        /**
         * 初始化
         */

        //双指针
        int left = 0;
        int right = -1;
        //循环
        while (count != 4) {
            //-1,如果本次不超了
            if (--arr[s.charAt(++right) - 'A'] == targetCount) {
                //记录符合
                count++;
            }
        }
        //初始化最小情况
        int min = right - left + 1;

        /**
         * 不断滑动
         */

        //跳出
        out:
        //循环
        while (left < s.length()) {

            /**
             * 左滑
             */

            //+1,如果本次超了
            if (arr[s.charAt(left++) - 'A']++ == targetCount) {
                //记录不符合
                count--;
            }

            /**
             * 不断右滑
             */

            //如果不满足
            while (count != 4) {
                //如果不可以右滑了
                if (right + 1 >= s.length()) {
                    //跳出
                    break out;
                }
                //-1,如果本次不超了
                if (--arr[s.charAt(++right) - 'A'] == targetCount) {
                    //记录符合
                    count++;
                }
            }

            /**
             * 记录本次结果
             */

            //如果是结果
            if (count == 4) {
                //更新最小情况
                min = Math.min(min, (right - left + 1));
            }

        }

        /**
         * 返回结果
         */

        //返回结果
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().balancedString("QQWE"));
    }

}
