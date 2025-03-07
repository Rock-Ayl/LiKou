package normal3;

/**
 * Created By Rock-Ayl on 2021-04-30
 * 695. 岛屿的最大面积
 * 给定一个包含了一些 0 和 1 的非空二维数组 grid 。
 * <p>
 * 一个 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在水平或者竖直方向上相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为 0 。)
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,1,1,0,1,0,0,0,0,0,0,0,0],
 * [0,1,0,0,1,1,0,0,1,0,1,0,0],
 * [0,1,0,0,1,1,0,0,1,1,1,0,0],
 * [0,0,0,0,0,0,0,0,0,0,1,0,0],
 * [0,0,0,0,0,0,0,1,1,1,0,0,0],
 * [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是 11 ，因为岛屿只能包含水平或垂直的四个方向的 1 。
 * <p>
 * 示例 2:
 * <p>
 * [[0,0,0,0,0,0,0,0]]
 * 对于上面这个给定的矩阵, 返回 0。
 * <p>
 * <p>
 * <p>
 * 注意: 给定的矩阵grid 的长度和宽度都不超过 50。
 */
public class Code8 {

    //最大岛屿尺寸
    int max = 0;
    //当前尺寸
    int thisSize = 0;
    //全局arr
    int[][] arr;

    public void count(int x, int y) {
        //如果越界
        if (x > arr.length - 1 || y > arr[0].length - 1 || x < 0 || y < 0) {
            //结束
            return;
        }
        //当前空间
        int space = arr[x][y];
        //如果是海
        if (space == 0) {
            //结束
            return;
        }
        //清算为海
        arr[x][y] = 0;
        //当前尺寸+1
        thisSize++;
        //向四周
        count(x + 1, y);
        count(x - 1, y);
        count(x, y + 1);
        count(x, y - 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        //全局
        this.arr = grid;
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //循环2
            for (int j = 0; j < arr[0].length; j++) {
                //当前空间
                int space = arr[i][j];
                //如果是陆地
                if (space == 1) {
                    //清算之前的
                    thisSize = 0;
                    //计算
                    count(i, j);
                    //如果这次岛屿比之前的大
                    if (max < thisSize) {
                        //更新
                        max = thisSize;
                    }
                }
            }
        }
        //返回
        return this.max;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxAreaOfIsland(new int[][]{
                new int[]{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                new int[]{0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                new int[]{0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0},
        }));
    }
}
