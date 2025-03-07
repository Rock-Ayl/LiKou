package easy35;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-01-06
 * LCP 28. 采购方案
 * 尝试过
 * 简单
 * 相关标签
 * 相关企业
 * 小力将 N 个零件的报价存于数组 nums。小力预算为 target，假定小力仅购买两个零件，要求购买零件的花费不超过预算，请问他有多少种采购方案。
 * <p>
 * 注意：答案需要以 1e9 + 7 (1000000007) 为底取模，如：计算初始结果为：1000000008，请返回 1
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,5,3,5], target = 6
 * <p>
 * 输出：1
 * <p>
 * 解释：预算内仅能购买 nums[0] 与 nums[2]。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [2,2,1,9], target = 10
 * <p>
 * 输出：4
 * <p>
 * 解释：符合预算的采购方案如下： nums[0] + nums[1] = 4 nums[0] + nums[2] = 3 nums[1] + nums[2] = 3 nums[2] + nums[3] = 10
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i], target <= 10^5
 */
public class Code17 {

    public int purchasePlans(int[] nums, int target) {
        //万事不决先排序
        Arrays.sort(nums);
        //结果
        long sum = 0L;
        //左边边界坐标
        int left = 0;
        int right = nums.length - 1;
        //跳出标记
        out:
        //如果满足
        while (left < nums.length - 1) {
            //如果不满足条件
            while (nums[left] + nums[right] > target) {
                //右边收缩,如果左右边界重合则跳过
                if (left >= --right) {
                    //彻底跳出
                    break out;
                }
            }
            //计算本次结果
            sum += right - left;
            //左边的边界进位
            left++;
        }
        //最后取模,返回
        return (int) (sum % 1000000007L);
    }

    public static void main(String[] args) {
        System.out.println(new Code17().purchasePlans(new int[]{2, 2, 1, 9}, 10));
    }

}
