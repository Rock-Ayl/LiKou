package easy43;

/**
 * 4000. 给定数位和的最大整数
 * 算术评级: 2
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个非负整数 n 和 s。
 * <p>
 * 返回满足下述条件的 最大 整数：
 * <p>
 * 最多有 n 位数字。
 * 其各位数字之和等于 s 。
 * 如果不存在这样的整数，则返回 -1。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 2, s = 9
 * <p>
 * 输出： 90
 * <p>
 * 解释：
 * <p>
 * 最多由 2 位数字组成且各位数字之和为 9 的最大整数是 90。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 2, s = 19
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 不存在最多由 2 位数字组成且各位数字之和为 19 的整数，因此答案为 -1。
 * <p>
 * 示例 3：
 * <p>
 * 输入： n = 5, s = 0
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 唯一一个各位数字之和为 0 的非负整数是 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5
 * 0 <= s <= 100
 */
public class Code24 {

    public int largestInteger(int n, int s) {
        //数字
        int num = 0;
        //循环
        while (n-- > 0) {
            //本次
            int add = Math.min(s, 9);
            //叠加本次
            num = num * 10 + add;
            //下一个
            s -= add;
        }
        //返回
        return s > 0 ? -1 : num;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().largestInteger(2, 19));
    }

}
