package normal29;

/**
 * @Author ayl
 * @Date 2024-02-19
 * 713. 乘积小于 K 的子数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 和一个整数 k ，请你返回子数组内所有元素的乘积严格小于 k 的连续子数组的数目。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [10,5,2,6], k = 100
 * 输出：8
 * 解释：8 个乘积小于 100 的子数组分别为：[10]、[5]、[2],、[6]、[10,5]、[5,2]、[2,6]、[5,2,6]。
 * 需要注意的是 [10,5,2] 并不是乘积小于 100 的子数组。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3], k = 0
 * 输出：0
 */
public class Code4 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //结果
        int result = 0;
        //右边距(-1为不存在,用于处理第一次和某个节点大于等于k的情况,类似隔断)
        int right = -1;
        int lastSum = 0;
        //循环
        for (int i = 0; i < nums.length; i++) {
            //如果当前就很大
            if (nums[i] >= k) {
                //没有本次结果
                right = -1;
                //本轮过
                continue;
            }
            //如果没有上一个缓存
            if (right == -1) {
                //初始化右边距及对应和
                right = i + 1;
                lastSum = nums[i];
            } else {
                //剔除左边的数字
                lastSum = lastSum / nums[i - 1];
            }
            //如果右边距可以继续扩展
            while (right < nums.length && lastSum * nums[right] < k) {
                //计算并进位
                lastSum = lastSum * nums[right++];
            }
            //叠加本次结果
            result += right - i;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

}
