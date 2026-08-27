package normal56;

/**
 * 3091. 执行操作使数据元素之和大于等于 K
 * 算术评级: 4
 * 第 390 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1522
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 k 。最初，你有一个数组 nums = [1] 。
 * <p>
 * 你可以对数组执行以下 任意 操作 任意 次数（可能为零）：
 * <p>
 * 选择数组中的任何一个元素，然后将它的值 增加 1 。
 * 复制数组中的任何一个元素，然后将它附加到数组的末尾。
 * 返回使得最终数组元素之 和 大于或等于 k 所需的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：k = 11
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 可以对数组 nums = [1] 执行以下操作：
 * <p>
 * 将元素的值增加 1 三次。结果数组为 nums = [4] 。
 * 复制元素两次。结果数组为 nums = [4,4,4] 。
 * 最终数组的和为 4 + 4 + 4 = 12 ，大于等于 k = 11 。
 * 执行的总操作次数为 3 + 2 = 5 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：k = 1
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * 原始数组的和已经大于等于 1 ，因此不需要执行操作。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 105
 *
 */
public class Code17 {

    public int minOperations(int k) {
        //特殊
        if (k == 1) {
            //过
            return 0;
        }
        //结果
        int result = k;
        //循环
        for (int i = 2; i <= k; i++) {
            //增加多少次 + 乘以多少次 ,并刷新最小
            result = Math.min(result, (i - 1) + (k / i + (k % i == 0 ? 0 : 1) - 1));
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().minOperations(8));
    }

}
