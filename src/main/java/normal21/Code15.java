package normal21;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-07-07
 * 剑指 Offer II 062. 实现前缀树
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
 * inputs = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * inputs = [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
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
 * <p>
 * <p>
 * <p>
 * <p>
 * 注意：本题与主站 208 题相同：https://leetcode-cn.com/problems/implement-trie-prefix-tree/
 */
public class Code15 {

    //前缀树节点
    private static class Node {

        //当前节点
        public Character space;

        //子节点
        public Map<Character, Node> childrenMap;

        //当前层级是否包括
        public Boolean hadWord;

    }

    //主节点map
    private Node rootNode;

    /**
     * Initialize your data structure here.
     */
    public Code15() {
        //初始化
        this.rootNode = new Node();
        //初始化map
        this.rootNode.childrenMap = new HashMap<>();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        //初始化当前节点
        Node node = rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //如果不存在
            if (node.childrenMap.containsKey(c) == false) {
                //初始化
                Node nextNode = new Node();
                //当前
                nextNode.space = c;
                //子节点map初始化
                nextNode.childrenMap = new HashMap<>();
                //默认没有该节点
                nextNode.hadWord = false;
                //组装
                node.childrenMap.put(c, nextNode);
            }
            //下一个
            node = node.childrenMap.get(c);
        }
        //结束所有单词后,该节点存在单词
        node.hadWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        //初始化当前节点
        Node node = rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //如果不存在
            if (node.childrenMap.containsKey(c) == false) {
                //不是
                return false;
            }
            //下一个
            node = node.childrenMap.get(c);
        }
        //返回结果
        return node.hadWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        //初始化当前节点
        Node node = rootNode;
        //循环
        for (char c : prefix.toCharArray()) {
            //如果不存在
            if (node.childrenMap.containsKey(c) == false) {
                //不是
                return false;
            }
            //下一个
            node = node.childrenMap.get(c);
        }
        //默认是
        return true;
    }

}
