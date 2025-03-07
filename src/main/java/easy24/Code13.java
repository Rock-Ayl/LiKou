package easy24;

/**
 * @Author ayl
 * @Date 2022-11-02
 * 剑指 Offer 42. 连续子数组的最大和
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 * <p>
 * <p>
 * <p>
 * 示例1:
 * <p>
 * 输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 10^5
 * -100 <= arr[i] <= 100
 * 注意：本题与主站 53 题相同：https://leetcode-cn.com/problems/maximum-subarray/
 */
public class Code13 {

    public int maxSubArray(int[] nums) {
        //结果
        int max = Integer.MIN_VALUE;
        //上一个和
        int lastSum = 0;
        //循环
        for (int num : nums) {
            //当前和
            int thisSum = lastSum + num;
            //尝试刷新最大
            max = Math.max(max, thisSum);
            //重置和
            lastSum = Math.max(thisSum, 0);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
