package easy40;

/**
 * @Author ayl
 * @Date 2025-03-12
 * 1185. 一周中的第几天
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个日期，请你设计一个算法来判断它是对应一周中的哪一天。
 * <p>
 * 输入为三个整数：day、month 和 year，分别表示日、月、年。
 * <p>
 * 您返回的结果必须是这几个值中的一个 {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"}。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：day = 31, month = 8, year = 2019
 * 输出："Saturday"
 * 示例 2：
 * <p>
 * 输入：day = 18, month = 7, year = 1999
 * 输出："Sunday"
 * 示例 3：
 * <p>
 * 输入：day = 15, month = 8, year = 1993
 * 输出："Sunday"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给出的日期一定是在 1971 到 2100 年之间的有效日期。
 */
public class Code2 {

    public String dayOfTheWeek(int day, int month, int year) {
        //返回结果每局
        String[] result = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
        //每个月的时间
        int[] arr = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //1971年1月1日是周五
        int daySum = 5;
        //初始年
        int yearIndex = 1971;
        //如果不够
        while (yearIndex < year) {
            //默认加1年
            daySum += 365;
            //如果是闰年
            if (yearIndex % 4 == 0) {
                //+1
                daySum++;
            }
            //下一年
            yearIndex++;
        }
        //月份
        int monthIndex = 1;
        //如果不够
        while (monthIndex < month) {
            //默认加月份对应时间
            daySum += arr[monthIndex];
            //如果是闰年
            if (monthIndex == 2 && (yearIndex % 4 == 0 && yearIndex % 100 != 0)) {
                //+1
                daySum++;
            }
            //下一月
            monthIndex++;
        }
        //叠加日期
        daySum += day;
        //删除轮
        daySum = (daySum - 1) % 7;
        //返回
        return result[daySum];
    }

    public static void main(String[] args) {
        System.out.println(new Code2().dayOfTheWeek(31, 8, 2100));
    }

}
