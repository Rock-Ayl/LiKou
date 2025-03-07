package normal38;

import javafx.util.Pair;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-11-28
 * 2492. 两个城市间路径的最小分数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个正整数 n ，表示总共有 n 个城市，城市从 1 到 n 编号。给你一个二维数组 roads ，其中 roads[i] = [ai, bi, distancei] 表示城市 ai 和 bi 之间有一条 双向 道路，道路距离为 distancei 。城市构成的图不一定是连通的。
 * <p>
 * 两个城市之间一条路径的 分数 定义为这条路径中道路的 最小 距离。
 * <p>
 * 城市 1 和城市 n 之间的所有路径的 最小 分数。
 * <p>
 * 注意：
 * <p>
 * 一条路径指的是两个城市之间的道路序列。
 * 一条路径可以 多次 包含同一条道路，你也可以沿着路径多次到达城市 1 和城市 n 。
 * 测试数据保证城市 1 和城市n 之间 至少 有一条路径。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, roads = [[1,2,9],[2,3,6],[2,4,5],[1,4,7]]
 * 输出：5
 * 解释：城市 1 到城市 4 的路径中，分数最小的一条为：1 -> 2 -> 4 。这条路径的分数是 min(9,5) = 5 。
 * 不存在分数更小的路径。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：n = 4, roads = [[1,2,2],[1,3,4],[3,4,7]]
 * 输出：2
 * 解释：城市 1 到城市 4 分数最小的路径是：1 -> 2 -> 1 -> 3 -> 4 。这条路径的分数是 min(2,2,4,7) = 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n <= 105
 * 1 <= roads.length <= 105
 * roads[i].length == 3
 * 1 <= ai, bi <= n
 * ai != bi
 * 1 <= distancei <= 104
 * 不会有重复的边。
 * 城市 1 和城市 n 之间至少有一条路径。
 */
public class Code2 {

    public int minScore(int n, int[][] roads) {
        //路径缓存
        Map<Integer, List<Pair<Integer, Integer>>> roadMap = new HashMap<>();
        //循环
        for (int[] road : roads) {
            //如果不存在
            if (roadMap.containsKey(road[0]) == false) {
                //初始化
                roadMap.put(road[0], new ArrayList<>());
            }
            //如果不存在
            if (roadMap.containsKey(road[1]) == false) {
                //初始化
                roadMap.put(road[1], new ArrayList<>());
            }
            //记录路径
            roadMap.get(road[0]).add(new Pair<>(road[1], road[2]));
            roadMap.get(road[1]).add(new Pair<>(road[0], road[2]));
        }
        //最小分数
        int min = Integer.MAX_VALUE;
        //已经走过的路径
        Set<Integer> walkedSet = new HashSet<>();
        //本次要走过的路径,默认从1走
        Set<Integer> walkSet = new HashSet<>(Arrays.asList(1));
        //下次要走的路径
        Set<Integer> nextWalkSet = new HashSet<>();
        //如果还有路
        while (walkSet.isEmpty() == false) {
            //循环
            for (Integer start : walkSet) {
                //记录其已经走过了
                walkedSet.add(start);
                //获取其可以走过的路径
                List<Pair<Integer, Integer>> pairs = roadMap.get(start);
                //循环
                for (Pair<Integer, Integer> pair : pairs) {
                    //如果走过了
                    if (walkedSet.contains(pair.getKey())) {
                        //本轮过
                        continue;
                    }
                    //记录其要走
                    nextWalkSet.add(pair.getKey());
                    //刷新最小结果
                    min = Math.min(pair.getValue(), min);
                }
            }
            //临时指针
            Set<Integer> midSet = walkSet;
            //交换
            walkSet = nextWalkSet;
            nextWalkSet = midSet;
            //清空
            nextWalkSet.clear();
        }
        //返回最小情况
        return min;
    }

    int curMinScore = Integer.MAX_VALUE;

    public int start(int n, int[][] roads) {
        int[] father = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            father[i] = i;
            rank[i] = 1;
        }
        for (int i = 0; i < roads.length; i++) {
            merge(roads[i][0], roads[i][1], father, rank);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < roads.length; i++) {
            if (find(roads[i][1], father) == find(n, father)) {
                res = Math.min(res, roads[i][2]);
            }
        }
        return res;
    }

    void merge(int x, int y, int[] father, int[] rank) {
        int fatherX = find(x, father);
        int fatherY = find(y, father);
        if (rank[fatherX] <= rank[fatherY]) {
            father[fatherX] = fatherY;
        } else {
            father[fatherY] = fatherX;
        }
        if (fatherY != fatherX && rank[fatherY] == rank[fatherX]) {
            rank[fatherY]++;
        }
    }

    int find(int x, int[] father) {
        return x == father[x] ? x : (father[x] = find(father[x], father));
    }

    public static void main(String[] args) {
        System.out.println(new Code2().start(36, new int[][]{
                new int[]{7, 11, 418},
                new int[]{13, 23, 287},
                new int[]{16, 25, 7891},
                new int[]{15, 7, 9695},
                new int[]{4, 3, 9569},
                new int[]{17, 7, 1809},
                new int[]{14, 3, 4720},
                new int[]{14, 4, 6118},
                new int[]{9, 2, 4290},
                new int[]{32, 17, 5645},
                new int[]{14, 16, 426},
                new int[]{36, 7, 6721},
                new int[]{13, 30, 9444},
                new int[]{3, 25, 4635},
                new int[]{33, 5, 1669},
                new int[]{22, 18, 8910},
                new int[]{5, 28, 7865},
                new int[]{13, 10, 9466},
                new int[]{7, 9, 2457},
                new int[]{11, 8, 4711},
                new int[]{17, 11, 6308},
                new int[]{7, 34, 3789},
                new int[]{8, 33, 9659},
                new int[]{16, 3, 4187},
                new int[]{16, 20, 3595},
                new int[]{23, 10, 6251},
                new int[]{26, 22, 6180},
                new int[]{4, 16, 5577},
                new int[]{26, 7, 5398},
                new int[]{6, 36, 8671},
                new int[]{10, 19, 3028},
                new int[]{23, 30, 1330},
                new int[]{19, 13, 8315},
                new int[]{25, 20, 4740},
                new int[]{25, 4, 5818},
                new int[]{30, 10, 8030},
                new int[]{30, 19, 7527},
                new int[]{28, 6, 6804},
                new int[]{21, 27, 1746},
                new int[]{18, 9, 5189},
                new int[]{7, 27, 6560},
                new int[]{20, 14, 2450},
                new int[]{27, 32, 3951},
                new int[]{2, 21, 3927},
                new int[]{1, 15, 9283},
                new int[]{3, 20, 5428},
                new int[]{15, 26, 5871},
                new int[]{19, 23, 4533},
                new int[]{14, 25, 6992},
                new int[]{4, 20, 5831}
        }));
    }

}
