package normal32;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-06-30
 * 2895. 最小处理时间
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你有 n 颗处理器，每颗处理器都有 4 个核心。现有 n * 4 个待执行任务，每个核心只执行 一个 任务。
 * <p>
 * 给你一个下标从 0 开始的整数数组 processorTime ，表示每颗处理器最早空闲时间。另给你一个下标从 0 开始的整数数组 tasks ，表示执行每个任务所需的时间。返回所有任务都执行完毕需要的 最小时间 。
 * <p>
 * 注意：每个核心独立执行任务。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：processorTime = [8,10], tasks = [2,2,3,1,8,7,4,5]
 * 输出：16
 * 解释：
 * 最优的方案是将下标为 4, 5, 6, 7 的任务分配给第一颗处理器（最早空闲时间 time = 8），下标为 0, 1, 2, 3 的任务分配给第二颗处理器（最早空闲时间 time = 10）。
 * 第一颗处理器执行完所有任务需要花费的时间 = max(8 + 8, 8 + 7, 8 + 4, 8 + 5) = 16 。
 * 第二颗处理器执行完所有任务需要花费的时间 = max(10 + 2, 10 + 2, 10 + 3, 10 + 1) = 13 。
 * 因此，可以证明执行完所有任务需要花费的最小时间是 16 。
 * 示例 2：
 * <p>
 * 输入：processorTime = [10,20], tasks = [2,3,1,2,5,8,4,3]
 * 输出：23
 * 解释：
 * 最优的方案是将下标为 1, 4, 5, 6 的任务分配给第一颗处理器（最早空闲时间 time = 10），下标为 0, 2, 3, 7 的任务分配给第二颗处理器（最早空闲时间 time = 20）。
 * 第一颗处理器执行完所有任务需要花费的时间 = max(10 + 3, 10 + 5, 10 + 8, 10 + 4) = 18 。
 * 第二颗处理器执行完所有任务需要花费的时间 = max(20 + 2, 20 + 1, 20 + 2, 20 + 3) = 23 。
 * 因此，可以证明执行完所有任务需要花费的最小时间是 23 。
 */
public class Code24 {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        //排序
        Collections.sort(processorTime);
        Collections.sort(tasks);
        //倒过来
        Collections.reverse(processorTime);
        //最大结果
        int max = 0;
        //循环
        for (int i = 3; i < tasks.size(); i = i + 4) {
            //本次话费时间
            int cost = processorTime.get(i / 4) + tasks.get(i);
            //计算并刷新最大值
            max = Math.max(cost, max);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().minProcessingTime(Arrays.asList(10, 20), Arrays.asList(2, 3, 1, 2, 5, 8, 4, 3)));
    }

}
