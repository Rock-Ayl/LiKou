package easy42;

/**
 * 3095. 或值至少 K 的最短子数组 I
 * 算术评级: 2
 * 第 127 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1369
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * <p>
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * <p>
 * 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], k = 2
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 * <p>
 * 注意，[2] 也是一个特别子数组。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,8], k = 10
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2], k = 0
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 0 <= k < 64
 */
public class Code23 {

    public int minimumSubarrayLength(int[] nums, int k) {
        //最小情况
        int min = Integer.MAX_VALUE;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //如果一个满足
            if (num > k || (num & k) == k) {
                //直接
                return 1;
            }
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //叠加
                num |= nums[j];
                //如果一个满足
                if (num > k || (num & k) == k) {
                    //刷新最小
                    min = Math.min(min, j - i + 1);
                    //跳出
                    break;
                }
            }
        }
        //返回
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(32));
        System.out.println(Integer.toBinaryString(29));
        System.out.println(32 & 29);
        System.out.println(new Code23().minimumSubarrayLength(new int[]{2, 1, 2, 32}, 29));
    }

}
