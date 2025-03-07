package normal27;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-05
 * 347. 前 K 个高频元素
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,1,1,2,2,3], k = 2
 * 输出: [1,2]
 * 示例 2:
 * <p>
 * 输入: nums = [1], k = 1
 * 输出: [1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * k 的取值范围是 [1, 数组中不相同的元素的个数]
 * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的
 * <p>
 * <p>
 * 进阶：你所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 */
public class Code16 {

    public int[] topKFrequent(int[] nums, int k) {
        //优先队列
        PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>((a, b) -> b.getValue().intValue() - a.getValue().intValue());
        //分组,加入优先队列
        queue.addAll(Arrays.stream(nums)
                .boxed()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet());
        //初始化结果
        int[] result = new int[k];
        //循环
        for (int i = 0; i < result.length; i++) {
            //记录结果
            result[i] = queue.poll().getKey();
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code16().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println();
    }
}
