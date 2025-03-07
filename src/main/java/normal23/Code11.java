package normal23;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-08-22
 * LCR 004. 只出现一次的数字 II
 * 中等
 * 145
 * 相关企业
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [0,1,0,1,0,1,100]
 * 输出：100
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 3 * 104
 * -231 <= nums[i] <= 231 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 * <p>
 * <p>
 * 进阶：你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 137 题相同：https://leetcode-cn.com/problems/single-number-ii/
 */
public class Code11 {

    public int singleNumber(int[] nums) {
        //缓存
        Set<Integer> set = new HashSet<>();
        //和
        long sum = 0L;
        //第一次和
        long maxSum = 0L;
        //循环
        for (int num : nums) {
            //叠加
            sum += num;
            //如果第一次出现
            if (set.contains(num) == false) {
                //叠加
                maxSum += num;
                //记录
                set.add(num);
            }
        }
        //全3次 减去 缺结果2次的 的结果除以2 就是目标结果
        return (int) ((maxSum * 3L - sum) / 2L);
    }

    public int star(int[] nums) {
        //初始化结果
        int result = 0;
        //循环
        for (int i = 0; i < 32; ++i) {
            int total = 0;
            //循环
            for (int num : nums) {
                //计算并叠加
                total = total + ((num >> i) & 1);
            }
            //如果不满足取余的条件
            if (total % 3 != 0) {
                //记录结果
                result |= (1 << i);
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().star(new int[]{2, 2, 2, 3}));
    }

}
