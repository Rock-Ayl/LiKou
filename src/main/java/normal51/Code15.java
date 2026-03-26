package normal51;

/**
 * 3418. 机器人可以获得的最大金币数
 * 算术评级: 5
 * 第 432 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1798
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 m x n 的网格。一个机器人从网格的左上角 (0, 0) 出发，目标是到达网格的右下角 (m - 1, n - 1)。在任意时刻，机器人只能向右或向下移动。
 * <p>
 * 网格中的每个单元格包含一个值 coins[i][j]：
 * <p>
 * 如果 coins[i][j] >= 0，机器人可以获得该单元格的金币。
 * 如果 coins[i][j] < 0，机器人会遇到一个强盗，强盗会抢走该单元格数值的 绝对值 的金币。
 * 机器人有一项特殊能力，可以在行程中 最多感化 2个单元格的强盗，从而防止这些单元格的金币被抢走。
 * <p>
 * 注意：机器人的总金币数可以是负数。
 * <p>
 * 返回机器人在路径上可以获得的 最大金币数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： coins = [[0,1,-1],[1,-2,3],[2,-3,4]]
 * <p>
 * 输出： 8
 * <p>
 * 解释：
 * <p>
 * 一个获得最多金币的最优路径如下：
 * <p>
 * 从 (0, 0) 出发，初始金币为 0（总金币 = 0）。
 * 移动到 (0, 1)，获得 1 枚金币（总金币 = 0 + 1 = 1）。
 * 移动到 (1, 1)，遇到强盗抢走 2 枚金币。机器人在此处使用一次感化能力，避免被抢（总金币 = 1）。
 * 移动到 (1, 2)，获得 3 枚金币（总金币 = 1 + 3 = 4）。
 * 移动到 (2, 2)，获得 4 枚金币（总金币 = 4 + 4 = 8）。
 * 示例 2：
 * <p>
 * 输入： coins = [[10,10,10],[10,10,10]]
 * <p>
 * 输出： 40
 * <p>
 * 解释：
 * <p>
 * 一个获得最多金币的最优路径如下：
 * <p>
 * 从 (0, 0) 出发，初始金币为 10（总金币 = 10）。
 * 移动到 (0, 1)，获得 10 枚金币（总金币 = 10 + 10 = 20）。
 * 移动到 (0, 2)，再获得 10 枚金币（总金币 = 20 + 10 = 30）。
 * 移动到 (1, 2)，获得 10 枚金币（总金币 = 30 + 10 = 40）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == coins.length
 * n == coins[i].length
 * 1 <= m, n <= 500
 * -1000 <= coins[i][j] <= 1000
 */
public class Code15 {

    public int maximumAmount(int[][] coins) {
        //三维数组,0表示未使用感化能力,1表示使用了1个,2表示使用了2个
        int[][][] countArr = new int[3][coins.length][coins[0].length];
        //获取三种情况
        int[][] oneArr = countArr[0];
        int[][] twoArr = countArr[1];
        int[][] threeArr = countArr[2];
        //循环1
        for (int i = 0; i < coins.length; i++) {
            //循环2
            for (int j = 0; j < coins[0].length; j++) {
                //递推三种情况
                oneArr[i][j] = max(getArr(oneArr, i - 1, j), getArr(oneArr, i, j - 1)) + coins[i][j];
                twoArr[i][j] = max(getArr(twoArr, i - 1, j), getArr(twoArr, i, j - 1)) + coins[i][j];
                threeArr[i][j] = max(getArr(threeArr, i - 1, j), getArr(threeArr, i, j - 1)) + coins[i][j];
                //如果可以感化
                if (coins[i][j] < 0) {
                    //感化
                    twoArr[i][j] = Math.max(max(getArr(oneArr, i - 1, j), getArr(oneArr, i, j - 1)), twoArr[i][j]);
                    //感化
                    threeArr[i][j] = Math.max(max(getArr(twoArr, i - 1, j), getArr(twoArr, i, j - 1)), threeArr[i][j]);
                }
            }
        }
        //三个维度,三种情况
        int a = oneArr[coins.length - 1][coins[0].length - 1];
        int b = twoArr[coins.length - 1][coins[0].length - 1];
        int c = threeArr[coins.length - 1][coins[0].length - 1];
        //返回最大
        return max(max(a, b), c);
    }

    //获取数字内内容
    private Integer getArr(int[][] arr, int x, int y) {
        //判断越界
        if (x < 0 || x >= arr.length || y < 0 || y >= arr[0].length) {
            //过
            return null;
        }
        //返回
        return arr[x][y];
    }

    //比较大小
    private int max(Integer a, Integer b) {
        //都空
        if (a == null && b == null) {
            //返回
            return 0;
        }
        //判空
        if (a == null) {
            //返回
            return b;
        }
        //判空
        if (b == null) {
            //返回
            return a;
        }
        //对比
        return Math.max(a, b);
    }

    public static void main(String[] args) {
        /*System.out.println(new Code15().maximumAmount(new int[][]{
                {0, 1, -1},
                {1, -2, 3},
                {2, -3, 4}
        }));*/

        System.out.println(new Code15().maximumAmount(new int[][]{
                {-7, 12, 12, 13},
                {-6, 19, 19, -6},
                {9, -2, -10, 16},
                {-4, 14, -10, -9}
        }));


    }

}