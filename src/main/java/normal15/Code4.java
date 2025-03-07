package normal15;

/**
 * @Author ayl
 * @Date 2022-07-08
 * 130. 被围绕的区域
 * 给你一个 m x n 的矩阵 board ，由若干字符 'X' 和 'O' ，找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
 * 输出：[["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
 * 解释：被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * 示例 2：
 * <p>
 * 输入：board = [["X"]]
 * 输出：[["X"]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 200
 * board[i][j] 为 'X' 或 'O'
 */
public class Code4 {

    //初始化无需删除的坐标
    int[][] cannotArr;
    //全局
    char[][] board;

    //尝试将这些及其连通的存入无需删除的坐标
    public void setCannotArr(int x, int y) {
        //如果越界
        if (x < 0 || y < 0 || x >= cannotArr.length || y >= cannotArr[0].length) {
            //过
            return;
        }
        //如果不满足
        if (board[x][y] != 'O') {
            //过
            return;
        }
        //如果已经记录过
        if (cannotArr[x][y] > 0) {
            //过
            return;
        }
        //记录
        cannotArr[x][y]++;
        //下一级
        setCannotArr(x + 1, y);
        setCannotArr(x - 1, y);
        setCannotArr(x, y + 1);
        setCannotArr(x, y - 1);
    }

    public void solve(char[][] board) {
        //全局
        this.board = board;
        //初始化无需管控的地址
        cannotArr = new int[board.length][board[0].length];
        //沿着边走1
        for (int i = 0; i < board.length; i++) {
            //如果是
            if (board[i][0] == 'O') {
                //记录
                setCannotArr(i, 0);
            }
            //如果是
            if (board[i][board[0].length - 1] == 'O') {
                //记录
                setCannotArr(i, board[0].length - 1);
            }
        }
        //沿着边走2
        for (int j = 0; j < board[0].length; j++) {
            //如果是
            if (board[0][j] == 'O') {
                //记录
                setCannotArr(0, j);
            }
            //如果是
            if (board[board.length - 1][j] == 'O') {
                //记录
                setCannotArr(board.length - 1, j);
            }
        }
        //循环3
        for (int i = 0; i < board.length; i++) {
            //循环4
            for (int j = 0; j < board[0].length; j++) {
                //如果是并且可以删除
                if (board[i][j] == 'O' && cannotArr[i][j] == 0) {
                    //删除
                    board[i][j] = 'X';
                }
            }
        }
    }

}
