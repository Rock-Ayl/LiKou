package normal22;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-07-20
 * 剑指 Offer II 066. 单词之和
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * <p>
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * inputs = ["MapSum", "insert", "sum", "insert", "sum"]
 * inputs = [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * <p>
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 * <p>
 * <p>
 * 注意：本题与主站 677 题相同： https://leetcode-cn.com/problems/map-sum-pairs/
 */
public class Code7 {

    private static class Node {

        //当前节点和
        private int sum;

        //子结构
        private Map<Character, Node> children;

        public Node() {
            //初始化
            this.sum = 0;
            this.children = new HashMap<>();
        }

    }

    //主节点
    private Node rootNode;

    //已走过的缓存
    private Map<String, Integer> hadMap;

    /**
     * Initialize your data structure here.
     */
    public Code7() {
        //初始化
        this.rootNode = new Node();
        this.hadMap = new HashMap<>();
    }

    public void insert(String key, int val) {
        //如果走过了
        if (hadMap.containsKey(key)) {
            //先获取旧值
            int oldVal = hadMap.get(key);
            //如果新旧相同
            if (oldVal == val) {
                //过
                return;
            }
            //再记录新值
            hadMap.put(key, val);
            //新值计算差,走一遍差
            val = val - oldVal;
        } else {
            //直接记录已走的新单词
            hadMap.put(key, val);
        }
        //默认节点
        Node node = this.rootNode;
        //循环
        for (char c : key.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //初始化
                node.children.put(c, new Node());
            }
            //获取
            Node nextNode = node.children.get(c);
            //叠加和(差)
            nextNode.sum += val;
            //下一个
            node = nextNode;
        }
    }

    public int sum(String prefix) {
        //默认节点
        Node node = this.rootNode;
        //循环
        for (char c : prefix.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //初始化
                node.children.put(c, new Node());
            }
            //获取
            Node nextNode = node.children.get(c);
            //下一个
            node = nextNode;
        }
        //返回结果
        return node.sum;
    }

    public static void main(String[] args) {
        Code7 code7 = new Code7();

        code7.insert("apple", 3);
        System.out.println(code7.sum("ap"));
        code7.insert("app", 2);
        code7.insert("apple", 2);
        System.out.println(code7.sum("ap"));

    }

}
