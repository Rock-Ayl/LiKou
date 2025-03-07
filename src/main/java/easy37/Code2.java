package easy37;

/**
 * @Author ayl
 * @Date 2024-05-25
 * 3151. 特殊数组 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * <p>
 * Aging 有一个整数数组 nums。如果 nums 是一个 特殊数组 ，返回 true，否则返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 只有一个元素，所以答案为 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,1,4]
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 只有两对相邻元素： (2,1) 和 (1,4)，它们都包含了奇偶性不同的数字，因此答案为 true。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [4,3,1,6]
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * nums[1] 和 nums[2] 都是奇数。因此答案为 false。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code2 {

    public boolean isArraySpecial(int[] nums) {
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果不是
            if (nums[i - 1] % 2 == nums[i] % 2) {
                //不行
                return false;
            }
        }
        //默认
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().isArraySpecial(new int[]{2, 1, 4}));
    }

}
