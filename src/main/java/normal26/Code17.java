package normal26;

/**
 * @Author ayl
 * @Date 2023-12-05
 * LCR 104. 组合总和 Ⅳ
 * 中等
 * 73
 * 相关企业
 * 给定一个由 不同 正整数组成的数组 nums ，和一个目标整数 target 。请从 nums 中找出并返回总和为 target 的元素组合的个数。数组中的数字可以在一次排列中出现任意次，但是顺序不同的序列被视作不同的组合。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3], target = 4
 * 输出：7
 * 解释：
 * 所有可能的组合为：
 * (1, 1, 1, 1)
 * (1, 1, 2)
 * (1, 2, 1)
 * (1, 3)
 * (2, 1, 1)
 * (2, 2)
 * (3, 1)
 * 请注意，顺序不同的序列被视作不同的组合。
 * 示例 2：
 * <p>
 * 输入：nums = [9], target = 3
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 1000
 * nums 中的所有元素 互不相同
 * 1 <= target <= 1000
 * <p>
 * <p>
 * 进阶：如果给定的数组中含有负数会发生什么？问题会产生何种变化？如果允许负数出现，需要向题目中添加哪些限制条件？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 377 题相同：https://leetcode-cn.com/problems/combination-sum-iv/
 */
public class Code17 {

    public int combinationSum4(int[] nums, int target) {
        //初始化缓存
        int[] arr = new int[target + 1];
        //默认一个不选是0
        arr[0] = 1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //循环
            for (int num : nums) {
                //如果满足
                if (i >= num) {
                    //叠加
                    arr[i] += arr[i - num];
                }
            }
        }
        //返回结果
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code17().combinationSum4(new int[]{1, 2, 3}, 4));
    }

}
