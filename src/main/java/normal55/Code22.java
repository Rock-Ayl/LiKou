package normal55;

import java.util.*;

/**
 * 373. 查找和最小的 K 对数字
 * 算术评级: 5
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * <p>
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * <p>
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [[1,2],[1,4],[1,6]]
 * 解释: 返回序列中的前 3 对数：
 * [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 * 示例 2:
 * <p>
 * 输入: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
 * 输出: [[1,1],[1,1]]
 * 解释: 返回序列中的前 2 对数：
 * [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums1.length, nums2.length <= 105
 * -109 <= nums1[i], nums2[i] <= 109
 * nums1 和 nums2 均为 升序排列
 * 1 <= k <= 104
 * k <= nums1.length * nums2.length
 */
public class Code22 {

    private static class Node {

        //索引1
        private int index1;

        //索引2
        private int index2;

        //求和
        private int sum;

        //初始化
        public Node(int[] nums1, int[] nums2, int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
            //计算和
            this.sum = nums1[index1] + nums2[index2];
        }

        @Override
        public boolean equals(Object o) {
            //强转
            Node node = (Node) o;
            //判断
            return index1 == node.index1
                    && index2 == node.index2
                    && sum == node.sum;
        }

        @Override
        public int hashCode() {
            //hashCode
            return Objects.hash(index1, index2, sum);
        }

        @Override
        public String toString() {
            return "Node{" +
                    "index1=" + index1 +
                    ", index2=" + index2 +
                    ", sum=" + sum +
                    '}';
        }

    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        //已经加入的集合
        Set<Node> nodeSet = new HashSet<>();
        //初始化优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.sum - b.sum);
        //默认
        queue.add(new Node(nums1, nums2, 0, 0));
        //结果
        List<List<Integer>> result = new ArrayList<>(k);
        //循环
        while (result.size() < k) {
            //拉取最小的一个
            Node minNode = queue.poll();
            //记录当前数对
            result.add(Arrays.asList(nums1[minNode.index1], nums2[minNode.index2]));
            //如果有后续情况1
            if (minNode.index1 + 1 < nums1.length) {
                //新节点
                Node node = new Node(nums1, nums2, minNode.index1 + 1, minNode.index2);
                //如果是第一次加入
                if (nodeSet.add(node) == true) {
                    //添加
                    queue.add(node);
                }
            }
            //如果有后续情况2
            if (minNode.index2 + 1 < nums2.length) {
                //新节点
                Node node = new Node(nums1, nums2, minNode.index1, minNode.index2 + 1);
                //如果是第一次加入
                if (nodeSet.add(node) == true) {
                    //添加
                    queue.add(node);
                }
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new Code22().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println();
    }

}
