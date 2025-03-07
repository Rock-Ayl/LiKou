package normal37;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-11-19
 * 2602. 使数组元素全部相等的最少操作次数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数数组 nums 。
 * <p>
 * 同时给你一个长度为 m 的整数数组 queries 。第 i 个查询中，你需要将 nums 中所有元素变成 queries[i] 。你可以执行以下操作 任意 次：
 * <p>
 * 将数组里一个元素 增大 或者 减小 1 。
 * 请你返回一个长度为 m 的数组 answer ，其中 answer[i]是将 nums 中所有元素变成 queries[i] 的 最少 操作次数。
 * <p>
 * 注意，每次查询后，数组变回最开始的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,6,8], queries = [1,5]
 * 输出：[14,10]
 * 解释：第一个查询，我们可以执行以下操作：
 * - 将 nums[0] 减小 2 次，nums = [1,1,6,8] 。
 * - 将 nums[2] 减小 5 次，nums = [1,1,1,8] 。
 * - 将 nums[3] 减小 7 次，nums = [1,1,1,1] 。
 * 第一个查询的总操作次数为 2 + 5 + 7 = 14 。
 * 第二个查询，我们可以执行以下操作：
 * - 将 nums[0] 增大 2 次，nums = [5,1,6,8] 。
 * - 将 nums[1] 增大 4 次，nums = [5,5,6,8] 。
 * - 将 nums[2] 减小 1 次，nums = [5,5,5,8] 。
 * - 将 nums[3] 减小 3 次，nums = [5,5,5,5] 。
 * 第二个查询的总操作次数为 2 + 4 + 1 + 3 = 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,9,6,3], queries = [10]
 * 输出：[20]
 * 解释：我们可以将数组中所有元素都增大到 10 ，总操作次数为 8 + 1 + 4 + 7 = 20 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == queries.length
 * 1 <= n, m <= 105
 * 1 <= nums[i], queries[i] <= 109
 */
public class Code15 {

    //递归寻找
    private int find(int[] nums, int targetNum, int start, int end) {
        //计算中间点
        int mid = (end - start) / 2 + start;
        //如果找到头了
        if (start + 1 == end) {
            //如果右边更小
            if (nums[end] <= targetNum) {
                //返回
                return end;
            }
            //返回
            return start;
        }
        //如果中间点比目标值更大
        if (nums[mid] >= targetNum) {
            //继续
            return find(nums, targetNum, start, mid);
        } else {
            //继续
            return find(nums, targetNum, mid, end);
        }
    }

    //寻找 小于 目标数字 的最大索引
    private int findMinIndex(int[] nums, int targetNum) {
        //如果最小的比目标的还大
        if (nums[0] >= targetNum) {
            //过
            return -1;
        }
        //如果最大的比目标都小
        if (nums[nums.length - 1] <= targetNum) {
            //过
            return nums.length;
        }
        //开始递归寻找
        return find(nums, targetNum, 0, nums.length - 1);
    }

    public List<Long> minOperations(int[] nums, int[] queries) {
        //排序
        Arrays.sort(nums);
        //前缀和数组
        long[] sumArr = new long[nums.length];
        //第一个
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //计算本次
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        //初始化结果列表
        List<Long> result = new ArrayList<>(queries.length);
        //循环
        for (int i = 0; i < queries.length; i++) {
            //本次目标数字
            int targetNum = queries[i];
            //寻找对应索引
            int minIndex = findMinIndex(nums, targetNum);
            //求和
            long sum = 0L;
            //如果存在左边的区间
            if (minIndex != -1) {
                //左边的区间
                int start = 0;
                int end = Math.min(minIndex, nums.length - 1);
                //计算左边和,叠加
                sum += ((long) targetNum * (end - start + 1)) - ((long) sumArr[end] - (long) (start == 0 ? 0 : sumArr[start - 1]));
            }
            //如果存在右边的区间
            if (minIndex != nums.length) {
                //右边的区间
                int start = minIndex + 1;
                int end = nums.length - 1;
                //计算右边和,叠加
                sum += ((long) sumArr[end] - (long) (start == 0 ? 0 : sumArr[start - 1])) - ((long) targetNum * (end - start + 1));
            }
            //组装本次结果
            result.add(sum);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<Long> longs = new Code15().minOperations(new int[]{2, 9, 6, 3}, new int[]{10});
        System.out.println();
    }

}
