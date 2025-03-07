package normal23;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2023-08-31
 * 面试题 17.15. 最长单词
 * 提示
 * 中等
 * 53
 * 相关企业
 * 给定一组单词words，编写一个程序，找出其中的最长单词，且该单词由这组单词中的其他单词组合而成。若有多个长度相同的结果，返回其中字典序最小的一项，若没有符合要求的单词则返回空字符串。
 * <p>
 * 示例：
 * <p>
 * 输入： ["cat","banana","dog","nana","walk","walker","dogwalker"]
 * 输出： "dogwalker"
 * 解释： "dogwalker"可由"dog"和"walker"组成。
 * 提示：
 * <p>
 * 0 <= len(words) <= 200
 * 1 <= len(words[i]) <= 100
 */
public class Code15 {

    //节点实体
    private static class Node {

        //子节点
        private Map<Character, Node> children;

        public Node() {
            this.children = new HashMap<>();
        }

    }

    //缓存中主节点
    private Node rootNode;

    //单词缓存
    private Set<String> wordSet;

    //最大单词
    private String maxWord = "";

    //插入单词
    private void insert(String word) {
        //记录
        this.wordSet.add(word);
        //当前节点
        Node node = this.rootNode;
        //循环
        for (char c : word.toCharArray()) {
            //如果不存在
            if (node.children.containsKey(c) == false) {
                //初始化
                node.children.put(c, new Node());
            }
            //下一个
            node = node.children.get(c);
        }
    }

    //寻找
    private void find(Node node, String word, int p, int count, StringBuilder str) {
        //如果找到最大值了
        if ("".equals(maxWord) == false) {
            //过
            return;
        }
        //如果到头了
        if (word.length() == p) {
            //如果最后一次还有内容 and 是字典单词
            if (str.length() > 0 && this.wordSet.contains(str.toString())) {
                //叠加结果
                count++;
            } else if (str.length() == 0) {
                //继续
            } else {
                //直接终止(无结果)
                return;
            }
            //如果是多个单词组合
            if (count > 1) {
                //刷新结果
                maxWord = word;
            }
            //结束
            return;
        }
        //获取
        Character space = word.charAt(p);
        //获取(肯定存在)
        Node nextNode = node.children.get(space);
        //叠加
        str.append(space);
        //如果当前是新单词,额外分叉
        if (this.wordSet.contains(str.toString())) {
            //递归新的
            find(nextNode, word, p + 1, count + 1, new StringBuilder());
        }
        //返回
        find(nextNode, word, p + 1, count, str);
    }

    public String longestWord(String[] words) {
        //初始化
        this.rootNode = new Node();
        this.wordSet = new HashSet<>();
        //循环
        for (String word : words) {
            //插入
            insert(word);
        }
        //给单词排个序,从最大的开始找
        List<String> wordSortList = Arrays
                //流
                .stream(words)
                //排序
                .sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        //如果长度不同
                        if (o1.length() != o2.length()) {
                            //用长度
                            return o2.length() - o1.length();
                        } else {
                            //按字典
                            return o1.compareTo(o2);
                        }
                    }
                })
                .collect(Collectors.toList());
        //循环
        for (String word : wordSortList) {
            //寻找
            find(this.rootNode, word, 0, 0, new StringBuilder());
            //如果找到最大值了
            if ("".equals(maxWord) == false) {
                //直接返回
                return maxWord;
            }
        }
        //返回最大结果
        return maxWord;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().longestWord(new String[]{"ccc", "c", "9999", "a"}));
    }

}
