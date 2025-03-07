package normal31;

/**
 * @Author ayl
 * @Date 2024-04-24
 * 240. 搜索二维矩阵 II
 * 中等
 * 相关标签
 * 相关企业
 * 编写一个高效的算法来搜索 m x n 矩阵 matrix 中的一个目标值 target 。该矩阵具有以下特性：
 * <p>
 * 每行的元素从左到右升序排列。
 * 每列的元素从上到下升序排列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 5
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,4,7,11,15],[2,5,8,12,19],[3,6,9,16,22],[10,13,14,17,24],[18,21,23,26,30]], target = 20
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= n, m <= 300
 * -109 <= matrix[i][j] <= 109
 * 每行的所有元素从左到右升序排列
 * 每列的所有元素从上到下升序排列
 * -109 <= target <= 109
 */
public class Code5 {

    //递归实现
    private boolean find(int[][] matrix, int target, int startX, int startY, int endX, int endY) {
        //如果到头了
        if (startX + 1 >= endX && startY + 1 >= endY) {
            //判断最后的4个数字
            return matrix[startX][startY] == target ||
                    matrix[endX][startY] == target ||
                    matrix[startX][endY] == target ||
                    matrix[endX][endY] == target;
        }
        //计算中点坐标
        int midX = (endX - startX) / 2 + startX;
        int midY = (endY - startY) / 2 + startY;
        //如果是目标
        if (matrix[midX][midY] == target) {
            //返回
            return true;
        }
        //如果中间比目标更大
        if (matrix[midX][midY] > target) {
            //继续缩小范围
            boolean min = find(matrix, target, startX, startY, midX, midY);
            //如果是
            if (min) {
                //返回
                return true;
            }
        } else {
            //继续缩小范围
            boolean max = find(matrix, target, midX, midY, endX, endY);
            //如果是
            if (max) {
                //返回
                return true;
            }
        }
        //第二种情况(左下)
        boolean two = find(matrix, target, midX, startY, endX, midY);
        //如果是
        if (two) {
            //返回
            return true;
        }
        //第三种情况(右上)
        boolean three = find(matrix, target, startX, midY, midX, endY);
        //如果是
        if (three) {
            //返回
            return true;
        }
        //默认
        return false;
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //寻找
        return find(matrix, target, 0, 0, matrix.length - 1, matrix[0].length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code5().searchMatrix(new int[][]{
                new int[]{1, 2, 3, 4, 5},
                new int[]{6, 7, 8, 9, 10},
                new int[]{11, 12, 13, 14, 15},
                new int[]{16, 17, 18, 19, 20},
                new int[]{21, 22, 23, 24, 25}
        }, 5));
    }

}
