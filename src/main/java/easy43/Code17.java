package easy43;

/**
 * 3954. 区间内的兼容数字之和 I
 * 算术评级: 2
 * 第 505 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1210
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数 n 和 k。
 * <p>
 * 如果一个 正 整数 x 同时满足以下两个条件，则称其为 兼容 整数：
 * <p>
 * abs(n - x) <= k
 * (n & x) == 0
 * 返回所有 兼容 整数 x 的总和。
 * <p>
 * 注意：
 * <p>
 * 这里，& 表示 按位与 运算符。
 * 整数 i 和 j 之间的 绝对 差定义为 abs(i - j)。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 2, k = 3
 * <p>
 * 输出： 10
 * <p>
 * 解释：
 * <p>
 * 兼容整数为：
 * <p>
 * x = 1，因为 abs(2 - 1) = 1 且 2 & 1 = 0。
 * x = 4，因为 abs(2 - 4) = 2 且 2 & 4 = 0。
 * x = 5，因为 abs(2 - 5) = 3 且 2 & 5 = 0。
 * 因此，答案为 1 + 4 + 5 = 10。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 5, k = 1
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 区间 [4, 6] 中没有兼容整数。因此，答案为 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * 1 <= k <= 100
 */
public class Code17 {

    public int sumOfGoodIntegers(int n, int k) {
        //开始结束区间
        int start = Math.max(n - k, 1);
        int end = Math.max(n + k, start);
        //好人
        int sum = 0;
        //循环
        while (start <= end) {
            //对应数字,下一个
            int num = start++;
            //如果满足
            if ((n & num) == 0) {
                //叠加
                sum += num;
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().sumOfGoodIntegers(2, 3));
    }

}
