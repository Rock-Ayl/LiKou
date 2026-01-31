package easy42;

/**
 * 3658. 奇数和与偶数和的最大公约数
 * 算术评级: 3
 * 第 464 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1220
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n。请你计算以下两个值的 最大公约数（GCD）：
 * <p>
 * sumOdd：最小的 n 个正奇数的总和。
 * <p>
 * sumEven：最小的 n 个正偶数的总和。
 * <p>
 * 返回 sumOdd 和 sumEven 的 GCD。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 4
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 前 4 个奇数的总和 sumOdd = 1 + 3 + 5 + 7 = 16
 * 前 4 个偶数的总和 sumEven = 2 + 4 + 6 + 8 = 20
 * 因此，GCD(sumOdd, sumEven) = GCD(16, 20) = 4。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 5
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 前 5 个奇数的总和 sumOdd = 1 + 3 + 5 + 7 + 9 = 25
 * 前 5 个偶数的总和 sumEven = 2 + 4 + 6 + 8 + 10 = 30
 * 因此，GCD(sumOdd, sumEven) = GCD(25, 30) = 5。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 1000
 */
public class Code6 {

    public int gcdOfOddEvenSums(int n) {
        //奇偶总数
        int length = n * 2;
        //总和
        int sum = (1 + length) * n;
        //奇偶和
        int sumOdd = (sum - n) / 2;
        int sumEven = sum - sumOdd;
        //返回最大公约数
        return gcd(sumEven, sumOdd);
    }

    //计算最大公约数
    private int gcd(int big, int small) {
        //索引
        int index = small;
        //循环
        while (true) {
            //如果是结果
            if (big % index == 0 && small % index == 0) {
                //返回
                return index;
            }
            //-1
            index--;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code6().gcdOfOddEvenSums(4));;
    }

}
