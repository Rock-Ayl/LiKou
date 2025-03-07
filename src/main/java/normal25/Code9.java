package normal25;

/**
 * @Author ayl
 * @Date 2023-10-20
 * 641. 设计循环双端队列
 * 中等
 * 223
 * 相关企业
 * 设计实现双端队列。
 * <p>
 * 实现 MyCircularDeque 类:
 * <p>
 * MyCircularDeque(int k) ：构造函数,双端队列最大为 k 。
 * boolean insertFront()：将一个元素添加到双端队列头部。 如果操作成功返回 true ，否则返回 false 。
 * boolean insertLast() ：将一个元素添加到双端队列尾部。如果操作成功返回 true ，否则返回 false 。
 * boolean deleteFront() ：从双端队列头部删除一个元素。 如果操作成功返回 true ，否则返回 false 。
 * boolean deleteLast() ：从双端队列尾部删除一个元素。如果操作成功返回 true ，否则返回 false 。
 * int getFront() )：从双端队列头部获得一个元素。如果双端队列为空，返回 -1 。
 * int getRear() ：获得双端队列的最后一个元素。 如果双端队列为空，返回 -1 。
 * boolean isEmpty() ：若双端队列为空，则返回 true ，否则返回 false  。
 * boolean isFull() ：若双端队列满了，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入
 * ["MyCircularDeque", "insertLast", "insertLast", "insertFront", "insertFront", "getRear", "isFull", "deleteLast", "insertFront", "getFront"]
 * [[3], [1], [2], [3], [4], [], [], [], [4], []]
 * 输出
 * [null, true, true, true, false, 2, true, true, true, 4]
 * <p>
 * 解释
 * MyCircularDeque circularDeque = new MycircularDeque(3); // 设置容量大小为3
 * circularDeque.insertLast(1);			        // 返回 true
 * circularDeque.insertLast(2);			        // 返回 true
 * circularDeque.insertFront(3);			        // 返回 true
 * circularDeque.insertFront(4);			        // 已经满了，返回 false
 * circularDeque.getRear();  				// 返回 2
 * circularDeque.isFull();				        // 返回 true
 * circularDeque.deleteLast();			        // 返回 true
 * circularDeque.insertFront(4);			        // 返回 true
 * circularDeque.getFront();				// 返回 4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 1000
 * 0 <= value <= 1000
 * insertFront, insertLast, deleteFront, deleteLast, getFront, getRear, isEmpty, isFull  调用次数不大于 2000 次
 */
public class Code9 {

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

    public Code9(int k) {
        this.size = 0;
        this.maxSize = k;
        this.firstNode = null;
        this.lastNode = null;
    }

    public boolean insertFront(int value) {
        //实现
        return insert(true, value);
    }

    public boolean insertLast(int value) {
        //实现
        return insert(false, value);
    }

    //插入实现
    private boolean insert(boolean first, int value) {
        //如果满了
        if (isFull()) {
            //过
            return false;
        }
        //初始化新节点
        Node newNode = new Node(value);
        //如果是第一个节点
        if (++size == 1) {
            //初始化
            this.firstNode = newNode;
            this.lastNode = newNode;
            //成功
            return true;
        }
        //判断插入首尾
        if (first) {
            //关联
            newNode.next = this.firstNode;
            this.firstNode.last = newNode;
            //更换首节点
            this.firstNode = newNode;
        } else {
            //关联
            this.lastNode.next = newNode;
            newNode.last = this.lastNode;
            //更换尾节点
            this.lastNode = newNode;
        }
        //成功
        return true;
    }

    public boolean deleteFront() {
        //实现
        return delete(true);
    }

    public boolean deleteLast() {
        //实现
        return delete(false);
    }

    //删除实现
    private boolean delete(boolean first) {
        //如果为空
        if (isEmpty()) {
            //过
            return false;
        }
        //如果删除后没有了
        if (--size == 0) {
            //置空
            this.firstNode = null;
            this.lastNode = null;
            //成功
            return true;
        }
        //判断删除收或尾
        if (first) {
            //删除首节点
            this.firstNode = this.firstNode.next;
        } else {
            //删除最后节点
            this.lastNode = this.lastNode.last;
        }
        //成功
        return true;
    }

    public int getFront() {
        //如果为空
        if (isEmpty()) {
            //默认
            return -1;
        } else {
            //返回首节点值
            return firstNode.val;
        }
    }

    public int getRear() {
        //如果为空
        if (isEmpty()) {
            //默认
            return -1;
        } else {
            //返回首节点值
            return lastNode.val;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == maxSize;
    }

}
