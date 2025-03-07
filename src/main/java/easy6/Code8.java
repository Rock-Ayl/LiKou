package easy6;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created By Rock-Ayl on 2021-02-04
 * 1507. 转变日期格式
 * 给你一个字符串 date ，它的格式为 Day Month Year ，其中：
 * <p>
 * Day 是集合 {"1st", "2nd", "3rd", "4th", ..., "30th", "31st"} 中的一个元素。
 * Month 是集合 {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"} 中的一个元素。
 * Year 的范围在 ​[1900, 2100] 之间。
 * 请你将字符串转变为 YYYY-MM-DD 的格式，其中：
 * <p>
 * YYYY 表示 4 位的年份。
 * MM 表示 2 位的月份。
 * DD 表示 2 位的天数。
 * <p>
 * 示例 1：
 * <p>
 * 输入：date = "20th Oct 2052"
 * 输出："2052-10-20"
 * 示例 2：
 * <p>
 * 输入：date = "6th Jun 1933"
 * 输出："1933-06-06"
 * 示例 3：
 * <p>
 * 输入：date = "26th May 1960"
 * 输出："1960-05-26"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定日期保证是合法的，所以不需要处理异常输入。
 */
public class Code8 {

    public static String reformatDate(String date) {
        //初始化月份
        Map<String, String> months = new HashMap<>();
        //组装
        months.put("Jan", "01");
        months.put("Feb", "02");
        months.put("Mar", "03");
        months.put("Apr", "04");
        months.put("May", "05");
        months.put("Jun", "06");
        months.put("Jul", "07");
        months.put("Aug", "08");
        months.put("Sep", "09");
        months.put("Oct", "10");
        months.put("Nov", "11");
        months.put("Dec", "12");
        //切割
        String[] words = date.split(" ");
        //初始化天
        StringBuffer day = new StringBuffer(words[0]);
        //删除后两位
        day = day.delete(day.length() - 2, day.length());
        //如果是个位数
        if (day.length() == 1) {
            //加个0
            return words[2] + "-" + months.get(words[1]) + "-" + "0" + day.toString();
        } else {
            //不加0
            return words[2] + "-" + months.get(words[1]) + "-" + day.toString();
        }
    }

    public static void main(String[] args) {
        System.out.println(reformatDate("26th May 1960"));
    }
}
