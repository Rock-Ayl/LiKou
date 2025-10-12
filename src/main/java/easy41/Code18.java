package easy41;

/**
 * @Author ayl
 * @Date 2025-10-12
 * 3712. 出现次数能被 K 整除的元素总和
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k。
 * <p>
 * 请返回一个整数，表示 nums 中所有其 出现次数 能被 k 整除的元素的总和；如果没有这样的元素，则返回 0 。
 * <p>
 * 注意： 若某个元素在数组中的总出现次数能被 k 整除，则它在求和中会被计算 恰好 与其出现次数相同的次数。
 * <p>
 * 元素 x 的 出现次数 指它在数组中出现的次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,2,2,3,3,3,3,4], k = 2
 * <p>
 * 输出： 16
 * <p>
 * 解释：
 * <p>
 * 数字 1 出现 1 次（奇数次）。
 * 数字 2 出现 2 次（偶数次）。
 * 数字 3 出现 4 次（偶数次）。
 * 数字 4 出现 1 次（奇数次）。
 * 因此总和为 2 + 2 + 3 + 3 + 3 + 3 = 16。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,3,4,5], k = 2
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 没有元素出现偶数次，因此总和为 0。
 * <p>
 * 示例 3：
 * <p>
 * 输入： nums = [4,4,4,1,2,3], k = 3
 * <p>
 * 输出： 12
 * <p>
 * 解释：
 * <p>
 * 数字 1 出现 1 次。
 * 数字 2 出现 1 次。
 * 数字 3 出现 1 次。
 * 数字 4 出现 3 次。
 * 因此总和为 4 + 4 + 4 = 12。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 * 1 <= k <= 100
 */
public class Code18 {

    public int sumDivisibleByK(int[] nums, int k) {
        //缓存
        int[] arr = new int[101];
        //循环
        for (int num : nums) {
            //+1
            arr[num]++;
        }
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果没有
            if (arr[i] == 0) {
                //本轮过
                continue;
            }
            //如果是目标结果
            if (arr[i] % k == 0) {
                //本次
                result += arr[i] * i;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().sumDivisibleByK(new int[]{1, 2, 2, 3, 3, 3, 3, 4}, 2));
    }

}
