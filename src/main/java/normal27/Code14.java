package normal27;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-12-30
 * LCR 060. 前 K 个高频元素
 * 中等
 * 68
 * 相关企业
 * 给定一个整数数组 nums 和一个整数 k ，请返回其中出现频率前 k 高的元素。可以按 任意顺序 返回答案。
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
 * 进阶：所设计算法的时间复杂度 必须 优于 O(n log n) ，其中 n 是数组大小。
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 347 题相同：https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class Code14 {

    public int[] topKFrequent(int[] nums, int k) {
        //优先队列,懒得手搓了
        PriorityQueue<Map.Entry<Integer, Long>> priorityQueue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Long>>() {
            @Override
            public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                return o2.getValue().intValue() - o1.getValue().intValue();
            }
        });
        //加入队列
        priorityQueue.addAll(Arrays.stream(nums)
                //装箱
                .boxed()
                //分组统计数量
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                //转为集合
                .entrySet());
        //初始化结果
        int[] result = new int[k];
        //循环
        for (int i = 0; i < result.length; i++) {
            //获取结果
            result[i] = priorityQueue.poll().getKey();
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code14().topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        System.out.println();
    }
}
