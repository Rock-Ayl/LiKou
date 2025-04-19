package normal42;

import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-04-19
 * 2830. 销售利润最大化
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 表示数轴上的房屋数量，编号从 0 到 n - 1 。
 * <p>
 * 另给你一个二维整数数组 offers ，其中 offers[i] = [starti, endi, goldi] 表示第 i 个买家想要以 goldi 枚金币的价格购买从 starti 到 endi 的所有房屋。
 * <p>
 * 作为一名销售，你需要有策略地选择并销售房屋使自己的收入最大化。
 * <p>
 * 返回你可以赚取的金币的最大数目。
 * <p>
 * 注意 同一所房屋不能卖给不同的买家，并且允许保留一些房屋不进行出售。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, offers = [[0,0,1],[0,2,2],[1,3,2]]
 * 输出：3
 * 解释：
 * 有 5 所房屋，编号从 0 到 4 ，共有 3 个购买要约。
 * 将位于 [0,0] 范围内的房屋以 1 金币的价格出售给第 1 位买家，并将位于 [1,3] 范围内的房屋以 2 金币的价格出售给第 3 位买家。
 * 可以证明我们最多只能获得 3 枚金币。
 * 示例 2：
 * <p>
 * 输入：n = 5, offers = [[0,0,1],[0,2,10],[1,3,2]]
 * 输出：10
 * 解释：有 5 所房屋，编号从 0 到 4 ，共有 3 个购买要约。
 * 将位于 [0,2] 范围内的房屋以 10 金币的价格出售给第 2 位买家。
 * 可以证明我们最多只能获得 10 枚金币。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 1 <= offers.length <= 105
 * offers[i].length == 3
 * 0 <= starti <= endi <= n - 1
 * 1 <= goldi <= 103
 */
public class Code1 {

    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        //按照开始索引排序,结束索引无所谓
        offers.sort((a, b) -> a.get(0) - b.get(0));
        //初始化动态规划
        int[] arr = new int[n + 1];
        //索引
        int index = 1;
        //最大结果
        int max = 0;
        //循环
        for (List<Integer> offer : offers) {
            //开始、结束、金币
            int start = offer.get(0) + 1;
            int end = offer.get(1) + 1;
            int gold = offer.get(2);
            //如果索引已经结束了
            while (index < start) {
                //后置位最大结果=前置位最大结果
                arr[index] = Math.max(arr[index], arr[index - 1]);
                //+1
                index++;
            }
            //如果使用当前offer,刷新后置位最大结果
            arr[end] = Math.max(arr[end], arr[start - 1] + gold);
            //刷新最大结果
            max = Math.max(max, arr[end]);
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().maximizeTheProfit(4, Arrays.asList(
                Arrays.asList(0, 0, 6),
                Arrays.asList(1, 2, 8),
                Arrays.asList(0, 3, 7),
                Arrays.asList(2, 2, 5),
                Arrays.asList(0, 1, 5),
                Arrays.asList(2, 3, 2),
                Arrays.asList(0, 2, 8),
                Arrays.asList(2, 3, 10),
                Arrays.asList(0, 3, 2)
        )));
    }

}
