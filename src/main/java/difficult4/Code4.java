package difficult4;

/**
 * @Author ayl
 * @Date 2025-08-26
 * 1032. 字符流
 * 算术评级: 7
 * 第 133 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1970
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 * <p>
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到 "axyz" 的后缀 "xyz" 与 words 中的字符串 "xyz" 匹配。
 * <p>
 * 按下述要求实现 StreamChecker 类：
 * <p>
 * StreamChecker(String[] words) ：构造函数，用字符串数组 words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 * <p>
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] 由小写英文字母组成
 * letter 是一个小写英文字母
 * 最多调用查询 4 * 104 次
 */
public class Code4 {

    public Code4(String[] words) {
        //主节点
        this.root = new Node();
        //字符流缓存
        this.str = new StringBuilder();
        //循环
        for (String word : words) {
            //构建字典树
            buildTree(word, word.length() - 1, this.root);
        }
    }

    //节点实体
    private static class Node {

        //该节点是否存在单词,默认不存在
        private boolean hadWord = false;

        //下一级节点
        private Node[] children;

    }

    //主节点
    private Node root;

    //字符串
    private StringBuilder str;

    //构建字典树
    private void buildTree(String word, int index, Node node) {
        //获取字符
        char letter = word.charAt(index);
        //计算出对应索引
        int letterIndex = letter - 'a';
        //如果没有初始化
        if (node.children == null) {
            //初始化
            node.children = new Node[26];
        }
        //下一个节点
        Node nextNode;
        //判断之前是否有该节点
        if (node.children[letterIndex] == null) {
            //初始化
            nextNode = new Node();
            //记录
            node.children[letterIndex] = nextNode;
        } else {
            //使用已有的
            nextNode = node.children[letterIndex];
        }
        //如果是最后一个字符
        if (index == 0) {
            //该节点拥有单词
            nextNode.hadWord = true;
        } else {
            //递归
            buildTree(word, index - 1, nextNode);
        }
    }

    //搜索
    public boolean query(char letter) {
        //增加字符
        this.str.append(letter);
        //搜索递归实现
        return search(this.root, this.str.length() - 1);
    }

    //搜索递归实现
    private boolean search(Node node, int index) {
        //如果越界
        if (index < 0) {
            //没有
            return false;
        }
        //如果没有下一级
        if (node.children == null) {
            //没有
            return false;
        }
        //获取字符
        char letter = this.str.charAt(index);
        //计算出对应索引
        int letterIndex = letter - 'a';
        //如果没有节点
        if (node.children[letterIndex] == null) {
            //没有
            return false;
        }
        //获取下一级节点
        Node nextNode = node.children[letterIndex];
        //如果匹配到单词
        if (nextNode.hadWord == true) {
            //有结果
            return true;
        }
        //递归
        return search(nextNode, index - 1);
    }

    public static void main(String[] args) {

        /*

        Code4 code4 = new Code4(new String[]{"cd", "f", "kl"});
        System.out.println(code4.query('a'));
        System.out.println(code4.query('b'));
        System.out.println(code4.query('c'));
        System.out.println(code4.query('d'));
        System.out.println(code4.query('e'));
        System.out.println(code4.query('f'));
        System.out.println(code4.query('g'));

        */

        Code4 code4 = new Code4(new String[]{"ab", "ba", "aaab", "abab", "baa"});
        System.out.println(code4.query('a'));
        System.out.println(code4.query('b'));


    }

}
