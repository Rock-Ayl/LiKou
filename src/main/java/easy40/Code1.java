package easy40;

/**
 * @Author ayl
 * @Date 2025-03-11
 * 1154. 一年中的第几天
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 date ，按 YYYY-MM-DD 格式表示一个 现行公元纪年法 日期。返回该日期是当年的第几天。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "2019-01-09"
 * 输出：9
 * 解释：给定日期是2019年的第九天。
 * 示例 2：
 * <p>
 * 输入：date = "2019-02-10"
 * 输出：41
 * <p>
 * <p>
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其他的 date[i] 都是数字
 * date 表示的范围从 1900 年 1 月 1 日至 2019 年 12 月 31 日
 */
public class Code1 {

    public int dayOfYear(String date) {
        //每个月的时间
        int[] arr = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        //年月日
        int year = Integer.valueOf(date.substring(0, 4));
        int month = Integer.valueOf(date.substring(5, 7));
        int day = Integer.valueOf(date.substring(8, 10));
        //结果,默认本月的默认填
        int result = day;
        //索引
        int index = 0;
        //循环
        while (index + 1 < month) {
            //叠加
            result += arr[index++];
        }
        //如果是闰年
        if (year % 4 == 0 && 1900 != year) {
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

    public static void main(String[] args) {
        System.out.println(new Code1().dayOfYear("1900-02-29"));
    }

}
