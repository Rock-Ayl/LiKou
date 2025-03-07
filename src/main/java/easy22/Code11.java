package easy22;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-09-08
 * 2395. 和相等的子数组
 * 给你一个下标从 0 开始的整数数组 nums ，判断是否存在 两个 长度为 2 的子数组且它们的 和 相等。注意，这两个子数组起始位置的下标必须 不相同 。
 * <p>
 * 如果这样的子数组存在，请返回 true，否则返回 false 。
 * <p>
 * 子数组 是一个数组中一段连续非空的元素组成的序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,4]
 * 输出：true
 * 解释：元素为 [4,2] 和 [2,4] 的子数组有相同的和 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：false
 * 解释：没有长度为 2 的两个子数组和相等。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0]
 * 输出：true
 * 解释：子数组 [nums[0],nums[1]] 和 [nums[1],nums[2]] 的和相等，都为 0 。
 * 注意即使子数组的元素相同，这两个子数组也视为不相同的子数组，因为它们在原数组中的起始位置不同。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * -109 <= nums[i] <= 109
 */
public class Code11 {

    public boolean findSubarrays(int[] nums) {
        //如果太小
        if (nums.length < 3) {
            //肯定不行
            return false;
        }
        //缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前
            int sum = nums[i - 1] + nums[i];
            //如果有了
            if (set.contains(sum)) {
                //可以
                return true;
            }
            //记录
            set.add(sum);
        }
        //默认没有
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().findSubarrays(new int[]{4, 2, 4}));
    }

}
