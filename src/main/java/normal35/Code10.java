package normal35;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-09-23
 * 3066. 超过阈值的最少操作数 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * 一次操作中，你将执行：
 * <p>
 * 选择 nums 中最小的两个整数 x 和 y 。
 * 将 x 和 y 从 nums 中删除。
 * 将 min(x, y) * 2 + max(x, y) 添加到数组中的任意位置。
 * 注意，只有当 nums 至少包含两个元素时，你才可以执行以上操作。
 * <p>
 * 你需要使数组中的所有元素都大于或等于 k ，请你返回需要的 最少 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,11,10,1,3], k = 10
 * 输出：2
 * 解释：第一次操作中，我们删除元素 1 和 2 ，然后添加 1 * 2 + 2 到 nums 中，nums 变为 [4, 11, 10, 3] 。
 * 第二次操作中，我们删除元素 3 和 4 ，然后添加 3 * 2 + 4 到 nums 中，nums 变为 [10, 11, 10] 。
 * 此时，数组中的所有元素都大于等于 10 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 10 需要的最少操作次数为 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,4,9], k = 20
 * 输出：4
 * 解释：第一次操作后，nums 变为 [2, 4, 9, 3] 。
 * 第二次操作后，nums 变为 [7, 4, 9] 。
 * 第三次操作后，nums 变为 [15, 9] 。
 * 第四次操作后，nums 变为 [33] 。
 * 此时，数组中的所有元素都大于等于 20 ，所以我们停止操作。
 * 使数组中所有元素都大于等于 20 需要的最少操作次数为 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 109
 * 1 <= k <= 109
 * 输入保证答案一定存在，也就是说一定存在一个操作序列使数组中所有元素都大于等于 k 。
 */
public class Code10 {

    public int minOperations(int[] nums, int k) {
        //初始化优先队列
        PriorityQueue<Long> queue = Arrays.stream(nums)
                .mapToLong(Long::new)
                .boxed()
                .collect(Collectors.toCollection(PriorityQueue::new));
        //次数
        int count = 0;
        //循环
        while (queue.peek() < k) {
            //删除旧数字、计算新数字、加入集合
            queue.add(queue.poll() * 2 + queue.poll());
            //+1
            count++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {

    }

}
