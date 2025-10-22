package normal47;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-10-22
 * 面试题 16.26. 计算器
 * 尝试过
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给定一个包含正整数、加(+)、减(-)、乘(*)、除(/)的算数表达式(括号除外)，计算其结果。
 * <p>
 * 表达式仅包含非负整数，+， - ，*，/ 四种运算符和空格  。 整数除法仅保留整数部分。
 * <p>
 * 示例 1：
 * <p>
 * 输入："3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：" 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：" 3+5 / 2 "
 * 输出：5
 * 说明：
 * <p>
 * 你可以假设所给定的表达式都是有效的。
 * 请不要使用内置的库函数 eval。
 */
public class Code8 {

    private static class Node {

        //符号
        private char symbol;

        //数字
        private int number;

        //初始化
        public Node(char symbol) {
            this.symbol = symbol;
            this.number = 0;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("symbol=%s,number=%s", this.symbol, this.number);
        }

    }

    public int calculate(String s) {

        //符号set
        Set<Character> symbolSet = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

        /**
         * 构建节点
         */

        //节点列表
        List<Node> nodeList = new ArrayList<>();
        //初始化第一个+号节点
        Node node = new Node('+');
        //加入列表
        nodeList.add(node);
        //循环
        for (int i = 0; i < s.length(); i++) {
            //字符
            char letter = s.charAt(i);
            //如果是空格
            if (letter == ' ') {
                //本轮过
                continue;
            }
            //如果是符号
            if (symbolSet.contains(letter) == true) {
                //初始化节点
                node = new Node(letter);
                //加入列表
                nodeList.add(node);
            } else {
                //叠加数字
                node.number = node.number * 10 + (letter - '0');
            }
        }

        /**
         * 优先计算乘除
         */

        //索引
        int index = 0;
        //重新从第一个索引开始
        node = nodeList.get(index++);
        //循环
        while (index < nodeList.size()) {
            //下一个节点
            Node nextNode = nodeList.get(index++);
            //如果是乘
            if (nextNode.symbol == '*') {
                //乘
                node.number = node.number * nextNode.number;
            }
            //如果是除
            else if (nextNode.symbol == '/') {
                //除
                node.number = node.number / nextNode.number;
            }
            //加减
            else {
                //换节点
                node = nextNode;
            }
        }

        /**
         * 再计算加减
         */

        //和
        int sum = 0;
        //循环
        for (Node sumNode : nodeList) {
            //如果是加
            if (sumNode.symbol == '+') {
                //叠加
                sum += sumNode.number;
            }
            //如果是减
            if (sumNode.symbol == '-') {
                //叠加
                sum -= sumNode.number;
            }
        }
        //返回
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().calculate("1*2-3/4+5*6-7*8+9/10"));
    }

}
