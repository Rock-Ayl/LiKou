package normal16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-08-11
 * 2368. 受限条件下可到达节点的数目
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 * <p>
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 * <p>
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 * <p>
 * 注意，节点 0 不 会标记为受限节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵有效的树
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * restricted 中的所有值 互不相同
 * 通过次数7,323提交次数16,784
 */
public class Code1 {

    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        //访问过的节点
        Set<Integer> result = new HashSet<>();
        //无法访问的节点
        Set<Integer> cannotSet = new HashSet<>();
        //循环
        for (int i : restricted) {
            //记录无法访问的节点
            cannotSet.add(i);
        }
        //缓存
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //指针
        int p = 0;
        //循环
        while (p < n) {
            //初始化set
            map.put(p++, new HashSet<>());
        }
        //循环
        for (int[] edge : edges) {
            //记录结果
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //默认从0走
        result.add(0);
        //从这里开始
        Set<Integer> link = map.get(0);
        //循环
        while (link.size() > 0) {
            //下一级
            Set<Integer> nextLink = new HashSet<>();
            //循环
            for (Integer integer : link) {
                //如果走过了
                if (result.contains(integer)) {
                    //过
                    continue;
                }
                //如果无法访问
                if (cannotSet.contains(integer)) {
                    //过
                    continue;
                }
                //记录走过了
                result.add(integer);
                //记录可能访问的节点列表
                nextLink.addAll(map.get(integer));
            }
            //下一个
            link = nextLink;
        }
        //返回结果
        return result.size();
    }

    public static void main(String[] args) {
        System.out.println(new Code1().reachableNodes(7, new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{3, 1},
                new int[]{4, 0},
                new int[]{0, 5},
                new int[]{5, 6}
        }, new int[]{4, 5}));
    }


}
