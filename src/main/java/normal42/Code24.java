package normal42;

/**
 * @Author ayl
 * @Date 2025-05-13
 * 1344. 时钟指针的夹角
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个数 hour 和 minutes 。请你返回在时钟上，由给定时间的时针和分针组成的较小角的角度（60 单位制）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：hour = 12, minutes = 30
 * 输出：165
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：hour = 3, minutes = 30
 * 输出；75
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：hour = 3, minutes = 15
 * 输出：7.5
 * 示例 4：
 * <p>
 * 输入：hour = 4, minutes = 50
 * 输出：155
 * 示例 5：
 * <p>
 * 输入：hour = 12, minutes = 0
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= hour <= 12
 * 0 <= minutes <= 59
 * 与标准答案误差在 10^-5 以内的结果都被视为正确结果。
 */
public class Code24 {

    public double angleClock(int hour, int minutes) {
        //小时
        int thisHour = 0;
        int thisMinutes = 0;
        //结果度
        double hourd = 0D;
        double minuted = 0D;
        //循环
        while (thisHour++ < hour) {
            //叠加度
            hourd += 30D;
        }
        //循环
        while (thisMinutes++ < minutes) {
            //叠加度
            minuted += 6D;
            hourd += 0.5D;
        }
        //删除多余
        hourd = hourd % 360D;
        minuted = minuted % 360D;
        //计算出度数
        double d = Math.abs(minuted - hourd);
        //返回
        return Math.min(d, 360d - d);
    }

    public static void main(String[] args) {
        System.out.println(new Code24().angleClock(1, 57));
    }

}
