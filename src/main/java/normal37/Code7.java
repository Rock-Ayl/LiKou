package normal37;

/**
 * @Author ayl
 * 1685. 有序数组中差绝对值之和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个 非递减 有序整数数组 nums 。
 * <p>
 * 请你建立并返回一个整数数组 result，它跟 nums 长度相同，且result[i] 等于 nums[i] 与数组中所有其他元素差的绝对值之和。
 * <p>
 * 换句话说， result[i] 等于 sum(|nums[i]-nums[j]|) ，其中 0 <= j < nums.length 且 j != i （下标从 0 开始）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,5]
 * 输出：[4,3,5]
 * 解释：假设数组下标从 0 开始，那么
 * result[0] = |2-2| + |2-3| + |2-5| = 0 + 1 + 3 = 4，
 * result[1] = |3-2| + |3-3| + |3-5| = 1 + 0 + 2 = 3，
 * result[2] = |5-2| + |5-3| + |5-5| = 3 + 2 + 0 = 5。
 * 示例 2：
 * <p>
 * 输入：nums = [1,4,6,8,10]
 * 输出：[24,15,13,15,21]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 105
 * 1 <= nums[i] <= nums[i + 1] <= 104
 */
public class Code7 {

    public int[] getSumAbsoluteDifferences(int[] nums) {
        //初始化结果
        int[] result = new int[nums.length];
        //初始化前缀和
        int[] sumArr = new int[nums.length];
        //第一个
        sumArr[0] = nums[0];
        //循环
        for (int i = 1; i < sumArr.length; i++) {
            //求和o
            sumArr[i] = sumArr[i - 1] + nums[i];
        }
        //循环
        for (int i = 0; i < result.length; i++) {
            //分别计算左右
            int left = i > 0 ? (i * nums[i] - sumArr[i - 1]) : 0;
            int right = (i + 1 < result.length) ? (sumArr[sumArr.length - 1] - sumArr[i] - ((nums.length - i - 1) * nums[i])) : 0;
            //本次结果
            result[i] = left + right;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] sumAbsoluteDifferences = new Code7().getSumAbsoluteDifferences(new int[]{2, 3, 5});
        System.out.println();
    }


}
