package easy43;

/**
 * 3978. 唯一中间元素
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为奇数 n 的整数数组 nums 。
 * <p>
 * 如果 nums 的下标中间元素在数组中 恰好 出现一次，返回 true 。否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * nums 的中间元素是 2 ，它恰好出现一次。
 * <p>
 * 因此，答案为 true 。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,2]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * nums 的中间元素是 2 ，它出现了两次。
 * <p>
 * 因此，答案为 false 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 100
 * n 是奇数。
 * 1 <= nums[i] <= 100
 */
public class Code19 {

    public boolean isMiddleElementUnique(int[] nums) {
        //目标数字
        int midNum = nums[nums.length / 2];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果出现相同数字 and 不是中间索引
            if (nums[i] == midNum && i != nums.length / 2) {
                //不行
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().isMiddleElementUnique(new int[]{1, 2, 3}));
    }

}
