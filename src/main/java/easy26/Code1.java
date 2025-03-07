package easy26;

/**
 * @Author ayl
 * @Date 2022-12-14
 * 1217. 玩筹码
 * 有 n 个筹码。第 i 个筹码的位置是 position[i] 。
 * <p>
 * 我们需要把所有筹码移到同一个位置。在一步中，我们可以将第 i 个筹码的位置从 position[i] 改变为:
 * <p>
 * position[i] + 2 或 position[i] - 2 ，此时 cost = 0
 * position[i] + 1 或 position[i] - 1 ，此时 cost = 1
 * 返回将所有筹码移动到同一位置上所需要的 最小代价 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：position = [1,2,3]
 * 输出：1
 * 解释：第一步:将位置3的筹码移动到位置1，成本为0。
 * 第二步:将位置2的筹码移动到位置1，成本= 1。
 * 总成本是1。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：position = [2,2,2,3,3]
 * 输出：2
 * 解释：我们可以把位置3的两个筹码移到位置2。每一步的成本为1。总成本= 2。
 * 示例 3:
 * <p>
 * 输入：position = [1,1000000000]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= position.length <= 100
 * 1 <= position[i] <= 10^9
 */
public class Code1 {

    public int minCostToMoveChips(int[] position) {
        //单双位置count
        int one = 0;
        int two = 0;
        //循环
        for (int i : position) {
            //如果是偶数
            if (i % 2 == 0) {
                //叠加
                two++;
            } else {
                //叠加
                one++;
            }
        }
        //返回最小的情况
        return Math.min(one, two);
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minCostToMoveChips(new int[]{2, 2, 2, 3, 3}));
    }

}
