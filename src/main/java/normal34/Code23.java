package normal34;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2024-09-07
 * 2789. 合并后数组中的最大元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、由正整数组成的数组 nums 。
 * <p>
 * 你可以在数组上执行下述操作 任意 次：
 * <p>
 * 选中一个同时满足 0 <= i < nums.length - 1 和 nums[i] <= nums[i + 1] 的整数 i 。将元素 nums[i + 1] 替换为 nums[i] + nums[i + 1] ，并从数组中删除元素 nums[i] 。
 * 返回你可以从最终数组中获得的 最大 元素的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,7,9,3]
 * 输出：21
 * 解释：我们可以在数组上执行下述操作：
 * - 选中 i = 0 ，得到数组 nums = [5,7,9,3] 。
 * - 选中 i = 1 ，得到数组 nums = [5,16,3] 。
 * - 选中 i = 0 ，得到数组 nums = [21,3] 。
 * 最终数组中的最大元素是 21 。可以证明我们无法获得更大的元素。
 * 示例 2：
 * <p>
 * 输入：nums = [5,3,3]
 * 输出：11
 * 解释：我们可以在数组上执行下述操作：
 * - 选中 i = 1 ，得到数组 nums = [5,6] 。
 * - 选中 i = 0 ，得到数组 nums = [11] 。
 * 最终数组中只有一个元素，即 11 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code23 {

    public long maxArrayValue(int[] nums) {
        //缓存
        Stack<Long> stack = new Stack<>();
        //循环
        for (int i = nums.length - 1; i >= 0; i--) {
            //获取数字
            long num = nums[i];
            //如果满足合并条件
            if (stack.isEmpty() == false && stack.peek().compareTo(num) >= 0) {
                //求和,放进去
                stack.push(stack.pop() + num);
            } else {
                //默认直接加入
                stack.push(num);
            }
        }
        //返回最大值
        return stack.stream().mapToLong(Long::longValue).max().getAsLong();
    }

    public static void main(String[] args) {
        System.out.println(new Code23().maxArrayValue(new int[]{2, 3, 7, 9, 3}));
    }
}
