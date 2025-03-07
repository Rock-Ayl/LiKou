package normal38;

/**
 * @Author ayl
 * @Date 2024-12-24
 * 2483. 商店的最少代价
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个顾客访问商店的日志，用一个下标从 0 开始且只包含字符 'N' 和 'Y' 的字符串 customers 表示：
 * <p>
 * 如果第 i 个字符是 'Y' ，它表示第 i 小时有顾客到达。
 * 如果第 i 个字符是 'N' ，它表示第 i 小时没有顾客到达。
 * 如果商店在第 j 小时关门（0 <= j <= n），代价按如下方式计算：
 * <p>
 * 在开门期间，如果某一个小时没有顾客到达，代价增加 1 。
 * 在关门期间，如果某一个小时有顾客到达，代价增加 1 。
 * 请你返回在确保代价 最小 的前提下，商店的 最早 关门时间。
 * <p>
 * 注意，商店在第 j 小时关门表示在第 j 小时以及之后商店处于关门状态。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：customers = "YYNY"
 * 输出：2
 * 解释：
 * - 第 0 小时关门，总共 1+1+0+1 = 3 代价。
 * - 第 1 小时关门，总共 0+1+0+1 = 2 代价。
 * - 第 2 小时关门，总共 0+0+0+1 = 1 代价。
 * - 第 3 小时关门，总共 0+0+1+1 = 2 代价。
 * - 第 4 小时关门，总共 0+0+1+0 = 1 代价。
 * 在第 2 或第 4 小时关门代价都最小。由于第 2 小时更早，所以最优关门时间是 2 。
 * 示例 2：
 * <p>
 * 输入：customers = "NNNNN"
 * 输出：0
 * 解释：最优关门时间是 0 ，因为自始至终没有顾客到达。
 * 示例 3：
 * <p>
 * 输入：customers = "YYYY"
 * 输出：4
 * 解释：最优关门时间是 4 ，因为每一小时均有顾客到达。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= customers.length <= 105
 * customers 只包含字符 'Y' 和 'N' 。
 */
public class Code19 {

    public int bestClosingTime(String customers) {

        /**
         * 1. 计算前缀和数组1
         */

        //前缀和数组
        int[] rightArr = new int[customers.length()];
        //初始化最后一个
        rightArr[rightArr.length - 1] = customers.charAt(customers.length() - 1) == 'Y' ? 1 : 0;
        //循环
        for (int i = customers.length() - 2; i >= 0; i--) {
            //叠加计算
            rightArr[i] = rightArr[i + 1] + (customers.charAt(i) == 'Y' ? 1 : 0);
        }

        /**
         * 2. 边界判定结果
         */

        //如果全是Y
        if (rightArr[0] == rightArr.length) {
            //直接返回
            return rightArr.length;
        }
        //如果全是0
        if (rightArr[0] == 0) {
            //直接返回
            return 0;
        }

        /**
         * 3. 计算前缀和数组2
         */

        int[] leftArr = new int[customers.length()];
        //初始化第一个
        leftArr[0] = customers.charAt(0) == 'N' ? 1 : 0;
        //循环
        for (int i = 1; i < customers.length(); i++) {
            //叠加计算
            leftArr[i] = leftArr[i - 1] + (customers.charAt(i) == 'N' ? 1 : 0);
        }

        /**
         * 4. 计算结果
         */

        //初始化 最小代价、最小代价索引
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        //循环
        for (int i = 0; i <= leftArr.length; i++) {
            //本索引关门的代价
            int target = (i < rightArr.length ? rightArr[i] : 0) + (i > 0 ? leftArr[i - 1] : 0);
            //如果更小
            if (target < min) {
                //更新
                min = target;
                minIndex = i;
            }
        }
        //返回结果
        return minIndex;
    }

    public static void main(String[] args) {
        new Code19().bestClosingTime("YYNY");
    }

}
