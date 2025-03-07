package normal23;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-08-11
 * LCR 064. 实现一个魔法字典
 * 中等
 * 52
 * 相关企业
 * 设计一个使用单词列表进行初始化的数据结构，单词列表中的单词 互不相同 。 如果给出一个单词，请判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于已构建的神奇字典中。
 * <p>
 * 实现 MagicDictionary 类：
 * <p>
 * MagicDictionary() 初始化对象
 * void buildDict(String[] dictionary) 使用字符串数组 dictionary 设定该数据结构，dictionary 中的字符串互不相同
 * bool search(String searchWord) 给定一个字符串 searchWord ，判定能否只将字符串中 一个 字母换成另一个字母，使得所形成的新字符串能够与字典中的任一字符串匹配。如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * inputs = ["MagicDictionary", "buildDict", "search", "search", "search", "search"]
 * inputs = [[], [["hello", "leetcode"]], ["hello"], ["hhllo"], ["hell"], ["leetcoded"]]
 * 输出
 * [null, null, false, true, false, false]
 * <p>
 * 解释
 * MagicDictionary magicDictionary = new MagicDictionary();
 * magicDictionary.buildDict(["hello", "leetcode"]);
 * magicDictionary.search("hello"); // 返回 False
 * magicDictionary.search("hhllo"); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
 * magicDictionary.search("hell"); // 返回 False
 * magicDictionary.search("leetcoded"); // 返回 False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 100
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写英文字母组成
 * dictionary 中的所有字符串 互不相同
 * 1 <= searchWord.length <= 100
 * searchWord 仅由小写英文字母组成
 * buildDict 仅在 search 之前调用一次
 * 最多调用 100 次 search
 * <p>
 * <p>
 * 注意：本题与主站 676 题相同： https://leetcode-cn.com/problems/implement-magic-dictionary/
 */
public class Code2 {

    //字典树节点实体
    private static class Node {

        //当前节点字符
        private Character space;

        //下一级节点map
        private Map<Character, Node> children;

        //是否存在单词
        private Boolean hadWord;

        //初始化
        public Node(Character space) {
            //默认没有单词
            this.hadWord = false;
            this.children = new HashMap<>();
            this.space = space;
        }

    }

    //主节点
    private Node ROOT_NODE;

    //本次结果字符目标偏差值,只有严格等于它才是目标结果
    private static final int DEVIATION_TARGET_NUM = 1;

    /**
     * Initialize your data structure here.
     */
    public Code2() {
        //初始化主节点
        this.ROOT_NODE = new Node(null);
    }

    //插入字典
    public void buildDict(String[] dictionary) {
        //循环
        for (String word : dictionary) {
            //插入单词
            insert(word);
        }
    }

    //插入新的单词
    private void insert(String word) {
        //当前节点
        Node node = this.ROOT_NODE;
        //循环
        for (int i = 0; i < word.length(); i++) {
            //当前字符
            Character space = word.charAt(i);
            //如果不存在
            if (node.children.containsKey(space) == false) {
                //初始化
                node.children.put(space, new Node(space));
            }
            //下一个
            node = node.children.get(space);
        }
        //记录这个节点存在真实单词
        node.hadWord = true;
    }

    //搜索单词
    public boolean search(String searchWord) {
        //实现
        return search(searchWord, ROOT_NODE, 0, 0);
    }

    /**
     * 搜索单词
     *
     * @param searchWord 目标单词
     * @param p          单词字符坐标
     * @param deviation  偏差值
     */
    private boolean search(String searchWord, Node node, int p, int deviation) {
        //判断 偏差值是否达到目标,如果不是,走全量,如果是,只同字符节点
        if (deviation < DEVIATION_TARGET_NUM) {
            //如果到头了,统计本次单词递归结果
            if (p == searchWord.length()) {
                //肯定不行,偏差值不同
                return false;
            }
            //获取当前字符
            Character space = searchWord.charAt(p);
            //循环所有节点
            for (Node childNode : node.children.values()) {
                //下一级的偏差值
                int nextDeviation = deviation;
                //如果偏差值不同
                if (childNode.space.equals(space) == false) {
                    //+1
                    nextDeviation++;
                }
                //继续走下去
                boolean success = search(searchWord, childNode, p + 1, nextDeviation);
                //如果有结果
                if (success) {
                    //返回结果
                    return true;
                }
            }
            //默认不可以
            return false;
        } else {
            //如果到头了,统计本次单词递归结果
            if (p == searchWord.length()) {
                //如果是目标偏差值 and 当前节点存在真实的单词
                return deviation == DEVIATION_TARGET_NUM && node.hadWord == true;
            }
            //获取当前字符
            Character space = searchWord.charAt(p);
            //如果不存在
            if (node.children.containsKey(space) == false) {
                //不可以
                return false;
            }
            //继续走下去
            return search(searchWord, node.children.get(space), p + 1, deviation);
        }
    }

    public static void main(String[] args) {

        Code2 magicDictionary = new Code2();
        magicDictionary.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(magicDictionary.search("hello")); // 返回 False
        System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        System.out.println(magicDictionary.search("hell")); // 返回 False
        System.out.println(magicDictionary.search("leetcoded")); // 返回 False
    }

}
