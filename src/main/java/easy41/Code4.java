package easy41;

/**
 * @Author ayl
 * @Date 2025-08-07
 * 69. x 的平方根
 * 尝试过
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
 * <p>
 * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
 * <p>
 * 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 4
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：x = 8
 * 输出：2
 * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= x <= 231 - 1
 */
public class Code4 {

    public int mySqrt(int x) {
        //递归实现
        return (int) next(x, 0, x);
    }

    //递归
    private long next(long target, long start, long end) {
        //如果到头了
        if (start == end) {
            //返回
            return start * start <= target ? start : start - 1;
        }
        //如果只差一位
        if (start + 1 == end) {
            //如果结束是
            if (end * end <= target) {
                //返回
                return end;
            }
            //如果开始是
            if (start * start <= target) {
                //返回
                return start;
            }
            //默认
            return start - 1;
        }
        //中间数字
        long mid = (end - start) / 2 + start;
        //计算本次
        long sum = mid * mid;
        //如果相同
        if (sum == target) {
            //返回
            return mid;
        }
        //判断方向
        if (sum > target) {
            //递归
            return next(target, start, mid - 1);
        } else {
            //递归
            return next(target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code4().mySqrt(3));
    }

}
