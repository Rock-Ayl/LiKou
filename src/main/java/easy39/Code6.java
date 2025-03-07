package easy39;

/**
 * @Author ayl
 * @Date 2024-12-18
 * 3360. 移除石头游戏
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * Alice 和 Bob 在玩一个游戏，他们俩轮流从一堆石头中移除石头，Alice 先进行操作。
 * <p>
 * Alice 在第一次操作中移除 恰好 10 个石头。
 * 接下来的每次操作中，每位玩家移除的石头数 恰好 为另一位玩家上一次操作的石头数减 1 。
 * 第一位没法进行操作的玩家输掉这个游戏。
 * <p>
 * 给你一个正整数 n 表示一开始石头的数目，如果 Alice 赢下这个游戏，请你返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 12
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * Alice 第一次操作中移除 10 个石头，剩下 2 个石头给 Bob 。
 * Bob 无法移除 9 个石头，所以 Alice 赢下游戏。
 * 示例 2：
 * <p>
 * 输入：n = 1
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * Alice 无法移除 10 个石头，所以 Alice 输掉游戏。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 */
public class Code6 {

    public boolean canAliceWin(int n) {
        //是否赢,默认输
        boolean win = false;
        //当前需要移除
        int count = 10;
        //循环
        while (n > 0 && n >= count) {
            //计算
            n -= count--;
            //改变结局
            win = !win;
        }
        //返回
        return win;
    }

    public static void main(String[] args) {

    }
}
