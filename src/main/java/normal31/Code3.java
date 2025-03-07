package normal31;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-04-21
 * 300. 最长递增子序列
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的
 * 子序列
 * 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class Code3 {

    public int lengthOfLIS(int[] nums) {
        //动态规划
        int[] arr = new int[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //数字
            int num = nums[i];
            //默认当前情况是1,即它自己身
            arr[i] = 1;
            //循环
            for (int j = 0; j < i; j++) {
                //当前数字
                int num2 = nums[j];
                //如果不满足递增
                if (num2 >= num) {
                    //本轮过
                    continue;
                }
                //刷新最大情况
                arr[i] = Math.max(arr[i], arr[j] + 1);
            }
        }
        //返回最大情况
        return Arrays.stream(arr).max().getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Code3().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
