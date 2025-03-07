package normal28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-01-26
 * 面试题 04.01. 节点间通路
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 节点间通路。给定有向图，设计一个算法，找出两个节点之间是否存在一条路径。
 * <p>
 * 示例1:
 * <p>
 * 输入：n = 3, graph = [[0, 1], [0, 2], [1, 2], [1, 2]], start = 0, target = 2
 * 输出：true
 * 示例2:
 * <p>
 * 输入：n = 5, graph = [[0, 1], [0, 2], [0, 4], [0, 4], [0, 1], [1, 3], [1, 4], [1, 3], [2, 3], [3, 4]], start = 0, target = 4
 * 输出 true
 * 提示：
 * <p>
 * 节点数量n在[0, 1e5]范围内。
 * 节点编号大于等于 0 小于 n。
 * 图中可能存在自环和平行边。
 */
public class Code10 {

    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        //走路关系图
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //循环
        for (int i = 0; i < n; i++) {
            //初始化
            map.put(i, new HashSet<>());
        }
        //循环
        for (int[] link : graph) {
            //记录
            map.get(link[0]).add(link[1]);
        }
        //当前走过的路
        Set<Integer> walkedSet = new HashSet<>();
        //当前走的路
        Set<Integer> walkSet = new HashSet<>();
        //从这里开始
        walkedSet.add(start);
        walkSet.add(start);
        //如果可以走
        while (walkSet.isEmpty() == false) {
            //下次走的路
            Set<Integer> nextWalkSet = new HashSet<>();
            //循环
            for (Integer num : walkedSet) {
                //获取并记录
                nextWalkSet.addAll(map.get(num));
            }
            //删除走过的
            nextWalkSet.removeAll(walkedSet);
            //记录走过
            walkedSet.addAll(nextWalkSet);
            //如果走过了
            if (nextWalkSet.contains(target)) {
                //是
                return true;
            }
            //下一个
            walkSet = nextWalkSet;
        }
        //默认
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().findWhetherExistsPath(5, new int[][]{
                new int[]{0, 1},
                new int[]{0, 2},
                new int[]{0, 4},
                new int[]{0, 4},
                new int[]{0, 1},
                new int[]{1, 3},
                new int[]{1, 4},
                new int[]{1, 3},
                new int[]{2, 3},
                new int[]{3, 4}
        }, 0, 4));
    }
}
