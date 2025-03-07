package easy23;

/**
 * @Author ayl
 * @Date 2022-09-24
 * 2224. 转化时间需要的最少操作数
 * 给你两个字符串 current 和 correct ，表示两个 24 小时制时间 。
 * <p>
 * 24 小时制时间 按 "HH:MM" 进行格式化，其中 HH 在 00 和 23 之间，而 MM 在 00 和 59 之间。最早的 24 小时制时间为 00:00 ，最晚的是 23:59 。
 * <p>
 * 在一步操作中，你可以将 current 这个时间增加 1、5、15 或 60 分钟。你可以执行这一操作 任意 次数。
 * <p>
 * 返回将 current 转化为 correct 需要的 最少操作数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：current = "02:30", correct = "04:35"
 * 输出：3
 * 解释：
 * 可以按下述 3 步操作将 current 转换为 correct ：
 * - 为 current 加 60 分钟，current 变为 "03:30" 。
 * - 为 current 加 60 分钟，current 变为 "04:30" 。
 * - 为 current 加 5 分钟，current 变为 "04:35" 。
 * 可以证明，无法用少于 3 步操作将 current 转化为 correct 。
 * 示例 2：
 * <p>
 * 输入：current = "11:00", correct = "11:01"
 * 输出：1
 * 解释：只需要为 current 加一分钟，所以最小操作数是 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * current 和 correct 都符合 "HH:MM" 格式
 * current <= correct
 */
public class Code10 {

    public int convertTime(String current, String correct) {
        //转换时间为数字
        int start = toNum(current);
        int end = toNum(correct);
        //次数
        int count = 0;
        //循环1
        while (end - start >= 60) {
            //处理一次
            count++;
            start += 60;
        }
        //循环2
        while (end - start >= 15) {
            //处理一次
            count++;
            start += 15;
        }
        //循环3
        while (end - start >= 5) {
            //处理一次
            count++;
            start += 5;
        }
        //循环4
        while (end - start >= 1) {
            //处理一次
            count++;
            start += 1;
        }
        //返回
        return count;
    }

    //转换时间
    public int toNum(String time) {
        //计算并返回
        return (time.charAt(0) - '0') * 600 + (time.charAt(1) - '0') * 60 + (time.charAt(3) - '0') * 10 + (time.charAt(4) - '0');
    }

    public static void main(String[] args) {
        new Code10().convertTime("02:30", "04:35");
    }

}
