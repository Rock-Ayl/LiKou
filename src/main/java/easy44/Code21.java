package easy44;

/**
 * 4111. 统计一致子数组数目 I
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 如果一个子数组中所有元素的 按位与 运算结果等于该子数组的 最小值 ，则称该子数组为 一致子数组 。
 * <p>
 * 返回 nums 中 一致子数组 的个数。
 * <p>
 * 子数组 是数组中一个连续、非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,3,1,2]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 以下子数组是一致子数组：
 * <p>
 * 子数组	包含的值	按位与	最小值
 * nums[0..0]	[5]	5	5
 * nums[1..1]	[3]	3	3
 * nums[2..2]	[1]	1	1
 * nums[3..3]	[2]	2	2
 * nums[1..2]	[3, 1]	3 & 1 = 1	1
 * nums[0..2]	[5, 3, 1]	5 & 3 & 1 = 1	1
 * 因此，一致子数组的个数为 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,1,1]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 对于每个子数组，其按位与运算结果和最小值均等于 1。因此，答案为 6。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [0]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 唯一的子数组是 [0]，其按位与运算结果和最小值均为 0。因此，答案为 1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 *
 */
public class Code21 {

    public int countConsistent(int[] nums) {
        //结果
        int count = 0;
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //当前
            int sum = nums[i];
            //最小
            int min = nums[i];
            //+1
            count++;
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //与
                sum &= nums[j];
                //最小
                min = Math.min(min, nums[j]);
                //如果是
                if (sum == min) {
                    //+1
                    count++;
                }
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().countConsistent(new int[]{5, 3, 1, 2}));;
    }

}
