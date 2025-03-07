package normal26;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-11-20
 * 1476. 子矩形查询
 * 提示
 * 中等
 * 42
 * 相关企业
 * 请你实现一个类 SubrectangleQueries ，它的构造函数的参数是一个 rows x cols 的矩形（这里用整数矩阵表示），并支持以下两种操作：
 * <p>
 * 1. updateSubrectangle(int row1, int col1, int row2, int col2, int newValue)
 * <p>
 * 用 newValue 更新以 (row1,col1) 为左上角且以 (row2,col2) 为右下角的子矩形。
 * 2. getValue(int row, int col)
 * <p>
 * 返回矩形中坐标 (row,col) 的当前值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
 * [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
 * 输出：
 * [null,1,null,5,5,null,10,5]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,2,1],[4,3,4],[3,2,1],[1,1,1]]);
 * // 初始的 (4x3) 矩形如下：
 * // 1 2 1
 * // 4 3 4
 * // 3 2 1
 * // 1 1 1
 * subrectangleQueries.getValue(0, 2); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
 * // 此次更新后矩形变为：
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * // 5 5 5
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * subrectangleQueries.getValue(3, 1); // 返回 5
 * subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
 * // 此次更新后矩形变为：
 * // 5   5   5
 * // 5   5   5
 * // 5   5   5
 * // 10  10  10
 * subrectangleQueries.getValue(3, 1); // 返回 10
 * subrectangleQueries.getValue(0, 2); // 返回 5
 * 示例 2：
 * <p>
 * 输入：
 * ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue"]
 * [[[[1,1,1],[2,2,2],[3,3,3]]],[0,0],[0,0,2,2,100],[0,0],[2,2],[1,1,2,2,20],[2,2]]
 * 输出：
 * [null,1,null,100,100,null,20]
 * 解释：
 * SubrectangleQueries subrectangleQueries = new SubrectangleQueries([[1,1,1],[2,2,2],[3,3,3]]);
 * subrectangleQueries.getValue(0, 0); // 返回 1
 * subrectangleQueries.updateSubrectangle(0, 0, 2, 2, 100);
 * subrectangleQueries.getValue(0, 0); // 返回 100
 * subrectangleQueries.getValue(2, 2); // 返回 100
 * subrectangleQueries.updateSubrectangle(1, 1, 2, 2, 20);
 * subrectangleQueries.getValue(2, 2); // 返回 20
 * <p>
 * <p>
 * 提示：
 * <p>
 * 最多有 500 次updateSubrectangle 和 getValue 操作。
 * 1 <= rows, cols <= 100
 * rows == rectangle.length
 * cols == rectangle[i].length
 * 0 <= row1 <= row2 < rows
 * 0 <= col1 <= col2 < cols
 * 1 <= newValue, rectangle[i][j] <= 10^9
 * 0 <= row < rows
 * 0 <= col < cols
 */
public class Code5 {

    //数组列表
    private int[][] rectangle;
    //日志列表
    private List<int[]> historyList;

    public Code5(int[][] rectangle) {
        this.rectangle = rectangle;
        this.historyList = new ArrayList<>();
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        //记录日志即可
        this.historyList.add(new int[]{row1, col1, row2, col2, newValue});
    }

    public int getValue(int row, int col) {
        //循环日志、倒叙
        for (int i = this.historyList.size() - 1; i >= 0; i--) {
            //获取最近一次的
            int[] history = this.historyList.get(i);
            //如果满足这个日志的修改
            if (history[0] <= row && row <= history[2] && history[1] <= col && col <= history[3]) {
                //返回结果
                return history[4];
            }
        }
        //默认
        return this.rectangle[row][col];
    }

}
