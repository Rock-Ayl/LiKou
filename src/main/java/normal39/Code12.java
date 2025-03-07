package normal39;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-01-22
 * 2799. 统计完全子数组的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果数组中的某个子数组满足下述条件，则称之为 完全子数组 ：
 * <p>
 * 子数组中 不同 元素的数目等于整个数组不同元素的数目。
 * 返回数组中 完全子数组 的数目。
 * <p>
 * 子数组 是数组中的一个连续非空序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,2,2]
 * 输出：4
 * 解释：完全子数组有：[1,3,1,2]、[1,3,1,2,2]、[3,1,2] 和 [3,1,2,2] 。
 * 示例 2：
 * <p>
 * 输入：nums = [5,5,5,5]
 * 输出：10
 * 解释：数组仅由整数 5 组成，所以任意子数组都满足完全子数组的条件。子数组的总数为 10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 2000
 */
public class Code12 {

    public int countCompleteSubarrays(int[] nums) {

        /**
         * 计算总不同元素数
         */

        //缓存
        Set<Integer> set = new HashSet<>();
        //循环
        for (int num : nums) {
            //记录
            set.add(num);
        }
        //总数
        int allCount = set.size();

        /**
         * 初始化一个数字的结果
         */

        //结果
        Map<Integer, Integer> map = new HashMap<>();
        //初始化指针
        int start = 0;
        int end = -1;
        //循环
        while (map.size() < allCount) {
            //获取key
            int endKey = nums[++end];
            //+1
            map.put(endKey, map.getOrDefault(endKey, 0) + 1);
        }
        //初始化结果
        int result = nums.length - end;

        /**
         * 计算后续
         */

        //跳出标记
        out:
        //循环
        while (start < nums.length) {
            //获取Key
            int startKey = nums[start++];
            //-1
            subOne(map, startKey);
            //如果不满足
            while (map.size() < allCount) {
                //如果不够了
                if (++end == nums.length) {
                    //跳出所有
                    break out;
                }
                //获取key
                int endKey = nums[end];
                //+1
                map.put(endKey, map.getOrDefault(endKey, 0) + 1);
            }
            //记录本次结果
            result += nums.length - end;
        }

        //返回结果
        return result;
    }

    //-1
    private void subOne(Map<Integer, Integer> map, int key) {
        //计算结果
        int count = map.get(key) - 1;
        //如果没了
        if (count == 0) {
            //删除
            map.remove(key);
        }
        //如果有，则覆盖
        else {
            //覆盖
            map.put(key, count);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code12().countCompleteSubarrays(new int[]{1, 3, 1, 2, 2}));
    }

}
