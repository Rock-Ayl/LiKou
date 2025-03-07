package easy15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-11-18
 * 1791. 找出星型图的中心节点
 * 有一个无向的 星型 图，由 n 个编号从 1 到 n 的节点组成。星型图有一个 中心 节点，并且恰有 n - 1 条边将中心节点与其他每个节点连接起来。
 * <p>
 * 给你一个二维整数数组 edges ，其中 edges[i] = [ui, vi] 表示在节点 ui 和 vi 之间存在一条边。请你找出并返回 edges 所表示星型图的中心节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：edges = [[1,2],[2,3],[4,2]]
 * 输出：2
 * 解释：如上图所示，节点 2 与其他每个节点都相连，所以节点 2 是中心节点。
 * 示例 2：
 * <p>
 * 输入：edges = [[1,2],[5,1],[1,3],[1,4]]
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 1 <= ui, vi <= n
 * ui != vi
 * 题目数据给出的 edges 表示一个有效的星型图
 */
public class Code3 {

    public int findCenter(int[][] edges) {
        //目标值
        int size = edges.length * edges[0].length / 2;
        //记录
        Map<Integer, Integer> map = new HashMap<>();
        //循环1
        for (int[] edge : edges) {
            //循环2
            for (int i : edge) {
                //当前
                int num = map.getOrDefault(i, 0) + 1;
                //如果已经找到了
                if (num >= size) {
                    //返回
                    return i;
                }
                //+1
                map.put(i, num);
            }
        }
        //最大值
        int max = 0;
        Integer key = null;
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //如果结果更大
            if (entry.getValue() > max) {
                //记录key
                max = entry.getValue();
                key = entry.getKey();
            }
        }
        //返回最大结果
        return key;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().findCenter(new int[][]{
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{4, 2}
        }));
    }
}
