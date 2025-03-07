package normal31;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-05-17
 * LCR 113. 课程表 II
 * 中等
 * 相关标签
 * 相关企业
 * 现在总共有 numCourses 门课需要选，记为 0 到 numCourses-1。
 * <p>
 * 给定一个数组 prerequisites ，它的每一个元素 prerequisites[i] 表示两门课程之间的先修顺序。 例如 prerequisites[i] = [ai, bi] 表示想要学习课程 ai ，需要先完成课程 bi 。
 * <p>
 * 请根据给出的总课程数  numCourses 和表示先修顺序的 prerequisites 得出一个可行的修课序列。
 * <p>
 * 可能会有多个正确的顺序，只要任意返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: numCourses = 2, prerequisites = [[1,0]]
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2:
 * <p>
 * 输入: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3:
 * <p>
 * 输入: numCourses = 1, prerequisites = []
 * 输出: [0]
 * 解释: 总共 1 门课，直接修第一门课就可。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * prerequisites 中不存在重复元素
 * <p>
 * <p>
 * 注意：本题与主站 210 题相同：https://leetcode-cn.com/problems/course-schedule-ii/
 */
public class Code18 {

    private static class Node {

        //节点的值
        private int value;

        //上一级父节点数量
        private int fatherCount = 0;

        //下一级节点集合
        private Set<Node> childSet = new HashSet<>();

        //初始化
        public Node(int value) {
            this.value = value;
        }

    }

    //结果集及索引
    private int[] resultArr;
    private int resultP;

    private void next(Node node) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //删除一个父亲,如果还有父亲
        if (--node.fatherCount > 0) {
            //过
            return;
        }
        //记录当前节点值
        this.resultArr[this.resultP++] = node.value;
        //循环
        for (Node child : node.childSet) {
            //递归
            next(child);
        }
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化结果集
        this.resultArr = new int[numCourses];
        this.resultP = 0;
        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //主节点集合
        Set<Node> rootNodeSet = new HashSet<>();
        //循环
        for (int i = 0; i < numCourses; i++) {
            //初始化节点
            Node node = new Node(i);
            //组装缓存
            nodeMap.put(i, node);
            rootNodeSet.add(node);
        }
        //循环
        for (int[] prerequisite : prerequisites) {
            //获取父子节点
            Node father = nodeMap.get(prerequisite[1]);
            Node child = nodeMap.get(prerequisite[0]);
            //记录父子关系
            child.fatherCount++;
            father.childSet.add(child);
            //该节点不会是父节点
            rootNodeSet.remove(child);
        }
        //循环主节点
        for (Node root : rootNodeSet) {
            //从主节点开始走
            next(root);
        }
        //如果没有走完
        if (this.resultP < numCourses) {
            //过
            return new int[]{};
        }
        //返回结果
        return this.resultArr;
    }

    public static void main(String[] args) {
        int[] order = new Code18().findOrder(3, new int[][]{
                new int[]{1, 0},
                new int[]{1, 2},
                new int[]{0, 1}
        });
        System.out.println();
    }

}
