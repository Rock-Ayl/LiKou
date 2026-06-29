package normal54;

import java.util.Arrays;

/**
 * 3974. K 个元素的最大总和
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，以及两个整数 k 和 mul。
 * <p>
 * 从 nums 中选出 恰好 k 个元素。你可以按照任意顺序逐个处理这些元素。
 * <p>
 * 对于每个被选择的元素，都可以 独立地 选择以下两种操作之一：
 * <p>
 * 将该元素的值 加 到总和中；或
 * 将该元素乘以 mul 的 当前 值，并将结果 加 到总和中。
 * 每处理一个被选择的元素后，无论选择哪种操作，mul 都会 减少 1。mul 的当前值可能变为 0 或负数。
 * <p>
 * 返回一个整数，表示可能得到的 最大 总和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [6,1,2,9], k = 3, mul = 2
 * <p>
 * 输出： 26
 * <p>
 * 解释：
 * <p>
 * 一种最优方式如下：
 * <p>
 * 一种最优选择是 nums[3] = 9、nums[0] = 6 和 nums[2] = 2。
 * 先处理 nums[3] = 9：选择乘法，因此贡献 9 * 2 = 18。此时，mul 变为 1。
 * 接着处理 nums[0] = 6：选择乘法，因此贡献 6 * 1 = 6。此时，mul 变为 0。
 * 最后处理 nums[2] = 2：选择直接相加，因此贡献 2。
 * 总和为 18 + 6 + 2 = 26。
 * 示例 2：
 * <p>
 * 输入： nums = [3,7,5,2], k = 2, mul = 4
 * <p>
 * 输出： 43
 * <p>
 * 解释：
 * <p>
 * 一种最优方式如下：
 * <p>
 * 一种最优选择是 nums[1] = 7 和 nums[2] = 5。
 * 先处理 nums[1] = 7：选择乘法，因此贡献 7 * 4 = 28。此时，mul 变为 3。
 * 接着处理 nums[2] = 5：选择乘法，因此贡献 5 * 3 = 15。
 * 总和为 28 + 15 = 43。
 * 示例 3：
 * <p>
 * 输入： nums = [4,4], k = 1, mul = 1
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 一种最优方式如下：
 * <p>
 * 一种最优选择是 nums[0] = 4。
 * 处理 nums[0] = 4：选择乘法，因此贡献 4 * 1 = 4。
 * 总和为 4。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= nums.length
 * 1 <= mul <= 105
 */
public class Code20 {

    public long maxSum(int[] nums, int k, int mul) {
        //排序
        Arrays.sort(nums);
        //索引
        int index = nums.length - 1;
        //结果
        long sum = 0L;
        //循环
        while (k-- > 0) {
            //当前数字,-1
            long num = nums[index--];
            //如果有
            if (mul > 1) {
                //计算
                sum += num * mul--;
            } else {
                //直接叠加
                sum += num;
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().maxSum(new int[]{6,1,2,9}, 3, 2));
    }

}
