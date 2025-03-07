package easy24;

/**
 * @Author ayl
 * @Date 2022-10-25
 * 2446. 判断两个事件是否存在冲突
 * 给你两个字符串数组 event1 和 event2 ，表示发生在同一天的两个闭区间时间段事件，其中：
 * <p>
 * event1 = [startTime1, endTime1] 且
 * event2 = [startTime2, endTime2]
 * 事件的时间为有效的 24 小时制且按 HH:MM 格式给出。
 * <p>
 * 当两个事件存在某个非空的交集时（即，某些时刻是两个事件都包含的），则认为出现 冲突 。
 * <p>
 * 如果两个事件之间存在冲突，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：event1 = ["01:15","02:00"], event2 = ["02:00","03:00"]
 * 输出：true
 * 解释：两个事件在 2:00 出现交集。
 * 示例 2：
 * <p>
 * 输入：event1 = ["01:00","02:00"], event2 = ["01:20","03:00"]
 * 输出：true
 * 解释：两个事件的交集从 01:20 开始，到 02:00 结束。
 * 示例 3：
 * <p>
 * 输入：event1 = ["10:00","11:00"], event2 = ["14:00","15:00"]
 * 输出：false
 * 解释：两个事件不存在交集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * evnet1.length == event2.length == 2.
 * event1[i].length == event2[i].length == 5
 * startTime1 <= endTime1
 * startTime2 <= endTime2
 * 所有事件的时间都按照 HH:MM 格式给出
 */
public class Code7 {

    public boolean haveConflict(String[] event1, String[] event2) {
        //获取字符串,转化为数字
        int oneStart = toNum(event1[0]);
        int oneEnd = toNum(event1[1]);
        int twoStart = toNum(event2[0]);
        int twoEnd = toNum(event2[1]);
        //判断是否相交
        return (oneEnd >= twoStart && oneStart < twoEnd) || (twoEnd >= oneStart && twoStart < oneEnd);
    }

    //时间转byte数字
    public int toNum(String time) {
        //返回byte的数字
        return time.charAt(0) * 600 + time.charAt(1) * 60 + time.charAt(3) * 10 + time.charAt(4);
    }

    public static void main(String[] args) {
        System.out.println(new Code7().haveConflict(new String[]{"01:00", "02:00"}, new String[]{"01:20", "03:00"}));
    }

}
