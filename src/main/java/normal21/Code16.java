package normal21;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-07-10
 * 剑指 Offer II 063. 替换单词
 * 在英语中，有一个叫做 词根(root) 的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，跟随着单词 other(其他)，可以形成新的单词 another(另一个)。
 * <p>
 * 现在，给定一个由许多词根组成的词典和一个句子，需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。
 * <p>
 * 需要输出替换之后的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：dictionary = ["cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 2：
 * <p>
 * 输入：dictionary = ["a","b","c"], sentence = "aadsfasf absbs bbab cadsfafs"
 * 输出："a a b c"
 * 示例 3：
 * <p>
 * 输入：dictionary = ["a", "aa", "aaa", "aaaa"], sentence = "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
 * 输出："a a a a a a a a bbb baba a"
 * 示例 4：
 * <p>
 * 输入：dictionary = ["catt","cat","bat","rat"], sentence = "the cattle was rattled by the battery"
 * 输出："the cat was rat by the bat"
 * 示例 5：
 * <p>
 * 输入：dictionary = ["ac","ab"], sentence = "it is abnormal that this solution is accepted"
 * 输出："it is ab that this solution is ac"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 100
 * dictionary[i] 仅由小写字母组成。
 * 1 <= sentence.length <= 10^6
 * sentence 仅由小写字母和空格组成。
 * sentence 中单词的总量在范围 [1, 1000] 内。
 * sentence 中每个单词的长度在范围 [1, 1000] 内。
 * sentence 中单词之间由一个空格隔开。
 * sentence 没有前导或尾随空格。
 * <p>
 * <p>
 * 注意：本题与主站 648 题相同： https://leetcode-cn.com/problems/replace-words/
 */
public class Code16 {

    /**
     * 前缀树节点实体
     */
    private static class Node {

        //当前字符
        private Character letter;

        //下一级
        private Map<Character, Node> children;

        //当前节点是否存在单词
        private Boolean hadWord;

        //初始化
        public Node(Character letter, Map<Character, Node> children, Boolean hadWord) {
            this.letter = letter;
            this.children = children;
            this.hadWord = hadWord;
        }

    }

    //首节点缓存
    private Node rootNode;

    //递归寻找
    private String findWord(String word) {
        //当前节点
        Node node = this.rootNode;
        //初始化结果
        StringBuilder newWordStr = new StringBuilder();
        //循环字符
        for (char letter : word.toCharArray()) {
            //如果不存在该节点
            if (node.children.containsKey(letter) == false) {
                //返回本身
                return word;
            }
            //获取下一个节点
            Node nextNode = node.children.get(letter);
            //组装当前单词
            newWordStr.append(nextNode.letter);
            //如果是目标
            if (nextNode.hadWord) {
                //跳出返回
                break;
            }
            //下一个
            node = nextNode;
        }
        //返回结果
        return newWordStr.toString();
    }

    //将字典插入前缀树上
    private void insertNode(String dictionaryWord) {
        //当前节点
        Node node = this.rootNode;
        //循环字符
        for (char letter : dictionaryWord.toCharArray()) {
            //如果不存在该节点
            if (node.children.containsKey(letter) == false) {
                //初始化节点,并加入到子结构
                node.children.put(letter, new Node(letter, new HashMap<>(), false));
            }
            //下一个
            node = node.children.get(letter);
        }
        //最后,记录当前节点有这个单词
        node.hadWord = true;
    }

    //实现
    public String replaceWords(List<String> dictionary, String sentence) {
        //初始化默认节点
        this.rootNode = new Node(null, new HashMap<>(), false);
        //循环字典
        for (String dictionaryWord : dictionary) {
            //将字典记录到缓存中
            insertNode(dictionaryWord);
        }
        //拆分
        String[] wordArr = sentence.split(" ");
        //初始化øo
        StringBuilder str = new StringBuilder();
        //循环单词
        for (String word : wordArr) {
            //根据单词找到最简单词
            str.append(findWord(word));
            //空格
            str.append(" ");
        }
        //删除最后一个
        str.deleteCharAt(str.length() - 1);
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code16().replaceWords(Arrays.asList("bat"), "by"));
        ;
    }

}
