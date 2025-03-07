package easy19;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-06-05
 * 2099. 找到和最大的长度为 K 的子序列
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * <p>
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * <p>
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,1,3,3], k = 2
 * 输出：[3,3]
 * 解释：
 * 子序列有最大和：3 + 3 = 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [-1,-2,3,4], k = 3
 * 输出：[-1,3,4]
 * 解释：
 * 子序列有最大和：-1 + 3 + 4 = 6 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,4,3,3], k = 2
 * 输出：[3,4]
 * 解释：
 * 子序列有最大和：3 + 4 = 7 。
 * 另一个可行的子序列为 [4, 3] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -105 <= nums[i] <= 105
 * 1 <= k <= nums.length
 */
public class Code20 {

    public int[] maxSubsequence(int[] nums, int k) {
        //排序
        int[] sortArr = Arrays.stream(nums).sorted().toArray();
        //要删除的元素数量
        int minusCount = nums.length - k;
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int i = 0; i < minusCount; i++) {
            //要删除的
            int willMinus = sortArr[i];
            //记录数量
            map.put(willMinus, map.getOrDefault(willMinus, 0) + 1);
        }
        //初始化结果
        int[] result = new int[nums.length - minusCount];
        //指针
        int p = 0;
        //循环2
        for (int num : nums) {
            //如果要删除
            if (map.containsKey(num)) {
                //获取
                int count = map.get(num);
                //判断是否有存活,并递减
                if (count > 1) {
                    //记录
                    map.put(num, --count);
                } else if (count == 1) {
                    //删除
                    map.remove(num);
                }
                //本次过
                continue;
            }
            //默认组装
            result[p++] = num;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code20().maxSubsequence(new int[]{-1, -2, 3, 4}, 3);
    }

}
