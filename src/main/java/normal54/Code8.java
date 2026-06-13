package normal54;

/**
 * 2139. 得到目标值的最少行动次数
 * 算术评级: 4
 * 第 276 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1417
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你正在玩一个整数游戏。从整数 1 开始，期望得到整数 target 。
 * <p>
 * 在一次行动中，你可以做下述两种操作之一：
 * <p>
 * 递增，将当前整数的值加 1（即， x = x + 1）。
 * 加倍，使当前整数的值翻倍（即，x = 2 * x）。
 * 在整个游戏过程中，你可以使用 递增 操作 任意 次数。但是只能使用 加倍 操作 至多 maxDoubles 次。
 * <p>
 * 给你两个整数 target 和 maxDoubles ，返回从 1 开始得到 target 需要的最少行动次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：target = 5, maxDoubles = 0
 * 输出：4
 * 解释：一直递增 1 直到得到 target 。
 * 示例 2：
 * <p>
 * 输入：target = 19, maxDoubles = 2
 * 输出：7
 * 解释：最初，x = 1 。
 * 递增 3 次，x = 4 。
 * 加倍 1 次，x = 8 。
 * 递增 1 次，x = 9 。
 * 加倍 1 次，x = 18 。
 * 递增 1 次，x = 19 。
 * 示例 3：
 * <p>
 * 输入：target = 10, maxDoubles = 4
 * 输出：4
 * 解释：
 * 最初，x = 1 。
 * 递增 1 次，x = 2 。
 * 加倍 1 次，x = 4 。
 * 递增 1 次，x = 5 。
 * 加倍 1 次，x = 10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= target <= 109
 * 0 <= maxDoubles <= 100
 */
public class Code8 {

    public int minMoves(int target, int maxDoubles) {
        //如果是奇数
        if (target % 2 != 0) {
            //递归
            return 1 + minMoves(target - 1, maxDoubles);
        }
        //如果还有倍数
        if (maxDoubles > 0 && target > 1) {
            //递归
            return 1 + minMoves(target / 2, maxDoubles - 1);
        }
        //实现
        return target - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().minMoves(19, 2));
    }

}
