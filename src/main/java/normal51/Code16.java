package normal51;

import java.util.Arrays;

/**
 * 2501. 数组中最长的方波
 * 算术评级: 4
 * 第 323 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1480
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。如果 nums 的子序列满足下述条件，则认为该子序列是一个 方波 ：
 * <p>
 * 子序列的长度至少为 2 ，并且
 * 将子序列从小到大排序 之后 ，除第一个元素外，每个元素都是前一个元素的 平方 。
 * 返回 nums 中 最长方波 的长度，如果不存在 方波 则返回 -1 。
 * <p>
 * 子序列 也是一个数组，可以由另一个数组删除一些或不删除元素且不改变剩余元素的顺序得到。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * 输入：nums = [4,3,6,16,8,2]
 * 输出：3
 * 解释：选出子序列 [4,16,2] 。排序后，得到 [2,4,16] 。
 * - 4 = 2 * 2.
 * - 16 = 4 * 4.
 * 因此，[4,16,2] 是一个方波.
 * 可以证明长度为 4 的子序列都不是方波。
 * 示例 2 ：
 * <p>
 * 输入：nums = [2,3,5,6,7]
 * 输出：-1
 * 解释：nums 不存在方波，所以返回 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 2 <= nums[i] <= 105
 */
public class Code16 {

    public int longestSquareStreak(int[] nums) {
        //排序
        Arrays.sort(nums);
        //数组
        int[] arr = new int[nums[nums.length - 1] + 1];
        //循环
        for (int num : nums) {
            //记录
            arr[num] = 1;
        }
        //最大长度
        int max = 0;
        //循环
        for (int num : nums) {
            //次数
            int count = 0;
            //数字
            int thisNum = num;
            //如果有
            while (thisNum >= 2 && thisNum < arr.length && arr[thisNum] == 1) {
                //删除
                arr[thisNum] = 0;
                //平方
                thisNum = thisNum * thisNum;
                //+1
                count++;
            }
            //刷新最大
            max = Math.max(max, count);
        }
        //返回
        return max == 1 ? -1 : max;
    }

    public static void main(String[] args) {
        int res = new Code16().longestSquareStreak(new int[]{4, 3, 6, 16, 8, 2});
        System.out.println(res);
    }

}
