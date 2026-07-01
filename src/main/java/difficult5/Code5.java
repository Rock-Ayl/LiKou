package difficult5;

/**
 * 995. K 连续位的最小翻转次数
 * 算术评级: 8
 * 第 124 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1835
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定一个二进制数组 nums 和一个整数 k 。
 * <p>
 * k位翻转 就是从 nums 中选择一个长度为 k 的 子数组 ，同时把子数组中的每一个 0 都改成 1 ，把子数组中的每一个 1 都改成 0 。
 * <p>
 * 返回数组中不存在 0 所需的最小 k位翻转 次数。如果不可能，则返回 -1 。
 * <p>
 * 子数组 是数组的 连续 部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,1,0], K = 1
 * 输出：2
 * 解释：先翻转 A[0]，然后翻转 A[2]。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,0], K = 2
 * 输出：-1
 * 解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
 * 示例 3：
 * <p>
 * 输入：nums = [0,0,0,1,0,1,1,0], K = 3
 * 输出：3
 * 解释：
 * 翻转 A[0],A[1],A[2]: A变成 [1,1,1,1,0,1,1,0]
 * 翻转 A[4],A[5],A[6]: A变成 [1,1,1,1,1,0,0,0]
 * 翻转 A[5],A[6],A[7]: A变成 [1,1,1,1,1,1,1,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= k <= nums.length
 */
public class Code5 {

    public int minKBitFlips(int[] nums, int k) {
        //操作次数
        int count = 0;
        //差分数组
        int[] arr = new int[nums.length + 1];
        //当前位置操作次数
        int change = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {

            /**
             * 计算当前位置数字
             */

            //叠加(其实是减少过期的操作次数)
            change += arr[i];
            //如果操作次数为奇数
            if (change % 2 != 0) {
                //变换
                nums[i] = (nums[i] == 0 ? 1 : 0);
            }
            //如果是1
            if (nums[i] == 1) {
                //不操作,本轮过
                continue;
            }

            /**
             * 操作一次
             */

            //如果接下来不满k个
            if (nums.length - i  < k) {
                //操作不了,返回
                return -1;
            }
            //操作+1
            count++;
            //从这里操作一次,改为操作后数字
            nums[i] = 1;
            //差分
            arr[i]++;
            arr[i + k]--;
            change++;

        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        //System.out.println(new Code5().minKBitFlips(new int[]{0, 0, 0, 1, 0, 1, 1, 0}, 3));
        System.out.println(new Code5().minKBitFlips(new int[]{1, 1, 0}, 2));
    }

}
