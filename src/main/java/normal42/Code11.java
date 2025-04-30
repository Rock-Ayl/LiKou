package normal42;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-04-30
 * 3478. 选出和最大的 K 个元素
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个整数数组，nums1 和 nums2，长度均为 n，以及一个正整数 k 。
 * <p>
 * 对从 0 到 n - 1 每个下标 i ，执行下述操作：
 * <p>
 * 找出所有满足 nums1[j] 小于 nums1[i] 的下标 j 。
 * 从这些下标对应的 nums2[j] 中选出 至多 k 个，并 最大化 这些值的总和作为结果。
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 表示对应下标 i 的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums1 = [4,2,1,5,3], nums2 = [10,20,30,40,50], k = 2
 * <p>
 * 输出：[80,30,0,80,50]
 * <p>
 * 解释：
 * <p>
 * 对于 i = 0 ：满足 nums1[j] < nums1[0] 的下标为 [1, 2, 4] ，选出其中值最大的两个，结果为 50 + 30 = 80 。
 * 对于 i = 1 ：满足 nums1[j] < nums1[1] 的下标为 [2] ，只能选择这个值，结果为 30 。
 * 对于 i = 2 ：不存在满足 nums1[j] < nums1[2] 的下标，结果为 0 。
 * 对于 i = 3 ：满足 nums1[j] < nums1[3] 的下标为 [0, 1, 2, 4] ，选出其中值最大的两个，结果为 50 + 30 = 80 。
 * 对于 i = 4 ：满足 nums1[j] < nums1[4] 的下标为 [1, 2] ，选出其中值最大的两个，结果为 30 + 20 = 50 。
 * 示例 2：
 * <p>
 * 输入：nums1 = [2,2,2,2], nums2 = [3,1,2,3], k = 1
 * <p>
 * 输出：[0,0,0,0]
 * <p>
 * 解释：由于 nums1 中的所有元素相等，不存在满足条件 nums1[j] < nums1[i]，所有位置的结果都是 0 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums1.length == nums2.length
 * 1 <= n <= 105
 * 1 <= nums1[i], nums2[i] <= 106
 * 1 <= k <= n
 */
public class Code11 {

    //节点
    private static class Node {

        //数字
        private int number;

        //孩子集合
        private List<Child> childList = new ArrayList<>();

        //初始化
        public Node(int number) {
            this.number = number;
        }

        //排序
        @Override
        public String toString() {
            return String.format("number=%s", this.number);
        }

        //节点子集
        private static class Child {

            //索引
            private int index;

            //分数
            private int rank;

            //初始化
            public Child(int index, int rank) {
                this.index = index;
                this.rank = rank;
            }

            //排序
            @Override
            public String toString() {
                return String.format("index=%s,rank=%s", this.index, this.rank);
            }

        }

    }

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {

        /**
         * 构建节点并排序
         */

        //缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        //循环
        for (int i = 0; i < nums1.length; i++) {
            //初始化节点
            nodeMap.putIfAbsent(nums1[i], new Node(nums1[i]));
            //加入子级
            nodeMap.get(nums1[i]).childList.add(new Node.Child(i, nums2[i]));
        }
        //初始化数组
        List<Node> nodeList = new ArrayList<>(nodeMap.values());
        //排序
        nodeList.sort((a, b) -> a.number - b.number);

        /**
         * 计算结果
         */

        //优先队列
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> a - b);
        //优先队列和
        long sum = 0L;
        //初始化结果
        long[] result = new long[nums1.length];
        //循环
        for (Node node : nodeList) {
            //如果太多了
            while (queue.size() > k) {
                //拉取并减少
                sum -= queue.poll();
            }
            //循环
            for (Node.Child child : node.childList) {
                //记录本次结果
                result[child.index] = sum;
            }
            //循环
            for (Node.Child child : node.childList) {
                //记录本次分数
                queue.add(child.rank);
                sum += child.rank;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        long[] maxSum = new Code11().findMaxSum(new int[]{4, 2, 1, 5, 3}, new int[]{10, 20, 30, 40, 50}, 2);
        System.out.println();
    }

}
