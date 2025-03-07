package normal31;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-05-16
 * 1462. 课程表 IV
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
 * <p>
 * 有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
 * 先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
 * <p>
 * 你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
 * <p>
 * 返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]], queries = [[0,1],[1,0]]
 * 输出：[false,true]
 * 解释：课程 0 不是课程 1 的先修课程，但课程 1 是课程 0 的先修课程。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [], queries = [[1,0],[0,1]]
 * 输出：[false,false]
 * 解释：没有先修课程对，所以每门课程之间是独立的。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：numCourses = 3, prerequisites = [[1,2],[1,0],[2,0]], queries = [[1,0],[1,2]]
 * 输出：[true,true]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= numCourses <= 100
 * 0 <= prerequisites.length <= (numCourses * (numCourses - 1) / 2)
 * prerequisites[i].length == 2
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * 每一对 [ai, bi] 都 不同
 * 先修课程图中没有环。
 * 1 <= queries.length <= 104
 * 0 <= ui, vi <= n - 1
 * ui != vi
 */
public class Code17 {

    private static class Node {

        //上级节点数量
        private int fatherCount = 0;

        //下一级子节点集合
        private Set<Node> childSet = new HashSet<>();

        //所有上级父节点集合
        private Set<Node> allFatherSet = new HashSet<>();

    }

    //判空
    private void next(Node node, Node father) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //记录其所有的父节点
        node.allFatherSet.addAll(father.allFatherSet);
        node.allFatherSet.add(father);
        //如果其还有父亲没有进来
        if (--node.fatherCount > 0) {
            //先不继续下去
            return;
        }
        //循环
        for (Node child : node.childSet) {
            //递归下一级节点
            next(child, node);
        }
    }

    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //父级节点缓存
        Set<Node> rootNodeSet = new HashSet<>();
        //循环
        for (int i = 0; i < numCourses; i++) {
            //初始化节点
            Node node = new Node();
            //组装
            nodeMap.put(i, node);
            rootNodeSet.add(node);
        }
        //循环
        for (int[] prerequisite : prerequisites) {
            //获取父子关系
            Node father = nodeMap.get(prerequisite[0]);
            Node child = nodeMap.get(prerequisite[1]);
            //记录父子关系
            father.childSet.add(child);
            //记录父亲的数量
            ++child.fatherCount;
            //该子节点无法作为主节点,删除之
            rootNodeSet.remove(child);
        }
        //循环1
        for (Node root : rootNodeSet) {
            //循环2
            for (Node node : root.childSet) {
                //递归所有主节点
                next(node, root);
            }
        }
        //初始化结果列表
        List<Boolean> resultList = new ArrayList<>(queries.length);
        //循环问题
        for (int[] query : queries) {
            //获取父子关系,判断孩子的父节点里,有没有父节点
            resultList.add(nodeMap.get(query[1]).allFatherSet.contains(nodeMap.get(query[0])));
        }
        //返回
        return resultList;
    }

    public static void main(String[] args) {
        List<Boolean> list = new Code17().checkIfPrerequisite(
                5,
                new int[][]{
                        new int[]{4, 3},
                        new int[]{4, 1},
                        new int[]{4, 0},
                        new int[]{3, 2},
                        new int[]{3, 1},
                        new int[]{3, 0},
                        new int[]{2, 1},
                        new int[]{2, 0},
                        new int[]{1, 0}
                },
                new int[][]{
                        new int[]{1, 4},
                        new int[]{4, 2},
                        new int[]{0, 1},
                        new int[]{4, 0},
                        new int[]{0, 2},
                        new int[]{1, 3},
                        new int[]{0, 1}
                });
        System.out.println();
    }

}
