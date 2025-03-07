package easy13;

/**
 * @Author ayl
 * @Date 2021-10-26
 * 2006. 差的绝对值为 K 的数对数目
 * 给你一个整数数组 nums 和一个整数 k ，请你返回数对 (i, j) 的数目，满足 i < j 且 |nums[i] - nums[j]| == k 。
 * <p>
 * |x| 的值定义为：
 * <p>
 * 如果 x >= 0 ，那么值为 x 。
 * 如果 x < 0 ，那么值为 -x 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,1], k = 1
 * 输出：4
 * 解释：差的绝对值为 1 的数对为：
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * - [1,2,2,1]
 * 示例 2：
 * <p>
 * 输入：nums = [1,3], k = 3
 * 输出：0
 * 解释：没有任何数对差的绝对值为 3 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1,5,4], k = 2
 * 输出：3
 * 解释：差的绝对值为 2 的数对为：
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * - [3,2,1,5,4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 * 1 <= k <= 99
 */
public class Code13 {

    public int countKDifference(int[] nums, int k) {
        //结果
        int size = 0;
        //循环1
        for (int i = 0; i < nums.length; i++) {
            //循环2
            for (int j = i + 1; j < nums.length; j++) {
                //如果是
                if (Math.abs(nums[i] - nums[j]) == k) {
                    //记录
                    size++;
                }
            }
        }
        //结果
        return size;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countKDifference(new int[]{1, 2, 2, 1}, 1));
    }
}
