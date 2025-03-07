package normal18;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-01-18
 * 462. 最小操作次数使数组元素相等 II
 * 给你一个长度为 n 的整数数组 nums ，返回使所有数组元素相等需要的最小操作数。
 * <p>
 * 在一次操作中，你可以使数组中的一个元素加 1 或者减 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：
 * 只需要两次操作（每次操作指南使一个元素加 1 或减 1）：
 * [1,2,3]  =>  [2,2,3]  =>  [2,2,2]
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,2,9]
 * 输出：16
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Code14 {

    public int minMoves2(int[] nums) {
        //排序
        Arrays.sort(nums);
        //如果是偶数
        if (nums.length % 2 == 0) {
            //中位数
            int right = nums.length / 2;
            //中位数2
            int left = right - 1;
            //二者的和
            int leftSum = 0;
            int rightSum = 0;
            //二者的值
            int leftNum = nums[left];
            int rightNum = nums[right];
            //开始计算
            for (int i = 0; i < left; i++) {
                //叠加
                leftSum += leftNum - nums[i];
            }
            //开始计算
            for (int i = left + 1; i < nums.length; i++) {
                //叠加
                leftSum += nums[i] - leftNum;
            }
            //开始计算
            for (int i = 0; i < right; i++) {
                //叠加
                rightSum += rightNum - nums[i];
            }
            //开始计算
            for (int i = right + 1; i < nums.length; i++) {
                //叠加
                rightSum += nums[i] - rightNum;
            }
            //返回最小结果
            return Math.min(leftSum, rightSum);
        } else {
            //中位数
            int mid = nums.length / 2;
            //和
            int sum = 0;
            //值
            int num = nums[mid];
            //开始计算
            for (int i = 0; i < mid; i++) {
                //叠加
                sum += num - nums[i];
            }
            //开始计算
            for (int i = mid + 1; i < nums.length; i++) {
                //叠加
                sum += nums[i] - num;
            }
            //返回最小结果
            return sum;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code14().minMoves2(new int[]{1, 2,3}));
    }

}
