package easy35;

/**
 * @Author ayl
 * @Date 2024-01-08
 * 1909. 删除一个元素使数组严格递增
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums ，如果 恰好 删除 一个 元素后，数组 严格递增 ，那么请你返回 true ，否则返回 false 。如果数组本身已经是严格递增的，请你也返回 true 。
 * <p>
 * 数组 nums 是 严格递增 的定义为：对于任意下标的 1 <= i < nums.length 都满足 nums[i - 1] < nums[i] 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,10,5,7]
 * 输出：true
 * 解释：从 nums 中删除下标 2 处的 10 ，得到 [1,2,5,7] 。
 * [1,2,5,7] 是严格递增的，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,3,1,2]
 * 输出：false
 * 解释：
 * [3,1,2] 是删除下标 0 处元素后得到的结果。
 * [2,1,2] 是删除下标 1 处元素后得到的结果。
 * [2,3,2] 是删除下标 2 处元素后得到的结果。
 * [2,3,1] 是删除下标 3 处元素后得到的结果。
 * 没有任何结果数组是严格递增的，所以返回 false 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：false
 * 解释：删除任意元素后的结果都是 [1,1] 。
 * [1,1] 不是严格递增的，所以返回 false 。
 * 示例 4：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 已经是严格递增的，所以返回 true 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 1000
 * 1 <= nums[i] <= 1000
 */
public class Code19 {

    //无限递归
    private boolean next(int[] nums, int p, Integer skipP) {
        //如果到头了
        if (p >= nums.length) {
            //视为可以
            return true;
        }
        //如果当前节点是跳过节点 or 因为跳过节点而导致当前节点=0的特殊情况
        if ((skipP != null && skipP.equals(p)) || p == 0) {
            //继续走下去
            return next(nums, p + 1, skipP);
        }
        //计算上一个节点坐标,要考虑已经跳过的节点
        int lastP = p - 1 - (skipP != null && skipP.equals(p - 1) ? 1 : 0);
        //如果上一个节点越界
        if (lastP < 0) {
            //不可以
            return false;
        }
        //如果正常走
        if (nums[lastP] < nums[p]) {
            //继续走下去
            return next(nums, p + 1, skipP);
        }
        //如果之前已经错误过了,那么到这里属于错2次
        if (skipP != null) {
            //不可以
            return false;
        }
        //错误后,两种情况满足一种就行
        return next(nums, p + 1, p) || next(nums, p - 2, p - 1);
    }

    public boolean canBeIncreasing(int[] nums) {
        //如果太小
        if (nums.length < 3) {
            //是
            return true;
        }
        //如果第一级就是如此
        if (nums[0] >= nums[1]) {
            //特殊处理,直接跳过第0个,从第2个开始
            return next(nums, 2, 0);
        } else {
            //默认实现
            return next(nums, 1, null);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code19().canBeIncreasing(new int[]{2, 3, 1, 2}));
    }

}