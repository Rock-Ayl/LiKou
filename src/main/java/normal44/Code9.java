package normal44;

/**
 * @Author ayl
 * @Date 2025-06-26
 * 1936. 新增的最少台阶数
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 严格递增 的整数数组 rungs ，用于表示梯子上每一台阶的 高度 。当前你正站在高度为 0 的地板上，并打算爬到最后一个台阶。
 * <p>
 * 另给你一个整数 dist 。每次移动中，你可以到达下一个距离你当前位置（地板或台阶）不超过 dist 高度的台阶。当然，你也可以在任何正 整数 高度处插入尚不存在的新台阶。
 * <p>
 * 返回爬到最后一阶时必须添加到梯子上的 最少 台阶数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：rungs = [1,3,5,10], dist = 2
 * 输出：2
 * 解释：
 * 现在无法到达最后一阶。
 * 在高度为 7 和 8 的位置增设新的台阶，以爬上梯子。
 * 梯子在高度为 [1,3,5,7,8,10] 的位置上有台阶。
 * 示例 2：
 * <p>
 * 输入：rungs = [3,6,8,10], dist = 3
 * 输出：0
 * 解释：
 * 这个梯子无需增设新台阶也可以爬上去。
 * 示例 3：
 * <p>
 * 输入：rungs = [3,4,6,7], dist = 2
 * 输出：1
 * 解释：
 * 现在无法从地板到达梯子的第一阶。
 * 在高度为 1 的位置增设新的台阶，以爬上梯子。
 * 梯子在高度为 [1,3,4,6,7] 的位置上有台阶。
 * 示例 4：
 * <p>
 * 输入：rungs = [5], dist = 10
 * 输出：0
 * 解释：这个梯子无需增设新台阶也可以爬上去。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= rungs.length <= 105
 * 1 <= rungs[i] <= 109
 * 1 <= dist <= 109
 * rungs 严格递增
 */
public class Code9 {

    public int addRungs(int[] rungs, int dist) {
        //递归实现
        return count(rungs, 0, 0, dist, 0);
    }

    //递归
    private int count(int[] rungs, int index, int last, int dist, int add) {
        //如果到头了
        if (index >= rungs.length) {
            //返回
            return add;
        }
        //当前
        int rung = rungs[index];
        //缺失了多少
        int other = rung - last - dist;
        //如果存在
        if (other > 0) {
            //叠加本次操作
            add += other / dist + (other % dist != 0 ? 1 : 0);
        }
        //返回
        return count(rungs, index + 1, rung, dist, add);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().addRungs(new int[]{1, 3, 5, 10}, 2));
    }

}
