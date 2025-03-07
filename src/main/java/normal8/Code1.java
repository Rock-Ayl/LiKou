package normal8;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-09-13
 * 581. 最短无序连续子数组
 * 给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * <p>
 * 请你找出符合题意的 最短 子数组，并输出它的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,6,4,8,10,9,15]
 * 输出：5
 * 解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -105 <= nums[i] <= 105
 * <p>
 * <p>
 * 进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 */
public class Code1 {

    public int findUnsortedSubarray(int[] nums) {
        //克隆
        int[] sortNums = nums.clone();
        //排序
        Arrays.sort(sortNums);
        //如果相等
        if (Arrays.equals(sortNums, nums)) {
            //返回
            return 0;
        }
        //左右
        int left = 0, right = nums.length - 1;
        //循环
        while (left < nums.length) {
            //如果找到不同了
            if (sortNums[left] != nums[left]) {
                //结束
                break;
            }
            //下一个
            left++;
        }
        //循环
        while (right >= 0) {
            //如果找到不同了
            if (sortNums[right] != nums[right]) {
                //结束
                break;
            }
            //下一个
            right--;
        }
        //返回
        return right - left + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
