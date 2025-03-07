package normal2;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-04-05
 * 1561. 你可以获得的最大硬币数目
 * 有 3n 堆数目不一的硬币，你和你的朋友们打算按以下方式分硬币：
 * <p>
 * 每一轮中，你将会选出 任意 3 堆硬币（不一定连续）。
 * Alice 将会取走硬币数量最多的那一堆。
 * 你将会取走硬币数量第二多的那一堆。
 * Bob 将会取走最后一堆。
 * 重复这个过程，直到没有更多硬币。
 * 给你一个整数数组 piles ，其中 piles[i] 是第 i 堆中硬币的数目。
 * <p>
 * 返回你可以获得的最大硬币数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：piles = [2,4,1,2,7,8]
 * 输出：9
 * 解释：选出 (2, 7, 8) ，Alice 取走 8 枚硬币的那堆，你取走 7 枚硬币的那堆，Bob 取走最后一堆。
 * 选出 (1, 2, 4) , Alice 取走 4 枚硬币的那堆，你取走 2 枚硬币的那堆，Bob 取走最后一堆。
 * 你可以获得的最大硬币数目：7 + 2 = 9.
 * 考虑另外一种情况，如果选出的是 (1, 2, 8) 和 (2, 4, 7) ，你就只能得到 2 + 4 = 6 枚硬币，这不是最优解。
 * 示例 2：
 * <p>
 * 输入：piles = [2,4,5]
 * 输出：4
 * 示例 3：
 * <p>
 * 输入：piles = [9,8,7,6,5,1,2,3,4]
 * 输出：18
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= piles.length <= 10^5
 * piles.length % 3 == 0
 * 1 <= piles[i] <= 10^4
 * 通过次数9,484提交次数12,194
 */
public class Code4 {

    public static int maxCoins(int[] piles) {
        //你的硬币数
        int sum = 0;
        //排序
        Arrays.sort(piles);
        //可以拿的次数
        int time = piles.length / 3;
        //你可以拿的最大值
        int p = piles.length - 2;
        //循环
        while (time > 0) {
            //拿一枚
            sum += piles[p];
            //递减
            p -= 2;
            //次数-1
            time--;
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(maxCoins(new int[]{2, 4, 1, 2, 7, 8}));
    }
}
