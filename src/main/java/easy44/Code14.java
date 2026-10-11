package easy44;

/**
 * 101204. 和为目标值的最大乘积对
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 target。
 * <p>
 * 当一个由 不同 下标组成的二元组 (i, j) 满足以下条件，称它是 有效的 ：
 * <p>
 * nums[i] + nums[j] == target
 * nums[i] > nums[j]
 * 返回一个 有效的 二元组 [i, j]，使其 乘积 nums[i] * nums[j] 在所有有效二元组中是 最大 的。如果不存在有效的二元组，返回 [-1, -1]。
 * <p>
 * 如果有多个有效二元组都能达到 最大 乘积，你可以返回其中的 任意一个 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4], target = 5
 * <p>
 * 输出： [2,1]
 * <p>
 * 解释：
 * <p>
 * 存在 2 个有效的二元组：
 * <p>
 * 序号	(i, j)	nums[i]	nums[j]	和	积
 * 1	(3, 0)	4	1	5	4
 * 2	(2, 1)	3	2	5	6
 * 两个二元组的和均为 5 且满足 nums[i] > nums[j]。第二个二元组的乘积更大，3 * 2 = 6，因此答案是 [2, 1]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [-3,-1,4,2], target = 1
 * <p>
 * 输出： [3,1]
 * <p>
 * 解释：
 * <p>
 * 存在 2 个有效的二元组：
 * <p>
 * 序号	(i, j)	nums[i]	nums[j]	和	积
 * 1	(2, 0)	4	-3	1	-12
 * 2	(3, 1)	2	-1	1	-2
 * 由于 -2 > -12，因此选择下标 (3, 1) 对应的二元组，答案是 [3, 1]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [3,3,5], target = 6
 * <p>
 * 输出： [-1,-1]
 * <p>
 * 解释：
 * <p>
 * 不存在有效的二元组，因为 nums[0] 和 nums[1] 的和虽然为 6，但它们是相等的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * -100 <= nums[i], target <= 100
 *
 */
public class Code14 {

    public int[] maxProductPair(int[] nums, int target) {
        //结果
        int[] result = new int[]{-1, -1};
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //如果相同
                if (nums[i] == nums[j]) {
                    //本路过
                    continue;
                }
                //如果和不为目标值
                if (nums[i] + nums[j] != target) {
                    //本轮过
                    continue;
                }
                //如果乘积不更大
                if (result[0] != -1 && nums[i] * nums[j] <= nums[result[0]] * nums[result[1]]) {
                    //本轮过
                    continue;
                }
                //对比大小
                if (nums[i] > nums[j]) {
                    //更新结果
                    result[0] = i;
                    result[1] = j;
                } else {
                    //更新结果
                    result[0] = j;
                    result[1] = i;
                }
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code14().maxProductPair(new int[]{-3, -1, 4, 2}, 1);
        System.out.println();
    }

}
