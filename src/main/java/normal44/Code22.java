package normal44;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-07-11
 * 2359. 找到离给定两个节点最近的节点
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 n 个节点的 有向图 ，节点编号为 0 到 n - 1 ，每个节点 至多 有一条出边。
 * <p>
 * 有向图用大小为 n 下标从 0 开始的数组 edges 表示，表示节点 i 有一条有向边指向 edges[i] 。如果节点 i 没有出边，那么 edges[i] == -1 。
 * <p>
 * 同时给你两个节点 node1 和 node2 。
 * <p>
 * 请你返回一个从 node1 和 node2 都能到达节点的编号，使节点 node1 和节点 node2 到这个节点的距离 较大值最小化。如果有多个答案，请返回 最小 的节点编号。如果答案不存在，返回 -1 。
 * <p>
 * 注意 edges 可能包含环。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [2,2,3,-1], node1 = 0, node2 = 1
 * 输出：2
 * 解释：从节点 0 到节点 2 的距离为 1 ，从节点 1 到节点 2 的距离为 1 。
 * 两个距离的较大值为 1 。我们无法得到一个比 1 更小的较大值，所以我们返回节点 2 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：edges = [1,2,-1], node1 = 0, node2 = 2
 * 输出：2
 * 解释：节点 0 到节点 2 的距离为 2 ，节点 2 到它自己的距离为 0 。
 * 两个距离的较大值为 2 。我们无法得到一个比 2 更小的较大值，所以我们返回节点 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == edges.length
 * 2 <= n <= 105
 * -1 <= edges[i] < n
 * edges[i] != i
 * 0 <= node1, node2 < n
 */
public class Code22 {

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        //递归前者
        Map<Integer, Integer> node1Map = walk(edges, new HashMap<>(), node1, 0);
        //递归后者,返回最小结果
        int[] one = walkAndCompare(edges, new HashMap<>(), node1Map, node2, 0);

        //递归后者
        Map<Integer, Integer> node2Map = walk(edges, new HashMap<>(), node2, 0);
        //递归前者,返回最小结果
        int[] two = walkAndCompare(edges, new HashMap<>(), node2Map, node1, 0);

        //如果结果相同
        if (one[1] == two[1]) {
            //返回最小编号
            return Math.min(one[0], two[0]);
        } else {
            //如果左边大
            if (one[1] > two[1]) {
                //返回
                return two[0];
            } else {
                //返回
                return one[0];
            }
        }

    }

    //递归
    private Map<Integer, Integer> walk(int[] edges, Map<Integer, Integer> resultMap, int index, int level) {
        //如果存在
        if (resultMap.containsKey(index)) {
            //过
            return resultMap;
        }
        //记录
        resultMap.put(index, level);
        //下一步
        int next = edges[index];
        //如果没有路
        if (next == -1) {
            //过
            return resultMap;
        }
        //递归
        return walk(edges, resultMap, next, level + 1);
    }

    //递归并对比
    private int[] walkAndCompare(int[] edges, Map<Integer, Integer> resultMap, Map<Integer, Integer> targetMap, int index, int level) {
        //如果存在
        if (resultMap.containsKey(index)) {
            //过
            return new int[]{-1, -1};
        }
        //记录
        resultMap.put(index, level);
        //如果目标出现
        if (targetMap.containsKey(index)) {
            //返回
            return new int[]{index, targetMap.get(index)};
        }
        //下一步
        int next = edges[index];
        //如果没有路
        if (next == -1) {
            //过
            return new int[]{-1, -1};
        }
        //递归
        return walkAndCompare(edges, resultMap, targetMap, next, level + 1);
    }

    public static void main(String[] args) {
        //System.out.println(new Code22().closestMeetingNode(new int[]{2, 2, 3, -1}, 0, 1));
        System.out.println(new Code22().closestMeetingNode(new int[]{5, 3, 1, 0, 2, 4, 5}, 3, 2));
        //System.out.println(new Code22().closestMeetingNode(new int[]{2, 0, 0}, 2, 0));
    }

}
