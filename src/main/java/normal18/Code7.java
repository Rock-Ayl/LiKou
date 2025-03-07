package normal18;

/**
 * @Author ayl
 * @Date 2022-12-28
 * 1031. 两个非重叠子数组的最大和
 * 给出非负整数数组 A ，返回两个非重叠（连续）子数组中元素的最大和，子数组的长度分别为 L 和 M。（这里需要澄清的是，长为 L 的子数组可以出现在长为 M 的子数组之前或之后。）
 * <p>
 * 从形式上看，返回最大的 V，而 V = (A[i] + A[i+1] + ... + A[i+L-1]) + (A[j] + A[j+1] + ... + A[j+M-1]) 并满足下列条件之一：
 * <p>
 * <p>
 * <p>
 * 0 <= i < i + L - 1 < j < j + M - 1 < A.length, 或
 * 0 <= j < j + M - 1 < i < i + L - 1 < A.length.
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = [0,6,5,2,2,5,1,9,4], L = 1, M = 2
 * 输出：20
 * 解释：子数组的一种选择中，[9] 长度为 1，[6,5] 长度为 2。
 * 示例 2：
 * <p>
 * 输入：A = [3,8,1,3,2,1,8,9,0], L = 3, M = 2
 * 输出：29
 * 解释：子数组的一种选择中，[3,8,1] 长度为 3，[8,9] 长度为 2。
 * 示例 3：
 * <p>
 * 输入：A = [2,1,5,6,0,9,5,0,3,8], L = 4, M = 3
 * 输出：31
 * 解释：子数组的一种选择中，[5,6,0,9] 长度为 4，[0,3,8] 长度为 3。
 * <p>
 * <p>
 * 提示：
 * <p>
 * L >= 1
 * M >= 1
 * L + M <= A.length <= 1000
 * 0 <= A[i] <= 1000
 */
public class Code7 {

    //实现
    public int maxSumTwoNoOverlapExcute(int[] nums, int firstLen, int secondLen) {
        //最大可能
        int max = 0;
        //第一个窗口区间
        int firstStart = 0;
        int firstEnd = firstLen - 1;
        //第一个窗口区间和
        int firstSum = 0;
        //循环
        for (int i = firstStart; i <= firstEnd; i++) {
            //计算和
            firstSum += nums[i];
        }
        //第一个区间最后边结尾
        int firstLast = nums.length - secondLen;
        //如果第一个区间可以走下去
        while (firstEnd < firstLast) {
            //第二个窗口区间
            int secondStart = firstEnd + 1;
            int secondEnd = secondStart + secondLen - 1;
            //第二个窗口区间和
            int secondSum = 0;
            //循环
            for (int i = secondStart; i <= secondEnd; i++) {
                //计算和
                secondSum += nums[i];
            }
            //第二个区间最大可能
            int secondMax = 0;
            //第二个区间最后边结尾
            int secondLast = nums.length - 1;
            //如果第二个区间可以走下去
            while (secondEnd < secondLast) {
                //刷新第二个区间最大值
                secondMax = Math.max(secondMax, secondSum);
                //滑动第二个窗口
                secondSum = secondSum + nums[++secondEnd] - nums[secondStart++];
            }
            //刷新最大结果
            max = Math.max(max, firstSum + Math.max(secondMax, secondSum));
            //滑动第一个窗口
            firstSum = firstSum + nums[++firstEnd] - nums[firstStart++];
        }
        //返回
        return max;
    }

    public int maxSumTwoNoOverlap(int[] nums, int firstLen, int secondLen) {
        //实现
        return Math.max(maxSumTwoNoOverlapExcute(nums, firstLen, secondLen), maxSumTwoNoOverlapExcute(nums, secondLen, firstLen));
    }

    public static void main(String[] args) {
        System.out.println(new Code7().maxSumTwoNoOverlap(new int[]{0, 6, 5, 2, 2, 5, 1, 9, 4}, 1, 2));
    }
}
