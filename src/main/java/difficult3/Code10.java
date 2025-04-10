package difficult3;

import java.util.TreeSet;

/**
 * @Author ayl
 * @Date 2025-04-10
 * 480. 滑动窗口中位数
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 中位数是有序序列最中间的那个数。如果序列的长度是偶数，则没有最中间的数；此时中位数是最中间的两个数的平均数。
 * <p>
 * 例如：
 * <p>
 * [2,3,4]，中位数是 3
 * [2,3]，中位数是 (2 + 3) / 2 = 2.5
 * 给你一个数组 nums，有一个长度为 k 的窗口从最左端滑动到最右端。窗口中有 k 个数，每次窗口向右移动 1 位。你的任务是找出每次窗口移动后得到的新窗口中元素的中位数，并输出由它们组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 给出 nums = [1,3,-1,-3,5,3,6,7]，以及 k = 3。
 * <p>
 * 窗口位置                      中位数
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       1
 * 1 [3  -1  -3] 5  3  6  7      -1
 * 1  3 [-1  -3  5] 3  6  7      -1
 * 1  3  -1 [-3  5  3] 6  7       3
 * 1  3  -1  -3 [5  3  6] 7       5
 * 1  3  -1  -3  5 [3  6  7]      6
 * 因此，返回该滑动窗口的中位数数组 [1,-1,-1,3,5,6]。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 你可以假设 k 始终有效，即：k 始终小于等于输入的非空数组的元素个数。
 * 与真实值误差在 10 ^ -5 以内的答案将被视作正确答案。
 */
public class Code10 {

    //节点
    private static class Node {

        //索引
        private int index;

        //值
        private Integer value;

        //初始化
        public Node(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int hashCode() {
            //索引不同则不同
            return this.index;
        }

        @Override
        public boolean equals(Object obj) {
            //如果不是
            if (obj instanceof Node == false) {
                //不同
                return false;
            }
            //对比
            return ((Node) obj).index == this.index;
        }

        //左堆对比
        public int compareMin(Node other) {
            //对比
            int compare = other.value.compareTo(this.value);
            //如果数字不同
            if (compare != 0) {
                //按照数字
                return compare;
            }
            //默认按照索引
            return this.index - other.index;
        }

        //右堆对比
        public int compareMax(Node other) {
            //对比
            int compare = this.value.compareTo(other.value);
            //如果数字不同
            if (compare != 0) {
                //按照数字
                return compare;
            }
            //默认按照索引
            return this.index - other.index;
        }

        @Override
        public String toString() {
            return String.format("index=%s,value=%s", this.index, this.value);
        }

    }

    public double[] medianSlidingWindow(int[] nums, int k) {

        /**
         * 构建双优先队列,压缩中位数
         */

        //数组
        Node[] nodeArr = new Node[nums.length];
        //双队列
        TreeSet<Node> leftQueue = new TreeSet<>(Node::compareMin);
        TreeSet<Node> rightQueue = new TreeSet<>(Node::compareMax);
        //结束索引
        int end = 0;
        //如果没有装满
        while (end < nums.length && leftQueue.size() + rightQueue.size() < k) {
            //初始化节点
            Node endNode = new Node(end, nums[end]);
            //加入数字并平衡
            addAndBalance(endNode, leftQueue, rightQueue);
            //记录缓存,并+1
            nodeArr[end++] = endNode;
        }

        /**
         * 初始化第一个结果
         */

        //初始化结果
        double[] result = new double[nums.length - k + 1];
        //初始化第一个结果
        result[0] = count(leftQueue, rightQueue);

        /**
         * 开始不断计算结果
         */

        //开始索引
        int start = 0;
        //循环
        while (end < nums.length) {

            /**
             * 加入新节点
             */

            //初始化节点
            Node endNode = new Node(end, nums[end]);
            //加入数字并平衡
            addAndBalance(endNode, leftQueue, rightQueue);
            //记录缓存
            nodeArr[end] = endNode;

            /**
             * 删除旧节点
             */

            //获取左边节点,并+1
            Node startNode = nodeArr[start++];
            //删除数字并平衡
            removeAndBalance(startNode, leftQueue, rightQueue);

            /**
             * 计算结果
             */

            //记录本次结果
            result[end - k + 1] = count(leftQueue, rightQueue);
            //+1
            end++;
        }

        //返回
        return result;
    }

    //加入数字，并平衡
    private void addAndBalance(Node node,
                               TreeSet<Node> leftQueue,
                               TreeSet<Node> rightQueue) {
        //判断加入左边还是右边
        if (rightQueue.isEmpty() == false && rightQueue.first().value < node.value) {
            //加入右边
            rightQueue.add(node);
        } else {
            //默认加入左边
            leftQueue.add(node);
        }
        //如果左边多
        while (leftQueue.size() > rightQueue.size()) {
            //平衡一下
            rightQueue.add(leftQueue.pollFirst());
        }
        //如果右边多
        while (rightQueue.size() > leftQueue.size() + 1) {
            //平衡一下
            leftQueue.add(rightQueue.pollFirst());
        }
    }

    //删除数字，并平衡
    private void removeAndBalance(Node node,
                                  TreeSet<Node> leftQueue,
                                  TreeSet<Node> rightQueue) {
        //判断存在与否
        if (leftQueue.contains(node) == true) {
            //删除左边
            leftQueue.remove(node);
        } else {
            //删除右边
            rightQueue.remove(node);
        }
        //如果左边多
        while (leftQueue.size() > rightQueue.size()) {
            //平衡一下
            rightQueue.add(leftQueue.pollFirst());
        }
        //如果右边多
        while (rightQueue.size() > leftQueue.size() + 1) {
            //平衡一下
            leftQueue.add(rightQueue.pollFirst());
        }
    }

    //获取当前结果
    private double count(TreeSet<Node> leftQueue,
                         TreeSet<Node> rightQueue) {
        //如果平衡
        if (leftQueue.size() == rightQueue.size()) {
            //计算
            return ((((double) leftQueue.first().value) + rightQueue.first().value) / 2D);
        }
        //默认返回
        return rightQueue.first().value;
    }

    public static void main(String[] args) {
        double[] doubles = new Code10().medianSlidingWindow(
                new int[]{
                        2147483647, 2147483647, 2147483647, 2147483647
                }, 3);
        System.out.println();
    }

}
