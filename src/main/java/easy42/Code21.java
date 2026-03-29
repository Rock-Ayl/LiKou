package easy42;

/**
 * 3880. 两个值之间的最小绝对差值
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个只包含 0、1 和 2 的整数数组 nums。
 * <p>
 * 如果 nums[i] == 1 且 nums[j] == 2，则称下标对 (i, j) 为 有效 的。
 * <p>
 * 请返回所有有效下标对中 i 和 j 之间的 最小 绝对差。如果不存在有效下标对，则返回 -1。
 * <p>
 * 下标 i 和 j 之间的绝对差定义为 abs(i - j)。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,0,0,2,0,1]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 有效下标对有：
 * <p>
 * (0, 3)，其绝对差为 abs(0 - 3) = 3。
 * (5, 3)，其绝对差为 abs(5 - 3) = 2。
 * 因此，结果是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,0,1,0]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 数组中不存在有效下标对，因此结果是 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 2
 */
public class Code21 {

    public int minAbsoluteDifference(int[] nums) {
        //刷新最小结果
        int min = Math.min(left(nums), right(nums));
        //返回
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    //从左到右
    private int left(int[] nums) {
        //最小结果
        int min = Integer.MAX_VALUE;
        //上一个1的索引
        int lastOneIndex = -1;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果是1
            if (nums[i] == 1) {
                //记录
                lastOneIndex = i;
            } else if (nums[i] == 2) {
                //如果有1
                if (lastOneIndex != -1) {
                    //刷新最小结果
                    min = Math.min(min, i - lastOneIndex);
                }
            }
        }
        //返回
        return min;
    }

    //从右到左
    private int right(int[] nums) {
        //最小结果
        int min = Integer.MAX_VALUE;
        //上一个1的索引
        int lastOneIndex = -1;
        //循环
        for (int i = nums.length - 1; i >= 0; i--) {
            //如果是1
            if (nums[i] == 1) {
                //记录
                lastOneIndex = i;
            } else if (nums[i] == 2) {
                //如果有1
                if (lastOneIndex != -1) {
                    //刷新最小结果
                    min = Math.min(min, lastOneIndex - i);
                }
            }
        }
        //返回
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new Code21().minAbsoluteDifference(new int[]{1, 0, 0, 2, 0, 1}));
    }

}