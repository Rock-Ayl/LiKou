package normal6;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-08-06
 * 1887. 使数组元素相等的减少操作次数
 * 给你一个整数数组 nums ，你的目标是令 nums 中的所有元素相等。完成一次减少操作需要遵照下面的几个步骤：
 * <p>
 * 找出 nums 中的 最大 值。记这个值为 largest 并取其下标 i （下标从 0 开始计数）。如果有多个元素都是最大值，则取最小的 i 。
 * 找出 nums 中的 下一个最大 值，这个值 严格小于 largest ，记为 nextLargest 。
 * 将 nums[i] 减少到 nextLargest 。
 * 返回使 nums 中的所有元素相等的操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,1,3]
 * 输出：3
 * 解释：需要 3 次操作使 nums 中的所有元素相等：
 * 1. largest = 5 下标为 0 。nextLargest = 3 。将 nums[0] 减少到 3 。nums = [3,1,3] 。
 * 2. largest = 3 下标为 0 。nextLargest = 1 。将 nums[0] 减少到 1 。nums = [1,1,3] 。
 * 3. largest = 3 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 * 解释：nums 中的所有元素已经是相等的。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,2,2,3]
 * 输出：4
 * 解释：需要 4 次操作使 nums 中的所有元素相等：
 * 1. largest = 3 下标为 4 。nextLargest = 2 。将 nums[4] 减少到 2 。nums = [1,1,2,2,2] 。
 * 2. largest = 2 下标为 2 。nextLargest = 1 。将 nums[2] 减少到 1 。nums = [1,1,1,2,2] 。
 * 3. largest = 2 下标为 3 。nextLargest = 1 。将 nums[3] 减少到 1 。nums = [1,1,1,1,2] 。
 * 4. largest = 2 下标为 4 。nextLargest = 1 。将 nums[4] 减少到 1 。nums = [1,1,1,1,1] 。
 */
public class Code3 {

    public int reductionOperations(int[] nums) {
        //结果
        int result = 0;
        //排序
        Arrays.sort(nums);
        //当前数
        int last = nums[0];
        //叠加器
        int add = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前值
            int num = nums[i];
            //如果不相同
            if (num != last) {
                //+1
                add++;
                //刷新
                last = num;
            }
            //直接叠加
            result += add;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().reductionOperations(new int[]{5, 1, 3}));
    }

}
