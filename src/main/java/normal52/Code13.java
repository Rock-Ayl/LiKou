package normal52;

import java.util.ArrayList;
import java.util.List;

/**
 * 901. 股票价格跨度
 * 尝试过
 * 算术评级: 6
 * 第 101 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1709
 * 相关标签
 * premium lock icon
 * 相关企业
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 105
 * 最多调用 next 方法 104 次
 */
public class Code13 {

    public Code13() {

    }

    //缓存列表
    private List<Integer> list = new ArrayList<>();

    public int next(int price) {
        //添加本次
        this.list.add(price);
        //结束
        int end = this.list.size() - 1;
        //开始
        int start = this.list.size() - 1;
        //如果可以往前推进
        while (start > 0 && this.list.get(start - 1) <= this.list.get(end)) {
            //往前推
            start--;
        }
        //返回
        return end - start + 1;
    }

    public static void main(String[] args) {

        Code13 code13 = new Code13();
        System.out.println(code13.next(28));
        System.out.println(code13.next(14));
        System.out.println(code13.next(28));

    }

}
