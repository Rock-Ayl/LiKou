package easy43;

/**
 * 3950. 恰好一对连续置位
 * 算术评级: 2
 * 第 184 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1270
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n 。
 * <p>
 * 如果其二进制表示中 恰好 仅包含 一对 连续的置位 ，则返回 true ，否则返回 false 。
 * <p>
 * 整数中的 置位 是指其 二进制 表示中的 1 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 6
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 6 的二进制表示为 110 。
 * 恰好存在一对连续的置位（"11"）。因此，答案为 true 。
 * 示例 2：
 * <p>
 * 输入： n = 5
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 5 的二进制表示为 101 。
 * 不存在连续的置位。因此，答案为 false 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= n <= 105
 */
public class Code15 {

    public boolean consecutiveSetBits(int n) {
        //次数
        int count = 0;
        //当前最后数字
        int last = n % 2;
        //位移一次
        n = n >> 1;
        //循环
        while (n > 0) {
            //当前最后数字
            int num = n % 2;
            //如果满足一次,+1,并判断是否超了
            if (num == 1 && last == 1 && ++count == 2) {
                //直接返回不行
                return false;
            }
            //下一个
            last = num;
            n = n >> 1;
        }
        //判断是否满足1
        return count == 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().consecutiveSetBits(30));
    }

}
