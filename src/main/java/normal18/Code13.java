package normal18;

/**
 * @Author ayl
 * @Date 2023-01-14
 * 1343. 大小为 K 且平均值大于等于阈值的子数组数目
 * 给你一个整数数组 arr 和两个整数 k 和 threshold 。
 * <p>
 * 请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
 * 输出：3
 * 解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
 * 示例 2：
 * <p>
 * 输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
 * 输出：6
 * 解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * 1 <= arr[i] <= 104
 * 1 <= k <= arr.length
 * 0 <= threshold <= 104
 */
public class Code13 {

    public int numOfSubarrays(int[] arr, int k, int threshold) {
        //结果
        int count = 0;
        //和
        int sum = 0;
        //循环
        for (int i = 0; i < k; i++) {
            //叠加
            sum += arr[i];
        }
        //如果是
        if (sum / k >= threshold) {
            //初始化+1
            count++;
        }
        //循环
        for (int i = k; i < arr.length; i++) {
            //滑动,重新计算
            sum = sum + arr[i] - arr[i - k];
            //如果是
            if (sum / k >= threshold) {
                //初始化+1
                count++;
            }
        }
        //返回结果
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }

}
