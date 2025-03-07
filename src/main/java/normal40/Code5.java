package normal40;

/**
 * @Author ayl
 * @Date 2025-02-14
 * 2461. 长度为 K 子数组中的最大和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。请你从 nums 中满足下述条件的全部子数组中找出最大子数组和：
 * <p>
 * 子数组的长度是 k，且
 * 子数组中的所有元素 各不相同 。
 * 返回满足题面要求的最大子数组和。如果不存在子数组满足这些条件，返回 0 。
 * <p>
 * 子数组 是数组中一段连续非空的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,5,4,2,9,9,9], k = 3
 * 输出：15
 * 解释：nums 中长度为 3 的子数组是：
 * - [1,5,4] 满足全部条件，和为 10 。
 * - [5,4,2] 满足全部条件，和为 11 。
 * - [4,2,9] 满足全部条件，和为 15 。
 * - [2,9,9] 不满足全部条件，因为元素 9 出现重复。
 * - [9,9,9] 不满足全部条件，因为元素 9 出现重复。
 * 因为 15 是满足全部条件的所有子数组中的最大子数组和，所以返回 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [4,4,4], k = 3
 * 输出：0
 * 解释：nums 中长度为 3 的子数组是：
 * - [4,4,4] 不满足全部条件，因为元素 4 出现重复。
 * 因为不存在满足全部条件的子数组，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Code5 {

    public long maximumSubarraySum(int[] nums, int k) {

        /**
         * 初始化第一次
         */

        //结果
        long maxSum = 0L;
        //和
        long sum = 0L;
        //不同的字符数量
        int hit = 0;
        //map
        int[] arr = new int[1000000];
        //双指针
        int start = 0;
        int end = 0;
        //循环
        while (end < k) {

            /**
             * 右侧滑动
             */

            //获取数字
            int num = nums[end++];
            //求和
            sum += num;
            //+1,如果有1个了
            if (++arr[num] == 1) {
                //+1
                hit++;
            }
            //如果有2个了
            else if (arr[num] == 2) {
                //-1
                hit--;
            }
        }
        //如果第一次满足
        if (hit == k) {
            //刷新最大
            maxSum = Math.max(sum, maxSum);
        }

        /**
         * 后续计算
         */

        //循环
        while (end < nums.length) {

            /**
             * 右侧滑动
             */

            //获取数字
            int endNum = nums[end++];
            //求和
            sum += endNum;
            //+1,如果有1个了
            if (++arr[endNum] == 1) {
                //+1
                hit++;
            }
            //如果有2个了
            else if (arr[endNum] == 2) {
                //-1
                hit--;
            }

            /**
             * 左侧滑动
             */

            //获取数字
            int startNum = nums[start++];
            //求和
            sum -= startNum;
            //-1,如果有0个了
            if (--arr[startNum] == 0) {
                //-1
                hit--;
            }
            //如果有2个了
            else if (arr[startNum] == 1) {
                //+1
                hit++;
            }

            /**
             * 结算
             */

            //如果第一次满足
            if (hit == k) {
                //刷新最大
                maxSum = Math.max(sum, maxSum);
            }

        }

        //返回最终
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().maximumSubarraySum(new int[]{1, 5, 4, 2, 9, 9, 9}, 3));
    }

}
