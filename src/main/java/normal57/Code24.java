package normal57;

import java.util.HashMap;
import java.util.Map;

/**
 * 2170. 使数组变成交替数组的最少操作数
 * 算术评级: 4
 * 第 280 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1663
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，该数组由 n 个正整数组成。
 * <p>
 * 如果满足下述条件，则数组 nums 是一个 交替数组 ：
 * <p>
 * nums[i - 2] == nums[i] ，其中 2 <= i <= n - 1 。
 * nums[i - 1] != nums[i] ，其中 1 <= i <= n - 1 。
 * 在一步 操作 中，你可以选择下标 i 并将 nums[i] 更改 为 任一 正整数。
 * <p>
 * 返回使数组变成交替数组的 最少操作数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,3,2,4,3]
 * 输出：3
 * 解释：
 * 使数组变成交替数组的方法之一是将该数组转换为 [3,1,3,1,3,1] 。
 * 在这种情况下，操作数为 3 。
 * 可以证明，操作数少于 3 的情况下，无法使数组变成交替数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,2,2]
 * 输出：2
 * 解释：
 * 使数组变成交替数组的方法之一是将该数组转换为 [1,2,1,2,1].
 * 在这种情况下，操作数为 2 。
 * 注意，数组不能转换成 [2,2,2,2,2] 。因为在这种情况下，nums[0] == nums[1]，不满足交替数组的条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 */
public class Code24 {

    public int minimumOperations(int[] nums) {
        //特殊情况
        if (nums.length == 1) {
            //过
            return 0;
        }
        //单双计数器数组
        Map<Integer, Integer> singleMap = new HashMap<>();
        Map<Integer, Integer> doubleMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //偶数位
            if (i % 2 == 0) {
                //+1
                doubleMap.put(nums[i], doubleMap.getOrDefault(nums[i], 0) + 1);
            } else {
                //+1
                singleMap.put(nums[i], singleMap.getOrDefault(nums[i], 0) + 1);
            }
        }
        //发现map中,第一大和第二大的组合
        Map.Entry<Integer, Integer>[] singleMaxAndSecondArr = findMaxAndSecond(singleMap);
        Map.Entry<Integer, Integer>[] doubleMaxAndSecondArr = findMaxAndSecond(doubleMap);
        //如果双方最大的key均不同
        if (singleMaxAndSecondArr[0].getKey().equals(doubleMaxAndSecondArr[0].getKey()) == false) {
            //获取
            Integer a = singleMaxAndSecondArr[0].getValue();
            Integer b = doubleMaxAndSecondArr[0].getValue();
            //返回
            return nums.length - a - b;
        } else {
            //两种可能
            int a = singleMaxAndSecondArr[0].getValue() + (doubleMaxAndSecondArr[1] != null && singleMaxAndSecondArr[0].getKey().equals(doubleMaxAndSecondArr[1].getKey()) == false ? doubleMaxAndSecondArr[1].getValue() : 0);
            int b = doubleMaxAndSecondArr[0].getValue() + (singleMaxAndSecondArr[1] != null && doubleMaxAndSecondArr[0].getKey().equals(singleMaxAndSecondArr[1].getKey()) == false ? singleMaxAndSecondArr[1].getValue() : 0);
            //返回最好情况
            return nums.length - Math.max(a, b);
        }
    }

    //发现map中,第一大和第二大的组合
    private Map.Entry<Integer, Integer>[] findMaxAndSecond(Map<Integer, Integer> map) {
        //初始化
        Map.Entry<Integer, Integer>[] result = new Map.Entry[2];
        //循环
        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            //判空
            if (result[0] == null) {
                //记录
                result[0] = pair;
                //本轮过
                continue;
            }
            //判断是否是第一大
            if (pair.getValue() > result[0].getValue()) {
                //更新第一大和第二大
                result[1] = result[0];
                result[0] = pair;
            } else if (result[1] == null || pair.getValue() > result[1].getValue()) {
                //更新第二大
                result[1] = pair;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        //System.out.println(new Code24().minimumOperations(new int[]{3, 1, 3, 2, 4, 3}));
        //System.out.println(new Code24().minimumOperations(new int[]{1, 2, 2, 2, 2}));
        //System.out.println(new Code24().minimumOperations(new int[]{2, 2}));
        System.out.println(new Code24().minimumOperations(new int[]{1, 2, 2, 2, 2}));
    }

}
