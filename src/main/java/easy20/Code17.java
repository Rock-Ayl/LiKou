package easy20;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-07-06
 * LCP 07. 传递信息
 * 小朋友 A 在和 ta 的小伙伴们玩传信息游戏，游戏规则如下：
 * <p>
 * 有 n 名玩家，所有玩家编号分别为 0 ～ n-1，其中小朋友 A 的编号为 0
 * 每个玩家都有固定的若干个可传信息的其他玩家（也可能没有）。传信息的关系是单向的（比如 A 可以向 B 传信息，但 B 不能向 A 传信息）。
 * 每轮信息必须需要传递给另一个人，且信息可重复经过同一个人
 * 给定总玩家数 n，以及按 [玩家编号,对应可传递玩家编号] 关系组成的二维数组 relation。返回信息从小 A (编号 0 ) 经过 k 轮传递到编号为 n-1 的小伙伴处的方案数；若不能到达，返回 0。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 5, relation = [[0,2],[2,1],[3,4],[2,3],[1,4],[2,0],[0,4]], k = 3
 * <p>
 * 输出：3
 * <p>
 * 解释：信息从小 A 编号 0 处开始，经 3 轮传递，到达编号 4。共有 3 种方案，分别是 0->2->0->4， 0->2->1->4， 0->2->3->4。
 * <p>
 * 示例 2：
 * <p>
 * 输入：n = 3, relation = [[0,2],[2,1]], k = 2
 * <p>
 * 输出：0
 * <p>
 * 解释：信息不能从小 A 处经过 2 轮传递到编号 2
 * <p>
 * 限制：
 * <p>
 * 2 <= n <= 10
 * 1 <= k <= 5
 * 1 <= relation.length <= 90, 且 relation[i].length == 2
 * 0 <= relation[i][0],relation[i][1] < n 且 relation[i][0] != relation[i][1]
 */
public class Code17 {

    //结果数
    int result = 0;
    //目标
    int target;
    //可走路径缓存
    Map<Integer, List<Integer>> map = new HashMap<>();

    //不断走
    public void walk(int p, int size) {
        //判断能不能走,不能则清算
        if (size == 0) {
            //如果是目标
            if (p == target) {
                //记录
                result++;
            }
            //结束
            return;
        }
        //如果不能走
        if (map.containsKey(p) == false) {
            //结束
            return;
        }
        //可以走的路径
        List<Integer> walkList = map.get(p);
        //下一个次数
        int nextSize = size - 1;
        //循环
        for (Integer nextP : walkList) {
            //继续走
            walk(nextP, nextSize);
        }
    }

    public int numWays(int n, int[][] relation, int k) {
        //循环
        for (int[] ints : relation) {
            //key
            int key = ints[0];
            //如果不存在
            if (map.containsKey(key) == false) {
                //初始化
                map.put(key, new ArrayList<>());
            }
            //直接组装
            map.get(key).add(ints[1]);
        }
        //初始化目标
        target = n - 1;
        //走
        walk(0, k);
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code17().numWays(5, new int[][]{
                new int[]{0, 2},
                new int[]{2, 1},
                new int[]{3, 4},
                new int[]{2, 3},
                new int[]{1, 4},
                new int[]{2, 0},
                new int[]{0, 4},
        }, 3));
    }

}
