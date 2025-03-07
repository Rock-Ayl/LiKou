package easy28;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-02-27
 * 6369. 左右元素和的差值
 * 给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
 * <p>
 * answer.length == nums.length
 * answer[i] = |leftSum[i] - rightSum[i]|
 * 其中：
 * <p>
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回数组 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,4,8,3]
 * 输出：[15,1,11,22]
 * 解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
 * 数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：[0]
 * 解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
 * 数组 answer 为 [|0 - 0|] = [0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 */
public class Code16 {

    public int[] leftRigthDifference(int[] nums) {
        //初始化结果
        int[] result = new int[nums.length];
        //左右之和
        int leftSum = 0;
        int rightSum = Arrays.stream(nums).sum();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果需要平衡左边
            if (i > 0) {
                //左边+
                leftSum += nums[i - 1];
            }
            //右边减
            rightSum -= nums[i];
            //当前坐标的结果
            result[i] = Math.abs(leftSum - rightSum);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new Code16().leftRigthDifference(new int[]{10, 4, 8, 3});
        System.out.println();
    }

}
