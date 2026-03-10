package normal51;

import java.util.Arrays;

/**
 * 416. 分割等和子集
 * 尝试过
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,11,5]
 * 输出：true
 * 解释：数组可以分割成 [1, 5, 5] 和 [11] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,5]
 * 输出：false
 * 解释：数组不能分割成两个元素和相等的子集。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 */
public class Code6 {

    public boolean canPartition(int[] nums) {

        /**
         * 特殊判定
         */

        //求和
        int sum = Arrays.stream(nums).sum();
        //如果是奇数
        if (sum % 2 != 0) {
            //不行
            return false;
        }

        /**
         * 01背包问题
         */

        //目标和
        int target = sum / 2;
        //目标数组
        int[] targetArr = new int[target + 1];
        //0的情况
        targetArr[0] = 1;
        //循环所有数字
        for (int i = 0; i < nums.length; i++) {

            /**
             * 当前情况计算结果
             */

            //当前数字
            int num = nums[i];
            //对应key
            int key = i + 2;
            //循环2
            for (int j = targetArr.length - 1; j >= 0; j--) {
                //如果是0
                if (targetArr[j] == 0 || targetArr[j] == key) {
                    //本轮过
                    continue;
                }
                //下一个位置
                int next = j + num;
                //如果满足
                if (next < targetArr.length) {
                    //记录
                    targetArr[next] = key;
                }
            }

            /**
             * 这个数字之后的判断结果
             */

            //如果满足了
            if (targetArr[targetArr.length - 1] != 0) {
                //返回
                return true;
            }
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        //System.out.println(new Code6().canPartition(new int[]{1, 5, 11, 5}));
        System.out.println(new Code6().canPartition(new int[]{1, 1, 1, 1}));
    }

}
