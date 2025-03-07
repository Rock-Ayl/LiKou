package easy3;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2020-10-21
 * 977. 有序数组的平方
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 * <p>
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 */
public class Code1 {

    public static int[] sortedSquares(int[] A) {
        //循环
        for (int i = 0; i < A.length; i++) {
            //当前数
            int x = A[i];
            //平方
            A[i] = x * x;
        }
        //排序
        Arrays.sort(A);
        //返回
        return A;
    }

    public static void main(String[] args) {
        for (int i : sortedSquares(new int[]{-4, -1, 0, 3, 10})) {
            System.out.println(i);
        }
    }
}
