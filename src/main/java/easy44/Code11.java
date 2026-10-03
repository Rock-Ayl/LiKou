package easy44;

/**
 * 4061. 皇后到达目标格子的最少移动步数
 * 同步题目状态
 * <p>
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 一个 8 x 8 的空棋盘，其行和列的下标从 1 开始。
 * <p>
 * 给你一个数组 source = [sr, sc] 表示 皇后 的初始位置，以及一个数组 target = [tr, tc] 表示目标位置。
 * <p>
 * 在一步移动中，皇后可以在棋盘范围内，沿着单条 行 、 列 或 对角线 移动一个或多个方格。
 * <p>
 * 返回皇后移动到 恰好 落在 target 位置所需的 最小 移动次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： source = [8,1], target = [1,8]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 单次对角线移动即可让皇后直接从 (8, 1) 移动到 (1, 8)。
 * <p>
 * 示例 2：
 * <p>
 * 输入： source = [4,2], target = [1,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * ​​​​​​​
 * <p>
 * 皇后先从 (4, 2) 移动到 (4, 3)，然后从 (4, 3) 移动到 (1, 3)，共用 2 步移动到达目标位置。
 * <p>
 * 示例 3：
 * <p>
 * 输入： source = [1,1], target = [1,1]
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 皇后已经处于目标位置，因此不需要任何移动。
 * <p>
 * <p>
 * <p>
 * 提示：​​​​​​​
 * <p>
 * source == [sr, sc]
 * target == [tr, tc]
 * 1 <= sr, sc, tr, tc <= 8
 */
public class Code11 {

    public int minQueenMoves(int[] source, int[] target) {
        //获取坐标
        int sr = source[0];
        int sc = source[1];
        int tr = target[0];
        int tc = target[1];
        //如果完全相同
        if (sr == tr && sc == tc) {
            //返回
            return 0;
        }
        //如果行相同
        if (sr == tr) {
            //返回
            return 1;
        }
        //如果列相同
        if (sc == tc) {
            //返回
            return 1;
        }
        //如果对角线相同
        if (Math.abs(sr - tr) == Math.abs(sc - tc)) {
            //返回
            return 1;
        }
        //默认
        return 2;
    }

    public static void main(String[] args) {
        new Code11().minQueenMoves(new int[]{8, 1}, new int[]{1, 8});
    }

}
