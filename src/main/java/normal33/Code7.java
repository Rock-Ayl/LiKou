package normal33;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-07-10
 * 2971. 找到最大周长的多边形
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个长度为 n 的 正 整数数组 nums 。
 * <p>
 * 多边形 指的是一个至少有 3 条边的封闭二维图形。多边形的 最长边 一定 小于 所有其他边长度之和。
 * <p>
 * 如果你有 k （k >= 3）个 正 数 a1，a2，a3, ...，ak 满足 a1 <= a2 <= a3 <= ... <= ak 且 a1 + a2 + a3 + ... + ak-1 > ak ，那么 一定 存在一个 k 条边的多边形，每条边的长度分别为 a1 ，a2 ，a3 ， ...，ak 。
 * <p>
 * 一个多边形的 周长 指的是它所有边之和。
 * <p>
 * 请你返回从 nums 中可以构造的 多边形 的 最大周长 。如果不能构造出任何多边形，请你返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [5,5,5]
 * 输出：15
 * 解释：nums 中唯一可以构造的多边形为三角形，每条边的长度分别为 5 ，5 和 5 ，周长为 5 + 5 + 5 = 15 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,12,1,2,5,50,3]
 * 输出：12
 * 解释：最大周长多边形为五边形，每条边的长度分别为 1 ，1 ，2 ，3 和 5 ，周长为 1 + 1 + 2 + 3 + 5 = 12 。
 * 我们无法构造一个包含变长为 12 或者 50 的多边形，因为其他边之和没法大于两者中的任何一个。
 * 所以最大周长为 12 。
 * 示例 3：
 * <p>
 * 输入：nums = [5,5,50]
 * 输出：-1
 * 解释：无法构造任何多边形，因为多边形至少要有 3 条边且 50 > 5 + 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 105
 * 1 <= nums[i] <= 109
 */
public class Code7 {

    public long largestPerimeter(int[] nums) {
        //排序
        Arrays.sort(nums);
        //数组
        long[] arr = new long[nums.length];
        //默认第一个
        arr[0] = nums[0];
        //循环1
        for (int i = 1; i < arr.length; i++) {
            //叠加
            arr[i] = arr[i - 1] + nums[i];
        }
        //循环
        for (int i = arr.length - 1; i >= 2; i--) {
            //如果满足
            if (nums[i] < arr[i] - nums[i]) {
                //返回
                return arr[i];
            }
        }
        //默认
        return -1L;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().largestPerimeter(new int[]{1, 5, 1, 7}));
        ;
    }

}
