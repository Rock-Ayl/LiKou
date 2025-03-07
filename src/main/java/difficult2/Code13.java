package difficult2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-04-29
 * 2050. 并行课程 III
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数 n ，表示有 n 节课，课程编号从 1 到 n 。同时给你一个二维整数数组 relations ，其中 relations[j] = [prevCoursej, nextCoursej] ，表示课程 prevCoursej 必须在课程 nextCoursej 之前 完成（先修课的关系）。同时给你一个下标从 0 开始的整数数组 time ，其中 time[i] 表示完成第 (i+1) 门课程需要花费的 月份 数。
 * <p>
 * 请你根据以下规则算出完成所有课程所需要的 最少 月份数：
 * <p>
 * 如果一门课的所有先修课都已经完成，你可以在 任意 时间开始这门课程。
 * 你可以 同时 上 任意门课程 。
 * 请你返回完成所有课程所需要的 最少 月份数。
 * <p>
 * 注意：测试数据保证一定可以完成所有课程（也就是先修课的关系构成一个有向无环图）。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入：n = 3, relations = [[1,3],[2,3]], time = [3,2,5]
 * 输出：8
 * 解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
 * 你可以在月份 0 同时开始课程 1 和 2 。
 * 课程 1 花费 3 个月，课程 2 花费 2 个月。
 * 所以，最早开始课程 3 的时间是月份 3 ，完成所有课程所需时间为 3 + 5 = 8 个月。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 5, relations = [[1,5],[2,5],[3,5],[3,4],[4,5]], time = [1,2,3,4,5]
 * 输出：12
 * 解释：上图展示了输入数据所表示的先修关系图，以及完成每门课程需要花费的时间。
 * 你可以在月份 0 同时开始课程 1 ，2 和 3 。
 * 在月份 1，2 和 3 分别完成这三门课程。
 * 课程 4 需在课程 3 之后开始，也就是 3 个月后。课程 4 在 3 + 4 = 7 月完成。
 * 课程 5 需在课程 1，2，3 和 4 之后开始，也就是在 max(1,2,3,7) = 7 月开始。
 * 所以完成所有课程所需的最少时间为 7 + 5 = 12 个月。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 5 * 104
 * 0 <= relations.length <= min(n * (n - 1) / 2, 5 * 104)
 * relations[j].length == 2
 * 1 <= prevCoursej, nextCoursej <= n
 * prevCoursej != nextCoursej
 * 所有的先修课程对 [prevCoursej, nextCoursej] 都是 互不相同 的。
 * time.length == n
 * 1 <= time[i] <= 104
 * 先修课程图是一个有向无环图。
 */
public class Code13 {

    private static class Node {

        //花费
        private Integer cost;

        //最大时间
        private Integer maxTime = 0;

        //上级节点数量
        private Integer lastNodeCount = 0;

        //下一级节点
        private Set<Node> nextNodeSet = new HashSet<>();

    }

    //递归
    private void next(Node node, Node father) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //计算本次时间
        int time = father.maxTime + node.cost;
        //刷新最大
        node.maxTime = Math.max(time, node.maxTime);
        //如果还有
        if (--node.lastNodeCount > 0) {
            //过
            return;
        }
        //循环
        for (Node nextNode : node.nextNodeSet) {
            //递归
            next(nextNode, node);
        }
    }

    public int minimumTime(int n, int[][] relations, int[] time) {
        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //父节点缓存
        Set<Node> fatherSet = new HashSet<>();
        //循环
        for (int i = 1; i <= n; i++) {
            //初始化新节点
            Node node = new Node();
            //初始化节点
            nodeMap.put(i, node);
            fatherSet.add(node);
            //记录花费
            node.cost = time[i - 1];
        }
        //循环2
        for (int i = 0; i < relations.length; i++) {
            //当前路线
            int[] relation = relations[i];
            //获取对应两个节点
            Node node1 = nodeMap.get(relation[0]);
            Node node2 = nodeMap.get(relation[1]);
            //关联
            node1.nextNodeSet.add(node2);
            //记录上级数量
            node2.lastNodeCount++;
            //该节点不是父级
            fatherSet.remove(node2);
        }
        //循环
        for (Node father : fatherSet) {
            //父节点默认花费时间
            father.maxTime = father.cost;
            //循环2
            for (Node nextNode : father.nextNodeSet) {
                //递归
                next(nextNode, father);
            }
        }
        //返回最小情况
        return nodeMap.values().stream().map(p -> p.maxTime).mapToInt(Integer::intValue).max().getAsInt();
    }

    public static void main(String[] args) {
        int time = new Code13().minimumTime(5, new int[][]{
                new int[]{1, 5},
                new int[]{2, 5},
                new int[]{3, 5},
                new int[]{3, 4},
                new int[]{4, 5}
        }, new int[]{1, 2, 3, 4, 5});
        System.out.println(time);
    }

}
