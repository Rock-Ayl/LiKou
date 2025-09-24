package difficult4;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-09-24
 * 1411. 给 N x 3 网格图涂色的方案数
 * 算术评级: 6
 * 第 184 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1845
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你有一个 n x 3 的网格图 grid ，你需要用 红，黄，绿 三种颜色之一给每一个格子上色，且确保相邻格子颜色不同（也就是有相同水平边或者垂直边的格子颜色不同）。
 * <p>
 * 给你网格图的行数 n 。
 * <p>
 * 请你返回给 grid 涂色的方案数。由于答案可能会非常大，请你返回答案对 10^9 + 7 取余的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1
 * 输出：12
 * 解释：总共有 12 种可行的方法：
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出：54
 * 示例 3：
 * <p>
 * 输入：n = 3
 * 输出：246
 * 示例 4：
 * <p>
 * 输入：n = 7
 * 输出：106494
 * 示例 5：
 * <p>
 * 输入：n = 5000
 * 输出：30228214
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == grid.length
 * grid[i].length == 3
 * 1 <= n <= 5000
 */
public class Code10 {

    //十二种可能
    private static int[][] TEMP_ARR = new int[][]{new int[]{0, 1, 0},
            new int[]{1, 0, 1},
            new int[]{2, 0, 1},
            new int[]{0, 1, 2},
            new int[]{1, 0, 2},
            new int[]{2, 0, 2},
            new int[]{0, 2, 0},
            new int[]{1, 2, 0},
            new int[]{2, 1, 0},
            new int[]{0, 2, 1},
            new int[]{1, 2, 1},
            new int[]{2, 1, 2}
    };

    public int numOfWays(int n) {
        //动态规划
        int[][] arr = new int[n][12];
        //第一次固定1
        Arrays.fill(arr[0], 1);
        //循环
        for (int i = 1; i < arr.length; i++) {
            //当前数组
            int[] thisArr = arr[i];
            //上一次数组
            int[] lastArr = arr[i - 1];
            //循环2
            for (int o = 0; o < thisArr.length; o++) {
                //当前模板
                int[] thisArrTemp = TEMP_ARR[o];
                //循环2
                for (int p = 0; p < lastArr.length; p++) {
                    //上一个模板
                    int[] lastArrTemp = TEMP_ARR[p];
                    //如果满足
                    if (thisArrTemp[0] != lastArrTemp[0] && thisArrTemp[1] != lastArrTemp[1] && thisArrTemp[2] != lastArrTemp[2]) {
                        //叠加
                        thisArr[o] = (thisArr[o] + lastArr[p]) % 1000000007;
                    }
                }
            }
        }
        //返回
        return Arrays.stream(arr[arr.length - 1]).reduce((a, b) -> (a + b) % 1000000007).getAsInt();
    }

    public static void main(String[] args) {
        System.out.println(new Code10().numOfWays(5000));
    }

}
