package easy28;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-02-18
 * 697. 数组的度
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length 在 1 到 50,000 范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
public class Code8 {

    public int findShortestSubArray(int[] nums) {
        //如果太小
        if (nums.length < 2) {
            //过
            return nums.length;
        }
        //缓存
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> startMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        //最大数量
        int maxCount = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //当前数量
            int count = map.getOrDefault(num, 0) + 1;
            //记录数量
            map.put(num, count);
            //刷新最大数量
            maxCount = Math.max(count, maxCount);
            //如果有开始
            if (startMap.containsKey(num)) {
                //覆盖结束位置
                endMap.put(num, i);
            } else {
                //开始位置
                startMap.put(num, i);
            }
        }
        int finalMaxCount = maxCount;
        //获取刷领最多的key
        List<Integer> maxKeyList = map.entrySet().stream()
                .filter(p -> p.getValue() == finalMaxCount)
                .map(p -> p.getKey())
                .collect(Collectors.toList());
        //最小结果
        int minResult = nums.length;
        //循环
        for (Integer key : maxKeyList) {
            //如果没有结束
            if (endMap.containsKey(key) == false) {
                //记录结果
                minResult = Math.min(1, minResult);
                //本轮过
                continue;
            }
            //本次结果
            int result = endMap.get(key) - startMap.get(key) + 1;
            //记录结果
            minResult = Math.min(result, minResult);
        }
        //返回结果
        return minResult;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().findShortestSubArray(new int[]{1, 2, 2, 3, 1}));
    }

}
