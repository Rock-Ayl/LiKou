package normal26;

/**
 * @Author ayl
 * @Date 2023-11-17
 * 2369. 检查数组是否存在有效划分
 * 提示
 * 中等
 * 40
 * 相关企业
 * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 * <p>
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 * <p>
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [4,4,4,5,6]
 * 输出：true
 * 解释：数组可以划分成子数组 [4,4] 和 [4,5,6] 。
 * 这是一种有效划分，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,2]
 * 输出：false
 * 解释：该数组不存在有效划分。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 */
public class Code3 {

    //走过的路
    private int[] walkedArr;

    //递归
    public boolean next(int[] nums, int p) {
        //如果到头了
        if (p == nums.length) {
            //是
            return true;
        }
        //如果走过了
        if (++walkedArr[p] > 1) {
            //不是
            return false;
        }
        //如果连2个都不够
        if (nums.length - p < 2) {
            //不是
            return false;
        }
        //如果当前满足 2同
        if (nums[p] == nums[p + 1]) {
            //递归,如果有结果
            boolean success = next(nums, p + 2);
            //如果是
            if (success) {
                //返回
                return true;
            }
        }
        //如果不满足3个
        if (nums.length - p < 3) {
            //不是
            return false;
        }
        //判断是 三同 or 递增
        if ((nums[p] == nums[p + 1] && nums[p] == nums[p + 2]) || (nums[p] + 1 == nums[p + 1] && nums[p + 1] + 1 == nums[p + 2])) {
            //递归,如果有结果
            boolean success = next(nums, p + 3);
            //如果是
            if (success) {
                //返回
                return true;
            }
        }
        //默认
        return false;
    }

    public boolean validPartition(int[] nums) {
        //初始化缓存
        this.walkedArr = new int[nums.length];
        //开始递归
        return next(nums, 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code3().validPartition(new int[]{4, 4, 4, 5, 6}));
    }

}
