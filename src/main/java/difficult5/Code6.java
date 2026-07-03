package difficult5;

/**
 * 3229. 使数组等于目标数组所需的最少操作次数
 * 算术评级: 7
 * 第 407 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2067
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个长度相同的正整数数组 nums 和 target。
 * <p>
 * 在一次操作中，你可以选择 nums 的任何子数组，并将该子数组内的每个元素的值增加或减少 1。
 * <p>
 * 返回使 nums 数组变为 target 数组所需的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,5,1,2], target = [4,6,2,4]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 执行以下操作可以使 nums 等于 target：
 * - nums[0..3] 增加 1，nums = [4,6,2,3]。
 * - nums[3..3] 增加 1，nums = [4,6,2,4]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,3,2], target = [2,1,4]
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 执行以下操作可以使 nums 等于 target：
 * - nums[0..0] 增加 1，nums = [2,3,2]。
 * - nums[1..1] 减少 1，nums = [2,2,2]。
 * - nums[1..1] 减少 1，nums = [2,1,2]。
 * - nums[2..2] 增加 1，nums = [2,1,3]。
 * - nums[2..2] 增加 1，nums = [2,1,4]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length == target.length <= 105
 * 1 <= nums[i], target[i] <= 108
 */
public class Code6 {

    public long minimumOperations(int[] nums, int[] target) {

        /**
         * 计算每个位置要增加减少的操作次数
         */

        //每个位置要增加的多少
        int[] addArr = new int[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //计算
            addArr[i] = target[i] - nums[i];
        }

        /**
         * 计算结果
         */

        //操作次数,默认第一个操作位置
        long result = Math.abs(addArr[0]);
        //判断是否为正数
        boolean add = addArr[0] >= 0;
        //上一个操作位置的大小
        int last = addArr[0];
        //循环
        for (int i = 1; i < addArr.length; i++) {
            //如果与上一个相同
            if (addArr[i] == last) {
                //本轮过
                continue;
            }
            //如果 一个正数、一个负数
            if (last >= 0 && addArr[i] < 0 || last < 0 && addArr[i] >= 0) {
                //交换
                add = !add;
                last = addArr[i];
                //叠加,本次
                result += Math.abs(addArr[i]);
                //本轮过
                continue;
            }
            //如果都是正数
            if (add == true) {
                //如果新的更大
                if (addArr[i] > last) {
                    //叠加,本次
                    result += addArr[i] - last;
                    //更新更大
                    last = addArr[i];
                } else {
                    //削减
                    last = addArr[i];
                }
            } else {
                //如果新的更小
                if (addArr[i] < last) {
                    //叠加,本次
                    result += last - addArr[i];
                    //更新更小
                    last = addArr[i];
                } else {
                    //削减
                    last = addArr[i];
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().minimumOperations(new int[]{9, 2, 6, 10, 4, 8, 3, 4, 2, 3}, new int[]{9, 5, 5, 1, 7, 9, 8, 7, 6, 5}));
    }

}
