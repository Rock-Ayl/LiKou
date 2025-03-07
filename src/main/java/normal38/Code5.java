package normal38;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @Author ayl
 * @Date 2024-12-01
 * 面试题 16.25. LRU 缓存
 * <p>
 * 设计和构建一个“最近最少使用”缓存，该缓存会删除最近最少使用的项目。缓存应该从键映射到值(允许你插入和检索特定键对应的值)，并在初始化时指定最大容量。当缓存被填满时，它应该删除最近最少使用的项目。
 * 它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * 示例:
 * LRUCache cache = new LRUCache( 2);
 * cache.put(1, 1);
 * cache.put(2, 2);
 * cache.get(1);       // 返回  1
 * cache.put(3, 3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4, 4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 */
public class Code5 {

    //节点
    private static class Node {

        //键
        private int key;

        //值
        private int value;

        //排序分
        private int rank;

        //初始化
        public Node(int key, int value, int rank) {
            this.key = key;
            this.value = value;
            this.rank = rank;
        }

    }

    //现存节点集合
    private Map<Integer, Node> nodeMap = new HashMap<>();
    //优先队列树
    private TreeSet<Node> treeSet = new TreeSet<>(Comparator.comparingInt(a -> a.rank));
    //最大允许键值数量
    private int capacity;
    //操作次数
    private int opCount = 1;

    public Code5(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        //如果不存在
        if (this.nodeMap.containsKey(key) == false) {
            //过
            return -1;
        }
        //获取对应节点
        Node node = this.nodeMap.get(key);
        //删除节点
        this.treeSet.remove(node);
        //更新分数
        node.rank = this.opCount++;
        //重新加入节点
        this.treeSet.add(node);
        //获取结果
        return node.value;
    }

    public void put(int key, int value) {
        //如果已有该节点
        if (this.nodeMap.containsKey(key)) {
            //获取对应节点
            Node node = this.nodeMap.get(key);
            //删除节点
            this.treeSet.remove(node);
            //更新分数
            node.rank = this.opCount++;
            //更新值
            node.value = value;
            //重新加入节点
            this.treeSet.add(node);
            //结束
            return;
        }
        //如果满了
        if (this.capacity == nodeMap.size()) {
            //拉取最低的节点
            Node node = treeSet.pollFirst();
            //删除
            this.nodeMap.remove(node.key);

        }
        //初始化新节点
        Node node = new Node(key, value, this.opCount++);
        //加入队列、缓存
        this.nodeMap.put(key, node);
        this.treeSet.add(node);
    }

    public static void main(String[] args) {
        Code5 code5 = new Code5(2);
        System.out.println(code5.get(2));
        code5.put(2, 6);
        System.out.println(code5.get(1));
        code5.put(1, 5);
        code5.put(1, 2);
        System.out.println(code5.get(1));
        System.out.println(code5.get(2));
    }

}