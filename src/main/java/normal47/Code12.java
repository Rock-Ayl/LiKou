package normal47;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-10-27
 * 3727. 最大交替平方和
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。你可以以任意顺序 重新排列元素 。
 * <p>
 * 数组 arr 的 交替得分 定义为：
 * <p>
 * score = arr[0]2 - arr[1]2 + arr[2]2 - arr[3]2 + ...
 * 在对 nums 重新排列后，返回其 最大可能的交替得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3]
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * nums 的一种可行重排为 [2,1,3]，该排列在所有可能重排中给出了最大交替得分。
 * <p>
 * 交替得分计算如下：
 * <p>
 * score = 22 - 12 + 32 = 4 - 1 + 9 = 12
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,-1,2,-2,3,-3]
 * <p>
 * 输出： 16
 * <p>
 * 解释：
 * <p>
 * nums 的一种可行重排为 [-3,-1,-2,1,3,2]，该排列在所有可能重排中给出了最大交替得分。
 * <p>
 * 交替得分计算如下：
 * <p>
 * score = (-3)2 - (-1)2 + (-2)2 - (1)2 + (3)2 - (2)2 = 9 - 1 + 4 - 1 + 9 - 4 = 16
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -4 * 104 <= nums[i] <= 4 * 104
 */
public class Code12 {

    public long maxAlternatingSum(int[] nums) {
        //循环
        for (int i = 0; i < nums.length; i++) {
            //平方
            nums[i] = nums[i] * nums[i];
        }
        //排序
        Arrays.sort(nums);
        //索引
        int left = 0;
        int right = nums.length - 1;
        //结果
        long result = 0L;
        //方向
        boolean point = true;
        //循环
        while (left <= right) {
            //如果是正方向
            if (point == true) {
                //叠加
                result += nums[right--];
            } else {
                //叠加
                result -= nums[left++];
            }
            //下一个方向
            point = !point;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxAlternatingSum(new int[]{1, -1, 2, -2, 3, -3}));
    }

}
