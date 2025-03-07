package easy35;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-14
 * 2980. 检查按位或是否存在尾随零
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 正整数 数组 nums 。
 * <p>
 * 你需要检查是否可以从数组中选出 两个或更多 元素，满足这些元素的按位或运算（ OR）结果的二进制表示中 至少 存在一个尾随零。
 * <p>
 * 例如，数字 5 的二进制表示是 "101"，不存在尾随零，而数字 4 的二进制表示是 "100"，存在两个尾随零。
 * <p>
 * 如果可以选择两个或更多元素，其按位或运算结果存在尾随零，返回 true；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：true
 * 解释：如果选择元素 2 和 4，按位或运算结果是 6，二进制表示为 "110" ，存在一个尾随零。
 * 示例 2：
 * <p>
 * 输入：nums = [2,4,8,16]
 * 输出：true
 * 解释：如果选择元素 2 和 4，按位或运算结果是 6，二进制表示为 "110"，存在一个尾随零。
 * 其他按位或运算结果存在尾随零的可能选择方案包括：(2, 8), (2, 16), (4, 8), (4, 16), (8, 16), (2, 4, 8), (2, 4, 16), (2, 8, 16), (4, 8, 16), 以及 (2, 4, 8, 16) 。
 * 示例 3：
 * <p>
 * 输入：nums = [1,3,5,7,9]
 * 输出：false
 * 解释：不存在按位或运算结果存在尾随零的选择方案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Code20 {

    public boolean hasTrailingZeros(int[] nums) {
        //默认
        return Arrays.stream(nums).boxed().filter(p -> p % 2 == 0).collect(Collectors.toList()).size() > 1;
    }

    public static void main(String[] args) {

        new Code20().hasTrailingZeros(new int[]{1, 3, 5, 7, 9});

        int a = 1;
        int b = 9;
        int c = a ^ b;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(Integer.toBinaryString(a));
        System.out.println(Integer.toBinaryString(b));
        System.out.println(Integer.toBinaryString(c));

    }

}
