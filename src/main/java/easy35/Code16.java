package easy35;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-01-04
 * 2917. 找出数组中的 K-or 值
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * nums 中的 K-or 是一个满足以下条件的非负整数：
 * <p>
 * 只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。
 * 返回 nums 的 K-or 值。
 * <p>
 * 注意 ：对于整数 x ，如果 (2i AND x) == 2i ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [7,12,9,8,9,15], k = 4
 * 输出：9
 * 解释：nums[0]、nums[2]、nums[4] 和 nums[5] 的第 0 位的值为 1 。
 * nums[0] 和 nums[5] 的第 1 位的值为 1 。
 * nums[0]、nums[1] 和 nums[5] 的第 2 位的值为 1 。
 * nums[1]、nums[2]、nums[3]、nums[4] 和 nums[5] 的第 3 位的值为 1 。
 * 只有第 0 位和第 3 位满足数组中至少存在 k 个元素在对应位上的值为 1 。因此，答案为 2^0 + 2^3 = 9 。
 * 示例 2：
 * <p>
 * 输入：nums = [2,12,1,11,4,5], k = 6
 * 输出：0
 * 解释：因为 k == 6 == nums.length ，所以数组的 6-or 等于其中所有元素按位与运算的结果。因此，答案为 2 AND 12 AND 1 AND 11 AND 4 AND 5 = 0 。
 * 示例 3：
 * <p>
 * 输入：nums = [10,8,5,9,11,6,8], k = 1
 * 输出：15
 * 解释：因为 k == 1 ，数组的 1-or 等于其中所有元素按位或运算的结果。因此，答案为 10 OR 8 OR 5 OR 9 OR 11 OR 6 OR 8 = 15 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 50
 * 0 <= nums[i] < 231
 * 1 <= k <= nums.length
 */
public class Code16 {

    public int findKOr(int[] nums, int k) {
        //缓存
        String[] arr = new String[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //转化为二进制
            arr[i] = new StringBuffer(Integer.toBinaryString(nums[i])).reverse().toString();
        }
        //字符串最大长度
        int maxLength = Arrays.stream(arr).map(String::length).mapToInt(Integer::intValue).max().getAsInt();
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < maxLength; i++) {
            //符合条件的情况
            int count = 0;
            //循环
            for (String num : arr) {
                //如果是
                if (i < num.length() && num.charAt(i) == '1') {
                    //记录
                    count++;
                }
            }
            //如果是
            if (count >= k) {
                //叠加结果
                result += 1 << i;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4));
        System.out.println(2 ^ 3);
    }
}
