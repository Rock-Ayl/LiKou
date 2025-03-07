package difficult3;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2025-01-10
 * 2251. 花期内花的数目
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，people[i] 是第 i 个人来看花的时间。
 * <p>
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= flowers.length <= 5 * 104
 * flowers[i].length == 2
 * 1 <= starti <= endi <= 109
 * 1 <= people.length <= 5 * 104
 * 1 <= people[i] <= 109
 */
public class Code7 {

    public int[] fullBloomFlowers(int[][] flowers, int[] people) {

        /**
         * 统计花的差分
         */

        //缓存
        Map<Integer, Integer> flowerMap = new HashMap<>();
        //循环
        for (int[] flower : flowers) {
            //获取key,包装
            Integer start = flower[0];
            Integer end = flower[1] + 1;
            //记录差分
            flowerMap.put(start, flowerMap.getOrDefault(start, 0) + 1);
            flowerMap.put(end, flowerMap.getOrDefault(end, 0) - 1);
        }
        //map转list
        List<Map.Entry<Integer, Integer>> nodeList = flowerMap
                .entrySet()
                .stream()
                //根据时间排序
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .collect(Collectors.toList());

        /**
         * 为人排序,因为后来的人可能时间更早
         */

        //人物索引
        Integer[] peopleIndexArr = new Integer[people.length];
        //循环
        for (int i = 0; i < peopleIndexArr.length; i++) {
            //记录
            peopleIndexArr[i] = i;
        }
        //按照到来的时间排序
        Arrays.sort(peopleIndexArr, Comparator.comparingInt(a -> people[a]));

        /**
         * 计算最终结果
         */

        //结果
        int[] result = new int[people.length];
        //指针
        int nodeIndex = 0;
        //当前结果
        int count = 0;
        //循环
        for (int i = 0; i < peopleIndexArr.length; i++) {
            //获取时间
            int time = people[peopleIndexArr[i]];
            //如果在人物到来之前,需要清算
            while (nodeIndex < nodeList.size() && nodeList.get(nodeIndex).getKey() <= time) {
                //清算结果
                count += nodeList.get(nodeIndex++).getValue();
            }
            //记录本次结果
            result[peopleIndexArr[i]] = count;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        int[] ints = new Code7().fullBloomFlowers(new int[][]{
                new int[]{1, 10},
                new int[]{3, 3}
        }, new int[]{
                3, 3, 2
        });
        System.out.println();
    }

}
