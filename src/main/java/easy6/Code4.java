package easy6;

/**
 * Created By Rock-Ayl on 2021-01-31
 * 1037. 有效的回旋镖
 * 回旋镖定义为一组三个点，这些点各不相同且不在一条直线上。
 * <p>
 * 给出平面上三个点组成的列表，判断这些点是否可以构成回旋镖。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[1,1],[2,3],[3,2]]
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：[[1,1],[2,2],[3,3]]
 * 输出：false
 * <p>
 * 提示：
 * <p>
 * points.length == 3
 * points[i].length == 2
 * 0 <= points[i][j] <= 100
 */
public class Code4 {

    public static boolean isBoomerang(int[][] points) {
        //循环
        int a = points[0][0];
        int b = points[1][0];
        int c = points[2][0];
        //如果三者x轴相同
        if (a == b && b == c) {
            //不可以
            return false;
        }
        //循环
        int a2 = points[0][1];
        int b2 = points[1][1];
        int c2 = points[2][1];
        //如果三者y轴相同
        if (a2 == b2 && b2 == c2) {
            //不可以
            return false;
        }
        //如果对角线相同
        if (c2 - b2 == b2 - a2 && c - b == b - a) {
            //不可以
            return false;
        }
        //如果有点相同
        if (a == b && a2 == b2 || b == c && b2 == c2 || a == c && a2 == c2) {
            //不可以
            return false;
        }
        //可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBoomerang(new int[][]{new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 1}}));
    }
}
