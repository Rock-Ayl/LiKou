package normal38;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-12-07
 * 1357. 每隔 n 个顾客打折
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 超市里正在举行打折活动，每隔 n 个顾客会得到 discount 的折扣。
 * <p>
 * 超市里有一些商品，第 i 种商品为 products[i] 且每件单品的价格为 prices[i] 。
 * <p>
 * 结账系统会统计顾客的数目，每隔 n 个顾客结账时，该顾客的账单都会打折，折扣为 discount （也就是如果原本账单为 x ，那么实际金额会变成 x - (discount * x) / 100 ），然后系统会重新开始计数。
 * <p>
 * 顾客会购买一些商品， product[i] 是顾客购买的第 i 种商品， amount[i] 是对应的购买该种商品的数目。
 * <p>
 * 请你实现 Cashier 类：
 * <p>
 * Cashier(int n, int discount, int[] products, int[] prices) 初始化实例对象，参数分别为打折频率 n ，折扣大小 discount ，超市里的商品列表 products 和它们的价格 prices 。
 * double getBill(int[] product, int[] amount) 返回账单的实际金额（如果有打折，请返回打折后的结果）。返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["Cashier","getBill","getBill","getBill","getBill","getBill","getBill","getBill"]
 * [[3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]],[[1,2],[1,2]],[[3,7],[10,10]],[[1,2,3,4,5,6,7],[1,1,1,1,1,1,1]],[[4],[10]],[[7,3],[10,10]],[[7,5,3,1,6,4,2],[10,10,10,9,9,9,7]],[[2,3,5],[5,3,2]]]
 * 输出
 * [null,500.0,4000.0,800.0,4000.0,4000.0,7350.0,2500.0]
 * 解释
 * Cashier cashier = new Cashier(3,50,[1,2,3,4,5,6,7],[100,200,300,400,300,200,100]);
 * cashier.getBill([1,2],[1,2]);                        // 返回 500.0, 账单金额为 = 1 * 100 + 2 * 200 = 500.
 * cashier.getBill([3,7],[10,10]);                      // 返回 4000.0
 * cashier.getBill([1,2,3,4,5,6,7],[1,1,1,1,1,1,1]);    // 返回 800.0 ，账单原本为 1600.0 ，但由于该顾客是第三位顾客，他将得到 50% 的折扣，所以实际金额为 1600 - 1600 * (50 / 100) = 800 。
 * cashier.getBill([4],[10]);                           // 返回 4000.0
 * cashier.getBill([7,3],[10,10]);                      // 返回 4000.0
 * cashier.getBill([7,5,3,1,6,4,2],[10,10,10,9,9,9,7]); // 返回 7350.0 ，账单原本为 14700.0 ，但由于系统计数再次达到三，该顾客将得到 50% 的折扣，实际金额为 7350.0 。
 * cashier.getBill([2,3,5],[5,3,2]);                    // 返回 2500.0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^4
 * 0 <= discount <= 100
 * 1 <= products.length <= 200
 * 1 <= products[i] <= 200
 * products 列表中 不会 有重复的元素。
 * prices.length == products.length
 * 1 <= prices[i] <= 1000
 * 1 <= product.length <= products.length
 * product[i] 在 products 出现过。
 * amount.length == product.length
 * 1 <= amount[i] <= 1000
 * 最多有 1000 次对 getBill 函数的调用。
 * 返回结果与标准答案误差在 10^-5 以内都视为正确结果。
 */
public class Code11 {

    //每N位客人打折
    private int target;
    private int user = 0;
    //折扣百分比
    private int discount;
    //产品价格map
    private Map<Integer, Integer> productMap = new HashMap<>();

    public Code11(int n, int discount, int[] products, int[] prices) {
        this.target = n;
        this.discount = discount;
        //循环
        for (int i = 0; i < products.length; i++) {
            //记录价格
            this.productMap.put(products[i], prices[i]);
        }
    }

    public double getBill(int[] product, int[] amount) {
        //本次总价
        double result = 0D;
        //循环
        for (int i = 0; i < product.length; i++) {
            //计算本次
            result += (double) this.productMap.get(product[i]) * (double) amount[i];
        }
        //计算打折客人,如果打折
        if (++this.user % this.target == 0) {
            //打折
            result = result - (this.discount * result) / 100D;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {

        Code11 code11 = new Code11(3, 50, new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{100, 200, 300, 400, 300, 200, 100});
        System.out.println(code11.getBill(new int[]{1, 2}, new int[]{1, 2}));
        System.out.println(code11.getBill(new int[]{3, 7}, new int[]{10, 10}));
        System.out.println(code11.getBill(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{1, 1, 1, 1, 1, 1, 1}));
        System.out.println(code11.getBill(new int[]{7, 5, 3, 1, 6, 4, 2}, new int[]{10, 10, 10, 9, 9, 9, 7}));
    }

}
