package normal29;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-02-23
 * 给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。
 * <p>
 * 你可以假设所有输入数组都可以得到满足题目要求的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,1,1,6,4]
 * 输出：[1,6,1,5,1,4]
 * 解释：[1,4,1,5,1,6] 同样是符合题目要求的结果，可以被判题程序接受。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,2,3,1]
 * 输出：[2,3,1,3,1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 104
 * 0 <= nums[i] <= 5000
 * 题目数据保证，对于给定的输入 nums ，总能产生满足题目要求的结果
 * <p>
 * <p>
 * 进阶：你能用 O(n) 时间复杂度和 / 或原地 O(1) 额外空间来实现吗？
 */
public class Code8 {

    public void wiggleSort(int[] nums) {
        //先排序
        Arrays.sort(nums);
        //分割为两半,如果多一个,则放在左边
        int[] left = Arrays.copyOfRange(nums, 0, nums.length / 2 + nums.length % 2);
        int[] right = Arrays.copyOfRange(nums, nums.length / 2 + nums.length % 2, nums.length);
        //三个指针
        int p1 = 0;
        int p2 = left.length - 1;
        int p3 = right.length - 1;
        //循环
        while (p1 < nums.length) {
            //判断奇偶
            if (p1 % 2 == 0) {
                //使用左边
                nums[p1++] = left[p2--];
            } else {
                //使用右边
                nums[p1++] = right[p3--];
            }
        }
    }

    public static void main(String[] args) {
        new Code8().wiggleSort(new int[]{1, 5, 1, 1, 6, 4, 1});
    }

}
