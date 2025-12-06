package normal48;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-12-06
 * 767. 重构字符串
 * 尝试过
 * 算术评级: 7
 * 第 68 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1681
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个字符串 s ，检查是否能重新排布其中的字母，使得两相邻的字符不同。
 * <p>
 * 返回 s 的任意可能的重新排列。若不可行，返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "aab"
 * 输出: "aba"
 * 示例 2:
 * <p>
 * 输入: s = "aaab"
 * 输出: ""
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写字母
 */
public class Code17 {

    private static class Node {

        //字符
        private char letter;

        //数字
        private int count;

        //初始化
        public Node(char letter, int count) {
            this.letter = letter;
            this.count = count;
        }

        @Override
        public String toString() {
            return String.format("letter=%s,count=%s", this.letter, this.count);
        }

    }

    public String reorganizeString(String s) {
        //优先队列
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>((a, b) -> b.count - a.count);
        //缓存
        Node[] nodeArr = new Node[123];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char letter = s.charAt(i);
            //判空
            if (nodeArr[letter] == null) {
                //初始化
                Node node = new Node(letter, 0);
                //记录
                nodeArr[letter] = node;
            }
            //+1
            nodeArr[letter].count++;
        }
        //循环
        for (Node node : nodeArr) {
            //判空
            if (node == null) {
                //本轮过
                continue;
            }
            //记录结果
            priorityQueue.add(node);
        }
        //字符串
        StringBuilder str = new StringBuilder();
        //如果还有
        while (priorityQueue.isEmpty() == false) {
            //拉取
            Node first = priorityQueue.poll();
            //如果不同
            if (str.length() == 0 || first.letter != str.charAt(str.length() - 1)) {
                //使用
                str.append(first.letter);
                //-1
                if (--first.count > 0) {
                    //记录
                    priorityQueue.add(first);
                }
            } else {
                //如果没有了
                if (priorityQueue.isEmpty()) {
                    //不行
                    return "";
                }
                //拉取
                Node second = priorityQueue.poll();
                //使用
                str.append(second.letter);
                //-1
                if (--second.count > 0) {
                    //记录
                    priorityQueue.add(second);
                }
                //记录
                priorityQueue.add(first);
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code17().reorganizeString("aaab"));
    }

}
