package difficult3;

/**
 * @Author ayl
 * @Date 2025-08-13
 * 2302. 统计得分小于 K 的子数组数目
 * 算术评级: 5
 * 第 80 场双周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1808
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 一个数组的 分数 定义为数组之和 乘以 数组的长度。
 * <p>
 * 比方说，[1, 2, 3, 4, 5] 的分数为 (1 + 2 + 3 + 4 + 5) * 5 = 75 。
 * 给你一个正整数数组 nums 和一个整数 k ，请你返回 nums 中分数 严格小于 k 的 非空整数子数组数目。
 * <p>
 * 子数组 是数组中的一个连续元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,4,3,5], k = 10
 * 输出：6
 * 解释：
 * 有 6 个子数组的分数小于 10 ：
 * - [2] 分数为 2 * 1 = 2 。
 * - [1] 分数为 1 * 1 = 1 。
 * - [4] 分数为 4 * 1 = 4 。
 * - [3] 分数为 3 * 1 = 3 。
 * - [5] 分数为 5 * 1 = 5 。
 * - [2,1] 分数为 (2 + 1) * 2 = 6 。
 * 注意，子数组 [1,4] 和 [4,3,5] 不符合要求，因为它们的分数分别为 10 和 36，但我们要求子数组的分数严格小于 10 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1], k = 5
 * 输出：5
 * 解释：
 * 除了 [1,1,1] 以外每个子数组分数都小于 5 。
 * [1,1,1] 分数为 (1 + 1 + 1) * 3 = 9 ，大于 5 。
 * 所以总共有 5 个子数组得分小于 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= k <= 1015
 */
public class Code15 {

    public long countSubarrays(int[] nums, long k) {
        //结果
        long result = 0L;
        //双指针
        int left = 0;
        int right = 0;
        //当前和
        long sum = nums[right];
        //数量
        int count = 1;
        //循环
        while (left < nums.length) {
            //如果不够了
            if (right <= left) {
                //重置
                sum = nums[left];
                right = left;
                count = 1;
            }
            //如果本身就高
            if (sum * count >= k) {
                //左滑
                sum -= nums[left++];
                //-1
                count--;
                //本轮过
                continue;
            }
            //如果还可以增加
            while (right + 1 < nums.length && (sum + nums[right + 1]) * (count + 1) < k) {
                //右滑
                sum += nums[++right];
                count++;
            }
            //叠加本次结果
            result += (right - left + 1);
            //左滑
            sum -= nums[left++];
            //-1
            count--;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(new Code15().countSubarrays(new int[]{2, 1, 4, 3, 5}, 10));
        //System.out.println(new Code15().countSubarrays(new int[]{1, 1, 1}, 5));
        System.out.println(new Code15().countSubarrays(new int[]{9, 5, 3, 8, 4, 7, 2, 7, 4, 5, 4, 9, 1, 4, 8, 10, 8, 10, 4, 7}, 4));
    }

}
