package normal48;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2025-11-20
 * 3310. 移除可疑的方法
 * 算术评级: 5
 * 第 418 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1711
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 你正在维护一个项目，该项目有 n 个方法，编号从 0 到 n - 1。
 * <p>
 * 给你两个整数 n 和 k，以及一个二维整数数组 invocations，其中 invocations[i] = [ai, bi] 表示方法 ai 调用了方法 bi。
 * <p>
 * 已知如果方法 k 存在一个已知的 bug。那么方法 k 以及它直接或间接调用的任何方法都被视为 可疑方法 ，我们需要从项目中移除这些方法。
 * <p>
 * 只有当一组方法没有被这组之外的任何方法调用时，这组方法才能被移除。
 * <p>
 * 返回一个数组，包含移除所有 可疑方法 后剩下的所有方法。你可以以任意顺序返回答案。如果无法移除 所有 可疑方法，则 不 移除任何方法。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
 * <p>
 * 输出: [0,1,2,3]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 方法 2 和方法 1 是可疑方法，但它们分别直接被方法 3 和方法 0 调用。由于方法 3 和方法 0 不是可疑方法，我们无法移除任何方法，故返回所有方法。
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
 * <p>
 * 输出: [3,4]
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 方法 0、方法 1 和方法 2 是可疑方法，且没有被任何其他方法直接调用。我们可以移除它们。
 * <p>
 * 示例 3:
 * <p>
 * 输入: n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]
 * <p>
 * 输出: []
 * <p>
 * 解释:
 * <p>
 * <p>
 * <p>
 * 所有方法都是可疑方法。我们可以移除它们。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= n <= 105
 * 0 <= k <= n - 1
 * 0 <= invocations.length <= 2 * 105
 * invocations[i] == [ai, bi]
 * 0 <= ai, bi <= n - 1
 * ai != bi
 * invocations[i] != invocations[j]
 */
public class Code4 {

    private static class Node {

        //数字
        private int number;

        //是否走过检查bug,默认没检查过
        private boolean checkBug = false;

        //是否为bug,默认false
        private boolean bug = false;

        //分组
        private int group = -1;

        //父级列表
        private List<Node> fatherList = new ArrayList<>();

        //子级列表
        private List<Node> childList = new ArrayList<>();

        //初始化
        public Node(int number) {
            this.number = number;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("number=%s,bug=%s,group=%s,fatherSize=%s,childSize=%s", this.number, this.bug, this.group, this.fatherList.size(), this.childList.size());
        }

    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {

        /**
         * step 1 初始化节点
         */

        //初始化节点数组
        Node[] nodeArr = new Node[n];
        //循环
        for (int i = 0; i < nodeArr.length; i++) {
            //初始化节点
            nodeArr[i] = new Node(i);
        }

        /**
         * step 2 构建节点父子关系
         */

        //循环
        for (int[] invocation : invocations) {
            //获取节点
            Node father = nodeArr[invocation[0]];
            Node child = nodeArr[invocation[1]];
            //关联
            father.childList.add(child);
            child.fatherList.add(father);
        }

        /**
         * step 3 感染所有bug
         */

        //获取第一个感染的bug,递归感染
        nextBug(nodeArr[k]);

        /**
         * step 4 分组、并计算被删除的节点
         */

        //分组是否允许删除 0=不删除 1=删除
        int[] groupDeleteArr = new int[nodeArr.length];
        //递归记录结果的数组
        int[] countArr = new int[2];
        //循环所有节点
        for (Node node : nodeArr) {
            //如果有了分组
            if (node.group != -1) {
                //本轮过
                continue;
            }
            //分组名
            int group = node.number;
            //重置计数
            countArr[0] = 0;
            countArr[1] = 0;
            //递归分组,返回整个分组是否存在bug
            nextGroup(node, group, countArr);
            //如果分组有bug and 全部都有bug
            if (countArr[0] > 0 && countArr[0] == countArr[1]) {
                //记录该分组被删除
                groupDeleteArr[group] = 1;
            }
        }

        /**
         * step 5 构建结果并返回
         */

        //初始化结果
        List<Integer> result = new ArrayList<>();
        //循环
        for (Node node : nodeArr) {
            //如果不需要删除
            if (groupDeleteArr[node.group] == 0) {
                //记录结果
                result.add(node.number);
            }
        }
        //返回
        return result;
    }

    //递归分组,返回整个分组是否存在bug
    private void nextGroup(Node node, int group, int[] countArr) {
        //判空
        if (node == null) {
            //无
            return;
        }
        //如果有分组,说明走过了
        if (node.group != -1) {
            //无
            return;
        }
        //记录分组,视为走过了
        node.group = group;
        //如果有bug
        if (node.bug == true) {
            //bug +1
            countArr[0]++;
        }
        //节点 +1
        countArr[1]++;
        //循环孩子
        for (Node child : node.childList) {
            //递归
            nextGroup(child, group, countArr);
        }
        //循环父亲
        for (Node father : node.fatherList) {
            //递归
            nextGroup(father, group, countArr);
        }
    }

    //递归感染bug
    private void nextBug(Node node) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果检查过
        if (node.checkBug == true) {
            //过
            return;
        }
        //记录检查过
        node.checkBug = true;
        //感染
        node.bug = true;
        //循环子节点
        for (Node child : node.childList) {
            //递归
            nextBug(child);
        }
    }

    public static void main(String[] args) {
        List<Integer> list = new Code4().remainingMethods(4, 1, new int[][]{
                new int[]{1, 2},
                new int[]{0, 1},
                new int[]{3, 2}
        });
        List<Integer> list2 = new Code4().remainingMethods(5, 0, new int[][]{
                new int[]{1, 2},
                new int[]{0, 2},
                new int[]{0, 1},
                new int[]{3, 4}
        });

        System.out.println();
    }

}