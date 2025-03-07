package normal2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2021-04-19
 * 54. 螺旋矩阵
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 10
 * -100 <= matrix[i][j] <= 100
 */
public class Code16 {

    //转向 1=x++  2=y++ 3=x-- 4=y--
    int option = 1;
    //网格
    int[][] arr;
    //结果
    List<Integer> result = new ArrayList<>();
    //缓存
    Set<String> set = new HashSet<>();
    //起始位置
    int x = 0, y = 0;

    public List<Integer> spiralOrder(int[][] matrix) {
        //全局
        arr = matrix;
        //总和
        int allSize = matrix.length * matrix[0].length;
        //循环
        while (set.size() < allSize) {
            //当前
            int thisNum = matrix[y][x];
            //对应缓存key
            String setStr = x + "," + y;
            //记录
            set.add(setStr);
            //组装
            result.add(thisNum);
            //下一个
            next();
        }
        //返回
        return result;
    }

    /**
     * 下一个判定
     */
    private void next() {
        //根据选项移动
        switch (option) {
            case 1:
                x++;
                //如果越界了
                if (isCross()) {
                    //捡回来
                    x--;
                    //更新
                    option++;
                    y++;
                }
                break;
            case 2:
                y++;
                //如果越界了
                if (isCross()) {
                    //捡回来
                    y--;
                    //更新
                    option++;
                    x--;
                }
                break;
            case 3:
                x--;
                //如果越界了
                if (isCross()) {
                    //捡回来
                    x++;
                    //更新
                    option++;
                    y--;
                }
                break;
            case 4:
            default:
                y--;
                //如果越界了
                if (isCross()) {
                    //捡回来
                    y++;
                    //回归
                    option = 1;
                    x++;
                }
                break;
        }
    }

    /**
     * 如果越界了(本身越界+已经走过的墙)
     *
     * @return
     */
    private boolean isCross() {
        //如果数组越界
        if (x < 0 || x >= arr[0].length || y < 0 || y >= arr.length) {
            //越界
            return true;
        }
        //如果墙越界了
        if (set.contains(x + "," + y)) {
            //越界
            return true;
        }
        //未越界
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().spiralOrder(new int[][]{
                new int[]{1, 2, 3, 4},
                new int[]{5, 6, 7, 8},
                new int[]{9, 10, 11, 12}
        }));
    }
}
