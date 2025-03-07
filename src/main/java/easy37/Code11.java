package easy37;

/**
 * @Author ayl
 * @Date 2024-06-21
 * 3114. 替换字符可以得到的最晚时间
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s，表示一个 12 小时制的时间格式，其中一些数字（可能没有）被 "?" 替换。
 * <p>
 * 12 小时制时间格式为 "HH:MM" ，其中 HH 的取值范围为 00 至 11，MM 的取值范围为 00 至 59。最早的时间为 00:00，最晚的时间为 11:59。
 * <p>
 * 你需要将 s 中的 所有 "?" 字符替换为数字，使得结果字符串代表的时间是一个 有效 的 12 小时制时间，并且是可能的 最晚 时间。
 * <p>
 * 返回结果字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "1?:?4"
 * <p>
 * 输出： "11:54"
 * <p>
 * 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "11:54"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "0?:5?"
 * <p>
 * 输出： "09:59"
 * <p>
 * 解释： 通过替换 "?" 字符，可以得到的最晚12小时制时间是 "09:59"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * s.length == 5
 * s[2] 是字符 ":"
 * 除 s[2] 外，其他字符都是数字或 "?"
 * 输入保证在替换 "?" 字符后至少存在一个介于 "00:00" 和 "11:59" 之间的时间。
 */
public class Code11 {

    public String findLatestTime(String s) {
        //初始化
        StringBuilder str = new StringBuilder();
        //如果最后一个需要计算
        if (s.charAt(4) == '?') {
            //最大
            str.append(9);
        } else {
            //直接写入
            str.append(s.charAt(4));
        }
        //如果倒数第二个需要计算
        if (s.charAt(3) == '?') {
            //最大
            str.append(5);
        } else {
            //直接写入
            str.append(s.charAt(3));
        }
        //分隔符
        str.append(":");
        //如果倒数第三个需要计算
        if (s.charAt(1) == '?') {
            //判断是9还是1
            if (s.charAt(0) == '0') {
                //最大
                str.append(9);
            } else {
                //最大
                str.append(1);
            }
        } else {
            //直接写入
            str.append(s.charAt(1));
        }
        //如果倒数第四个需要计算
        if (s.charAt(0) == '?') {
            //如果可以是1
            if (str.charAt(str.length() - 1) == '1' || str.charAt(str.length() - 1) == '0') {
                //最大
                str.append(1);
            } else {
                //最大
                str.append(0);
            }
        } else {
            //直接写入
            str.append(s.charAt(0));
        }
        //返回
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().findLatestTime("??:1?"));
    }

}
