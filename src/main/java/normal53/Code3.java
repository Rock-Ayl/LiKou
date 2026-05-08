package normal53;

import java.util.ArrayList;
import java.util.List;

/**
 * 2420. 找到所有好下标
 * 算术评级: 4
 * 第 312 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1695
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 n 下标从 0 开始的整数数组 nums 和一个正整数 k 。
 * <p>
 * 对于 k <= i < n - k 之间的一个下标 i ，如果它满足以下条件，我们就称它为一个 好 下标：
 * <p>
 * 下标 i 之前 的 k 个元素是 非递增的 。
 * 下标 i 之后 的 k 个元素是 非递减的 。
 * 按 升序 返回所有好下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,1,1,3,4,1], k = 2
 * 输出：[2,3]
 * 解释：数组中有两个好下标：
 * - 下标 2 。子数组 [2,1] 是非递增的，子数组 [1,3] 是非递减的。
 * - 下标 3 。子数组 [1,1] 是非递增的，子数组 [3,4] 是非递减的。
 * 注意，下标 4 不是好下标，因为 [4,1] 不是非递减的。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,1,2], k = 2
 * 输出：[]
 * 解释：数组中没有好下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 3 <= n <= 105
 * 1 <= nums[i] <= 106
 * 1 <= k <= n / 2
 */
public class Code3 {

    public List<Integer> goodIndices(int[] nums, int k) {

        /**
         * 前缀和 统计
         */

        //非递减
        int[] upArr = new int[nums.length];
        //非递增
        int[] downArr = new int[nums.length];
        //初始化二者第一个
        upArr[0] = 1;
        downArr[0] = 1;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果是非递减
            if (nums[i] >= nums[i - 1]) {
                //叠加
                upArr[i] = upArr[i - 1] + 1;
            } else {
                //重置
                upArr[i] = 1;
            }
            //如果是飞递增
            if (nums[i] <= nums[i - 1]) {
                //叠加
                downArr[i] = downArr[i - 1] + 1;
            } else {
                //重置
                downArr[i] = 1;
            }
        }

        /**
         * 计算
         */

        //列表
        List<Integer> result = new ArrayList<>();
        //循环
        for (int i = k; i < nums.length - k; i++) {
            //判断
            int a = downArr[i - 1];
            int b = upArr[i + k];
            //如果是好下标
            if (a >= k && b >= k) {
                //记录
                result.add(i);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        //new Code3().goodIndices(new int[]{2, 1, 1, 1, 3, 4, 1}, 2);
        //new Code3().goodIndices(new int[]{478184, 863008, 716977, 921182, 182844, 350527, 541165, 881224}, 1);
        new Code3().goodIndices(new int[]{253747, 459932, 263592, 354832, 60715, 408350, 959296}, 2);
    }

}