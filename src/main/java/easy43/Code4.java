package easy43;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 3912. 数组中的有效元素
 * 算术评级: 3
 * 第 499 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1273
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 如果元素 nums[i] 满足以下 至少一个 条件，则认为它是 有效 元素：
 * <p>
 * 它 严格大于 其左侧的所有元素。
 * 它 严格大于 其右侧的所有元素。
 * 第一个元素和最后一个元素始终有效。
 * <p>
 * 返回所有有效元素组成的数组，顺序与它们在 nums 中出现的顺序相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,4,2,3,2]
 * <p>
 * 输出： [1,2,4,3,2]
 * <p>
 * 解释：
 * <p>
 * nums[0] 和 nums[5] 始终有效。
 * nums[1] 和 nums[2] 都严格大于其左侧的所有元素。
 * nums[4] 严格大于其右侧的所有元素。
 * 因此，答案为 [1, 2, 4, 3, 2]。
 * 示例 2：
 * <p>
 * 输入： nums = [5,5,5,5]
 * <p>
 * 输出： [5,5]
 * <p>
 * 解释：
 * <p>
 * 第一个元素和最后一个元素始终有效。
 * 其他元素既不严格大于其左侧的所有元素，也不严格大于其右侧的所有元素。
 * 因此，答案为 [5, 5]。
 * 示例 3：
 * <p>
 * 输入： nums = [1]
 * <p>
 * 输出： [1]
 * <p>
 * 解释：
 * <p>
 * 由于数组中只有一个元素，它始终有效。因此，答案为 [1]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code4 {

    public List<Integer> findValidElements(int[] nums) {

        //如果只有一个
        if (nums.length == 1) {
            //返回
            return Collections.singletonList(nums[0]);
        }

        /**
         * 构建右侧最大值数组
         */

        //右侧最大值数组
        int[] rightArr = new int[nums.length];
        //初始化第一个
        rightArr[rightArr.length - 1] = nums[rightArr.length - 1];
        //循环
        for (int i = rightArr.length - 2; i >= 0; i--) {
            //刷新最大
            rightArr[i] = Math.max(rightArr[i + 1], nums[i]);
        }

        /**
         * 遍历数组，判断是否有效
         */

        //初始化最大
        int max = nums[0];
        //初始化结果
        List<Integer> list = new ArrayList<>();
        //第一个必然是
        list.add(nums[0]);
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //判断是否有效
            if (nums[i] > max || nums[i] > rightArr[i + 1]) {
                //是
                list.add(nums[i]);
            }
            //刷新最大
            max = Math.max(max, nums[i]);
        }
        //最后一个必然是
        list.add(nums[nums.length - 1]);
        //返回
        return list;
    }

    public static void main(String[] args) {
        new Code4().findValidElements(new int[]{1, 2, 4, 2, 3, 2});
    }

}
