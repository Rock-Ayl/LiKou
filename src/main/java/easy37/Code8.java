package easy37;

/**
 * @Author ayl
 * @Date 2024-06-17
 * 3158. 求出出现两次数字的 XOR 值
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个数组 nums ，数组中的数字 要么 出现一次，要么 出现两次。
 * <p>
 * 请你返回数组中所有出现两次数字的按位 XOR 值，如果没有数字出现过两次，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * nums 中唯一出现过两次的数字是 1 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * nums 中没有数字出现两次。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,2,1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 数字 1 和 2 出现过两次。1 XOR 2 == 3 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 * nums 中每个数字要么出现过一次，要么出现过两次。
 */
public class Code8 {

    public int duplicateNumbersXOR(int[] nums) {
        //目标结果
        int result = 0;
        //缓存
        int[] cache = new int[51];
        //循环
        for (int num : nums) {
            //如果是出现两次
            if (++cache[num] == 2) {
                //计算本次结果
                result = result ^ num;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().duplicateNumbersXOR(new int[]{1, 1, 2, 2}));
    }

}
