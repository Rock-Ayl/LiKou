package normal46;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-09-20
 * 3034. 匹配模式数组的子数组数目 I
 * 算术评级: 3
 * 第 384 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1384
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums ，和一个下标从 0 开始长度为 m 的整数数组 pattern ，pattern 数组只包含整数 -1 ，0 和 1 。
 * <p>
 * 大小为 m + 1 的子数组 nums[i..j] 如果对于每个元素 pattern[k] 都满足以下条件，那么我们说这个子数组匹配模式数组 pattern ：
 * <p>
 * 如果 pattern[k] == 1 ，那么 nums[i + k + 1] > nums[i + k]
 * 如果 pattern[k] == 0 ，那么 nums[i + k + 1] == nums[i + k]
 * 如果 pattern[k] == -1 ，那么 nums[i + k + 1] < nums[i + k]
 * 请你返回匹配 pattern 的 nums 子数组的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5,6], pattern = [1,1]
 * 输出：4
 * 解释：模式 [1,1] 说明我们要找的子数组是长度为 3 且严格上升的。在数组 nums 中，子数组 [1,2,3] ，[2,3,4] ，[3,4,5] 和 [4,5,6] 都匹配这个模式。
 * 所以 nums 中总共有 4 个子数组匹配这个模式。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,4,1,3,5,5,3], pattern = [1,0,-1]
 * 输出：2
 * 解释：这里，模式数组 [1,0,-1] 说明我们需要找的子数组中，第一个元素小于第二个元素，第二个元素等于第三个元素，第三个元素大于第四个元素。在 nums 中，子数组 [1,4,4,1] 和 [3,5,5,3] 都匹配这个模式。
 * 所以 nums 中总共有 2 个子数组匹配这个模式。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n == nums.length <= 100
 * 1 <= nums[i] <= 109
 * 1 <= m == pattern.length < n
 * -1 <= pattern[i] <= 1
 */
public class Code13 {

    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        //目标hash和
        int targetHashSum = Arrays.stream(pattern).sum();
        //当前hash和
        int hashSum = 0;
        //结果
        int result = 0;
        //转换数组
        int[] arr = new int[nums.length];
        //循环
        for (int i = 1; i < arr.length; i++) {
            //2个数字
            int one = nums[i];
            int two = nums[i - 1];
            //判断
            if (one == two) {
                //记录
                arr[i] = 0;
            } else if (one > two) {
                //记录
                arr[i] = 1;
            } else {
                //记录
                arr[i] = -1;
            }
            //叠加hash和
            hashSum += arr[i];
            //如果需要删除hash和
            if (i - pattern.length > 0) {
                //删除hash和
                hashSum -= arr[i - pattern.length];
            }
            //排除第一个0,如果hash一样
            if (i - pattern.length >= 0 && hashSum == targetHashSum) {
                //计算本次
                result += compareTo(arr, pattern, i);
            }
        }
        //返回
        return result;
    }

    //计算是否一致
    private int compareTo(int[] arr, int[] pattern, int index) {
        //索引
        int patternLastIndex = pattern.length - 1;
        //循环
        while (patternLastIndex >= 0) {
            //判断不同,并-1
            if (arr[index--] != pattern[patternLastIndex--]) {
                //过
                return 0;
            }
        }
        //默认
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countMatchingSubarrays(new int[]{985443402, 348396760, 348396760, 41818842}, new int[]{0, -1}));
    }

}
