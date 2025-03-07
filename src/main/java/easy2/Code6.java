package easy2;

/**
 * Created By Rock-Ayl on 2020-09-24
 * 1475. 商品折扣后的最终价格
 * 给你一个数组 prices ，其中 prices[i] 是商店里第 i 件商品的价格。
 * <p>
 * 商店里正在进行促销活动，如果你要买第 i 件商品，那么你可以得到与 prices[j] 相等的折扣，其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
 * <p>
 * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [8,4,6,2,3]
 * 输出：[4,2,4,2,3]
 * 解释：
 * 商品 0 的价格为 price[0]=8 ，你将得到 prices[1]=4 的折扣，所以最终价格为 8 - 4 = 4 。
 * 商品 1 的价格为 price[1]=4 ，你将得到 prices[3]=2 的折扣，所以最终价格为 4 - 2 = 2 。
 * 商品 2 的价格为 price[2]=6 ，你将得到 prices[3]=2 的折扣，所以最终价格为 6 - 2 = 4 。
 * 商品 3 和 4 都没有折扣。
 * 示例 2：
 * <p>
 * 输入：prices = [1,2,3,4,5]
 * 输出：[1,2,3,4,5]
 * 解释：在这个例子中，所有商品都没有折扣。
 * 示例 3：
 * <p>
 * 输入：prices = [10,1,1,6]
 * 输出：[9,0,1,6]
 */
public class Code6 {

    /**
     * 其中 j 是满足 j > i 且 prices[j] <= prices[i] 的 最小下标 ，如果没有满足条件的 j ，你将没有任何折扣。
     * <p>
     * 请你返回一个数组，数组中第 i 个元素是折扣后你购买商品 i 最终需要支付的价格。
     *
     * @param prices
     * @return
     */
    public static int[] finalPrices(int[] prices) {
        //真是价格组
        int[] realValueArr = new int[prices.length];
        //循环 i为第i个商品
        for (int i = 0; i < prices.length; i++) {
            //物品原来价值
            int x = prices[i];
            //是否打过折,默认未打折
            boolean dis = false;
            //循环 j为折扣的位置,默认 j>i
            for (int j = i + 1; j < prices.length; j++) {
                //折扣
                int y = prices[j];
                //初始化真实价格
                int realValue;
                //如果满足折扣条件
                if (y <= x) {
                    //真实价格
                    realValue = x - y;
                    //记录真实价格
                    realValueArr[i] = realValue;
                    //打过折了
                    dis = true;
                    //中断
                    break;
                }
            }
            //如果结尾还是没有打折
            if (dis == false) {
                //记录原价
                realValueArr[i] = x;
            }
        }
        //返回打折组
        return realValueArr;
    }

    public static void main(String[] args) {
        for (int i : finalPrices(new int[]{10, 1, 1, 6})) {
            System.out.println(i);
        }
    }
}
