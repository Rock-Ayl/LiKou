package easy32;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-06-30
 * 面试题 10.01. 合并排序的数组
 * 给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。
 * <p>
 * 初始化 A 和 B 的元素数量分别为 m 和 n。
 * <p>
 * 示例:
 * <p>
 * 输入:
 * A = [1,2,3,0,0,0], m = 3
 * B = [2,5,6],       n = 3
 * <p>
 * 输出: [1,2,2,3,5,6]
 * 说明:
 * <p>
 * A.length == n + m
 */
public class Code10 {

    public void merge(int[] A, int m, int[] B, int n) {
        //如果不需要
        if (n < 1) {
            //过
            return;
        }
        //指针
        int p = 0;
        //循环
        for (int i = m; i < A.length; i++) {
            //记录
            A[i] = B[p++];
        }
        //排序
        Arrays.sort(A);
    }

    public static void main(String[] args) {
        new Code10().merge(new int[]{4, 5, 6, 0, 0, 0}, 3, new int[]{1, 2, 3}, 3);
    }

}
