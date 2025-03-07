package normal26;

/**
 * @Author ayl
 * @Date 2023-11-21
 * 885. 螺旋矩阵 III
 * 中等
 * 96
 * 相关企业
 * 在 rows x cols 的网格上，你从单元格 (rStart, cStart) 面朝东面开始。网格的西北角位于第一行第一列，网格的东南角位于最后一行最后一列。
 * <p>
 * 你需要以顺时针按螺旋状行走，访问此网格中的每个位置。每当移动到网格的边界之外时，需要继续在网格之外行走（但稍后可能会返回到网格边界）。
 * <p>
 * 最终，我们到过网格的所有 rows x cols 个空间。
 * <p>
 * 按照访问顺序返回表示网格位置的坐标列表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：rows = 1, cols = 4, rStart = 0, cStart = 0
 * 输出：[[0,0],[0,1],[0,2],[0,3]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：rows = 5, cols = 6, rStart = 1, cStart = 4
 * 输出：[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rows, cols <= 100
 * 0 <= rStart < rows
 * 0 <= cStart < cols
 */
public class Code6 {

    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        //结果
        int[][] result = new int[rows * cols][2];
        //指针
        int p = 0;
        //当前坐标
        int x = rStart;
        int y = cStart;
        //螺旋半径
        int radius = 1;
        //方向
        int dir = 1;
        //初始化第一个
        result[p++] = new int[]{x, y};
        //跳出标记
        out:
        //如果还需要走
        while (p < result.length) {
            //根据方向
            switch (dir) {
                //右
                case 1:
                    //如果需要换方向了
                    if (cStart + radius == y) {
                        //换方向
                        dir++;
                        //本轮过
                        continue out;
                    }
                    //走
                    y++;
                    break;
                //下
                case 2:
                    //如果需要换方向了
                    if (rStart + radius == x) {
                        //换方向
                        dir++;
                        //本轮过
                        continue out;
                    }
                    //走
                    x++;
                    break;
                //左
                case 3:
                    //如果需要换方向了
                    if (cStart - radius == y) {
                        //换方向
                        dir++;
                        //本轮过
                        continue out;
                    }
                    //走
                    y--;
                    break;
                //上
                case 4:
                    //如果需要换方向了
                    if (rStart - radius == x) {
                        //换方向
                        dir = 1;
                        //螺旋半径增加
                        radius++;
                        //本轮过
                        continue out;
                    }
                    //走
                    x--;
                    break;
            }
            //如果没越界
            if (x >= 0 && y >= 0 && x < rows && y < cols) {
                //本次记录
                result[p++] = new int[]{x, y};
            }
        }
        //返回结果
        return result;
    }

    private static void print(int[][] arr) {
        for (int[] ints : arr) {
            System.out.print("[" + ints[0] + "," + ints[1] + "],");
        }
        System.out.println("#############");
    }

    //[[1,4],[1,5],[2,5],[2,4],[2,3],[1,3],[0,3],[0,4],[0,5],[3,5],[3,4],[3,3],[3,2],[2,2],[1,2],[0,2],[4,5],[4,4],[4,3],[4,2],[4,1],[3,1],[2,1],[1,1],[0,1],[4,0],[3,0],[2,0],[1,0],[0,0]]
    public static void main(String[] args) {
        int[][] ints = new Code6().spiralMatrixIII(5, 6, 1, 4);
        print(ints);
    }

}
