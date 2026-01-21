package normal49;

/**
 * 2653. 滑动子数组的美丽值
 * 算术评级: 5
 * 第 342 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1786
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums ，请你求出每个长度为 k 的子数组的 美丽值 。
 * <p>
 * 一个子数组的 美丽值 定义为：如果子数组中第 x 小整数 是 负数 ，那么美丽值为第 x 小的数，否则美丽值为 0 。
 * <p>
 * 请你返回一个包含 n - k + 1 个整数的数组，依次 表示数组中从第一个下标开始，每个长度为 k 的子数组的 美丽值 。
 * <p>
 * 子数组指的是数组中一段连续 非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,-1,-3,-2,3], k = 3, x = 2
 * 输出：[-1,-2,-2]
 * 解释：总共有 3 个 k = 3 的子数组。
 * 第一个子数组是 [1, -1, -3] ，第二小的数是负数 -1 。
 * 第二个子数组是 [-1, -3, -2] ，第二小的数是负数 -2 。
 * 第三个子数组是 [-3, -2, 3] ，第二小的数是负数 -2 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,-3,-4,-5], k = 2, x = 2
 * 输出：[-1,-2,-3,-4]
 * 解释：总共有 4 个 k = 2 的子数组。
 * [-1, -2] 中第二小的数是负数 -1 。
 * [-2, -3] 中第二小的数是负数 -2 。
 * [-3, -4] 中第二小的数是负数 -3 。
 * [-4, -5] 中第二小的数是负数 -4 。
 * 示例 3：
 * <p>
 * 输入：nums = [-3,1,2,-3,0,-3], k = 2, x = 1
 * 输出：[-3,0,-3,-3,-3]
 * 解释：总共有 5 个 k = 2 的子数组。
 * [-3, 1] 中最小的数是负数 -3 。
 * [1, 2] 中最小的数不是负数，所以美丽值为 0 。
 * [2, -3] 中最小的数是负数 -3 。
 * [-3, 0] 中最小的数是负数 -3 。
 * [0, -3] 中最小的数是负数 -3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 105
 * 1 <= k <= n
 * 1 <= x <= k
 * -50 <= nums[i] <= 50
 */
public class Code23 {

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        //结果
        int[] result = new int[nums.length - k + 1];
        //缓存
        int[] cacheArr = new int[101];
        //循环
        for (int i = 0; i < nums.length; i++) {

            /**
             * 右滑
             */

            //右滑数字,平移+1
            cacheArr[nums[i] + 50]++;

            /**
             * 左滑
             */

            //左边索引
            int leftIndext = i - k;
            //如果未越界
            if (leftIndext >= 0) {
                //左滑数字,平移-1
                cacheArr[nums[leftIndext] + 50]--;
            }

            /**
             * 寻找本次目标
             */

            //结果索引
            int index = i - k + 1;
            //如果没有目标值
            if (index < 0) {
                //本轮过
                continue;
            }
            //当前预期需要的数字顺位
            int count = x;
            //循环
            for (int j = 0; j < cacheArr.length; j++) {
                //如果没有数字
                if (cacheArr[j] == 0) {
                    //本轮过
                    continue;
                }
                //删除
                count -= cacheArr[j];
                //如果不是目标
                if (count > 0) {
                    //本轮过
                    continue;
                }
                //目标结果
                int target = j - 50;
                //如果是美丽的
                if (target < 0) {
                    //记录本次
                    result[index] = target;
                }
                //跳出
                break;
            }

        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] subarrayBeauty = new Code23().getSubarrayBeauty(
                new int[]{-46, -34, -46}, 3, 3);
        System.out.println();
    }

}