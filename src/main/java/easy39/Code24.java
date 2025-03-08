package easy39;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author ayl
 * @Date 2025-03-08
 * 326. 3 的幂
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：n = 45
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * -231 <= n <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能不使用循环或者递归来完成本题吗？
 */
public class Code24 {

    public boolean isPowerOfThree(int n) {
        //特殊情况
        if (n == 1) {
            //是
            return true;
        }
        //如果不能整除3
        if (n % 3 != 0) {
            //肯定不行
            return false;
        }
        //初始化
        int num = 3;
        //乘法
        while (num * 3 <= n && num * 3 > 0) {
            //下一个
            num = num * 3;
        }
        //返回
        return num == n;
    }

    public boolean isPowerOfThree2(int n) {
        //实现
        return new HashSet<>(Arrays.asList(
                1,
                3,
                9,
                27,
                81,
                243,
                729,
                2187,
                6561,
                19683,
                59049,
                177147,
                531441,
                1594323,
                4782969,
                14348907,
                43046721,
                129140163,
                387420489,
                1162261467)).contains(n);
    }

    public static void main(String[] args) {
        System.out.println(new Code24().isPowerOfThree(1162261467));
    }

}
