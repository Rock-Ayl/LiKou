package easy37;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-06-24
 * 3194. 最小元素和最大元素的最小平均值
 * 简单
 * 相关企业
 * 提示
 * 你有一个初始为空的浮点数数组 averages。另给你一个包含 n 个整数的数组 nums，其中 n 为偶数。
 * <p>
 * 你需要重复以下步骤 n / 2 次：
 * <p>
 * 从 nums 中移除 最小 的元素 minElement 和 最大 的元素 maxElement。
 * 将 (minElement + maxElement) / 2 加入到 averages 中。
 * 返回 averages 中的 最小 元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [7,8,3,4,15,13,4,1]
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[7,8,3,4,15,13,4,1]	[]
 * 1	[7,8,3,4,13,4]	[8]
 * 2	[7,8,4,4]	[8,8]
 * 3	[7,4]	[8,8,6]
 * 4	[]	[8,8,6,5.5]
 * 返回 averages 中最小的元素，即 5.5。
 * 示例 2：
 * <p>
 * 输入： nums = [1,9,8,3,10,5]
 * <p>
 * 输出： 5.5
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[1,9,8,3,10,5]	[]
 * 1	[9,8,3,5]	[5.5]
 * 2	[8,5]	[5.5,6]
 * 3	[]	[5.5,6,6.5]
 * 示例 3：
 * <p>
 * 输入： nums = [1,2,3,7,8,9]
 * <p>
 * 输出： 5.0
 * <p>
 * 解释：
 * <p>
 * 步骤	nums	averages
 * 0	[1,2,3,7,8,9]	[]
 * 1	[2,3,7,8]	[5]
 * 2	[3,7]	[5,5]
 * 3	[]	[5,5,5]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n == nums.length <= 50
 * n 为偶数。
 * 1 <= nums[i] <= 50
 */
public class Code14 {

    public double minimumAverage(int[] nums) {
        //排序
        Arrays.sort(nums);
        //结果
        double min = Double.MAX_VALUE;
        //左右坐标
        int left = 0;
        int right = nums.length - 1;
        //循环
        while (left < right) {
            //刷新最小值
            min = Math.min(((double) (nums[left++] + nums[right--])) / 2D, min);
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().minimumAverage(new int[]{7, 8, 3, 4, 15, 13, 4, 1}));
    }

}
