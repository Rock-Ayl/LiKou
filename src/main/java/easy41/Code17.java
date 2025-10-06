package easy41;

/**
 * @Author ayl
 * @Date 2025-10-06
 * 3701. 计算交替和
 * 算术评级: 1
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 交替和 定义为：将 nums 中偶数下标位置的元素 相加 ，减去 奇数下标位置的元素。即：nums[0] - nums[1] + nums[2] - nums[3]...
 * <p>
 * 返回表示 nums 的交替和的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,3,5,7]
 * <p>
 * 输出： -4
 * <p>
 * 解释：
 * <p>
 * 偶数下标位置的元素是 nums[0] = 1 和 nums[2] = 5，因为 0 和 2 是偶数。
 * 奇数下标位置的元素是 nums[1] = 3 和 nums[3] = 7，因为 1 和 3 是奇数。
 * 交替和为 nums[0] - nums[1] + nums[2] - nums[3] = 1 - 3 + 5 - 7 = -4。
 * 示例 2：
 * <p>
 * 输入： nums = [100]
 * <p>
 * 输出： 100
 * <p>
 * 解释：
 * <p>
 * 唯一的偶数下标位置的元素是 nums[0] = 100，因为 0 是偶数。
 * 没有奇数下标位置的元素。
 * 交替和为 nums[0] = 100。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code17 {

    public int alternatingSum(int[] nums) {
        //结果
        int result = 0;
        //正面
        boolean right = true;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //判断奇偶
            if (right == true) {
                //叠加
                result += nums[i];
            } else {
                //叠加
                result -= nums[i];
            }
            //方向交换
            right = !right;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().alternatingSum(new int[]{1, 3, 5, 7}));
    }

}
