package normal55;

/**
 * 2905. 找出满足差值条件的下标 II
 * 算术评级: 6
 * 第 367 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1764
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、长度为 n 的整数数组 nums ，以及整数 indexDifference 和整数 valueDifference 。
 * <p>
 * 你的任务是从范围 [0, n - 1] 内找出  2 个满足下述所有条件的下标 i 和 j ：
 * <p>
 * abs(i - j) >= indexDifference 且
 * abs(nums[i] - nums[j]) >= valueDifference
 * 返回整数数组 answer。如果存在满足题目要求的两个下标，则 answer = [i, j] ；否则，answer = [-1, -1] 。如果存在多组可供选择的下标对，只需要返回其中任意一组即可。
 * <p>
 * 注意：i 和 j 可能 相等 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,1,4,1], indexDifference = 2, valueDifference = 4
 * 输出：[0,3]
 * 解释：在示例中，可以选择 i = 0 和 j = 3 。
 * abs(0 - 3) >= 2 且 abs(nums[0] - nums[3]) >= 4 。
 * 因此，[0,3] 是一个符合题目要求的答案。
 * [3,0] 也是符合题目要求的答案。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1], indexDifference = 0, valueDifference = 0
 * 输出：[0,0]
 * 解释：
 * 在示例中，可以选择 i = 0 和 j = 0 。
 * abs(0 - 0) >= 0 且 abs(nums[0] - nums[0]) >= 0 。
 * 因此，[0,0] 是一个符合题目要求的答案。
 * [0,1]、[1,0] 和 [1,1] 也是符合题目要求的答案。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3], indexDifference = 2, valueDifference = 4
 * 输出：[-1,-1]
 * 解释：在示例中，可以证明无法找出 2 个满足所有条件的下标。
 * 因此，返回 [-1,-1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 105
 * 0 <= nums[i] <= 109
 * 0 <= indexDifference <= 105
 * 0 <= valueDifference <= 109
 */
public class Code6 {

    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {

        /**
         * 构建数组
         */

        //最大、最小数组
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];
        //初始化第一个
        minArr[minArr.length - 1] = minArr.length - 1;
        maxArr[maxArr.length - 1] = minArr.length - 1;
        //循环
        for (int i = nums.length - 2; i >= 0; i--) {
            //如果当前数字更小
            if (nums[i] < nums[maxArr[i + 1]]) {
                //使用之前的
                maxArr[i] = maxArr[i + 1];
            } else {
                //否则，更新为当前索引
                maxArr[i] = i;
            }
            //如果当前数字更大
            if (nums[i] > nums[minArr[i + 1]]) {
                //使用之前的
                minArr[i] = minArr[i + 1];
            } else {
                //否则，更新为当前索引
                minArr[i] = i;
            }
        }

        /**
         * 计算
         */

        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //计算右边索引
            int rightIndex = i + indexDifference;
            //如果越界
            if (rightIndex >= nums.length) {
                //跳出
                break;
            }
            //如果满足
            if (Math.abs(num - nums[minArr[rightIndex]]) >= valueDifference) {
                //返回
                return new int[]{i, minArr[rightIndex]};
            }
            //如果满足
            if (Math.abs(num - nums[maxArr[rightIndex]]) >= valueDifference) {
                //返回
                return new int[]{i, maxArr[rightIndex]};
            }
        }
        //默认
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        int[] indices = new Code6().findIndices(new int[]{5, 1, 4, 1}, 2, 4);
        System.out.println();
    }

}
