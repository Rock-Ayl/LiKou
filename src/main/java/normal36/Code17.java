package normal36;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2024-10-29
 * 1405. 最长快乐字符串
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 如果字符串中不含有任何 'aaa'，'bbb' 或 'ccc' 这样的字符串作为子串，那么该字符串就是一个「快乐字符串」。
 * <p>
 * 给你三个整数 a，b ，c，请你返回 任意一个 满足下列全部条件的字符串 s：
 * <p>
 * s 是一个尽可能长的快乐字符串。
 * s 中 最多 有a 个字母 'a'、b 个字母 'b'、c 个字母 'c' 。
 * s 中只含有 'a'、'b' 、'c' 三种字母。
 * 如果不存在这样的字符串 s ，请返回一个空字符串 ""。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：a = 1, b = 1, c = 7
 * 输出："ccaccbcc"
 * 解释："ccbccacc" 也是一种正确答案。
 * 示例 2：
 * <p>
 * 输入：a = 2, b = 2, c = 1
 * 输出："aabbc"
 * 示例 3：
 * <p>
 * 输入：a = 7, b = 1, c = 0
 * 输出："aabaa"
 * 解释：这是该测试用例的唯一正确答案。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= a, b, c <= 100
 * a + b + c > 0
 */
public class Code17 {

    //节点
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

        //调试
        @Override
        public String toString() {
            return letter + ",count=" + count;
        }

    }

    //组装方法
    private void set(StringBuilder str, Node node, boolean big) {
        //判断大小
        if (big && node.count > 1) {
            //-2
            node.count -= 2;
            //加入
            str.append(node.letter);
            str.append(node.letter);
        } else {
            //-1
            node.count--;
            //加入
            str.append(node.letter);
        }
    }

    public String longestDiverseString(int a, int b, int c) {
        //优先队列
        PriorityQueue<Node> queue = new PriorityQueue<>((x, y) -> y.count - x.count);
        //初始化
        if (a > 0) {
            queue.add(new Node('a', a));
        }
        if (b > 0) {
            queue.add(new Node('b', b));
        }
        if (c > 0) {
            queue.add(new Node('c', c));
        }
        //初始化结果
        StringBuilder str = new StringBuilder();
        //如果还存在
        while (queue.isEmpty() == false) {
            //获取最大的那个
            Node first = queue.poll();
            //如果没有 or 与前一个不同
            if (str.length() == 0 || str.charAt(str.length() - 1) != first.letter) {
                //直接组装
                set(str, first, true);
                //如果还有
                if (first.count > 0) {
                    //重新加入
                    queue.add(first);
                }
                //本轮过
                continue;
            }
            //获取第二的那个
            Node second = queue.poll();
            //如果没有
            if (second == null) {
                //跳出
                break;
            }
            //直接组装
            set(str, second, false);
            //如果还有
            if (second.count > 0) {
                //重新加入
                queue.add(second);
            }
            //重新加入
            queue.add(first);
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code17().longestDiverseString(1, 1, 6));
    }

}
