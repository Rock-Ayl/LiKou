package easy39;

/**
 * @Author ayl
 * @Date 2025-02-17
 * 3452. 好数字之和
 * 简单
 * 相关企业
 * 提示
 * 给定一个整数数组 nums 和一个整数 k，如果元素 nums[i] 严格 大于下标 i - k 和 i + k 处的元素（如果这些元素存在），则该元素 nums[i] 被认为是 好 的。如果这两个下标都不存在，那么 nums[i] 仍然被认为是 好 的。
 * <p>
 * 返回数组中所有 好 元素的 和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,3,2,1,5,4], k = 2
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 好的数字包括 nums[1] = 3，nums[4] = 5 和 nums[5] = 4，因为它们严格大于下标 i - k 和 i + k 处的数字。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [2,1], k = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 唯一的好数字是 nums[0] = 2，因为它严格大于 nums[1]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 1000
 * 1 <= k <= floor(nums.length / 2)
 */
public class Code20 {

    public int sumOfGoodNumbers(int[] nums, int k) {
        //和
        int sum = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是
            if (right(nums, i, k) == true) {
                //叠加
                sum += nums[i];
            }
        }
        //返回
        return sum;
    }

    //是否为好数
    private boolean right(int[] nums, int index, int k) {
        //如果左边有 and 不符合
        if (index - k >= 0 && nums[index] <= nums[index - k]) {
            //过
            return false;
        }
        //如果右边有 and 不符合
        if (index + k < nums.length && nums[index] <= nums[index + k]) {
            //过
            return false;
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().sumOfGoodNumbers(new int[]{1, 3, 2, 1, 5, 4}, 2));
    }

}