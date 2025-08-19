package difficult3;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-08-19
 * 768. 最多能完成排序的块 II
 * 1788
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个整数数组 arr 。
 * <p>
 * 将 arr 分割成若干 块 ，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。
 * <p>
 * 返回能将数组分成的最多块数？
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [5,4,3,2,1]
 * 输出：1
 * 解释：
 * 将数组分成2块或者更多块，都无法得到所需的结果。
 * 例如，分成 [5, 4], [3, 2, 1] 的结果是 [4, 5, 1, 2, 3]，这不是有序的数组。
 * 示例 2：
 * <p>
 * 输入：arr = [2,1,3,4,4]
 * 输出：4
 * 解释：
 * 可以把它分成两块，例如 [2, 1], [3, 4, 4]。
 * 然而，分成 [2, 1], [3], [4], [4] 可以得到最多的块数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr.length <= 2000
 * 0 <= arr[i] <= 108
 */
public class Code18 {

    private static class Node {

        //数字
        private int number;

        //是否被使用,默认未被使用
        private boolean used = false;

        //初始化
        public Node(int number) {
            this.number = number;
        }

        //调试
        @Override
        public String toString() {
            return String.format("number=%s,used=%s", this.number, this.used);
        }

    }

    public int maxChunksToSorted(int[] arr) {
        //初始化节点缓存
        Node[] nodeArr = new Node[arr.length];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化节点
            nodeArr[i] = new Node(arr[i]);
        }
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.number - b.number);
        //循环
        for (Node node : nodeArr) {
            //加入队列
            queue.add(node);
        }
        //最大节点
        Node max = null;
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //当前节点
            Node node = nodeArr[i];
            //记录其已经被使用了
            node.used = true;
            //如果没有
            if (max == null || max.number < node.number) {
                //更新最大节点
                max = node;
            }
            //如果还有 and 已经被使用了
            while (queue.isEmpty() == false && queue.peek().used == true) {
                //删除之
                queue.poll();
            }
            //获取右边最小的节点
            Node min = queue.peek();
            //如果左边最大的 <= 右边最小的
            if (min == null || max.number <= min.number) {
                //可以分为一块
                result++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().maxChunksToSorted(new int[]{2, 1, 3, 4, 4}));
        ;
    }

}
