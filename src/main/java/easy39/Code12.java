package easy39;

/**
 * @Author ayl
 * @Date 2025-01-02
 * 3375. 使数组的值全部为 K 的最少操作次数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 如果一个数组中所有 严格大于 h 的整数值都 相等 ，那么我们称整数 h 是 合法的 。
 * <p>
 * 比方说，如果 nums = [10, 8, 10, 8] ，那么 h = 9 是一个 合法 整数，因为所有满足 nums[i] > 9 的数都等于 10 ，但是 5 不是 合法 整数。
 * <p>
 * 你可以对 nums 执行以下操作：
 * <p>
 * 选择一个整数 h ，它对于 当前 nums 中的值是合法的。
 * 对于每个下标 i ，如果它满足 nums[i] > h ，那么将 nums[i] 变为 h 。
 * 你的目标是将 nums 中的所有元素都变为 k ，请你返回 最少 操作次数。如果无法将所有元素都变 k ，那么返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,2,5,4,5], k = 2
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 依次选择合法整数 4 和 2 ，将数组全部变为 2 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2], k = 2
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 没法将所有值变为 2 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [9,7,5,3], k = 1
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 依次选择合法整数 7 ，5 ，3 和 1 ，将数组全部变为 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 */
public class Code12 {

    public int minOperations(int[] nums, int k) {
        //次数
        int count = 0;
        //缓存
        int[] arr = new int[101];
        //循环
        for (int num : nums) {
            //如果小
            if (num < k) {
                //不可能
                return -1;
            }
            //如果第一次出现
            if (++arr[num] == 1) {
                //+1
                count++;
            }
        }
        //返回
        return count + (arr[k] > 0 ? -1 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code12().minOperations(new int[]{9,7,5,3}, 1));
    }

}
