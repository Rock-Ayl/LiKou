package normal21;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-06-26
 * 211. 添加与搜索单词 - 数据结构设计
 * 请你设计一个数据结构，支持 添加新单词 和 查找字符串是否与任何先前添加的字符串匹配 。
 * <p>
 * 实现词典类 WordDictionary ：
 * <p>
 * WordDictionary() 初始化词典对象
 * void addWord(word) 将 word 添加到数据结构中，之后可以对它进行匹配
 * bool search(word) 如果数据结构中存在字符串与 word 匹配，则返回 true ；否则，返回  false 。word 中可能包含一些 '.' ，每个 . 都可以表示任何一个字母。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * 输出：
 * [null,null,null,null,false,true,true,true]
 * <p>
 * 解释：
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // 返回 False
 * wordDictionary.search("bad"); // 返回 True
 * wordDictionary.search(".ad"); // 返回 True
 * wordDictionary.search("b.."); // 返回 True
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 25
 * addWord 中的 word 由小写英文字母组成
 * search 中的 word 由 '.' 或小写英文字母组成
 * 最多调用 104 次 addWord 和 search
 */
public class Code8 {

    public Code8() {
        //初始化默认节点
        this.rootNode = new Node(null);
    }

    //缓存
    private Node rootNode;

    //加入单词
    public void addWord(String word) {
        //首先用首节点
        Node node = this.rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //获取子节点map
            Map<Character, Node> children = node.children;
            //如果不存在
            if (children.containsKey(c) == false) {
                //初始化节点
                children.put(c, new Node(c));
            }
            //替换为下一个节点
            node = children.get(c);
        }
        //最后,记录该节点为最后一个节点,存在结果
        node.had = true;
    }

    //搜索单词
    public boolean search(String word) {
        //实现
        return search(word, 0, this.rootNode);
    }

    //搜索单词实现
    private boolean search(String word, int p, Node node) {
        //如果到头了
        if (p == word.length()) {
            //返回该节点是否为单词结尾
            return node.had;
        }
        //当前
        char space = word.charAt(p);
        //获取子节点map
        Map<Character, Node> children = node.children;
        //下一级位置
        int nextP = p + 1;
        //如果是特殊占位符
        if ('.' == space) {
            //循环所有
            for (Node childNode : children.values()) {
                //继续走
                boolean success = search(word, nextP, childNode);
                //如果成功一个
                if (success) {
                    //直接返回
                    return true;
                }
            }
            //默认失败
            return false;
        }
        //如果不存在
        if (children.containsKey(space) == false) {
            //默认失败
            return false;
        }
        //获取下一级节点继续走
        return search(word, nextP, children.get(space));
    }

    //节点列表
    private static class Node {

        //当前
        public Character space;

        //是否存在这个单词
        public boolean had;

        //子节点
        public Map<Character, Node> children;

        //初始化方法
        public Node(Character space) {
            //覆盖
            this.space = space;
            //默认不存在
            this.had = false;
            //初始化
            this.children = new HashMap<>();
        }

    }

    public static void main(String[] args) {

        Code8 code8 = new Code8();

        code8.addWord("at");
        code8.addWord("and");
        code8.addWord("an");
        code8.addWord("add");


        System.out.println(code8.search("at"));
        System.out.println(code8.search(".at"));

    }

}
