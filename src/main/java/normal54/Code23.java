package normal54;

/**
 * 3583. 统计特殊三元组
 * 算术评级: 4
 * 第 454 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1510
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 特殊三元组 定义为满足以下条件的下标三元组 (i, j, k)：
 * <p>
 * 0 <= i < j < k < n，其中 n = nums.length
 * nums[i] == nums[j] * 2
 * nums[k] == nums[j] * 2
 * 返回数组中 特殊三元组 的总数。
 * <p>
 * 由于答案可能非常大，请返回结果对 109 + 7 取余数后的值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [6,3,6]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 唯一的特殊三元组是 (i, j, k) = (0, 1, 2)，其中：
 * <p>
 * nums[0] = 6, nums[1] = 3, nums[2] = 6
 * nums[0] = nums[1] * 2 = 3 * 2 = 6
 * nums[2] = nums[1] * 2 = 3 * 2 = 6
 * 示例 2：
 * <p>
 * 输入： nums = [0,1,0,0]
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * 唯一的特殊三元组是 (i, j, k) = (0, 2, 3)，其中：
 * <p>
 * nums[0] = 0, nums[2] = 0, nums[3] = 0
 * nums[0] = nums[2] * 2 = 0 * 2 = 0
 * nums[3] = nums[2] * 2 = 0 * 2 = 0
 * 示例 3：
 * <p>
 * 输入： nums = [8,4,2,8,4]
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 共有两个特殊三元组：
 * <p>
 * (i, j, k) = (0, 1, 3)
 * nums[0] = 8, nums[1] = 4, nums[3] = 8
 * nums[0] = nums[1] * 2 = 4 * 2 = 8
 * nums[3] = nums[1] * 2 = 4 * 2 = 8
 * (i, j, k) = (1, 2, 4)
 * nums[1] = 4, nums[2] = 2, nums[4] = 4
 * nums[1] = nums[2] * 2 = 2 * 2 = 4
 * nums[4] = nums[2] * 2 = 2 * 2 = 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n == nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Code23 {

    public int specialTriplets(int[] nums) {

        /**
         * 统计数量
         */

        //左右分别的数量
        int[] leftCountArr = new int[100001];
        int[] rightCountArr = new int[100001];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //+1
            rightCountArr[nums[i]]++;
        }

        /**
         * 滑动
         */

        //处理第一个
        leftCountArr[nums[0]]++;
        rightCountArr[nums[0]]--;

        //结果
        long result = 0L;

        //循环
        for (int i = 1; i < nums.length; i++) {
            //当前数字
            int num = nums[i];
            //先滑动
            rightCountArr[num]--;
            //目标数字
            int target = num * 2;
            //如果没越界
            if (target < rightCountArr.length) {
                //左右
                long leftCount = leftCountArr[target];
                long rightCount = rightCountArr[target];
                //如果都存在
                if (leftCount > 0 && rightCount > 0) {
                    //计算本次
                    result += leftCount * rightCount;
                }
            }
            //再滑动
            leftCountArr[num]++;
        }

        //返回结果
        return (int) (result % 1000000007);
    }

    public static void main(String[] args) {
        System.out.println(new Code23().specialTriplets(new int[]{0, 1, 0, 0}));
    }

}
