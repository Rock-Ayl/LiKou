package normal42;

/**
 * @Author ayl
 * @Date 2025-05-05
 * 1904. 你完成的完整对局数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一款新的在线电子游戏在近期发布，在该电子游戏中，以 刻钟 为周期规划若干时长为 15 分钟 的游戏对局。这意味着，在 HH:00、HH:15、HH:30 和 HH:45 ，将会开始一个新的对局，其中 HH 用一个从 00 到 23 的整数表示。游戏中使用 24 小时制的时钟 ，所以一天中最早的时间是 00:00 ，最晚的时间是 23:59 。
 * <p>
 * 给你两个字符串 startTime 和 finishTime ，均符合 "HH:MM" 格式，分别表示你 进入 和 退出 游戏的确切时间，请计算在整个游戏会话期间，你完成的 完整对局的对局数 。
 * <p>
 * 例如，如果 startTime = "05:20" 且 finishTime = "05:59" ，这意味着你仅仅完成从 05:30 到 05:45 这一个完整对局。而你没有完成从 05:15 到 05:30 的完整对局，因为你是在对局开始后进入的游戏；同时，你也没有完成从 05:45 到 06:00 的完整对局，因为你是在对局结束前退出的游戏。
 * 如果 finishTime 早于 startTime ，这表示你玩了个通宵（也就是从 startTime 到午夜，再从午夜到 finishTime）。
 * <p>
 * 假设你是从 startTime 进入游戏，并在 finishTime 退出游戏，请计算并返回你完成的 完整对局的对局数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：startTime = "12:01", finishTime = "12:44"
 * 输出：1
 * 解释：你完成了从 12:15 到 12:30 的一个完整对局。
 * 你没有完成从 12:00 到 12:15 的完整对局，因为你是在对局开始后的 12:01 进入的游戏。
 * 你没有完成从 12:30 到 12:45 的完整对局，因为你是在对局结束前的 12:44 退出的游戏。
 * 示例 2：
 * <p>
 * 输入：startTime = "20:00", finishTime = "06:00"
 * 输出：40
 * 解释：你完成了从 20:00 到 00:00 的 16 个完整的对局，以及从 00:00 到 06:00 的 24 个完整的对局。
 * 16 + 24 = 40
 * 示例 3：
 * <p>
 * 输入：startTime = "00:00", finishTime = "23:59"
 * 输出：95
 * 解释：除最后一个小时你只完成了 3 个完整对局外，其余每个小时均完成了 4 场完整对局。
 * <p>
 * <p>
 * 提示：
 * <p>
 * startTime 和 finishTime 的格式为 HH:MM
 * 00 <= HH <= 23
 * 00 <= MM <= 59
 * startTime 和 finishTime 不相等
 */
public class Code16 {

    //区间数组
    private static final int[] RANGE_ARR = new int[]{0, 15, 30, 45};

    public int numberOfRounds(String loginTime, String logoutTime) {

        /**
         * string 转 数字
         */

        //解析时间
        int inTime = parseTime(loginTime);
        int outTime = parseTime(logoutTime);

        /**
         * 解决过一天的问题
         */

        //如果开始时间大于结束时间,说明过了一天
        if (inTime > outTime) {
            //晚一天
            outTime += 60 * 24;
        }

        /**
         * 修剪2个时间,变为完整时间
         */

        //修剪,一个向上取整,一个向下取整
        inTime = upTime(inTime);
        outTime = downTime(outTime);

        /**
         * 计算最终结果
         */

        //计算结果并返回,最小为0
        return Math.max((outTime - inTime) / 15, 0);
    }

    //时间解析为数字
    private int parseTime(String time) {
        //拆解
        int hour = Integer.valueOf(time.substring(0, 2));
        int day = Integer.valueOf(time.substring(3, 5));
        //返回
        return hour * 60 + day;
    }

    //将时间向上取整
    private int upTime(int time) {
        //整小时
        int inHour = time / 60 * 60;
        //分钟
        int inMin = time - inHour;
        //区间指针
        int rangeIndex = 0;
        //循环
        while (rangeIndex < RANGE_ARR.length) {
            //如果当前完全覆盖这个区间
            if (inMin <= RANGE_ARR[rangeIndex]) {
                //返回
                return inHour + RANGE_ARR[rangeIndex];
            }
            //+1
            rangeIndex++;
        }
        //默认返回下一个小时开始
        return inHour + 60;
    }

    //将时间向下取整
    private int downTime(int time) {
        //整小时
        int inHour = time / 60 * 60;
        //分钟
        int inMin = time - inHour;
        //区间指针
        int rangeIndex = RANGE_ARR.length - 1;
        //循环
        while (rangeIndex >= 0) {
            //如果当前完全覆盖这个区间
            if (inMin >= RANGE_ARR[rangeIndex]) {
                //返回
                return inHour + RANGE_ARR[rangeIndex];
            }
            //-1
            rangeIndex--;
        }
        //默认返回上一个小时开始
        return inHour - 60;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().numberOfRounds("00:47", "00:57"));
    }

}