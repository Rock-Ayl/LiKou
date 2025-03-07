package normal15;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-07-15
 * 797. 所有可能的路径
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 * <p>
 * graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[1,2],[3],[3],[]]
 * 输出：[[0,1,3],[0,2,3]]
 * 解释：有两条路径 0 -> 1 -> 3 和 0 -> 2 -> 3
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：graph = [[4,3,1],[3,2,4],[3],[4],[]]
 * 输出：[[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i（即不存在自环）
 * graph[i] 中的所有元素 互不相同
 * 保证输入为 有向无环图（DAG）
 */
public class Code6 {

    //结果
    List<List<Integer>> result = new ArrayList<>();
    //缓存,记录可以走的节点
    Map<Integer, Set<Integer>> map = new HashMap<>();
    //到目标
    int end;

    //不断走下去
    public void next(int p, LinkedHashSet<Integer> set) {
        //如果到目标了
        if (p == end) {
            //组装结果
            result.add(new ArrayList<>(set));
            //结束
            return;
        }
        //如果没有
        if (map.containsKey(p) == false) {
            //过
            return;
        }
        //下一个路径
        Set<Integer> links = map.get(p);
        //循环
        for (Integer link : links) {
            //如果走过了
            if (set.contains(link)) {
                //本轮过
                continue;
            }
            //走
            set.add(link);
            //下一步
            next(link, set);
            //回溯
            set.remove(link);
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //到目标
        end = graph.length - 1;
        //循环
        for (int i = 0; i < graph.length; i++) {
            //记录
            map.put(i, Arrays.stream(graph[i])
                    .boxed()
                    .collect(Collectors.toSet())
            );
        }
        //初始化
        LinkedHashSet set = new LinkedHashSet<>();
        //默认
        set.add(0);
        //走下去
        next(0, set);
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code6().allPathsSourceTarget(new int[][]{
                new int[]{4, 3, 1},
                new int[]{3, 2, 4},
                new int[]{3},
                new int[]{4},
                new int[]{}
        });
    }
}
