package easy41;

/**
 * @Author ayl
 * @Date 2025-11-22
 * 3740. 三个相等元素之间的最小距离 I
 * 算术评级: 1
 * 第 475 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1288
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 如果满足 nums[i] == nums[j] == nums[k]，且 (i, j, k) 是 3 个 不同 下标，那么三元组 (i, j, k) 被称为 有效三元组 。
 * <p>
 * 有效三元组 的 距离 被定义为 abs(i - j) + abs(j - k) + abs(k - i)，其中 abs(x) 表示 x 的 绝对值 。
 * <p>
 * 返回一个整数，表示 有效三元组 的 最小 可能距离。如果不存在 有效三元组 ，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,1,1,3]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 最小距离对应的有效三元组是 (0, 2, 3) 。
 * <p>
 * (0, 2, 3) 是一个有效三元组，因为 nums[0] == nums[2] == nums[3] == 1。它的距离为 abs(0 - 2) + abs(2 - 3) + abs(3 - 0) = 2 + 1 + 3 = 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,1,2,3,2,1,2]
 * <p>
 * 输出： 8
 * <p>
 * 解释：
 * <p>
 * 最小距离对应的有效三元组是 (2, 4, 6) 。
 * <p>
 * (2, 4, 6) 是一个有效三元组，因为 nums[2] == nums[4] == nums[6] == 2。它的距离为 abs(2 - 4) + abs(4 - 6) + abs(6 - 2) = 2 + 2 + 4 = 8。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 不存在有效三元组，因此答案为 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 100
 * 1 <= nums[i] <= n
 */
public class Code25 {

    public int minimumDistance(int[] nums) {
        //结果
        int min = Integer.MAX_VALUE;
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //如果不同
                if (nums[i] != nums[j]) {
                    //本轮过
                    continue;
                }
                //循环3
                for (int k = j + 1; k < nums.length; k++) {
                    //如果不同
                    if (nums[i] != nums[k]) {
                        //本轮过
                        continue;
                    }
                    //刷新最小
                    min = Math.min((k - i) * 2, min);
                }
            }
        }
        //返回
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    public static void main(String[] args) {
        System.out.println(new Code25().minimumDistance(new int[]{1, 1, 2, 3, 2, 1, 2}));
    }

}
