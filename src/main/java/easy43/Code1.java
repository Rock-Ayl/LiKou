package easy43;

/**
 * 101037. 交通信号灯的颜色
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 timer，表示交通信号灯上的剩余时间（以秒为单位）。
 * <p>
 * 信号灯遵循以下规则：
 * <p>
 * 如果 timer == 0，信号灯为 "Green"
 * 如果 timer == 30，信号灯为 "Orange"
 * 如果 30 < timer <= 90，信号灯为 "Red"
 * 返回信号灯的当前状态。如果均不满足上述条件，返回 "Invalid"。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： timer = 60
 * <p>
 * 输出： "Red"
 * <p>
 * 解释：
 * <p>
 * 因为 timer = 60，且 30 < timer <= 90，所以答案是 "Red"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： timer = 5
 * <p>
 * 输出： "Invalid"
 * <p>
 * 解释：
 * <p>
 * 因为 timer = 5，不满足任何给定的条件，所以答案是 "Invalid"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= timer <= 1000
 */
public class Code1 {

    public String trafficSignal(int timer) {
        //情况1
        if (timer == 0) {
            //过
            return "Green";
        }
        //情况2
        if (timer == 30) {
            //过
            return "Orange";
        }
        //情况3
        if (timer <= 90 && timer > 30) {
            //过
            return "Red";
        }
        //默认
        return "Invalid";
    }

}
