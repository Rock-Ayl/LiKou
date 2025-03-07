package normal13;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-03-28
 * 1376. 通知所有员工所需的时间
 * 公司里有 n 名员工，每个员工的 ID 都是独一无二的，编号从 0 到 n - 1。公司的总负责人通过 headID 进行标识。
 * <p>
 * 在 manager 数组中，每个员工都有一个直属负责人，其中 manager[i] 是第 i 名员工的直属负责人。对于总负责人，manager[headID] = -1。题目保证从属关系可以用树结构显示。
 * <p>
 * 公司总负责人想要向公司所有员工通告一条紧急消息。他将会首先通知他的直属下属们，然后由这些下属通知他们的下属，直到所有的员工都得知这条紧急消息。
 * <p>
 * 第 i 名员工需要 informTime[i] 分钟来通知它的所有直属下属（也就是说在 informTime[i] 分钟后，他的所有直属下属都可以开始传播这一消息）。
 * <p>
 * 返回通知所有员工这一紧急消息所需要的 分钟数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 1, headID = 0, manager = [-1], informTime = [0]
 * 输出：0
 * 解释：公司总负责人是该公司的唯一一名员工。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 6, headID = 2, manager = [2,2,-1,2,2,2], informTime = [0,0,1,0,0,0]
 * 输出：1
 * 解释：id = 2 的员工是公司的总负责人，也是其他所有员工的直属负责人，他需要 1 分钟来通知所有员工。
 * 上图显示了公司员工的树结构。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 10^5
 * 0 <= headID < n
 * manager.length == n
 * 0 <= manager[i] < n
 * manager[headID] == -1
 * informTime.length == n
 * 0 <= informTime[i] <= 1000
 * 如果员工 i 没有下属，informTime[i] == 0 。
 * 题目 保证 所有员工都可以收到通知。
 */
public class Code14 {

    //最大时长(深度)
    int maxDeep = 0;

    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        //缓存<节点,该节点到重点的总时间>
        Map<Integer, Integer> map = new HashMap<>();
        //最大时间
        int maxTime = 0;
        //循环
        for (int i = 0; i < manager.length; i++) {
            //时间
            int time = 0;
            //当前用户的父亲
            int father = manager[i];
            //如果不是顶级节点
            while (father != -1) {
                //叠加到达父亲花费的时间
                time += informTime[father];
                //如果之前走过了
                if (map.containsKey(father)) {
                    //一口气叠加缓存
                    time += map.get(father);
                    //结束循环
                    break;
                }
                //父亲的父亲
                father = manager[father];
            }
            //记录缓存
            map.put(i, time);
            //刷新最大时间
            maxTime = Math.max(maxTime, time);
        }
        //返回
        return maxTime;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().numOfMinutes(6, 2, new int[]{2, 2, -1, 2, 2, 2}, new int[]{0, 0, 1, 0, 0, 0}));
    }

}
