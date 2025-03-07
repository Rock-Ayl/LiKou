package difficult3;

import java.util.*;

/**
 * @Author ayl
 * @Date 2024-12-31
 * 239. 滑动窗口最大值
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * <p>
 * 返回 滑动窗口中的最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 * <p>
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * 1 <= k <= nums.length
 */
public class Code4 {

    //节点
    private static class Node {

        //索引
        private int index;

        //数字
        private int num;

        //初始化
        public Node(int index, int num) {
            this.index = index;
            this.num = num;
        }

        //比较
        public int compareTo(Node another) {
            //如果数字不同
            if (this.num != another.num) {
                //按照数字对比
                return this.num - another.num;
            }
            //默认按照索引
            return this.index - another.index;
        }

        /**
         * 重写hash
         *
         * @return
         */
        @Override
        public int hashCode() {
            return this.index;
        }

        /**
         * 重写对比
         *
         * @param obj
         * @return
         */
        @Override
        public boolean equals(Object obj) {
            //如果不是节点对象
            if (obj instanceof Node == false) {
                //不是
                return false;
            }
            //强转
            Node another = (Node) obj;
            //按照索引对比
            return this.index == another.index;
        }

        /**
         * 方便调试
         *
         * @return
         */
        @Override
        public String toString() {
            return String.format("num=%s,index=%s", this.num, this.index);
        }

    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        //初始化节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化节点并组装
            nodeList.add(new Node(i, nums[i]));
        }
        //指针
        int index = 0;
        //优先队列树
        TreeSet<Node> treeSet = new TreeSet<>(Node::compareTo);
        //循环
        while (index < nodeList.size() && treeSet.size() < k) {
            //获取、记录、+1
            treeSet.add(nodeList.get(index++));
        }
        //缓存
        int[] result = new int[nums.length - k + 1];
        //第一个
        result[0] = treeSet.last().num;
        //循环
        for (int i = 1; i < result.length; i++) {
            //计算滑动的节点、+1
            Node first = nodeList.get(index - k);
            Node last = nodeList.get(index++);
            //滑动
            treeSet.add(last);
            treeSet.remove(first);
            //记录最大值
            result[i] = treeSet.last().num;
        }
        //返回结果
        return result;
    }

    //收藏、优先队列
    public int[] star(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ints = new Code4().star(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3);
        System.out.println();
    }

}
