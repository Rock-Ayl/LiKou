package easy7;

/**
 * Created By Rock-Ayl on 2021-03-06
 * 766. 托普利茨矩阵
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * <p>
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
 * 输出：true
 * 解释：
 * 在上述矩阵中, 其对角线为:
 * "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]"。
 * 各条对角线上的所有元素均相同, 因此答案是 True 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2],[2,2]]
 * 输出：false
 * 解释：
 * 对角线 "[1, 2]" 上的元素不同。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 20
 * 0 <= matrix[i][j] <= 99
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 如果矩阵存储在磁盘上，并且内存有限，以至于一次最多只能将矩阵的一行加载到内存中，该怎么办？
 * 如果矩阵太大，以至于一次只能将不完整的一行加载到内存中，该怎么办？
 */
public class Code10 {

    public static boolean isToeplitzMatrix(int[][] matrix) {
        //左右的长度
        int iSize = matrix.length, jSize = matrix[0].length;
        //如果小于2行
        if (iSize < 2) {
            //默认可以
            return true;
        }
        //初始坐标
        int x = iSize - 2, y = 0;
        //循环
        while (y < jSize - 1) {
            //记录当前位置
            int a = x, b = y;
            //当前数是
            int thisNum = matrix[a][b];
            //如果还存在下一级
            while (a < iSize - 1 && b < jSize - 1) {
                //计算下一级
                a++;
                b++;
                //下一个数
                int nexNum = matrix[a][b];
                //如果下一级不同
                if (nexNum != thisNum) {
                    //直接不是
                    return false;
                }
            }
            //如果x还没有替换完
            if (x > 0) {
                //递减
                x--;
            } else {
                //递增
                y++;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isToeplitzMatrix(new int[][]{new int[]{1, 2, 3, 4}, new int[]{5, 1, 2, 3}, new int[]{9, 5, 1, 2}}));
    }
}
