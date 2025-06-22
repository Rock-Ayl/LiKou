package easy40;

/**
 * @Author ayl
 * @Date 2025-06-22
 * 3560. 木材运输的最小成本
 * 简单
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你三个整数 n、m 和 k。
 * <p>
 * 有两根长度分别为 n 和 m 单位的木材，需要通过三辆卡车运输。每辆卡车最多只能装载一根长度 不超过 k 单位的木材。
 * <p>
 * 你可以将木材切成更小的段，其中将长度为 x 的木材切割成长度为 len1 和 len2 的段的成本为 cost = len1 * len2，并且满足 len1 + len2 = x。
 * <p>
 * 返回将木材分配到卡车上的 最小总成本 。如果木材不需要切割，总成本为 0。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 6, m = 5, k = 5
 * <p>
 * 输出： 5
 * <p>
 * 解释：
 * <p>
 * 将长度为 6 的木材切割成长度为 1 和 5 的两段，成本为 1 * 5 == 5。现在三段长度分别为 1、5 和 5 的木材可以分别装载到每辆卡车。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 4, m = 4, k = 6
 * <p>
 * 输出： 0
 * <p>
 * 解释：
 * <p>
 * 两根木材已经可以直接装载到卡车上，因此不需要切割。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= k <= 105
 * 1 <= n, m <= 2 * k
 * 输入数据保证木材总存在能被运输的方案。
 */
public class Code23 {

    public long minCuttingCost(int n, int m, int k) {
        //看谁更大
        int big = Math.max(n, m);
        //如果满足
        if (big <= k) {
            //无需操作
            return 0L;
        }
        //最小成本
        long result = Long.MAX_VALUE;
        //循环
        for (long i = big - k; i <= k; i++) {
            //刷新本次
            result = Math.min(result, i * (big - i));
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().minCuttingCost(6, 5, 5));
    }

}