package easy40;

/**
 * @Author ayl
 * @Date 2025-06-07
 * 3550. 数位和等于下标的最小下标
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 返回满足 nums[i] 的数位和（每一位数字相加求和）等于 i 的 最小 下标 i 。
 * <p>
 * 如果不存在满足要求的下标，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,2]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * nums[2] = 2，其数位和等于 2 ，与其下标 i = 2 相等。因此，输出为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,10,11]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums[1] = 10，其数位和等于 1 + 0 = 1，与其下标 i = 1 相等。
 * nums[2] = 11，其数位和等于是 1 + 1 = 2，与其下标 i = 2 相等。
 * 由于下标 1 是满足要求的最小下标，输出为 1 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 由于不存在满足要求的下标，输出为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 1000
 */
public class Code19 {

    public int smallestIndex(int[] nums) {
        //循环
        for (int i = 0; i < nums.length; i++) {
            //数字
            int num = nums[i];
            //如果是
            if (count(num) == i) {
                //返回
                return i;
            }
        }
        //默认
        return -1;
    }

    //计算数位
    private int count(int num) {
        //和
        int sum = 0;
        //循环
        while (num > 9) {
            //叠加
            sum += num % 10;
            //下一个
            num = num / 10;
        }
        //返回
        return sum + num;
    }

    public static void main(String[] args) {

    }

}
