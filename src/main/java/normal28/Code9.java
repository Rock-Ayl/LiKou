package normal28;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-24
 * 1471. 数组中的 k 个最强值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 和一个整数 k 。
 * <p>
 * 设 m 为数组的中位数，只要满足下述两个前提之一，就可以判定 arr[i] 的值比 arr[j] 的值更强：
 * <p>
 * |arr[i] - m| > |arr[j] - m|
 * |arr[i] - m| == |arr[j] - m|，且 arr[i] > arr[j]
 * 请返回由数组中最强的 k 个值组成的列表。答案可以以 任意顺序 返回。
 * <p>
 * 中位数 是一个有序整数列表中处于中间位置的值。形式上，如果列表的长度为 n ，那么中位数就是该有序列表（下标从 0 开始）中位于 ((n - 1) / 2) 的元素。
 * <p>
 * 例如 arr = [6, -3, 7, 2, 11]，n = 5：数组排序后得到 arr = [-3, 2, 6, 7, 11] ，数组的中间位置为 m = ((5 - 1) / 2) = 2 ，中位数 arr[m] 的值为 6 。
 * 例如 arr = [-7, 22, 17, 3]，n = 4：数组排序后得到 arr = [-7, 3, 17, 22] ，数组的中间位置为 m = ((4 - 1) / 2) = 1 ，中位数 arr[m] 的值为 3 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,3,4,5], k = 2
 * 输出：[5,1]
 * 解释：中位数为 3，按从强到弱顺序排序后，数组变为 [5,1,4,2,3]。最强的两个元素是 [5, 1]。[1, 5] 也是正确答案。
 * 注意，尽管 |5 - 3| == |1 - 3| ，但是 5 比 1 更强，因为 5 > 1 。
 * 示例 2：
 * <p>
 * 输入：arr = [1,1,3,5,5], k = 2
 * 输出：[5,5]
 * 解释：中位数为 3, 按从强到弱顺序排序后，数组变为 [5,5,1,1,3]。最强的两个元素是 [5, 5]。
 * 示例 3：
 * <p>
 * 输入：arr = [6,7,11,7,6,8], k = 5
 * 输出：[11,8,6,6,7]
 * 解释：中位数为 7, 按从强到弱顺序排序后，数组变为 [11,8,6,6,7,7]。
 * [11,8,6,6,7] 的任何排列都是正确答案。
 * 示例 4：
 * <p>
 * 输入：arr = [6,-3,7,2,11], k = 3
 * 输出：[-3,11,2]
 * 示例 5：
 * <p>
 * 输入：arr = [-7,22,17,3], k = 2
 * 输出：[22,17]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -10^5 <= arr[i] <= 10^5
 * 1 <= k <= arr.length
 */
public class Code9 {

    //计算权重
    private int rank(int midNum, int num) {
        //如果相同
        if (midNum == num) {
            //返回
            return 0;
        }
        //如果一正一负
        if ((midNum > 0 && num < 0) || (midNum < 0 && num > 0)) {
            //计算
            return Math.abs(Math.abs(midNum) + Math.abs(num));
        } else {
            //计算
            return Math.abs(Math.abs(midNum) - Math.abs(num));
        }
    }

    public int[] getStrongest(int[] arr, int k) {
        //排序
        Arrays.sort(arr);
        //获取中位数
        int midNum = arr[((arr.length - 1) / 2)];
        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //计算权重
                int left = rank(midNum, o1);
                int right = rank(midNum, o2);
                //如果权重不同
                if (left != right) {
                    //用权重
                    return right - left;
                } else {
                    //用数字本身
                    return o2 - o1;
                }
            }
        });
        //加入所有
        queue.addAll(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        //初始化结果
        int[] result = new int[k];
        //循环
        for (int i = 0; i < result.length; i++) {
            //获取当前最大
            result[i] = queue.poll();
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        int[] strongest = new Code9().getStrongest(new int[]{6, 7, 11, 7, 6, 8}, 5);
        System.out.println();
    }

}
