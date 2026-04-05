package normal51;

/**
 * 2419. 按位与最大的最长子数组
 * 算术评级: 4
 * 第 312 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1496
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 。
 * <p>
 * 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。
 * <p>
 * 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。
 * 返回满足要求的 最长 子数组的长度。
 * <p>
 * 数组的按位与就是对数组中的所有数字进行按位与运算。
 * <p>
 * 子数组 是数组中的一个连续元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,3,2,2]
 * 输出：2
 * 解释：
 * 子数组按位与运算的最大值是 3 。
 * 能得到此结果的最长子数组是 [3,3]，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：1
 * 解释：
 * 子数组按位与运算的最大值是 4 。
 * 能得到此结果的最长子数组是 [4]，所以返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code22 {

    public int longestSubarray(int[] nums) {
        //最大数字
        int maxNumber = nums[0];
        //最大连击
        int maxHit = 1;
        //上一个数字
        int lastNumber = nums[0];
        //当前连击
        int hit = 1;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果相同 and
            if (nums[i] == lastNumber) {
                //+1
                hit++;
            } else {
                //重新计算
                hit = 1;
            }
            //如果更大
            if (lastNumber > maxNumber) {
                //刷新更大
                maxNumber = lastNumber;
                maxHit = hit;
            }
            //如果相同
            if (lastNumber == maxNumber) {
                //刷新更大
                maxNumber = lastNumber;
                maxHit = Math.max(maxHit, hit);
            }
            //更新上一个数字
            lastNumber = nums[i];
        }
        //返回
        return lastNumber > maxNumber ? hit : maxHit;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().longestSubarray(new int[]{323376, 323376, 323376, 323376, 323376, 323376, 323376, 75940, 323376, 323377, 323377}));
    }

}
