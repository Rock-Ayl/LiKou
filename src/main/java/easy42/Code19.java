package easy42;

/**
 * 3866. 找到第一个唯一偶数
 * 算术评级: 2
 * 第 178 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1209
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个整数数组 nums。
 * <p>
 * 请你返回一个整数，表示 nums 中出现 恰好 一次的第一个 偶数（以数组下标最早为准）。如果不存在这样的整数，返回 -1。
 * <p>
 * 如果一个整数 x 能被 2 整除，那么它就被认为是 偶数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,4,2,5,4,6]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 2 和 6 都是偶数，并且它们都恰好出现一次。因为 2 在数组中出现得更早，所以答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [4,4]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 没有恰好出现一次的偶数，所以返回 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code19 {

    public int firstUniqueEven(int[] nums) {
        //计数器
        int[] arr = new int[101];
        //循环
        for (int num : nums) {
            //+1
            arr[num]++;
        }
        //循环
        for (int num : nums) {
            //如果是目标
            if (num % 2 == 0 && arr[num] == 1) {
                //返回
                return num;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {

    }

}
