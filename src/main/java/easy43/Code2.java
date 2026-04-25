package easy43;

/**
 * 3898. 统计每个顶点的度
 * 算术评级: 2
 * 第 497 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1202
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个大小为 n x n 的二维整数数组 matrix，以邻接矩阵形式表示一个 无向图。该图包含 n 个顶点，编号从 0 到 n - 1。
 * <p>
 * matrix[i][j] = 1 表示顶点 i 与顶点 j 之间存在一条边。
 * matrix[i][j] = 0 表示顶点 i 与顶点 j 之间不存在边。
 * 顶点的 度（degree）定义为与该顶点相连的边的数量。
 * <p>
 * 请返回一个长度为 n 的整数数组 ans，其中 ans[i] 表示顶点 i 的度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入： matrix = [[0,1,1],[1,0,1],[1,1,0]]
 * <p>
 * 输出： [2,2,2]
 * <p>
 * 解释：
 * <p>
 * 顶点 0 与顶点 1 和 2 相连，因此其度为 2。
 * 顶点 1 与顶点 0 和 2 相连，因此其度为 2。
 * 顶点 2 与顶点 0 和 1 相连，因此其度为 2。
 * 因此，答案为 [2, 2, 2]。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入： matrix = [[0,1,0],[1,0,0],[0,0,0]]
 * <p>
 * 输出： [1,1,0]
 * <p>
 * 解释：
 * <p>
 * 顶点 0 与顶点 1 相连，因此其度为 1。
 * 顶点 1 与顶点 0 相连，因此其度为 1。
 * 顶点 2 没有与任何顶点相连，因此其度为 0。
 * 因此，答案为 [1, 1, 0]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： matrix = [[0]]
 * <p>
 * 输出： [0]
 * <p>
 * 解释：
 * <p>
 * 图中只有一个顶点，且没有任何边与其相连，因此答案为 [0]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == matrix.length == matrix[i].length <= 100
 * matrix[i][i] == 0
 * matrix[i][j] 仅为 0 或 1
 * matrix[i][j] == matrix[j][i]
 */
public class Code2 {

    public int[] findDegrees(int[][] matrix) {
        //结果
        int[] arr = new int[matrix[0].length];
        //循环
        for (int[] ints : matrix) {
            //循环2
            for (int i = 0; i < ints.length; i++) {
                //叠加本次
                arr[i] += ints[i];
            }
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {

    }

}
