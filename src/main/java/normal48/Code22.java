package normal48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-12-12
 * 809. 情感丰富的文字
 * 算术评级: 5
 * 第 78 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1605
 * 相关标签
 * premium lock icon
 * 相关企业
 * 有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。
 * <p>
 * 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。
 * <p>
 * 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词 "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = s。
 * <p>
 * 输入一组查询单词，输出其中可扩张的单词数量。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * s = "heeellooo"
 * words = ["hello", "hi", "helo"]
 * 输出：1
 * 解释：
 * 我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
 * 我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, words.length <= 100
 * 1 <= words[i].length <= 100
 * s 和所有在 words 中的单词都只由小写字母组成。
 */
public class Code22 {

    private static class Node {

        //字符
        private char letter;

        //数量
        private int count;

        //初始化
        public Node(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("letter=%s,count=%s", this.letter, this.count);
        }

    }

    public int expressiveWords(String s, String[] words) {
        //构建节点
        List<Node> targetList = buildNode(s);
        //结果
        int count = 0;
        //循环
        for (String word : words) {
            //构建节点
            List<Node> nodeList = buildNode(word);
            //对比
            count += same(targetList, nodeList);
        }
        //返回
        return count;
    }

    //对比
    private int same(List<Node> targetList, List<Node> nodeList) {
        //如果不同
        if (targetList.size() != nodeList.size()) {
            //不行
            return 0;
        }
        //循环
        for (int i = 0; i < targetList.size(); i++) {
            //如果不同
            if (same(targetList.get(i), nodeList.get(i)) == false) {
                //不行
                return 0;
            }
        }
        //默认可以
        return 1;
    }

    //对比
    private boolean same(Node target, Node node) {
        //字符不同
        if (target.letter != node.letter) {
            //不行
            return false;
        }
        //如果不够
        if (target.count < node.count) {
            //不行
            return false;
        }
        //如果大于
        if (target.count > 2) {
            //可以
            return true;
        }
        //如果相同
        if (target.count == node.count) {
            //可以
            return true;
        }
        //不行
        return false;
    }

    //构建节点
    private List<Node> buildNode(String word) {
        //初始化
        List<Node> nodeList = new ArrayList<>();
        //索引
        int index = 0;
        //循环
        while (index < word.length()) {
            //第一个字符
            char first = word.charAt(index);
            //连击
            int hit = 1;
            //如果还有
            while (index + 1 < word.length() && word.charAt(index + 1) == first) {
                //+1
                index++;
                hit++;
            }
            //记录本次
            nodeList.add(new Node(first, hit));
            //下一个
            index++;
        }
        //返回
        return nodeList;
    }

    public static void main(String[] args) {
        //System.out.println(new Code22().expressiveWords("zzzzzyyyyy", new String[]{"zzyy", "zy", "zyy"}));
        //System.out.println(new Code22().expressiveWords("heeellooo", new String[]{"hello", "hi", "helo"}));
        System.out.println(new Code22().expressiveWords("aaa", new String[]{"aaaa"}));
    }

}
