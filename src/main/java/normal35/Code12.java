package normal35;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-09-25
 * 2587. 重排数组以得到最大前缀分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的整数数组 nums 。你可以将 nums 中的元素按 任意顺序 重排（包括给定顺序）。
 * <p>
 * 令 prefix 为一个数组，它包含了 nums 重新排列后的前缀和。换句话说，prefix[i] 是 nums 重新排列后下标从 0 到 i 的元素之和。nums 的 分数 是 prefix 数组中正整数的个数。
 * <p>
 * 返回可以得到的最大分数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,-1,0,1,-3,3,-3]
 * 输出：6
 * 解释：数组重排为 nums = [2,3,1,-1,-3,0,-3] 。
 * prefix = [2,5,6,5,2,2,-1] ，分数为 6 。
 * 可以证明 6 是能够得到的最大分数。
 * 示例 2：
 * <p>
 * 输入：nums = [-2,-3,0]
 * 输出：0
 * 解释：不管怎么重排数组得到的分数都是 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -106 <= nums[i] <= 106
 */
public class Code12 {

    public int maxScore(int[] nums) {
        //排序
        Arrays.sort(nums);
        //和
        long sum = 0L;
        //倒叙循环
        for (int i = nums.length - 1; i >= 0; i--) {
            //叠加本次和
            sum += nums[i];
            //如果和不是正整数了
            if (sum <= 0) {
                //直接返回结果
                return nums.length - 1 - i;
            }
        }
        //默认全部长度
        return nums.length;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().maxScore(new int[]{-687767, -860350, 950296, 52109, 510127, 545329, -291223, -966728, 852403, 828596, 456730, -483632, -529386, 356766, 147293, 572374, 243605, 931468, 641668, 494446}));
    }

}
