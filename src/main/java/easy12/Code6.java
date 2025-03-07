package easy12;

/**
 * @Author ayl
 * @Date 2021-10-04
 * 746. 使用最小花费爬楼梯
 * 数组的每个下标作为一个阶梯，第 i 个阶梯对应着一个非负数的体力花费值 cost[i]（下标从 0 开始）。
 * <p>
 * 每当你爬上一个阶梯你都要花费对应的体力值，一旦支付了相应的体力值，你就可以选择向上爬一个阶梯或者爬两个阶梯。
 * <p>
 * 请你找出达到楼层顶部的最低花费。在开始时，你可以选择从下标为 0 或 1 的元素作为初始阶梯。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cost = [10, 15, 20]
 * 输出：15
 * 解释：最低花费是从 cost[1] 开始，然后走两步即可到阶梯顶，一共花费 15 。
 * 示例 2：
 * <p>
 * 输入：cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 * 输出：6
 * 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * cost 的长度范围是 [2, 1000]。
 * cost[i] 将会是一个整型数据，范围为 [0, 999] 。
 */
public class Code6 {

    public int minCostClimbingStairs(int[] cost) {
        //初始化每一步最优的结果
        int[] arr = new int[cost.length];
        //循环
        for (int i = 2; i < cost.length; i++) {
            //前两步坐标
            int a = i - 2, b = i - 1;
            //前1步,前2步比较最优解
            arr[i] = Math.min(cost[a] + arr[a], cost[b] + arr[b]);
        }
        //最后两个可以到达终点的位置
        int lastA = cost.length - 1, lastB = cost.length - 2;
        //返回最终结果
        return Math.min(arr[lastA] + cost[lastA], arr[lastB] + cost[lastB]);
    }

    public static void main(String[] args) {
        System.out.println(new Code6().minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}
