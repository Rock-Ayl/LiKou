package normal45;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-07-30
 * 3488. 距离最小相等元素查询
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 环形 数组 nums 和一个数组 queries 。
 * <p>
 * 对于每个查询 i ，你需要找到以下内容：
 * <p>
 * 数组 nums 中下标 queries[i] 处的元素与 任意 其他下标 j（满足 nums[j] == nums[queries[i]]）之间的 最小 距离。如果不存在这样的下标 j，则该查询的结果为 -1 。
 * 返回一个数组 answer，其大小与 queries 相同，其中 answer[i] 表示查询i的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： nums = [1,3,1,4,1,3,2], queries = [0,3,5]
 * <p>
 * 输出： [2,-1,3]
 * <p>
 * 解释：
 * <p>
 * 查询 0：下标 queries[0] = 0 处的元素为 nums[0] = 1 。最近的相同值下标为 2，距离为 2。
 * 查询 1：下标 queries[1] = 3 处的元素为 nums[3] = 4 。不存在其他包含值 4 的下标，因此结果为 -1。
 * 查询 2：下标 queries[2] = 5 处的元素为 nums[5] = 3 。最近的相同值下标为 1，距离为 3（沿着循环路径：5 -> 6 -> 0 -> 1）。
 * 示例 2：
 * <p>
 * 输入： nums = [1,2,3,4], queries = [0,1,2,3]
 * <p>
 * 输出： [-1,-1,-1,-1]
 * <p>
 * 解释：
 * <p>
 * 数组 nums 中的每个值都是唯一的，因此没有下标与查询的元素值相同。所有查询的结果均为 -1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 0 <= queries[i] < nums.length
 */
public class Code13 {

    private static class Node {

        //索引
        private int index;

        //数字
        private int num;

        //上一个节点
        private Node last;

        //下一个节点
        private Node next;

        //初始化
        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=%s,num=%s", this.index, this.num);
        }

    }

    public List<Integer> solveQueries(int[] nums, int[] queries) {

        /**
         * 构建关系
         */

        //节点缓存
        Map<Integer, Node> nodeMap = new HashMap<>();
        Map<Integer, Node> rootNodeMap = new HashMap<>();
        //节点数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //获取数字
            int num = nums[i];
            //初始化节点
            Node node = new Node(i, num);
            //记录节点
            nodeArr[i] = node;
            //如果存在
            if (nodeMap.containsKey(num) == true) {
                //获取上一个节点
                Node last = nodeMap.get(num);
                //关联1 上一个节点
                last.next = node;
                node.last = last;
                //关联2 环
                Node root = rootNodeMap.get(num);
                node.next = root;
                root.last = node;
                //记录新的父级
                nodeMap.put(num, node);
            } else {
                //记录头节点
                rootNodeMap.put(num, node);
                //记录新的父级
                nodeMap.put(num, node);
            }
        }

        /**
         * 计算结果
         */

        //初始化结果
        List<Integer> resultList = new ArrayList<>(queries.length);
        //循环
        for (int i = 0; i < queries.length; i++) {
            //获取目标节点
            Node node = nodeArr[queries[i]];
            //如果没有其他同数字节点
            if (node.last == null && node.next == null) {
                //记录
                resultList.add(-1);
                //本轮过
                continue;
            }
            //计算结果
            int a = node.last == null ? Integer.MAX_VALUE : away(nums, node.index, node.last.index);
            int b = node.next == null ? Integer.MAX_VALUE : away(nums, node.index, node.next.index);
            //记录最小结果
            resultList.add(Math.min(a, b));
        }
        //返回
        return resultList;
    }

    //计算距离
    private int away(int[] nums, int left, int right) {
        //计算大小
        int big = Math.max(left, right);
        int small = Math.min(left, right);
        //普通计算方式
        int a = big - small;
        //环形的计算方式
        int b = nums.length - big + small;
        //返回最小
        return Math.min(a, b);
    }

    public static void main(String[] args) {
        //List<Integer> integers = new Code13().solveQueries(new int[]{1, 3, 1, 4, 1, 3, 2}, new int[]{0, 3, 5});
        List<Integer> integers = new Code13().solveQueries(new int[]{14, 14, 4, 2, 19, 19, 14, 19, 14}, new int[]{8});
        System.out.println();
    }

}
