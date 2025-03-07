package normal22;

/**
 * @Author ayl
 * @Date 2023-07-29
 * 剑指 Offer II 102. 加减的目标值
 * 给定一个正整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], target = 3
 * 输出：5
 * 解释：一共有 5 种方法让最终目标和为 3 。
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * 示例 2：
 * <p>
 * 输入：nums = [1], target = 1
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 494 题相同： https://leetcode-cn.com/problems/target-sum/
 */
public class Code14 {

    //结果
    private int count = 0;

    private void next(int[] nums, int sum, int p, int target) {
        //如果到头了
        if (p >= nums.length) {
            //如果是目标
            if (target == sum) {
                //记录
                count++;
            }
            //结束
            return;
        }
        //当前数字
        int num = nums[p];
        //下一个坐标
        int nextP = p + 1;
        //走下去
        next(nums, sum + num, nextP, target);
        next(nums, sum - num, nextP, target);
    }

    public int findTargetSumWays(int[] nums, int target) {
        //走下去
        next(nums, 0, 0, target);
        //返回结果
        return this.count;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }

}
