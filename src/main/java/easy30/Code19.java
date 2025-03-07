package easy30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-05-09
 * 6416. 找出不同元素数目差数组
 * 给你一个下标从 0 开始的数组 nums ，数组长度为 n 。
 * <p>
 * nums 的 不同元素数目差 数组可以用一个长度为 n 的数组 diff 表示，其中 diff[i] 等于前缀 nums[0, ..., i] 中不同元素的数目 减去 后缀 nums[i + 1, ..., n - 1] 中不同元素的数目。
 * <p>
 * 返回 nums 的 不同元素数目差 数组。
 * <p>
 * 注意 nums[i, ..., j] 表示 nums 的一个从下标 i 开始到下标 j 结束的子数组（包含下标 i 和 j 对应元素）。特别需要说明的是，如果 i > j ，则 nums[i, ..., j] 表示一个空子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：[-3,-1,1,3,5]
 * 解释：
 * 对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 4 个不同的元素。因此，diff[0] = 1 - 4 = -3 。
 * 对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
 * 对于 i = 2，前缀中有 3 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 3 - 2 = 1 。
 * 对于 i = 3，前缀中有 4 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 4 - 1 = 3 。
 * 对于 i = 4，前缀中有 5 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 5 - 0 = 5 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,3,4,2]
 * 输出：[-2,-1,0,2,3]
 * 解释：
 * 对于 i = 0，前缀中有 1 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[0] = 1 - 3 = -2 。
 * 对于 i = 1，前缀中有 2 个不同的元素，而在后缀中有 3 个不同的元素。因此，diff[1] = 2 - 3 = -1 。
 * 对于 i = 2，前缀中有 2 个不同的元素，而在后缀中有 2 个不同的元素。因此，diff[2] = 2 - 2 = 0 。
 * 对于 i = 3，前缀中有 3 个不同的元素，而在后缀中有 1 个不同的元素。因此，diff[3] = 3 - 1 = 2 。
 * 对于 i = 4，前缀中有 3 个不同的元素，而在后缀中有 0 个不同的元素。因此，diff[4] = 3 - 0 = 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Code19 {

    public int[] distinctDifferenceArray(int[] nums) {
        //左右map
        Map<Integer, Integer> leftMap = new HashMap<>();
        Map<Integer, Integer> rightMap = new HashMap<>();
        //结果
        int[] result = new int[nums.length];
        //循环
        for (int num : nums) {
            //+1
            rightMap.put(num, rightMap.getOrDefault(num, 0) + 1);
        }
        //循环2
        for (int i = 0; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //+1
            leftMap.put(num, leftMap.getOrDefault(num, 0) + 1);
            //如果是1
            if (rightMap.get(num) == 1) {
                //删除
                rightMap.remove(num);
            } else {
                //-1
                rightMap.put(num, rightMap.get(num) - 1);
            }
            //计算
            result[i] = leftMap.size() - rightMap.size();
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] arr = new Code19().distinctDifferenceArray(new int[]{1, 2, 3, 4, 5});
        System.out.println();
    }

}
