package normal35;

/**
 * @Author ayl
 * @Date 2024-09-29
 * 3001. 捕获黑皇后需要的最少移动次数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 现有一个下标从 1 开始的 8 x 8 棋盘，上面有 3 枚棋子。
 * <p>
 * 给你 6 个整数 a 、b 、c 、d 、e 和 f ，其中：
 * <p>
 * (a, b) 表示白色车的位置。
 * (c, d) 表示白色象的位置。
 * (e, f) 表示黑皇后的位置。
 * 假定你只能移动白色棋子，返回捕获黑皇后所需的最少移动次数。
 * <p>
 * 请注意：
 * <p>
 * 车可以向垂直或水平方向移动任意数量的格子，但不能跳过其他棋子。
 * 象可以沿对角线方向移动任意数量的格子，但不能跳过其他棋子。
 * 如果车或象能移向皇后所在的格子，则认为它们可以捕获皇后。
 * 皇后不能移动。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：a = 1, b = 1, c = 8, d = 8, e = 2, f = 3
 * 输出：2
 * 解释：将白色车先移动到 (1, 3) ，然后移动到 (2, 3) 来捕获黑皇后，共需移动 2 次。
 * 由于起始时没有任何棋子正在攻击黑皇后，要想捕获黑皇后，移动次数不可能少于 2 次。
 * 示例 2：
 * <p>
 * <p>
 * 输入：a = 5, b = 3, c = 3, d = 4, e = 5, f = 2
 * 输出：1
 * 解释：可以通过以下任一方式移动 1 次捕获黑皇后：
 * - 将白色车移动到 (5, 2) 。
 * - 将白色象移动到 (5, 2) 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= a, b, c, d, e, f <= 8
 * 两枚棋子不会同时出现在同一个格子上。
 */
public class Code16 {

    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        //如果白象理论上可以直接吃
        if (Math.abs(c - e) == Math.abs(d - f)) {
            //判断车是否在二者之间
            boolean x = (a > c && a > e) || (a < c && a < e);
            boolean y = (b > d && b > f) || (b < d && b < f);
            //如果车不在白象路上 or 如果车不在中间
            if (Math.abs(a - e) != Math.abs(b - f) || x == true || y == true) {
                //一步
                return 1;
            }
        }
        //如果车理论上可以直接吃
        if (a == e || b == f) {
            //判断象是否在二者之间
            boolean x = (c > a && c > e) || (c < a && c < e);
            boolean y = (d > b && d > f) || (d < b && d < f);
            //如果象不在中间
            if (x == true || y == true) {
                //一步
                return 1;
            }
        }
        //默认
        return 2;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
    }

    private void print(int a, int b, int c, int d, int e, int f) {
        int[][] arr = new int[9][9];
        arr[a][b] = 1;
        arr[c][d] = 2;
        arr[e][f] = 3;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}
