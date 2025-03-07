package easy36;

/**
 * @Author ayl
 * @Date 2024-03-12
 * 1275. 找出井字棋的获胜者
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * A 和 B 在一个 3 x 3 的网格上玩井字棋。
 * <p>
 * 井字棋游戏的规则如下：
 * <p>
 * 玩家轮流将棋子放在空方格 (" ") 上。
 * 第一个玩家 A 总是用 "X" 作为棋子，而第二个玩家 B 总是用 "O" 作为棋子。
 * "X" 和 "O" 只能放在空方格中，而不能放在已经被占用的方格上。
 * 只要有 3 个相同的（非空）棋子排成一条直线（行、列、对角线）时，游戏结束。
 * 如果所有方块都放满棋子（不为空），游戏也会结束。
 * 游戏结束后，棋子无法再进行任何移动。
 * 给你一个数组 moves，其中每个元素是大小为 2 的另一个数组（元素分别对应网格的行和列），它按照 A 和 B 的行动顺序（先 A 后 B）记录了两人各自的棋子位置。
 * <p>
 * 如果游戏存在获胜者（A 或 B），就返回该游戏的获胜者；如果游戏以平局结束，则返回 "Draw"；如果仍会有行动（游戏未结束），则返回 "Pending"。
 * <p>
 * 你可以假设 moves 都 有效（遵循井字棋规则），网格最初是空的，A 将先行动。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：moves = [[0,0],[2,0],[1,1],[2,1],[2,2]]
 * 输出："A"
 * 解释："A" 获胜，他总是先走。
 * "X  "    "X  "    "X  "    "X  "    "X  "
 * "   " -> "   " -> " X " -> " X " -> " X "
 * "   "    "O  "    "O  "    "OO "    "OOX"
 * 示例 2：
 * <p>
 * 输入：moves = [[0,0],[1,1],[0,1],[0,2],[1,0],[2,0]]
 * 输出："B"
 * 解释："B" 获胜。
 * "X  "    "X  "    "XX "    "XXO"    "XXO"    "XXO"
 * "   " -> " O " -> " O " -> " O " -> "XO " -> "XO "
 * "   "    "   "    "   "    "   "    "   "    "O  "
 * 示例 3：
 * <p>
 * 输入：moves = [[0,0],[1,1],[2,0],[1,0],[1,2],[2,1],[0,1],[0,2],[2,2]]
 * 输出："Draw"
 * 解释：由于没有办法再行动，游戏以平局结束。
 * "XXO"
 * "OOX"
 * "XOX"
 * 示例 4：
 * <p>
 * 输入：moves = [[0,0],[1,1]]
 * 输出："Pending"
 * 解释：游戏还没有结束。
 * "X  "
 * " O "
 * "   "
 */
public class Code15 {

    public String tictactoe(int[][] moves) {
        //初始化棋盘
        char[][] arr = new char[3][3];
        //循环
        for (int i = 0; i < moves.length; i++) {
            //本次
            int[] move = moves[i];
            //判断谁走
            char letter = i % 2 == 0 ? 'X' : 'O';
            //走
            arr[move[0]][move[1]] = letter;
        }
        print(arr);
        //左边第一个
        char leftFirst = arr[0][0];
        //如果左边相同
        if (leftFirst != '\u0000' && leftFirst == arr[1][1] && leftFirst == arr[2][2]) {
            //返回结果
            return leftFirst == 'X' ? "A" : "B";
        }
        //如果左边的横相同
        if (leftFirst != '\u0000' && leftFirst == arr[0][1] && leftFirst == arr[0][2]) {
            //返回结果
            return leftFirst == 'X' ? "A" : "B";
        }
        //如果左边的竖相同
        if (leftFirst != '\u0000' && leftFirst == arr[1][0] && leftFirst == arr[2][0]) {
            //返回结果
            return leftFirst == 'X' ? "A" : "B";
        }
        //右边第一个
        char rightFirst = arr[0][2];
        //如果右边相同
        if (rightFirst != '\u0000' && rightFirst == arr[1][1] && rightFirst == arr[2][0]) {
            //返回结果
            return rightFirst == 'X' ? "A" : "B";
        }
        //右边最后一个
        char rightLast = arr[2][2];
        //如果右边的横相同
        if (rightLast != '\u0000' && rightLast == arr[2][1] && rightLast == arr[2][0]) {
            //返回结果
            return rightLast == 'X' ? "A" : "B";
        }
        //如果右边的竖相同
        if (rightLast != '\u0000' && rightLast == arr[1][2] && rightLast == arr[0][2]) {
            //返回结果
            return rightLast == 'X' ? "A" : "B";
        }
        //中间
        char mid = arr[1][1];
        //如果中间的横相同
        if (mid != '\u0000' && mid == arr[1][0] && mid == arr[1][2]) {
            //返回结果
            return mid == 'X' ? "A" : "B";
        }
        //如果中间的竖相同
        if (mid != '\u0000' && mid == arr[0][1] && mid == arr[2][1]) {
            //返回结果
            return mid == 'X' ? "A" : "B";
        }
        //默认
        return moves.length == 9 ? "Draw" : "Pending";
    }

    private void print(char[][] arr) {
        for (char[] chars : arr) {
            for (char c : chars) {
                System.out.print(c + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code15().tictactoe(new int[][]{
                new int [] {1,2},
                new int [] {2,1},
                new int [] {1,0},
                new int [] {0,0},
                new int [] {0,1},
                new int [] {2,0},
                new int [] {1,1}
        }));
    }

}
