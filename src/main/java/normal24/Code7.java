package normal24;

/**
 * @Author ayl
 * @Date 2023-09-19
 * 221. 最大正方形
 * 中等
 * 1.5K
 * 相关企业
 * 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：4
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [["0","1"],["1","0"]]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：matrix = [["0"]]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 300
 * matrix[i][j] 为 '0' 或 '1'
 */
public class Code7 {

    //结果
    private int max = 0;

    //递归计算
    public void next(char[][] matrix, int x, int y) {
        //如果当前不是
        if (matrix[x][y] != '1') {
            //过
            return;
        }
        //默认已经是长度为1的正方形了
        int width = 1;
        //跳出标记
        out:
        //循环
        while (true) {
            //当前坐标
            int thisX = x + width;
            int thisY = y + width;
            //如果有越界情况
            if (thisX >= matrix.length || thisY >= matrix[0].length) {
                //跳出
                break out;
            }
            //循环1
            for (int i = x; i < thisX; i++) {
                //如果不是
                if (matrix[i][thisY] == '0') {
                    //跳出
                    break out;
                }
            }
            //循环1
            for (int i = y; i < thisY; i++) {
                //如果不是
                if (matrix[thisX][i] == '0') {
                    //跳出
                    break out;
                }
            }
            //如果右下角不是
            if (matrix[thisX][thisY] == '0') {
                //跳出
                break out;
            }
            //正方形大一圈
            width++;
        }
        //刷新最大结果
        this.max = Math.max(this.max, width);
    }

    public int maximalSquare(char[][] matrix) {
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //实现
                next(matrix, i, j);
            }
        }
        //返回最大结果
        return max * max;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maximalSquare(new char[][]{
                new char[]{'0', '0', '0', '1', '0', '1', '1', '1'},
                new char[]{'0', '1', '1', '0', '0', '1', '0', '1'},
                new char[]{'1', '0', '1', '1', '1', '1', '0', '1'},
                new char[]{'0', '0', '0', '1', '0', '0', '0', '0'},
                new char[]{'0', '0', '1', '0', '0', '0', '1', '0'},
                new char[]{'1', '1', '1', '0', '0', '1', '1', '1'},
                new char[]{'1', '0', '0', '1', '1', '0', '0', '1'},
                new char[]{'0', '1', '0', '0', '1', '1', '0', '0'},
                new char[]{'1', '0', '0', '1', '0', '0', '0', '0'}
        }));
    }

}
