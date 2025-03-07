package normal28;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-01-18
 * 2316. 统计无向图中无法互相到达点对数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。
 * <p>
 * 请你返回 无法互相到达 的不同 点对数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, edges = [[0,1],[0,2],[1,2]]
 * 输出：0
 * 解释：所有点都能互相到达，意味着没有点对无法互相到达，所以我们返回 0 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 7, edges = [[0,2],[0,5],[2,4],[1,6],[5,4]]
 * 输出：14
 * 解释：总共有 14 个点对互相无法到达：
 * [[0,1],[0,3],[0,6],[1,2],[1,3],[1,4],[1,5],[2,3],[2,6],[3,4],[3,5],[3,6],[4,6],[5,6]]
 * 所以我们返回 14 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * 0 <= edges.length <= 2 * 105
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * 不会有重复边。
 */
public class Code4 {

    public long countPairs(int n, int[][] edges) {
        //如果太小
        if (n < 2) {
            //返回
            return 0;
        }
        //如果没有配对
        if (edges.length < 1) {
            //直接计算
            return (0L + n - 1L) * ((0L + n) / 2L);
        }
        //缓存
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //节点缓存
        Set<Integer> nodeSet = new HashSet<>();
        //循环
        for (int i = 0; i < n; i++) {
            //记录
            map.put(i, new HashSet<>());
            nodeSet.add(i);
        }
        //循环
        for (int[] edge : edges) {
            //记录关系
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        //分组列表
        List<Set<Integer>> groupList = new ArrayList<>();
        //如果还有
        while (nodeSet.isEmpty() == false) {
            //获取一个节点
            Integer first = nodeSet.stream().findFirst().orElse(null);
            //初始化新的分组
            Set<Integer> newGroup = new HashSet<>();
            //记录分组
            groupList.add(newGroup);
            //当前节点分组
            Set<Integer> thisSet = new HashSet<>();
            //加入第一个分组
            thisSet.add(first);
            newGroup.add(first);
            //如果存在
            while (thisSet.isEmpty() == false) {
                //下一级节点
                Set<Integer> nextSet = new HashSet<>();
                //循环
                for (Integer node : thisSet) {
                    //获取下一级并加入
                    nextSet.addAll(map.get(node));
                }
                //不算本次的节点
                nextSet.removeAll(newGroup);
                //加入到分组
                newGroup.addAll(nextSet);
                //下一步
                thisSet = nextSet;
            }
            //剔除这些分组的节点
            nodeSet.removeAll(newGroup);
        }
        //结果
        long sum = 0L;
        //循环分组
        for (Set<Integer> group : groupList) {
            //计算本次
            sum += group.size() * (0L + n - group.size());
        }
        //返回结果
        return sum / 2L;
    }

    public static void main(String[] args) {
        System.out.println(new Code4().countPairs(12, new int[][]{

        }));
    }

}
