package normal12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-24
 * 743. 网络延迟时间
 * 有 n 个网络节点，标记为 1 到 n。
 * <p>
 * 给你一个列表 times，表示信号经过 有向 边的传递时间。 times[i] = (ui, vi, wi)，其中 ui 是源节点，vi 是目标节点， wi 是一个信号从源节点传递到目标节点的时间。
 * <p>
 * 现在，从某个节点 K 发出一个信号。需要多久才能使所有节点都收到信号？如果不能使所有节点收到信号，返回 -1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：times = [[2,1,1],[2,3,1],[3,4,1]], n = 4, k = 2
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 1
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：times = [[1,2,1]], n = 2, k = 2
 * 输出：-1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= n <= 100
 * 1 <= times.length <= 6000
 * times[i].length == 3
 * 1 <= ui, vi <= n
 * ui != vi
 * 0 <= wi <= 100
 * 所有 (ui, vi) 对都 互不相同（即，不含重复边）
 */
public class Code6 {

    //缓存
    Map<Integer, List<List<Integer>>> nextMap = new HashMap<>();
    //到每个节点的最小cost
    Map<Integer, Integer> costMap = new HashMap<>();

    public void walk(int k, int cost) {
        //如果不能走了
        if (nextMap.containsKey(k) == false) {
            //过
            return;
        }
        //获取可以走的选择
        List<List<Integer>> list = nextMap.get(k);
        //循环
        for (List<Integer> change : list) {
            //目标
            int next = change.get(0);
            //走到这里的花费
            int nextCost = cost + change.get(1);
            //如果已经走过了,尝试对比花费
            if (costMap.containsKey(next)) {
                //如果路更短
                if (nextCost < costMap.get(next)) {
                    //更新
                    costMap.put(next, nextCost);
                    //继续走下去
                    walk(next, nextCost);
                }
            } else {
                //记录花费
                costMap.put(next, nextCost);
                //继续走下去
                walk(next, nextCost);
            }
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {
        //循环
        for (int[] time : times) {
            //获取
            List<List<Integer>> list = nextMap.getOrDefault(time[0], new ArrayList<>());
            //记录
            List<Integer> data = new ArrayList<>(2);
            data.add(time[1]);
            data.add(time[2]);
            list.add(data);
            nextMap.put(time[0], list);
        }
        //初始化起点
        costMap.put(k, 0);
        //走路
        walk(k, 0);
        //如果有没有走到的节点
        if (costMap.size() < n) {
            //过
            return -1;
        }
        //最大
        int max = 0;
        //循环
        for (Map.Entry<Integer, Integer> entry : costMap.entrySet()) {
            //如果更大
            if (entry.getValue() > max) {
                //刷新
                max = entry.getValue();
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().networkDelayTime(new int[][]{
                new int[]{1, 2, 1},
                new int[]{2, 3, 7},
                new int[]{1, 3, 4},
                new int[]{2, 1, 2}
        }, 3, 1));
    }

}
