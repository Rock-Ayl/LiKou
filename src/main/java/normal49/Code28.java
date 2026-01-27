package normal49;

/**
 * 3818. 移除前缀使数组严格递增
 * 算术评级: 2
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 你需要从 nums 中 恰好 移除一个前缀（可以为空）。
 * <p>
 * 返回一个整数，表示被移除的前缀的 最小 长度，使得剩余的数组 严格递增 。
 * <p>
 * 数组的 前缀 是从数组的起始位置开始，一直延伸到任意位置的子数组。
 * <p>
 * 如果一个数组的每个元素都严格大于它的前一个元素（若存在），则称该数组 严格递增 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,-1,2,3,3,4,5]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 移除前缀 prefix = [1, -1, 2, 3] 后，剩余数组为 [3, 4, 5]，严格递增。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,3,-2,-5]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 移除前缀 prefix = [4, 3, -2] 后，剩余数组为 [-5]，严格递增。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,2,3,4]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组 nums = [1, 2, 3, 4] 已经是严格递增的，因此移除空前缀即可。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 */
public class Code28 {

    public int minimumPrefixLength(int[] nums) {
        //索引
        int index = nums.length - 1;
        //如果可以左滑
        while (index > 0 && nums[index] > nums[index - 1]) {
            //-1
            index--;
        }
        //返回
        return index;
    }

    public static void main(String[] args) {
        System.out.println(new Code28().minimumPrefixLength(new int[]{
                1, -1, 2, 3, 3, 4, 5
        }));
    }

}
