package normal18;

/**
 * @Author ayl
 * @Date 2023-01-20
 * 2221. 数组的三角和
 * 给你一个下标从 0 开始的整数数组 nums ，其中 nums[i] 是 0 到 9 之间（两者都包含）的一个数字。
 * <p>
 * nums 的 三角和 是执行以下操作以后最后剩下元素的值：
 * <p>
 * nums 初始包含 n 个元素。如果 n == 1 ，终止 操作。否则，创建 一个新的下标从 0 开始的长度为 n - 1 的整数数组 newNums 。
 * 对于满足 0 <= i < n - 1 的下标 i ，newNums[i] 赋值 为 (nums[i] + nums[i+1]) % 10 ，% 表示取余运算。
 * 将 newNums 替换 数组 nums 。
 * 从步骤 1 开始 重复 整个过程。
 * 请你返回 nums 的三角和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums = [1,2,3,4,5]
 * 输出：8
 * 解释：
 * 上图展示了得到数组三角和的过程。
 * 示例 2：
 * <p>
 * 输入：nums = [5]
 * 输出：5
 * 解释：
 * 由于 nums 中只有一个元素，数组的三角和为这个元素自己。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] <= 9
 */
public class Code16 {

    public int triangularSum(int[] nums) {
        //次数
        int count = nums.length - 1;
        //如果没处理完毕
        while (count > 0) {
            //循环
            for (int i = 0; i < count; i++) {
                //计算下一个并覆盖给i
                nums[i] = (nums[i] + nums[i + 1]) % 10;
            }
            //下一步
            count--;
        }
        //返回最终结果
        return nums[0];
    }

    public static void main(String[] args) {
        System.out.println(new Code16().triangularSum(new int[]{1, 2, 3, 4, 5}));
    }

}
