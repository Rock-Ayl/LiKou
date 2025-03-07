package normal27;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-12-27
 * 1054. 距离相等的条形码
 * 提示
 * 中等
 * 183
 * 相关企业
 * 在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
 * <p>
 * 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：barcodes = [1,1,1,2,2,2]
 * 输出：[2,1,2,1,2,1]
 * 示例 2：
 * <p>
 * 输入：barcodes = [1,1,1,1,2,2,3,3]
 * 输出：[1,3,1,3,2,1,2,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= barcodes.length <= 10000
 * 1 <= barcodes[i] <= 10000
 */
public class Code11 {

    public int[] rearrangeBarcodes(int[] barcodes) {

        /**
         * 分组并加入优先队列
         */

        //优先队列
        PriorityQueue<Map.Entry<Integer, Long>> queue = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Long>>() {
            @Override
            public int compare(Map.Entry<Integer, Long> o1, Map.Entry<Integer, Long> o2) {
                //按照count排序
                return o2.getValue().intValue() - o1.getValue().intValue();
            }
        });
        //统计每个key出现的次数,并加入有限队列
        queue.addAll(Arrays
                .stream(barcodes)
                .boxed()
                .collect(Collectors.groupingBy(p -> p, Collectors.counting()))
                .entrySet());
        //初始化结果
        int[] arr = new int[barcodes.length];

        /**
         * 每次计算当前应该是什么
         */

        //循环
        for (int i = 0; i < arr.length; i++) {
            //获取优先级最高的第一个
            Map.Entry<Integer, Long> firstNode = queue.poll();
            //两种情况,优先级最高的是目标,直接使用,否则拿优先级第二的
            if (i == 0 || firstNode.getKey().equals(arr[i - 1]) == false) {

                /**
                 * 使用节点1的key
                 */

                //使用节点1的值
                arr[i] = firstNode.getKey();
                //节点1-1
                firstNode.setValue(firstNode.getValue() - 1);

                /**
                 * 插入节点1
                 */

                //插入节点1
                queue.add(firstNode);
            } else {

                /**
                 * 使用节点2的key
                 */

                //获取第二个节点
                Map.Entry<Integer, Long> secondNode = queue.poll();
                //使用第二个
                arr[i] = secondNode.getKey();
                //节点2-1
                secondNode.setValue(secondNode.getValue() - 1);

                /**
                 * 插入节点1、2
                 */

                //插入节点1
                queue.add(firstNode);
                //插入节点2
                queue.add(secondNode);
            }
        }
        //返回
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().rearrangeBarcodes(new int[]{1, 1, 1, 1, 2, 2, 3, 3}));
    }

}
