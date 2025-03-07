package easy3;

/**
 * Created By Rock-Ayl on 2020-10-31
 * 896. 单调数列
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * <p>
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * <p>
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 */
public class Code11 {

    public static boolean isMonotonic(int[] A) {
        //长度
        int size = A.length;
        //上一个
        int last = A[0];
        //最后一个
        int end = A[size - 1];
        //如果递减
        if (last > end) {
            //循环
            for (int i = 1; i < A.length; i++) {
                //当前
                int thisI = A[i];
                //如果下一个大于上一个了
                if (A[i] > last) {
                    //不是
                    return false;
                }
                //记录
                last = thisI;
            }
        } else if (last == end) {
            //循环
            for (int i = 1; i < A.length; i++) {
                //当前
                int thisI = A[i];
                //如果不是
                if (A[i] != last) {
                    //不是
                    return false;
                }
                //记录
                last = thisI;
            }
        } else {
            //循环
            for (int i = 1; i < A.length; i++) {
                //当前
                int thisI = A[i];
                //如果下一个小于上一个了
                if (thisI < last) {
                    //不是
                    return false;
                }
                //记录
                last = thisI;
            }
        }
        //缺省
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isMonotonic(new int[]{1, 3, 2}));
    }
}
