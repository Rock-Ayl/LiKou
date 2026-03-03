package normal51;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 3371. 识别数组中的最大异常值
 * 算术评级: 4
 * 第 426 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1644
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。该数组包含 n 个元素，其中 恰好 有 n - 2 个元素是 特殊数字 。剩下的 两个 元素中，一个是所有 特殊数字 的 和 ，另一个是 异常值 。
 * <p>
 * 异常值 的定义是：既不是原始特殊数字之一，也不是表示元素和的那个数。
 * <p>
 * 注意，特殊数字、和 以及 异常值 的下标必须 不同 ，但可以共享 相同 的值。
 * <p>
 * 返回 nums 中可能的 最大异常值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [2,3,5,10]
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 特殊数字可以是 2 和 3，因此和为 5，异常值为 10。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [-2,-1,-3,-6,4]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 特殊数字可以是 -2、-1 和 -3，因此和为 -6，异常值为 4。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,1,1,1,1,5,5]
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 特殊数字可以是 1、1、1、1 和 1，因此和为 5，另一个 5 为异常值。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * -1000 <= nums[i] <= 1000
 * 输入保证 nums 中至少存在 一个 可能的异常值。
 */
public class Code2 {

    public int getLargestOutlier(int[] nums) {

        /**
         * 排序
         */

        //排序
        Arrays.sort(nums);

        /**
         * 前缀和 & 计数器
         */

        //计数器
        Map<Integer, Integer> countMap = new HashMap<>();
        //前缀和
        int[] sumArr = new int[nums.length];
        //第一个前缀和
        sumArr[0] = nums[0];
        //计数器+1
        countMap.put(nums[0], 1);
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //计算前缀和
            sumArr[i] = sumArr[i - 1] + nums[i];
            //计数器+1
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }

        /**
         * 计算
         */

        //所有值的和
        int sum = sumArr[nums.length - 1];
        //循环,从大到小
        for (int i = nums.length - 1; i >= 0; i--) {

            //当前异常值
            int num = nums[i];
            //抛出异常值的和
            int sum2 = sum - num;
            //目标数字
            int target = sum2 / 2;

            //暂时删除异常值
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) - 1);
            //如果不是偶数
            if (sum2 % 2 != 0) {
                //回滚
                countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
                //本轮过,肯定不行
                continue;
            }
            //如果还有目标数字
            if (countMap.getOrDefault(target, 0) > 0) {
                //找到异常值
                return num;
            }
            //回滚
            countMap.put(nums[i], countMap.getOrDefault(nums[i], 0) + 1);
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        //System.out.println(new Code2().getLargestOutlier(new int[]{-108, -108, -517}));
        //System.out.println(new Code2().getLargestOutlier(new int[]{963, -626, 963}));
        System.out.println(new Code2().getLargestOutlier(new int[]{-947, -326, 200, -747}));
    }

}
