package easy9;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author 安永亮
 * @Date 2021-06-13
 * @Description 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class Code1 {

    //网格
    int[][] matrix;
    //指针
    int point = 0;
    //方向
    int direction = 0;
    //结果
    int[] arr;
    //走过的点
    Set<String> set = new HashSet<>();

    public void move(int x, int y) {
        //如果走完了
        if (set.size() == arr.length) {
            //结束
            return;
        }
        //转化为str
        String str = x + "," + y;
        //记录走过
        set.add(str);
        //记录结果
        arr[point++] = matrix[x][y];
        //根据方向操作下一步
        switch (direction) {
            case 0:
                //预计的下一步
                y++;
                //转化为str
                str = x + "," + y;
                //如果未越界或者未走过这个点
                if (y < matrix[0].length && !set.contains(str)) {
                    //下一步
                    move(x, y);
                } else {
                    //改变方向
                    direction++;
                    //下一步
                    move(++x, --y);
                }
                break;
            case 1:
                //预计的下一步
                x++;
                //转化为str
                str = x + "," + y;
                //如果未越界或者未走过这个点
                if (x < matrix.length && !set.contains(str)) {
                    //下一步
                    move(x, y);
                } else {
                    //改变方向
                    direction++;
                    //下一步
                    move(--x, --y);
                }
                break;
            case 2:
                //预计的下一步
                y--;
                //转化为str
                str = x + "," + y;
                //如果未越界或者未走过这个点
                if (y > -1 && !set.contains(str)) {
                    //下一步
                    move(x, y);
                } else {
                    //改变方向
                    direction++;
                    //下一步
                    move(--x, ++y);
                }
                break;
            case 3:
                //预计的下一步
                x--;
                //转化为str
                str = x + "," + y;
                //如果未越界或者未走过这个点
                if (x > -1 && !set.contains(str)) {
                    //下一步
                    move(x, y);
                } else {
                    //回退
                    direction = 0;
                    //下一步
                    move(++x, ++y);
                }
                break;
        }
    }

    public int[] spiralOrder(int[][] matrix) {
        //判空
        if (matrix.length == 0) {
            //默认
            return new int[]{};
        }
        //全局
        this.matrix = matrix;
        //结果
        this.arr = new int[matrix.length * matrix[0].length];
        //起始点
        int x = 0, y = 0;
        //不断移动
        move(x, y);
        //返回
        return this.arr;
    }

    public static void main(String[] args) {
        for (int i : new Code1().spiralOrder(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        })) {
            System.out.println(i);
        }
    }

}
