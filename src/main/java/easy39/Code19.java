package easy39;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-02-12
 * 3432. 统计元素和差值为偶数的分区方案
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 。
 * <p>
 * 分区 是指将数组按照下标 i （0 <= i < n - 1）划分成两个 非空 子数组，其中：
 * <p>
 * 左子数组包含区间 [0, i] 内的所有下标。
 * 右子数组包含区间 [i + 1, n - 1] 内的所有下标。
 * 对左子数组和右子数组先求元素 和 再做 差 ，统计并返回差值为 偶数 的 分区 方案数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,10,3,7,6]
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * <p>
 * 共有 4 个满足题意的分区方案：
 * <p>
 * [10]、[10, 3, 7, 6] 元素和的差值为 10 - 26 = -16 ，是偶数。
 * [10, 10]、[3, 7, 6] 元素和的差值为 20 - 16 = 4，是偶数。
 * [10, 10, 3]、[7, 6] 元素和的差值为 23 - 13 = 10，是偶数。
 * [10, 10, 3, 7]、[6] 元素和的差值为 30 - 6 = 24，是偶数。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 不存在元素和的差值为偶数的分区方案。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [2,4,6,8]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 所有分区方案都满足元素和的差值为偶数。
 */
public class Code19 {

    public int countPartitions(int[] nums) {
        //滑动
        int right = Arrays.stream(nums).sum();
        int left = 0;
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < nums.length - 1; i++) {
            //清算
            left += nums[i];
            right -= nums[i];
            //如果是偶数
            if ((right - left) % 2 == 0) {
                //+1
                result++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().countPartitions(new int[]{10, 10, 3, 7, 6}));
    }

}
