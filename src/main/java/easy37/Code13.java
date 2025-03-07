package easy37;

/**
 * @Author ayl
 * @Date 2024-06-23
 * 100345. 使所有元素都可以被 3 整除的最少操作数
 * 简单
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。一次操作中，你可以将 nums 中的 任意 一个元素增加或者减少 1 。
 * <p>
 * 请你返回将 nums 中所有元素都可以被 3 整除的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 通过以下 3 个操作，数组中的所有元素都可以被 3 整除：
 * <p>
 * 将 1 减少 1 。
 * 将 2 增加 1 。
 * 将 4 减少 1 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,6,9]
 * <p>
 * 输出：0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Code13 {

    public int minimumOperations(int[] nums) {
        //和
        int sum = 0;
        //循环
        for (int num : nums) {
            //计算
            sum += num % 3 == 0 ? 0 : 1;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().minimumOperations(new int[]{1, 2, 3, 4}));
    }

}
