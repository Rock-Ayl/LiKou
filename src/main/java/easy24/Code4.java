package easy24;

/**
 * @Author ayl
 * @Date 2022-10-18
 * 1886. 判断矩阵经轮转后是否一致
 * 给你两个大小为 n x n 的二进制矩阵 mat 和 target 。现 以 90 度顺时针轮转 矩阵 mat 中的元素 若干次 ，如果能够使 mat 与 target 一致，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
 * 输出：true
 * 解释：顺时针轮转 90 度一次可以使 mat 和 target 一致。
 * 示例 2：
 * <p>
 * <p>
 * 输入：mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
 * 输出：false
 * 解释：无法通过轮转矩阵中的元素使 equal 与 target 一致。
 * 示例 3：
 * <p>
 * <p>
 * 输入：mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
 * 输出：true
 * 解释：顺时针轮转 90 度两次可以使 mat 和 target 一致。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == mat.length == target.length
 * n == mat[i].length == target[i].length
 * 1 <= n <= 10
 * mat[i][j] 和 target[i][j] 不是 0 就是 1
 */
public class Code4 {

    //判断是否相同
    public boolean same(int[][] target, int[][] arr) {
        //循环
        for (int i = 0; i < target.length; i++) {
            //循环2
            for (int j = 0; j < target[0].length; j++) {
                //如果不同
                if (target[i][j] != arr[i][j]) {
                    //不是
                    return false;
                }
            }
        }
        //默认是
        return true;
    }

    //反转90度,到第五圈返回false
    public boolean findRotation(int[][] mat, int[][] target, int count) {
        //如果开始转第五圈
        if (count == 5) {
            //过
            return false;
        }
        //初始化旋转后
        int[][] arr = new int[mat.length][mat[0].length];
        //数组坐标
        int x = 0;
        int y = 0;
        //循环2
        for (int j = 0; j < target[0].length; j++) {
            //循环1
            for (int i = target.length - 1; i >= 0; i--) {
                //记录
                arr[x][y++] = mat[i][j];
                //如果满了
                if (y == target[0].length) {
                    //下一行
                    x++;
                    y = 0;
                }
            }
        }
        //如果旋转后是目标
        if (same(target, arr)) {
            //返回是
            return true;
        }
        //默认不可以
        return findRotation(arr, target, count + 1);
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        //实现
        return findRotation(mat, target, 1);
    }

}
