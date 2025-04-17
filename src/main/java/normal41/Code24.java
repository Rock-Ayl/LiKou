package normal41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-04-17
 * 3075. 幸福值最大化的选择方案
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的数组 happiness ，以及一个 正整数 k 。
 * <p>
 * n 个孩子站成一队，其中第 i 个孩子的 幸福值 是 happiness[i] 。你计划组织 k 轮筛选从这 n 个孩子中选出 k 个孩子。
 * <p>
 * 在每一轮选择一个孩子时，所有 尚未 被选中的孩子的 幸福值 将减少 1 。注意，幸福值 不能 变成负数，且只有在它是正数的情况下才会减少。
 * <p>
 * 选择 k 个孩子，并使你选中的孩子幸福值之和最大，返回你能够得到的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：happiness = [1,2,3], k = 2
 * 输出：4
 * 解释：按以下方式选择 2 个孩子：
 * - 选择幸福值为 3 的孩子。剩余孩子的幸福值变为 [0,1] 。
 * - 选择幸福值为 1 的孩子。剩余孩子的幸福值变为 [0] 。注意幸福值不能小于 0 。
 * 所选孩子的幸福值之和为 3 + 1 = 4 。
 * 示例 2：
 * <p>
 * 输入：happiness = [1,1,1,1], k = 2
 * 输出：1
 * 解释：按以下方式选择 2 个孩子：
 * - 选择幸福值为 1 的任意一个孩子。剩余孩子的幸福值变为 [0,0,0] 。
 * - 选择幸福值为 0 的孩子。剩余孩子的幸福值变为 [0,0] 。
 * 所选孩子的幸福值之和为 1 + 0 = 1 。
 * 示例 3：
 * <p>
 * 输入：happiness = [2,3,4,5], k = 1
 * 输出：5
 * 解释：按以下方式选择 1 个孩子：
 * - 选择幸福值为 5 的孩子。剩余孩子的幸福值变为 [1,2,3] 。
 * 所选孩子的幸福值之和为 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == happiness.length <= 2 * 105
 * 1 <= happiness[i] <= 108
 * 1 <= k <= n
 */
public class Code24 {

    public long maximumHappinessSum(int[] happiness, int k) {
        //排序
        Arrays.sort(happiness);
        //结果
        long sum = 0L;
        //索引
        int index = happiness.length - 1;
        //指针
        int p = 0;
        //循环
        while (++p <= k) {
            //获取并计算当前幸福值,最小为0,叠加结果
            sum += Math.max(happiness[index--] - p + 1, 0);
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().maximumHappinessSum(new int[]{1, 2, 3}, 2));
    }

}