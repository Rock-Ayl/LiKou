package normal49;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-12-23
 * 227. 基本计算器 II
 * 尝试过
 * 算术评级: 7
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 * <p>
 * 整数除法仅保留整数部分。
 * <p>
 * 你可以假设给定的表达式总是有效的。所有中间结果将在 [-231, 231 - 1] 的范围内。
 * <p>
 * 注意：不允许使用任何将字符串作为数学表达式计算的内置函数，比如 eval() 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3+2*2"
 * 输出：7
 * 示例 2：
 * <p>
 * 输入：s = " 3/2 "
 * 输出：1
 * 示例 3：
 * <p>
 * 输入：s = " 3+5 / 2 "
 * 输出：5
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3 * 105
 * s 由整数和算符 ('+', '-', '*', '/') 组成，中间由一些空格隔开
 * s 表示一个 有效表达式
 * 表达式中的所有整数都是非负整数，且在范围 [0, 231 - 1] 内
 * 题目数据保证答案是一个 32-bit 整数
 */
public class Code1 {

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

        @Override
        public String toString() {
            return String.format("symbol=%s,number=%s", this.symbol, this.number);
        }

    }

    //符号集合
    private static final Set<Character> SYMBOL_SET = new HashSet<>(Arrays.asList('+', '-', '*', '/'));

    public int calculate(String s) {
        //解析为节点列表
        List<Node> nodeList = parse(s);
        //先清算乘除法
        nodeList = count1(nodeList);
        //再清算加减
        return count2(nodeList);
    }

    //再清算加减
    private int count2(List<Node> nodeList) {
        //结果
        int result = 0;
        //循环
        for (Node node : nodeList) {
            //判断加减
            if (node.symbol == '+') {
                //计算
                result += node.number;
            } else {
                //计算
                result -= node.number;
            }
        }
        //返回
        return result;
    }

    //先清算乘除法
    private List<Node> count1(List<Node> nodeList) {
        //初始化新的结果
        List<Node> result = new ArrayList<>();
        //索引
        int index = 0;
        //循环
        while (index < nodeList.size()) {
            //获取第一个节点
            Node node = nodeList.get(index++);
            //循环
            while (index < nodeList.size() && (nodeList.get(index).symbol == '/' || nodeList.get(index).symbol == '*')) {
                //获取下一个节点
                Node nextNode = nodeList.get(index++);
                //判断乘除
                if (nextNode.symbol == '*') {
                    //计算
                    node.number = node.number * nextNode.number;
                } else {
                    //计算
                    node.number = node.number / nextNode.number;
                }
            }
            //组装到新的结果里面
            result.add(node);
        }
        //返回
        return result;
    }

    //解析为节点列表
    private List<Node> parse(String s) {
        //删除所有空格
        s = s.replaceAll(" ", "");
        //初始化第一个+号
        s = "+" + s;
        //初始化结果
        List<Node> nodeList = new ArrayList<>();
        //索引
        int index = 0;
        //循环
        while (index < s.length()) {
            //初始化节点(符号)
            Node node = new Node(s.charAt(index++));
            //组装到结果
            nodeList.add(node);
            //如果是数字
            while (index < s.length() && SYMBOL_SET.contains(s.charAt(index)) == false) {
                //叠加
                node.number = node.number * 10 + (s.charAt(index++) - '0');
            }
        }
        //返回
        return nodeList;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().calculate("3+1*5*3*7/2"));
    }

}