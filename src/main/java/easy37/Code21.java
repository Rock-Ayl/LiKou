package easy37;

/**
 * @Author ayl
 * @Date 2024-07-22
 * 3226. 使两个整数相等的位更改次数
 * 简单
 * 相关企业
 * 提示
 * 给你两个正整数 n 和 k。
 * <p>
 * 你可以选择 n 的 二进制表示 中任意一个值为 1 的位，并将其改为 0。
 * <p>
 * 返回使得 n 等于 k 所需要的更改次数。如果无法实现，返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 13, k = 4
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * 最初，n 和 k 的二进制表示分别为 n = (1101)2 和 k = (0100)2，
 * <p>
 * 我们可以改变 n 的第一位和第四位。结果整数为 n = (0100)2 = k。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 21, k = 21
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * n 和 k 已经相等，因此不需要更改。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 14, k = 13
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * 无法使 n 等于 k。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n, k <= 106
 */
public class Code21 {

    public int minChanges(int n, int k) {
        //变更次数
        int count = 0;
        //如果有满足
        while (n > 0 || k > 0) {
            //计算当前最后两位数字
            int left = n % 2;
            int right = k % 2;
            //如果最后两位不同
            if (left != right) {
                //如果左边是0
                if (left == 0) {
                    //无法变更
                    return -1;
                } else {
                    //变更一次
                    ++count;
                }
            }
            //位移一位
            n = n >> 1;
            k = k >> 1;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(13));
        System.out.println(Integer.toBinaryString(14));
        System.out.println();
        System.out.println(new Code21().minChanges(13, 4));
    }

}
