package normal20;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-05-15
 * 剑指 Offer II 110. 所有路径
 * 给定一个有 n 个节点的有向无环图，用二维数组 graph 表示，请找到所有从 0 到 n-1 的路径并输出（不要求按顺序）。
 * <p>
 * graph 的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些结点（译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a ），若为空，就是没有下一个节点了。
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
 * 示例 3：
 * <p>
 * 输入：graph = [[1],[]]
 * 输出：[[0,1]]
 * 示例 4：
 * <p>
 * 输入：graph = [[1,2,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,2,3],[0,3]]
 * 示例 5：
 * <p>
 * 输入：graph = [[1,3],[2],[3],[]]
 * 输出：[[0,1,2,3],[0,3]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == graph.length
 * 2 <= n <= 15
 * 0 <= graph[i][j] < n
 * graph[i][j] != i
 * 保证输入为有向无环图 (GAD)
 * <p>
 * <p>
 * 注意：本题与主站 797 题相同：https://leetcode-cn.com/problems/all-paths-from-source-to-target/
 */
public class Code13 {

    //本次结果
    private List<List<Integer>> result = new ArrayList<>();

    //走下去
    public void next(int start, int target, LinkedList<Integer> list, int[][] graph) {
        //如果是目标结果
        if (start == target) {
            //初始化结果
            result.add(new LinkedList<>(list));
            //过
            return;
        }
        //循环
        for (int i : graph[start]) {
            //记录
            list.addLast(i);
            //走下去
            next(i, target, list, graph);
            //回溯
            list.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        //初始化
        LinkedList list = new LinkedList<>();
        //组装开始节点
        list.addLast(0);
        //走下去
        next(0, graph.length - 1, list, graph);
        //返回
        return this.result;
    }

    public static void main(String[] args) {
        new Code13().allPathsSourceTarget(new int[][]{
                new int[]{4, 3, 1},
                new int[]{3, 2, 4},
                new int[]{3},
                new int[]{4},
                new int[]{}
        });
    }

}
