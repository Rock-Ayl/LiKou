package normal21;

/**
 * @Author ayl
 * @Date 2023-06-08
 * 剑指 Offer II 098. 路径的数目
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：m = 3, n = 7
 * 输出：28
 * 示例 2：
 * <p>
 * 输入：m = 3, n = 2
 * 输出：3
 * 解释：
 * 从左上角开始，总共有 3 条路径可以到达右下角。
 * 1. 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右
 * 3. 向下 -> 向右 -> 向下
 * 示例 3：
 * <p>
 * 输入：m = 7, n = 3
 * 输出：28
 * 示例 4：
 * <p>
 * 输入：m = 3, n = 3
 * 输出：6
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 100
 * 题目数据保证答案小于等于 2 * 109
 * <p>
 * <p>
 * 注意：本题与主站 62 题相同： https://leetcode-cn.com/problems/unique-paths/
 */
public class Code2 {

    public int uniquePaths(int m, int n) {
        //初始化
        int[][] arr = new int[m][n];
        //循环
        for (int i = 0; i < m; i++) {
            //初始化1
            arr[i][0] = 1;
        }
        //循环
        for (int i = 0; i < n; i++) {
            //初始化1
            arr[0][i] = 1;
        }
        //循环
        for (int i = 1; i < m; i++) {
            //循环2
            for (int j = 1; j < n; j++) {
                //计算
                arr[i][j] = arr[i - 1][j] + arr[i][j - 1];
            }
        }
        //返回
        return arr[m - 1][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code2().uniquePaths(3, 7));
        ;
    }

}
