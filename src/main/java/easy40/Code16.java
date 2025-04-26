package easy40;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-04-26
 * 3471. 找出最大的几近缺失整数
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k 。
 * <p>
 * 如果整数 x 恰好仅出现在 nums 中的一个大小为 k 的子数组中，则认为 x 是 nums 中的几近缺失（almost missing）整数。
 * <p>
 * 返回 nums 中 最大的几近缺失 整数，如果不存在这样的整数，返回 -1 。
 * <p>
 * 子数组 是数组中的一个连续元素序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,9,2,1,7], k = 3
 * <p>
 * 输出：7
 * <p>
 * 解释：
 * <p>
 * 1 出现在两个大小为 3 的子数组中：[9, 2, 1]、[2, 1, 7]
 * 2 出现在三个大小为 3 的子数组中：[3, 9, 2]、[9, 2, 1]、[2, 1, 7]
 * 3 出现在一个大小为 3 的子数组中：[3, 9, 2]
 * 7 出现在一个大小为 3 的子数组中：[2, 1, 7]
 * 9 出现在两个大小为 3 的子数组中：[3, 9, 2]、[9, 2, 1]
 * 返回 7 ，因为它满足题意的所有整数中最大的那个。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [3,9,7,2,1,7], k = 4
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 1 出现在两个大小为 3 的子数组中：[9, 7, 2, 1]、[7, 2, 1, 7]
 * 2 出现在三个大小为 3 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]、[7, 2, 1, 7]
 * 3 出现在一个大小为 3 的子数组中：[3, 9, 7, 2]
 * 7 出现在三个大小为 3 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]、[7, 2, 1, 7]
 * 9 出现在两个大小为 3 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]
 * 返回 3 ，因为它满足题意的所有整数中最大的那个。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [0,0], k = 1
 * <p>
 * 输出：-1
 * <p>
 * 解释：
 * <p>
 * 不存在满足题意的整数。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 1 <= k <= nums.length
 */
public class Code16 {

    public int largestInteger(int[] nums, int k) {
        //缓存
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //循环
        for (int i = 0; i <= nums.length - k; i++) {
            //循环2
            for (int j = i; j < i + k; j++) {
                //初始化
                map.putIfAbsent(nums[j], new HashSet<>());
                //记录
                map.get(nums[j]).add(i);
            }
        }
        //返回
        return map.entrySet()
                .stream()
                //只需要出现一次的
                .filter(p -> p.getValue().size() == 1)
                //获取数字
                .map(Map.Entry::getKey)
                //转为int
                .mapToInt(Integer::intValue)
                //最大的
                .max()
                //默认返回-1
                .orElse(-1);
    }

    public static void main(String[] args) {
        System.out.println(new Code16().largestInteger(new int[]{0, 0}, 1));
    }

}
