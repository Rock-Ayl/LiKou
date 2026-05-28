package normal53;

import java.util.HashSet;
import java.util.Set;

/**
 * 2834. 找出美丽数组的最小和
 * 算术评级: 4
 * 第 360 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1409
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个正整数：n 和 target 。
 * <p>
 * 如果数组 nums 满足下述条件，则称其为 美丽数组 。
 * <p>
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 [0, n-1] 内，不存在 两个 不同 下标 i 和 j ，使得 nums[i] + nums[j] == target 。
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 109 + 7。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2, target = 3
 * 输出：4
 * 解释：nums = [1,3] 是美丽数组。
 * - nums 的长度为 n = 2 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 4 是符合条件的美丽数组所可能具备的最小和。
 * 示例 2：
 * <p>
 * 输入：n = 3, target = 3
 * 输出：8
 * 解释：
 * nums = [1,3,4] 是美丽数组。
 * - nums 的长度为 n = 3 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 8 是符合条件的美丽数组所可能具备的最小和。
 * 示例 3：
 * <p>
 * 输入：n = 1, target = 1
 * 输出：1
 * 解释：nums = [1] 是美丽数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 * 1 <= target <= 109
 */
public class Code17 {

    public int minimumPossibleSum(int n, int target) {

        /**
         * 计算左边数字
         * 1,2,3,4,5,6 这种
         */

        //能直接从1加到的数字
        int hitAdd = target / 2;
        //最多能叠加的次数,要考虑需要的
        int needAdd = Math.min(n, hitAdd);
        //清算左边的和(高斯算法)
        long leftSum = sum(1, needAdd);
        //清算剩余次数
        n -= needAdd;
        //如果不需要更多了
        if (n == 0) {
            //直接返回
            return (int) (leftSum% 1000000007L);
        }

        /**
         * 计算右边数字
         * target,target+1,target+2 这种
         */

        //计算右边的区间
        int start = target;
        int end = start + n - 1;
        //计算
        long rightSum = sum(start, end);
        //返回
        return (int) ((leftSum % 1000000007L + rightSum % 1000000007L) % 1000000007L);
    }

    //求取区间和
    private long sum(long start, long end) {
        //高斯算法
        return (end - start + 1) * ((start + end)) / 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().minimumPossibleSum(100000000, 1000000000));
    }

}
