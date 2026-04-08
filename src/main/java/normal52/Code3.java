package normal52;

/**
 * 2571. 将整数减少到零需要的最少操作数
 * 算术评级: 4
 * 第 333 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1649
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数 n ，你可以执行下述操作 任意 次：
 * <p>
 * n 加上或减去 2 的某个 幂
 * 返回使 n 等于 0 需要执行的 最少 操作数。
 * <p>
 * 如果 x == 2i 且其中 i >= 0 ，则数字 x 是 2 的幂。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 39
 * 输出：3
 * 解释：我们可以执行下述操作：
 * - n 加上 20 = 1 ，得到 n = 40 。
 * - n 减去 23 = 8 ，得到 n = 32 。
 * - n 减去 25 = 32 ，得到 n = 0 。
 * 可以证明使 n 等于 0 需要执行的最少操作数是 3 。
 * 示例 2：
 * <p>
 * 输入：n = 54
 * 输出：3
 * 解释：我们可以执行下述操作：
 * - n 加上 21 = 2 ，得到 n = 56 。
 * - n 加上 23 = 8 ，得到 n = 64 。
 * - n 减去 26 = 64 ，得到 n = 0 。
 * 使 n 等于 0 需要执行的最少操作数是 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 */
public class Code3 {

    public int minOperations(int n) {
        //增减次数
        int count = 0;
        //转为二进制
        char[] charArray = Integer.toBinaryString(n).toCharArray();
        //循环
        for (int i = charArray.length - 1; i >= 0; i--) {
            //如果当前为0
            if (charArray[i] == '0') {
                //本轮过
                continue;
            }
            //如果前面是0
            if (i == 0 || charArray[i - 1] == '0') {
                //直接减去
                charArray[i] = '0';
                //操作+1
                count++;
            } else {
                //索引
                int index = i;
                //如果满足
                while (index > 0 && charArray[index] == '1') {
                    //进位
                    charArray[index--] = '0';
                }
                //如果进位到最前面
                if (index >= 0) {
                    //记录
                    charArray[index] = '1';
                }
                //操作+1
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().minOperations(39));
    }

}
