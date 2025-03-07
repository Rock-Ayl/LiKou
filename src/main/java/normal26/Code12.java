package normal26;

/**
 * @Author ayl
 * @Date 2023-11-30
 * 2536. 子矩阵元素加 1
 * 提示
 * 中等
 * 40
 * 相关企业
 * 给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。
 * <p>
 * 另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：
 * <p>
 * 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
 * 返回执行完所有操作后得到的矩阵 mat 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
 * 输出：[[1,1,0],[1,2,1],[0,1,1]]
 * 解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
 * - 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。
 * - 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 2, queries = [[0,0,1,1]]
 * 输出：[[1,1],[1,1]]
 * 解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。
 * - 第一个操作：将矩阵中的每个元素加 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= queries.length <= 104
 * 0 <= row1i <= row2i < n
 * 0 <= col1i <= col2i < n
 */
public class Code12 {

    public int[][] rangeAddQueries(int n, int[][] queries) {
        //初始化结果
        int[][] result = new int[n][n];
        //循环
        for (int[] query : queries) {
            //循环1
            for (int i = query[0]; i <= query[2]; i++) {
                //循环2
                for (int j = query[1]; j <= query[3]; j++) {
                    //+1
                    result[i][j]++;
                }
            }
        }
        //返回
        return result;
    }

    //二维差分 特殊写法
    public int[][] star(int n, int[][] queries) {
        //二维差分模板
        int[][] diff = new int[n + 2][n + 2];
        //循环
        for (int[] q : queries) {
            //获取坐标
            int startX = q[0];
            int startY = q[1];
            int endX = q[2];
            int endY = q[3];

            //差分
            diff[startX + 1][startY + 1]++;
            diff[endX + 2][endY + 2]++;

            diff[startX + 1][endY + 2]--;
            diff[endX + 2][startY + 1]--;

            print(diff);

        }
        System.out.println("################################################");
        //循环1
        for (int i = 1; i <= n; ++i) {
            //循环2
            for (int j = 1; j <= n; ++j) {
                //计算
                diff[i][j] = diff[i][j] + diff[i][j - 1] + diff[i - 1][j] - diff[i - 1][j - 1];
                print(diff);
            }
        }
        //返回
        return diff;
    }

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
        System.out.println("#############");
    }

    public static void main(String[] args) {
        new Code12().star(3, new int[][]{
                new int[]{1, 1, 2, 2}
        });
    }

}
