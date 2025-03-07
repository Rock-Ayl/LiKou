package easy29;

/**
 * @Author ayl
 * @Date 2023-03-27
 * 6354. K 件物品的最大和
 * 袋子中装有一些物品，每个物品上都标记着数字 1 、0 或 -1 。
 * <p>
 * 给你四个非负整数 numOnes 、numZeros 、numNegOnes 和 k 。
 * <p>
 * 袋子最初包含：
 * <p>
 * numOnes 件标记为 1 的物品。
 * numZeroes 件标记为 0 的物品。
 * numNegOnes 件标记为 -1 的物品。
 * 现计划从这些物品中恰好选出 k 件物品。返回所有可行方案中，物品上所标记数字之和的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 2
 * 输出：2
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 2 件标记为 1 的物品，得到的数字之和为 2 。
 * 可以证明 2 是所有可行方案中的最大值。
 * 示例 2：
 * <p>
 * 输入：numOnes = 3, numZeros = 2, numNegOnes = 0, k = 4
 * 输出：3
 * 解释：袋子中的物品分别标记为 {1, 1, 1, 0, 0} 。取 3 件标记为 1 的物品，1 件标记为 0 的物品，得到的数字之和为 3 。
 * 可以证明 3 是所有可行方案中的最大值。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= numOnes, numZeros, numNegOnes <= 50
 * 0 <= k <= numOnes + numZeros + numNegOnes
 */
public class Code7 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        //如果1足够多
        if (k <= numOnes) {
            //全1
            return Math.min(numOnes, k);
        }
        //删除1的数量
        k -= numOnes;
        //如果0足够多
        if (k <= numZeros) {
            //全1+0
            return numOnes;
        }
        //最后
        return numOnes - k + numZeros;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().kItemsWithMaximumSum(3, 3, 5, 11));
    }

}
