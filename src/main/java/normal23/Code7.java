package normal23;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-08-17
 * 面试题 01.08. 零矩阵
 * 提示
 * 中等
 * 168
 * 相关企业
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * [
 * [1,1,1],
 * [1,0,1],
 * [1,1,1]
 * ]
 * 输出：
 * [
 * [1,0,1],
 * [0,0,0],
 * [1,0,1]
 * ]
 * 示例 2：
 * <p>
 * 输入：
 * [
 * [0,1,2,0],
 * [3,4,5,2],
 * [1,3,1,5]
 * ]
 * 输出：
 * [
 * [0,0,0,0],
 * [0,4,5,0],
 * [0,3,1,0]
 * ]
 */
public class Code7 {

    //删除上
    private void removeUp(int[][] matrix, int x, int y) {
        //如果越级
        if (x < 0) {
            //过
            return;
        }
        //删除
        matrix[x][y] = 0;
        //继续
        removeUp(matrix, x - 1, y);
    }

    //删除下
    private void removeDown(int[][] matrix, int x, int y) {
        //如果越级
        if (x >= matrix.length) {
            //过
            return;
        }
        //删除
        matrix[x][y] = 0;
        //继续
        removeDown(matrix, x + 1, y);
    }

    //删除左
    private void removeLeft(int[][] matrix, int x, int y) {
        //如果越级
        if (y < 0) {
            //过
            return;
        }
        //删除
        matrix[x][y] = 0;
        //继续
        removeLeft(matrix, x, y - 1);
    }

    //删除右
    private void removeRight(int[][] matrix, int x, int y) {
        //如果越级
        if (y >= matrix[0].length) {
            //过
            return;
        }
        //删除
        matrix[x][y] = 0;
        //继续
        removeRight(matrix, x, y + 1);
    }

    //删除这个0上下左右
    private void remove(int[][] matrix, int x, int y) {
        removeUp(matrix, x - 1, y);
        removeDown(matrix, x + 1, y);
        removeLeft(matrix, x, y - 1);
        removeRight(matrix, x, y + 1);
    }

    public void setZeroes(int[][] matrix) {
        //初始化要删除的坐标
        List<int[]> list = new ArrayList<>();
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //循环2
            for (int j = 0; j < matrix[0].length; j++) {
                //如果是自然0
                if (matrix[i][j] == 0) {
                    //记录
                    list.add(new int[]{i, j});
                }
            }
        }
        //循环
        for (int[] zeroIndex : list) {
            //删除
            remove(matrix, zeroIndex[0], zeroIndex[1]);
        }
    }

    public static void main(String[] args) {
        new Code7().setZeroes(new int[][]{
                new int[]{0, 1, 2, 0},
                new int[]{3, 4, 5, 2},
                new int[]{1, 3, 1, 5}
        });
    }
}