package easy38;

/**
 * @Author ayl
 * @Date 2024-08-25
 * 3264. K 次乘运算后的最终数组 I
 * 简单
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，一个整数 k  和一个整数 multiplier 。
 * <p>
 * 你需要对 nums 执行 k 次操作，每次操作中：
 * <p>
 * 找到 nums 中的 最小 值 x ，如果存在多个最小值，选择最 前面 的一个。
 * 将 x 替换为 x * multiplier 。
 * 请你返回执行完 k 次乘运算之后，最终的 nums 数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,5,6], k = 5, multiplier = 2
 * <p>
 * 输出：[8,4,6,5,6]
 * <p>
 * 解释：
 * <p>
 * 操作	结果
 * 1 次操作后	[2, 2, 3, 5, 6]
 * 2 次操作后	[4, 2, 3, 5, 6]
 * 3 次操作后	[4, 4, 3, 5, 6]
 * 4 次操作后	[4, 4, 6, 5, 6]
 * 5 次操作后	[8, 4, 6, 5, 6]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], k = 3, multiplier = 4
 * <p>
 * 输出：[16,8]
 * <p>
 * 解释：
 * <p>
 * 操作	结果
 * 1 次操作后	[4, 2]
 * 2 次操作后	[4, 8]
 * 3 次操作后	[16, 8]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 10
 * 1 <= multiplier <= 5
 */
public class Code5 {

    public int[] getFinalState(int[] nums, int k, int multiplier) {
        //循环
        while (k-- > 0) {
            //最小情况
            int minIndex = 0;
            //循环
            for (int i = 1; i < nums.length; i++) {
                //如果更小
                if (nums[i] < nums[minIndex]) {
                    //更新
                    minIndex = i;
                }
            }
            //计算
            nums[minIndex] = nums[minIndex] * multiplier;
        }
        //返回
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().getFinalState(new int[]{2, 1, 3, 5, 6}, 5, 2));
    }

}
