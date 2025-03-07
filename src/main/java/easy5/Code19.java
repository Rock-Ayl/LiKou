package easy5;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-01-19
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 * <p>
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class Code19 {

    public static int[] getLeastNumbers(int[] arr, int k) {
        //初始化返回值
        int[] result = new int[k];
        //排序
        Arrays.sort(arr);
        //k开始计算位置
        k--;
        //循环
        while (k >= 0) {
            //计算
            result[k] = arr[k--];
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int leastNumber : getLeastNumbers(new int[]{3, 2, 1, 4, 9, 12, 4}, 4)) {
            System.out.println(leastNumber);
        }
    }
}
