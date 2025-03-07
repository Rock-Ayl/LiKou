package normal8;

/**
 * @Author ayl
 * @Date 2021-12-22
 * 300. 最长递增子序列
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,9,2,5,3,7,101,18]
 * 输出：4
 * 解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,3,2,3]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：nums = [7,7,7,7,7,7,7]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 2500
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以设计时间复杂度为 O(n2) 的解决方案吗？
 * 你能将算法的时间复杂度降低到 O(n log(n)) 吗?
 */
public class Code11 {

    //全局
    int[] nums;
    //最长
    int max = 0;

    public int next(int p, int last, int count) {
        //循环
        for (int i = p; i < nums.length; i++) {
            //当前数字
            int number = nums[i];
            //如果可以
            if (number > last) {
                //计算
                int size = next(i + 1, number, count + 1);
                //如果刷新记录
                if (size > max) {
                    //更新
                    max = size;
                }
            }
        }
        //返回结果
        return count;
    }

    public int lengthOfLIS(int[] nums) {
        //全局
        this.nums = nums;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //计算
            next(i + 1, nums[i], 1);
        }
        //返回
        return Math.max(max, 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code11().lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

}
