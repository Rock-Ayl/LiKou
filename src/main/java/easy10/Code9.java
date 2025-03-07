package easy10;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2021-07-18
 * 1929. 数组串联
 * 给你一个长度为 n 的整数数组 nums 。请你构建一个长度为 2n 的答案数组 ans ，数组下标 从 0 开始计数 ，对于所有 0 <= i < n 的 i ，满足下述所有要求：
 * <p>
 * ans[i] == nums[i]
 * ans[i + n] == nums[i]
 * 具体而言，ans 由两个 nums 数组 串联 形成。
 * <p>
 * 返回数组 ans 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,1]
 * 输出：[1,2,1,1,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
 * - ans = [1,2,1,1,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3,2,1]
 * 输出：[1,3,2,1,1,3,2,1]
 * 解释：数组 ans 按下述方式形成：
 * - ans = [nums[0],nums[1],nums[2],nums[3],nums[0],nums[1],nums[2],nums[3]]
 * - ans = [1,3,2,1,1,3,2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 1000
 * 1 <= nums[i] <= 1000
 */
public class Code9 {

    public int[] getConcatenation(int[] nums) {
        //结果
        int[] arr = new int[nums.length * 2];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //组装
            arr[i] = nums[i];
            arr[i + nums.length] = nums[i];
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        for (int i : new Code9().getConcatenation(new int[]{1, 2, 3, 1})) {
            System.out.println(i);
        }
    }
}
