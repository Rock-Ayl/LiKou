package normal25;

/**
 * @Author ayl
 * @Date 2023-10-21
 * 622. 设计循环队列
 * 中等
 * 486
 * 相关企业
 * 设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
 * <p>
 * 循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。
 * <p>
 * 你的实现应该支持如下操作：
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满。
 * <p>
 * <p>
 * 示例：
 * <p>
 * MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3
 * circularQueue.enQueue(1);  // 返回 true
 * circularQueue.enQueue(2);  // 返回 true
 * circularQueue.enQueue(3);  // 返回 true
 * circularQueue.enQueue(4);  // 返回 false，队列已满
 * circularQueue.Rear();  // 返回 3
 * circularQueue.isFull();  // 返回 true
 * circularQueue.deQueue();  // 返回 true
 * circularQueue.enQueue(4);  // 返回 true
 * circularQueue.Rear();  // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 所有的值都在 0 至 1000 的范围内；
 * 操作数将在 1 至 1000 的范围内；
 * 请不要使用内置的队列库。
 */
public class Code10 {

    //最大数量
    private int maxSize;
    //当前数量
    private int size;

    //首节点
    private Node firstNode;
    //最后一个节点
    private Node lastNode;

    //节点
    public class Node {

        //当前节点值
        private int val;
        //下一个节点
        private Node next;
        //上一个节点
        private Node last;

        //初始化
        public Node(int val) {
            this.val = val;
        }

    }

    public Code10(int k) {
        //初始化数字
        this.size = 0;
        this.maxSize = k;
        //初始化首节点、尾节点
        firstNode = new Node(-1);
        lastNode = new Node(-1);
        //关联首、尾
        firstNode.next = lastNode;
        lastNode.last = firstNode;
    }

    public boolean enQueue(int value) {
        //如果满了
        if (isFull()) {
            //过
            return false;
        }
        //增加一个节点
        size++;
        //初始化新节点
        Node node = new Node(value);
        //插入到最后
        node.last = lastNode.last;
        node.next = lastNode;
        lastNode.last.next = node;
        lastNode.last = node;
        //结束
        return true;
    }

    public boolean deQueue() {
        //如果空了
        if (isEmpty()) {
            //过
            return false;
        }
        //删除一个节点
        size--;
        //删除第一个节点
        firstNode.next = firstNode.next.next;
        firstNode.next.last = firstNode;
        //结束
        return true;
    }

    public int Front() {
        //如果没有
        if (isEmpty()) {
            //过
            return -1;
        }
        //返回目标值
        return firstNode.next.val;
    }

    public int Rear() {
        //如果没有
        if (isEmpty()) {
            //过
            return -1;
        }
        //返回目标值
        return lastNode.last.val;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

    public static void main(String[] args) {
        //初始化
        Code10 code10 = new Code10(8);

        System.out.println(code10.enQueue(3));
        System.out.println(code10.enQueue(9));
        System.out.println(code10.enQueue(5));
        System.out.println(code10.enQueue(0));
        System.out.println(code10.deQueue());
        System.out.println(code10.deQueue());
        System.out.println(code10.isEmpty());
        System.out.println(code10.isEmpty());
        System.out.println(code10.Rear());
        System.out.println(code10.Rear());
        System.out.println(code10.deQueue());
    }

}
