package difficult3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-08-11
 * 2416. 字符串的前缀分数和
 * 算术评级: 5
 * 第 311 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 1725
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的数组 words ，该数组由 非空 字符串组成。
 * <p>
 * 定义字符串 term 的 分数 等于以 term 作为 前缀 的 words[i] 的数目。
 * <p>
 * 例如，如果 words = ["a", "ab", "abc", "cab"] ，那么 "ab" 的分数是 2 ，因为 "ab" 是 "ab" 和 "abc" 的一个前缀。
 * 返回一个长度为 n 的数组 answer ，其中 answer[i] 是 words[i] 的每个非空前缀的分数 总和 。
 * <p>
 * 注意：字符串视作它自身的一个前缀。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["abc","ab","bc","b"]
 * 输出：[5,4,3,2]
 * 解释：对应每个字符串的答案如下：
 * - "abc" 有 3 个前缀："a"、"ab" 和 "abc" 。
 * - 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" ，1 个字符串的前缀为 "abc" 。
 * 总计 answer[0] = 2 + 2 + 1 = 5 。
 * - "ab" 有 2 个前缀："a" 和 "ab" 。
 * - 2 个字符串的前缀为 "a" ，2 个字符串的前缀为 "ab" 。
 * 总计 answer[1] = 2 + 2 = 4 。
 * - "bc" 有 2 个前缀："b" 和 "bc" 。
 * - 2 个字符串的前缀为 "b" ，1 个字符串的前缀为 "bc" 。
 * 总计 answer[2] = 2 + 1 = 3 。
 * - "b" 有 1 个前缀："b"。
 * - 2 个字符串的前缀为 "b" 。
 * 总计 answer[3] = 2 。
 * 示例 2：
 * <p>
 * 输入：words = ["abcd"]
 * 输出：[4]
 * 解释：
 * "abcd" 有 4 个前缀 "a"、"ab"、"abc" 和 "abcd"。
 * 每个前缀的分数都是 1 ，总计 answer[0] = 1 + 1 + 1 + 1 = 4 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 1000
 * 1 <= words[i].length <= 1000
 * words[i] 由小写英文字母组成
 */
public class Code13 {

    private static class Node {

        //当前字符
        private Character letter;

        //到这里的单词书
        private int count = 0;

        //下一级节点
        private Map<Character, Node> children = new HashMap<>();

        //初始化
        public Node(Character letter) {
            this.letter = letter;
        }

        //调试
        @Override
        public String toString() {
            return String.format("letter=%s,count=%s,children=%s", this.letter, this.count, this.children.size());
        }

    }

    //主节点
    private Node root = new Node(null);

    public int[] sumPrefixScores(String[] words) {
        //循环
        for (String word : words) {
            //构建字典树
            build(this.root, word, 0);
        }
        //初始化结果
        int[] result = new int[words.length];
        //循环
        for (int i = 0; i < words.length; i++) {
            //计算结果并组装
            result[i] = count(this.root, words[i], 0);
        }
        //返回
        return result;
    }

    //构建字典树
    private void build(Node node, String word, int index) {
        //如果越界
        if (index >= word.length()) {
            //过
            return;
        }
        //当前字符
        Character letter = word.charAt(index);
        //如果不存在
        if (node.children.containsKey(letter) == false) {
            //初始化
            node.children.put(letter, new Node(letter));
        }
        //获取下一个节点
        Node nextNode = node.children.get(letter);
        //+1
        nextNode.count++;
        //下一个
        build(nextNode, word, index + 1);
    }

    //计算结果
    private int count(Node node, String word, int index) {
        //如果越界
        if (index >= word.length()) {
            //过
            return 0;
        }
        //当前字符
        Character letter = word.charAt(index);
        //获取节点
        Node nextNode = node.children.get(letter);
        //结果,默认未该节点
        int sum = nextNode.count;
        //递归
        sum += count(nextNode, word, index + 1);
        //返回
        return sum;
    }

    public static void main(String[] args) {
        int[] ints = new Code13().sumPrefixScores(new String[]{"abc", "ab", "bc", "b"});
        System.out.println();
    }

}
