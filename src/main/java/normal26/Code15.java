package normal26;

/**
 * @Author ayl
 * @Date 2023-12-03
 * 518. 零钱兑换 II
 * 中等
 * 1.2K
 * 相关企业
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：amount = 5, coins = [1, 2, 5]
 * 输出：4
 * 解释：有四种方式可以凑成总金额：
 * 5=5
 * 5=2+2+1
 * 5=2+1+1+1
 * 5=1+1+1+1+1
 * 示例 2：
 * <p>
 * 输入：amount = 3, coins = [2]
 * 输出：0
 * 解释：只用面额 2 的硬币不能凑成总金额 3 。
 * 示例 3：
 * <p>
 * 输入：amount = 10, coins = [10]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= coins.length <= 300
 * 1 <= coins[i] <= 5000
 * coins 中的所有值 互不相同
 * 0 <= amount <= 5000
 */
public class Code15 {

    public int change(int amount, int[] coins) {
        //如果太小
        if (amount < 1) {
            //过
            return 1;
        }
        //每个额度缓存
        int[] arr = new int[amount + 1];
        //循环1
        for (int coin : coins) {
            //如同太大
            if (coin > arr.length - 1) {
                //本轮过
                continue;
            }
            //开始默认情况+1
            arr[coin]++;
            //循环2
            for (int i = coin + 1; i < arr.length; i++) {
                //更换
                arr[i] += arr[i - coin];
            }
        }
        //返回结果
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code15().change(5, new int[]{1, 2, 5}));
    }

}
