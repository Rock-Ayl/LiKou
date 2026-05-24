package easy43;

/**
 * 3936. 将 0 移到末尾的最少交换次数
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 在一步操作中，你可以选择任意两个 不同 的下标 i 和 j 并交换 nums[i] 和 nums[j] 。
 * <p>
 * 返回将所有 0 移动到数组末尾所需的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [0,1,0,3,12]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 我们执行以下交换操作：
 * <p>
 * 交换 nums[0] 和 nums[3] ，得到 nums = [3, 1, 0, 0, 12] 。
 * 交换 nums[2] 和 nums[4] ，得到 nums = [3, 1, 12, 0, 0] 。
 * 因此，答案是 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [0,1,0,2]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 我们执行以下交换操作：
 * <p>
 * 交换 nums[0] 和 nums[3] ，得到 nums = [2, 1, 0, 0] 。
 * 因此，答案是 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,2,0]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组已经满足条件。因此，不需要任何交换操作。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class Code12 {

    public int minimumSwaps(int[] nums) {
        //0
        int result = 0;
        //双指针
        int left = 0;
        int right = nums.length - 1;
        //循环
        while (left < right) {
            //如果左边不是0
            if (nums[left] != 0) {
                //+1
                left++;
                //本轮过
                continue;
            }
            //如果右边是0
            if (nums[right] == 0) {
                //-1
                right--;
                //本轮过
                continue;
            }
            //交换
            result++;
            left++;
            right--;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minimumSwaps(new int[]{0, 1, 0, 3, 12}));
    }

}
