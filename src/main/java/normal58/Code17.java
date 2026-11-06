package normal58;

/**
 * 3653. 区间乘法查询后的异或 I
 * 算术评级: 3
 * 第 463 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1556
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 nums 和一个大小为 q 的二维整数数组 queries，其中 queries[i] = [li, ri, ki, vi]。
 * <p>
 * 对于每个查询，按以下步骤执行操作：
 * <p>
 * 设定 idx = li。
 * 当 idx <= ri 时：
 * 更新：nums[idx] = (nums[idx] * vi) % (109 + 7)
 * 将 idx += ki。
 * 在处理完所有查询后，返回数组 nums 中所有元素的 按位异或 结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,1,1], queries = [[0,2,1,4]]
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 唯一的查询 [0, 2, 1, 4] 将下标 0 到下标 2 的每个元素乘以 4。
 * 数组从 [1, 1, 1] 变为 [4, 4, 4]。
 * 所有元素的异或为 4 ^ 4 ^ 4 = 4。
 * 示例 2：
 * <p>
 * 输入： nums = [2,3,1,5,4], queries = [[1,4,2,3],[0,2,1,2]]
 * <p>
 * 输出： 31
 * <p>
 * 解释：
 * <p>
 * 第一个查询 [1, 4, 2, 3] 将下标 1 和 3 的元素乘以 3，数组变为 [2, 9, 1, 15, 4]。
 * 第二个查询 [0, 2, 1, 2] 将下标 0、1 和 2 的元素乘以 2，数组变为 [4, 18, 2, 15, 4]。
 * 所有元素的异或为 4 ^ 18 ^ 2 ^ 15 ^ 4 = 31。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == nums.length <= 103
 * 1 <= nums[i] <= 109
 * 1 <= q == queries.length <= 103
 * queries[i] = [li, ri, ki, vi]
 * 0 <= li <= ri < n
 * 1 <= ki <= n
 * 1 <= vi <= 105
 */
public class Code17 {

    public int xorAfterQueries(int[] nums, int[][] queries) {
        //循环
        for (int i = 0; i < queries.length; i++) {
            //更新
            update(nums, queries[i][0], queries[i][1], queries[i][2], queries[i][3]);
        }
        //结果
        long result = 0L;
        //循环
        for (int num : nums) {
            //异或
            result ^= num;
        }
        //返回
        return (int) result;
    }

    //更新本次
    private void update(int[] nums, int li, int ri, int ki, int vi) {
        //循环
        for (int i = li; i <= ri; i += ki) {
            //更新
            nums[i] = (int) ((((long) nums[i]) * vi) % 1000000007L);
        }
    }

    public static void main(String[] args) {
        int i = new Code17().xorAfterQueries(new int[]{1, 1, 1}, new int[][]{{0, 2, 1, 4}});
        System.out.println();
    }

}
