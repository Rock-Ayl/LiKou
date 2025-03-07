package normal37;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-11-23
 * 2349. 设计数字容器系统
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 设计一个数字容器系统，可以实现以下功能：
 * <p>
 * 在系统中给定下标处 插入 或者 替换 一个数字。
 * 返回 系统中给定数字的最小下标。
 * 请你实现一个 NumberContainers 类：
 * <p>
 * NumberContainers() 初始化数字容器系统。
 * void change(int index, int number) 在下标 index 处填入 number 。如果该下标 index 处已经有数字了，那么用 number 替换该数字。
 * int find(int number) 返回给定数字 number 在系统中的最小下标。如果系统中没有 number ，那么返回 -1 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["NumberContainers", "find", "change", "change", "change", "change", "find", "change", "find"]
 * [[], [10], [2, 10], [1, 10], [3, 10], [5, 10], [10], [1, 20], [10]]
 * 输出：
 * [null, -1, null, null, null, null, 1, null, 2]
 * <p>
 * 解释：
 * NumberContainers nc = new NumberContainers();
 * nc.find(10); // 没有数字 10 ，所以返回 -1 。
 * nc.change(2, 10); // 容器中下标为 2 处填入数字 10 。
 * nc.change(1, 10); // 容器中下标为 1 处填入数字 10 。
 * nc.change(3, 10); // 容器中下标为 3 处填入数字 10 。
 * nc.change(5, 10); // 容器中下标为 5 处填入数字 10 。
 * nc.find(10); // 数字 10 所在的下标为 1 ，2 ，3 和 5 。因为最小下标为 1 ，所以返回 1 。
 * nc.change(1, 20); // 容器中下标为 1 处填入数字 20 。注意，下标 1 处之前为 10 ，现在被替换为 20 。
 * nc.find(10); // 数字 10 所在下标为 2 ，3 和 5 。最小下标为 2 ，所以返回 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= index, number <= 109
 * 调用 change 和 find 的 总次数 不超过 105 次。
 */
public class Code19 {

    //节点
    private static class Node {

        //索引
        private int index;

        //数字
        private int number;

        //是否生效,默认有效
        private boolean effect = true;

        //初始化
        public Node(int index, int number) {
            this.index = index;
            this.number = number;
        }

        //比较
        public int compareTo(Node another) {
            //按照索引比较
            return this.index - another.index;
        }

    }

    //索引的节点优先队列map
    private Map<Integer, PriorityQueue<Node>> indexQueueMap = new HashMap<>();
    //每个索引的生效节点map
    private Map<Integer, Node> effectNodeMap = new HashMap<>();

    public Code19() {

    }

    public void change(int index, int number) {
        //如果不存在
        if (this.indexQueueMap.containsKey(number) == false) {
            //初始化优先队列
            this.indexQueueMap.put(number, new PriorityQueue<>(Node::compareTo));
        }
        //如果存在老节点
        if (this.effectNodeMap.containsKey(index)) {
            //设置为老节点不生效
            this.effectNodeMap.get(index).effect = false;
        }
        //初始化新节点
        Node node = new Node(index, number);
        //加入新节点
        this.indexQueueMap.get(number).add(node);
        this.effectNodeMap.put(index, node);
    }

    public int find(int number) {
        //如果不存在
        if (this.indexQueueMap.containsKey(number) == false) {
            //默认
            return -1;
        }
        //获取对应队列
        PriorityQueue<Node> queue = this.indexQueueMap.get(number);
        //循环
        while (queue.isEmpty() == false) {
            //如果是生效的
            if (queue.peek().effect == true) {
                //返回结果
                return queue.peek().index;
            }
            //丢弃不生效数据并继续
            queue.poll();
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {
        Code19 code19 = new Code19();
        System.out.println(code19.find(10));
        code19.change(2, 10);
        code19.change(1, 10);
        code19.change(3, 10);
        code19.change(5, 10);
        System.out.println(code19.find(10));
        code19.change(1, 20);
        System.out.println(code19.find(10));
    }

}
