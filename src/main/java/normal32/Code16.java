package normal32;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-06-11
 * 1968. 构造元素不等于两相邻元素平均值的数组
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 下标从 0 开始 的数组 nums ，数组由若干 互不相同的 整数组成。你打算重新排列数组中的元素以满足：重排后，数组中的每个元素都 不等于 其两侧相邻元素的 平均值 。
 * <p>
 * 更公式化的说法是，重新排列的数组应当满足这一属性：对于范围 1 <= i < nums.length - 1 中的每个 i ，(nums[i-1] + nums[i+1]) / 2 不等于 nums[i] 均成立 。
 * <p>
 * 返回满足题意的任一重排结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：[1,2,4,5,3]
 * 解释：
 * i=1, nums[i] = 2, 两相邻元素平均值为 (1+4) / 2 = 2.5
 * i=2, nums[i] = 4, 两相邻元素平均值为 (2+5) / 2 = 3.5
 * i=3, nums[i] = 5, 两相邻元素平均值为 (4+3) / 2 = 3.5
 * 示例 2：
 * <p>
 * 输入：nums = [6,2,0,9,7]
 * 输出：[9,7,6,2,0]
 * 解释：
 * i=1, nums[i] = 7, 两相邻元素平均值为 (9+6) / 2 = 7.5
 * i=2, nums[i] = 6, 两相邻元素平均值为 (7+2) / 2 = 4.5
 * i=3, nums[i] = 2, 两相邻元素平均值为 (6+0) / 2 = 3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= nums.length <= 105
 * 0 <= nums[i] <= 105
 */
public class Code16 {

    public int[] rearrangeArray(int[] nums) {
        //为数组排序
        Arrays.sort(nums);
        //初始化目标结果
        int[] result = new int[nums.length];
        //左右双边
        int left = 0;
        int right = nums.length - 1;
        //循环
        for (int i = 0; i < result.length; i++) {
            //根据索引奇偶性,判断是用左边还是右边
            result[i] = i % 2 == 0 ? nums[left++] : nums[right--];
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code16().rearrangeArray(new int[]{6, 2, 0, 9, 7});
        System.out.println();
    }
}
