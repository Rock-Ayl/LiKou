package normal19;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-03-02
 * 210. 课程表 II
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 */
public class Code4 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //结果
        int[] result = new int[numCourses];
        //结果指针
        int resultP = 0;
        //缓存
        Map<Integer, Set<Integer>> nextMap = new HashMap<>();
        Map<Integer, Set<Integer>> lastMap = new HashMap<>();
        //循环
        for (int[] prerequisite : prerequisites) {
            //获取
            Set<Integer> list = nextMap.getOrDefault(prerequisite[0], new HashSet<>());
            //组装
            list.add(prerequisite[1]);
            //记录
            nextMap.put(prerequisite[0], list);
            //获取
            Set<Integer> list2 = lastMap.getOrDefault(prerequisite[1], new HashSet<>());
            //组装
            list2.add(prerequisite[0]);
            //记录
            lastMap.put(prerequisite[1], list2);
        }
        //每次可学习的课程集合
        Set<Integer> set = new HashSet<>();
        //指针
        int p = 0;
        //循环
        while (p < numCourses) {
            //如果没有前置
            if (nextMap.containsKey(p) == false) {
                //记录
                set.add(p);
            }
            //进位
            p++;
        }
        //如果还可以学习下去
        while (set.isEmpty() == false) {
            //本次学习后,可学习的集合
            Set<Integer> nextSet = new HashSet<>();
            //循环
            for (Integer work : set) {
                //记录其可学习
                result[resultP++] = work;
                //如果其是某些课程前置
                if (lastMap.containsKey(work)) {
                    //循环解锁
                    for (Integer finishWork : lastMap.get(work)) {
                        //所有前置
                        Set<Integer> allFinish = nextMap.get(finishWork);
                        //如果只有其本身了
                        if (allFinish.size() == 1) {
                            //删除该任务
                            nextMap.remove(finishWork);
                            //它是下次完成的任务
                            nextSet.add(finishWork);
                        } else {
                            //先删除
                            allFinish.remove(work);
                        }
                    }
                }
            }
            //更换
            set = nextSet;
        }
        //如果没有全部完成
        if (resultP != numCourses) {
            //空
            return new int[]{};
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        new Code4().findOrder(4, new int[][]{
                new int[]{1, 0},
                new int[]{2, 0},
                new int[]{3, 1},
                new int[]{3, 2}
        });
    }

}
