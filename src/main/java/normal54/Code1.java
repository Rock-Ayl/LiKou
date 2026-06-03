package normal54;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 2453. 摧毁一系列目标
 * 算术评级: 5
 * 第 90 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1762
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，它包含若干正整数，表示数轴上你需要摧毁的目标所在的位置。同时给你一个整数 space 。
 * <p>
 * 你有一台机器可以摧毁目标。给机器 输入 nums[i] ，这台机器会摧毁所有位置在 nums[i] + c * space 的目标，其中 c 是任意非负整数。你想摧毁 nums 中 尽可能多 的目标。
 * <p>
 * 请你返回在摧毁数目最多的前提下，nums[i] 的 最小值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,7,8,1,1,5], space = 2
 * 输出：1
 * 解释：如果我们输入 nums[3] ，我们可以摧毁位于 1,3,5,7,9,... 这些位置的目标。
 * 这种情况下， 我们总共可以摧毁 5 个目标（除了 nums[2]）。
 * 没有办法摧毁多于 5 个目标，所以我们返回 nums[3] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,5,2,4,6], space = 2
 * 输出：1
 * 解释：输入 nums[0] 或者 nums[3] 都会摧毁 3 个目标。
 * 没有办法摧毁多于 3 个目标。
 * 由于 nums[0] 是最小的可以摧毁 3 个目标的整数，所以我们返回 1 。
 * 示例 3：
 * <p>
 * 输入：nums = [6,2,5], space = 100
 * 输出：2
 * 解释：无论我们输入哪个数字，都只能摧毁 1 个目标。输入的最小整数是 nums[1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * 1 <= space <= 109
 */
public class Code1 {

    public int destroyTargets(int[] nums, int space) {

        /**
         * 统计分组
         */

        //每个分组最小数字
        Map<Integer, Integer> groupMinMap = new HashMap<>();
        //计算分组
        int[] groupArr = new int[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前分组
            int gourp = nums[i] % space;
            //记录
            groupArr[i] = gourp;
            //获取当前分组最小数字
            int groupMinNum = groupMinMap.getOrDefault(gourp, nums[i]);
            //记录当前分组最小数字
            groupMinMap.put(gourp, Math.min(nums[i], groupMinNum));
        }

        /**
         * 最大分组数量
         */

        //数量分组
        Map<Integer, Long> countGroupMap = Arrays.stream(groupArr)
                //装箱
                .boxed()
                //分组统计数量
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()));
        //寻找最大数量
        Long maxCount = countGroupMap.values()
                .stream()
                .max(Long::compareTo)
                .orElse(0L);
        //获取最大数量对应的分组集合
        Set<Integer> maxCountGroupKeySet = countGroupMap
                .entrySet()
                .stream()
                .filter(p -> p.getValue().equals(maxCount))
                .map(Map.Entry::getKey)
                .collect(Collectors.toSet());

        /**
         * 寻找结果
         */

        //结果
        int minNum = Integer.MAX_VALUE;
        //循环所有目标分组key
        for (Integer maxCountGroupKey : maxCountGroupKeySet) {
            //获取对应最小数字
            Integer num = groupMinMap.get(maxCountGroupKey);
            //刷新最小
            minNum = Math.min(num, minNum);
        }
        //返回
        return minNum;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().destroyTargets(new int[]{3, 7, 8, 1, 1, 5}, 2));
        System.out.println(new Code1().destroyTargets(new int[]{1, 3, 5, 2, 4, 6}, 2));
        System.out.println(new Code1().destroyTargets(new int[]{6, 2, 5}, 100));
    }

}
