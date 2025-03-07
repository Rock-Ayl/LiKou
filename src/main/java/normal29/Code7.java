package normal29;

/**
 * @Author ayl
 * @Date 2024-02-22
 * 1329. 将矩阵按对角线排序
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 矩阵对角线 是一条从矩阵最上面行或者最左侧列中的某个元素开始的对角线，沿右下方向一直到矩阵末尾的元素。例如，矩阵 mat 有 6 行 3 列，从 mat[2][0] 开始的 矩阵对角线 将会经过 mat[2][0]、mat[3][1] 和 mat[4][2] 。
 * <p>
 * 给你一个 m * n 的整数矩阵 mat ，请你将同一条 矩阵对角线 上的元素按升序排序后，返回排好序的矩阵。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：mat = [[3,3,1,1],[2,2,1,2],[1,1,1,2]]
 * 输出：[[1,1,1,1],[1,2,2,2],[1,2,3,3]]
 * 示例 2：
 * <p>
 * 输入：mat = [[11,25,66,1,69,7],[23,55,17,45,15,52],[75,31,36,44,58,8],[22,27,33,25,68,4],[84,28,14,11,5,50]]
 * 输出：[[5,17,4,1,52,7],[11,11,25,45,8,69],[14,23,25,44,58,15],[22,27,31,36,50,66],[84,28,75,33,55,68]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 100
 * 1 <= mat[i][j] <= 100
 */
public class Code7 {

    /**
     * 排序实现
     *
     * @param mat 数组
     * @param x   首节点坐标x
     * @param y   首节点坐标y
     */
    private void sort(int[][] mat, int x, int y) {
        //最长距离
        int maxLength = Math.max(mat.length, mat[0].length);
        //循环
        for (int i = 0; i < maxLength; i++) {
            //当前节点坐标
            int thisX = x + i;
            int thisY = y + i;
            //如果越界
            if (thisX >= mat.length || thisY >= mat[0].length) {
                //跳出
                break;
            }
            //循环2
            for (int j = i + 1; j < maxLength; j++) {
                //下一个节点坐标
                int nextX = x + j;
                int nextY = y + j;
                //如果越界
                if (nextX >= mat.length || nextY >= mat[0].length) {
                    //跳出
                    break;
                }
                //如果需要交换
                if (mat[nextX][nextY] < mat[thisX][thisY]) {
                    //交换二者
                    int cache = mat[thisX][thisY];
                    mat[thisX][thisY] = mat[nextX][nextY];
                    mat[nextX][nextY] = cache;
                }
            }
        }
    }

    public int[][] diagonalSort(int[][] mat) {
        //循环1
        for (int i = mat.length - 1; i >= 0; i--) {
            //从首节点开始排序
            sort(mat, i, 0);
        }
        //循环2
        for (int i = 1; i < mat[0].length; i++) {
            //从首节点开始排序
            sort(mat, 0, i);
        }
        //返回
        return mat;
    }

    public static void main(String[] args) {
        int[][] ints = new Code7().diagonalSort(new int[][]{
                new int[]{3, 3, 1, 1},
                new int[]{2, 2, 1, 2},
                new int[]{1, 1, 1, 2}
        });
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
        System.out.println();
    }

}
