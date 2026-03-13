package difficult5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 745. 前缀和后缀搜索
 * 尝试过
 * 算术评级: 6
 * 同步题目状态
 * <p>
 * 困难
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 设计一个包含一些单词的特殊词典，并能够通过前缀和后缀来检索单词。
 * <p>
 * 实现 WordFilter 类：
 * <p>
 * WordFilter(string[] words) 使用词典中的单词 words 初始化对象。
 * f(string pref, string suff) 返回词典中具有前缀 pref 和后缀 suff 的单词的下标。如果存在不止一个满足要求的下标，返回其中 最大的下标 。如果不存在这样的单词，返回 -1 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["WordFilter", "f"]
 * [[["apple"]], ["a", "e"]]
 * 输出
 * [null, 0]
 * 解释
 * WordFilter wordFilter = new WordFilter(["apple"]);
 * wordFilter.f("a", "e"); // 返回 0 ，因为下标为 0 的单词：前缀 prefix = "a" 且 后缀 suffix = "e" 。
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 104
 * 1 <= words[i].length <= 7
 * 1 <= pref.length, suff.length <= 7
 * words[i]、pref 和 suff 仅由小写英文字母组成
 * 最多对函数 f 执行 104 次调用
 */
public class Code1 {

    public Code1(String[] words) {
        //单词去重集合
        Set<String> set = new HashSet<>();
        //初始化缓存
        this.leftMap = new HashMap<>();
        this.rightMap = new HashMap<>();
        //循环
        for (int i = words.length - 1; i >= 0; i--) {
            //如果有更高优先级的
            if (set.contains(words[i])) {
                //本轮过
                continue;
            }
            //添加到集合
            set.add(words[i]);
            //初始化单词接待您
            WordNode wordNode = new WordNode(i, words[i]);
            //构建
            buildLeft(this.leftMap, wordNode, 0);
            buildRight(this.rightMap, wordNode, wordNode.word.length() - 1);
        }
    }

    //单词节点实体
    private static class WordNode {

        //索引
        private int index;

        //单词
        private String word;

        //初始化
        public WordNode(int index, String word) {
            this.index = index;
            this.word = word;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("index=[%d],word=[%s]", index, word);
        }

    }

    //字母节点实体
    private static class CharNode {

        //字母
        private Character letter;

        //当前前缀的集合
        private Set<WordNode> wordNodeSet;

        //下一级节点
        private Map<Character, CharNode> nextMap;

        //初始化
        public CharNode(Character letter) {
            this.letter = letter;
            this.wordNodeSet = new HashSet<>();
            this.nextMap = new HashMap<>();
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("letter=[%s]", letter);
        }

    }

    //前缀缓存
    private Map<Character, CharNode> leftMap;
    //后缀缓存
    private Map<Character, CharNode> rightMap;

    //构建前缀节点
    private void buildLeft(Map<Character, CharNode> map, WordNode wordNode, int index) {
        //如果越界
        if (index >= wordNode.word.length()) {
            //过
            return;
        }
        //当前节点
        Character letter = wordNode.word.charAt(index);
        //如果不存在
        if (map.containsKey(letter) == false) {
            //初始化
            map.put(letter, new CharNode(letter));
        }
        //获取
        CharNode charNode = map.get(letter);
        //记录
        charNode.wordNodeSet.add(wordNode);
        //下一个
        buildLeft(charNode.nextMap, wordNode, index + 1);
    }

    //构建后缀节点
    private void buildRight(Map<Character, CharNode> map, WordNode wordNode, int index) {
        //如果越界
        if (index < 0) {
            //过
            return;
        }
        //当前节点
        Character letter = wordNode.word.charAt(index);
        //如果不存在
        if (map.containsKey(letter) == false) {
            //初始化
            map.put(letter, new CharNode(letter));
        }
        //获取
        CharNode charNode = map.get(letter);
        //记录
        charNode.wordNodeSet.add(wordNode);
        //下一个
        buildRight(charNode.nextMap, wordNode, index - 1);
    }

    public int f(String pref, String suff) {
        //寻找前缀
        Set<WordNode> leftSet = findLeft(this.leftMap, pref, 0);
        //寻找后缀
        Set<WordNode> rightSet = findRight(this.rightMap, suff, suff.length() - 1);
        //交集
        WordNode result = null;
        //遍历
        for (WordNode wordNode : leftSet) {
            //如果后缀不包含
            if (rightSet.contains(wordNode) == false) {
                //本轮过
                continue;
            }
            //判空
            if (result == null) {
                //默认
                result = wordNode;
            } else {
                //如果当前索引更大
                if (wordNode.index > result.index) {
                    //记录
                    result = wordNode;
                }
            }
        }
        //返回最后一个
        return result == null ? -1 : result.index;
    }

    //寻找前缀
    private Set<WordNode> findLeft(Map<Character, CharNode> map, String pref, int index) {
        //当前字符
        Character letter = pref.charAt(index);
        //获取对应节点
        CharNode charNode = map.get(letter);
        //判空
        if (charNode == null) {
            //过
            return new HashSet<>();
        }
        //如果到头了
        if (index + 1 >= pref.length()) {
            //返回结果
            return charNode.wordNodeSet;
        }
        //递归
        return findLeft(charNode.nextMap, pref, index + 1);
    }

    //寻找前缀
    private Set<WordNode> findRight(Map<Character, CharNode> map, String pref, int index) {
        //当前字符
        Character letter = pref.charAt(index);
        //获取对应节点
        CharNode charNode = map.get(letter);
        //判空
        if (charNode == null) {
            //过
            return new HashSet<>();
        }
        //如果到头了
        if (index - 1 < 0) {
            //返回结果
            return charNode.wordNodeSet;
        }
        //递归
        return findRight(charNode.nextMap, pref, index - 1);
    }

    public static void main(String[] args) {
        Code1 code1 = new Code1(new String[]{"apple", "abe", "bpde"});
        System.out.println(code1.f("a", "e"));
    }

}
