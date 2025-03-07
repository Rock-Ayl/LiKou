package normal31;

/**
 * @Author ayl
 * @Date 2024-05-15
 * LCR 129. 字母迷宫
 * 中等
 * 相关标签
 * 相关企业
 * 字母迷宫游戏初始界面记作 m x n 二维字符串数组 grid，请判断玩家是否能在 grid 中找到目标单词 target。
 * 注意：寻找单词时 必须 按照字母顺序，通过水平或垂直方向相邻的单元格内的字母构成，同时，同一个单元格内的字母 不允许被重复使用 。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：grid = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], target = "ABCB"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == grid.length
 * n = grid[i].length
 * 1 <= m, n <= 6
 * 1 <= target.length <= 15
 * grid 和 target 仅由大小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 */
public class Code16 {

    //递归寻找目标
    private boolean find(char[][] grid, String target, int x, int y, int index, boolean[][] walkArr) {
        //如果越界
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
            //过
            return false;
        }
        //如果当前不是
        if (grid[x][y] == target.charAt(index) == false) {
            //过
            return false;
        }
        //如果走过了
        if (walkArr[x][y] == true) {
            //过
            return false;
        }
        //记录走过
        walkArr[x][y] = true;
        //如果索引为目标长度了
        if (++index == target.length()) {
            //是
            return true;
        }
        //判断
        if (find(grid, target, x + 1, y, index, walkArr)) {
            //是
            return true;
        }
        //判断
        if (find(grid, target, x - 1, y, index, walkArr)) {
            //是
            return true;
        }
        //判断
        if (find(grid, target, x, y + 1, index, walkArr)) {
            //是
            return true;
        }
        //判断
        if (find(grid, target, x, y - 1, index, walkArr)) {
            //是
            return true;
        }
        //回溯
        walkArr[x][y] = false;
        //默认不是
        return false;
    }

    public boolean wordPuzzle(char[][] grid, String target) {
        //走过的路
        boolean[][] walkArr = new boolean[grid.length][grid[0].length];
        //循环1
        for (int i = 0; i < grid.length; i++) {
            //循环2
            for (int j = 0; j < grid[0].length; j++) {
                //如果本次可以找到目标
                if (find(grid, target, i, j, 0, walkArr)) {
                    //可以
                    return true;
                }
            }
        }
        //默认不行
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().wordPuzzle(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'}

        }, "ABCB"));
    }

}
