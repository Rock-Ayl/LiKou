package normal29;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-03-20
 * 688. 骑士在棋盘上的概率
 * 中等
 * 相关标签
 * 相关企业
 * 在一个 n x n 的国际象棋棋盘上，一个骑士从单元格 (row, column) 开始，并尝试进行 k 次移动。行和列是 从 0 开始 的，所以左上单元格是 (0,0) ，右下单元格是 (n - 1, n - 1) 。
 * <p>
 * 象棋骑士有8种可能的走法，如下图所示。每次移动在基本方向上是两个单元格，然后在正交方向上是一个单元格。
 * <p>
 * <p>
 * <p>
 * 每次骑士要移动时，它都会随机从8种可能的移动中选择一种(即使棋子会离开棋盘)，然后移动到那里。
 * <p>
 * 骑士继续移动，直到它走了 k 步或离开了棋盘。
 * <p>
 * 返回 骑士在棋盘停止移动后仍留在棋盘上的概率 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: n = 3, k = 2, row = 0, column = 0
 * 输出: 0.0625
 * 解释: 有两步(到(1,2)，(2,1))可以让骑士留在棋盘上。
 * 在每一个位置上，也有两种移动可以让骑士留在棋盘上。
 * 骑士留在棋盘上的总概率是0.0625。
 * 示例 2：
 * <p>
 * 输入: n = 1, k = 0, row = 0, column = 0
 * 输出: 1.00000
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 25
 * 0 <= k <= 100
 * 0 <= row, column <= n - 1
 */
public class Code26 {

    private void print(int[][] thisArr) {
        for (int[] ints : thisArr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

    //填充
    private void fill(double[][] thisArr, int x, int y, int n, double count) {
        //如果越界
        if (x < 0 || y < 0 || x >= n || y >= n) {
            //过
            return;
        }
        //叠加本次移动次数
        thisArr[x][y] += count;
    }

    public double knightProbability(int n, int k, int row, int column) {
        //如果不移动
        if (k == 0) {
            //必然留在原位
            return 1D;
        }
        //初始化结果集
        double[][][] allArr = new double[k + 1][n][n];
        //默认开始节点
        allArr[0][row][column] = 1;
        //循环
        for (int i = 1; i < allArr.length; i++) {
            //当前棋盘
            double[][] thisArr = allArr[i];
            //上次棋盘
            double[][] lastArr = allArr[i - 1];
            //循环上一次棋盘
            for (int x = 0; x < n; x++) {
                //循环2
                for (int y = 0; y < n; y++) {
                    //起跳数量
                    double startCount = lastArr[x][y];
                    //如果没有任何起跳
                    if (startCount == 0) {
                        //本轮过
                        continue;
                    }
                    //尝试叠加8个方向
                    fill(thisArr, x + 2, y + 1, n, startCount);
                    fill(thisArr, x + 2, y - 1, n, startCount);
                    fill(thisArr, x - 2, y + 1, n, startCount);
                    fill(thisArr, x - 2, y - 1, n, startCount);
                    fill(thisArr, x + 1, y + 2, n, startCount);
                    fill(thisArr, x + 1, y - 2, n, startCount);
                    fill(thisArr, x - 1, y + 2, n, startCount);
                    fill(thisArr, x - 1, y - 2, n, startCount);
                }
            }
        }
        //总次数
        double allCount = 8D;
        //指针
        int q = 0;
        //循环
        while (++q < k) {
            //乘法
            allCount = allCount * 8D;
        }
        //收集最后一次移动后,还停留在棋盘的可能
        double sum = Arrays
                .stream(allArr[allArr.length - 1])
                //收集里面的和
                .map(p -> Arrays.stream(p).sum())
                //拆箱
                .mapToDouble(Double::doubleValue)
                //求和
                .sum();
        //返回概率
        return sum / allCount;
    }

    public static void main(String[] args) {
        System.out.println(new Code26().knightProbability(8, 30, 6, 4));
    }

}
