package difficult5;

/**
 * 3093. 最长公共后缀查询
 * 算术评级: 6
 * 第 390 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2118
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个字符串数组 wordsContainer 和 wordsQuery 。
 * <p>
 * 对于每个 wordsQuery[i] ，你需要从 wordsContainer 中找到一个与 wordsQuery[i] 有 最长公共后缀 的字符串。如果 wordsContainer 中有两个或者更多字符串有最长公共后缀，那么答案为长度 最短 的。如果有超过两个字符串有 相同 最短长度，那么答案为它们在 wordsContainer 中出现 更早 的一个。
 * <p>
 * 请你返回一个整数数组 ans ，其中 ans[i]是 wordsContainer中与 wordsQuery[i] 有 最长公共后缀 字符串的下标。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：wordsContainer = ["abcd","bcd","xbcd"], wordsQuery = ["cd","bcd","xyz"]
 * <p>
 * 输出：[1,1,1]
 * <p>
 * 解释：
 * <p>
 * 我们分别来看每一个 wordsQuery[i] ：
 * <p>
 * 对于 wordsQuery[0] = "cd" ，wordsContainer 中有最长公共后缀 "cd" 的字符串下标分别为 0 ，1 和 2 。这些字符串中，答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。
 * 对于 wordsQuery[1] = "bcd" ，wordsContainer 中有最长公共后缀 "bcd" 的字符串下标分别为 0 ，1 和 2 。这些字符串中，答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。
 * 对于 wordsQuery[2] = "xyz" ，wordsContainer 中没有字符串跟它有公共后缀，所以最长公共后缀为 "" ，下标为 0 ，1 和 2 的字符串都得到这一公共后缀。这些字符串中， 答案是下标为 1 的字符串，因为它的长度为 3 ，是最短的字符串。
 * 示例 2：
 * <p>
 * 输入：wordsContainer = ["abcdefgh","poiuygh","ghghgh"], wordsQuery = ["gh","acbfgh","acbfegh"]
 * <p>
 * 输出：[2,0,2]
 * <p>
 * 解释：
 * <p>
 * 我们分别来看每一个 wordsQuery[i] ：
 * <p>
 * 对于 wordsQuery[0] = "gh" ，wordsContainer 中有最长公共后缀 "gh" 的字符串下标分别为 0 ，1 和 2 。这些字符串中，答案是下标为 2 的字符串，因为它的长度为 6 ，是最短的字符串。
 * 对于 wordsQuery[1] = "acbfgh" ，只有下标为 0 的字符串有最长公共后缀 "fgh" 。所以尽管下标为 2 的字符串是最短的字符串，但答案是 0 。
 * 对于 wordsQuery[2] = "acbfegh" ，wordsContainer 中有最长公共后缀 "gh" 的字符串下标分别为 0 ，1 和 2 。这些字符串中，答案是下标为 2 的字符串，因为它的长度为 6 ，是最短的字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= wordsContainer.length, wordsQuery.length <= 104
 * 1 <= wordsContainer[i].length <= 5 * 103
 * 1 <= wordsQuery[i].length <= 5 * 103
 * wordsContainer[i] 只包含小写英文字母。
 * wordsQuery[i] 只包含小写英文字母。
 * wordsContainer[i].length 的和至多为 5 * 105 。
 * wordsQuery[i].length 的和至多为 5 * 105 。
 */
public class Code2 {

    private static class Word {

        //单词
        private String word;

        //索引
        private Integer index;

        //初始化
        public Word(String word, int index) {
            this.word = word;
            this.index = index;
        }

        //输出
        @Override
        public String toString() {
            return String.format("word=%s,index=%d", word, index);
        }

    }

    private static class Node {

        //当前字符
        public Character letter;

        //下一级节点
        private Node[] children = new Node[26];

        //目标单词节点
        private Word word = null;

        //初始化节点
        public Node(Character letter) {
            this.letter = letter;
        }

        //加入单词
        public void addWord(Word word) {
            //如果为空 or 新单词长度更小
            if (this.word == null || this.word.word.length() > word.word.length()) {
                //覆盖
                this.word = word;
            }
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("letter=%s,word=%s", letter, word);
        }

    }

    //初始化主节点
    private Node root = new Node(null);

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        //循环
        for (int i = 0; i < wordsContainer.length; i++) {
            //构建单词
            build(wordsContainer[i], i);
        }
        //结果
        int[] result = new int[wordsQuery.length];
        //循环
        for (int i = 0; i < result.length; i++) {
            //寻找单词
            result[i] = find(wordsQuery[i]);
        }
        //返回
        return result;
    }

    //构建节点
    private void build(String word, int index) {
        //从主节点开始
        Node current = this.root;
        //记录单词
        current.addWord(new Word(word, index));
        //循环
        for (int i = word.length() - 1; i >= 0; i--) {
            //计算字符在数组中的索引
            int key = word.charAt(i) - 'a';
            //如果下一级节点为空
            if (current.children[key] == null) {
                //初始化下一级节点
                current.children[key] = new Node(word.charAt(i));
            }
            //下一级
            current = current.children[key];
            //记录单词
            current.addWord(new Word(word, index));
        }
    }

    //寻找目标单词
    private int find(String targetWord) {
        //从主节点开始
        Node current = this.root;
        //索引
        int index = targetWord.length();
        //如果前面还存在
        while (index - 1 >= 0 && current.children[targetWord.charAt(index - 1) - 'a'] != null) {
            //下一级
            current = current.children[targetWord.charAt(--index) - 'a'];
        }
        //返回
        return current.word == null ? -1 : current.word.index;
    }

    public static void main(String[] args) {
        int[] ints = new Code2().stringIndices(new String[]{"abcd", "bcd", "xbcd"}, new String[]{"cd", "bcd", "xyz"});
        System.out.println();
    }

}