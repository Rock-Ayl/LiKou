package normal29;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-02-12
 * 1090. 受标签影响的最大值
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 我们有一个 n 项的集合。给出两个整数数组 values 和 labels ，第 i 个元素的值和标签分别是 values[i] 和 labels[i]。还会给出两个整数 numWanted 和 useLimit 。
 * <p>
 * 从 n 个元素中选择一个子集 s :
 * <p>
 * 子集 s 的大小 小于或等于 numWanted 。
 * s 中 最多 有相同标签的 useLimit 项。
 * 一个子集的 分数 是该子集的值之和。
 * <p>
 * 返回子集 s 的最大 分数 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,1,2,2,3], numWanted = 3, useLimit = 1
 * 输出：9
 * 解释：选出的子集是第一项，第三项和第五项。
 * 示例 2：
 * <p>
 * 输入：values = [5,4,3,2,1], labels = [1,3,3,3,2], numWanted = 3, useLimit = 2
 * 输出：12
 * 解释：选出的子集是第一项，第二项和第三项。
 * 示例 3：
 * <p>
 * 输入：values = [9,8,8,7,6], labels = [0,0,0,1,1], numWanted = 3, useLimit = 1
 * 输出：16
 * 解释：选出的子集是第一项和第四项。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == values.length == labels.length
 * 1 <= n <= 2 * 104
 * 0 <= values[i], labels[i] <= 2 * 104
 * 1 <= numWanted, useLimit <= n
 */
public class Code1 {

    //节点
    private class Node {

        //标签
        private int label;

        //值
        private int value;

        //初始化
        public Node(int label, int value) {
            this.label = label;
            this.value = value;
        }

    }

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        //初始化优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> b.value - a.value);
        //循环
        for (int i = 0; i < values.length; i++) {
            //记录节点
            queue.add(new Node(labels[i], values[i]));
        }
        //count缓存
        Map<Integer, Integer> countMap = new HashMap<>();
        //结果
        int sum = 0;
        //如果可以继续拿
        while (numWanted > 0 && queue.isEmpty() == false) {
            //获取最高优先级的
            Node node = queue.poll();
            //当前已使用的次数
            Integer count = countMap.getOrDefault(node.label, 0);
            //如果不能用了
            if (count >= useLimit) {
                //本轮过
                continue;
            }
            //叠加
            sum += node.value;
            //记录已使用
            countMap.put(node.label, count + 1);
            //下一个
            numWanted--;
        }
        //返回结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().largestValsFromLabels(new int[]{
                        9, 8, 8, 7, 6
                }, new int[]{
                        0, 0, 0, 1, 1
                }
                , 3, 1));
    }

}
