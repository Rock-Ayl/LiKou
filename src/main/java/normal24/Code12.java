package normal24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-09-28
 * 2150. 找出数组中的所有孤独数字
 * 提示
 * 中等
 * 13
 * 相关企业
 * 给你一个整数数组 nums 。如果数字 x 在数组中仅出现 一次 ，且没有 相邻 数字（即，x + 1 和 x - 1）出现在数组中，则认为数字 x 是 孤独数字 。
 * <p>
 * 返回 nums 中的 所有 孤独数字。你可以按 任何顺序 返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,6,5,8]
 * 输出：[10,8]
 * 解释：
 * - 10 是一个孤独数字，因为它只出现一次，并且 9 和 11 没有在 nums 中出现。
 * - 8 是一个孤独数字，因为它只出现一次，并且 7 和 9 没有在 nums 中出现。
 * - 5 不是一个孤独数字，因为 6 出现在 nums 中，反之亦然。
 * 因此，nums 中的孤独数字是 [10, 8] 。
 * 注意，也可以返回 [8, 10] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,5,3]
 * 输出：[1,5]
 * 解释：
 * - 1 是一个孤独数字，因为它只出现一次，并且 0 和 2 没有在 nums 中出现。
 * - 5 是一个孤独数字，因为它只出现一次，并且 4 和 6 没有在 nums 中出现。
 * - 3 不是一个孤独数字，因为它出现两次。
 * 因此，nums 中的孤独数字是 [1, 5] 。
 * 注意，也可以返回 [5, 1] 。
 */
public class Code12 {

    public List<Integer> findLonely(int[] nums) {
        //如果太少
        if (nums.length == 1) {
            //返回
            return Arrays.stream(nums).boxed().collect(Collectors.toList());
        }
        //排序
        Arrays.sort(nums);
        //初始化
        List<Integer> result = new ArrayList<>();
        //如果是一个是
        if (nums[0] < nums[1] - 1) {
            //记录
            result.add(nums[0]);
        }
        //如果最后一个是
        if (nums[nums.length - 1] - 1 > nums[nums.length - 2]) {
            //记录
            result.add(nums[nums.length - 1]);
        }
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //如果相同
            if (nums[i] == nums[i - 1] || nums[i] == nums[i + 1]) {
                //本轮过
                continue;
            }
            //如果数字相邻
            if (nums[i] == nums[i - 1] + 1 || nums[i] == nums[i + 1] - 1) {
                //本轮过
                continue;
            }
            //记录
            result.add(nums[i]);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<Integer> lonely = new Code12().findLonely(new int[]{1, 3, 5, 3});
        System.out.println();

    }

}
