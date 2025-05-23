package normal33;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-07-11
 * 2924. 找到冠军 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一场比赛中共有 n 支队伍，按从 0 到  n - 1 编号。每支队伍也是 有向无环图（DAG） 上的一个节点。
 * <p>
 * 给你一个整数 n 和一个下标从 0 开始、长度为 m 的二维整数数组 edges 表示这个有向无环图，其中 edges[i] = [ui, vi] 表示图中存在一条从 ui 队到 vi 队的有向边。
 * <p>
 * 从 a 队到 b 队的有向边意味着 a 队比 b 队 强 ，也就是 b 队比 a 队 弱 。
 * <p>
 * 在这场比赛中，如果不存在某支强于 a 队的队伍，则认为 a 队将会是 冠军 。
 * <p>
 * 如果这场比赛存在 唯一 一个冠军，则返回将会成为冠军的队伍。否则，返回 -1 。
 * <p>
 * 注意
 * <p>
 * 环 是形如 a1, a2, ..., an, an+1 的一个序列，且满足：节点 a1 与节点 an+1 是同一个节点；节点 a1, a2, ..., an 互不相同；对于范围 [1, n] 中的每个 i ，均存在一条从节点 ai 到节点 ai+1 的有向边。
 * 有向无环图 是不存在任何环的有向图。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,2]]
 * 输出：0
 * 解释：1 队比 0 队弱。2 队比 1 队弱。所以冠军是 0 队。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, edges = [[0,2],[1,3],[1,2]]
 * 输出：-1
 * 解释：2 队比 0 队和 1 队弱。3 队比 1 队弱。但是 1 队和 0 队之间不存在强弱对比。所以答案是 -1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 100
 * m == edges.length
 * 0 <= m <= n * (n - 1) / 2
 * edges[i].length == 2
 * 0 <= edge[i][j] <= n - 1
 * edges[i][0] != edges[i][1]
 * 生成的输入满足：如果 a 队比 b 队强，就不存在 b 队比 a 队强
 * 生成的输入满足：如果 a 队比 b 队强，b 队比 c 队强，那么 a 队比 c 队强
 */
public class Code8 {

    public int findChampion(int n, int[][] edges) {
        //如果绝对不够
        if (edges.length + 1 < n) {
            //过
            return -1;
        }
        //作为主节点的集合
        Set<Integer> rootSet = new HashSet<>();
        //循环
        for (int i = 0; i < n; i++) {
            //加入节点
            rootSet.add(i);
        }
        //循环
        for (int[] edge : edges) {
            //改点无法作为父节点
            rootSet.remove(edge[1]);
        }
        //返回
        return rootSet.size() == 1 ? rootSet.stream().findFirst().get() : -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().findChampion(4, new int[][]{
                new int[]{0, 2},
                new int[]{1, 3},
                new int[]{1, 2}
        }));
    }

}
