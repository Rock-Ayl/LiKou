package normal5;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-07-12
 * 59. 螺旋矩阵 II
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 3
 * 输出：[[1,2,3],[8,9,4],[7,6,5]]
 * 示例 2：
 * <p>
 * 输入：n = 1
 * 输出：[[1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 20
 */
public class Code3 {

    //走过的路
    Set<String> set;
    //矩阵
    int[][] arr;
    //走到的数字
    int num;
    //方向
    int direction = 1;
    //最大长度
    int size;
    //n
    int n;

    public void next(int x, int y) {
        //走
        this.arr[x][y] = this.num++;
        //位置
        String str = x + "," + y;
        //记录
        this.set.add(str);
        //如果到头了
        if (this.set.size() == this.size) {
            //end
            return;
        }
        //根据方向走下一步
        switch (direction) {
            case 1:
                //走一下
                y++;
                //如果越界了或者走过了
                if (y == n || set.contains(x + "," + y)) {
                    //退步,改方向
                    y--;
                    x++;
                    direction = 2;
                }
                break;
            case 2:
                //走一下
                x++;
                //如果越界了或者走过了
                if (x == n || set.contains(x + "," + y)) {
                    //退步,改方向
                    x--;
                    y--;
                    direction = 3;
                }
                break;
            case 3:
                //走一下
                y--;
                //如果越界了或者走过了
                if (y < 0 || set.contains(x + "," + y)) {
                    //退步,改方向
                    y++;
                    x--;
                    direction = 4;
                }
                break;
            case 4:
                //走一下
                x--;
                //如果越界了或者走过了
                if (x < 0 || set.contains(x + "," + y)) {
                    //退步,改方向
                    x++;
                    y++;
                    direction = 1;
                }
                break;
        }
        //下一步
        next(x, y);
    }

    public int[][] generateMatrix(int n) {
        //全局
        this.arr = new int[n][n];
        this.n = n;
        //从1开始加
        this.num = 1;
        //最大长度
        this.size = n * n;
        //初始化
        this.set = new HashSet<>(size);
        //初始位置开始移动
        next(0, 0);
        //返回
        return this.arr;
    }

    public static void main(String[] args) {
        for (int[] ints : new Code3().generateMatrix(4)) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}
