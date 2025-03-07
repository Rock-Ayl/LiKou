package easy39;

/**
 * @Author ayl
 * @Date 2024-12-12
 * 3370. 仅含置位位的最小整数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n。
 * <p>
 * 返回 大于等于 n 且二进制表示仅包含 置位 位的 最小 整数 x 。
 * <p>
 * 置位 位指的是二进制表示中值为 1 的位。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5
 * <p>
 * 输出： 7
 * <p>
 * 解释：
 * <p>
 * 7 的二进制表示是 "111"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 10
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 15 的二进制表示是 "1111"。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 3
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 3 的二进制表示是 "11"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code2 {

    public int smallestNumber(int n) {
        //数字
        int num = 1;
        //循环
        while (num <= n) {
            //位移
            num = num << 1;
        }
        //返回
        return num - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().smallestNumber(10));
    }

}
