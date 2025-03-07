package normal26;

/**
 * @Author ayl
 * @Date 2023-12-06
 * 322. 零钱兑换
 * 中等
 * 2.6K
 * 相关企业
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
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
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 12
 * 1 <= coins[i] <= 231 - 1
 * 0 <= amount <= 104
 */
public class Code18 {

    public int coinChange(int[] coins, int amount) {
        //如果直接是
        if (amount == 0) {
            //返回
            return 0;
        }
        //初始化
        int[] arr = new int[amount + 1];
        //循环
        for (int coin : coins) {
            //如果可以初始化
            if (coin < arr.length) {
                //默认
                arr[coin] = 1;
            }
        }
        //循环
        for (int i = 1; i < arr.length; i++) {
            //循环币种
            for (int coin : coins) {
                //如果金额不需要处理
                if (i <= coin) {
                    //本轮过
                    continue;
                }
                //如果之前没有结果
                if (arr[i - coin] < 1) {
                    //本轮过
                    continue;
                }
                //如果没计算过
                if (arr[i] == 0) {
                    //计算并覆盖
                    arr[i] = arr[i - coin] + 1;
                } else {
                    //计算并对比
                    arr[i] = Math.min(arr[i], arr[i - coin] + 1);
                }
            }
        }
        //返回结果
        return arr[arr.length - 1] == 0 ? -1 : arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code18().coinChange(new int[]{5, 2, 1}, 11));
    }

}
