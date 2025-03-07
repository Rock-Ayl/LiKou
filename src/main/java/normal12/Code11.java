package normal12;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-03-01
 * 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * <p>
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * <p>
 * 输入：triangle = [[-10]]
 * 输出：-10
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -104 <= triangle[i][j] <= 104
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？
 */
public class Code11 {

    //全局
    List<List<Integer>> triangle;
    //每个路径最小距离
    Map<Integer, Map<Integer, Integer>> map = new HashMap<>();

    //不断走下去
    public void next(int p, int deep, int lastSum) {
        //如果越界
        if (deep == triangle.size() || p == triangle.get(deep).size()) {
            //过
            return;
        }
        //当前值
        int num = triangle.get(deep).get(p);
        //当前消费
        int sum = lastSum + num;
        //当前深度map
        Map<Integer, Integer> deepMap = map.get(deep);
        //如果走过了
        if (deepMap.containsKey(p)) {
            //获取最小
            int minSum = deepMap.get(p);
            //如果现在已经更多了
            if (sum >= minSum) {
                //过
                return;
            }
        }
        //记录更小
        deepMap.put(p, sum);
        //下一级
        next(p, deep + 1, sum);
        next(p + 1, deep + 1, sum);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        //全局
        this.triangle = triangle;
        //循环
        for (int i = 0; i < triangle.size(); i++) {
            //初始化每层深度的缓存map
            map.put(i, new HashMap<>());
        }
        //开始走
        next(0, 0, 0);
        //初始化最小值
        int min = Integer.MAX_VALUE;
        //最大深度
        int maxDeep = triangle.size() - 1;
        //最大深度的map
        Map<Integer, Integer> lastDeepMap = map.get(maxDeep);
        //循环
        for (Map.Entry<Integer, Integer> entry : lastDeepMap.entrySet()) {
            //如果更小
            if (entry.getValue() < min) {
                //刷新最小值
                min = entry.getValue();
            }
        }
        //结果
        return min;
    }

    public int star(List<List<Integer>> triangle) {
        //深度
        int deep = triangle.size();
        //初始化缓存
        int[][] cache = new int[deep][deep];
        //第一级默认
        cache[0][0] = triangle.get(0).get(0);
        //开始计算
        for (int i = 1; i < deep; ++i) {
            cache[i][0] = cache[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                cache[i][j] = Math.min(cache[i - 1][j - 1], cache[i - 1][j]) + triangle.get(i).get(j);
            }
            cache[i][i] = cache[i - 1][i - 1] + triangle.get(i).get(i);
        }
        //最小值
        int minTotal = cache[deep - 1][0];
        //循环
        for (int i = 1; i < deep; ++i) {
            //计算最小值
            minTotal = Math.min(minTotal, cache[deep - 1][i]);
        }
        //返回
        return minTotal;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();

        List<Integer> one = Arrays.asList(2);
        List<Integer> two = Arrays.asList(3, 4);
        List<Integer> three = Arrays.asList(6, 5, 7);
        List<Integer> four = Arrays.asList(4, 1, 8, 3);
        triangle.add(one);
        triangle.add(two);
        triangle.add(three);
        triangle.add(four);
        System.out.println(new Code11().star(triangle));
    }

}
