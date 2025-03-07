package normal40;

/**
 * @Author ayl
 * @Date 2025-02-22
 * 3446. 按对角线进行矩阵排序
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵：
 * <p>
 * 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。
 * 右上角三角形 的对角线按 非递减顺序 排序。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[1,7,3],[9,8,2],[4,5,6]]
 * <p>
 * 输出： [[8,2,3],[9,6,7],[4,5,1]]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 标有黑色箭头的对角线（左下角三角形）应按非递增顺序排序：
 * <p>
 * [1, 8, 6] 变为 [8, 6, 1]。
 * [9, 5] 和 [4] 保持不变。
 * 标有蓝色箭头的对角线（右上角三角形）应按非递减顺序排序：
 * <p>
 * [7, 2] 变为 [2, 7]。
 * [3] 保持不变。
 * 示例 2：
 * <p>
 * 输入： grid = [[0,1],[1,2]]
 * <p>
 * 输出： [[2,1],[1,0]]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 标有黑色箭头的对角线必须按非递增顺序排序，因此 [0, 2] 变为 [2, 0]。其他对角线已经符合要求。
 * <p>
 * 示例 3：
 * <p>
 * 输入： grid = [[1]]
 * <p>
 * 输出： [[1]]
 * <p>
 * 解释：
 * <p>
 * 只有一个元素的对角线已经符合要求，因此无需修改。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * grid.length == grid[i].length == n
 * 1 <= n <= 10
 * -105 <= grid[i][j] <= 105
 */
public class Code10 {

    public int[][] sortMatrix(int[][] grid) {
        //次数
        int count = grid.length + grid[0].length - 1;
        //起始坐标
        int x = grid.length - 1;
        int y = 0;
        //是否为上
        boolean up = true;
        //循环
        while (count-- > 0) {
            //执行本次排序
            sort(grid, x, y, up);
            //变更方向
            if (x == 0) {
                //变更方向
                up = false;
            }
            //根据方向,计算下一个头节点
            if (up == true) {
                //移动
                --x;
            } else {
                //移动
                y++;
            }
        }
        //返回结果
        return grid;
    }

    //排序
    private void sort(int[][] grid, int startX, int startY, boolean up) {
        //如果是数组内
        while (inArr(grid, startX, startY) == true) {
            //下一个坐标
            int nextX = startX + 1;
            int nextY = startY + 1;
            //如果下一个也是数组内
            while (inArr(grid, nextX, nextY) == true) {
                //计算大小
                int big = Math.max(grid[startX][startY], grid[nextX][nextY]);
                int small = Math.min(grid[startX][startY], grid[nextX][nextY]);
                //判断排序是正序还是倒序
                if (up == true) {
                    //倒序
                    grid[startX][startY] = big;
                    grid[nextX][nextY] = small;
                } else {
                    //正序
                    grid[startX][startY] = small;
                    grid[nextX][nextY] = big;
                }
                //下一个
                nextX++;
                nextY++;
            }
            //下一个
            startX++;
            startY++;
        }
    }

    //如果坐标是数组内
    private boolean inArr(int[][] grid, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //不是
            return false;
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {

        /*int[][] ints = new Code10().sortMatrix(new int[][]{
                new int[]{1, 7, 3},
                new int[]{9, 8, 2},
                new int[]{4, 5, 6}
        });*/

        int[][] ints = new Code10().sortMatrix(new int[][]{
                new int[]{-1, -2, -3},
                new int[]{-3, -3, -2},
                new int[]{-4, -4, 0}
        });

        print(ints);
    }

    private static void print(int[][] arr) {
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //循环2
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j]);
                System.out.print(",");
            }
            System.out.println();
        }
        System.out.println("#########");
    }

}
