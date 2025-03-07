package normal29;

/**
 * @Author ayl
 * @Date 2024-03-15
 * 764. 最大加号标志
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 在一个 n x n 的矩阵 grid 中，除了在数组 mines 中给出的元素为 0，其他每个元素都为 1。mines[i] = [xi, yi]表示 grid[xi][yi] == 0
 * <p>
 * 返回  grid 中包含 1 的最大的 轴对齐 加号标志的阶数 。如果未找到加号标志，则返回 0 。
 * <p>
 * 一个 k 阶由 1 组成的 “轴对称”加号标志 具有中心网格 grid[r][c] == 1 ，以及4个从中心向上、向下、向左、向右延伸，长度为 k-1，由 1 组成的臂。注意，只有加号标志的所有网格要求为 1 ，别的网格可能为 0 也可能为 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: n = 5, mines = [[4, 2]]
 * 输出: 2
 * 解释: 在上面的网格中，最大加号标志的阶只能是2。一个标志已在图中标出。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: n = 1, mines = [[0, 0]]
 * 输出: 0
 * 解释: 没有加号标志，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 * 1 <= mines.length <= 5000
 * 0 <= xi, yi < n
 * 每一对 (xi, yi) 都 不重复
 */
public class Code22 {

    private void print(int[][] arr) {
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

    //计算节点上方矩形长度数量
    private int[][] up(int n, int[][] sourceArr) {
        //初始化结果
        int[][] result = new int[n][n];
        //循环
        for (int i = 1; i < n; i++) {
            //循环2
            for (int j = 0; j < n; j++) {
                //如果上方是墙
                if (sourceArr[i - 1][j] == 1) {
                    //本轮过
                    continue;
                }
                //计算
                result[i][j] = result[i - 1][j] + (sourceArr[i - 1][j] == 0 ? 1 : 0);
            }
        }
        //返回
        return result;
    }

    //计算节点下方矩形长度数量
    private int[][] down(int n, int[][] sourceArr) {
        //初始化结果
        int[][] result = new int[n][n];
        //循环
        for (int i = n - 2; i >= 0; i--) {
            //循环2
            for (int j = 0; j < n; j++) {
                //如果下方是墙
                if (sourceArr[i + 1][j] == 1) {
                    //本轮过
                    continue;
                }
                //计算
                result[i][j] = result[i + 1][j] + (sourceArr[i + 1][j] == 0 ? 1 : 0);
            }
        }
        //返回
        return result;
    }

    //计算节点左方矩形长度数量
    private int[][] left(int n, int[][] sourceArr) {
        //初始化结果
        int[][] result = new int[n][n];
        //循环
        for (int i = 0; i < n; i++) {
            //循环2
            for (int j = 1; j < n; j++) {
                //如果左方是墙
                if (sourceArr[i][j - 1] == 1) {
                    //本轮过
                    continue;
                }
                //计算
                result[i][j] = result[i][j - 1] + (sourceArr[i][j - 1] == 0 ? 1 : 0);
            }
        }
        //返回
        return result;
    }

    //计算节点右方矩形长度数量
    private int[][] right(int n, int[][] sourceArr) {
        //初始化结果
        int[][] result = new int[n][n];
        //循环
        for (int i = 0; i < n; i++) {
            //循环2
            for (int j = n - 2; j >= 0; j--) {
                //如果右方是墙
                if (sourceArr[i][j + 1] == 1) {
                    //本轮过
                    continue;
                }
                //计算
                result[i][j] = result[i][j + 1] + (sourceArr[i][j + 1] == 0 ? 1 : 0);
            }
        }
        //返回
        return result;
    }

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        //如果特殊处理
        if (n == 1) {
            //返回
            return mines.length == 1 ? 0 : 1;
        }
        //如果全有
        if (n * n == mines.length) {
            //过
            return 0;
        }
        //源网格,默认0为正常区间(题目是1)
        int[][] sourceArr = new int[n][n];
        //循环
        for (int[] mine : mines) {
            //填充为1(题目对应0)
            sourceArr[mine[0]][mine[1]] = 1;
        }
        //生成四个方向的缓存
        int[][] upArr = up(n, sourceArr);
        int[][] downArr = down(n, sourceArr);
        int[][] leftArr = left(n, sourceArr);
        int[][] rightArr = right(n, sourceArr);
        //最大可能
        int maxLength = 0;
        //循环1
        for (int i = 0; i < n; i++) {
            //循环2
            for (int j = 0; j < n; j++) {
                //如果当前是墙
                if (sourceArr[i][j] == 1) {
                    //本轮过
                    continue;
                }
                //计算本次最小正方型
                int thisLength = Math.min(Math.min(upArr[i][j], downArr[i][j]), Math.min(leftArr[i][j], rightArr[i][j]));
                //刷新最大结果
                maxLength = Math.max(maxLength, thisLength);
            }
        }
        //返回结果
        return maxLength + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code22().orderOfLargestPlusSign(5, new int[][]{
                new int[]{4, 2}
        }));
    }

}
