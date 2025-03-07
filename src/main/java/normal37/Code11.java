package normal37;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-11-15
 * 2856. 删除数对后的最小数组长度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的 非递减 整数数组 nums 。
 * <p>
 * 你可以执行以下操作任意次：
 * <p>
 * 选择 两个 下标 i 和 j ，满足 nums[i] < nums[j] 。
 * 将 nums 中下标在 i 和 j 处的元素删除。剩余元素按照原来的顺序组成新的数组，下标也重新从 0 开始编号。
 * 请你返回一个整数，表示执行以上操作任意次后（可以执行 0 次），nums 数组的 最小 数组长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,2,3,3]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1000000000,1000000000]
 * <p>
 * 输出：2
 * <p>
 * 解释：
 * <p>
 * 由于两个数字相等，不能删除它们。
 * <p>
 * 示例 4：
 * <p>
 * 输入：nums = [2,3,4,4,4]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 * nums 是 非递减 数组。
 */
public class Code11 {

    public int minLengthAfterRemovals(List<Integer> nums) {
        //结果集
        int count = 0;
        //双指针
        int left = nums.size() / 2 - 1;
        int right = nums.size() - 1;
        //循环
        while (left >= 0) {
            //如果满足
            if (nums.get(left--) < nums.get(right)) {
                //清算结果
                right--;
                //记录
                count++;
            }
        }
        //返回
        return nums.size() - (count * 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code11().minLengthAfterRemovals(Arrays.asList(1, 1, 2, 2, 3, 3)));
    }

}
