package normal47;

/**
 * @Author ayl
 * @Date 2025-11-04
 * 设计一个算法，判断玩家是否赢了井字游戏。输入是一个 N x N 的数组棋盘，由字符" "，"X"和"O"组成，其中字符" "代表一个空位。
 * <p>
 * 以下是井字游戏的规则：
 * <p>
 * 玩家轮流将字符放入空位（" "）中。
 * 第一个玩家总是放字符"O"，且第二个玩家总是放字符"X"。
 * "X"和"O"只允许放置在空位中，不允许对已放有字符的位置进行填充。
 * 当有N个相同（且非空）的字符填充任何行、列或对角线时，游戏结束，对应该字符的玩家获胜。
 * 当所有位置非空时，也算为游戏结束。
 * 如果游戏结束，玩家不允许再放置字符。
 * 如果游戏存在获胜者，就返回该游戏的获胜者使用的字符（"X"或"O"）；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 示例 1：
 * <p>
 * 输入： board = ["O X"," XO","X O"]
 * 输出： "X"
 * 示例 2：
 * <p>
 * 输入： board = ["OOX","XXO","OXO"]
 * 输出： "Draw"
 * 解释： 没有玩家获胜且不存在空位
 * 示例 3：
 * <p>
 * 输入： board = ["OOX","XXO","OX "]
 * 输出： "Pending"
 * 解释： 没有玩家获胜且仍存在空位
 * 提示：
 * <p>
 * 1 <= board.length == board[i].length <= 100
 * 输入一定遵循井字棋规则
 */
public class Code18 {

    public String tictactoe(String[] board) {

        //n
        int n = board.length;

        /**
         * 横
         */

        //跳出标记
        out:
        //循环
        for (int i = 0; i < board.length; i++) {
            //第一个字符
            char letter = board[i].charAt(0);
            //如果是空
            if (letter == ' ') {
                //本轮过
                continue out;
            }
            //循环
            for (int j = 1; j < n; j++) {
                //如果后面的不同
                if (letter != board[i].charAt(j)) {
                    //跳出
                    continue out;
                }
            }
            //返回结果
            return String.valueOf(letter);
        }

        /**
         * 纵
         */

        //跳出标记
        out:
        //循环
        for (int i = 0; i < board[0].length(); i++) {
            //第一个字符
            char letter = board[0].charAt(i);
            //如果是空
            if (letter == ' ') {
                //本轮过
                continue out;
            }
            //循环
            for (int j = 1; j < n; j++) {
                //如果后面的不同
                if (letter != board[j].charAt(i)) {
                    //跳出
                    continue out;
                }
            }
            //返回结果
            return String.valueOf(letter);
        }

        /**
         * 斜1
         */

        //作用域
        if (board[0].charAt(0) != ' ') {
            //是否正确,默认是
            boolean oneRight = true;
            //循环
            for (int i = 1; i < n; i++) {
                //如果不同
                if (board[0].charAt(0) != board[i].charAt(i)) {
                    //不是
                    oneRight = false;
                    //跳出
                    break;
                }
            }
            //若斜1是
            if (oneRight == true) {
                //返回结果
                return String.valueOf(board[0].charAt(0));
            }
        }

        /**
         * 斜2
         */

        //作用域
        if (true) {
            //是否正确,默认是
            boolean twoRight = true;
            //索引
            int i = 0;
            int j = n - 1;
            //索引
            int startI = i;
            int startJ = j;
            //如果不是空格
            if (board[startI].charAt(startJ) != ' ') {
                //循环
                while (j >= 0) {
                    //如果不同
                    if (board[startI].charAt(startJ) != board[i++].charAt(j--)) {
                        //不是
                        twoRight = false;
                        //跳出
                        break;
                    }
                }
                //若斜2是
                if (twoRight == true) {
                    //返回结果
                    return String.valueOf(board[startI].charAt(startJ));
                }
            }
        }

        /**
         * 返回结果
         */

        //循环1
        for (int i = 0; i < board.length; i++) {
            //循环2
            for (int j = 0; j < board[0].length(); j++) {
                //如果有空位
                if (board[i].charAt(j) == ' ') {
                    //有空位
                    return "Pending";
                }
            }
        }
        //默认没有空位
        return "Draw";
    }

    public static void main(String[] args) {
        System.out.println(new Code18().tictactoe(new String[]{
                "   X O  O ", " X X    O ", "X  X    O ", "X    OX O ", "X   XO  O ", "X  X O  O ", "O  X O  O ", "     O  OX", "     O  O ", "   X XXXO "
        }));
    }

}
