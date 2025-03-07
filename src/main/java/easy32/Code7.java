package easy32;

/**
 * @Author ayl
 * @Date 2023-06-27
 * 面试题 16.17. 连续数列
 * 给定一个整数数组，找出总和最大的连续数列，并返回总和。
 * <p>
 * 示例：
 * <p>
 * 输入： [-2,1,-3,4,-1,2,1,-5,4]
 * 输出： 6
 * 解释： 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶：
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class Code7 {

    public int maxSubArray(int[] nums) {
        //初始化 最大和、当前和
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        //循环
        for (int num : nums) {
            //叠加当前和,并刷新最大
            maxSum = Math.max(maxSum, sum += num);
            //如果当前太小
            if (sum < 0) {
                //刷新为0
                sum = 0;
            }
        }
        //返回
        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
