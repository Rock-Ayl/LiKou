package normal16;

/**
 * @Author ayl
 * @Date 2022-08-30
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出：6
 * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
 * 示例 2：
 * <p>
 * 输入：nums = [1]
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：nums = [5,4,-1,7,8]
 * 输出：23
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class Code8 {

    public int maxSubArray(int[] nums) {
        //最大可能
        int max = nums[0];
        //当前连击
        int hit = nums[0];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //如果不值得连击
            if (hit < 0) {
                //断开连击
                hit = num;
            } else {
                //继续连击
                hit = num + hit;
            }
            //刷新最大可能
            max = Math.max(max, hit);
        }
        //返回最大结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));;
    }

}
