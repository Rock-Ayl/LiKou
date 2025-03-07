package normal20;

/**
 * @Author ayl
 * @Date 2023-05-14
 * 2640. 一个数组所有前缀的分数
 * 定义一个数组 arr 的 转换数组 conver 为：
 * <p>
 * conver[i] = arr[i] + max(arr[0..i])，其中 max(arr[0..i]) 是满足 0 <= j <= i 的所有 arr[j] 中的最大值。
 * 定义一个数组 arr 的 分数 为 arr 转换数组中所有元素的和。
 * <p>
 * 给你一个下标从 0 开始长度为 n 的整数数组 nums ，请你返回一个长度为 n 的数组 ans ，其中 ans[i]是前缀 nums[0..i] 的分数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,3,7,5,10]
 * 输出：[4,10,24,36,56]
 * 解释：
 * 对于前缀 [2] ，转换数组为 [4] ，所以分数为 4 。
 * 对于前缀 [2, 3] ，转换数组为 [4, 6] ，所以分数为 10 。
 * 对于前缀 [2, 3, 7] ，转换数组为 [4, 6, 14] ，所以分数为 24 。
 * 对于前缀 [2, 3, 7, 5] ，转换数组为 [4, 6, 14, 12] ，所以分数为 36 。
 * 对于前缀 [2, 3, 7, 5, 10] ，转换数组为 [4, 6, 14, 12, 20] ，所以分数为 56 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,2,4,8,16]
 * 输出：[2,4,8,16,32,64]
 * 解释：
 * 对于前缀 [1] ，转换数组为 [2] ，所以分数为 2 。
 * 对于前缀 [1, 1]，转换数组为 [2, 2] ，所以分数为 4 。
 * 对于前缀 [1, 1, 2]，转换数组为 [2, 2, 4] ，所以分数为 8 。
 * 对于前缀 [1, 1, 2, 4]，转换数组为 [2, 2, 4, 8] ，所以分数为 16 。
 * 对于前缀 [1, 1, 2, 4, 8]，转换数组为 [2, 2, 4, 8, 16] ，所以分数为 32 。
 * 对于前缀 [1, 1, 2, 4, 8, 16]，转换数组为 [2, 2, 4, 8, 16, 32] ，所以分数为 64 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 109
 */
public class Code12 {

    public long[] findPrefixScore(int[] nums) {
        //初始化
        long[] resultArr = new long[nums.length];
        //最大数字
        long maxNum = nums[0];
        //和
        long sum = maxNum * 2L;
        //第一个
        resultArr[0] = sum;
        //循环
        for (int i = 1; i < nums.length; i++) {
            //最大值
            maxNum = Math.max(nums[i], maxNum);
            //叠加和
            sum += maxNum + nums[i];
            //记录
            resultArr[i] = sum;
        }
        //返回
        return resultArr;
    }

    public static void main(String[] args) {
        new Code12().findPrefixScore(new int[]{2, 3, 7, 5, 10});
    }
}
