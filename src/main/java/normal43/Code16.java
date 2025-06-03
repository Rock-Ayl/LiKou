package normal43;

/**
 * @Author ayl
 * @Date 2025-06-03
 * 3566. 等积子集的划分方案
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，其中包含的正整数 互不相同 ，另给你一个整数 target。
 * <p>
 * 请判断是否可以将 nums 分成两个 非空、互不相交 的 子集 ，并且每个元素必须  恰好 属于 一个 子集，使得这两个子集中元素的乘积都等于 target。
 * <p>
 * 如果存在这样的划分，返回 true；否则，返回 false。
 * <p>
 * 子集 是数组中元素的一个选择集合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,1,6,8,4], target = 24
 * <p>
 * 输出： true
 * <p>
 * 解释：子集 [3, 8] 和 [1, 6, 4] 的乘积均为 24。因此，输出为 true 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [2,5,3,7], target = 15
 * <p>
 * 输出： false
 * <p>
 * 解释：无法将 nums 划分为两个非空的互不相交子集，使得它们的乘积均为 15。因此，输出为 false。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 12
 * 1 <= target <= 1015
 * 1 <= nums[i] <= 100
 * nums 中的所有元素互不相同。
 */
public class Code16 {

    public boolean checkEqualPartitions(int[] nums, long target) {

        /**
         * 判断能否满足结果
         */

        //乘积
        long sum = 1L;
        //循环
        for (int num : nums) {
            //乘积
            sum = sum * num;
        }
        //如果不可能有结果
        if (sum != target * target) {
            //过
            return false;
        }

        /**
         * 计算
         */

        //递归实现
        return next(nums, 0, 1L, target);
    }

    //递归
    private boolean next(int[] nums, int index, long sum, long target) {
        //如果越界
        if (index >= nums.length) {
            //过
            return false;
        }
        //获取当前数字,并计算下一个结果
        long newSum = sum * nums[index];
        //如果负数,不满足
        if (newSum < 0L) {
            //过
            return false;
        }
        //如果是结果
        else if (newSum == target) {
            //返回
            return true;
        }
        //如果还有的搞
        else if (newSum < target) {
            //递归
            boolean success = next(nums, index + 1, newSum, target);
            //如果是结果
            if (success == true) {
                //返回
                return true;
            }
        }
        //默认不去乘本身递归
        return next(nums, index + 1, sum, target);
    }

    public static void main(String[] args) {
        System.out.println(new Code16().checkEqualPartitions(new int[]{40, 15, 92, 65, 42, 7, 80, 17, 46, 68, 78, 48}, 4098931200L));
    }

}
