package normal13;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-03-16
 * 1557. 可以到达所有点的最少点数目
 * 给你一个 有向无环图 ， n 个节点编号为 0 到 n-1 ，以及一个边数组 edges ，其中 edges[i] = [fromi, toi] 表示一条从点  fromi 到点 toi 的有向边。
 * <p>
 * 找到最小的点集使得从这些点出发能到达图中所有点。题目保证解存在且唯一。
 * <p>
 * 你可以以任意顺序返回这些节点编号。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[2,5],[3,4],[4,2]]
 * 输出：[0,3]
 * 解释：从单个节点出发无法到达所有节点。从 0 出发我们可以到达 [0,1,2,5] 。从 3 出发我们可以到达 [3,4,2,5] 。所以我们输出 [0,3] 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, edges = [[0,1],[2,1],[3,1],[1,4],[2,4]]
 * 输出：[0,2,3]
 * 解释：注意到节点 0，3 和 2 无法从其他节点到达，所以我们必须将它们包含在结果点集中，这些点都能到达节点 1 和 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 10^5
 * 1 <= edges.length <= min(10^5, n * (n - 1) / 2)
 * edges[i].length == 2
 * 0 <= fromi, toi < n
 * 所有点对 (fromi, toi) 互不相同。
 */
public class Code6 {

    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        //初始化
        List<Integer> result = new ArrayList<>();
        //谁被指向过
        Set<Integer> set = new HashSet<>();
        //循环
        for (List<Integer> edge : edges) {
            //记录其被指向过
            set.add(edge.get(1));
        }
        //指针
        int p = 0;
        //循环
        while (p < n) {
            //如果不存在被指向
            if (set.contains(p) == false) {
                //记录其肯定是
                result.add(p);
            }
            //+1
            p++;
        }
        //返回
        return result;
    }

}
