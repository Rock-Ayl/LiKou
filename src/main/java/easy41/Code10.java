package easy41;

/**
 * @Author ayl
 * @Date 2025-09-14
 * 3678. 大于平均值的最小未出现正整数
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 nums。
 * <p>
 * 返回 nums 中 严格大于 nums 中所有元素 平均值 的 最小未出现正整数。
 * <p>
 * 数组的 平均值 定义为数组中所有元素的总和除以元素的数量。
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [3,5]
 * <p>
 * 输出: 6
 * <p>
 * 解释:
 * <p>
 * nums 的平均值是 (3 + 5) / 2 = 8 / 2 = 4 。
 * 大于 4 的最小未出现正整数是 6。
 * 示例 2:
 * <p>
 * 输入: nums = [-1,1,2]
 * <p>
 * 输出: 3
 * <p>
 * 解释:
 * <p>
 * nums 的平均值是 (-1 + 1 + 2) / 3 = 2 / 3 = 0.667 。
 * 大于 0.667 的最小未出现正整数是 3 。
 * 示例 3:
 * <p>
 * 输入: nums = [4,-1]
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * nums 的平均值是 (4 + (-1)) / 2 = 3 / 2 = 1.50。
 * 大于 1.50 的最小未出现正整数是 2。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 100
 * -100 <= nums[i] <= 100
 */
public class Code10 {

    public int smallestAbsent(int[] nums) {
        //结果
        int sum = 0;
        //缓存
        int[] arr = new int[202];
        //循环
        for (int num : nums) {
            //+1
            arr[num + 100]++;
            //叠加
            sum += num;
        }
        //平均值
        int target = sum / nums.length;
        //循环
        for (int i = Math.max(target + 101, 101); i < arr.length; i++) {
            //如果是结果
            if (arr[i] == 0) {
                //返回
                return i - 100;
            }
        }
        //默认
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().smallestAbsent(new int[]{98,100}));
    }

}
