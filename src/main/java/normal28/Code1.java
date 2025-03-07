package normal28;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-15
 * LCR 076. 数组中的第 K 个最大元素
 * 中等
 * 相关标签
 * 相关企业
 * 给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
 * <p>
 * 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 示例 2:
 * <p>
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 注意：本题与主站 215 题相同： https://leetcode-cn.com/problems/kth-largest-element-in-an-array/
 */
public class Code1 {

    public int findKthLargest(int[] nums, int k) {
        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> b - a);
        //加入所有内容
        queue.addAll(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        //循环
        while (k-- > 1) {
            //弹出
            queue.poll();
        }
        //返回
        return queue.poll();
    }

    public static void main(String[] args) {
        System.out.println(new Code1().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

}
