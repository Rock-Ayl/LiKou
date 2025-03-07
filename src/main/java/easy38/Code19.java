package easy38;

/**
 * @Author ayl
 * @Date 2024-10-26
 * 2437. 有效时间的数目
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 5 的字符串 time ，表示一个电子时钟当前的时间，格式为 "hh:mm" 。最早 可能的时间是 "00:00" ，最晚 可能的时间是 "23:59" 。
 * <p>
 * 在字符串 time 中，被字符 ? 替换掉的数位是 未知的 ，被替换的数字可能是 0 到 9 中的任何一个。
 * <p>
 * 请你返回一个整数 answer ，将每一个 ? 都用 0 到 9 中一个数字替换后，可以得到的有效时间的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = "?5:00"
 * 输出：2
 * 解释：我们可以将 ? 替换成 0 或 1 ，得到 "05:00" 或者 "15:00" 。注意我们不能替换成 2 ，因为时间 "25:00" 是无效时间。所以我们有两个选择。
 * 示例 2：
 * <p>
 * 输入：time = "0?:0?"
 * 输出：100
 * 解释：两个 ? 都可以被 0 到 9 之间的任意数字替换，所以我们总共有 100 种选择。
 * 示例 3：
 * <p>
 * 输入：time = "??:??"
 * 输出：1440
 * 解释：小时总共有 24 种选择，分钟总共有 60 种选择。所以总共有 24 * 60 = 1440 种选择。
 * <p>
 * <p>
 * 提示：
 * <p>
 * time 是一个长度为 5 的有效字符串，格式为 "hh:mm" 。
 * "00" <= hh <= "23"
 * "00" <= mm <= "59"
 * 字符串中有的数位是 '?' ，需要用 0 到 9 之间的数字替换。
 */
public class Code19 {

    public int countTime(String time) {

        /**
         * 计算小时
         */

        //小时次数
        int hourCount = 0;
        //循环
        for (int i = 0; i < 24; i++) {
            //计算第一个数字
            int first = i % 10;
            //如果不满足
            if (time.charAt(1) != '?' && (time.charAt(1) - '0') != first) {
                //本轮过
                continue;
            }
            //计算第二个数字
            int second = i / 10;
            //如果不满足
            if (time.charAt(0) != '?' && (time.charAt(0) - '0') != second) {
                //本轮过
                continue;
            }
            //本次可以
            hourCount++;
        }

        /**
         * 计算分
         */

        //分次数
        int minuteCount = 0;
        //循环
        for (int i = 0; i < 60; i++) {
            //计算第一个数字
            int first = i % 10;
            //如果不满足
            if (time.charAt(4) != '?' && (time.charAt(4) - '0') != first) {
                //本轮过
                continue;
            }
            //计算第二个数字
            int second = i / 10;
            //如果不满足
            if (time.charAt(3) != '?' && (time.charAt(3) - '0') != second) {
                //本轮过
                continue;
            }
            //本次可以
            minuteCount++;
        }

        //返回结果
        return hourCount * minuteCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().countTime("??:??"));
    }

}
