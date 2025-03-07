package normal34;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-08-07
 * 2285. 道路的最大总重要性
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示一个国家里的城市数目。城市编号为 0 到 n - 1 。
 * <p>
 * 给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] 表示城市 ai 和 bi 之间有一条 双向 道路。
 * <p>
 * 你需要给每个城市安排一个从 1 到 n 之间的整数值，且每个值只能被使用 一次 。道路的 重要性 定义为这条道路连接的两座城市数值 之和 。
 * <p>
 * 请你返回在最优安排下，所有道路重要性 之和 最大 为多少。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, roads = [[0,1],[1,2],[2,3],[0,2],[1,3],[2,4]]
 * 输出：43
 * 解释：上图展示了国家图和每个城市被安排的值 [2,4,5,3,1] 。
 * - 道路 (0,1) 重要性为 2 + 4 = 6 。
 * - 道路 (1,2) 重要性为 4 + 5 = 9 。
 * - 道路 (2,3) 重要性为 5 + 3 = 8 。
 * - 道路 (0,2) 重要性为 2 + 5 = 7 。
 * - 道路 (1,3) 重要性为 4 + 3 = 7 。
 * - 道路 (2,4) 重要性为 5 + 1 = 6 。
 * 所有道路重要性之和为 6 + 9 + 8 + 7 + 7 + 6 = 43 。
 * 可以证明，重要性之和不可能超过 43 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, roads = [[0,3],[2,4],[1,3]]
 * 输出：20
 * 解释：上图展示了国家图和每个城市被安排的值 [4,3,2,5,1] 。
 * - 道路 (0,3) 重要性为 4 + 5 = 9 。
 * - 道路 (2,4) 重要性为 2 + 1 = 3 。
 * - 道路 (1,3) 重要性为 3 + 5 = 8 。
 * 所有道路重要性之和为 9 + 3 + 8 = 20 。
 * 可以证明，重要性之和不可能超过 20 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 5 * 104
 * 1 <= roads.length <= 5 * 104
 * roads[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 没有重复道路。
 */
public class Code2 {

    public long maximumImportance(int n, int[][] roads) {
        //节点缓存
        Map<Integer, Integer> nodeMap = new HashMap<>();
        //循环
        for (int[] road : roads) {
            //+1
            nodeMap.put(road[0], nodeMap.getOrDefault(road[0], 0) + 1);
            nodeMap.put(road[1], nodeMap.getOrDefault(road[1], 0) + 1);
        }
        //获取节点路线列表,并排序
        List<Integer> linkList = nodeMap.values().stream().sorted((a, b) -> b - a).collect(Collectors.toList());
        //目标结果
        long result = 0L;
        //分数递减
        long rank = n;
        //循环
        for (Integer link : linkList) {
            //计算本次和
            result += (long) link * rank--;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code2().maximumImportance(5, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{2, 4}
        }));
    }

}
