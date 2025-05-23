package normal9;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-01-10
 * 16. 最接近的三数之和
 * 给你一个长度为 n 的整数数组 nums 和 一个目标值 target。请你从 nums 中选出三个整数，使它们的和与 target 最接近。
 * <p>
 * 返回这三个数的和。
 * <p>
 * 假定每组输入只存在恰好一个解。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,0,0], target = 1
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 1000
 * -1000 <= nums[i] <= 1000
 * -104 <= target <= 104
 */
public class Code15 {

    public int star(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int best = 10000000;

        // 枚举 a
        for (int i = 0; i < n; ++i) {
            // 保证和上一次枚举的元素不相等
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            // 使用双指针枚举 b 和 c
            int j = i + 1, k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 如果和为 target 直接返回答案
                if (sum == target) {
                    return target;
                }
                // 根据差值的绝对值来更新答案
                if (Math.abs(sum - target) < Math.abs(best - target)) {
                    best = sum;
                }
                if (sum > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = k - 1;
                    // 移动到下一个不相等的元素
                    while (j < k0 && nums[k0] == nums[k]) {
                        --k0;
                    }
                    k = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = j + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < k && nums[j0] == nums[j]) {
                        ++j0;
                    }
                    j = j0;
                }
            }
        }
        return best;
    }

    public int threeSumClosest(int[] nums, int target) {
        //结果值
        int minNum = Integer.MAX_VALUE;
        //结果距离
        int min = Integer.MAX_VALUE;
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //第一个数
            int one = nums[i];
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //1+2
                int twoSum = one + nums[j];
                //循环
                for (int k = j + 1; k < nums.length; k++) {
                    //1+2+3
                    int threeSum = twoSum + nums[k];
                    //对比目标距离
                    int abc = Math.abs(target - threeSum);
                    //如果更近
                    if (abc < min) {
                        //刷新
                        min = abc;
                        minNum = threeSum;
                    }

                }
            }
        }
        //返回
        return minNum;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().star(new int[]{-1, 2, 1, -4}, 1));
    }
}
