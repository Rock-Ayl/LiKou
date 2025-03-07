package easy35;

/**
 * @Author ayl
 * @Date 2023-11-03
 * LCR 068. 搜索插入位置
 * 简单
 * 53
 * 相关企业
 * 给定一个排序的整数数组 nums 和一个整数目标值 target ，请在数组中找到 target ，并返回其下标。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * <p>
 * 请必须使用时间复杂度为 O(log n) 的算法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,3,5,6], target = 5
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: nums = [1,3,5,6], target = 2
 * 输出: 1
 * 示例 3:
 * <p>
 * 输入: nums = [1,3,5,6], target = 7
 * 输出: 4
 * 示例 4:
 * <p>
 * 输入: nums = [1,3,5,6], target = 0
 * 输出: 0
 * 示例 5:
 * <p>
 * 输入: nums = [1], target = 0
 * 输出: 0
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 为无重复元素的升序排列数组
 * -104 <= target <= 104
 * <p>
 * <p>
 * 注意：本题与主站 35 题相同： https://leetcode-cn.com/problems/search-insert-position/
 */
public class Code2 {

    //递归
    private int next(int[] nums, int target, int left, int right, int p) {
        //如果是目标值
        if (nums[p] == target) {
            //直接返回
            return p;
        }
        //如果范围最小了
        if (left + 1 == right) {
            //返回
            return right;
        }
        //继续递归
        if (nums[p] > target) {
            //递归
            return next(nums, target, left, p, ((p - left) / 2) + left);
        } else {
            //递归
            return next(nums, target, p, right, ((right - p) / 2) + p);
        }
    }

    public int searchInsert(int[] nums, int target) {
        //如果比第一个还小 or 相等
        if (nums[0] >= target) {
            //头
            return 0;
        }
        //如果比最后一个还大
        if (nums[nums.length - 1] < target) {
            //头
            return nums.length;
        }
        //开始递归
        return next(nums, target, 0, nums.length - 1, nums.length / 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code2().searchInsert(new int[]{1, 3}, 3));
    }

}
