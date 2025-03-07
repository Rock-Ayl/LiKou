package normal6;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-08-02
 * 73. 矩阵置零
 * 给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
 * <p>
 * 进阶：
 * <p>
 * 一个直观的解决方案是使用  O(mn) 的额外空间，但这并不是一个好的解决方案。
 * 一个简单的改进方案是使用 O(m + n) 的额外空间，但这仍然不是最好的解决方案。
 * 你能想出一个仅使用常量空间的解决方案吗？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：[[1,0,1],[0,0,0],[1,0,1]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[0].length
 * 1 <= m, n <= 200
 * -231 <= matrix[i][j] <= 231 - 1
 */
public class Code1 {

    public void setZeroes(int[][] matrix) {
        //需要修改的
        List<List<Integer>> list = new ArrayList<>();
        //循环
        for (int i = 0; i < matrix.length; i++) {
            //循环
            for (int j = 0; j < matrix[0].length; j++) {
                //如果是0
                if (matrix[i][j] == 0) {
                    //坐标变为list
                    List<Integer> xy = new ArrayList<>(2);
                    xy.add(i);
                    xy.add(j);
                    //记录坐标
                    list.add(xy);
                }
            }
        }
        //如果存在
        if (list.size() > 0) {
            //循环
            for (List<Integer> xy : list) {
                //对应x,y
                int x = xy.get(0), y = xy.get(1);
                //循环x轴
                for (int i = 0; i < matrix.length; i++) {
                    //置0
                    matrix[i][y] = 0;
                }
                //循环y轴
                for (int i = 0; i < matrix[0].length; i++) {
                    //置0
                    matrix[x][i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Code1().setZeroes(new int[][]{
                new int[]{1, 1, 1},
                new int[]{1, 0, 1},
                new int[]{1, 1, 1}
        });
    }

}
