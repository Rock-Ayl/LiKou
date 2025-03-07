package easy31;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-05-26
 * 剑指 Offer II 012. 左右两边子数组的和相等
 * 给你一个整数数组 nums ，请计算数组的 中心下标 。
 * <p>
 * 数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。
 * <p>
 * 如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。
 * <p>
 * 如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,7,3,6,5,6]
 * 输出：3
 * 解释：
 * 中心下标是 3 。
 * 左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
 * 右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
 * 示例 2：
 * <p>
 * 输入：nums = [1, 2, 3]
 * 输出：-1
 * 解释：
 * 数组中不存在满足此条件的中心下标。
 * 示例 3：
 * <p>
 * 输入：nums = [2, 1, -1]
 * 输出：0
 * 解释：
 * 中心下标是 0 。
 * 左侧数之和 sum = 0 ，（下标 0 左侧不存在元素），
 * 右侧数之和 sum = nums[1] + nums[2] = 1 + -1 = 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -1000 <= nums[i] <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 724 题相同： https://leetcode-cn.com/problems/find-pivot-index/
 */
public class Code5 {

    public int pivotIndex(int[] nums) {
        //当前数组和
        int sum = Arrays.stream(nums).sum();
        //初始化左边和
        int leftSum = nums[0];
        //如果第一个点是
        if (sum - leftSum == 0) {
            //直接返回第一个节点
            return 0;
        }
        //从1开始
        int p = 1;
        //初始化右边和
        int rightSum = sum - leftSum - nums[1];
        //边界
        int right = nums.length - 1;
        //循环
        while (p < right) {
            //如果当前相同
            if (leftSum == rightSum) {
                //返回结果
                return p;
            }
            //进位计算
            leftSum += nums[p];
            rightSum -= nums[++p];
        }
        //如果是最后一个点
        if (sum - nums[right] == 0) {
            //最后一个节点
            return right;
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().pivotIndex(new int[]{-1, -1, 1, 1, 0, 0}));
    }

}
