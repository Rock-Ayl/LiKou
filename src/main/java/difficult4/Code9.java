package difficult4;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-09-18
 * 3296. 移山所需的最少秒数
 * 算术评级: 5
 * 第 416 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1695
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 mountainHeight 表示山的高度。
 * <p>
 * 同时给你一个整数数组 workerTimes，表示工人们的工作时间（单位：秒）。
 * <p>
 * 工人们需要 同时 进行工作以 降低 山的高度。对于工人 i :
 * <p>
 * 山的高度降低 x，需要花费 workerTimes[i] + workerTimes[i] * 2 + ... + workerTimes[i] * x 秒。例如：
 * 山的高度降低 1，需要 workerTimes[i] 秒。
 * 山的高度降低 2，需要 workerTimes[i] + workerTimes[i] * 2 秒，依此类推。
 * 返回一个整数，表示工人们使山的高度降低到 0 所需的 最少 秒数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： mountainHeight = 4, workerTimes = [2,1,1]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 将山的高度降低到 0 的一种方式是：
 * <p>
 * 工人 0 将高度降低 1，花费 workerTimes[0] = 2 秒。
 * 工人 1 将高度降低 2，花费 workerTimes[1] + workerTimes[1] * 2 = 3 秒。
 * 工人 2 将高度降低 1，花费 workerTimes[2] = 1 秒。
 * 因为工人同时工作，所需的最少时间为 max(2, 3, 1) = 3 秒。
 * <p>
 * 示例 2：
 * <p>
 * 输入： mountainHeight = 10, workerTimes = [3,2,2,4]
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 工人 0 将高度降低 2，花费 workerTimes[0] + workerTimes[0] * 2 = 9 秒。
 * 工人 1 将高度降低 3，花费 workerTimes[1] + workerTimes[1] * 2 + workerTimes[1] * 3 = 12 秒。
 * 工人 2 将高度降低 3，花费 workerTimes[2] + workerTimes[2] * 2 + workerTimes[2] * 3 = 12 秒。
 * 工人 3 将高度降低 2，花费 workerTimes[3] + workerTimes[3] * 2 = 12 秒。
 * 所需的最少时间为 max(9, 12, 12, 12) = 12 秒。
 * <p>
 * 示例 3：
 * <p>
 * 输入： mountainHeight = 5, workerTimes = [1]
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 这个示例中只有一个工人，所以答案是 workerTimes[0] + workerTimes[0] * 2 + workerTimes[0] * 3 + workerTimes[0] * 4 + workerTimes[0] * 5 = 15 秒。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= mountainHeight <= 105
 * 1 <= workerTimes.length <= 104
 * 1 <= workerTimes[i] <= 106
 */
public class Code9 {

    //工作人员
    private static class Worker {

        //下一次降低的时间
        private Long nextTime;

        //降低次数
        private int count;

        //降低倍率
        private int workerTime;

        //初始化
        public Worker(int workerTime) {
            this.workerTime = workerTime;
            this.count = 1;
            this.nextTime = (long) (this.workerTime * this.count);
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("nextTime=%s,count=%s,workerTime=%s", this.nextTime, this.count, this.workerTime);
        }

    }

    public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {

        /**
         * 构建节点
         */

        //优先队列
        PriorityQueue<Worker> queue = new PriorityQueue<>((a, b) -> a.nextTime.compareTo(b.nextTime));
        //循环
        for (int workerTime : workerTimes) {
            //初始化并组装
            queue.add(new Worker(workerTime));
        }

        /**
         * 计算
         */

        //结果
        long result = 0L;
        //跳出
        out:
        //如果还需要降低
        while (mountainHeight > 0) {
            //目标时间段
            result = queue.peek().nextTime;
            //如果还有
            while (queue.peek().nextTime == result) {
                //拉取
                Worker poll = queue.poll();
                //-1,判断是否结束
                if (--mountainHeight == 0) {
                    //跳出
                    break out;
                }
                //计算下一次时间
                poll.nextTime = poll.nextTime + ((long) poll.workerTime * ++poll.count);
                //重新推送
                queue.add(poll);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().minNumberOfSeconds(10, new int[]{3, 2, 2, 4}));
    }

}
