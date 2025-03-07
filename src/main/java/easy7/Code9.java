package easy7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-03-05
 * 905. 按奇偶排序数组
 * 给定一个非负整数数组 A，返回一个数组，在该数组中， A 的所有偶数元素之后跟着所有奇数元素。
 * <p>
 * 你可以返回满足此条件的任何数组作为答案。
 * <p>
 * 示例：
 * <p>
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * <p>
 * 提示：
 * <p>
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class Code9 {

    public static int[] sortArrayByParity(int[] A) {
        //长度
        int size = A.length;
        //奇数
        int[] single = new int[size];
        //位置
        int sp = 0;
        //偶数
        int[] even = new int[size];
        //位置
        int ep = 0;
        //循环
        for (int i : A) {
            //如果是偶数
            if (i % 2 == 0) {
                //记录
                even[ep++] = i;
            } else {
                //记录
                single[sp++] = i;
            }
        }
        //循环
        for (int i = 0; i < sp; i++) {
            //合并
            even[ep++] = single[i];
        }
        //返回
        return even;
    }

    public static void main(String[] args) {
        for (int i : sortArrayByParity(new int[]{4222, 3790, 2103, 1294, 2556, 2025, 3919, 1516, 2383, 2917})) {
            System.out.println(i);
        }
    }
}
