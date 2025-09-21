package easy41;

/**
 * @Author ayl
 * @Date 2025-09-21
 * 3688. 偶数的按位或运算
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 返回数组中所有 偶数 的按位 或 运算结果。
 * <p>
 * 如果 nums 中没有偶数，返回 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4,5,6]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 偶数为 2、4 和 6。它们的按位或运算结果是 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [7,9,11]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 数组中没有偶数，因此结果为 0。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,8,16]
 * <p>
 * 输出： 24
 * <p>
 * 解释：
 * <p>
 * 偶数为 8 和 16。它们的按位或运算结果是 24。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code12 {

    public int evenNumberBitwiseORs(int[] nums) {
        //结果
        Integer result = null;
        //循环
        for (int num : nums) {
            //如果不是
            if (num % 2 == 1) {
                //本轮过
                continue;
            }
            //是否为第一个
            if (result == null) {
                //使用
                result = num;
            } else {
                //按位或
                result = result | num;
            }
        }
        //判空
        if (result == null) {
            //过
            return 0;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().evenNumberBitwiseORs(new int[]{1, 2, 3, 4, 5, 6}));
    }

}
