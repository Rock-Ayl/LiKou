package normal3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Created By Rock-Ayl on 2021-05-08
 * 137. 只出现一次的数字 II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class Code16 {

    public int singleNumber(int[] nums) {
        //如果只有1
        if (nums.length == 1) {
            //返回
            return nums[0];
        }
        //排个序
        Arrays.sort(nums);
        //对比开始
        if (nums[0] != nums[1]) {
            //返回
            return nums[0];
        }
        //对比结尾
        if (nums[nums.length - 1] != nums[nums.length - 2]) {
            //返回
            return nums[nums.length - 1];
        }
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //如果不等于左右
            if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]) {
                //返回
                return nums[i];
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().singleNumber(new int[]{2, 2, 3, 2}));
    }

}
