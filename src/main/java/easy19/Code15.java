package easy19;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-05-31
 * 2176. 统计数组中相等且可以被整除的数对
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums 和一个整数 k ，请你返回满足 0 <= i < j < n ，nums[i] == nums[j] 且 (i * j) 能被 k 整除的数对 (i, j) 的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,1,2,2,2,1,3], k = 2
 * 输出：4
 * 解释：
 * 总共有 4 对数符合所有要求：
 * - nums[0] == nums[6] 且 0 * 6 == 0 ，能被 2 整除。
 * - nums[2] == nums[3] 且 2 * 3 == 6 ，能被 2 整除。
 * - nums[2] == nums[4] 且 2 * 4 == 8 ，能被 2 整除。
 * - nums[3] == nums[4] 且 3 * 4 == 12 ，能被 2 整除。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4], k = 1
 * 输出：0
 * 解释：由于数组中没有重复数值，所以没有数对 (i,j) 符合所有要求。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i], k <= 100
 */
public class Code15 {

    public int countPairs(int[] nums, int k) {
        //缓存
        Map<Integer, List<Integer>> map = new HashMap<>();
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //获取
            List<Integer> list = map.getOrDefault(num, new ArrayList<>());
            //组装
            list.add(i);
            map.put(num, list);
        }
        //次数
        int count = 0;
        //循环2
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            //当前列表
            List<Integer> list = entry.getValue();
            //如果不够
            if (list.size() < 2) {
                //过
                continue;
            }
            //循环3
            for (int i = 0; i < list.size(); i++) {
                //当前
                int num = list.get(i);
                //循环4
                for (int j = i + 1; j < list.size(); j++) {
                    //当前
                    int next = list.get(j);
                    //如果是偶数
                    if (num * next % k == 0) {
                        //+1
                        count++;
                    }
                }
            }
        }
        //返回结果
        return count;
    }


}
