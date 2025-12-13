package normal48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-12-13
 * 2337. 移动片段得到字符串
 * 尝试过
 * 算术评级: 5
 * 第 301 场周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1693
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你两个字符串 start 和 target ，长度均为 n 。每个字符串 仅 由字符 'L'、'R' 和 '_' 组成，其中：
 * <p>
 * 字符 'L' 和 'R' 表示片段，其中片段 'L' 只有在其左侧直接存在一个 空位 时才能向 左 移动，而片段 'R' 只有在其右侧直接存在一个 空位 时才能向 右 移动。
 * 字符 '_' 表示可以被 任意 'L' 或 'R' 片段占据的空位。
 * 如果在移动字符串 start 中的片段任意次之后可以得到字符串 target ，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：start = "_L__R__R_", target = "L______RR"
 * 输出：true
 * 解释：可以从字符串 start 获得 target ，需要进行下面的移动：
 * - 将第一个片段向左移动一步，字符串现在变为 "L___R__R_" 。
 * - 将最后一个片段向右移动一步，字符串现在变为 "L___R___R" 。
 * - 将第二个片段向右移动三步，字符串现在变为 "L______RR" 。
 * 可以从字符串 start 得到 target ，所以返回 true 。
 * 示例 2：
 * <p>
 * 输入：start = "R_L_", target = "__LR"
 * 输出：false
 * 解释：字符串 start 中的 'R' 片段可以向右移动一步得到 "_RL_" 。
 * 但是，在这一步之后，不存在可以移动的片段，所以无法从字符串 start 得到 target 。
 * 示例 3：
 * <p>
 * 输入：start = "_R", target = "R_"
 * 输出：false
 * 解释：字符串 start 中的片段只能向右移动，所以无法从字符串 start 得到 target 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == start.length == target.length
 * 1 <= n <= 105
 * start 和 target 由字符 'L'、'R' 和 '_' 组成
 */
public class Code23 {

    private static class Node {

        //字符
        private char letter;

        //索引
        private int index;

        //初始化
        public Node(char letter, int index) {
            this.letter = letter;
            this.index = index;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("letter=%s,index=%s", this.letter, this.index);
        }

    }

    public boolean canChange(String start, String target) {
        //分别构建节点
        List<Node> nodeList = buildNode(start);
        List<Node> targetNodeList = buildNode(target);
        //对比
        return eq(nodeList, targetNodeList);
    }

    //对比
    private boolean eq(List<Node> nodeList, List<Node> targetNodeList) {
        //如果数量不同
        if (nodeList.size() != targetNodeList.size()) {
            //不行
            return false;
        }
        //左边
        int leftIndex = 0;
        //循环
        while (leftIndex < nodeList.size()) {
            //获取节点
            Node node = nodeList.get(leftIndex);
            Node targetNode = targetNodeList.get(leftIndex);
            //如果字符不同
            if (node.letter != targetNode.letter) {
                //不行
                return false;
            }
            //如果位置相同
            if (node.index == targetNode.index) {
                //+1
                leftIndex++;
                //本轮过
                continue;
            }
            //如果是左字符
            if (node.letter == 'L') {
                //如果可以移动
                if (node.index > targetNode.index) {
                    //移动
                    node.index = targetNode.index;
                    //+1
                    leftIndex++;
                    //本轮过
                    continue;
                } else {
                    //不行
                    return false;
                }
            }
            //如果是右字符
            if (node.letter == 'R') {
                //如果可以移动
                if (node.index > targetNode.index) {
                    //不行
                    return false;
                } else {
                    //移动
                    node.index = targetNode.index;
                    //+1
                    leftIndex++;
                    //本轮过
                    continue;
                }
            }
        }
        //默认可以
        return true;
    }

    //构建节点
    private List<Node> buildNode(String word) {
        //初始化
        List<Node> nodeList = new ArrayList<>();
        //循环
        for (int i = 0; i < word.length(); i++) {
            //当前字符
            char letter = word.charAt(i);
            //如果是空格
            if (letter == '_') {
                //本轮过
                continue;
            }
            //初始化节点并组装
            nodeList.add(new Node(letter, i));
        }
        //返回
        return nodeList;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().canChange("_L__R__R_", "L______RR"));
        //System.out.println(new Code23().canChange("R___R__R_", "_R_____RR"));
    }

}
