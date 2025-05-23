package easy40;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-03-16
 * 2409. 统计共同度过的日子数
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * Alice 和 Bob 计划分别去罗马开会。
 * <p>
 * 给你四个字符串 arriveAlice ，leaveAlice ，arriveBob 和 leaveBob 。Alice 会在日期 arriveAlice 到 leaveAlice 之间在城市里（日期为闭区间），而 Bob 在日期 arriveBob 到 leaveBob 之间在城市里（日期为闭区间）。每个字符串都包含 5 个字符，格式为 "MM-DD" ，对应着一个日期的月和日。
 * <p>
 * 请你返回 Alice和 Bob 同时在罗马的天数。
 * <p>
 * 你可以假设所有日期都在 同一个 自然年，而且 不是 闰年。每个月份的天数分别为：[31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arriveAlice = "08-15", leaveAlice = "08-18", arriveBob = "08-16", leaveBob = "08-19"
 * 输出：3
 * 解释：Alice 从 8 月 15 号到 8 月 18 号在罗马。Bob 从 8 月 16 号到 8 月 19 号在罗马，他们同时在罗马的日期为 8 月 16、17 和 18 号。所以答案为 3 。
 * 示例 2：
 * <p>
 * 输入：arriveAlice = "10-01", leaveAlice = "10-31", arriveBob = "11-01", leaveBob = "12-31"
 * 输出：0
 * 解释：Alice 和 Bob 没有同时在罗马的日子，所以我们返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有日期的格式均为 "MM-DD" 。
 * Alice 和 Bob 的到达日期都 早于或等于 他们的离开日期。
 * 题目测试用例所给出的日期均为 非闰年 的有效日期。
 */
public class Code4 {

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        //事件数组
        int[] arr = new int[366];
        //分别计算时间
        int startA = countDay(arriveAlice);
        int endA = countDay(leaveAlice);
        int startB = countDay(arriveBob);
        int endB = countDay(leaveBob);
        //循环
        for (int i = startA; i <= endA; i++) {
            //+1
            arr[i]++;
        }
        //循环
        for (int i = startB; i <= endB; i++) {
            //+1
            arr[i]++;
        }
        //返回结果,查看重合的日期
        return (int) Arrays.stream(arr).filter(p -> p == 2).count();
    }

    //计算时间
    private int countDay(String date) {
        //每个月的时间
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //月日
        int month = Integer.valueOf(date.substring(0, 2));
        int day = Integer.valueOf(date.substring(3, 5));
        //结果,默认本月的默认填
        int result = day;
        //索引
        int index = 0;
        //循环
        while (index + 1 < month) {
            //叠加
            result += arr[index++];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().countDaysTogether("08-15", "08-18", "08-16", "08-19"));
    }

}
