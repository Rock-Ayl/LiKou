package normal32;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-06-05
 * 2295. 替换数组中的元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的数组 nums ，它包含 n 个 互不相同 的正整数。请你对这个数组执行 m 个操作，在第 i 个操作中，你需要将数字 operations[i][0] 替换成 operations[i][1] 。
 * <p>
 * 题目保证在第 i 个操作中：
 * <p>
 * operations[i][0] 在 nums 中存在。
 * operations[i][1] 在 nums 中不存在。
 * 请你返回执行完所有操作后的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
 * 输出：[3,2,7,1]
 * 解释：我们对 nums 执行以下操作：
 * - 将数字 1 替换为 3 。nums 变为 [3,2,4,6] 。
 * - 将数字 4 替换为 7 。nums 变为 [3,2,7,6] 。
 * - 将数字 6 替换为 1 。nums 变为 [3,2,7,1] 。
 * 返回最终数组 [3,2,7,1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2], operations = [[1,3],[2,1],[3,2]]
 * 输出：[2,1]
 * 解释：我们对 nums 执行以下操作：
 * - 将数字 1 替换为 3 。nums 变为 [3,2] 。
 * - 将数字 2 替换为 1 。nums 变为 [3,1] 。
 * - 将数字 3 替换为 2 。nums 变为 [2,1] 。
 * 返回最终数组 [2,1] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * m == operations.length
 * 1 <= n, m <= 105
 * nums 中所有数字 互不相同 。
 * operations[i].length == 2
 * 1 <= nums[i], operations[i][0], operations[i][1] <= 106
 * 在执行第 i 个操作时，operations[i][0] 在 nums 中存在。
 * 在执行第 i 个操作时，operations[i][1] 在 nums 中不存在。
 */
public class Code13 {

    public int[] arrayChange(int[] nums, int[][] operations) {
        //缓存
        Map<Integer, Integer> indexMap = new HashMap<>();
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //记录数字对应索引
            indexMap.put(nums[i], i);
        }
        //循环
        for (int[] operation : operations) {
            //修改前
            Integer oldNum = operation[0];
            //修改后
            Integer newNum = operation[1];
            //获取修改前索引
            Integer oldIndex = indexMap.get(oldNum);
            //删除缓存
            indexMap.remove(oldNum);
            //记录新缓存
            indexMap.put(newNum, oldIndex);
            //修改数组
            nums[oldIndex] = newNum;
        }
        //返回结果
        return nums;
    }

    public static void main(String[] args) {
        int[] result = new Code13().arrayChange(new int[]{1, 2, 4, 6}, new int[][]{
                new int[]{1, 3},
                new int[]{4, 7},
                new int[]{6, 1}
        });
        System.out.println();
    }

}
