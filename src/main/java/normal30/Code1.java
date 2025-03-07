package normal30;

/**
 * @Author ayl
 * @Date 2024-03-21
 * 576. 出界的路径数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。
 * <p>
 * 给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：m = 2, n = 2, maxMove = 2, startRow = 0, startColumn = 0
 * 输出：6
 * 示例 2：
 * <p>
 * <p>
 * 输入：m = 1, n = 3, maxMove = 3, startRow = 0, startColumn = 1
 * 输出：12
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= m, n <= 50
 * 0 <= maxMove <= 50
 * 0 <= startRow < m
 * 0 <= startColumn < n
 */
public class Code1 {

    //目标结果
    private int result = 0;

    //填充 or 记录结果
    private void fill(int[][] thisArr, int x, int y, int m, int n, int count) {
        //如果越界
        if (x < 0 || y < 0 || x >= m || y >= n) {
            //叠加出界结果
            this.result = (this.result + count) % 1000000007;
            //过
            return;
        }
        //叠加
        thisArr[x][y] = (thisArr[x][y] + count) % 1000000007;
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        //如果移动
        if (maxMove == 0) {
            //过
            return 0;
        }
        //初始化缓存
        int[][][] arr = new int[maxMove + 1][m][n];
        //初始化起点
        arr[0][startRow][startColumn] = 1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //上一个
            int[][] lastArr = arr[i - 1];
            //当前
            int[][] thisArr = arr[i];
            //循环1
            for (int x = 0; x < m; x++) {
                //循环2
                for (int y = 0; y < n; y++) {
                    //获取当前count
                    int count = lastArr[x][y];
                    //如果没有
                    if (count == 0) {
                        //本轮过
                        continue;
                    }
                    //尝试填充
                    fill(thisArr, x + 1, y, m, n, count);
                    fill(thisArr, x - 1, y, m, n, count);
                    fill(thisArr, x, y + 1, m, n, count);
                    fill(thisArr, x, y - 1, m, n, count);

                }
            }
        }
        //返回
        return this.result;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().findPaths(1, 3, 3, 0, 1));
    }

}
