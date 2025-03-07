package normal20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-05-12
 * 2610. 转换二维数组
 * 给你一个整数数组 nums 。请你创建一个满足以下条件的二维数组：
 * <p>
 * 二维数组应该 只 包含数组 nums 中的元素。
 * 二维数组中的每一行都包含 不同 的整数。
 * 二维数组的行数应尽可能 少 。
 * 返回结果数组。如果存在多种答案，则返回其中任何一种。
 * <p>
 * 请注意，二维数组的每一行上可以存在不同数量的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,4,1,2,3,1]
 * 输出：[[1,3,4,2],[1,3],[1]]
 * 解释：根据题目要求可以创建包含以下几行元素的二维数组：
 * - 1,3,4,2
 * - 1,3
 * - 1
 * nums 中的所有元素都有用到，并且每一行都由不同的整数组成，所以这是一个符合题目要求的答案。
 * 可以证明无法创建少于三行且符合题目要求的二维数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[[4,3,2,1]]
 * 解释：nums 中的所有元素都不同，所以我们可以将其全部保存在二维数组中的第一行。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= nums.length
 */
public class Code10 {

    public List<List<Integer>> findMatrix(int[] nums) {
        //分组
        Map<Integer, Integer> map = new HashMap<>();
        //最大数量
        int maxCount = 0;
        //循环
        for (int num : nums) {
            //当前数量
            int count = map.getOrDefault(num, 0) + 1;
            //记录
            map.put(num, count);
            //记录最大数量
            maxCount = Math.max(maxCount, count);
        }
        //初始化结果
        List<List<Integer>> result = new ArrayList<>(maxCount);
        //循环
        while (result.size() < maxCount) {
            //组装
            result.add(new ArrayList<>());
        }
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //当前
            Integer num = entry.getKey();
            int count = entry.getValue();
            //指针
            int p = 0;
            //循环
            while (p < count) {
                //根据指针组装记录
                result.get(p++).add(num);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        new Code10().findMatrix(new int[]{1, 3, 4, 1, 2, 3, 1});
    }

}
