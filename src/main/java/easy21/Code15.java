package easy21;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-07-27
 * 1971. 寻找图中是否存在路径
 * 有一个具有 n个顶点的 双向 图，其中每个顶点标记从 0 到 n - 1（包含 0 和 n - 1）。图中的边用一个二维整数数组 edges 表示，其中 edges[i] = [ui, vi] 表示顶点 ui 和顶点 vi 之间的双向边。 每个顶点对由 最多一条 边连接，并且没有顶点存在与自身相连的边。
 * <p>
 * 请你确定是否存在从顶点 start 开始，到顶点 end 结束的 有效路径 。
 * <p>
 * 给你数组 edges 和整数 n、start和end，如果从 start 到 end 存在 有效路径 ，则返回 true，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[1,2],[2,0]], start = 0, end = 2
 * 输出：true
 * 解释：存在由顶点 0 到顶点 2 的路径:
 * - 0 → 1 → 2
 * - 0 → 2
 * 示例 2：
 * <p>
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[3,5],[5,4],[4,3]], start = 0, end = 5
 * 输出：false
 * 解释：不存在由顶点 0 到顶点 5 的路径.
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 2 * 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ui, vi <= n - 1
 * ui != vi
 * 0 <= start, end <= n - 1
 * 不存在双向边
 * 不存在指向顶点自身的边
 */
public class Code15 {

    /**
     * 自己写的
     */

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        //判空
        if (n == 1) {
            //是
            return true;
        }
        //初始化路径缓存
        Map<Integer, Set<Integer>> map = new HashMap<>(n);
        //指针
        int p = 0;
        //循环
        while (p < n) {
            //初始化set
            map.put(p++, new HashSet<>());
        }
        //循环
        for (int[] edge : edges) {
            //记录
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //初始化走过的缓存
        int[] alreadyWalk = new int[n];
        //初始化可以走
        Set<Integer> walk = new HashSet<>();
        //最开始可以走起始点
        walk.add(source);
        //可以走到的位置
        Set<Integer> next;
        //循环
        while (walk.size() > 0) {
            //初始化本次到达的位置
            next = new HashSet<>();
            //循环
            for (Integer start : walk) {
                //循环
                for (Integer end : map.get(start)) {
                    //如果走过了
                    if (alreadyWalk[end]++ > 0) {
                        //过
                        continue;
                    }
                    //如果是目标
                    if (end == destination) {
                        //直接返回
                        return true;
                    }
                    //记录
                    next.add(end);
                }
            }
            //下一轮
            walk = next;
        }
        //不可以
        return false;
    }

    /**
     * star 并查集
     */

    private int[] root;

    public boolean star(int n, int[][] edges, int source, int destination) {
        root = new int[n];
        for (int i = 0; i < n; i++) {
            root[i] = i;
        }
        for (int[] edge : edges) {
            union(edge[0], edge[1]);
            if (find(source) == find(destination)) return true;
        }
        return find(source) == find(destination);
    }

    private void union(int p, int q) {
        root[find(p)] = find(q);
    }

    private int find(int n) {
        if (root[n] == n) {
            return n;
        } else {
            return root[n] = find(root[n]);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code15().star(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{3, 5},
                new int[]{5, 4},
                new int[]{4, 3},
        }, 0, 5));
    }

}
