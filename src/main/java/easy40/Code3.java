package easy40;

/**
 * @Author ayl
 * @Date 2025-03-14
 * 1360. 日期之间隔几天
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 请你编写一个程序来计算两个日期之间隔了多少天。
 * <p>
 * 日期以字符串形式给出，格式为 YYYY-MM-DD，如示例所示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：date1 = "2019-06-29", date2 = "2019-06-30"
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：date1 = "2020-01-15", date2 = "2019-12-31"
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的日期是 1971 年到 2100 年之间的有效日期。
 */
public class Code3 {

    public int daysBetweenDates(String date1, String date2) {
        //实现
        return Math.abs(toCount(date1) - toCount(date2));
    }

    //计算时间
    private int toCount(String date) {
        //每个月的时间
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //年月日
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8, 10));
        //结果,默认本月的默认填
        int result = day;
        //索引
        int indexYear = 1970;
        //如果不够
        while (indexYear < year) {
            //+365
            result += 365;
            //如果是闰年
            if (isLeap(indexYear)) {
                //+1
                result++;
            }
            //+1
            indexYear++;
        }
        //索引
        int index = 0;
        //循环
        while (index + 1 < month) {
            //叠加
            result += arr[index++];
        }
        //如果是闰年
        if (isLeap(year)) {
            //如果二月以上
            if (month > 2) {
                //+1
                result++;
            }
            //如果是2月29日
            if (month == 2 && day > arr[month]) {
                //+1
                result++;
            }
        }
        //返回
        return result;
    }

    //是否为闰年
    private boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().daysBetweenDates("2100-09-22", "1991-03-12"));
    }

}