package easy43;

/**
 * 3986. 统计起止时间经过的秒数
 * 第 510 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1205
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个有效时间 startTime 和 endTime，它们均以字符串形式表示，格式为 "HH:MM:SS"。
 * <p>
 * 返回从 startTime 到 endTime 经过的秒数（包含两个端点）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： startTime = "01:00:00", endTime = "01:00:25"
 * <p>
 * 输出： 25
 * <p>
 * 解释：
 * <p>
 * endTime 比 startTime 晚 25 秒。
 * <p>
 * 示例 2：
 * <p>
 * 输入： startTime = "12:34:56", endTime = "13:00:00"
 * <p>
 * 输出： 1504
 * <p>
 * 解释：
 * <p>
 * endTime 比 startTime 晚 25 分 4 秒，共计 1504 秒。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * startTime.length == 8
 * endTime.length == 8
 * startTime 和 endTime 均为格式 "HH:MM:SS" 的有效时间
 * 00 <= HH <= 23
 * 00 <= MM <= 59
 * 00 <= SS <= 59
 * endTime 不早于 startTime
 *
 */
public class Code21 {

    public int secondsBetweenTimes(String startTime, String endTime) {
        //实现
        return parse(endTime) - parse(startTime);
    }

    //转为秒
    private int parse(String timeStr) {
        //是按
        int time = 0;
        //叠加-10小时
        time += (timeStr.charAt(0) - '0') * 60 * 60 * 10;
        //叠加-1小时
        time += (timeStr.charAt(1) - '0') * 60 * 60;
        //叠加-10分钟
        time += (timeStr.charAt(3) - '0') * 60 * 10;
        //叠加-1分钟
        time += (timeStr.charAt(4) - '0') * 60;
        //叠加-10秒
        time += (timeStr.charAt(6) - '0') * 10;
        //叠加-1秒
        time += (timeStr.charAt(7) - '0');
        //返回
        return time;
    }

    public static void main(String[] args) {
        Code21 code21 = new Code21();
        int secondsBetweenTimes = code21.secondsBetweenTimes("01:00:00", "01:00:25");
        System.out.println(secondsBetweenTimes);
    }

}
