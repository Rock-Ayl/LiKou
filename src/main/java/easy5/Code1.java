package easy5;

/**
 * Created By Rock-Ayl on 2020-12-31
 * 852. 山脉数组的峰顶索引
 * 我们把符合下列属性的数组 A 称作山脉：
 * <p>
 * A.length >= 3
 * 存在 0 < i < A.length - 1 使得A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
 * 给定一个确定为山脉的数组，返回任何满足 A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1] 的 i 的值。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[0,1,0]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：[0,2,1,0]
 * 输出：1
 * <p>
 * 提示：
 * <p>
 * 3 <= A.length <= 10000
 * 0 <= A[i] <= 10^6
 * A 是如上定义的山脉
 */
public class Code1 {

    /**
     * 方法2,二分
     *
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray2(int[] arr) {
        //左边界
        int left = 0;
        //右边界
        int right = arr.length - 1;
        //当前位置
        int p = right / 2;
        //循环
        while (left < right) {
            //当前高度
            int height = arr[p];
            //左右高度
            int a = arr[p - 1];
            int b = arr[p + 1];
            //如果左边矮
            if (height > a) {
                //如果右边也矮
                if (height > b) {
                    //结束
                    break;
                } else {
                    //更新左边界
                    left = p;
                }
            } else {
                //更新右边界
                right = p;
            }
            //计算新位置
            p = (right - left) / 2 + left;
        }
        //返回当前位置
        return p;
    }

    /**
     * 方法一，暴力
     *
     * @param arr
     * @return
     */
    public static int peakIndexInMountainArray(int[] arr) {
        //最高点
        int max = arr[0];
        //最高点位置
        int maxP = 0;
        //是否发现了最高点
        boolean isFindMax = false;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //当前高度
            int height = arr[i];
            //如果发现了最高点
            if (isFindMax == false) {
                //如果该高度比最高要高
                if (height > max) {
                    //更新最高点
                    max = height;
                    //更新最高点位置
                    maxP = i;
                } else {
                    //已发现最高点
                    isFindMax = true;
                }
            }
        }
        //返回最高点位置
        return maxP;
    }

    public static void main(String[] args) {
        System.out.println(peakIndexInMountainArray2(new int[]{3, 4, 5, 1}));
    }
}
