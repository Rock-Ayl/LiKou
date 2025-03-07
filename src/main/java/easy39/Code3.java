package easy39;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-12-13
 * 3354. 使数组元素等于零
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 开始时，选择一个满足 nums[curr] == 0 的起始位置 curr ，并选择一个移动 方向 ：向左或者向右。
 * <p>
 * 此后，你需要重复下面的过程：
 * <p>
 * 如果 curr 超过范围 [0, n - 1] ，过程结束。
 * 如果 nums[curr] == 0 ，沿当前方向继续移动：如果向右移，则 递增 curr ；如果向左移，则 递减 curr 。
 * 如果 nums[curr] > 0:
 * 将 nums[curr] 减 1 。
 * 反转 移动方向（向左变向右，反之亦然）。
 * 沿新方向移动一步。
 * 如果在结束整个过程后，nums 中的所有元素都变为 0 ，则认为选出的初始位置和移动方向 有效 。
 * <p>
 * 返回可能的有效选择方案数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,0,2,0,3]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 可能的有效选择方案如下：
 * <p>
 * 选择 curr = 3 并向左移动。
 * [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,0].
 * 选择 curr = 3 并向右移动。
 * [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0].
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,4,0,4,1,0]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 不存在有效的选择方案。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 至少存在一个元素 i 满足 nums[i] == 0 。
 */
public class Code3 {

    public int countValidSelections(int[] nums) {
        //目标结果
        int result = 0;
        //和
        int sum = Arrays.stream(nums).sum();
        //左边和
        int leftSum = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果不是0
            if (nums[i] != 0) {
                //记录和
                leftSum += nums[i];
            } else {
                //叠加结果
                result += (leftSum * 2 == sum ? 2 : 0);
                result += (Math.abs(sum - leftSum - leftSum) == 1 ? 1 : 0);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().countValidSelections(new int[]{16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7}));
    }

}
