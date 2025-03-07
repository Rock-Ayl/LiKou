package easy33;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-10-04
 * 2452. 距离字典两次编辑以内的单词
 * 提示
 * 中等
 * 5
 * 相关企业
 * 给你两个字符串数组 queries 和 dictionary 。数组中所有单词都只包含小写英文字母，且长度都相同。
 * <p>
 * 一次 编辑 中，你可以从 queries 中选择一个单词，将任意一个字母修改成任何其他字母。从 queries 中找到所有满足以下条件的字符串：不超过 两次编辑内，字符串与 dictionary 中某个字符串相同。
 * <p>
 * 请你返回 queries 中的单词列表，这些单词距离 dictionary 中的单词 编辑次数 不超过 两次 。单词返回的顺序需要与 queries 中原本顺序相同。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["word","note","ants","wood"], dictionary = ["wood","joke","moat"]
 * 输出：["word","note","wood"]
 * 解释：
 * - 将 "word" 中的 'r' 换成 'o' ，得到 dictionary 中的单词 "wood" 。
 * - 将 "note" 中的 'n' 换成 'j' 且将 't' 换成 'k' ，得到 "joke" 。
 * - "ants" 需要超过 2 次编辑才能得到 dictionary 中的单词。
 * - "wood" 不需要修改（0 次编辑），就得到 dictionary 中相同的单词。
 * 所以我们返回 ["word","note","wood"] 。
 * 示例 2：
 * <p>
 * 输入：queries = ["yes"], dictionary = ["not"]
 * 输出：[]
 * 解释：
 * "yes" 需要超过 2 次编辑才能得到 "not" 。
 * 所以我们返回空数组。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length, dictionary.length <= 100
 * n == queries[i].length == dictionary[j].length
 * 1 <= n <= 100
 * 所有 queries[i] 和 dictionary[j] 都只包含小写英文字母。
 */
public class Code19 {

    //节点实体
    public static class Node {

        //子体map
        private Map<Character, Node> children = new HashMap<>();

        //当前层级是否有单词
        private boolean hadWord = false;

    }

    //主节点
    private Node rootNode;

    //插入
    private void insert(String word) {
        //当前节点
        Node node = this.rootNode;
        //循环
        for (char letter : word.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(letter) == false) {
                //初始化
                node.children.put(letter, new Node());
            }
            //下一个
            node = node.children.get(letter);
        }
        //记录当前层级存在单词
        node.hadWord = true;
    }

    //检查递归
    private boolean next(String word, int p, int errorCount, Node node) {
        //如果超了
        if (errorCount > 2) {
            //不是
            return false;
        }
        //如果越界
        if (word.length() == p) {
            //返回结果
            return node.hadWord;
        }
        //当前字符
        char space = word.charAt(p);
        //如果存在
        if (node.children.containsKey(space)) {
            //优先递归当前
            boolean success = next(word, p + 1, errorCount, node.children.get(space));
            //如果成功了
            if (success) {
                //是
                return true;
            }
        }
        //循环
        for (Node childrenNode : node.children.values()) {
            //递归
            boolean success = next(word, p + 1, errorCount + 1, childrenNode);
            //如果成功了
            if (success) {
                //是
                return true;
            }
        }
        //默认不是
        return false;
    }

    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        //初始化
        this.rootNode = new Node();
        //循环
        for (String word : dictionary) {
            //插入单词
            insert(word);
        }
        //初始化结果
        List<String> result = new ArrayList<>();
        //循环
        for (String word : queries) {
            //判断是否是
            if (next(word, 0, 0, this.rootNode)) {
                //插入
                result.add(word);
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new Code19().twoEditWords(new String[]{"iarapqqk"}, new String[]{"apahhijt", "larapqqk", "isukkcws", "siqqoacj", "nloynmpm"});
        for (String str : strings) {
            System.out.println(str);
        }
    }

}