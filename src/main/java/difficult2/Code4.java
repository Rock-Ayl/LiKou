package difficult2;

import java.util.*;

/**
 * @Author ayl
 * @Date 2023-09-14
 * 472. 连接词
 * 困难
 * 300
 * 相关企业
 * 给你一个 不含重复 单词的字符串数组 words ，请你找出并返回 words 中的所有 连接词 。
 * <p>
 * 连接词 定义为：一个完全由给定数组中的至少两个较短单词（不一定是不同的两个单词）组成的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat"]
 * 输出：["catsdogcats","dogcatsdog","ratcatdogcat"]
 * 解释："catsdogcats" 由 "cats", "dog" 和 "cats" 组成;
 * "dogcatsdog" 由 "dog", "cats" 和 "dog" 组成;
 * "ratcatdogcat" 由 "rat", "cat", "dog" 和 "cat" 组成。
 * 示例 2：
 * <p>
 * 输入：words = ["cat","dog","catdog"]
 * 输出：["catdog"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 30
 * words[i] 仅由小写英文字母组成。
 * words 中的所有字符串都是 唯一 的。
 * 1 <= sum(words[i].length) <= 105
 */
public class Code4 {

    //节点
    private static class Node {

        //子节点map
        private Map<Character, Node> children = new HashMap<>();

        //是否存在单词
        private boolean hadWord = false;

    }

    //主节点
    private Node rootNode;

    //插入单词
    private void insert(String word) {
        //当前节点
        Node node = rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //默认
                node.children.put(c, new Node());
            }
            //下一个
            node = node.children.get(c);
        }
        //该节点存在真单词
        node.hadWord = true;
    }

    //递归检测该单词是否为目标结果
    private boolean next(String word, Node node, int p, int count) {
        //如果到头了
        if (word.length() == p) {
            //如果当前是 and 由多个组成
            if (node.hadWord == true && count > 0) {
                //是
                return true;
            }
            //不是
            return false;
        }
        //如果当前节点存在单词
        if (node.hadWord == true) {
            //递归
            boolean success = next(word, this.rootNode, p, count + 1);
            //如果是
            if (success) {
                //是
                return true;
            }
        }
        //当前
        char letter = word.charAt(p);
        //如果存在
        if (node.children.containsKey(letter)) {
            //递归
            boolean success = next(word, node.children.get(letter), p + 1, count);
            //如果是
            if (success) {
                //是
                return true;
            }
        }
        //默认不是
        return false;
    }

    //实现
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        //初始化主节点
        this.rootNode = new Node();
        //排序
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照长度排序
                return o1.length() - o2.length();
            }
        });
        //初始化结果
        List<String> result = new ArrayList<>();
        //循环
        for (String word : words) {
            //如果是
            if (next(word, this.rootNode, 0, 0)) {
                //记录结果,不必插入,因为前面已经有了
                result.add(word);
            } else {
                //插入
                insert(word);
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        List<String> list = new Code4().findAllConcatenatedWordsInADict(new String[]{
                "a", "aa", "b", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa", "aaaaaaaaaaa", "aaaaaaaaaaaa", "aaaaaaaaaaaaa", "aaaaaaaaaaaaaa", "aaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaz"
        });
        System.out.println();
    }

}
