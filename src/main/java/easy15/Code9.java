package easy15;

/**
 * @Author ayl
 * @Date 2021-11-24
 * 674. 最长连续递增序列
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,5,4,7]
 * 输出：3
 * 解释：最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,2,2,2]
 * 输出：1
 * 解释：最长连续递增序列是 [2], 长度为1。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 */
public class Code9 {

    public int findLengthOfLCIS(int[] nums) {
        //最大
        int max = 1;
        //上一个
        int last = nums[0];
        //当前连续
        int count = 1;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前
            int num = nums[i];
            //如果正常
            if (num > last) {
                //记录
                count++;
            } else {
                //如果刷新记录
                if (count > max) {
                    //记录
                    max = count;
                }
                //初始化
                count = 1;
            }
            //更新
            last = num;
        }
        //返回
        return Math.max(max, count);
    }

}
