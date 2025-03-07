package easy38;

/**
 * @Author ayl
 * @Date 2024-08-31
 * 706. 设计哈希映射
 * 简单
 * 相关标签
 * 相关企业
 * 不使用任何内建的哈希表库设计一个哈希映射（HashMap）。
 * <p>
 * 实现 MyHashMap 类：
 * <p>
 * MyHashMap() 用空映射初始化对象
 * void put(int key, int value) 向 HashMap 插入一个键值对 (key, value) 。如果 key 已经存在于映射中，则更新其对应的值 value 。
 * int get(int key) 返回特定的 key 所映射的 value ；如果映射中不包含 key 的映射，返回 -1 。
 * void remove(key) 如果映射中存在 key 的映射，则移除 key 和它所对应的 value 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["MyHashMap", "put", "put", "get", "get", "put", "get", "remove", "get"]
 * [[], [1, 1], [2, 2], [1], [3], [2, 1], [2], [2], [2]]
 * 输出：
 * [null, null, null, 1, -1, null, 1, null, -1]
 * <p>
 * 解释：
 * MyHashMap myHashMap = new MyHashMap();
 * myHashMap.put(1, 1); // myHashMap 现在为 [[1,1]]
 * myHashMap.put(2, 2); // myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(1);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.get(3);    // 返回 -1（未找到），myHashMap 现在为 [[1,1], [2,2]]
 * myHashMap.put(2, 1); // myHashMap 现在为 [[1,1], [2,1]]（更新已有的值）
 * myHashMap.get(2);    // 返回 1 ，myHashMap 现在为 [[1,1], [2,1]]
 * myHashMap.remove(2); // 删除键为 2 的数据，myHashMap 现在为 [[1,1]]
 * myHashMap.get(2);    // 返回 -1（未找到），myHashMap 现在为 [[1,1]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= key, value <= 106
 * 最多调用 104 次 put、get 和 remove 方法
 */
public class Code6 {

    //树节点
    private static class TreeNode {

        //子节点数组,默认0-9
        private TreeNode[] children = new TreeNode[10];

        //当前值,不一定存在
        private Integer value = null;

    }

    //主节点
    private TreeNode root;

    public Code6() {
        //初始化
        this.root = new TreeNode();
    }

    public void put(int key, int value) {
        //实现
        put(this.root, key, value);
    }

    //存储实现
    private void put(TreeNode node, int key, Integer value) {
        //如果是个位数
        if (key < 10) {
            //如果不存在
            if (node.children[key] == null) {
                //初始化
                node.children[key] = new TreeNode();
            }
            //覆盖
            node.children[key].value = value;
            //过
            return;
        }
        //当前key
        int thisKey = key % 10;
        //如果不存在
        if (node.children[thisKey] == null) {
            //初始化
            node.children[thisKey] = new TreeNode();
        }
        //递归实现
        put(node.children[thisKey], key / 10, value);
    }

    public int get(int key) {
        //实现
        return get(this.root, key);
    }

    //获取实现
    private int get(TreeNode node, int key) {
        //如果是个位数
        if (key < 10) {
            //如果存在
            if (node.children[key] != null && node.children[key].value != null) {
                //返回
                return node.children[key].value;
            }
            //默认
            return -1;
        }
        //当前key
        int thisKey = key % 10;
        //如果不存在
        if (node.children[thisKey] == null) {
            //默认
            return -1;
        }
        //递归
        return get(node.children[thisKey], key / 10);
    }

    public void remove(int key) {
        //实现
        put(this.root, key, null);
    }

}
