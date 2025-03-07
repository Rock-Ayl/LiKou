package normal31;

/**
 * @Author ayl
 * @Date 2024-05-14
 * 1901. 寻找峰值 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一个 2D 网格中的 峰值 是指那些 严格大于 其相邻格子(上、下、左、右)的元素。
 * <p>
 * 给你一个 从 0 开始编号 的 m x n 矩阵 mat ，其中任意两个相邻格子的值都 不相同 。找出 任意一个 峰值 mat[i][j] 并 返回其位置 [i,j] 。
 * <p>
 * 你可以假设整个矩阵周边环绕着一圈值为 -1 的格子。
 * <p>
 * 要求必须写出时间复杂度为 O(m log(n)) 或 O(n log(m)) 的算法
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[1,4],[3,2]]
 * 输出: [0,1]
 * 解释: 3 和 4 都是峰值，所以[1,0]和[0,1]都是可接受的答案。
 * 示例 2:
 * <p>
 * <p>
 * <p>
 * 输入: mat = [[10,20,15],[21,30,14],[7,16,32]]
 * 输出: [1,1]
 * 解释: 30 和 32 都是峰值，所以[1,1]和[2,2]都是可接受的答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 500
 * 1 <= mat[i][j] <= 105
 * 任意两个相邻元素均不相等.
 */
public class Code15 {

    //获取数组值内容
    private int get(int[][] mat, int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= mat.length || y >= mat[0].length) {
            //过
            return -1;
        }
        //返回
        return mat[x][y];
    }

    public int[] findPeakGrid(int[][] mat) {
        //循环
        int x = 0;
        int y = 0;
        //循环
        while (true) {
            //当前数字
            int midNumber = mat[x][y];
            //如果该方向更大
            if (midNumber < get(mat, x, y + 1)) {
                //本轮过
                ++y;
                continue;
            }
            //如果该方向更大
            if (midNumber < get(mat, x + 1, y)) {
                //本轮过
                ++x;
                continue;
            }
            //如果该方向更大
            if (midNumber < get(mat, x - 1, y)) {
                //本轮过
                --x;
                continue;
            }
            //如果该方向更大
            if (midNumber < get(mat, x, y - 1)) {
                //本轮过
                --y;
                continue;
            }
            //返回目标结果
            return new int[]{x, y};
        }
    }

    public static void main(String[] args) {
        int[] peakGrid = new Code15().findPeakGrid(new int[][]{
                new int[]{1, 2, 99, 98, 22, 21, 20},
                new int[]{2, 3, 4, 6, 7, 8, 19},
                new int[]{3, 5, 6, 7, 8, 9, 18},
                new int[]{4, 6, 7, 8, 9, 10, 17},
                new int[]{6, 7, 8, 9, 10, 11, 16},
                new int[]{7, 8, 9, 10, 11, 12, 15},
                new int[]{8, 9, 10, 11, 12, 13, 14}
        });
        System.out.println();
    }

}
