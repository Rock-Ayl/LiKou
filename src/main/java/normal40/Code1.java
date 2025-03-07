package normal40;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-02-07
 * 2121. 相同元素的间隔之和
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始、由 n 个整数组成的数组 arr 。
 * <p>
 * arr 中两个元素的 间隔 定义为它们下标之间的 绝对差 。更正式地，arr[i] 和 arr[j] 之间的间隔是 |i - j| 。
 * <p>
 * 返回一个长度为 n 的数组 intervals ，其中 intervals[i] 是 arr[i] 和 arr 中每个相同元素（与 arr[i] 的值相同）的 间隔之和 。
 * <p>
 * 注意：|x| 是 x 的绝对值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [2,1,3,1,2,3,3]
 * 输出：[4,2,7,2,4,4,5]
 * 解释：
 * - 下标 0 ：另一个 2 在下标 4 ，|0 - 4| = 4
 * - 下标 1 ：另一个 1 在下标 3 ，|1 - 3| = 2
 * - 下标 2 ：另两个 3 在下标 5 和 6 ，|2 - 5| + |2 - 6| = 7
 * - 下标 3 ：另一个 1 在下标 1 ，|3 - 1| = 2
 * - 下标 4 ：另一个 2 在下标 0 ，|4 - 0| = 4
 * - 下标 5 ：另两个 3 在下标 2 和 6 ，|5 - 2| + |5 - 6| = 4
 * - 下标 6 ：另两个 3 在下标 2 和 5 ，|6 - 2| + |6 - 5| = 5
 * 示例 2：
 * <p>
 * 输入：arr = [10,5,10,10]
 * 输出：[5,0,3,4]
 * 解释：
 * - 下标 0 ：另两个 10 在下标 2 和 3 ，|0 - 2| + |0 - 3| = 5
 * - 下标 1 ：只有这一个 5 在数组中，所以到相同元素的间隔之和是 0
 * - 下标 2 ：另两个 10 在下标 0 和 3 ，|2 - 0| + |2 - 3| = 3
 * - 下标 3 ：另两个 10 在下标 0 和 2 ，|3 - 0| + |3 - 2| = 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == arr.length
 * 1 <= n <= 105
 * 1 <= arr[i] <= 105
 */
public class Code1 {

    public long[] getDistances(int[] arr) {

        /**
         * 构建每个数字的前缀和
         */

        //前缀和map
        Map<Integer, List<Long>> numMap = new HashMap<>();

        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前数字
            Integer num = arr[i];
            //如果不存在
            if (numMap.containsKey(num) == false) {
                //初始化
                List<Long> list = new ArrayList<>();
                //第一个
                list.add((long) i);
                //组装
                numMap.put(num, list);
            } else {
                //获取当前
                List<Long> list = numMap.get(num);
                //计算前缀和
                list.add(list.get(list.size() - 1) + i);
            }
        }

        /**
         * 计算结果
         */

        //前缀和使用情况索引
        Map<Integer, Integer> indexMap = new HashMap<>();

        //结果
        long[] result = new long[arr.length];

        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前数字
            int num = arr[i];
            //获取索引,默认从第一个开始
            int sumListIndex = indexMap.getOrDefault(num, 0);
            //获取前缀和列表
            List<Long> sumList = numMap.get(num);
            //计算本次结果
            result[i] = count(sumList, sumListIndex, i);
            //索引缓存+1、覆盖
            indexMap.put(num, ++sumListIndex);
        }

        //返回结果
        return result;
    }

    //计算某个索引的结果
    private long count(List<Long> sumList, int sumListIndex, int index) {
        //左右两边的数量
        int leftCount = sumListIndex;
        int rightCount = sumList.size() - sumListIndex - 1;
        //默认结果
        long result = 0L;
        //如果有左边数量
        if (leftCount > 0) {
            //计算左边的结果、并叠加
            result += ((long) leftCount * index) - sumList.get(sumListIndex - 1);
        }
        //如果有右边数量
        if (rightCount > 0) {
            //计算右边的结果、并叠加
            result += sumList.get(sumList.size() - 1) - sumList.get(sumListIndex) - ((long) rightCount * index);
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().getDistances(new int[]{2, 1, 3, 1, 2, 3, 3}));
    }

}
