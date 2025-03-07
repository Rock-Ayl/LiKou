package easy5;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-01-13
 * 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。
 * <p>
 * 如果不能形成任何面积不为零的三角形，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[2,1,2]
 * 输出：5
 * 示例 2：
 * <p>
 * 输入：[1,2,1]
 * 输出：0
 * 示例 3：
 * <p>
 * 输入：[3,2,3,4]
 * 输出：10
 * 示例 4：
 * <p>
 * 输入：[3,6,2,3]
 * 输出：8
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
public class Code13 {

    public static int largestPerimeter(int[] A) {
        //如果不构成三边
        if (A.length < 3) {
            //缺省
            return 0;
        }
        //排个序
        Arrays.sort(A);
        //当前位置最大边位置
        int p = A.length - 1;
        //当至少能凑够三边
        while (p > 1) {
            //获取三边
            int x = A[p], y = A[p - 1], z = A[p - 2];
            //如果满足三角形条件
            if (y + z > x) {
                //返回周长
                return x + y + z;
            }
            //位置递减
            p--;
        }
        //缺省
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3, 6, 2, 3}));
    }
}
