package easy33;

/**
 * @Author ayl
 * @Date 2023-10-26
 * 2908. 元素和最小的山形三元组 I
 * 提示
 * 简单
 * 2
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 。
 * <p>
 * 如果下标三元组 (i, j, k) 满足下述全部条件，则认为它是一个 山形三元组 ：
 * <p>
 * i < j < k
 * nums[i] < nums[j] 且 nums[k] < nums[j]
 * 请你找出 nums 中 元素和最小 的山形三元组，并返回其 元素和 。如果不存在满足条件的三元组，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [8,6,1,5,3]
 * 输出：9
 * 解释：三元组 (2, 3, 4) 是一个元素和等于 9 的山形三元组，因为：
 * - 2 < 3 < 4
 * - nums[2] < nums[3] 且 nums[4] < nums[3]
 * 这个三元组的元素和等于 nums[2] + nums[3] + nums[4] = 9 。可以证明不存在元素和小于 9 的山形三元组。
 * 示例 2：
 * <p>
 * 输入：nums = [5,4,8,7,10,2]
 * 输出：13
 * 解释：三元组 (1, 3, 5) 是一个元素和等于 13 的山形三元组，因为：
 * - 1 < 3 < 5
 * - nums[1] < nums[3] 且 nums[5] < nums[3]
 * 这个三元组的元素和等于 nums[1] + nums[3] + nums[5] = 13 。可以证明不存在元素和小于 13 的山形三元组。
 * 示例 3：
 * <p>
 * 输入：nums = [6,5,4,3,4,5]
 * 输出：-1
 * 解释：可以证明 nums 中不存在山形三元组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Code23 {

    public int minimumSum(int[] nums) {
        //最小可能
        int min = Integer.MAX_VALUE;
        //数字
        int num1;
        int num2;
        int num3;
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //数字1
            num1 = nums[i];
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //数字2
                num2 = nums[j];
                //如果不满足 条件1
                if (num2 <= num1) {
                    //本轮过
                    continue;
                }
                //循环3
                for (int k = j + 1; k < nums.length; k++) {
                    //数字3
                    num3 = nums[k];
                    //如果不满足
                    if (num2 <= num3) {
                        //本轮过
                        continue;
                    }
                    //刷新结果
                    min = Math.min(num1 + num2 + num3, min);
                }
            }
        }
        //默认
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().minimumSum(new int[]{5, 4, 8, 7, 10, 2}));
    }

}
