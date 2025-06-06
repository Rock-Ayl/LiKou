package normal43;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-06-06
 * 3040. 相同分数的最大操作数目 II
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums ，如果 nums 至少 包含 2 个元素，你可以执行以下操作中的 任意 一个：
 * <p>
 * 选择 nums 中最前面两个元素并且删除它们。
 * 选择 nums 中最后两个元素并且删除它们。
 * 选择 nums 中第一个和最后一个元素并且删除它们。
 * 一次操作的 分数 是被删除元素的和。
 * <p>
 * 在确保 所有操作分数相同 的前提下，请你求出 最多 能进行多少次操作。
 * <p>
 * 请你返回按照上述要求 最多 可以进行的操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,2,1,2,3,4]
 * 输出：3
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [1,2,3,4] 。
 * - 删除第一个元素和最后一个元素，分数为 1 + 4 = 5 ，nums = [2,3] 。
 * - 删除第一个元素和最后一个元素，分数为 2 + 3 = 5 ，nums = [] 。
 * 由于 nums 为空，我们无法继续进行任何操作。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,6,1,4]
 * 输出：2
 * 解释：我们执行以下操作：
 * - 删除前两个元素，分数为 3 + 2 = 5 ，nums = [6,1,4] 。
 * - 删除最后两个元素，分数为 1 + 4 = 5 ，nums = [6] 。
 * 至多进行 2 次操作。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2000
 * 1 <= nums[i] <= 1000
 */
public class Code19 {

    //剩余最小长度
    private int minLength;
    //走过的缓存
    private Set<String> keySet = new HashSet<>();

    public int maxOperations(int[] nums) {
        //如果只有2
        if (nums.length == 2) {
            //过
            return 1;
        }
        //剩余最小长度
        this.minLength = nums.length;
        //递归三种情况
        next(nums, nums[0] + nums[1], 2, nums.length - 1);
        next(nums, nums[nums.length - 1] + nums[nums.length - 2], 0, nums.length - 3);
        next(nums, nums[0] + nums[nums.length - 1], 1, nums.length - 2);
        //返回
        return (nums.length - minLength) / 2;
    }

    //递归
    private void next(int[] nums, int rank, int start, int end) {
        //组合key
        String key = start + "," + end;
        //如果走过了
        if (this.keySet.contains(key)) {
            //过
            return;
        }
        //记录走过
        this.keySet.add(key);
        //如果越界
        if (start >= end) {
            //记录最终
            this.minLength = 0;
            //过
            return;
        }
        //刷新本次
        this.minLength = Math.min(end - start, this.minLength);
        //如果可以递归
        if (this.minLength > 0 && nums[start] + nums[end] == rank) {
            //递归
            next(nums, rank, start + 1, end - 1);
        }
        //如果可以递归
        if (this.minLength > 0 && nums[start] + nums[start + 1] == rank) {
            //递归
            next(nums, rank, start + 2, end);
        }
        //如果可以递归
        if (this.minLength > 0 && nums[end] + nums[end - 1] == rank) {
            //递归
            next(nums, rank, start, end - 2);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code19().maxOperations(new int[]{1, 9, 7, 3, 2, 7, 4, 12, 2, 6}));
    }

}
