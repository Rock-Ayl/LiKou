package easy11;

/**
 * @Author ayl
 * @Date 2021-08-24
 * 1920. 基于排列构建数组
 * 给你一个 从 0 开始的排列 nums（下标也从 0 开始）。请你构建一个 同样长度 的数组 ans ，其中，对于每个 i（0 <= i < nums.length），都满足 ans[i] = nums[nums[i]] 。返回构建好的数组 ans 。
 * <p>
 * 从 0 开始的排列 nums 是一个由 0 到 nums.length - 1（0 和 nums.length - 1 也包含在内）的不同整数组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [0,2,1,5,3,4]
 * 输出：[0,1,2,4,5,3]
 * 解释：数组 ans 构建如下：
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[0], nums[2], nums[1], nums[5], nums[3], nums[4]]
 * = [0,1,2,4,5,3]
 * 示例 2：
 * <p>
 * 输入：nums = [5,0,1,2,3,4]
 * 输出：[4,5,0,1,2,3]
 * 解释：数组 ans 构建如下：
 * ans = [nums[nums[0]], nums[nums[1]], nums[nums[2]], nums[nums[3]], nums[nums[4]], nums[nums[5]]]
 * = [nums[5], nums[0], nums[1], nums[2], nums[3], nums[4]]
 * = [4,5,0,1,2,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 1000
 * 0 <= nums[i] < nums.length
 * nums 中的元素 互不相同
 */
public class Code7 {

    public int[] buildArray(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i : new Code7().buildArray(new int[]{0, 2, 1, 5, 3, 4})) {
            System.out.println(i);
        }
    }

}
