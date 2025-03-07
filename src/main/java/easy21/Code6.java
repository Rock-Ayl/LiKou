package easy21;

/**
 * @Author ayl
 * @Date 2022-07-17
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 * 示例 2：
 * <p>
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class Code6 {

    public int maxProfit(int[] prices) {
        //如果太小
        if (prices.length < 2) {
            //过
            return 0;
        }
        //初始化
        int[] arr = new int[prices.length];
        //初始化收益
        arr[1] = Math.max(prices[1] - prices[0], 0);
        //买入价格
        int buy = prices[0];
        //循环
        for (int i = 1; i < prices.length; i++) {
            //卖出价格
            int sell = prices[i];
            //如果有结果
            if (sell - buy > 0) {
                //记录最大收益
                arr[i] = Math.max(arr[i - 1], sell - buy);
            } else {
                //上一个收益
                arr[i] = arr[i - 1];
            }
            //计算更小的价格
            buy = Math.min(buy, sell);
        }
        //返回结果
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Code6().maxProfit(new int[]{2, 4, 1}));
    }

}
