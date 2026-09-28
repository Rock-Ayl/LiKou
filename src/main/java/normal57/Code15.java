package normal57;

/**
 * 794. 有效的井字游戏
 * 算术评级: 4
 * 第 74 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1545
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串数组 board 表示井字游戏的棋盘。当且仅当在井字游戏过程中，棋盘有可能达到 board 所显示的状态时，才返回 true 。
 * <p>
 * 井字游戏的棋盘是一个 3 x 3 数组，由字符 ' '，'X' 和 'O' 组成。字符 ' ' 代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（' '）中。
 * 玩家 1 总是放字符 'X' ，而玩家 2 总是放字符 'O' 。
 * 'X' 和 'O' 只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有 3 个相同（且非空）的字符填充任何行、列或对角线时，游戏结束。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = ["O  ","   ","   "]
 * 输出：false
 * 解释：玩家 1 总是放字符 "X" 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = ["XOX"," X ","   "]
 * 输出：false
 * 解释：玩家应该轮流放字符。
 * 示例 3:
 * <p>
 * <p>
 * 输入：board = ["XOX","O O","XOX"]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * board.length == 3
 * board[i].length == 3
 * board[i][j] 为 'X'、'O' 或 ' '
 */
public class Code15 {

    public boolean validTicTacToe(String[] board) {
        //数量
        int xCount = 0;
        int oCount = 0;
        //循环1
        for (String s : board) {
            //循环2
            for (char c : s.toCharArray()) {
                //如果是
                if (c == 'X') {
                    //+1
                    xCount++;
                }
                //如果是
                if (c == 'O') {
                    //+1
                    oCount++;
                }
            }
        }
        //如果O的数量大于X的数量
        if (oCount > xCount) {
            //肯定不行
            return false;
        }
        //如果大太多
        if (xCount - 1 > oCount) {
            //肯定不行
            return false;
        }
        //二者赢家
        boolean x = checkWin(board, 'X');
        boolean o = checkWin(board, 'O');
        //如果都赢了
        if (x == true && o == true) {
            //肯定不行
            return false;
        }
        //如果X赢了
        if (x) {
            //返回
            return xCount - oCount == 1;
        }
        //如果O赢了
        if (o) {
            //返回
            return oCount == xCount;
        }
        //默认
        return true;
    }

    //检查
    private boolean checkWin(String[] board, char player) {
        //行
        for (int i = 0; i < 3; i++) {
            //如果赢了
            if (board[i].charAt(0) == player && board[i].charAt(1) == player && board[i].charAt(2) == player) {
                //是
                return true;
            }
        }
        //列
        for (int j = 0; j < 3; j++) {
            //如果赢了
            if (board[0].charAt(j) == player && board[1].charAt(j) == player && board[2].charAt(j) == player) {
                //是
                return true;
            }
        }
        //对角线
        if (board[0].charAt(0) == player && board[1].charAt(1) == player && board[2].charAt(2) == player) {
            //是
            return true;
        }
        //对角线
        if (board[0].charAt(2) == player && board[1].charAt(1) == player && board[2].charAt(0) == player) {
            //是
            return true;
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        /*System.out.println(new Code15().validTicTacToe(new String[]{
                "XOX",
                " X ",
                "   "
        }));*/
        System.out.println(new Code15().validTicTacToe(new String[]{
                "XO ",
                "XO ",
                "XO "
        }));
        // "XXX",
        // "OOX",
        // "OOX"
    }

}
