package easy33;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-10-01
 * 8038. 收集元素的最少操作次数
 * 提示
 * 简单
 * 0
 * 相关企业
 * 给你一个正整数数组 nums 和一个整数 k 。
 * <p>
 * 一次操作中，你可以将数组的最后一个元素删除，将该元素添加到一个集合中。
 * <p>
 * 请你返回收集元素 1, 2, ..., k 需要的 最少操作次数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,5,4,2], k = 2
 * 输出：4
 * 解释：4 次操作后，集合中的元素依次添加了 2 ，4 ，5 和 1 。此时集合中包含元素 1 和 2 ，所以答案为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,5,4,2], k = 5
 * 输出：5
 * 解释：5 次操作后，集合中的元素依次添加了 2 ，4 ，5 ，1 和 3 。此时集合中包含元素 1 到 5 ，所以答案为 5 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,5,3,1], k = 3
 * 输出：4
 * 解释：4 次操作后，集合中的元素依次添加了 1 ，3 ，5 和 2 。此时集合中包含元素 1 到 3  ，所以答案为 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= nums.length
 * 1 <= k <= nums.length
 * 输入保证你可以收集到元素 1, 2, ..., k 。
 */
public class Code17 {

    public int minOperations(List<Integer> nums, int k) {
        //缓存
        Set<Integer> cache = new HashSet<>();
        //循环
        for (int i = nums.size() - 1; i >= 0; i--) {
            //当前数字
            int num = nums.get(i);
            //如果不满足
            if (num > k) {
                //本轮过
                continue;
            }
            //记录本次结果
            cache.add(num);
            //如果满足条件了
            if (cache.size() >= k) {
                //计算并返回结果
                return nums.size() - 1;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().minOperations(Arrays.asList(3, 1, 5, 4, 2), 2));
    }

}
