package normal39;

/**
 * @Author ayl
 * @Date 2025-01-25
 * 2110. 股票平滑下跌阶段的数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 prices ，表示一支股票的历史每日股价，其中 prices[i] 是这支股票第 i 天的价格。
 * <p>
 * 一个 平滑下降的阶段 定义为：对于 连续一天或者多天 ，每日股价都比 前一日股价恰好少 1 ，这个阶段第一天的股价没有限制。
 * <p>
 * 请你返回 平滑下降阶段 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：prices = [3,2,1,4]
 * 输出：7
 * 解释：总共有 7 个平滑下降阶段：
 * [3], [2], [1], [4], [3,2], [2,1] 和 [3,2,1]
 * 注意，仅一天按照定义也是平滑下降阶段。
 * 示例 2：
 * <p>
 * 输入：prices = [8,6,7,7]
 * 输出：4
 * 解释：总共有 4 个连续平滑下降阶段：[8], [6], [7] 和 [7]
 * 由于 8 - 6 ≠ 1 ，所以 [8,6] 不是平滑下降阶段。
 * 示例 3：
 * <p>
 * 输入：prices = [1]
 * 输出：1
 * 解释：总共有 1 个平滑下降阶段：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= prices.length <= 105
 * 1 <= prices[i] <= 105
 */
public class Code15 {

    public long getDescentPeriods(int[] prices) {
        //结果
        long result = 0L;
        //滑动窗口
        int start = 0;
        //循环
        while (start < prices.length) {
            //初始化结束节点
            int end = start;
            //如果是继续下跌
            while (end + 1 < prices.length && prices[end] - 1 == prices[end + 1]) {
                //+1
                end++;
            }
            //计算本次结果、并叠加
            result += start == end ? 1L : count(start, end);
            //下一个节点
            start = end + 1;
        }
        //返回
        return result;
    }

    //通过高斯算法，计算区间结果
    private long count(int start, int end) {
        //长度
        int length = end - start + 1;
        //计算、转换
        long a = length + 1;
        long b = length / 2;
        long c = length % 2 == 0 ? 0 : ((length + 1) / 2);
        //计算最终结果
        return a * b + c;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().getDescentPeriods(new int[]{3, 2, 1, 4}));
    }

}
