package normal52;

/**
 * 2401. 最长优雅子数组
 * 尝试过
 * 算术评级: 6
 * 第 309 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1750
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由 正 整数组成的数组 nums 。
 * <p>
 * 如果 nums 的子数组中位于 不同 位置的每对元素按位 与（AND）运算的结果等于 0 ，则称该子数组为 优雅 子数组。
 * <p>
 * 返回 最长 的优雅子数组的长度。
 * <p>
 * 子数组 是数组中的一个 连续 部分。
 * <p>
 * 注意：长度为 1 的子数组始终视作优雅子数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,8,48,10]
 * 输出：3
 * 解释：最长的优雅子数组是 [3,8,48] 。子数组满足题目条件：
 * - 3 AND 8 = 0
 * - 3 AND 48 = 0
 * - 8 AND 48 = 0
 * 可以证明不存在更长的优雅子数组，所以返回 3 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,1,5,11,13]
 * 输出：1
 * 解释：最长的优雅子数组长度为 1 ，任何长度为 1 的子数组都满足题目条件。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code4 {

    public int longestNiceSubarray(int[] nums) {
        //最大长度
        int max = 0;
        //计数缓存
        int[] arr = new int[30];
        //错误计数
        int errorCount = 0;
        //滑动窗口
        int left = 0;
        int right = 0;
        //循环
        while (right < nums.length) {

            /**
             * 右滑：记录右边的数字1的位置
             */

            //当前数字
            int rightNum = nums[right++];
            //索引
            int rightNumIndex = 0;
            //如果还有
            while (rightNum > 0) {
                //如果有1,记录
                if ((rightNum % 2 == 1) == true && ++arr[rightNumIndex] == 2) {
                    //增加重复
                    errorCount++;
                }
                //+1
                rightNumIndex++;
                //位移
                rightNum = rightNum >> 1;
            }

            /**
             * 不断左滑：不能有重复的1
             */

            //如果重复了
            while (errorCount > 0) {
                //当前数字
                int leftNum = nums[left++];
                //索引
                int leftNumIndex = 0;
                //如果还有
                while (leftNum > 0) {
                    //如果有1,记录
                    if ((leftNum % 2 == 1) == true && --arr[leftNumIndex] == 1) {
                        //减少重复
                        errorCount--;
                    }
                    //+1
                    leftNumIndex++;
                    //位移
                    leftNum = leftNum >> 1;
                }
            }

            /**
             * 刷新最大长度
             */

            //计算
            max = Math.max(max, right - left);

        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        //new Code4().longestNiceSubarray(new int[]{59});
        System.out.println(new Code4().longestNiceSubarray(new int[]{1, 3, 8, 48, 10}));
    }

}