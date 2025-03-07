package normal32;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-05-27
 * 2279. 装满石头的背包的最大数量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有编号从 0 到 n - 1 的 n 个背包。给你两个下标从 0 开始的整数数组 capacity 和 rocks 。第 i 个背包最大可以装 capacity[i] 块石头，当前已经装了 rocks[i] 块石头。另给你一个整数 additionalRocks ，表示你可以放置的额外石头数量，石头可以往 任意 背包中放置。
 * <p>
 * 请你将额外的石头放入一些背包中，并返回放置后装满石头的背包的 最大 数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：capacity = [2,3,4,5], rocks = [1,2,4,4], additionalRocks = 2
 * 输出：3
 * 解释：
 * 1 块石头放入背包 0 ，1 块石头放入背包 1 。
 * 每个背包中的石头总数是 [2,3,4,4] 。
 * 背包 0 、背包 1 和 背包 2 都装满石头。
 * 总计 3 个背包装满石头，所以返回 3 。
 * 可以证明不存在超过 3 个背包装满石头的情况。
 * 注意，可能存在其他放置石头的方案同样能够得到 3 这个结果。
 * 示例 2：
 * <p>
 * 输入：capacity = [10,2,2], rocks = [2,2,0], additionalRocks = 100
 * 输出：3
 * 解释：
 * 8 块石头放入背包 0 ，2 块石头放入背包 2 。
 * 每个背包中的石头总数是 [10,2,2] 。
 * 背包 0 、背包 1 和背包 2 都装满石头。
 * 总计 3 个背包装满石头，所以返回 3 。
 * 可以证明不存在超过 3 个背包装满石头的情况。
 * 注意，不必用完所有的额外石头。
 */
public class Code5 {

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        //优先队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        //已经装满的数量
        int count = 0;
        //所需的所有石头
        long allNeed = 0L;
        //循环
        for (int i = 0; i < capacity.length; i++) {
            //计算背包装满的差
            int other = capacity[i] - rocks[i];
            //记录所有所需石头
            allNeed += other;
            //如果装满了
            if (other == 0) {
                //+1
                ++count;
            } else {
                //加入不满的队列
                priorityQueue.add(other);
            }
        }
        //如果绝对够
        if (allNeed <= additionalRocks) {
            //直接返回
            return capacity.length;
        }
        //循环
        while (additionalRocks > 0 && priorityQueue.isEmpty() == false) {
            //获取优先级最高的那个背包
            Integer small = priorityQueue.poll();
            //如果不够了
            if (small.compareTo(additionalRocks) > 0) {
                //跳出
                break;
            }
            //装满
            additionalRocks -= small;
            //+1
            ++count;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().maximumBags(new int[]{3, 3, 4, 5}, new int[]{1, 2, 4, 4}, 2));
    }

}
