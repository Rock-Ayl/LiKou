package normal28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-01-29
 * 2685. 统计完全连通分量的数量
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n 。现有一个包含 n 个顶点的 无向 图，顶点按从 0 到 n - 1 编号。给你一个二维整数数组 edges 其中 edges[i] = [ai, bi] 表示顶点 ai 和 bi 之间存在一条 无向 边。
 * <p>
 * 返回图中 完全连通分量 的数量。
 * <p>
 * 如果在子图中任意两个顶点之间都存在路径，并且子图中没有任何一个顶点与子图外部的顶点共享边，则称其为 连通分量 。
 * <p>
 * 如果连通分量中每对节点之间都存在一条边，则称其为 完全连通分量 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4]]
 * 输出：3
 * 解释：如上图所示，可以看到此图所有分量都是完全连通分量。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, edges = [[0,1],[0,2],[1,2],[3,4],[3,5]]
 * 输出：1
 * 解释：包含节点 0、1 和 2 的分量是完全连通分量，因为每对节点之间都存在一条边。
 * 包含节点 3 、4 和 5 的分量不是完全连通分量，因为节点 4 和 5 之间不存在边。
 * 因此，在图中完全连接分量的数量是 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 50
 * 0 <= edges.length <= n * (n - 1) / 2
 * edges[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 不存在重复的边
 */
public class Code12 {

    public int countCompleteComponents(int n, int[][] edges) {

        /**
         * 统计关系缓存
         */

        //缓存
        Map<Integer, Set<Integer>> cacheMap = new HashMap<>();
        //循环
        for (int i = 0; i < n; i++) {
            //缓存
            cacheMap.put(i, new HashSet<>());
        }
        //循环
        for (int[] edge : edges) {
            //记录路径
            cacheMap.get(edge[0]).add(edge[1]);
            cacheMap.get(edge[1]).add(edge[0]);
        }

        /**
         * 开始不断循环,一个一个组计算
         */

        //结果数量
        int count = 0;
        //如果还有内容
        while (cacheMap.isEmpty() == false) {

            /**
             * 计算本次分组
             */

            //随机获取一个节点
            Integer firstKey = cacheMap
                    .keySet()
                    .stream()
                    .findFirst()
                    .orElse(null);
            //本次一组key的集合
            Set<Integer> groupKeySet = new HashSet<>();
            //不断递归的key集合
            Set<Integer> thisKeySet = new HashSet<>();
            //不断递归的下一批key集合
            Set<Integer> nextKeySet = new HashSet<>();
            //加入默认key
            groupKeySet.add(firstKey);
            thisKeySet.add(firstKey);
            //如果有
            while (thisKeySet.isEmpty() == false) {
                //循环key
                for (Integer thisKey : thisKeySet) {
                    //获取并叠加
                    nextKeySet.addAll(cacheMap.get(thisKey));
                }
                //删除已经走过的节点
                nextKeySet.removeAll(groupKeySet);
                //记录
                groupKeySet.addAll(nextKeySet);
                //下一步
                thisKeySet.clear();
                thisKeySet.addAll(nextKeySet);
                nextKeySet.clear();
            }

            /**
             * 判断本组是否满足结果,并记录
             */

            //默认成功
            boolean success = true;
            //计算本次目标连接数量
            int targetLink = groupKeySet.size() - 1;
            //循环
            for (Integer groupKey : groupKeySet) {
                //如果不是目标连接数量,说明该分组不是目标
                if (targetLink != cacheMap.get(groupKey).size()) {
                    //记录失败
                    success = false;
                    //跳出
                    break;
                }
            }
            //记录本次结果
            count += success == true ? 1 : 0;

            /**
             * 剔除本次分组的key
             */

            //循环
            for (Integer groupKey : groupKeySet) {
                //删除对应所有key
                cacheMap.remove(groupKey);
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().countCompleteComponents(6, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{1, 2},
                new int[]{3, 4}
        }));
    }

}
