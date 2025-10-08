package difficult4;

/**
 * @Author ayl
 * @Date 2025-10-08
 * 1537. 最大得分
 * 算术评级: 8
 * 第 200 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1961
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你有两个 有序 且数组内元素互不相同的数组 nums1 和 nums2 。
 * <p>
 * 一条 合法路径 定义如下：
 * <p>
 * 选择数组 nums1 或者 nums2 开始遍历（从下标 0 处开始）。
 * 从左到右遍历当前数组。
 * 如果你遇到了 nums1 和 nums2 中都存在的值，那么你可以切换路径到另一个数组对应数字处继续遍历（但在合法路径中重复数字只会被统计一次）。
 * 得分 定义为合法路径中不同数字的和。
 * <p>
 * 请你返回 所有可能 合法路径 中的最大得分。由于答案可能很大，请你将它对 10^9 + 7 取余后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：nums1 = [2,4,5,8,10], nums2 = [4,6,8,9]
 * 输出：30
 * 解释：合法路径包括：
 * [2,4,5,8,10], [2,4,5,8,9], [2,4,6,8,9], [2,4,6,8,10],（从 nums1 开始遍历）
 * [4,6,8,9], [4,5,8,10], [4,5,8,9], [4,6,8,10]  （从 nums2 开始遍历）
 * 最大得分为上图中的绿色路径 [2,4,6,8,10] 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [1,3,5,7,9], nums2 = [3,5,100]
 * 输出：109
 * 解释：最大得分由路径 [1,3,5,100] 得到。
 * 示例 3：
 * <p>
 * 输入：nums1 = [1,2,3,4,5], nums2 = [6,7,8,9,10]
 * 输出：40
 * 解释：nums1 和 nums2 之间无相同数字。
 * 最大得分由路径[6,7,8,9,10]得到。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * 1 <= nums1[i], nums2[i] <= 107
 * nums1 和 nums2 都是严格递增的数组。
 */
public class Code14 {

    public int maxSum(int[] nums1, int[] nums2) {
        //常量
        final int MOD = 1000000007;
        //前缀和
        long[] num1SumArr = new long[nums1.length];
        long[] num2SumArr = new long[nums2.length];
        //数组执行的索引
        int num1Index = 0;
        int num2Index = 0;
        //如果都还没有执行完
        while (num1Index < nums1.length && num2Index < nums2.length) {
            //分别获取数字
            long num1 = nums1[num1Index];
            long num2 = nums2[num2Index];
            //三种情况
            if (num1 > num2) {
                //叠加
                long sum = (num2 + (num2Index > 0 ? num2SumArr[num2Index - 1] : 0));
                //记录和,并+1
                num2SumArr[num2Index++] = sum;
            } else if (num1 < num2) {
                //叠加
                long sum = (num1 + (num1Index > 0 ? num1SumArr[num1Index - 1] : 0));
                //记录和,并+1
                num1SumArr[num1Index++] = sum;
            } else {
                //叠加
                long sum2 = (num2 + (num2Index > 0 ? num2SumArr[num2Index - 1] : 0));
                long sum1 = (num1 + (num1Index > 0 ? num1SumArr[num1Index - 1] : 0));
                //最大叠加和
                long maxSum = Math.max(sum1, sum2);
                //记录和,并+1
                num1SumArr[num1Index++] = maxSum;
                num2SumArr[num2Index++] = maxSum;
            }
        }
        //如果1还没执行完
        while (num1Index < nums1.length) {
            //获取数字
            long num1 = nums1[num1Index];
            //叠加
            long sum = (num1 + (num1Index > 0 ? num1SumArr[num1Index - 1] : 0));
            //记录和,并+1
            num1SumArr[num1Index++] = sum;
        }
        //如果2还没执行完
        while (num2Index < nums2.length) {
            //获取数字
            long num2 = nums2[num2Index];
            //叠加
            long sum = (num2 + (num2Index > 0 ? num2SumArr[num2Index - 1] : 0));
            //记录和,并+1
            num2SumArr[num2Index++] = sum;
        }
        //返回最大结果
        return (int) (Math.max(num1SumArr[num1SumArr.length - 1], num2SumArr[num2SumArr.length - 1]) % MOD);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maxSum(new int[]{2, 4, 5, 8, 10}, new int[]{4, 6, 8, 9}));
    }

}