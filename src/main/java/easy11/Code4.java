package easy11;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-08-10
 * 1502. 判断能否形成等差数列
 * 给你一个数字数组 arr 。
 * <p>
 * 如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
 * <p>
 * 如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [3,5,1]
 * 输出：true
 * 解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2,4]
 * 输出：false
 * 解释：无法通过重新排序得到等差数列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= arr.length <= 1000
 * -10^6 <= arr[i] <= 10^6
 * 通过次数24,294提交次数33,828
 */
public class Code4 {

    public boolean canMakeArithmeticProgression(int[] arr) {
        //排个序
        Arrays.sort(arr);
        //如果长度太小
        if (arr.length < 2) {
            //直接
            return true;
        }
        //默认差
        int minus = arr[1] - arr[0];
        //循环
        for (int i = 1; i < arr.length - 1; i++) {
            //如果不是了
            if (arr[i + 1] - arr[i] != minus) {
                //否
                return false;
            }
        }
        //是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().canMakeArithmeticProgression(new int[]{5, 3, 1}));
    }
}
