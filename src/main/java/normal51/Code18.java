package normal51;

/**
 * 2707. 字符串中的额外字符
 * 尝试过
 * 算术评级: 5
 * 第 105 场双周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1736
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 s 和一个单词字典 dictionary 。你需要将 s 分割成若干个 互不重叠 的子字符串，每个子字符串都在 dictionary 中出现过。s 中可能会有一些 额外的字符 不在任何子字符串中。
 * <p>
 * 请你采取最优策略分割 s ，使剩下的字符 最少 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetscode", dictionary = ["leet","code","leetcode"]
 * 输出：1
 * 解释：将 s 分成两个子字符串：下标从 0 到 3 的 "leet" 和下标从 5 到 8 的 "code" 。只有 1 个字符没有使用（下标为 4），所以我们返回 1 。
 * 示例 2：
 * <p>
 * 输入：s = "sayhelloworld", dictionary = ["hello","world"]
 * 输出：3
 * 解释：将 s 分成两个子字符串：下标从 3 到 7 的 "hello" 和下标从 8 到 12 的 "world" 。下标为 0 ，1 和 2 的字符没有使用，所以我们返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= dictionary.length <= 50
 * 1 <= dictionary[i].length <= 50
 * dictionary[i] 和 s 只包含小写英文字母。
 * dictionary 中的单词互不相同。
 */
public class Code18 {

    private static class Node {

        //单词
        private Character letter;

        //下一级数组
        private Node[] children = new Node[26];

        //拥有的单词
        private String word;

        //初始化
        public Node(Character letter) {
            this.letter = letter;
        }

        //调试
        @Override
        public String toString() {
            return String.format("Node{letter=%s,word=%s}", letter, word);
        }

    }

    public int minExtraChar(String s, String[] dictionary) {

        /**
         * 构建字典树
         */

        //初始化
        Node root = new Node(null);
        //循环
        for (String word : dictionary) {
            //构建单词
            build(root, word, 0);
        }

        /**
         * 动态规划
         */

        //计数器
        int[] arr = new int[s.length() + 1];
        //默认
        arr[0] = 1;
        //循环
        for (int i = 1; i < arr.length; i++) {
            //如果没有
            if (arr[i] == 0) {
                //默认
                arr[i] = arr[i - 1] + 1;
            } else {
                //刷新最小值
                arr[i] = Math.min(arr[i], arr[i - 1] + 1);
            }
            //开始索引
            int index = i - 1;
            //走下去
            next(root, arr, s, index, arr[i - 1]);
        }
        //返回
        return arr[arr.length - 1] - 1;
    }

    //构建字典树
    private void build(Node node, String word, int index) {
        //获取key
        int key = word.charAt(index) - 'a';
        //如果没有
        if (node.children[key] == null) {
            //初始化
            node.children[key] = new Node(word.charAt(index));
        }
        //如果到头了
        if (index + 1 == word.length()) {
            //记录单词
            node.children[key].word = word;
            //过
            return;
        }
        //下一个
        build(node.children[key], word, index + 1);
    }

    //递归
    private void next(Node node, int[] arr, String s, int index, int sum) {
        //如果到头了
        if (index >= s.length()) {
            //过
            return;
        }
        //获取key
        int key = s.charAt(index) - 'a';
        //如果没有
        if (node.children[key] == null) {
            //过
            return;
        }
        //子级节点
        Node child = node.children[key];
        //如果包含单词
        if (child.word != null) {
            //如果没有
            if (arr[index + 1] == 0) {
                //初始化
                arr[index + 1] = sum;
            } else {
                //刷新最小值
                arr[index + 1] = Math.min(arr[index + 1], sum);
            }
        }
        //下一级
        next(child, arr, s, index + 1, sum);
    }

    public static void main(String[] args) {
        System.out.println(new Code18().minExtraChar("leetscode", new String[]{"leet", "code", "leetcode"}));
        ;

        System.out.println(new Code18().minExtraChar(
                "dwmodizxvvbosxxw",
                new String[]
                        {"ox", "lb", "diz", "gu", "v", "ksv", "o", "nuq", "r", "txhe", "e", "wmo", "cehy", "tskz", "ds", "kzbu"}
        ));
    }

}