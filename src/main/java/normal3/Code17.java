package normal3;

import java.util.Arrays;

/**
 * Created By Rock-Ayl on 2021-05-09
 * 1423. 可获得的最大点数
 * 几张卡牌 排成一行，每张卡牌都有一个对应的点数。点数由整数数组 cardPoints 给出。
 * <p>
 * 每次行动，你可以从行的开头或者末尾拿一张卡牌，最终你必须正好拿 k 张卡牌。
 * <p>
 * 你的点数就是你拿到手中的所有卡牌的点数之和。
 * <p>
 * 给你一个整数数组 cardPoints 和整数 k，请你返回可以获得的最大点数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：cardPoints = [1,2,3,4,5,6,1], k = 3
 * 输出：12
 * 解释：第一次行动，不管拿哪张牌，你的点数总是 1 。但是，先拿最右边的卡牌将会最大化你的可获得点数。最优策略是拿右边的三张牌，最终点数为 1 + 6 + 5 = 12 。
 * 示例 2：
 * <p>
 * 输入：cardPoints = [2,2,2], k = 2
 * 输出：4
 * 解释：无论你拿起哪两张卡牌，可获得的点数总是 4 。
 * 示例 3：
 * <p>
 * 输入：cardPoints = [9,7,7,9,7,7,9], k = 7
 * 输出：55
 * 解释：你必须拿起所有卡牌，可以获得的点数为所有卡牌的点数之和。
 * 示例 4：
 * <p>
 * 输入：cardPoints = [1,1000,1], k = 1
 * 输出：1
 * 解释：你无法拿到中间那张卡牌，所以可以获得的最大点数为 1 。
 * 示例 5：
 * <p>
 * 输入：cardPoints = [1,79,80,1,1,1,200,1], k = 3
 * 输出：202
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= cardPoints.length <= 10^5
 * 1 <= cardPoints[i] <= 10^4
 * 1 <= k <= cardPoints.length
 * 通过次数31,636提交次数57,010
 */
public class Code17 {

    public int maxScore(int[] cardPoints, int k) {
        //窗口当前和
        int sum = 0;
        //初始化窗口
        for (int i = 0; i < k; i++) {
            //叠加
            sum += cardPoints[i];
        }
        //初始化最大窗口和
        int max = sum;
        //窗口左、右变动的边界
        int left = k - 1, right = cardPoints.length;
        //滑动
        while (left > -1) {
            //要减去的值
            int a = cardPoints[left--];
            //要加上的值
            int b = cardPoints[--right];
            //更新窗口的值
            sum = sum - a + b;
            //如果更新了记录
            if (sum > max) {
                //刷新
                max = sum;
            }
        }
        //返回最大
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    }

}
