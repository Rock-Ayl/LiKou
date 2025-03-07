package normal35;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-10-02
 * 3170. 删除星号以后字典序最小的字符串
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个字符串 s 。它可能包含任意数量的 '*' 字符。你的任务是删除所有的 '*' 字符。
 * <p>
 * 当字符串还存在至少一个 '*' 字符时，你可以执行以下操作：
 * <p>
 * 删除最左边的 '*' 字符，同时删除该星号字符左边一个字典序 最小 的字符。如果有多个字典序最小的字符，你可以删除它们中的任意一个。
 * 请你返回删除所有 '*' 字符以后，剩余字符连接而成的
 * 字典序最小
 * 的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaba*"
 * <p>
 * 输出："aab"
 * <p>
 * 解释：
 * <p>
 * 删除 '*' 号和它左边的其中一个 'a' 字符。如果我们选择删除 s[3] ，s 字典序最小。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "abc"
 * <p>
 * 输出："abc"
 * <p>
 * 解释：
 * <p>
 * 字符串中没有 '*' 字符。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只含有小写英文字母和 '*' 字符。
 * 输入保证操作可以删除所有的 '*' 字符。
 */
public class Code19 {

    //字符节点
    private static class Node {

        //索引
        private int index;

        //字符
        private Character letter;

        //是否要删除,默认否
        private boolean willDelete = false;

        //初始化
        public Node(int index, Character letter) {
            this.index = index;
            this.letter = letter;
        }

        //排序
        public int compareTo(Node another) {
            //如果字符不同
            if (this.letter.equals(another.letter) == false) {
                //对比字符
                return this.letter.compareTo(another.letter);
            }
            //默认索引
            return another.index - this.index;
        }

        //方便调试
        @Override
        public String toString() {
            return this.letter + ",index=" + index + "," + willDelete;
        }

    }

    public String clearStars(String s) {
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>(Node::compareTo);
        //节点列表
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            Character letter = s.charAt(i);
            //判断是否为*
            if (letter.equals('*')) {
                //获取目前要被删除的节点
                Node poll = queue.poll();
                //该节点要被删除
                poll.willDelete = true;
            } else {
                //初始化节点
                Node node = new Node(i, letter);
                //加入队列
                queue.add(node);
                //加入节点列表
                nodeList.add(node);
            }
        }
        //返回
        return nodeList
                .stream()
                .filter(p -> p.willDelete == false)
                .map(p -> p.letter.toString())
                .reduce((a, b) -> a + b)
                .orElse("");
    }

    public static void main(String[] args) {
        System.out.println(new Code19().clearStars("aaba*"));
    }

    private void print(PriorityQueue<Node> queue) {
        while (queue.isEmpty() == false) {
            System.out.println(queue.poll().toString());
        }
    }

}
