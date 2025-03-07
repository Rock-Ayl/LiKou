package normal3;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-05-07
 * 79. 单词搜索
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 示例 1：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * 输出：true
 * 示例 3：
 * <p>
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * m == board.length
 * n = board[i].length
 * 1 <= m, n <= 6
 * 1 <= word.length <= 15
 * board 和 word 仅由大小写英文字母组成
 */
public class Code15 {

    //全局
    char[][] arr;
    String word;

    public boolean next(int x, int y, int p, Set<String> set) {
        //如果到尾了
        if (p == word.length()) {
            //可以
            return true;
        }
        //获取所需char
        char nextChar = word.charAt(p);
        //上下左右走
        //未越界
        if (x < arr.length - 1) {
            //获取
            char a = arr[x + 1][y];
            //如果是所需的char
            if (a == nextChar) {
                //坐标转为str
                String str = (x + 1) + "," + y;
                //如果没走过该路径
                if (!set.contains(str)) {
                    //记录走过该点
                    set.add(str);
                    //下一步
                    boolean can = next(x + 1, y, p + 1, set);
                    //如果可以走过去
                    if (can) {
                        //可以
                        return true;
                    }
                    //回溯
                    set.remove(str);
                }
            }
        }
        //未越界
        if (x > 0) {
            //获取
            char b = arr[x - 1][y];
            //如果是所需的char
            if (b == nextChar) {
                //坐标转为str
                String str = (x - 1) + "," + y;
                //如果没走过该路径
                if (!set.contains(str)) {
                    //记录走过该点
                    set.add(str);
                    //下一步
                    boolean can = next(x - 1, y, p + 1, set);
                    //如果可以走过去
                    if (can) {
                        //可以
                        return true;
                    }
                    //回溯
                    set.remove(str);
                }
            }
        }
        //未越界
        if (y < arr[0].length - 1) {
            //获取
            char c = arr[x][y + 1];
            //如果是所需的char
            if (c == nextChar) {
                //坐标转为str
                String str = x + "," + (y + 1);
                //如果没走过该路径
                if (!set.contains(str)) {
                    //记录走过该点
                    set.add(str);
                    //下一步
                    boolean can = next(x, y + 1, p + 1, set);
                    //如果可以走过去
                    if (can) {
                        //可以
                        return true;
                    }
                    //回溯
                    set.remove(str);
                }
            }
        }
        //未越界
        if (y > 0) {
            //获取
            char d = arr[x][y - 1];
            //如果是所需的char
            if (d == nextChar) {
                //坐标转为str
                String str = x + "," + (y - 1);
                //如果没走过该路径
                if (!set.contains(str)) {
                    //记录走过该点
                    set.add(str);
                    //下一步
                    boolean can = next(x, (y - 1), p + 1, set);
                    //如果可以走过去
                    if (can) {
                        //可以
                        return true;
                    }
                    //回溯
                    set.remove(str);
                }
            }
        }
        //默认不可以
        return false;
    }

    public boolean exist(char[][] board, String word) {
        //如果太长了
        if ((board.length * board[0].length) < word.length()) {
            //肯定不行
            return false;
        }
        //赋予全局
        this.arr = board;
        this.word = word;
        //第一个字符
        char first = word.charAt(0);
        //循环
        for (int i = 0; i < this.arr.length; i++) {
            //循环
            for (int j = 0; j < this.arr[0].length; j++) {
                //如果找到了
                if (arr[i][j] == first) {
                    //走过的路径
                    Set<String> set = new HashSet<>();
                    //记录该点
                    set.add(i + "," + j);
                    //递归
                    boolean isCan = next(i, j, 1, set);
                    //如果成功
                    if (isCan) {
                        //返回
                        return true;
                    }
                }
            }
        }
        //默认不可以
        return false;
    }

    /**
     * 懒得优化了...
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(new Code15().exist(new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'E', 'S'},
                new char[]{'A', 'D', 'E', 'E'}
        }, "ABCESEEEFS"));
    }
}
