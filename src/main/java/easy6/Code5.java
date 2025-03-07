package easy6;

/**
 * Created By Rock-Ayl on 2021-02-01
 * 1736. 替换隐藏数字得到的最晚时间
 * 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * <p>
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * <p>
 * 替换 time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * <p>
 * 示例 1：
 * <p>
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 * <p>
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 * <p>
 * 输入：time = "1?:22"
 * 输出："19:22"
 */
public class Code5 {

    public static String maximumTime(String time) {
        //如果不符合
        if (time.length() != 5) {
            //缺省
            return "";
        }
        //初始化新的字符
        StringBuffer newTime = new StringBuffer();
        //首字符
        char first = time.charAt(0);
        //获取第二个字符
        char second = time.charAt(1);
        //如果首字符可以替换
        if (first == '?') {
            //如果大于4,并且不是随意
            if (second - '4' >= 0 && second != '?') {
                //最大为1
                first = '1';
            } else {
                //最大为2
                first = '2';
            }
            //替换为最大
            newTime.append(first);
        } else {
            //直接赋值
            newTime.append(first);
        }
        //如果字符可以替换
        if (second == '?') {
            //如果是2
            if (first == '2') {
                //最大为3
                second = '3';
            } else {
                //最大为9
                second = '9';
            }
        }
        //直接赋值第二个、第三个
        newTime.append(second + ":");
        //更改第四个
        first = time.charAt(3);
        //更改第五个
        second = time.charAt(4);
        //如果字符可以替换
        if (first == '?') {
            //替换为最大
            newTime.append('5');
        } else {
            //直接赋值
            newTime.append(first);
        }
        //如果字符可以替换
        if (second == '?') {
            //替换为最大
            newTime.append('9');
        } else {
            //直接赋值
            newTime.append(second);
        }
        //返回
        return newTime.toString();
    }

    public static void main(String[] args) {
        System.out.println(maximumTime("?4:03"));
    }
}
