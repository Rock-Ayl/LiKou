package easy28;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-02-21
 * 1232. 缀点成线
 * 给定一个数组 coordinates ，其中 coordinates[i] = [x, y] ， [x, y] 表示横坐标为 x、纵坐标为 y 的点。请你来判断，这些点是否在该坐标系中属于同一条直线上。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * 输出：true
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates 中不含重复的点
 */
public class Code11 {

    public boolean checkStraightLine(int[][] coordinates) {
        //如果最多2点
        if (coordinates.length < 3) {
            //肯定可以
            return true;
        }
        //横竖线缓存
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        //循环1
        for (int[] coordinate : coordinates) {
            //记录每一列的情况
            set1.add(coordinate[0]);
            set2.add(coordinate[1]);
        }
        //如果是横竖线
        if (set1.size() == 1 || set2.size() == 1) {
            //可以
            return true;
        }
        //如果横竖有重复的值了
        if (set1.size() != coordinates.length || set2.size() != coordinates.length) {
            //肯定不是
            return false;
        }
        //第一个点
        int firstX = coordinates[0][0];
        int firstY = coordinates[0][1];
        //第二个点
        int secondX = coordinates[1][0];
        int secondY = coordinates[1][1];
        //第一个长宽
        int width = secondX - firstX;
        int height = secondY - firstY;
        //循环
        for (int i = 2; i < coordinates.length; i++) {
            //当前长宽
            int thisWidth = coordinates[i][0] - firstX;
            int thisHeight = coordinates[i][1] - firstY;
            //如果长宽比不同
            if (thisHeight / height != thisWidth / width) {
                //不是
                return false;
            }
        }
        //默认可以
        return true;
    }

    public boolean start(int[][] coordinates) {
        int deltaX = coordinates[0][0], deltaY = coordinates[0][1];
        for (int i = 0; i < coordinates.length; i++) {
            coordinates[i][0] -= deltaX;
            coordinates[i][1] -= deltaY;
        }
        int A = coordinates[1][1], B = -coordinates[1][0];
        for (int i = 2; i < coordinates.length; i++) {
            int x = coordinates[i][0], y = coordinates[i][1];
            if (A * x + B * y != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().start(new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4}
        }));
    }

}
