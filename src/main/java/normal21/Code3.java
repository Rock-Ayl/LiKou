package normal21;

/**
 * @Author ayl
 * @Date 2023-06-09
 * 剑指 Offer II 091. 粉刷房子
 * 假如有一排房子，共 n 个，每个房子可以被粉刷成红色、蓝色或者绿色这三种颜色中的一种，你需要粉刷所有的房子并且使其相邻的两个房子颜色不能相同。
 * <p>
 * 当然，因为市场上不同颜色油漆的价格不同，所以房子粉刷成不同颜色的花费成本也是不同的。每个房子粉刷成不同颜色的花费是以一个 n x 3 的正整数矩阵 costs 来表示的。
 * <p>
 * 例如，costs[0][0] 表示第 0 号房子粉刷成红色的成本花费；costs[1][2] 表示第 1 号房子粉刷成绿色的花费，以此类推。
 * <p>
 * 请计算出粉刷完所有房子最少的花费成本。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: costs = [[17,2,17],[16,16,5],[14,3,19]]
 * 输出: 10
 * 解释: 将 0 号房子粉刷成蓝色，1 号房子粉刷成绿色，2 号房子粉刷成蓝色。
 * 最少花费: 2 + 5 + 3 = 10。
 * 示例 2：
 * <p>
 * 输入: costs = [[7,6,2]]
 * 输出: 2
 * <p>
 * <p>
 * 提示:
 * <p>
 * costs.length == n
 * costs[i].length == 3
 * 1 <= n <= 100
 * 1 <= costs[i][j] <= 20
 * <p>
 * <p>
 * 注意：本题与主站 256 题相同：https://leetcode-cn.com/problems/paint-house/
 */
public class Code3 {

    public int minCost(int[][] costs) {
        //红黄蓝初始化
        int red = 0;
        int yellow = 0;
        int blue = 0;
        //循环
        for (int i = 0; i < costs.length; i++) {
            //计算当层三种颜色
            int nextRed = costs[i][0] + Math.min(yellow, blue);
            int nextYellow = costs[i][1] + Math.min(red, blue);
            int nextBlue = costs[i][2] + Math.min(red, yellow);
            //更新最小颜色
            red = nextRed;
            yellow = nextYellow;
            blue = nextBlue;
        }
        //返回最后一层三种颜色最小可能
        return Math.min(Math.min(red, blue), yellow);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().minCost(new int[][]{
                new int[]{17, 2, 17},
                new int[]{16, 16, 5},
                new int[]{14, 3, 19},
        }));
    }

}
