package normal45;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-07-28
 * 3627. 中位数之和的最大值
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，其长度可以被 3 整除。
 * <p>
 * 你需要通过多次操作将数组清空。在每一步操作中，你可以从数组中选择任意三个元素，计算它们的 中位数 ，并将这三个元素从数组中移除。
 * <p>
 * 奇数长度数组的 中位数 定义为数组按非递减顺序排序后位于中间的元素。
 * <p>
 * 返回通过所有操作得到的 中位数之和的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [2,1,3,2,1,3]
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 第一步，选择下标为 2、4 和 5 的元素，它们的中位数是 3。移除这些元素后，nums 变为 [2, 1, 2]。
 * 第二步，选择下标为 0、1 和 2 的元素，它们的中位数是 2。移除这些元素后，nums 变为空数组。
 * 因此，中位数之和为 3 + 2 = 5。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,1,10,10,10,10]
 * <p>
 * 输出： 20
 * <p>
 * 解释：
 * <p>
 * 第一步，选择下标为 0、2 和 3 的元素，它们的中位数是 10。移除这些元素后，nums 变为 [1, 10, 10]。
 * 第二步，选择下标为 0、1 和 2 的元素，它们的中位数是 10。移除这些元素后，nums 变为空数组。
 * 因此，中位数之和为 10 + 10 = 20。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * nums.length % 3 == 0
 * 1 <= nums[i] <= 109
 */
public class Code11 {

    public long maximumMedianSum(int[] nums) {
        //排序
        Arrays.sort(nums);
        //结果
        long result = 0L;
        //双指针
        int left = 0;
        int right = nums.length - 1;
        //循环
        while (left++ < right--) {
            //叠加
            result += nums[right--];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().maximumMedianSum(new int[]{2, 1, 3, 2, 1, 3}));
        //System.out.println(new Code11().maximumMedianSum(new int[]{1, 1, 10, 10, 10, 10}));
    }

}
