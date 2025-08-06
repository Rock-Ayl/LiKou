package easy41;

/**
 * @Author ayl
 * @Date 2025-08-06
 * 367. 有效的完全平方数
 * 尝试过
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
 * <p>
 * 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
 * <p>
 * 不能使用任何内置的库函数，如  sqrt 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 16
 * 输出：true
 * 解释：返回 true ，因为 4 * 4 = 16 且 4 是一个整数。
 * 示例 2：
 * <p>
 * 输入：num = 14
 * 输出：false
 * 解释：返回 false ，因为 3.742 * 3.742 = 14 但 3.742 不是一个整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 231 - 1
 */
public class Code3 {

    public boolean isPerfectSquare(int num) {
        //递归
        return next(num, 1, num);
    }

    //递归
    private boolean next(long num, long start, long end) {
        //如果越界
        if (start > end) {
            //过
            return false;
        }
        //如果相等
        if (start == end) {
            //返回
            return start * start == num;
        }
        //如果距离只有1
        if (start + 1 == end) {
            //返回
            return start * start == num || end * end == num;
        }
        //计算中间
        long mid = ((end - start) / 2) + start;
        //计算本次
        long sum = mid * mid;
        //如果是
        if (sum == num) {
            //是
            return true;
        }
        //判断左右方向
        if (sum > num) {
            //左边
            return next(num, start, mid - 1);
        } else {
            //右边
            return next(num, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        //899
        System.out.println(new Code3().isPerfectSquare(808201));
    }

}
