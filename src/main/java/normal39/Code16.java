package normal39;

/**
 * @Author ayl
 * @Date 2025-01-26
 * 2786. 访问数组中的位置使分数最大
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个正整数 x 。
 * <p>
 * 你 一开始 在数组的位置 0 处，你可以按照下述规则访问数组中的其他位置：
 * <p>
 * 如果你当前在位置 i ，那么你可以移动到满足 i < j 的 任意 位置 j 。
 * 对于你访问的位置 i ，你可以获得分数 nums[i] 。
 * 如果你从位置 i 移动到位置 j 且 nums[i] 和 nums[j] 的 奇偶性 不同，那么你将失去分数 x 。
 * 请你返回你能得到的 最大 得分之和。
 * <p>
 * 注意 ，你一开始的分数为 nums[0] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,6,1,9,2], x = 5
 * 输出：13
 * 解释：我们可以按顺序访问数组中的位置：0 -> 2 -> 3 -> 4 。
 * 对应位置的值为 2 ，6 ，1 和 9 。因为 6 和 1 的奇偶性不同，所以下标从 2 -> 3 让你失去 x = 5 分。
 * 总得分为：2 + 6 + 1 + 9 - 5 = 13 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6,8], x = 3
 * 输出：20
 * 解释：数组中的所有元素奇偶性都一样，所以我们可以将每个元素都访问一次，而且不会失去任何分数。
 * 总得分为：2 + 4 + 6 + 8 = 20 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i], x <= 106
 */
public class Code16 {

    public long maxScore(int[] nums, int x) {

        /**
         * 初始化第一个数字的情况
         */

        //截止到目前，奇偶数分别对应的最大分数
        Long singleSum = null;
        Long doubleSum = null;
        //如果第一个数字是偶数
        if (nums[0] % 2 == 0) {
            //初始化
            doubleSum = (long) nums[0];
        }
        //如果第一个数字是奇数
        else {
            //初始化
            singleSum = (long) nums[0];
        }

        /**
         * 开始不断计算
         */

        //索引从1开始
        int index = 1;
        //循环
        while (index < nums.length) {

            /**
             * 取数、计算奇偶
             */

            //获取当前数字
            int num = nums[index++];
            //当前奇偶性
            int key = num % 2;

            /**
             * 计算当前数字最大可能
             */

            //当前数字和
            long sum = Long.MIN_VALUE;

            //如果前方有奇数分数
            if (singleSum != null) {
                //根据奇偶数不同处理
                if (key == 1) {
                    //叠加
                    sum = Math.max(sum, singleSum + num);
                } else {
                    //扣分叠加
                    sum = Math.max(sum, singleSum + num - x);
                }
            }

            //如果前方有偶数分数
            if (doubleSum != null) {
                //根据奇偶数不同处理
                if (key == 0) {
                    //叠加
                    sum = Math.max(sum, doubleSum + num);
                } else {
                    //扣分叠加
                    sum = Math.max(sum, doubleSum + num - x);
                }
            }

            /**
             * 记录结果、刷新最大值
             */

            //根据奇偶数处理
            if (key == 1) {
                //刷新最大结果
                singleSum = singleSum == null ? sum : Math.max(singleSum, sum);
            } else {
                //刷新最大结果
                doubleSum = doubleSum == null ? sum : Math.max(doubleSum, sum);
            }

        }

        /**
         * 返回结果
         */

        //如果单为空
        if (singleSum == null) {
            //返回
            return doubleSum;
        }
        //如果双为空
        if (doubleSum == null) {
            //返回
            return singleSum;
        }
        //返回最大结果
        return Math.max(singleSum, doubleSum);
    }

    public static void main(String[] args) {
        System.out.println(new Code16().maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
    }

}
