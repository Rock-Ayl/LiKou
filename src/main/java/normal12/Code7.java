package normal12;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-02-25
 * 207. 课程表
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 105
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */
public class Code7 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //缓存
        Map<Integer, Set<Integer>> map = new HashMap<>();
        //循环
        for (int[] prerequisite : prerequisites) {
            //获取/初始化
            Set<Integer> list = map.getOrDefault(prerequisite[0], new HashSet<>());
            //记录前置
            list.add(prerequisite[1]);
            map.put(prerequisite[0], list);
        }
        //所有
        Set<Integer> all = new HashSet<>();
        //指针
        int p = 0;
        //循环
        while (p < numCourses) {
            //叠加
            all.add(p++);
        }
        //当前完成次数
        int count = 1;
        //如果还有并且每次都有完成
        while (all.size() > 0 && count > 0) {
            //本次默认
            count = 0;
            //遍历
            Iterator<Integer> iterator = all.iterator();
            //循环
            while (iterator.hasNext()) {
                //当前
                Integer num = iterator.next();
                //如果map没有前置
                if (map.containsKey(num) == false) {
                    //+1
                    count++;
                    //直接完成
                    iterator.remove();
                } else {
                    //获取前置
                    Set<Integer> thisSet = map.get(num);
                    //遍历
                    Iterator<Integer> iterator2 = thisSet.iterator();
                    //如果有
                    while (iterator2.hasNext()) {
                        //下一个
                        Integer integer = iterator2.next();
                        //如果不存在
                        if (all.contains(integer) == false) {
                            //删除
                            iterator2.remove();
                        }
                    }
                    //如果没了
                    if (thisSet.isEmpty()) {
                        //+1
                        count++;
                        //完成
                        iterator.remove();
                    }
                }
            }
        }
        //是否走过
        return all.size() == 0;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().canFinish(2, new int[][]{
                new int[]{1, 0}
        }));
    }

}
