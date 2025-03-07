package normal19;

/**
 * @Author ayl
 * @Date 2023-03-01
 * 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * <p>
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 104
 * 1 <= m * n <= 104
 * -105 <= mat[i][j] <= 105
 */
public class Code3 {

    //初始化结果
    private int[] result;
    //初始化结果坐标
    private int resultP = 0;

    //往下走
    private void down(int p, int[][] mat) {
        //当前坐标
        int x = 0;
        int y = mat.length - 1 + p;
        //如果没走完
        while (y >= 0) {
            if (check(x, y, mat)) {
                //记录本次结果
                result[resultP++] = mat[x][y];
            }
            //移动
            x++;
            y--;
        }
    }

    //往上走
    private void up(int p, int[][] mat) {
        //当前坐标
        int x = mat.length - 1 + p;
        int y = 0;
        //如果没走完
        while (x >= 0) {
            //如果未越界
            if (check(x, y, mat)) {
                //记录本次结果
                result[resultP++] = mat[x][y];
            }
            //移动
            x--;
            y++;
        }
    }

    //检查当前坐标是否越界
    private boolean check(int x, int y, int[][] mat) {
        //如果负数
        if (x < 0 || y < 0) {
            //不是
            return false;
        }
        //如果太长
        if (x >= mat.length || y >= mat[0].length) {
            //不是
            return false;
        }
        //默认未越界
        return true;
    }

    public int[] findDiagonalOrder(int[][] mat) {
        //当前结果
        result = new int[mat.length * mat[0].length];
        //默认从上走
        boolean up = true;
        //初始左下坐标
        int p = 0 - mat.length + 1;
        //如果还走
        while (p < mat[0].length) {
            //如果往上走
            if (up) {
                //走上走
                up(p, mat);
            } else {
                //往下走
                down(p, mat);
            }
            //更新方向和坐标
            up = !up;
            p++;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new Code3().findDiagonalOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        });
        System.out.println();
    }

}
