package normal5;

/**
 * @Author ayl
 * @Date 2021-07-25
 * 289. 生命游戏
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]
 * 输出：[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]
 * 示例 2：
 * <p>
 * <p>
 * 输入：board = [[1,1],[1,0]]
 * 输出：[[1,1],[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 25
 * board[i][j] 为 0 或 1
 */
public class Code9 {

    //模板
    int[][] template;
    //周围活细胞数
    int size = 0;

    public void add(int x, int y) {
        try {
            //尝试获取
            int num = template[x][y];
            //如果是活细胞
            if (num == 1) {
                //记录
                size++;
            }
        } catch (Exception e) {

        }
    }

    //判定其结果
    public int check(int x, int y, int cell) {
        //开始计算
        add(x + 1, y);
        add(x, y + 1);
        add(x - 1, y);
        add(x, y - 1);
        add(x + 1, y + 1);
        add(x + 1, y - 1);
        add(x - 1, y - 1);
        add(x - 1, y + 1);
        //结果
        int result;
        //如果周围三个活细胞
        if (size == 3) {
            //必活
            result = 1;
        } else {
            //如果是活的
            if (cell == 1 && size == 2) {
                //还可以活
                result = 1;
            } else {
                //死
                result = 0;
            }
        }
        //重置
        size = 0;
        //返回
        return result;
    }

    public void gameOfLife(int[][] board) {
        //初始化模板
        template = new int[board.length][board[0].length];
        //循环1
        for (int i = 0; i < board.length; i++) {
            //循环2
            for (int j = 0; j < board[0].length; j++) {
                //复制
                template[i][j] = board[i][j];
            }
        }
        //循环1
        for (int i = 0; i < board.length; i++) {
            //循环2
            for (int j = 0; j < board[0].length; j++) {
                //判定当前细胞结果
                board[i][j] = check(i, j, board[i][j]);
            }
        }
        for (int[] ints : board) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        new Code9().gameOfLife(new int[][]{
                new int[]{0, 1, 0},
                new int[]{0, 0, 1},
                new int[]{1, 1, 1},
                new int[]{0, 0, 0}
        });
    }
}
