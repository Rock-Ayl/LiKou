package easy;

import java.util.*;

/**
 * Created By Rock-Ayl on 2020-08-29
 * 1365. 有多少小于当前数字的数字
 * 给你一个数组 nums，对于其中每个元素 nums[i]，请你统计数组中比它小的所有数字的数目。
 * <p>
 * 换而言之，对于每个 nums[i] 你必须计算出有效的 j 的数量，其中 j 满足 j != i 且 nums[j] < nums[i] 。
 * <p>
 * 以数组形式返回答案。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,1,2,2,3]
 * 输出：[4,0,1,1,3]
 * 解释：
 * 对于 nums[0]=8 存在四个比它小的数字：（1，2，2 和 3）。
 * 对于 nums[1]=1 不存在比它小的数字。
 * 对于 nums[2]=2 存在一个比它小的数字：（1）。
 * 对于 nums[3]=2 存在一个比它小的数字：（1）。
 * 对于 nums[4]=3 存在三个比它小的数字：（1，2 和 2）。
 * 示例 2：
 * <p>
 * 输入：nums = [6,5,4,8]
 * 输出：[2,1,0,3]
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7]
 * 输出：[0,0,0,0]
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 500
 * 0 <= nums[i] <= 100
 */
public class Code21 {

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        //初始化返回值
        int[] result = new int[nums.length];
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //大
            int sum = 0;
            //循环2
            for (int y : nums) {
                //如果大
                if (nums[i] > y) {
                    //叠加
                    sum++;
                }
            }
            //记录
            result[i] = sum;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})) {
            System.out.println(i);
        }
    }

}
