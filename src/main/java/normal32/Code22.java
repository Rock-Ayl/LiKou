package normal32;

/**
 * @Author ayl
 * @Date 2024-06-28
 * 3195. 包含所有 1 的最小矩形面积 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
 * <p>
 * 返回这个矩形可能的 最小 面积。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： grid = [[0,1,0],[1,0,1]]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。
 * <p>
 * 示例 2：
 * <p>
 * 输入： grid = [[0,0],[1,0]]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] 是 0 或 1。
 * 输入保证 grid 中至少有一个 1 。
 */
public class Code22 {

    //四个边界
    private Integer up = null;
    private Integer down = null;
    private Integer left = null;
    private Integer right = null;

    //设置边界
    private void setLink(int x, int y) {
        //判空
        if (this.up == null) {
            //设置
            this.up = x;
        }
        //覆盖
        this.down = x;
        //判空
        if (this.left == null) {
            //设置
            this.left = y;
        } else {
            //最小情况
            this.left = Math.min(this.left, y);
        }
        //判空
        if (this.right == null) {
            //设置
            this.right = y;
        } else {
            //最大情况
            this.right = Math.max(this.right, y);
        }
    }

    public int minimumArea(int[][] grid) {
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果是1
                if (grid[i][j] == 1) {
                    //设置本次边界
                    setLink(i, j);
                }
            }
        }
        //计算结果并返回
        return (this.down - this.up + 1) * (this.right - this.left + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code22().minimumArea(new int[][]{
                new int[]{0, 1, 0},
                new int[]{1, 0, 1}
        }));
    }

}
