package normal38;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-12-10
 * 1785. 构成特定和需要添加的最少元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，和两个整数 limit 与 goal 。数组 nums 有一条重要属性：abs(nums[i]) <= limit 。
 * <p>
 * 返回使数组元素总和等于 goal 所需要向数组中添加的 最少元素数量 ，添加元素 不应改变 数组中 abs(nums[i]) <= limit 这一属性。
 * <p>
 * 注意，如果 x >= 0 ，那么 abs(x) 等于 x ；否则，等于 -x 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,1], limit = 3, goal = -4
 * 输出：2
 * 解释：可以将 -2 和 -3 添加到数组中，数组的元素总和变为 1 - 1 + 1 - 2 - 3 = -4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,-10,9,1], limit = 100, goal = 0
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= limit <= 106
 * -limit <= nums[i] <= limit
 * -109 <= goal <= 109
 */
public class Code14 {

    public int minElements(int[] nums, int limit, int goal) {
        //求和
        long sum = Arrays.stream(nums).boxed().mapToLong(Integer::longValue).sum();
        //如果是
        if (sum == goal) {
            //过
            return 0;
        }
        //需要的值
        long other = Math.abs((long) goal - sum);
        //计算所需
        long count = other / limit + (other % limit == 0 ? 0 : 1);
        //返回
        return (int) count;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().minElements(new int[]{1, -1, 1}, 3, -4));
    }

}
