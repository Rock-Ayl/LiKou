package normal50;

import java.util.*;

/**
 * 3243. 新增道路查询后的最短距离 I
 * 算术评级: 5
 * 第 409 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1568
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数 n 和一个二维整数数组 queries。
 * <p>
 * 有 n 个城市，编号从 0 到 n - 1。初始时，每个城市 i 都有一条单向道路通往城市 i + 1（ 0 <= i < n - 1）。
 * <p>
 * queries[i] = [ui, vi] 表示新建一条从城市 ui 到城市 vi 的单向道路。每次查询后，你需要找到从城市 0 到城市 n - 1 的最短路径的长度。
 * <p>
 * 返回一个数组 answer，对于范围 [0, queries.length - 1] 中的每个 i，answer[i] 是处理完前 i + 1 个查询后，从城市 0 到城市 n - 1 的最短路径的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： n = 5, queries = [[2, 4], [0, 2], [0, 4]]
 * <p>
 * 输出： [3, 2, 1]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 新增一条从 2 到 4 的道路后，从 0 到 4 的最短路径长度为 3。
 * <p>
 * <p>
 * <p>
 * 新增一条从 0 到 2 的道路后，从 0 到 4 的最短路径长度为 2。
 * <p>
 * <p>
 * <p>
 * 新增一条从 0 到 4 的道路后，从 0 到 4 的最短路径长度为 1。
 * <p>
 * 示例 2：
 * <p>
 * 输入： n = 4, queries = [[0, 3], [0, 2]]
 * <p>
 * 输出： [1, 1]
 * <p>
 * 解释：
 * <p>
 * <p>
 * <p>
 * 新增一条从 0 到 3 的道路后，从 0 到 3 的最短路径长度为 1。
 * <p>
 * <p>
 * <p>
 * 新增一条从 0 到 2 的道路后，从 0 到 3 的最短路径长度仍为 1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= n <= 500
 * 1 <= queries.length <= 500
 * queries[i].length == 2
 * 0 <= queries[i][0] < queries[i][1] < n
 * 1 < queries[i][1] - queries[i][0]
 * 查询中没有重复的道路。
 *
 */
public class Code7 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        //道路缓存
        Map<Integer, List<Integer>> linkMap = new HashMap<>();
        //循环
        for (int i = 0; i < n; i++) {
            //初始化道路
            linkMap.put(i, new ArrayList<>(Arrays.asList(i + 1)));
        }
        //结果
        int[] result = new int[queries.length];
        //循环
        for (int i = 0; i < queries.length; i++) {
            //新道路
            int[] query = queries[i];
            //新增本次道路
            linkMap.get(query[0]).add(query[1]);
            //本次路径
            int[] walkArr = new int[n];
            //计算最短路径
            count(linkMap, walkArr);
            //结果
            result[i] = walkArr[walkArr.length - 1];
        }
        //返回
        return result;
    }

    //计算路径
    private void count(Map<Integer, List<Integer>> linkMap, int[] walkArr) {
        //循环
        for (int i = 0; i < walkArr.length - 1; i++) {
            //如果没有走过
            if (walkArr[i + 1] == 0) {
                //前进道下一个
                walkArr[i + 1] = walkArr[i] + 1;
            }
            //循环其他道路
            for (Integer link : linkMap.get(i)) {
                //未访问 or 更短
                if (walkArr[link] == 0 || walkArr[link] > walkArr[i] + 1) {
                    //更新
                    walkArr[link] = walkArr[i] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] ints = new Code7().shortestDistanceAfterQueries(5, new int[][]{{2, 4}, {0, 2}, {0, 4}});
        System.out.println();
    }

}