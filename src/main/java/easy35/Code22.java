package easy35;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-25
 * 2996. 大于等于顺序前缀和的最小缺失整数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，那么我们称这个前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个 顺序前缀 。
 * <p>
 * 请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,2,5]
 * 输出：6
 * 解释：nums 的最长顺序前缀是 [1,2,3] ，和为 6 ，6 不在数组中，所以 6 是大于等于最长顺序前缀和的最小整数。
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,5,1,12,14,13]
 * 输出：15
 * 解释：nums 的最长顺序前缀是 [3,4,5] ，和为 12 ，12、13 和 14 都在数组中，但 15 不在，所以 15 是大于等于最长顺序前缀和的最小整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Code22 {

    public int missingInteger(int[] nums) {
        //右边
        int right = 1;
        //和
        int sum = nums[0];
        //如果满足条件
        while (right < nums.length && nums[right] == nums[right - 1] + 1) {
            //叠加
            sum += nums[right++];
        }
        //转化为集合
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        //循环
        while (true) {
            //如果不存在
            if (numSet.contains(sum) == false) {
                //返回
                return sum;
            }
            //进位
            sum++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code22().missingInteger(new int[]{3, 4, 5, 1, 12, 14, 13}));
    }
}
