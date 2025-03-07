package easy35;

/**
 * @Author ayl
 * @Date 2023-11-11
 * 2923. 找到冠军 I
 * 提示
 * 简单
 * 4
 * 相关企业
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。
 * <p>
 * 给你一个下标从 0 开始、大小为 n * n 的二维布尔矩阵 grid 。对于满足 0 <= i, j <= n - 1 且 i != j 的所有 i, j ：如果 grid[i][j] == 1，那么 i 队比 j 队 强 ；否则，j 队比 i 队 强 。
 * <p>
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 * <p>
 * 返回这场比赛中将会成为冠军的队伍。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [[0,1],[0,0]]
 * 输出：0
 * 解释：比赛中有两支队伍。
 * grid[0][1] == 1 表示 0 队比 1 队强。所以 0 队是冠军。
 * 示例 2：
 * <p>
 * 输入：grid = [[0,0,1],[1,0,1],[0,0,0]]
 * 输出：1
 * 解释：比赛中有三支队伍。
 * grid[1][0] == 1 表示 1 队比 0 队强。
 * grid[1][2] == 1 表示 1 队比 2 队强。
 * 所以 1 队是冠军。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * n == grid[i].length
 * 2 <= n <= 100
 * grid[i][j] 的值为 0 或 1
 * 对于所有 i， grid[i][i] 等于 0.
 * 对于满足 i != j 的所有 i, j ，grid[i][j] != grid[j][i] 均成立
 * 生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强
 */
public class Code3 {

    public int findChampion(int[][] grid) {
        //跳出标记
        io:
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果是自己
                if (i == j) {
                    //本轮过
                    continue;
                }
                //如果失败了
                if (grid[i][j] == 0) {
                    //跳出
                    continue io;
                }
            }
            //返回结果
            return i;
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().findChampion(new int[][]{
                new int[]{0, 0, 1},
                new int[]{1, 0, 1},
                new int[]{0, 0, 0}
        }));
    }

}
