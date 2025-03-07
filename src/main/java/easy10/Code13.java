package easy10;

/**
 * @Author ayl
 * @Date 2021-07-22
 * 1822. 数组元素积的符号
 * 已知函数 signFunc(x) 将会根据 x 的正负返回特定值：
 * <p>
 * 如果 x 是正数，返回 1 。
 * 如果 x 是负数，返回 -1 。
 * 如果 x 是等于 0 ，返回 0 。
 * 给你一个整数数组 nums 。令 product 为数组 nums 中所有元素值的乘积。
 * <p>
 * 返回 signFunc(product) 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-1,-2,-3,-4,3,2,1]
 * 输出：1
 * 解释：数组中所有值的乘积是 144 ，且 signFunc(144) = 1
 * 示例 2：
 * <p>
 * 输入：nums = [1,5,0,2,-3]
 * 输出：0
 * 解释：数组中所有值的乘积是 0 ，且 signFunc(0) = 0
 * 示例 3：
 * <p>
 * 输入：nums = [-1,1,-1,1,-1]
 * 输出：-1
 * 解释：数组中所有值的乘积是 -1 ，且 signFunc(-1) = -1
 */
public class Code13 {

    public int arraySign(int[] nums) {
        //负数的个数
        int size = 0;
        //循环
        for (int num : nums) {
            //如果是0
            if (num == 0) {
                //直接返回
                return 0;
            }
            //如果是负数
            if (num < 0) {
                //记录
                size++;
            }
        }
        //如果是偶数
        if (size % 2 == 0) {
            //正
            return 1;
        } else {
            //负
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code13().arraySign(new int[]{-1, -2, -3, -4, 3, 2, 1}));
    }
}
