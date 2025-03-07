package normal32;

/**
 * @Author ayl
 * @Date 2024-06-29
 * 3191. 使二进制数组全部等于 1 的最少操作次数 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制数组 nums 。
 * <p>
 * 你可以对数组执行以下操作 任意 次（也可以 0 次）：
 * <p>
 * 选择数组中 任意连续 3 个元素，并将它们 全部反转 。
 * 反转 一个元素指的是将它的值从 0 变 1 ，或者从 1 变 0 。
 * <p>
 * 请你返回将 nums 中所有元素变为 1 的 最少 操作次数。如果无法全部变成 1 ，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,1,1,0,0]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * 我们可以执行以下操作：
 * <p>
 * 选择下标为 0 ，1 和 2 的元素并反转，得到 nums = [1,0,0,1,0,0] 。
 * 选择下标为 1 ，2 和 3 的元素并反转，得到 nums = [1,1,1,0,0,0] 。
 * 选择下标为 3 ，4 和 5 的元素并反转，得到 nums = [1,1,1,1,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,1,1]
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * 无法将所有元素都变为 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 1
 */
public class Code23 {

    public int minOperations(int[] nums) {
        //变换次数
        int count = 0;
        //循环
        for (int i = 0; i < nums.length - 2; i++) {
            //如果是目标值
            if (nums[i] == 1) {
                //本轮过
                continue;
            }
            //+1
            ++count;
            //交换
            nums[i] = nums[i] == 0 ? 1 : 0;
            nums[i + 1] = nums[i + 1] == 0 ? 1 : 0;
            nums[i + 2] = nums[i + 2] == 0 ? 1 : 0;
        }
        //返回
        return nums[nums.length - 1] == 0 || nums[nums.length - 2] == 0 ? -1 : count;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().minOperations(new int[]{0, 1, 1, 1, 0, 0}));
    }

}
