package normal45;

/**
 * @Author ayl
 * @Date 2025-07-14
 * 3523. 非递减数组的最大长度
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。在一次操作中，你可以选择一个子数组，并将其替换为一个等于该子数组 最大值 的单个元素。
 * <p>
 * 返回经过零次或多次操作后，数组仍为 非递减 的情况下，数组 可能的最大长度。
 * <p>
 * 子数组 是数组中一个连续、非空 的元素序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [4,2,5,3,5]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 实现最大长度的一种方法是：
 * <p>
 * 将子数组 nums[1..2] = [2, 5] 替换为 5 → [4, 5, 3, 5]。
 * 将子数组 nums[2..3] = [3, 5] 替换为 5 → [4, 5, 5]。
 * 最终数组 [4, 5, 5] 是非递减的，长度为 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,3]
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 无需任何操作，因为数组 [1,2,3] 已经是非递减的。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 2 * 105
 */
public class Code1 {

    public int maximumPossibleSize(int[] nums) {
        //删除次数
        int count = 0;
        //索引
        int index = 0;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前数字是否可以保留
            if (nums[index] <= nums[i]) {
                //更新最大索引
                index = i;
            } else {
                //否则删除+1
                count++;
            }
        }
        //返回
        return nums.length - count;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().maximumPossibleSize(new int[]{4, 2, 5, 3, 5}));
    }

}
