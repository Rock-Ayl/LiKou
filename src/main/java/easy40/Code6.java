package easy40;

/**
 * @Author ayl
 * @Date 2025-03-20
 * 3487. 删除后的最大子数组元素和
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums 。
 * <p>
 * 你可以从数组 nums 中删除任意数量的元素，但不能将其变为 空 数组。执行删除操作后，选出 nums 中满足下述条件的一个子数组：
 * <p>
 * 子数组中的所有元素 互不相同 。
 * 最大化 子数组的元素和。
 * 返回子数组的 最大元素和 。
 * <p>
 * 子数组 是数组的一个连续、非空 的元素序列。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * <p>
 * 输出：15
 * <p>
 * 解释：
 * <p>
 * 不删除任何元素，选中整个数组得到最大元素和。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,0,1,1]
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 删除元素 nums[0] == 1、nums[1] == 1、nums[2] == 0 和 nums[3] == 1 。选中整个数组 [1] 得到最大元素和。
 * <p>
 * 示例 3：
 * <p>
 * 输入：nums = [1,2,-1,-2,1,0,-1]
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 删除元素 nums[2] == -1 和 nums[3] == -2 ，从 [1, 2, 1, 0, -1] 中选中子数组 [2, 1] 以获得最大元素和。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code6 {

    public int maxSum(int[] nums) {
        //求和
        int sum = 0;
        //最大的数字
        int max = Integer.MIN_VALUE;
        //缓存
        int[] arr = new int[201];
        //循环
        for (int num : nums) {
            //刷新最大数字
            max = Math.max(max, num);
            //+1、如果是第一次出现 and 数字是正数
            if (++arr[num + 100] == 1 && num > 0) {
                //叠加
                sum += num;
            }
        }
        //返回,如果存在,返回结果,如果不存在,返回最大值
        return sum > 0 ? sum : max;
    }

    public static void main(String[] args) {

    }

}
