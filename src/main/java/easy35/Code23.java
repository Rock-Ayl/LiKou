package easy35;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-28
 * 3005. 最大频率元素计数
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 正整数 组成的数组 nums 。
 * <p>
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * <p>
 * 元素的 频率 是指该元素在数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1,4]
 * 输出：4
 * 解释：元素 1 和 2 的频率为 2 ，是数组中的最大频率。
 * 因此具有最大频率的元素在数组中的数量是 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：5
 * 解释：数组中的所有元素的频率都为 1 ，是最大频率。
 * 因此具有最大频率的元素在数组中的数量是 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code23 {

    public int maxFrequencyElements(int[] nums) {
        //统计数量
        List<Long> groupByKey = new ArrayList<>(Arrays.stream(nums).boxed().collect(Collectors.groupingBy(p -> p, Collectors.counting())).values());
        //最大情况
        long max = groupByKey.stream().mapToLong(Long::longValue).max().getAsLong();
        //返回
        return (int) (max * groupByKey.stream().filter(p -> max == p).count());
    }

    public static void main(String[] args) {
        System.out.println(new Code23().maxFrequencyElements(new int[]{1, 2, 2, 3, 1, 4}));
    }

}
