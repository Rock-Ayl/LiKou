package normal44;

/**
 * @Author ayl
 * @Date 2025-06-21
 * 775. 全局倒置与局部倒置
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums ，表示由范围 [0, n - 1] 内所有整数组成的一个排列。
 * <p>
 * 全局倒置 的数目等于满足下述条件不同下标对 (i, j) 的数目：
 * <p>
 * 0 <= i < j < n
 * nums[i] > nums[j]
 * 局部倒置 的数目等于满足下述条件的下标 i 的数目：
 * <p>
 * 0 <= i < n - 1
 * nums[i] > nums[i + 1]
 * 当数组 nums 中 全局倒置 的数量等于 局部倒置 的数量时，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,2]
 * 输出：true
 * 解释：有 1 个全局倒置，和 1 个局部倒置。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：false
 * 解释：有 2 个全局倒置，和 1 个局部倒置。
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] < n
 * nums 中的所有整数 互不相同
 * nums 是范围 [0, n - 1] 内所有数字组成的一个排列
 */
public class Code5 {

    public boolean isIdealPermutation(int[] nums) {
        //最小的
        int min = nums[nums.length - 1];
        //循环
        for (int i = nums.length - 3; i >= 0; i--) {
            //当前
            int num = nums[i];
            //如果更大
            if (num > min) {
                //不行
                return false;
            }
            //刷新最小
            min = Math.min(min, nums[i + 1]);
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().isIdealPermutation(new int[]{1, 2, 0, 3}));
    }

}
