package normal32;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-06-27
 * 3159. 查询数组中元素的出现位置
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，一个整数数组 queries 和一个整数 x 。
 * <p>
 * 对于每个查询 queries[i] ，你需要找到 nums 中第 queries[i] 个 x 的位置，并返回它的下标。如果数组中 x 的出现次数少于 queries[i] ，该查询的答案为 -1 。
 * <p>
 * 请你返回一个整数数组 answer ，包含所有查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,1,7], queries = [1,3,2,4], x = 1
 * <p>
 * 输出：[0,-1,2,-1]
 * <p>
 * 解释：
 * <p>
 * 第 1 个查询，第一个 1 出现在下标 0 处。
 * 第 2 个查询，nums 中只有两个 1 ，所以答案为 -1 。
 * 第 3 个查询，第二个 1 出现在下标 2 处。
 * 第 4 个查询，nums 中只有两个 1 ，所以答案为 -1 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], queries = [10], x = 5
 * <p>
 * 输出：[-1]
 * <p>
 * 解释：
 * <p>
 * 第 1 个查询，nums 中没有 5 ，所以答案为 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length, queries.length <= 105
 * 1 <= queries[i] <= 105
 * 1 <= nums[i], x <= 104
 */
public class Code21 {

    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        //位置缓存
        List<Integer> indexList = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //如果不是目标数字
            if (num != x) {
                //本轮过
                continue;
            }
            //记录
            indexList.add(i);
        }
        //初始化结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //判断是否存在结果
            if (queries[i] > indexList.size()) {
                //不存在
                result[i] = -1;
            } else {
                //获取
                result[i] = indexList.get(queries[i] - 1);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code21().occurrencesOfElement(new int[]{1, 3, 1, 7}, new int[]{1, 3, 2, 4}, 1);
        System.out.println();
    }
}
