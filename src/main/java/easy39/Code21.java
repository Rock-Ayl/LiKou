package easy39;

/**
 * @Author ayl
 * @Date 2025-02-18
 * 3427. 变长子数组求和
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 。对于 每个 下标 i（0 <= i < n），定义对应的子数组 nums[start ... i]（start = max(0, i - nums[i])）。
 * <p>
 * 返回为数组中每个下标定义的子数组中所有元素的总和。
 * <p>
 * 子数组 是数组中的一个连续、非空 的元素序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1]
 * <p>
 * 输出：11
 * <p>
 * 解释：
 * <p>
 * 下标 i	子数组	和
 * 0	nums[0] = [2]	2
 * 1	nums[0 ... 1] = [2, 3]	5
 * 2	nums[1 ... 2] = [3, 1]	4
 * 总和	 	11
 * 总和为 11 。因此，输出 11 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,1,2]
 * <p>
 * 输出：13
 * <p>
 * 解释：
 * <p>
 * 下标 i	子数组	和
 * 0	nums[0] = [3]	3
 * 1	nums[0 ... 1] = [3, 1]	4
 * 2	nums[1 ... 2] = [1, 1]	2
 * 3	nums[1 ... 3] = [1, 1, 2]	4
 * 总和	 	13
 * 总和为 13 。因此，输出为 13 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 100
 * 1 <= nums[i] <= 1000
 */
public class Code21 {

    public int subarraySum(int[] nums) {
        //结果
        int result = 0;
        //前缀和
        int[] sumArr = new int[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //计算前缀和
            sumArr[i] = i > 0 ? (nums[i] + sumArr[i - 1]) : nums[i];
            //开始索引
            int start = Math.max(0, i - nums[i]);
            //叠加本次和
            result += sumArr[i] - (start > 0 ? sumArr[start - 1] : 0);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().subarraySum(new int[]{3, 1, 1, 2}));
    }

}
