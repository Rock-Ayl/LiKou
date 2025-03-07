package normal26;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-11-18
 * LCR 090. 打家劫舍 II
 * 中等
 * 56
 * 相关企业
 * 一个专业的小偷，计划偷窃一个环形街道上沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * <p>
 * 给定一个代表每个房屋存放金额的非负整数数组 nums ，请计算 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * <p>
 * 输入：nums = [0]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 213 题相同： https://leetcode-cn.com/problems/house-robber-ii/
 */
public class Code4 {

    public int rob(int[] nums) {
        //如果太小
        if (nums.length < 4) {
            //返回最大的
            return Arrays.stream(nums).max().getAsInt();
        }

        //初始化缓存,算左边的
        int[] arr = new int[nums.length];
        //从二个开始
        arr[0] = nums[0];
        arr[1] = Math.max(nums[0], nums[1]);
        //循环
        for (int i = 2; i < arr.length - 1; i++) {
            //计算
            arr[i] = Math.max(arr[i - 1], arr[i - 2] + nums[i]);
        }

        //初始化缓存2,算右边的
        int[] arr2 = new int[nums.length];
        //从二个开始
        arr2[1] = nums[1];
        arr2[2] = Math.max(nums[1], nums[2]);
        //循环
        for (int i = 3; i < arr2.length; i++) {
            //计算
            arr2[i] = Math.max(arr2[i - 1], arr2[i - 2] + nums[i]);
        }

        //返回两种可能最大的情况
        return Math.max(arr[arr.length - 2], arr2[arr.length - 1]);
    }

    public static void main(String[] args) {
        System.out.println(new Code4().rob(new int[]{1, 2, 1, 0}));
    }

}
