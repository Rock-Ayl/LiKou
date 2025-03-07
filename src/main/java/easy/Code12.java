package easy;

/**
 * Created By Rock-Ayl on 2020-08-20
 * 1486. 数组异或操作
 * 给你两个整数，n 和 start 。
 * <p>
 * 数组 nums 定义为：nums[i] = start + 2*i（下标从 0 开始）且 n == nums.length 。
 * <p>
 * 请返回 nums 中所有元素按位异或（XOR）后得到的结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, start = 0
 * 输出：8
 * 解释：数组 nums 为 [0, 2, 4, 6, 8]，其中 (0 ^ 2 ^ 4 ^ 6 ^ 8) = 8 。
 * "^" 为按位异或 XOR 运算符。
 * 示例 2：
 * <p>
 * 输入：n = 4, start = 3
 * 输出：8
 * 解释：数组 nums 为 [3, 5, 7, 9]，其中 (3 ^ 5 ^ 7 ^ 9) = 8.
 * 示例 3：
 * <p>
 * 输入：n = 1, start = 7
 * 输出：7
 * 示例 4：
 * <p>
 * 输入：n = 10, start = 5
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 * 0 <= start <= 1000
 * n == nums.length
 */
public class Code12 {

    public static int xorOperation(int n, int start) {
        //初始化
        int[] nums = new int[n];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //记录
            nums[i] = start + 2 * i;
        }
        //第一个数
        int sum = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //异或
            sum = sum ^ nums[i];
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(xorOperation(5, 0));
    }

}
