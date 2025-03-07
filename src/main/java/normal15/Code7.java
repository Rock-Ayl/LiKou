package normal15;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-07-23
 * 945. 使数组唯一的最小增量
 * 给你一个整数数组 nums 。每次 move 操作将会选择任意一个满足 0 <= i < nums.length 的下标 i，并将 nums[i] 递增 1。
 * <p>
 * 返回使 nums 中的每个值都变成唯一的所需要的最少操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 * <p>
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Code7 {

    public int minIncrementForUnique(int[] nums) {
        //排序
        Arrays.sort(nums);
        //初始化结果
        int count = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //左右
            int left = nums[i - 1];
            int right = nums[i];
            //如果不需要
            if (right > left) {
                //过
                continue;
            }
            //目标值
            int target = left + 1;
            //叠加二者差
            count += target - right;
            //记录目标值
            nums[i] = target;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }

}
