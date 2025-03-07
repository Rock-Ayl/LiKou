package easy38;

/**
 * @Author ayl
 * @Date 2024-10-03
 * 3300. 替换为数位和以后的最小元素
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 请你将 nums 中每一个元素都替换为它的各个数位之 和 。
 * <p>
 * 请你返回替换所有元素以后 nums 中的 最小 元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,12,13,14]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [1, 3, 4, 5] ，最小元素为 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [1, 2, 3, 4] ，最小元素为 1 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [999,19,199]
 * <p>
 * 输出：10
 * <p>
 * 解释：
 * <p>
 * nums 替换后变为 [27, 10, 19] ，最小元素为 10 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 */
public class Code14 {

    public int minElement(int[] nums) {
        //最小值
        int min = Integer.MAX_VALUE;
        //循环
        for (int num : nums) {
            //本次目标值
            int target = 0;
            //循环
            while (num > 0) {
                //叠加本次
                target += num % 10;
                //下一个
                num = num / 10;
            }
            //刷新最小
            min = Math.min(min, target);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {

    }

}
