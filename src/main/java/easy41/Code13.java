package easy41;

/**
 * @Author ayl
 * @Date 2025-09-27
 * 3683. 完成一个任务的最早时间
 * 算术评级: 1
 * 第 467 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1199
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二维整数数组 tasks，其中 tasks[i] = [si, ti]。
 * <p>
 * 数组中的每个 [si, ti] 表示一个任务，该任务的开始时间为 si，完成该任务需要 ti 个时间单位。
 * <p>
 * 返回至少完成一个任务的最早时间。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： tasks = [[1,6],[2,3]]
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 第一个任务从时间 t = 1 开始，并在 1 + 6 = 7 时完成。第二个任务在时间 t = 2 开始，并在 2 + 3 = 5 时完成。因此，最早完成的任务在时间 5。
 * <p>
 * 示例 2：
 * <p>
 * 输入： tasks = [[100,100],[100,100],[100,100]]
 * <p>
 * 输出： 200
 * <p>
 * 解释：
 * <p>
 * 三个任务都在时间 100 + 100 = 200 时完成。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= tasks.length <= 100
 * tasks[i] = [si, ti]
 * 1 <= si, ti <= 100
 */
public class Code13 {

    public int earliestTime(int[][] tasks) {
        //结果
        int first = Integer.MAX_VALUE;
        //循环
        for (int[] task : tasks) {
            //刷新
            first = Math.min(task[0] + task[1], first);
        }
        //返回
        return first;
    }

    public static void main(String[] args) {

    }

}
