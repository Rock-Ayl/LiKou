package normal26;

/**
 * @Author ayl
 * @Date 2023-12-04
 * LCR 103. 零钱兑换
 * 中等
 * 100
 * 相关企业
 * 给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：coins = [1, 2, 5], amount = 11
 * 输出：3
 * 解释：11 = 5 + 5 + 1
 * 示例 2：
 * <p>
 * 输入：coins = [2], amount = 3
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：coins = [1], amount = 0
 * 输出：0
 * 示例 4：
 * <p>
 * 输入：coins = [1], amount = 1
 * 输出：1
 * 示例 5：
 * <p>
 * 输入：coins = [1], amount = 2
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 * <p>
 * <p>
 * 注意：本题与主站 322 题相同： https://leetcode-cn.com/problems/coin-change/
 */
public class Code16 {

    public int coinChange(int[] coins, int amount) {
        //如果是0
        if (amount == 0) {
            //过
            return 0;
        }
        //排序
        int[] arr = new int[amount + 1];
        //默认
        arr[0] = 1;
        //初始化
        for (int coin : coins) {
            //如果满足
            if (coin < arr.length) {
                //默认
                arr[coin] = 1;
            }
        }
        //循环
        for (int i = 0; i < arr.length; i++) {
            //循环币种
            for (int coin : coins) {
                //如果不满足
                if (i < coin) {
                    //本轮过
                    continue;
                }
                //如果有结果
                if (arr[i - coin] > 0) {
                    //如果没有
                    if (arr[i] == 0) {
                        //第一次
                        arr[i] = arr[i - coin] + 1;
                    } else {
                        //对比最小的可能
                        arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                    }
                }
            }
        }
        //返回结果
        return arr[arr.length - 1] == 0 ? -1 : arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code16().coinChange(new int[]{1, 2, 5}, 11));
    }

}
