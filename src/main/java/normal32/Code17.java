package normal32;

/**
 * @Author ayl
 * @Date 2024-06-12
 * 2087. 网格图中机器人回家的最小代价
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 m x n 的网格图，其中 (0, 0) 是最左上角的格子，(m - 1, n - 1) 是最右下角的格子。给你一个整数数组 startPos ，startPos = [startrow, startcol] 表示 初始 有一个 机器人 在格子 (startrow, startcol) 处。同时给你一个整数数组 homePos ，homePos = [homerow, homecol] 表示机器人的 家 在格子 (homerow, homecol) 处。
 * <p>
 * 机器人需要回家。每一步它可以往四个方向移动：上，下，左，右，同时机器人不能移出边界。每一步移动都有一定代价。再给你两个下标从 0 开始的额整数数组：长度为 m 的数组 rowCosts  和长度为 n 的数组 colCosts 。
 * <p>
 * 如果机器人往 上 或者往 下 移动到第 r 行 的格子，那么代价为 rowCosts[r] 。
 * 如果机器人往 左 或者往 右 移动到第 c 列 的格子，那么代价为 colCosts[c] 。
 * 请你返回机器人回家需要的 最小总代价 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：startPos = [1, 0], homePos = [2, 3], rowCosts = [5, 4, 3], colCosts = [8, 2, 6, 7]
 * 输出：18
 * 解释：一个最优路径为：
 * 从 (1, 0) 开始
 * -> 往下走到 (2, 0) 。代价为 rowCosts[2] = 3 。
 * -> 往右走到 (2, 1) 。代价为 colCosts[1] = 2 。
 * -> 往右走到 (2, 2) 。代价为 colCosts[2] = 6 。
 * -> 往右走到 (2, 3) 。代价为 colCosts[3] = 7 。
 * 总代价为 3 + 2 + 6 + 7 = 18
 * 示例 2：
 * <p>
 * 输入：startPos = [0, 0], homePos = [0, 0], rowCosts = [5], colCosts = [26]
 * 输出：0
 * 解释：机器人已经在家了，所以不需要移动。总代价为 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == rowCosts.length
 * n == colCosts.length
 * 1 <= m, n <= 105
 * 0 <= rowCosts[r], colCosts[c] <= 104
 * startPos.length == 2
 * homePos.length == 2
 * 0 <= startrow, homerow < m
 * 0 <= startcol, homecol < n
 */
public class Code17 {

    //移动,返回和
    private int move(int start, int end, int[] cost) {
        //花费和
        int sum = 0;
        //根据方向判断偏移量
        if (start > end) {
            //倒序循环
            while (start > end) {
                //走一步、记录结果
                sum += cost[--start];
            }
        } else {
            //正序循环
            while (start < end) {
                //走一步、记录结果
                sum += cost[++start];
            }
        }
        //返回结果
        return sum;
    }

    public int minCost(int[] startPos, int[] homePos, int[] rowCosts, int[] colCosts) {
        //开始坐标
        int x = startPos[0];
        int y = startPos[1];
        //结束坐标
        int endX = homePos[0];
        int endY = homePos[1];
        //初始化结果
        int sum = 0;
        //如果x轴需要移动
        if (x != endX) {
            //计算偏移量
            sum += move(x, endX, rowCosts);
        }
        //如果y轴需要移动
        if (y != endY) {
            //计算偏移量
            sum += move(y, endY, colCosts);
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().minCost(new int[]{1, 0}, new int[]{2, 3}, new int[]{5, 4, 3}, new int[]{8, 2, 6, 7}));
    }
}
