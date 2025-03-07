package normal2;

/**
 * Created By Rock-Ayl on 2021-04-08
 * 1020. 飞地的数量
 * 给出一个二维数组 A，每个单元格为 0（代表海）或 1（代表陆地）。
 * <p>
 * 移动是指在陆地上从一个地方走到另一个地方（朝四个方向之一）或离开网格的边界。
 * <p>
 * 返回网格中无法在任意次数的移动中离开网格边界的陆地单元格的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
 * 输出：3
 * 解释：
 * 有三个 1 被 0 包围。一个 1 没有被包围，因为它在边界上。
 * 示例 2：
 * <p>
 * 输入：[[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
 * 输出：0
 * 解释：
 * 所有 1 都在边界上或可以到达边界。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 500
 * 1 <= A[i].length <= 500
 * 0 <= A[i][j] <= 1
 * 所有行的大小都相同
 */
public class Code7 {

    int[][] all;

    /**
     * 删除连接的陆地
     *
     * @return
     */
    public void remove(int x, int y) {
        //如果没有越界
        if (x >= 0 && x < all.length && y >= 0 && y < all[0].length) {
            //如果是陆地
            if (all[x][y] == 1) {
                //改为大海
                all[x][y] = 0;
                //上下左右
                remove(x + 1, y);
                //上下左右
                remove(x, y + 1);
                //上下左右
                remove(x - 1, y);
                //上下左右
                remove(x, y - 1);
            }
        }
    }

    /**
     * 懒得优化了
     *
     * @param grid
     * @return
     */
    public int numEnclaves(int[][] grid) {
        all = grid;
        //没有到达边界的陆地
        int size = 0;
        //初始位置
        int x = 0, y = 0;
        //循环
        while (y < all[0].length) {
            //删除
            remove(x, y);
            //递增
            y++;
        }
        //防止越界
        y--;
        //循环2
        while (x < all.length) {
            //删除
            remove(x, y);
            //递增
            x++;
        }
        //防止越界
        x--;
        //循环3
        while (y >= 0) {
            //删除
            remove(x, y);
            //递增
            y--;
        }
        //防止越界
        y = 0;
        //循环4
        while (x >= 0) {
            //删除
            remove(x, y);
            //递增
            x--;
        }
        //循环1
        for (int[] ints : grid) {
            //循环2
            for (int anInt : ints) {
                //如果还是陆地
                if (anInt == 1) {
                    //记录
                    size++;
                }
            }
        }
        //返回
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().numEnclaves(new int[][]{
                new int[]{0, 0, 0, 0},
                new int[]{1, 0, 1, 0},
                new int[]{0, 1, 1, 0},
                new int[]{0, 0, 0, 0}
        }));
    }
}
