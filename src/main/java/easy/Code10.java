package easy;

/**
 * Created By Rock-Ayl on 2020-08-18
 * 1480. 一维数组的动态和
 * 给你一个数组 nums 。数组「动态和」的计算公式为：runningSum[i] = sum(nums[0]…nums[i]) 。
 * <p>
 * 请返回 nums 的动态和。
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,6,10]
 * 解释：动态和计算过程为 [1, 1+2, 1+2+3, 1+2+3+4] 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1,1,1]
 * 输出：[1,2,3,4,5]
 * 解释：动态和计算过程为 [1, 1+1, 1+1+1, 1+1+1+1, 1+1+1+1+1] 。
 * 示例 3：
 * <p>
 * 输入：nums = [3,1,2,10,1]
 * 输出：[3,4,6,16,17]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * -10^6 <= nums[i] <= 10^6
 */
public class Code10 {

    public static int[] runningSum(int[] nums) {
        //次数
        int n = nums.length;
        //初始化
        int[] result = new int[n];
        //循环
        for (int i = 0; i < n; i++) {
            //计算和
            int sum = 0;
            //当前累加
            int thisNum = 0;
            //循环
            while (thisNum < n && thisNum <= i) {
                //累加
                sum = sum + nums[thisNum];
                //叠加
                thisNum++;
            }
            //记录
            result[i] = sum;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : runningSum(new int[]{1, 2, 3, 4})) {
            System.out.println(i);
        }
    }

}
