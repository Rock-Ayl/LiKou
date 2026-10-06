package normal57;

import java.util.Arrays;

/**
 * 3201. 找出有效子序列的最大长度 I
 * 算术评级: 4
 * 第 404 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1664
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 * <p>
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,3,4]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 2, 3, 4]。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,1,1,2,1,2]
 * <p>
 * 输出： 6
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [1,3]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 最长的有效子序列是 [1, 3]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 2 * 105
 * 1 <= nums[i] <= 107
 */
public class Code17 {

    public int maximumLength(int[] nums) {
        //全是偶数
        int a = (int) Arrays.stream(nums).filter(p -> p % 2 == 0).count();
        //全是奇数
        int b = (int) Arrays.stream(nums).filter(p -> p % 2 != 0).count();
        //先偶后奇
        int c = ab(nums, 0);
        //先奇后偶
        int d = ab(nums, 1);
        //返回最大
        return Math.max(Math.max(a, b), Math.max(c, d));
    }

    //交替情况
    private int ab(int[] nums, int target) {
        //次数
        int count = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //当前数字
            int num = nums[i] % 2;
            //如果是目标数字
            if (num == target) {
                //+1
                count++;
                //交替
                if (target == 1) {
                    //交替
                    target = 0;
                } else {
                    //交替
                    target = 1;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
    }

}
