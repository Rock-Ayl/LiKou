package normal48;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-12-02
 * 3759. 统计合格元素的数目
 * 算术评级: 3
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个整数 k。
 * <p>
 * 如果数组 nums 中的某个元素满足以下条件，则称其为 合格元素：存在 至少 k 个元素 严格大于 它。
 * <p>
 * 返回一个整数，表示数组 nums 中合格元素的总数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [3,1,2], k = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * 元素 1 和 2 均有至少 k = 1 个元素大于它们。
 * 没有元素比 3 更大。因此答案是 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： nums = [5,5,5], k = 2
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 由于所有元素都等于 5，没有任何元素比其他元素大。因此答案是 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 105
 * 1 <= nums[i] <= 109
 * 0 <= k < n
 */
public class Code13 {

    public int countElements(int[] nums, int k) {
        //如果不可能有
        if (nums.length <= k) {
            //过
            return 0;
        }
        //如果特殊情况
        if (k == 0) {
            //返回
            return nums.length;
        }
        //排序
        Arrays.sort(nums);
        //数量
        int count = 0;
        //最大允许的长度
        int length = nums.length - k;
        //连击
        int hit = 0;
        //循环
        for (int i = 0; i < length; i++) {
            //获取当前
            int num = nums[i];
            //判断是 check or hit
            if (nums[i + 1] == num) {
                //+1
                hit++;
            } else {
                //当前拥有数量
                int hadCount = nums.length - i - 1;
                //如果满足
                if (hadCount >= k) {
                    //叠加
                    count += hit + 1;
                    //重置
                    hit = 0;
                } else {
                    //彻底结束
                    break;
                }
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countElements(new int[]{3, 1, 2}, 1));
    }

}
