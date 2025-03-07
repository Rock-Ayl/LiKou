package easy22;

/**
 * @Author ayl
 * @Date 2022-09-10
 * 2347. 最好的扑克手牌
 * 给你一个整数数组 ranks 和一个字符数组 suit 。你有 5 张扑克牌，第 i 张牌大小为 ranks[i] ，花色为 suits[i] 。
 * <p>
 * 下述是从好到坏你可能持有的 手牌类型 ：
 * <p>
 * "Flush"：同花，五张相同花色的扑克牌。
 * "Three of a Kind"：三条，有 3 张大小相同的扑克牌。
 * "Pair"：对子，两张大小一样的扑克牌。
 * "High Card"：高牌，五张大小互不相同的扑克牌。
 * 请你返回一个字符串，表示给定的 5 张牌中，你能组成的 最好手牌类型 。
 * <p>
 * 注意：返回的字符串 大小写 需与题目描述相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：ranks = [13,2,3,1,9], suits = ["a","a","a","a","a"]
 * 输出："Flush"
 * 解释：5 张扑克牌的花色相同，所以返回 "Flush" 。
 * 示例 2：
 * <p>
 * 输入：ranks = [4,4,2,4,4], suits = ["d","a","a","b","c"]
 * 输出："Three of a Kind"
 * 解释：第一、二和四张牌组成三张相同大小的扑克牌，所以得到 "Three of a Kind" 。
 * 注意我们也可以得到 "Pair" ，但是 "Three of a Kind" 是更好的手牌类型。
 * 有其他的 3 张牌也可以组成 "Three of a Kind" 手牌类型。
 * 示例 3：
 * <p>
 * 输入：ranks = [10,10,2,12,9], suits = ["a","b","c","a","d"]
 * 输出："Pair"
 * 解释：第一和第二张牌大小相同，所以得到 "Pair" 。
 * 我们无法得到 "Flush" 或者 "Three of a Kind" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * ranks.length == suits.length == 5
 * 1 <= ranks[i] <= 13
 * 'a' <= suits[i] <= 'd'
 * 任意两张扑克牌不会同时有相同的大小和花色。
 */
public class Code14 {

    public String bestHand(int[] ranks, char[] suits) {
        //如果花色理论上满足
        if (suits.length > 4) {
            //记录数组
            int[] arr = new int[4];
            //循环
            for (char suit : suits) {
                //如果有5个相同的
                if (++arr[suit - 'a'] == 5) {
                    //第一权重
                    return "Flush";
                }
            }
        }
        //如果太小
        if (ranks.length < 2) {
            //默认
            return "High Card";
        }
        //初始化
        int[] rankArr = new int[14];
        //循环
        for (int rank : ranks) {
            //如果有三个相同的
            if (++rankArr[rank] == 3) {
                //返回
                return "Three of a Kind";
            }
        }
        //循环
        for (int i : rankArr) {
            //如果有俩相同的
            if (i == 2) {
                //返回
                return "Pair";
            }
        }
        //默认
        return "High Card";
    }


}
