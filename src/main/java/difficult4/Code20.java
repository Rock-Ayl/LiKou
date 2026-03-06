package difficult4;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 460. LFU 缓存
 * 尝试过
 * 算术评级: 9
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 * // cache=[3,4], cnt(4)=2, cnt(3)=3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 */
public class Code20 {

    public Code20(int capacity) {
        this.capacity = capacity;
    }

    private static class Node {

        //key
        private int key;

        //值
        private int value;

        //操作次数
        private int operCount;

        //上次使用时间
        private int lastOpTime;

        //是否在使用,默认是
        private boolean using;

        //初始化
        public Node(int key, int value, int operCount, int lastOpTime) {
            this.key = key;
            this.value = value;
            this.operCount = operCount;
            this.lastOpTime = lastOpTime;
            this.using = true;
        }

        //排序
        public int compareTo(Node o) {
            //先比较操作次数
            int compare = Integer.compare(this.operCount, o.operCount);
            //如果操作次数相同,比较时间
            return compare != 0 ? compare : Integer.compare(this.lastOpTime, o.lastOpTime);
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("key=%s,value=%s,operCount=%s,lastOpTime=%s,using=%s", this.key, this.value, this.operCount, this.lastOpTime, this.using);
        }

    }

    /**
     * - 移除规则：
     * - 先考虑 最不经常使用
     * - 再考虑 最久未使用
     * - 第一次 put = 1, get 或 put 操作，使用计数器的值将会递增
     */

    //优先队列
    private PriorityQueue<Node> queue = new PriorityQueue<>(Node::compareTo);
    //缓存
    private Map<Integer, Node> cacheMap = new HashMap<>();
    //长度
    private int capacity;
    //时间
    private int time = 1;

    //获取
    public int get(int key) {

        /**
         * 操作时间
         */

        //操作时间+1
        ++this.time;

        /**
         * 老节点
         */

        //获取节点
        Node node = this.cacheMap.get(key);
        //判空
        if (node == null) {
            //过
            return -1;
        }
        //老节点不再使用
        node.using = false;

        /**
         * 新节点
         */

        //克隆新的节点,+1
        Node newNode = new Node(node.key, node.value, node.operCount + 1, this.time);
        //写入新节点
        this.cacheMap.put(key, newNode);
        //加入队列
        this.queue.offer(newNode);
        //返回
        return newNode.value;
    }

    //存储
    public void put(int key, int value) {

        /**
         * 操作时间
         */

        //操作时间+1
        ++this.time;

        /**
         * 初始化新节点
         */

        //获取节点
        Node node = this.cacheMap.get(key);
        //新节点
        Node newNode;
        //判断存在
        if (node == null) {
            //初始化
            newNode = new Node(key, value, 1, this.time);
        } else {
            //克隆
            newNode = new Node(node.key, value, node.operCount + 1, this.time);
        }

        /**
         * 如果是相同的
         */

        //如果有老节点
        if (node != null) {
            //老节点不再使用
            node.using = false;
            //写入新节点
            this.cacheMap.put(key, newNode);
            //加入队列
            this.queue.offer(newNode);
            //结束
            return;
        }

        /**
         * 移除
         */

        //如果满了
        if (this.capacity == this.cacheMap.size()) {
            //如果没有在使用
            while (this.queue.peek().using == false) {
                //废弃
                this.queue.poll();
            }
            //拉取优先级最高的,删除之
            this.cacheMap.remove(this.queue.poll().key);
        }

        /**
         * 加入
         */

        //写入新节点
        this.cacheMap.put(key, newNode);
        //加入队列
        this.queue.offer(newNode);

    }

    public static void main(String[] args) {

        //["LFUCache","put","put","put","put","get"]
        //[[2],[3,1],[2,1],[2,2],[4,4],[2]]


        //初始化
        Code20 lfuCache = new Code20(2);
        //加入
        lfuCache.put(3, 1);
        lfuCache.put(2, 1);
        lfuCache.put(2, 2);
        lfuCache.put(4, 4);
        System.out.println(lfuCache.get(2));

    }

}
