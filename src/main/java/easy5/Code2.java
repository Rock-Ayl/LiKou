package easy5;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-01-01
 * 1380. 矩阵中的幸运数
 * 给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
 * <p>
 * 幸运数是指矩阵中满足同时下列两个条件的元素：
 * <p>
 * 在同一行的所有元素中最小
 * 在同一列的所有元素中最大
 * <p>
 * 示例 1：
 * <p>
 * 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * 输出：[15]
 * 解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * 输出：[12]
 * 解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
 * 示例 3：
 * <p>
 * 输入：matrix = [[7,8],[1,2]]
 * 输出：[7]
 */
public class Code2 {

    public static List<Integer> luckyNumbers(int[][] matrix) {
        //初始化结果
        List<Integer> list = new ArrayList<>();
        //循环1
        for (int i = 0; i < matrix.length; i++) {
            //当前组
            int[] arr = matrix[i];
            //初始化同行最小
            int min = arr[0];
            //初始化同行最小位置
            int minP = 0;
            //循环
            for (int j = 1; j < arr.length; j++) {
                //当前数
                int x = arr[j];
                //如果最小值更新
                if (x < min) {
                    //记录最小值
                    min = x;
                    //记录最小值位置
                    minP = j;
                }
            }
            //初始化同列最大
            int max = min;
            //循环
            for (int[] ints : matrix) {
                //获取同列值并计算最大
                max = Math.max(ints[minP], max);
            }
            //如果即是同行最小又是同列最大
            if (max == min) {
                //幸运数
                list.add(min);
            }
        }
        //返回结果
        return list;
    }

    public static void main(String[] args) {
        for (Integer luckyNumber : luckyNumbers(new int[][]{new int[]{3, 7, 8}, new int[]{9, 11, 13}, new int[]{15, 16, 17}})) {
            System.out.println(luckyNumber);
        }
    }
}
