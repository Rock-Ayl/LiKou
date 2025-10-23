package normal47;

/**
 * @Author ayl
 * @Date 2025-10-23
 * 面试题 10.09. 排序矩阵查找
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定 M×N 矩阵，每一行、每一列都按升序排列，请编写代码找出某元素。
 * <p>
 * 示例：
 * <p>
 * 现有矩阵 matrix 如下：
 * <p>
 * [
 * [1,   4,  7, 11, 15],
 * [2,   5,  8, 12, 19],
 * [3,   6,  9, 16, 22],
 * [10, 13, 14, 17, 24],
 * [18, 21, 23, 26, 30]
 * ]
 * 给定 target = 5，返回 true。
 * <p>
 * 给定 target = 20，返回 false。
 */
public class Code9 {

    public boolean searchMatrix(int[][] matrix, int target) {
        //如果没有
        if (matrix.length == 0 || matrix[0].length == 0) {
            //过
            return false;
        }
        //开始位置
        int x = 0;
        int y = matrix[0].length - 1;
        //递归寻找
        return find(matrix, x, y, target);
    }

    //递归寻找
    private boolean find(int[][] matrix, int x, int y, int target) {
        //如果越界
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            //过
            return false;
        }
        //如果是目标
        if (matrix[x][y] == target) {
            //返回
            return true;
        }
        //判断与目标相比大小
        if (matrix[x][y] < target) {
            //递归
            return find(matrix, x + 1, y, target);
        } else {
            //递归
            return find(matrix, x, y - 1, target);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code9().searchMatrix(new int[][]{
                new int[]{1, 4, 7, 11, 15},
                new int[]{2, 5, 8, 12, 19},
                new int[]{3, 6, 9, 16, 22},
                new int[]{10, 13, 14, 17, 24},
                new int[]{18, 21, 23, 26, 30}
        }, 20));
    }

}
