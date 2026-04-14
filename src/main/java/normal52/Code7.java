package normal52;

import java.util.HashMap;
import java.util.Map;

/**
 * 2537. 统计好子数组的数目
 * 算术评级: 6
 * 第 328 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1892
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你返回 nums 中 好 子数组的数目。
 * <p>
 * 一个子数组 arr 如果有 至少 k 对下标 (i, j) 满足 i < j 且 arr[i] == arr[j] ，那么称它是一个 好 子数组。
 * <p>
 * 子数组 是原数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,1,1,1], k = 10
 * 输出：1
 * 解释：唯一的好子数组是这个数组本身。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,4,3,2,2,4], k = 2
 * 输出：4
 * 解释：总共有 4 个不同的好子数组：
 * - [3,1,4,3,2,2] 有 2 对。
 * - [3,1,4,3,2,2,4] 有 3 对。
 * - [1,4,3,2,2,4] 有 2 对。
 * - [4,3,2,2,4] 有 2 对。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i], k <= 109
 */
public class Code7 {

    public long countGood(int[] nums, int k) {
        //双指针
        int left = 0;
        int right = 0;
        //结果
        long result = 0;
        //计数器
        Map<Integer, Integer> countMap = new HashMap<>();
        //初始化第一个
        countMap.put(nums[left], 1);
        //当前数量
        long count = 0L;
        //循环
        while (left < nums.length) {

            /**
             * 右滑N次
             */

            //如果不够
            while (right + 1 < nums.length && count < k) {
                //当前数字
                int num = nums[++right];
                //老数量、新数量
                int oldCount = countMap.getOrDefault(num, 0);
                int newCount = oldCount + 1;
                //清算count
                count -= count(oldCount);
                count += count(newCount);
                //覆盖缓存
                countMap.put(num, newCount);
            }

            /**
             * 本次结果
             */

            //如果彻底无了
            if (count < k) {
                //跳出
                break;
            }
            //记录本次结果
            result += nums.length - right;

            /**
             * 左滑一次
             */

            //当前数字
            int num = nums[left++];
            //老数量、新数量
            int oldCount = countMap.getOrDefault(num, 0);
            int newCount = oldCount - 1;
            //清算count
            count -= count(oldCount);
            count += count(newCount);
            //覆盖缓存
            countMap.put(num, newCount);

        }
        //返回
        return result;
    }

    //高斯算法
    private long count(int count) {
        //如果太小
        if (count < 2) {
            //过
            return 0;
        }
        //特殊
        if (count == 2) {
            //过
            return 1;
        }
        //长度
        long length = count - 1;
        long a = (1 + length) * (length / 2);
        long b = ((length % 2 == 0 ? 0 : ((length + 1) / 2)));
        //计算
        long result = a + b;
        //实现
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().countGood(new int[]{2, 1, 2, 1, 3, 1, 2, 2, 2, 1}, 17));
    }

}