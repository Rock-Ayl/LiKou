package normal51;

/**
 * 面试题 17.13. 恢复空格
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。
 * <p>
 * 注意：本题相对原题稍作改动，只需返回未识别的字符数
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * dictionary = ["looked","just","like","her","brother"]
 * sentence = "jesslookedjustliketimherbrother"
 * 输出： 7
 * 解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
 * 提示：
 * <p>
 * 0 <= len(sentence) <= 1000
 * dictionary中总字符数不超过 150000。
 * 你可以认为dictionary和sentence中只包含小写字母。
 */
public class Code11 {

    private static class Node {

        //字符串
        private Character letter;

        //单词
        private String word;

        //下一级节点
        private Node[] children = new Node[26];

        //初始化
        public Node(Character letter) {
            this.letter = letter;
        }

        @Override
        public String toString() {
            return String.format("letter=[%s]", letter);
        }

    }

    //主节点
    private Node root = new Node(null);

    public int respace(String[] dictionary, String sentence) {
        //如果不够
        if (sentence.length() < 1) {
            //过
            return 0;
        }
        //循环
        for (String word : dictionary) {
            //构建节点
            build(word);
        }
        //初始化动态规划-最大识别单词数
        int[] arr = new int[sentence.length()];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果有
            if (i > 0) {
                //刷新最大
                arr[i] = Math.max(arr[i], arr[i - 1]);
            }
            //从这里开始
            next(arr, this.root, sentence, i, i);
        }
        //返回
        return sentence.length() - arr[arr.length - 1];
    }

    //递归动态规划
    private void next(int[] arr, Node father, String sentence, int index, int startIndex) {
        //越界
        if (index >= sentence.length()) {
            //过
            return;
        }
        //计算key
        int key = sentence.charAt(index) - 'a';
        //判空
        if (father.children[key] == null) {
            //结束
            return;
        }
        //获取节点
        Node node = father.children[key];
        //如果这里有单词
        if (node.word != null) {
            //获取开始之前,最大的连击量
            int lastMax = startIndex > 0 ? arr[startIndex - 1] : 0;
            //刷新最大
            arr[index] = Math.max(arr[index], lastMax + node.word.length());
        }
        //递归下一个
        next(arr, node, sentence, index + 1, startIndex);
    }

    //构建节点
    private void build(String word) {
        //初始化节点
        Node node = this.root;
        //循环
        for (int i = 0; i < word.length(); i++) {
            //当前key
            int key = word.charAt(i) - 'a';
            //判断是否存在
            if (node.children[key] == null) {
                //初始化
                node.children[key] = new Node(word.charAt(i));
            }
            //下一级节点
            node = node.children[key];
        }
        //记录单词
        node.word = word;
    }

    public static void main(String[] args) {
        System.out.println(new Code11().respace(
                new String[]{"looked", "just", "like", "her", "brother"},
                "jesslookedjustliketimherbrother"
        ));
    }

}
