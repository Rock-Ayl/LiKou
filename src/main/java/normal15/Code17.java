package normal15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-08-08
 * 2096. 从二叉树一个节点到另一个节点每一步的方向
 * 给你一棵 二叉树 的根节点 root ，这棵二叉树总共有 n 个节点。每个节点的值为 1 到 n 中的一个整数，且互不相同。给你一个整数 startValue ，表示起点节点 s 的值，和另一个不同的整数 destValue ，表示终点节点 t 的值。
 * <p>
 * 请找到从节点 s 到节点 t 的 最短路径 ，并以字符串的形式返回每一步的方向。每一步用 大写 字母 'L' ，'R' 和 'U' 分别表示一种方向：
 * <p>
 * 'L' 表示从一个节点前往它的 左孩子 节点。
 * 'R' 表示从一个节点前往它的 右孩子 节点。
 * 'U' 表示从一个节点前往它的 父 节点。
 * 请你返回从 s 到 t 最短路径 每一步的方向。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,1,2,3,null,6,4], startValue = 3, destValue = 6
 * 输出："UURL"
 * 解释：最短路径为：3 → 1 → 5 → 2 → 6 。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1], startValue = 2, destValue = 1
 * 输出："L"
 * 解释：最短路径为：2 → 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目为 n 。
 * 2 <= n <= 105
 * 1 <= Node.val <= n
 * 树中所有节点的值 互不相同 。
 * 1 <= startValue, destValue <= n
 * startValue != destValue
 */
public class Code17 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    //缓存,子负关系
    Map<TreeNode, TreeNode> childFatherMap = new HashMap<>();
    //起点终点
    TreeNode startNode = null;
    TreeNode endNode = null;
    //起点终点深度
    Integer startDeep = null;
    Integer endDeep = null;

    //往下走
    public void next(TreeNode node, TreeNode father, int deep, int startValue, int destValue) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //记录子父关系
        childFatherMap.put(node, father);
        //当前值
        int value = node.val;
        //判断起点
        if (value == startValue) {
            //记录
            startNode = node;
            startDeep = deep;
        }
        //判断终点
        if (value == destValue) {
            //记录
            endNode = node;
            endDeep = deep;
        }
        //下一级
        next(node.left, node, deep + 1, startValue, destValue);
        next(node.right, node, deep + 1, startValue, destValue);
    }

    public String getDirections(TreeNode root, int startValue, int destValue) {
        //走一遍
        next(root, null, 0, startValue, destValue);
        //获取起点终点
        TreeNode startNode = this.startNode;
        TreeNode endNode = this.endNode;
        //起点终点深度
        int startDeep = this.startDeep;
        int endDeep = this.endDeep;
        //如果不是一个节点(共同父亲)
        while (startNode != endNode) {
            //如果开始更深
            if (startDeep > endDeep) {
                //往上走
                startDeep--;
                startNode = childFatherMap.get(startNode);
            } else {
                //往上走
                endDeep--;
                endNode = childFatherMap.get(endNode);
            }
        }
        //结果
        StringBuilder result = new StringBuilder();
        //判断一个节点是否为另一个节点的父级,还是有共同的父亲
        if (startNode == this.startNode) {
            //初始化链
            Set<TreeNode> nodeSet = new HashSet<>();
            //开始节点是父亲,所以要不断往下走,先从下往上走一遍,记录节点,然后反推
            TreeNode upNodeFindEnd = this.endNode;
            //如果不是开始节点
            while (upNodeFindEnd != this.startNode) {
                //记录
                nodeSet.add(upNodeFindEnd);
                //往上走
                upNodeFindEnd = childFatherMap.get(upNodeFindEnd);
            }
            //获取开始节点,准备往下走
            TreeNode downNodeFindStart = this.startNode;
            //如果没走到底
            while (downNodeFindStart != this.endNode) {
                //判断左右
                if (nodeSet.contains(downNodeFindStart.left)) {
                    //往左下走
                    result.append("L");
                    downNodeFindStart = downNodeFindStart.left;
                } else {
                    //往右下走
                    result.append("R");
                    downNodeFindStart = downNodeFindStart.right;
                }
            }
        } else if (startNode == this.endNode) {
            //结束节点是父亲,所以获取开始节点,不断往上走
            TreeNode upNodeFindStart = this.startNode;
            //如果不是结束节点
            while (upNodeFindStart != this.endNode) {
                //往上走
                result.append("U");
                upNodeFindStart = childFatherMap.get(upNodeFindStart);
            }
        } else {
            //获取共同的父亲
            TreeNode father = startNode;
            //结束节点是父亲,所以获取开始节点,不断往上走
            TreeNode upNodeFindFather = this.startNode;
            //如果不是父亲
            while (upNodeFindFather != father) {
                //往上走
                result.append("U");
                upNodeFindFather = childFatherMap.get(upNodeFindFather);
            }
            //初始化链
            Set<TreeNode> nodeSet = new HashSet<>();
            //开始节点是父亲,所以要不断往下走,先从下往上走一遍,记录节点,然后反推
            TreeNode upNodeFindEnd = this.endNode;
            //如果不是父亲
            while (upNodeFindEnd != father) {
                //记录
                nodeSet.add(upNodeFindEnd);
                //往上走
                upNodeFindEnd = childFatherMap.get(upNodeFindEnd);
            }
            //获取父亲节点,准备往下走
            TreeNode fatherFindEnd = father;
            //如果没走到底
            while (fatherFindEnd != this.endNode) {
                //判断左右
                if (nodeSet.contains(fatherFindEnd.left)) {
                    //往左下走
                    result.append("L");
                    fatherFindEnd = fatherFindEnd.left;
                } else {
                    //往右下走
                    result.append("R");
                    fatherFindEnd = fatherFindEnd.right;
                }
            }
        }
        //返回结果
        return result.toString();
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

        five.left = one;
        five.right = two;

        one.left = three;

        two.left = six;
        two.right = four;

        System.out.println(new Code17().getDirections(five, 3, 6));
        ;

    }

}
