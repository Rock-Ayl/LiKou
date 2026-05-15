package easy43;

/**
 * 1952. 三除数
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n 。如果 n 恰好有三个正除数 ，返回 true ；否则，返回 false 。
 * <p>
 * 如果存在整数 k ，满足 n = k * m ，那么整数 m 就是 n 的一个 除数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：false
 * 解释：2 只有两个除数：1 和 2 。
 * 示例 2：
 * <p>
 * 输入：n = 4
 * 输出：true
 * 解释：4 有三个除数：1、2 和 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 104
 */
public class Code8 {

    public boolean isThree(int n) {
        //如果是偶数
        if (n % 2 == 0) {
            //只有4是
            return n == 4;
        }
        //次数
        int count = 0;
        //循环
        for (int num = 2; num < n; num++) {
            //如果能除 and +1,判断是否超出数量
            if (n % num == 0 && ++count == 2) {
                //不是
                return false;
            }
        }
        //结果
        return count == 1;
    }

}
