package normal48;

/**
 * @Author ayl
 * @Date 2025-12-09
 * 1764. 通过连接另一个数组的子数组得到一个数组
 * 算术评级: 4
 * 第 46 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1588
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的二维整数数组 groups ，同时给你一个整数数组 nums 。
 * <p>
 * 你是否可以从 nums 中选出 n 个 不相交 的子数组，使得第 i 个子数组与 groups[i] （下标从 0 开始）完全相同，且如果 i > 0 ，那么第 (i-1) 个子数组在 nums 中出现的位置在第 i 个子数组前面。（也就是说，这些子数组在 nums 中出现的顺序需要与 groups 顺序相同）
 * <p>
 * 如果你可以找出这样的 n 个子数组，请你返回 true ，否则返回 false 。
 * <p>
 * 如果不存在下标为 k 的元素 nums[k] 属于不止一个子数组，就称这些子数组是 不相交 的。子数组指的是原数组中连续元素组成的一个序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：groups = [[1,-1,-1],[3,-2,0]], nums = [1,-1,0,1,-1,-1,3,-2,0]
 * 输出：true
 * 解释：你可以分别在 nums 中选出第 0 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 和第 1 个子数组 [1,-1,0,1,-1,-1,3,-2,0] 。
 * 这两个子数组是不相交的，因为它们没有任何共同的元素。
 * 示例 2：
 * <p>
 * 输入：groups = [[10,-2],[1,2,3,4]], nums = [1,2,3,4,10,-2]
 * 输出：false
 * 解释：选择子数组 [1,2,3,4,10,-2] 和 [1,2,3,4,10,-2] 是不正确的，因为它们出现的顺序与 groups 中顺序不同。
 * [10,-2] 必须出现在 [1,2,3,4] 之前。
 * 示例 3：
 * <p>
 * 输入：groups = [[1,2,3],[3,4]], nums = [7,7,1,2,3,4,7,7]
 * 输出：false
 * 解释：选择子数组 [7,7,1,2,3,4,7,7] 和 [7,7,1,2,3,4,7,7] 是不正确的，因为它们不是不相交子数组。
 * 它们有一个共同的元素 nums[4] （下标从 0 开始）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * groups.length == n
 * 1 <= n <= 103
 * 1 <= groups[i].length, sum(groups[i].length) <= 103
 * 1 <= nums.length <= 103
 * -107 <= groups[i][j], nums[k] <= 107
 */
public class Code19 {

    public boolean canChoose(int[][] groups, int[] nums) {
        //索引
        int numsIndex = 0;
        //循环
        for (int[] group : groups) {
            //循环是否满足
            while (eq(group, nums, numsIndex) == false) {
                //+1,如果到头了
                if (++numsIndex >= nums.length) {
                    //不行
                    return false;
                }
            }
            //跳过本组
            numsIndex += group.length;
        }
        //默认行
        return true;
    }

    //匹配是否相同
    private boolean eq(int[] group, int[] nums, int numsIndex) {
        //如果越界
        if (numsIndex + group.length > nums.length) {
            //不行
            return false;
        }
        //分组索引
        int groupIndex = 0;
        //如果满足
        while (groupIndex < group.length) {
            //如果不同
            if (group[groupIndex] != nums[numsIndex]) {
                //不行
                return false;
            }
            //下一位
            groupIndex++;
            numsIndex++;
        }
        //判断结果
        return group.length == groupIndex;
    }

    public static void main(String[] args) {
        /*

        System.out.println(new Code19().canChoose(new int[][]{
                new int[]{1, -1, -1},
                new int[]{3, -2, 0}
        }, new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0}));

         */

        System.out.println(new Code19().canChoose(new int[][]{
                new int[]{10, -2},
                new int[]{1, 2, 3, 4}
        }, new int[]{1, 2, 3, 4, 10, -2}));

    }

}
