package normal24;

/**
 * @Author ayl
 * @Date 2023-09-30
 * 面试题 01.07. 旋转矩阵
 * 提示
 * 中等
 * 283
 * 相关企业
 * 给你一幅由 N × N 矩阵表示的图像，其中每个像素的大小为 4 字节。请你设计一种算法，将图像旋转 90 度。
 * <p>
 * 不占用额外内存空间能否做到？
 * <p>
 * <p>
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
 * 注意：本题与主站 48 题相同：https://leetcode-cn.com/problems/rotate-image/
 */
public class Code13 {

    //交换该点及对应的另外三个角
    public void change(int[][] matrix, int x, int y, int a, int b, int xRight, int yRight) {
        //计算二者差值
        int xDiff = a - x;
        int yDiff = b - y;
        //给与边界
        xRight -= xDiff;
        yRight -= yDiff;
        //获取对应四个数
        int num1 = matrix[a][b];
        int num2 = matrix[b][xRight];
        int num3 = matrix[xRight][yRight];
        int num4 = matrix[yRight][a];
        //交换
        matrix[b][xRight] = num1;
        matrix[xRight][yRight] = num2;
        matrix[yRight][a] = num3;
        matrix[a][b] = num4;
    }

    //寻找所有需要交换的点
    public void rotate(int[][] matrix) {
        //要交换的点
        int x = 0;
        int y = 0;
        //对应矩形另一边
        int xRight = matrix.length - 1;
        int yRight = matrix[0].length - 1;
        //循环
        while (x < xRight && y < yRight) {
            //循环
            for (int i = y; i < yRight; i++) {
                //改变
                change(matrix, x, y, x, i, xRight, yRight);
            }
            //正方形收缩一层
            x++;
            y++;
            xRight--;
            yRight--;
        }
    }

    public static void main(String[] args) {
        //数组
        int[][] arr = {
                new int[]{5, 1, 9, 11},
                new int[]{2, 4, 8, 10},
                new int[]{13, 3, 6, 7},
                new int[]{15, 14, 12, 16}
        };
        //实现
        new Code13().rotate(arr);
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.println();
        }
    }

}
