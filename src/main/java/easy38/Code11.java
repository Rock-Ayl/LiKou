package easy38;

/**
 * @Author ayl
 * @Date 2024-09-08
 * 3280. 将日期转换为二进制表示
 * 简单
 * 相关企业
 * 给你一个字符串 date，它的格式为 yyyy-mm-dd，表示一个公历日期。
 * <p>
 * date 可以重写为二进制表示，只需要将年、月、日分别转换为对应的二进制表示（不带前导零）并遵循 year-month-day 的格式。
 * <p>
 * 返回 date 的 二进制 表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： date = "2080-02-29"
 * <p>
 * 输出： "100000100000-10-11101"
 * <p>
 * 解释：
 * <p>
 * 100000100000, 10 和 11101 分别是 2080, 02 和 29 的二进制表示。
 * <p>
 * 示例 2：
 * <p>
 * 输入： date = "1900-01-01"
 * <p>
 * 输出： "11101101100-1-1"
 * <p>
 * 解释：
 * <p>
 * 11101101100, 1 和 1 分别是 1900, 1 和 1 的二进制表示。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * date.length == 10
 * date[4] == date[7] == '-'，其余的 date[i] 都是数字。
 * 输入保证 date 代表一个有效的公历日期，日期范围从 1900 年 1 月 1 日到 2100 年 12 月 31 日（包括这两天）。
 */
public class Code11 {

    public String convertDateToBinary(String date) {
        //拆分
        String[] dateArr = date.split("-");
        //返回
        return Integer.toBinaryString(Integer.valueOf(dateArr[0])) + "-" +
                Integer.toBinaryString(Integer.valueOf(dateArr[1])) + "-" +
                Integer.toBinaryString(Integer.valueOf(dateArr[2]));
    }

    public static void main(String[] args) {
        System.out.println(new Code11().convertDateToBinary("2080-02-29"));
    }

}
