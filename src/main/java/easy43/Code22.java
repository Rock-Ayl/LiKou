package easy43;

/**
 * 3996. 偶数次骑士移动
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个整数数组 start 和 target，每个数组的形式均为 [x, y]，表示标准 8 x 8 国际象棋棋盘上的一个格子。
 * <p>
 * 如果骑士可以用 偶数 次移动从 start 到达 target，则返回 true；否则返回 false。
 * <p>
 * 注意：骑士的一次合法移动是：沿一个方向移动两格，再沿与其垂直的方向移动一格。下图展示了骑士从一个格子出发时所有 8 种可能的移动方式。
 * <p>
 * <p>
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： start = [1,1], target = [2,2]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 一种可行的移动序列为 (1, 1) -> (3, 2) -> (2, 4) -> (4, 3) -> (2, 2)。
 * <p>
 * 骑士经过 4 次移动到达目标位置，4 是偶数。因此答案为 true。
 * <p>
 * 示例 2：
 * <p>
 * 输入： start = [4,5], target = [6,6]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 骑士无法用偶数次移动从 start = [4, 5] 到达 target = [6, 6]。因此答案为 false。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * start.length == target.length == 2
 * 0 <= start[i], target[i] <= 7
 */
public class Code22 {

    public boolean canReach(int[] start, int[] target) {
        //绝对距离,偶数可以,基数不能
        return (Math.abs(start[0] - target[0]) + Math.abs(start[1] - target[1])) % 2 == 0;
    }

}
