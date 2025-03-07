package normal12;

/**
 * @Author ayl
 * @Date 2022-03-08
 * 55. 跳跃游戏
 * 给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,1,1,4]
 * 输出：true
 * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,1,0,4]
 * 输出：false
 * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * 0 <= nums[i] <= 105
 */
public class Code17 {

    //不断从后向前走
    public boolean next(int[] nums, int start) {
        //如果是从头开始
        if (start == 0) {
            //可以走到
            return true;
        }
        //从这里开始
        int end = start - 1;
        //循环
        while (end >= 0) {
            //当前可走 大于等于 距离
            if (nums[end] >= start - end) {
                //继续走下去
                return next(nums, end);
            }
            //下一个
            end--;
        }
        //如果走到头都没有能走到这个位置的
        return false;
    }

    public boolean canJump(int[] nums) {
        //从最后一位跳
        return next(nums, nums.length - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code17().canJump(new int[]{3, 2, 1, 0, 4}));
    }

}
