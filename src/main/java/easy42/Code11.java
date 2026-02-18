package easy42;

/**
 * 3833. 统计主导元素下标数
 * 算术评级: 2
 * 第 488 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1172
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 当下标 i 满足以下条件时，该下标处的元素被称为 主导元素：nums[i] > average(nums[i + 1], nums[i + 2], ..., nums[n - 1])
 * <p>
 * 你的任务是统计数组中 主导元素 的下标数。
 * <p>
 * 平均值 是指一组数的总和除以该组数的个数得到的值。
 * <p>
 * 注意：数组的 最右边元素 不算作 主导元素 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [5,4,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 在下标 i = 0 处，值 5 是主导元素，因为 5 > average(4, 3) = 3.5。
 * 在下标 i = 1 处，值 4 是主导元素，相对于子数组 [3]。
 * 下标 i = 2 不是主导元素，因为它右侧没有元素。因此答案是 2。
 * 示例 2：
 * <p>
 * 输入： nums = [4,1,2]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 在下标 i = 0 处，值 4 是主导元素，相对于子数组 [1, 2]。
 * 在下标 i = 1 处，值 1 不是主导元素。
 * 下标 i = 2 不是主导元素，因为它右侧没有元素。因此答案是 1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100​​​​​​​
 */
public class Code11 {

    public int dominantIndices(int[] nums) {
        //结果
        int result = 0;
        //数量
        int count = 0;
        //和
        double sum = 0;
        //索引
        int index = nums.length - 2;
        //循环
        while (index >= 0) {
            //叠加
            sum += nums[index + 1];
            //判断目标结果,并计算下一个索引
            if (nums[index--] > sum / ++count) {
                //+1结果
                result++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().dominantIndices(new int[]{4, 1, 2}));
    }

}
