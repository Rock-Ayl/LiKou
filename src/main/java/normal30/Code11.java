package normal30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-04-03
 * LCR 031. LRU 缓存
 * 中等
 * 相关标签
 * 相关企业
 * 运用所掌握的数据结构，设计和实现一个  LRU (Least Recently Used，最近最少使用) 缓存机制 。
 * <p>
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
 * 输出
 * [null, null, null, 1, null, -1, null, -1, 3, 4]
 * <p>
 * 解释
 * LRUCache lRUCache = new LRUCache(2);
 * lRUCache.put(1, 1); // 缓存是 {1=1}
 * lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
 * lRUCache.get(1);    // 返回 1
 * lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
 * lRUCache.get(2);    // 返回 -1 (未找到)
 * lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
 * lRUCache.get(1);    // 返回 -1 (未找到)
 * lRUCache.get(3);    // 返回 3
 * lRUCache.get(4);    // 返回 4
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 * 最多调用 2 * 105 次 get 和 put
 * <p>
 * <p>
 * 进阶：是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 146 题相同：https://leetcode-cn.com/problems/lru-cache/
 */
public class Code11 {

    //节点
    private class Node {

        //节点key
        private Integer key;

        //节点值
        private Integer value;

        //上一个节点
        private Node father;

        //下一个节点
        private Node child;

        //初始化
        public Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }

    }

    //容量
    private int capacity;
    //缓存
    private Map<Integer, Node> map;
    //缓存主节点
    private Node root;
    //最后一个节点
    private Node lastNode;

    public Code11(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.root = new Node(null, null);
        this.lastNode = this.root;
    }

    public int get(int key) {
        //如果不存在
        if (this.map.containsKey(key) == false) {
            //默认
            return -1;
        }
        //获取目标节点
        Node node = this.map.get(key);
        //从链表删除该节点
        delete(node);
        //插入新节点
        put(node.key, node.value);
        //返回结果
        return node.value;
    }

    public void put(int key, int value) {
        //如果存在
        if (this.map.containsKey(key)) {
            //刷新key
            get(key);
            //覆盖值
            this.map.get(key).value = value;
            //过
            return;
        }
        //如果需要删除节点了
        if (this.map.size() == this.capacity && this.root.child != null) {
            //删除优先级最低的那个节点
            delete(this.root.child);
        }
        //初始化新节点
        Node newNode = new Node(key, value);
        //该节点加入链表
        this.lastNode.child = newNode;
        newNode.father = this.lastNode;
        //更新链表最后节点
        this.lastNode = newNode;
        //记录缓存
        this.map.put(key, newNode);
    }

    //删除一个节点
    private void delete(Node node) {
        //获取其父级、子级
        Node father = node.father;
        Node child = node.child;
        //删除该节点
        father.child = child;
        //判空
        if (child != null) {
            //删除该节点
            child.father = father;
        }
        //如果最后一个节点有变动
        if (this.lastNode == node) {
            //更新
            this.lastNode = father;
        }
        //删除缓存
        this.map.remove(node.key);
    }

    //输出 -1,4,5  预期结果 3,-1,5
    public static void main(String[] args) {
        Code11 code11 = new Code11(3);
        code11.put(1, 1);
        code11.put(2, 2);
        code11.put(3, 3);
        code11.put(4, 4);
        code11.get(4);
        code11.get(3);
        code11.get(2);
        code11.get(1);
        code11.put(5, 5);
        code11.get(1);
        code11.get(2);
        System.out.println(code11.get(3));
        System.out.println(code11.get(4));
        System.out.println(code11.get(5));


    }

}
