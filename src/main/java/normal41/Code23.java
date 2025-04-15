package normal41;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-04-15
 * 1589. 所有排列中的最大和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 有一个整数数组 nums ，和一个查询数组 requests ，其中 requests[i] = [starti, endi] 。第 i 个查询求 nums[starti] + nums[starti + 1] + ... + nums[endi - 1] + nums[endi] 的结果 ，starti 和 endi 数组索引都是 从 0 开始 的。
 * <p>
 * 你可以任意排列 nums 中的数字，请你返回所有查询结果之和的最大值。
 * <p>
 * 由于答案可能会很大，请你将它对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5], requests = [[1,3],[0,1]]
 * 输出：19
 * 解释：一个可行的 nums 排列为 [2,1,3,4,5]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 1 + 3 + 4 = 8
 * requests[1] -> nums[0] + nums[1] = 2 + 1 = 3
 * 总和为：8 + 3 = 11。
 * 一个总和更大的排列为 [3,5,4,2,1]，并有如下结果：
 * requests[0] -> nums[1] + nums[2] + nums[3] = 5 + 4 + 2 = 11
 * requests[1] -> nums[0] + nums[1] = 3 + 5  = 8
 * 总和为： 11 + 8 = 19，这个方案是所有排列中查询之和最大的结果。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5,6], requests = [[0,1]]
 * 输出：11
 * 解释：一个总和最大的排列为 [6,5,4,3,2,1] ，查询和为 [11]。
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,3,4,5,10], requests = [[0,2],[1,3],[1,1]]
 * 输出：47
 * 解释：一个和最大的排列为 [4,10,5,3,2,1] ，查询结果分别为 [19,18,10]。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 0 <= nums[i] <= 105
 * 1 <= requests.length <= 105
 * requests[i].length == 2
 * 0 <= starti <= endi < n
 */
public class Code23 {

    public int maxSumRangeQuery(int[] nums, int[][] requests) {

        /**
         * 计算每个节点最终增加、删除的数量
         */

        //查分数组
        int[] arr = new int[nums.length + 1];
        //循环
        for (int[] request : requests) {
            //增加
            int add = request[0];
            //+1
            arr[add]++;
            //删除
            int remove = request[1] + 1;
            //-1
            arr[remove]--;
        }

        /**
         * 统计差分数组
         */

        //循环
        for (int i = 1; i < arr.length; i++) {
            //计算当前
            arr[i] = arr[i - 1] + arr[i];
        }

        /**
         * 根据二者排序,计算最终结果
         */

        //排序
        Arrays.sort(arr);
        Arrays.sort(nums);
        //求和
        long sum = 0L;
        //索引
        int arrIndex = arr.length - 1;
        int numIndex = nums.length - 1;
        //如果满足继续匹配，则循环
        while (numIndex >= 0 && arr[arrIndex] > 0) {
            //叠加
            sum = ((long) arr[arrIndex--] * nums[numIndex--] + sum) % 1000000007L;
        }
        //返回结果
        return (int) sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().maxSumRangeQuery(new int[]{1, 2, 3, 4, 5}, new int[][]{
                new int[]{1, 3},
                new int[]{0, 1}
        }));
    }

}