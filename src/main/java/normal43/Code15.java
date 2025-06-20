package normal43;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-06-02
 * 1846. 减小和重新排列数组后的最大元素
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个正整数数组 arr 。请你对 arr 执行一些操作（也可以不进行任何操作），使得数组满足以下条件：
 * <p>
 * arr 中 第一个 元素必须为 1 。
 * 任意相邻两个元素的差的绝对值 小于等于 1 ，也就是说，对于任意的 1 <= i < arr.length （数组下标从 0 开始），都满足 abs(arr[i] - arr[i - 1]) <= 1 。abs(x) 为 x 的绝对值。
 * 你可以执行以下 2 种操作任意次：
 * <p>
 * 减小 arr 中任意元素的值，使其变为一个 更小的正整数 。
 * 重新排列 arr 中的元素，你可以以任意顺序重新排列。
 * 请你返回执行以上操作后，在满足前文所述的条件下，arr 中可能的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,2,1,2,1]
 * 输出：2
 * 解释：
 * 我们可以重新排列 arr 得到 [1,2,2,2,1] ，该数组满足所有条件。
 * arr 中最大元素为 2 。
 * 示例 2：
 * <p>
 * 输入：arr = [100,1,1000]
 * 输出：3
 * 解释：
 * 一个可行的方案如下：
 * 1. 重新排列 arr 得到 [1,100,1000] 。
 * 2. 将第二个元素减小为 2 。
 * 3. 将第三个元素减小为 3 。
 * 现在 arr = [1,2,3] ，满足所有条件。
 * arr 中最大元素为 3 。
 * 示例 3：
 * <p>
 * 输入：arr = [1,2,3,4,5]
 * 输出：5
 * 解释：数组已经满足所有条件，最大元素为 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 105
 * 1 <= arr[i] <= 109
 */
public class Code15 {

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        //排序
        Arrays.sort(arr);
        //如果第一个不是1
        if (arr[0] != 1) {
            //固定为1
            arr[0] = 1;
        }
        //循环
        for (int i = 1; i < arr.length; i++) {
            //如果超了
            if (Math.abs(arr[i] - arr[i - 1]) > 1) {
                //修改为最大情况
                arr[i] = arr[i - 1] + 1;
            }
        }
        //返回
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code15().maximumElementAfterDecrementingAndRearranging(new int[]{100, 1, 1000}));
    }

}
