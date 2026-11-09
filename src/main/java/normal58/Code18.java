package normal58;

import java.util.ArrayDeque;

/**
 * 4103. 按类型和颜色删除元素
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 给你三个整数数组 types、colors 和 groupSize，其中 types 和 colors 的长度为 n，groupSize 的长度为 m。
 * <p>
 * types[i] 表示下标 i 处元素的类型。
 * colors[i] 表示下标 i 处元素的颜色。
 * groupSize[t] 表示类型为 t 的删除组需要的元素数量。
 * 在一次操作中，如果 恰好 groupSize[t] 个 连续 元素都具有类型 t 且颜色 相同 ，你可以将它们移除。
 * <p>
 * 在每次移除后，剩余的元素会重新 相邻 ，同时保持它们的相对顺序。
 * <p>
 * 如果可以通过一系列有效操作移除所有元素，返回 true。否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： types = [0,1,1,0], colors = [5,3,3,5] , groupSize = [2,2]
 * <p>
 * 输出： true
 * <p>
 * 解释：
 * <p>
 * 首先，移除下标 1 和 2 处的连续元素。这两个元素的类型均为 1，颜色均为 3，且组大小等于 groupSize[1] = 2。
 * 剩余的序列为：types = [0, 0]，colors = [5, 5]
 * 现在移除剩下的两个元素。它们的类型为 0，颜色为 5，且组大小等于 groupSize[0] = 2。
 * 所有元素已被移除，因此答案是 true。
 * 示例 2：
 * <p>
 * 输入： types = [0,1,0], colors = [9,9,9], groupSize = [3,2]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 无法执行任何有效操作，因为没有一个连续组满足其所需的大小。
 * 因此，无法移除所有元素，所以答案是 false。
 * 示例 3：
 * <p>
 * 输入： types = [2,0,1,2], colors = [7,5,4,7], groupSize = [3,1,2]
 * <p>
 * 输出： false
 * <p>
 * 解释：
 * <p>
 * 移除下标 2 处的元素。它的类型为 1，颜色为 4，并形成一个大小为 groupSize[1] = 1 的连续组。
 * 剩余的序列为：types = [2, 0, 2]，colors = [7, 5, 7]。
 * 无法再执行进一步的操作，因此答案是 false。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n == types.length == colors.length <= 105
 * 1 <= m == groupSize.length <= 105
 * 0 <= types[i] <= m - 1
 * 1 <= colors[i] <= 105
 * 1 <= groupSize[t] <= n
 *
 */
public class Code18 {

    private static class Node {

        //类型
        private int type;
        //颜色
        private int color;

        //当前长度
        private int size;
        //目标长度
        private int targetSize;

        //初始化
        public Node(int type, int color, int targetSize) {
            this.type = type;
            this.color = color;
            this.size = 1;
            this.targetSize = targetSize;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "type=" + type +
                    ", color=" + color +
                    ", size=" + size +
                    ", targetSize=" + targetSize +
                    '}';
        }

    }

    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        //节点队列
        ArrayDeque<Node> queue = new ArrayDeque<>();
        //循环
        for (int i = 0; i < types.length; i++) {
            //初始化节点
            Node node = new Node(types[i], colors[i], groupSize[types[i]]);
            //特殊情况
            if (node.targetSize == 1) {
                //本轮过
                continue;
            }
            //如果队列为空
            if (queue.isEmpty()) {
                //直接加入
                queue.add(node);
                //本轮过
                continue;
            }
            //获取上一个节点
            Node lastNode = queue.peekLast();
            //如果类型和颜色相同
            if (lastNode.type == node.type && lastNode.color == node.color) {
                //长度+1,判断是否到目标删除
                if (++lastNode.size == lastNode.targetSize) {
                    //移除
                    queue.removeLast();
                }
            } else {
                //直接加入
                queue.add(node);
            }
        }
        //返回结果
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        new Code18().canRemoveAll(new int[]{0, 1, 1, 0}, new int[]{5, 3, 3, 5}, new int[]{2, 2});
    }

}
