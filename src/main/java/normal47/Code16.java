package normal47;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-11-01
 * 3160. 所有球里面不同颜色的数目
 * 算术评级: 4
 * 第 131 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1517
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 limit 和一个大小为 n x 2 的二维数组 queries 。
 * <p>
 * 总共有 limit + 1 个球，每个球的编号为 [0, limit] 中一个 互不相同 的数字。一开始，所有球都没有颜色。queries 中每次操作的格式为 [x, y] ，你需要将球 x 染上颜色 y 。每次操作之后，你需要求出所有球颜色的数目。
 * <p>
 * 请你返回一个长度为 n 的数组 result ，其中 result[i] 是第 i 次操作以后颜色的数目。
 * <p>
 * 注意 ，没有染色的球不算作一种颜色。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：limit = 4, queries = [[1,4],[2,5],[1,3],[3,4]]
 * <p>
 * 输出：[1,2,2,3]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 操作 0 后，球 1 颜色为 4 。
 * 操作 1 后，球 1 颜色为 4 ，球 2 颜色为 5 。
 * 操作 2 后，球 1 颜色为 3 ，球 2 颜色为 5 。
 * 操作 3 后，球 1 颜色为 3 ，球 2 颜色为 5 ，球 3 颜色为 4 。
 * 示例 2：
 * <p>
 * 输入：limit = 4, queries = [[0,1],[1,2],[2,2],[3,4],[4,5]]
 * <p>
 * 输出：[1,2,2,3,4]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 操作 0 后，球 0 颜色为 1 。
 * 操作 1 后，球 0 颜色为 1 ，球 1 颜色为 2 。
 * 操作 2 后，球 0 颜色为 1 ，球 1 和 2 颜色为 2 。
 * 操作 3 后，球 0 颜色为 1 ，球 1 和 2 颜色为 2 ，球 3 颜色为 4 。
 * 操作 4 后，球 0 颜色为 1 ，球 1 和 2 颜色为 2 ，球 3 颜色为 4 ，球 4 颜色为 5 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= limit <= 109
 * 1 <= n == queries.length <= 105
 * queries[i].length == 2
 * 0 <= queries[i][0] <= limit
 * 1 <= queries[i][1] <= 109
 */
public class Code16 {

    public int[] queryResults(int limit, int[][] queries) {
        //结果
        int[] result = new int[queries.length];
        //球当前颜色的缓存
        Map<Integer, Integer> ballMap = new HashMap<>();
        //每种颜色数量map
        Map<Integer, Integer> countMap = new HashMap<>();
        //当前数量
        int countSum = 0;
        //循环
        for (int i = 0; i < queries.length; i++) {

            //获取当前球、颜色
            Integer ball = queries[i][0];
            Integer color = queries[i][1];
            //获取该球之前的颜色
            Integer lastColor = ballMap.get(ball);

            /**
             * 旧颜色
             */

            //如果之前染了颜色
            if (lastColor != null) {
                //计算新的数量
                int count = countMap.get(lastColor) - 1;
                //如果没有了
                if (count == 0) {
                    //-1
                    countSum--;
                }
                //覆盖
                countMap.put(lastColor, count);
            }

            /**
             * 新颜色
             */

            //覆盖新的颜色
            ballMap.put(ball, color);
            //新的数量
            int newCount = countMap.getOrDefault(color, 0) + 1;
            //如果新增颜色
            if (newCount == 1) {
                //+1
                countSum++;
            }
            //覆盖
            countMap.put(color, newCount);

            /**
             * 记录本次结果
             */

            //记录本次结果
            result[i] = countSum;
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code16().queryResults(4, new int[][]{
                new int[]{1, 4},
                new int[]{2, 5},
                new int[]{1, 3},
                new int[]{3, 4}
        });
        System.out.println();
    }

}
