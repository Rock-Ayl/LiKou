package normal49;

/**
 * @Author ayl
 * @Date 2025-12-25
 * 3152. 特殊数组 II
 * 算术评级: 4
 * 第 398 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1523
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 如果数组的每一对相邻元素都是两个奇偶性不同的数字，则该数组被认为是一个 特殊数组 。
 * <p>
 * 你有一个整数数组 nums 和一个二维整数矩阵 queries，对于 queries[i] = [fromi, toi]，请你帮助你检查 子数组 nums[fromi..toi] 是不是一个 特殊数组 。
 * <p>
 * 返回布尔数组 answer，如果 nums[fromi..toi] 是特殊数组，则 answer[i] 为 true ，否则，answer[i] 为 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [3,4,1,2,6], queries = [[0,4]]
 * <p>
 * 输出：[false]
 * <p>
 * 解释：
 * <p>
 * 子数组是 [3,4,1,2,6]。2 和 6 都是偶数。
 * <p>
 * 示例 2：
 * <p>
 * 输入：nums = [4,3,1,6], queries = [[0,2],[2,3]]
 * <p>
 * 输出：[false,true]
 * <p>
 * 解释：
 * <p>
 * 子数组是 [4,3,1]。3 和 1 都是奇数。因此这个查询的答案是 false。
 * 子数组是 [1,6]。只有一对：(1,6)，且包含了奇偶性不同的数字。因此这个查询的答案是 true。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 105
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= queries[i][0] <= queries[i][1] <= nums.length - 1
 */
public class Code3 {

    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        //前缀和
        int[] sumArr = new int[nums.length];
        //循环
        for (int i = 1; i < nums.length; i++) {
            //如果与前一个奇偶不同
            if (nums[i] % 2 != nums[i - 1] % 2) {
                //叠加
                sumArr[i] = sumArr[i - 1] + 1;
            }
        }
        //结果
        boolean[] result = new boolean[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //计算本次
            result[i] = count(sumArr, queries[i][0], queries[i][1]);
        }
        //返回
        return result;
    }

    //计算区间是否满足结果
    private boolean count(int[] sumArr, int left, int right) {
        //判断
        return sumArr[right] - sumArr[left] == right - left;
    }

    public static void main(String[] args) {
        boolean[] arraySpecial = new Code3().isArraySpecial(
                new int[]{4, 3, 1, 6},
                new int[][]{
                        new int[]{0, 2},
                        new int[]{2, 3}
                });
        System.out.println();
    }

}
