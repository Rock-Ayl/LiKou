package normal56;

import java.util.Arrays;

/**
 * 4034. 象到达目标格子的最少移动步数
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 8 x 8 的棋盘，行和列的下标从 1 开始。
 * <p>
 * 给你一个数组 source = [sr, sc]，表示 象 的起始位置，以及一个数组 target = [tr, tc]。在一步移动中，象可以在棋盘范围内沿着单个 对角线 方向移动任意数量的格子。
 * <p>
 * 返回象 恰好 到达 target 位置所需的 最少 移动次数。如果它永远无法到达 target，则返回 -1。
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
 * 一步对角线移动即可将象直接从 (8, 1) 送达 (1, 8)。
 * <p>
 * 示例 2：
 * <p>
 * 输入： source = [4,2], target = [1,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 象从 (4, 2) 移动到 (3, 1)，然后再从 (3, 1) 移动到 (1, 3)，经过 2 步移动到达目标位置。
 * <p>
 * 示例 3：
 * <p>
 * 输入： source = [1,1], target = [3,4]
 * <p>
 * 输出： -1
 * <p>
 * 解释：
 * <p>
 * 无论进行多少次对角线移动，从 (1, 1) 出发的象都永远无法到达 (3, 4)。因此，答案是 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * source.length == target.length == 2
 * 1 <= sr, sc, tr, tc <= 8
 * source != target
 */
public class Code19 {

    public int minBishopMoves(int[] source, int[] target) {
        //如果是目标
        if (Arrays.equals(source, target)) {
            //返回
            return 0;
        }
        //如果一个黑一个白
        if ((Math.abs(source[0] - source[1]) % 2) != Math.abs(target[0] - target[1]) % 2) {
            //不行
            return -1;
        }
        //如果一步到位
        if (Math.abs(source[0] - target[0]) == Math.abs(source[1] - target[1])) {
            //返回
            return 1;
        }
        //最多2步
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().minBishopMoves(new int[]{8, 1}, new int[]{1, 8}));
    }

}
