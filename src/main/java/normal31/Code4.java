package normal31;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-04-23
 * 593. 有效的正方形
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给定2D空间中四个点的坐标 p1, p2, p3 和 p4，如果这四个点构成一个正方形，则返回 true 。
 * <p>
 * 点的坐标 pi 表示为 [xi, yi] 。 输入没有任何顺序 。
 * <p>
 * 一个 有效的正方形 有四条等边和四个等角(90度角)。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * 示例 2:
 * <p>
 * 输入：p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,12]
 * 输出：false
 * 示例 3:
 * <p>
 * 输入：p1 = [1,0], p2 = [-1,0], p3 = [0,1], p4 = [0,-1]
 * 输出：true
 * <p>
 * <p>
 * 提示:
 * <p>
 * p1.length == p2.length == p3.length == p4.length == 2
 * -104 <= xi, yi <= 104
 */
public class Code4 {

    //计算两个单点的距离
    private int countNum(int a, int b) {
        //如果是同一个方向
        if (a >= 0 && b >= 0 || a <= 0 && b <= 0) {
            //距离
            return Math.abs(Math.abs(a) - Math.abs(b));
        }
        //如果a大b小
        if (a >= 0 && b <= 0) {
            //返回距离
            return a - b;
        }
        //如果a小b大
        if (a <= 0 && b >= 0) {
            //返回距离
            return b - a;
        }
        return 0;
    }

    //计算两点的伪距离
    private int count(int[] a, int[] b) {
        //距离,乘以2是特殊处理x,y=1的情况
        int x = countNum(a[0], b[0]) * 2;
        int y = countNum(a[1], b[1]) * 2;
        //判0
        if (x == 0) {
            //过
            return y;
        }
        //判0
        if (y == 0) {
            //过
            return x;
        }
        //计算伪距离
        return x * y;
    }

    //判断是否为一个点
    private boolean same(int[] a, int[] b) {
        return a[0] == b[0] && a[1] == b[1];
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        //如果有相同的点
        if (same(p1, p2) || same(p1, p3) || same(p1, p4) || same(p2, p3) || same(p2, p4) || same(p3, p4)) {
            //过
            return false;
        }
        //组合
        int[][] arr = new int[][]{p1, p2, p3, p4};
        //按照位置排序
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        //四边距离
        int one = count(arr[0], arr[1]);
        int two = count(arr[1], arr[3]);
        int three = count(arr[3], arr[2]);
        int four = count(arr[2], arr[0]);
        //中间线距离
        int left = count(arr[0], arr[3]);
        int right = count(arr[1], arr[2]);
        //返回
        return one == two && two == three && three == four && left == right;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().validSquare(new int[]{1, 1}, new int[]{3, 5}, new int[]{5, 3}, new int[]{7, 7}));
    }

}
