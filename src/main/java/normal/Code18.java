package normal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-03-24
 * 剑指 Offer 63. 股票的最大利润
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 * <p>
 * 示例 1:
 * <p>
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 * <p>
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 * <p>
 * 限制：
 * <p>
 * 0 <= 数组长度 <= 10^5
 */
public class Code18 {

    /**
     * 动态规划,未优化
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //如果不存在
        if (prices.length < 1) {
            //默认
            return 0;
        }
        //当天最大利润
        List<Integer> list = new ArrayList<>();
        //第一天无收入
        list.add(0);
        //最低买入价格
        int coast = prices[0];
        //循环
        for (int i = 1; i < prices.length; i++) {
            //当天价格
            int price = prices[i];
            //计算当天利润
            int earn = price - coast;
            //如果不是第一天
            if (i != 0) {
                //计算到今天位置最高利润
                earn = Math.max(list.get(i - 1), earn);
            }
            //记录最高利润
            list.add(earn);
            //更新最低价格
            coast = Math.min(coast, price);
        }
        //返回最后一个
        return Math.max(0, list.get(list.size() - 1));
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
