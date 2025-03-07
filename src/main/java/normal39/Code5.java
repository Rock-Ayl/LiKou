package normal39;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-01-12
 * 2365. 任务调度器 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的正整数数组 tasks ，表示需要 按顺序 完成的任务，其中 tasks[i] 表示第 i 件任务的 类型 。
 * <p>
 * 同时给你一个正整数 space ，表示一个任务完成 后 ，另一个 相同 类型任务完成前需要间隔的 最少 天数。
 * <p>
 * 在所有任务完成前的每一天，你都必须进行以下两种操作中的一种：
 * <p>
 * 完成 tasks 中的下一个任务
 * 休息一天
 * 请你返回完成所有任务所需的 最少 天数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：tasks = [1,2,1,2,3,1], space = 3
 * 输出：9
 * 解释：
 * 9 天完成所有任务的一种方法是：
 * 第 1 天：完成任务 0 。
 * 第 2 天：完成任务 1 。
 * 第 3 天：休息。
 * 第 4 天：休息。
 * 第 5 天：完成任务 2 。
 * 第 6 天：完成任务 3 。
 * 第 7 天：休息。
 * 第 8 天：完成任务 4 。
 * 第 9 天：完成任务 5 。
 * 可以证明无法少于 9 天完成所有任务。
 * 示例 2：
 * <p>
 * 输入：tasks = [5,8,8,5], space = 2
 * 输出：6
 * 解释：
 * 6 天完成所有任务的一种方法是：
 * 第 1 天：完成任务 0 。
 * 第 2 天：完成任务 1 。
 * 第 3 天：休息。
 * 第 4 天：休息。
 * 第 5 天：完成任务 2 。
 * 第 6 天：完成任务 3 。
 * 可以证明无法少于 6 天完成所有任务。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 105
 * 1 <= tasks[i] <= 109
 * 1 <= space <= tasks.length
 */
public class Code5 {

    public long taskSchedulerII(int[] tasks, int space) {
        //当前时间
        long time = 0L;
        //任务指针
        int taskIndex = 0;
        //对应类型任务最早什么时候可以完成
        Map<Integer, Long> typeMap = new HashMap<>();
        //如果还有任务未完成
        while (taskIndex < tasks.length) {
            //获取当前任务类型、索引+1
            int taskType = tasks[taskIndex++];
            //获取最早可以完成任务的时间,默认0、强行来到这个时间
            time = Math.max(time, typeMap.getOrDefault(taskType, 0L));
            //计算出该任务的完成时间、时间+1、记录缓存
            typeMap.put(taskType, time++ + space + 1);
        }
        //返回
        return time;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().taskSchedulerII(new int[]{1, 2, 1, 2, 3, 1}, 3));
    }

}
