package normal58;

/**
 * 2865. 美丽塔 I
 * 算术评级: 3
 * 第 364 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1519
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个包含 n 个整数的数组 heights 表示 n 座连续的塔中砖块的数量。你的任务是移除一些砖块来形成一个 山脉状 的塔排列。在这种布置中，塔高度先是非递减，有一个或多个连续塔达到最大峰值，然后非递增排列。
 * <p>
 * 返回满足山脉状塔排列的方案中，高度和的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：maxHeights = [5,3,4,1,1]
 * 输出：13
 * 解释：我们移除一些砖块来形成 heights = [5,3,3,1,1]，峰值位于下标 0。
 * 示例 2：
 * <p>
 * 输入：maxHeights = [6,5,3,9,2,7]
 * 输出：22
 * 解释：我们移除一些砖块来形成 heights = [3,3,3,9,2,2]，峰值位于下标 3。
 * 示例 3：
 * <p>
 * 输入：maxHeights = [3,2,5,5,2,3]
 * 输出：18
 * 解释：我们移除一些砖块来形成 heights = [2,2,5,5,2,2]，峰值位于下标 2 或 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == heights.length <= 103
 * 1 <= heights[i] <= 109
 *
 */
public class Code21 {

    public long maximumSumOfHeights(int[] heights) {
        //最大
        long max = 0L;
        //循环
        for (int i = 0; i < heights.length; i++) {
            //当成峰
            int mid = heights[i];
            //左右高度
            int left = mid;
            int right = mid;
            //结果
            long sum = mid;
            //循环
            for (int j = i + 1; j < heights.length; j++) {
                //更新高度
                right = Math.min(right, heights[j]);
                //叠加本次
                sum += right;
            }
            //循环2
            for (int k = i - 1; k >= 0; k--) {
                //更新高度
                left = Math.min(left, heights[k]);
                //叠加本次
                sum += left;
            }
            //更新最大
            max = Math.max(max, sum);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().maximumSumOfHeights(new int[]{6, 5, 3, 9, 2, 7}));
    }

}
