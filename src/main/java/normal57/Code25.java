package normal57;

import java.util.HashSet;
import java.util.Set;

/**
 * 2261. 含最多 K 个可整除元素的子数组
 * 算术评级: 4
 * 第 291 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1724
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和两个整数 k 和 p ，找出并返回满足要求的不同的子数组数，要求子数组中最多 k 个可被 p 整除的元素。
 * <p>
 * 如果满足下述条件之一，则认为数组 nums1 和 nums2 是 不同 数组：
 * <p>
 * 两数组长度 不同 ，或者
 * 存在 至少 一个下标 i 满足 nums1[i] != nums2[i] 。
 * 子数组 定义为：数组中的连续元素组成的一个 非空 序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,3,2,2], k = 2, p = 2
 * 输出：11
 * 解释：
 * 位于下标 0、3 和 4 的元素都可以被 p = 2 整除。
 * 共计 11 个不同子数组都满足最多含 k = 2 个可以被 2 整除的元素：
 * [2]、[2,3]、[2,3,3]、[2,3,3,2]、[3]、[3,3]、[3,3,2]、[3,3,2,2]、[3,2]、[3,2,2] 和 [2,2] 。
 * 注意，尽管子数组 [2] 和 [3] 在 nums 中出现不止一次，但统计时只计数一次。
 * 子数组 [2,3,3,2,2] 不满足条件，因为其中有 3 个元素可以被 2 整除。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4], k = 4, p = 1
 * 输出：10
 * 解释：
 * nums 中的所有元素都可以被 p = 1 整除。
 * 此外，nums 中的每个子数组都满足最多 4 个元素可以被 1 整除。
 * 因为所有子数组互不相同，因此满足所有限制条件的子数组总数为 10 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i], p <= 200
 * 1 <= k <= nums.length
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以设计并实现时间复杂度为 O(n2) 的算法解决此问题吗？
 */
public class Code25 {

    public int countDistinct(int[] nums, int k, int p) {
        //结果
        Set<String> set = new HashSet<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //字符串
            StringBuilder str = new StringBuilder();
            //可整除元素数量
            int count = 0;
            //循环2
            for (int j = i; j < nums.length; j++) {
                //如果可以被整除 and +1,如果超过
                if (nums[j] % p == 0 && ++count > k) {
                    //跳出
                    break;
                }
                //记录
                str.append(nums[j] + ",");
                //记录到结果
                set.add(str.toString());
            }
        }
        //返回
        return set.size();
    }

    public static void main(String[] args) {
        new Code25().countDistinct(new int[]{2, 3, 3, 2, 2}, 2, 2);
    }

}
