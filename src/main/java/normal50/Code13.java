package normal50;

import java.util.HashMap;
import java.util.Map;

/**
 * 1814. 统计一个数组中好对子的数目
 * 算术评级: 5
 * 第 49 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1738
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
 * <p>
 * 0 <= i < j < nums.length
 * nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
 * 请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [42,11,1,97]
 * 输出：2
 * 解释：两个坐标对为：
 * - (0,3)：42 + rev(97) = 42 + 79 = 121, 97 + rev(42) = 97 + 24 = 121 。
 * - (1,2)：11 + rev(1) = 11 + 1 = 12, 1 + rev(11) = 1 + 11 = 12 。
 * 示例 2：
 * <p>
 * 输入：nums = [13,10,35,24,76]
 * 输出：4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 0 <= nums[i] <= 109
 */
public class Code13 {

    public int countNicePairs(int[] nums) {

        /**
         * 构建
         */

        //统计按照差分组的数量
        Map<Integer, Integer> countMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //数字
            int num = nums[i];
            //翻转
            int revNum = rev(num);
            //翻转后二者差
            int other = num - revNum;
            //+1
            countMap.put(other, countMap.getOrDefault(other, 0) + 1);
        }

        /**
         * 计算
         */

        //结果
        long result = 0;
        //循环
        for (Integer count : countMap.values()) {
            //计算本分组结果
            result = (result + count(count));
        }
        //返回
        return (int) (result % 1000000007L);
    }

    //翻转数字
    private int rev(int num) {
        //数字
        int revNum = 0;
        //循环
        while (num != 0) {
            //翻转
            revNum = revNum * 10 + num % 10;
            //下一位
            num /= 10;
        }
        //返回
        return revNum;
    }

    //根据同分组数量计算结果
    private long count(int count) {
        //长度
        long length = count - 1;
        //高斯算法
        return (1 + length) * (length / 2) + (length % 2 == 0 ? 0 : length / 2 + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countNicePairs(new int[]{13, 10, 35, 24, 76}));
    }

}