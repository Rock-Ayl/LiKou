package easy36;

/**
 * @Author ayl
 * @Date 2024-02-28
 * 3038. 相同分数的最大操作数目 I
 * 简单
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作：
 * <p>
 * 选择 nums 中的前两个元素并将它们删除。
 * 一次操作的 分数 是被删除元素的和。
 * <p>
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * <p>
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,4,5]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,4,5] 。
 * - 删除前两个元素，分数为 1 + 4 = 5 ，nums = [5] 。
 * 由于只剩下 1 个元素，我们无法继续进行任何操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,6,1,4]
 * 输出：1
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * 由于下一次操作的分数与前一次不相等，我们无法继续进行任何操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 */
public class Code10 {

    public int maxOperations(int[] nums) {
        //目标域结果
        int target = nums[0] + nums[1];
        int sum = 1;
        //循环
        for (int i = 2; i < nums.length; i = i + 2) {
            //如果不满足
            if (i + 1 >= nums.length) {
                //跳出
                break;
            }
            //本次
            int num = nums[i] + nums[i + 1];
            //如果不能继续
            if (num != target) {
                //跳出
                break;
            }
            //叠加
            sum++;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {

    }

}
