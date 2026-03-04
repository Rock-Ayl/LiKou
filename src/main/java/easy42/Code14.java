package easy42;

/**
 * 3852. 不同频率的最小数对
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 从 nums 中找出两个 互不相同 的值 x 和 y，使得：
 * <p>
 * x < y
 * x 和 y 在 nums 中的频率不同。
 * 在所有满足条件的数对中：
 * <p>
 * 选择 x 的值尽可能小的数对。
 * 如果存在多个 x 相同的数对，选择 y 的值尽可能小的那个。
 * 返回一个整数数组 [x, y]。如果不存在有效的数对，返回 [-1, -1]。
 * <p>
 * 一个值 x 的 频率 是指它在数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,1,2,2,3,4]
 * <p>
 * 输出： [1,3]
 * <p>
 * 解释：
 * <p>
 * 最小的值是 1，频率为 2。比 1 大且频率与 1 不同的最小值是 3，其频率为 1。因此，答案是 [1, 3]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,5]
 * <p>
 * 输出： [-1,-1]
 * <p>
 * 解释：
 * <p>
 * 两个值的频率相同，因此不存在有效的数对。返回 [-1, -1]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [7]
 * <p>
 * 输出： [-1,-1]
 * <p>
 * 解释：
 * <p>
 * 数组中只有一个值，因此不存在有效的数对。返回 [-1, -1]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 *
 */
public class Code14 {

    public int[] minDistinctFreqPair(int[] nums) {
        //计数器
        int[] arr = new int[101];
        //循环
        for (int num : nums) {
            //+1
            arr[num]++;
        }
        //循环
        for (int x = 1; x < arr.length; x++) {
            //获取频率
            int xCount = arr[x];
            //如果没有
            if (xCount == 0) {
                //本轮过
                continue;
            }
            //循环2
            for (int y = x + 1; y < arr.length; y++) {
                //获取频率
                int yCount = arr[y];
                //如果没有
                if (yCount == 0) {
                    //本轮过
                    continue;
                }
                //如果相同
                if (yCount == xCount) {
                    //本轮过
                    continue;
                }
                //返回
                return new int[]{x, y};
            }
        }
        //默认
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {

    }

}
