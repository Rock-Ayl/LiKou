package easy28;

/**
 * @Author ayl
 * @Date 2023-02-14
 * 1582. 二进制矩阵中的特殊位置
 * 给你一个大小为 rows x cols 的矩阵 mat，其中 mat[i][j] 是 0 或 1，请返回 矩阵 mat 中特殊位置的数目 。
 * <p>
 * 特殊位置 定义：如果 mat[i][j] == 1 并且第 i 行和第 j 列中的所有其他元素均为 0（行和列的下标均 从 0 开始 ），则位置 (i, j) 被称为特殊位置。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,0,1],
 * [1,0,0]]
 * 输出：1
 * 解释：(1,2) 是一个特殊位置，因为 mat[1][2] == 1 且所处的行和列上所有其他元素都是 0
 * 示例 2：
 * <p>
 * 输入：mat = [[1,0,0],
 * [0,1,0],
 * [0,0,1]]
 * 输出：3
 * 解释：(0,0), (1,1) 和 (2,2) 都是特殊位置
 * 示例 3：
 * <p>
 * 输入：mat = [[0,0,0,1],
 * [1,0,0,0],
 * [0,1,1,0],
 * [0,0,0,0]]
 * 输出：2
 * 示例 4：
 * <p>
 * 输入：mat = [[0,0,0,0,0],
 * [1,0,0,0,0],
 * [0,1,0,0,0],
 * [0,0,1,0,0],
 * [0,0,0,1,1]]
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * rows == mat.length
 * cols == mat[i].length
 * 1 <= rows, cols <= 100
 * mat[i][j] 是 0 或 1
 */
public class Code4 {

    public int numSpecial(int[][] mat) {
        //次数
        int count = 0;
        //循环1
        for (int i = 0; i < mat.length; i++) {
            //循环2
            for (int j = 0; j < mat[0].length; j++) {
                //如果是
                if (mat[i][j] == 1 && check(i, j, mat)) {
                    //记录
                    count++;
                }
            }
        }
        //返回
        return count;
    }

    //检查
    public boolean check(int x, int y, int[][] mat) {
        //上
        int up = y - 1;
        //循环
        while (up >= 0) {
            //如果撞墙
            if (mat[x][up--] == 1) {
                //不是
                return false;
            }
        }
        //下
        int down = y + 1;
        //循环
        while (down < mat[0].length) {
            //如果撞墙
            if (mat[x][down++] == 1) {
                //不是
                return false;
            }
        }
        //上
        int left = x - 1;
        //循环
        while (left >= 0) {
            //如果撞墙
            if (mat[left--][y] == 1) {
                //不是
                return false;
            }
        }
        //下
        int right = x + 1;
        //循环
        while (right < mat.length) {
            //如果撞墙
            if (mat[right++][y] == 1) {
                //不是
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().numSpecial(new int[][]{
                new int[]{0, 0, 1, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 0, 0, 0},
                new int[]{0, 1, 0, 0}
        }));
    }
}
