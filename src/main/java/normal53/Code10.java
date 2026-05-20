package normal53;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 1156. 单字符重复子串的最大长度
 * 算术评级: 7
 * 第 149 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1787
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 如果字符串中的所有字符都相同，那么这个字符串是单字符重复的字符串。
 * <p>
 * 给你一个字符串 text，你只能交换其中两个字符一次或者什么都不做，然后得到一些单字符重复的子串。返回其中最长的子串的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "ababa"
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：text = "aaabaaa"
 * 输出：6
 * 示例 3：
 * <p>
 * 输入：text = "aaabbaaa"
 * 输出：4
 * 示例 4：
 * <p>
 * 输入：text = "aaaaa"
 * 输出：5
 * 示例 5：
 * <p>
 * 输入：text = "abcdef"
 * 输出：1
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 20000
 * text 仅由小写英文字母组成。
 */
public class Code10 {

    private static class Node {

        //当前字符
        private Character letter;
        //总数
        private Integer count;
        //开始
        private Integer start;
        //结束
        private Integer end;

        //初始化
        public Node(StringBuilder str, Integer end) {
            //使用最后一个字符
            this.letter = str.charAt(str.length() - 1);
            this.count = str.length();
            this.end = end;
            this.start = end - count + 1;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "letter=" + letter +
                    ", count=" + count +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }

    }

    //构建节点列表
    private List<Node> buildNode(String text) {
        //构建节点列表
        List<Node> nodeList = new ArrayList<>();
        //字符串
        StringBuilder str = new StringBuilder();
        //索引
        int index = 0;
        //循环
        while (index < text.length()) {
            //当前字符
            char letter = text.charAt(index);
            //如果是空
            if (str.length() == 0) {
                //直接写入
                str.append(letter);
                //+1
                index++;
                //本轮过
                continue;
            }
            //如果与最后一个不同
            if (letter != str.charAt(str.length() - 1)) {
                //初始化节点
                Node node = new Node(str, index - 1);
                //记录
                nodeList.add(node);
                //重新初始化
                str = new StringBuilder();
            } else {
                //直接写入
                str.append(letter);
                //+1
                index++;
            }
        }
        //如果最后有
        if (str.length() > 0) {
            //初始化节点
            Node node = new Node(str, index - 1);
            //记录
            nodeList.add(node);
        }
        //返回
        return nodeList;
    }

    public int maxRepOpt1(String text) {
        //构建节点列表,按照单词分组
        Map<Character, List<Node>> groupMap = buildNode(text)
                .stream()
                .collect(Collectors.groupingBy(p -> p.letter));
        //最大结果
        int max = 0;
        //循环
        for (List<Node> nodeList : groupMap.values()) {
            //计算本次最大值
            max = Math.max(max, count(nodeList));
        }
        //返回
        return max;
    }

    //计算当前分组
    private int count(List<Node> nodeList) {
        //如果只有1
        if (nodeList.size() == 1) {
            //直接返回
            return nodeList.get(0).count;
        }
        //最大长度
        int max = nodeList.get(0).count + 1;
        //是否有其他的拼接字符
        int hadOther = nodeList.size() > 2 ? 1 : 0;
        //循环
        for (int i = 1; i < nodeList.size(); i++) {
            //获取二者
            Node left = nodeList.get(i - 1);
            Node right = nodeList.get(i);
            //刷新单个最大(直接拿过来一个)
            max = Math.max(max, right.count + 1);
            //如果距离只有1
            if (right.start == left.end + 2) {
                //刷新最大值
                max = Math.max(max, left.count + right.count + hadOther);
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().maxRepOpt1("aaabbaaa"));
    }

}