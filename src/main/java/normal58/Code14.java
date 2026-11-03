package normal58;

/**
 * 2012. 数组美丽值求和
 * 算术评级: 4
 * 第 259 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1468
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。对于每个下标 i（1 <= i <= nums.length - 2），nums[i] 的 美丽值 等于：
 * <p>
 * 2，对于所有 0 <= j < i 且 i < k <= nums.length - 1 ，满足 nums[j] < nums[i] < nums[k]
 * 1，如果满足 nums[i - 1] < nums[i] < nums[i + 1] ，且不满足前面的条件
 * 0，如果上述条件全部不满足
 * 返回符合 1 <= i <= nums.length - 2 的所有 nums[i] 的 美丽值的总和 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：2
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 2
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,6,4]
 * 输出：1
 * 解释：对于每个符合范围 1 <= i <= 2 的下标 i :
 * - nums[1] 的美丽值等于 1
 * - nums[2] 的美丽值等于 0
 * 示例 3：
 * <p>
 * 输入：nums = [3,2,1]
 * 输出：0
 * 解释：对于每个符合范围 1 <= i <= 1 的下标 i :
 * - nums[1] 的美丽值等于 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 *
 */
public class Code14 {

    public int sumOfBeauties(int[] nums) {
        //右边最小数组
        int[] arr = new int[nums.length];
        //初始化
        arr[nums.length - 1] = nums[nums.length - 1];
        //循环
        for (int i = nums.length - 2; i >= 0; i--) {
            //刷新最小
            arr[i] = Math.min(arr[i + 1], nums[i]);
        }
        //结果
        int sum = 0;
        //左边最大数字
        int leftMax = nums[0];
        //循环
        for (int i = 1; i < nums.length - 1; i++) {
            //如果大于左边 and 小于右边最小
            if (nums[i] > leftMax && nums[i] < arr[i + 1]) {
                //2分
                sum += 2;
            }
            //如果只限两边
            else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                //1分
                sum += 1;
            }
            //刷新左边最大
            leftMax = Math.max(leftMax, nums[i]);
        }
        //返回结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().sumOfBeauties(new int[]{1, 2, 3}));
    }

}
