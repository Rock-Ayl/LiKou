package normal43;

/**
 * @Author ayl
 * @Date 2025-06-09
 * 3576. 数组元素相等转换
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 n 的整数数组 nums，其中只包含 1 和 -1，以及一个整数 k。
 * <p>
 * 你可以最多进行 k 次以下操作：
 * <p>
 * 选择一个下标 i（0 <= i < n - 1），然后将 nums[i] 和 nums[i + 1] 同时 乘以 -1。
 * <p>
 * 注意：你可以在 不同 的操作中多次选择相同的下标 i。
 * <p>
 * 如果在最多 k 次操作后可以使数组的所有元素相等，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,-1,1,-1,1], k = 3
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 我们可以通过以下两次操作使数组的所有元素相等：
 * <p>
 * 选择下标 i = 1，将 nums[1] 和 nums[2] 同时乘以 -1。此时 nums = [1,1,-1,-1,1]。
 * 选择下标 i = 2，将 nums[2] 和 nums[3] 同时乘以 -1。此时 nums = [1,1,1,1,1]。
 * 示例 2：
 * <p>
 * 输入： nums = [-1,-1,-1,1,1,1], k = 5
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 在最多 5 次操作内，无法使数组的所有元素相等。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 105
 * nums[i] 的值为 -1 或 1。
 * 1 <= k <= n
 */
public class Code20 {

    public boolean canMakeEqual(int[] nums, int k) {
        //两种实现满足一种就行
        return count(nums.clone(), k, 1) || count(nums, k, -1);
    }

    //计算一次
    private boolean count(int[] nums, int k, int target) {
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果正常
            if (nums[i - 1] == target) {
                //本轮过
                continue;
            }
            //如果没了
            if (k-- <= 0) {
                //不行
                return false;
            }
            //计算
            nums[i - 1] = nums[i - 1] * -1;
            nums[i] = nums[i] * -1;
        }
        //默认可以
        return nums[nums.length - 1] == target;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().canMakeEqual(new int[]{1, -1, 1}, 5));
    }

}
