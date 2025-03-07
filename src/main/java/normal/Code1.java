package normal;

/**
 * Created By Rock-Ayl on 2020-07-28
 * 旋转图像
 * 给定一个 n × n 的二维矩阵表示一个图像。
 * <p>
 * 将图像顺时针旋转 90 度。
 * <p>
 * 说明：
 * <p>
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 * <p>
 * 示例 1:
 * <p>
 * 给定 matrix =
 * [
 * [1,2,3],
 * [4,5,6],
 * [7,8,9]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [7,4,1],
 * [8,5,2],
 * [9,6,3]
 * ]
 * 示例 2:
 * <p>
 * 给定 matrix =
 * [
 * [ 5, 1, 9,11],
 * [ 2, 4, 8,10],
 * [13, 3, 6, 7],
 * [15,14,12,16]
 * ],
 * <p>
 * 原地旋转输入矩阵，使其变为:
 * [
 * [15,13, 2, 5],
 * [14, 3, 4, 1],
 * [12, 6, 8, 9],
 * [16, 7,10,11]
 * ]
 */
public class Code1 {

    public static void rotate(int[][] matrix) {
        //置换的缓存
        int a;
        int b;
        int c;
        int d;
        //几次循环
        int size = matrix.length / 2;
        //绝对坐标
        int x = 0;
        int y = matrix.length - 1;
        int ee = 0;
        int rr = matrix.length - 1;
        int zz = 1;
        //大循环
        while (size > 0) {
            int e = ee;
            int r = rr;
            //要处理几排
            int num = matrix.length - zz;
            while (num > 0) {
                e++;
                r--;
                a = matrix[x][e];
                b = matrix[e][y];
                c = matrix[y][r];
                d = matrix[r][x];
                matrix[x][e] = d;
                matrix[e][y] = a;
                matrix[y][r] = b;
                matrix[r][x] = c;
                num--;
            }
            zz++;
            zz++;
            ee++;
            rr--;
            size--;
            x++;
            y--;
        }
    }

    public static void main(String[] args) {
        //测试数据
        int[][] data = new int[][]{
                {1, 2, 3, 4, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}};
        //测试数据
        int[][] data2 = new int[][]{
                {1, 2, 3, 4},
                {6, 7, 8, 9},
                {11, 12, 13, 14},
                {16, 17, 18, 19}};
        //旋转
        rotate(data);
        for (int[] datum : data) {
            for (int i : datum) {
                System.out.print(i);
            }
        }
        System.out.println();
        //循环输出
        for (int[] datum : data) {
            for (int i : datum) {
                System.out.print(i + ",");
            }
            System.out.println();
        }
    }
}
