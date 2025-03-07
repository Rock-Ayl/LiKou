package easy32;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-08-20
 * 2815. 数组中的最大数对和
 * 提示
 * 简单
 * 3
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums 。请你从 nums 中找出和 最大 的一对数，且这两个数数位上最大的数字相等。
 * <p>
 * 返回最大和，如果不存在满足题意的数字对，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [51,71,17,24,42]
 * 输出：88
 * 解释：
 * i = 1 和 j = 2 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 71 + 17 = 88 。
 * i = 3 和 j = 4 ，nums[i] 和 nums[j] 数位上最大的数字相等，且这一对的总和 24 + 42 = 66 。
 * 可以证明不存在其他数对满足数位上最大的数字相等，所以答案是 88 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：-1
 * 解释：不存在数对满足数位上最大的数字相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 104
 */
public class Code24 {

    //缓存
    private Map<Integer, List<Integer>> map = new HashMap<>();

    //插入至对数缓存
    private void insertMap(int num) {
        //记录数字
        int key = num;
        //初始化
        int max = 0;
        //如果还有
        while (num > 0) {
            //刷新最大数字
            max = Math.max(max, num % 10);
            //下一位
            num = num / 10;
        }
        //当前对数的列表
        List<Integer> list = map.getOrDefault(max, new ArrayList<>());
        //记录
        list.add(key);
        //覆盖
        map.put(max, list);
    }

    public int maxSum(int[] nums) {
        //逊汗
        for (int num : nums) {
            //插入缓存
            insertMap(num);
        }
        //最大结果
        int maxResult = 0;
        //循环
        for (Integer max : map.keySet()) {
            //获取对应列表
            List<Integer> list = map.get(max);
            //如果太小
            if (list.size() < 2) {
                //本轮过
                continue;
            }
            //排序
            Collections.sort(list);
            //计算最大
            maxResult = Math.max(maxResult, list.get(list.size() - 1) + list.get(list.size() - 2));
        }
        //返回结果
        return maxResult > 0 ? maxResult : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code24().maxSum(new int[]{31, 25, 72, 79, 74}));
    }

}
