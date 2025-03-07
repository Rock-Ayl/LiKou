package normal24;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-10-03
 * 2870. 使数组为空的最少操作次数
 * 中等
 * 0
 * 相关企业
 * 给你一个下标从 0 开始的正整数数组 nums 。
 * <p>
 * 你可以对数组执行以下两种操作 任意次 ：
 * <p>
 * 从数组中选择 两个 值 相等 的元素，并将它们从数组中 删除 。
 * 从数组中选择 三个 值 相等 的元素，并将它们从数组中 删除 。
 * 请你返回使数组为空的 最少 操作次数，如果无法达成，请返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,3,2,2,4,2,3,4]
 * 输出：4
 * 解释：我们可以执行以下操作使数组为空：
 * - 对下标为 0 和 3 的元素执行第一种操作，得到 nums = [3,3,2,4,2,3,4] 。
 * - 对下标为 2 和 4 的元素执行第一种操作，得到 nums = [3,3,4,3,4] 。
 * - 对下标为 0 ，1 和 3 的元素执行第二种操作，得到 nums = [4,4] 。
 * - 对下标为 0 和 1 的元素执行第一种操作，得到 nums = [] 。
 * 至少需要 4 步操作使数组为空。
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,2,2,3,3]
 * 输出：-1
 * 解释：无法使数组为空。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code14 {

    public int minOperations(int[] nums) {
        //缓存
        Map<Integer, Integer> map = new HashMap<>();
        //循环
        for (int num : nums) {
            //记录
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //结果
        int result = 0;
        //循环
        for (Integer count : map.values()) {
            //第一种情况
            if (count.equals(1)) {
                //结束
                return -1;
            }
            //标准情况
            if (count % 3 == 0) {
                //本次直接全部3
                result += count / 3;
                //本轮过
                continue;
            }
            //第二种情况
            if ((count - 2) % 3 == 0) {
                //一次2,剩下的3
                result += (count + 2) / 3;
                //本轮过
                continue;
            }
            //第三种情况
            if ((count - 1) % 3 == 0) {
                //2次2,剩下的3
                result += (count - 4) / 3 + 2;
                //本轮过
                continue;
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().minOperations(new int[]{2, 3, 3, 2, 2, 4, 2, 3, 4}));
        ;
    }

}
