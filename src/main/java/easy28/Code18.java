package easy28;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-03-04
 * 1005. K 次取反后最大化的数组和
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,2,3], k = 1
 * 输出：5
 * 解释：选择下标 1 ，nums 变为 [4,-2,3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,-1,0,2], k = 3
 * 输出：6
 * 解释：选择下标 (1, 2, 2) ，nums 变为 [3,1,0,2] 。
 * 示例 3：
 * <p>
 * 输入：nums = [2,-3,-1,5,-4], k = 2
 * 输出：13
 * 解释：选择下标 (1, 4) ，nums 变为 [2,3,-1,5,4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -100 <= nums[i] <= 100
 * 1 <= k <= 104
 */
public class Code18 {

    public int largestSumAfterKNegations(int[] nums, int k) {
        //排序
        Arrays.sort(nums);
        //指针
        int p = 0;
        //循环
        while (k > 0 && p < nums.length && nums[p] < 0) {
            //变为正数
            nums[p] = Math.abs(nums[p]);
            //记录
            k--;
            p++;
        }
        //计算余数
        k = k % 2;
        //如果没有了
        if (k == 0) {
            //返回结果 和
            return Arrays.stream(nums).sum();
        } else {
            //返回结果 和删除最小的元素
            return Arrays.stream(nums).sum() - Math.min(nums[Math.max(0, p - 1)], nums[Math.min(p, nums.length - 1)]) * 2;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code18().largestSumAfterKNegations(new int[]{-8, 3, -5, -3, -5, -2}, 6));
    }

}
