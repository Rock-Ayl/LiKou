package normal16;

/**
 * @Author ayl
 * @Date 2022-08-29
 * 2177. 找到和为给定整数的三个连续整数
 * 给你一个整数 num ，请你返回三个连续的整数，它们的 和 为 num 。如果 num 无法被表示成三个连续整数的和，请你返回一个 空 数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 33
 * 输出：[10,11,12]
 * 解释：33 可以表示为 10 + 11 + 12 = 33 。
 * 10, 11, 12 是 3 个连续整数，所以返回 [10, 11, 12] 。
 * 示例 2：
 * <p>
 * 输入：num = 4
 * 输出：[]
 * 解释：没有办法将 4 表示成 3 个连续整数的和。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 1015
 */
public class Code7 {

    public long[] sumOfThree(long num) {
        //如果不满足
        if (num % 3 != 0) {
            //返回
            return new long[]{};
        }
        //中间的
        long mid = num / 3;
        //返回
        return new long[]{mid - 1, mid, mid + 1};
    }

}
