package normal6;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-08-29
 * 146. LRU 缓存机制
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制 。
 * 实现 LRUCache 类：
 * <p>
 * LRUCache(int capacity) 以正整数作为容量 capacity 初始化 LRU 缓存
 * int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
 * void put(int key, int value) 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。
 * <p>
 * <p>
 * 进阶：你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
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
 */
public class Code16 {

    class LRUCache {

        //最多允许
        int capacity;
        //队列
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        //结果集
        Map<Integer, Integer> map = new HashMap<>();

        public LRUCache(int capacity) {
            //全局
            this.capacity = capacity;
        }

        public int get(int key) {
            //如果存在
            if (map.containsKey(key)) {
                //删除
                queue.remove(key);
                //放在队列最后
                queue.addLast(key);
                //返回
                return map.get(key);
            } else {
                //not found
                return -1;
            }
        }

        public void put(int key, int value) {
            //如果存在
            if (map.containsKey(key)) {
                //删除
                queue.remove(key);
            } else {
                //如果到头了
                if (queue.size() == capacity) {
                    //删除第一个队列及其map缓存
                    map.remove(queue.removeFirst());
                }
            }
            //放在队列最后
            queue.addLast(key);
            //记录值
            map.put(key, value);
        }

    }

}
