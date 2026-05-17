package easy43;

/**
 * 3925. 连接逆序数组
 * 算术评级: 1
 * 第 501 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1176
 * premium lock icon
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums。
 * <p>
 * 构造一个新的长度为 2 * n 的数组 ans，其中前 n 个元素与 nums 相同，后 n 个元素为 nums 的逆序。
 * <p>
 * 具体而言，对于 0 <= i <= n - 1：
 * <p>
 * ans[i] = nums[i]
 * ans[i + n] = nums[n - i - 1]
 * 返回整数数组 ans。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3]
 * <p>
 * 输出： [1,2,3,3,2,1]
 * <p>
 * 解释：
 * <p>
 * ans 的前 n 个元素与 nums 相同。
 * <p>
 * 接下来的 n = 3 个元素按照 nums 的逆序填入：
 * <p>
 * ans[3] = nums[2] = 3
 * ans[4] = nums[1] = 2
 * ans[5] = nums[0] = 1
 * 因此，ans = [1, 2, 3, 3, 2, 1]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1]
 * <p>
 * 输出： [1,1]
 * <p>
 * 解释：
 * <p>
 * 数组逆序后保持不变。因此，ans = [1, 1]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code9 {

    public int[] concatWithReverse(int[] nums) {
        //初始化
        int[] result = new int[nums.length * 2];
        //索引
        int index = 0;
        //正序
        for (int i = 0; i < nums.length; i++) {
            //记录,并+1
            result[index++] = nums[i];
        }
        //倒序
        for (int i = nums.length - 1; i >= 0; i--) {
            //记录,并+1
            result[index++] = nums[i];
        }
        //返回
        return result;
    }

}
