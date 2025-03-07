package normal17;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-12-05
 * 1861. 旋转盒子
 * 给你一个 m x n 的字符矩阵 box ，它表示一个箱子的侧视图。箱子的每一个格子可能为：
 * <p>
 * '#' 表示石头
 * '*' 表示固定的障碍物
 * '.' 表示空位置
 * 这个箱子被 顺时针旋转 90 度 ，由于重力原因，部分石头的位置会发生改变。每个石头会垂直掉落，直到它遇到障碍物，另一个石头或者箱子的底部。重力 不会 影响障碍物的位置，同时箱子旋转不会产生惯性 ，也就是说石头的水平位置不会发生改变。
 * <p>
 * 题目保证初始时 box 中的石头要么在一个障碍物上，要么在另一个石头上，要么在箱子的底部。
 * <p>
 * 请你返回一个 n x m的矩阵，表示按照上述旋转后，箱子内的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：box = [["#",".","#"]]
 * 输出：[["."],
 * ["#"],
 * ["#"]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：box = [["#",".","*","."],
 * ["#","#","*","."]]
 * 输出：[["#","."],
 * ["#","#"],
 * ["*","*"],
 * [".","."]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：box = [["#","#","*",".","*","."],
 * ["#","#","#","*",".","."],
 * ["#","#","#",".","#","."]]
 * 输出：[[".","#","#"],
 * [".","#","#"],
 * ["#","#","*"],
 * ["#","*","."],
 * ["#",".","*"],
 * ["#",".","."]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == box.length
 * n == box[i].length
 * 1 <= m, n <= 500
 * box[i][j] 只可能是 '#' ，'*' 或者 '.' 。
 */
public class Code14 {

    public char[][] rotateTheBox(char[][] box) {
        //初始化结果
        char[][] result = new char[box[0].length][box.length];
        //循环
        for (char[] chars : result) {
            //填充所有为.
            Arrays.fill(chars, '.');
        }
        //长度与深度
        int length = result.length - 1;
        //结果指针
        int resultP = box.length - 1;
        //循环1
        for (int i = 0; i < box.length; i++) {
            //当前源box行
            char[] linkBox = box[i];
            //快指针
            int fast = length;
            //慢指针
            int low = length;
            //循环
            while (fast >= 0) {
                //获取当前原始,fast直接递减
                char fastLetter = linkBox[fast--];
                //根据情况处理
                switch (fastLetter) {
                    //实体
                    case '#':
                        //记录,递减
                        result[low--][resultP - i] = '#';
                        break;
                    //空行
                    case '.':
                        break;
                    //墙
                    case '*':
                        //使用墙
                        low = fast + 1;
                        //记录墙
                        result[low--][resultP - i] = '*';
                        break;
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        //结果
        char[][] result = new Code14().rotateTheBox(new char[][]{
                new char[]{'#', '#', '*', '.', '*', '.'},
                new char[]{'#', '#', '#', '*', '.', '.'},
                new char[]{'#', '#', '#', '.', '#', '.'}
        });
        for (char[] chars : result) {
            for (char aChar : chars) {
                System.out.print(aChar);
                System.out.print(',');
            }
            System.out.println();
        }
    }

}
