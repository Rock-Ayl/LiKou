package normal5;

/**
 * @Author ayl
 * @Date 2021-07-10
 * 74. 搜索二维矩阵
 * 编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性：
 * <p>
 * 每行中的整数从左到右按升序排列。
 * 每行的第一个整数大于前一行的最后一个整数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -104 <= matrix[i][j], target <= 104
 */
public class Code1 {

    //全局
    int[][] matrix;
    //目标
    int target;
    //当前位置
    int length;
    //当前位置xy
    int[] xy = new int[2];
    //边界
    int left;
    int right;

    //解析成xy
    public void xy(int point) {
        xy[0] = point / matrix[0].length;
        xy[1] = point % matrix[0].length;
    }

    public boolean search(int point) {
        //老边距
        int oldLeft = left;
        int oldRight = right;
        //解析一下xy
        xy(point);
        int x = xy[0], y = xy[1];
        //当前
        int num = matrix[x][y];
        //如果找到了目标值
        if (num == target) {
            //返回
            return true;
        }
        //如果还大
        if (num > target) {
            //更改边距
            right = point;
        } else {
            //更改边距
            left = point;
        }
        //下一步
        int next = (right - left) / 2 + left;
        //如果到头了
        if (oldLeft == left && oldRight == right) {
            //判断下盲点
            if (matrix[0][0] == target) {
                //可以
                return true;
            }
            //返回
            return false;
        }
        //下一步
        return search(next);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        //如果过小
        if (matrix.length * matrix[0].length <= 3) {
            //循环1
            for (int[] ints : matrix) {
                //循环2
                for (int anInt : ints) {
                    //如果找到了
                    if (anInt == target) {
                        //是
                        return true;
                    }
                }
            }
            //否
            return false;
        }
        //全局
        this.matrix = matrix;
        this.target = target;
        //当成一条线看s
        this.length = matrix.length * matrix[0].length;
        //边距
        this.left = 1;
        this.right = length;
        //开始搜索
        return search(length / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code1().searchMatrix(new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60}
        }, 1));
    }

}
