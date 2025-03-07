package normal22;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-07-25
 * 208. 实现 Trie (前缀树)
 * Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * <p>
 * 请你实现 Trie 类：
 * <p>
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length, prefix.length <= 2000
 * word 和 prefix 仅由小写英文字母组成
 * insert、search 和 startsWith 调用次数 总计 不超过 3 * 104 次
 */
public class Code10 {

    //前缀树节点
    private static class Node {

        //该节点是否存在单词
        private Boolean had;

        //下一级节点
        private Map<Character, Node> children;

        //初始化
        public Node() {
            //默认
            this.children = new HashMap<>();
            this.had = false;
        }

    }

    //缓存主节点
    private Node rootNode;

    public Code10() {
        this.rootNode = new Node();
    }

    public void insert(String word) {
        //初始化节点
        Node node = this.rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //初始化
                node.children.put(c, new Node());
            }
            //下一级
            node = node.children.get(c);
        }
        //该节点存在单词
        node.had = true;
    }

    public boolean search(String word) {
        //初始化节点
        Node node = this.rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //过
                return false;
            }
            //下一级
            node = node.children.get(c);
        }
        //返回是否存在
        return node.had;
    }

    public boolean startsWith(String prefix) {
        //初始化节点
        Node node = this.rootNode;
        //循环
        for (char c : prefix.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //过
                return false;
            }
            //下一级
            node = node.children.get(c);
        }
        //有节点就存在
        return true;
    }

}
