package easy30;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-05-08
 * LCP 77. 符文储备
 * 远征队在出发前需要携带一些「符文」，作为后续的冒险储备。runes[i] 表示第 i 枚符文的魔力值。
 * <p>
 * 他们将从中选取若干符文进行携带，并对这些符文进行重新排列，以确保任意相邻的两块符文之间的魔力值相差不超过 1。
 * <p>
 * 请返回他们能够携带的符文 最大数量。
 * <p>
 * 示例 1：
 * <p>
 * 输入：runes = [1,3,5,4,1,7]
 * <p>
 * 输出：3
 * <p>
 * 解释：最佳的选择方案为[3,5,4]
 * 将其排列为 [3,4,5] 后，任意相邻的两块符文魔力值均不超过 1，携带数量为 3
 * 其他满足条件的方案为 [1,1] 和 [7]，数量均小于 3。
 * 因此返回可携带的最大数量 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入：runes = [1,1,3,3,2,4]
 * <p>
 * 输出：6
 * <p>
 * 解释：排列为 [1,1,2,3,3,4]，可携带所有的符文
 * <p>
 * 提示：
 * <p>
 * 1 <= runes.length <= 10^4
 * 0 <= runes[i] <= 10^4
 */
public class Code18 {

    public int runeReserve(int[] runes) {
        //排序
        Arrays.sort(runes);
        //最大连击
        int maxHit = 1;
        int hit = 1;
        //上一个
        int last = runes[0];
        //循环
        for (int i = 1; i < runes.length; i++) {
            //如果符合连击
            if (last == runes[i] || last + 1 == runes[i]) {
                //+1
                hit++;
                last = runes[i];
                //本轮过
                continue;
            }
            //刷新记录
            maxHit = Math.max(maxHit, hit);
            //记录
            last = runes[i];
            hit = 1;
        }
        //返回
        return Math.max(maxHit, hit);
    }

    public static void main(String[] args) {
        System.out.println(new Code18().runeReserve(new int[]{1, 3, 5, 4, 1, 7}));
    }

}
