package normal4;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-05-23
 * 419. 甲板上的战舰
 * 给定一个二维的甲板， 请计算其中有多少艘战舰。 战舰用 'X'表示，空位用 '.'表示。 你需要遵守以下规则：
 * <p>
 * 给你一个有效的甲板，仅由战舰或者空位组成。
 * 战舰只能水平或者垂直放置。换句话说,战舰只能由 1xN (1 行, N 列)组成，或者 Nx1 (N 行, 1 列)组成，其中N可以是任意大小。
 * 两艘战舰之间至少有一个水平或垂直的空位分隔 - 即没有相邻的战舰。
 * 示例 :
 * <p>
 * X..X
 * ...X
 * ...X
 * 在上面的甲板中有2艘战舰。
 * <p>
 * 无效样例 :
 * <p>
 * ...X
 * XXXX
 * ...X
 * 你不会收到这样的无效甲板 - 因为战舰之间至少会有一个空位将它们分开。
 */
public class Code9 {

    //全局
    char[][] board;
    //战舰个数
    int result = 0;

    //覆盖战舰
    public List<String> set(int x, int y, List<String> list) {
        //如果未越界
        if (x >= 0 && y >= 0 && x < this.board.length && y < this.board[0].length) {
            //当前空间
            char space = this.board[x][y];
            //如果是战舰
            if (space == 'X') {
                //记录坐标
                list.add(x + "," + y);
                //修改为甲板
                this.board[x][y] = '.';
                //上下左右
                list = set(x + 1, y, list);
                list = set(x - 1, y, list);
                list = set(x, y + 1, list);
                list = set(x, y - 1, list);
            }
        }
        //返回
        return list;
    }

    public int countBattleships(char[][] board) {
        //全局
        this.board = board;
        //循环1
        for (int i = 0; i < this.board.length; i++) {
            //循环2
            for (int j = 0; j < this.board[0].length; j++) {
                //如果是战舰的某一部分
                if (this.board[i][j] == 'X') {
                    //覆盖战舰,获取所有战舰坐标
                    List<String> list = set(i, j, new ArrayList<>());
                    //开头
                    String[] first = list.get(0).split(",");
                    //坐标
                    int x = Integer.valueOf(first[0]), y = Integer.valueOf(first[1]);
                    //横纵是否有修改过
                    boolean changeX = false, changeY = false;
                    //是否有不同
                    for (int k = 1; k < list.size(); k++) {
                        //当前坐标
                        String[] thisXY = list.get(0).split(",");
                        //坐标
                        int a = Integer.valueOf(first[0]), b = Integer.valueOf(first[1]);
                        //如果有变动
                        if (a != x) {
                            //记录
                            changeX = true;
                        }
                        //如果有变动
                        if (b != y) {
                            //记录
                            changeY = true;
                        }
                        //如果都有变动了
                        if (changeX && changeY) {
                            //结束
                            break;
                        }
                    }
                    //如果符合战舰
                    if (!changeX || !changeY) {
                        //+1
                        result++;
                    }
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code9().countBattleships(new char[][]{
                new char[]{'X', '.', '.', 'X'},
                new char[]{'.', '.', '.', 'X'},
                new char[]{'.', '.', '.', 'X'}
        }));
    }

}
