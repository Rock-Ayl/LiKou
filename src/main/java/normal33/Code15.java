package normal33;

/**
 * @Author ayl
 * @Date 2024-07-21
 * 100375. 求出硬币游戏的赢家
 * 简单
 * 相关企业
 * 提示
 * 给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
 * <p>
 * Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名玩家无法执行此操作，那么这名玩家 输掉 游戏。
 * <p>
 * 两名玩家都采取 最优 策略，请你返回游戏的赢家。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：x = 2, y = 7
 * <p>
 * 输出："Alice"
 * <p>
 * 解释：
 * <p>
 * 游戏一次操作后结束：
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * 示例 2：
 * <p>
 * 输入：x = 4, y = 11
 * <p>
 * 输出："Bob"
 * <p>
 * 解释：
 * <p>
 * 游戏 2 次操作后结束：
 * <p>
 * Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= x, y <= 100
 */
public class Code15 {

    public String losingPlayer(int x, int y) {
        //计算出可以配对的次数,并返回结果
        return Math.min(x, y / 4) % 2 == 1 ? "Alice" : "Bob";
    }

    public static void main(String[] args) {

    }

}
