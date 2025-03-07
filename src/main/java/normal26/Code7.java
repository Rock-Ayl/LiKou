package normal26;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-11-22
 * 919. 完全二叉树插入器
 * 中等
 * 162
 * 相关企业
 * 完全二叉树 是每一层（除最后一层外）都是完全填充（即，节点数达到最大）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一种算法，将一个新节点插入到一个完整的二叉树中，并在插入后保持其完整。
 * <p>
 * 实现 CBTInserter 类:
 * <p>
 * CBTInserter(TreeNode root) 使用头节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个值为 Node.val == val的新节点 TreeNode。使树保持完全二叉树的状态，并返回插入节点 TreeNode 的父节点的值；
 * CBTInserter.get_root() 将返回树的头节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入
 * ["CBTInserter", "insert", "insert", "get_root"]
 * [[[1, 2]], [3], [4], []]
 * 输出
 * [null, 1, 2, [1, 2, 3, 4]]
 * <p>
 * 解释
 * CBTInserter cBTInserter = new CBTInserter([1, 2]);
 * cBTInserter.insert(3);  // 返回 1
 * cBTInserter.insert(4);  // 返回 2
 * cBTInserter.get_root(); // 返回 [1, 2, 3, 4]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数量范围为 [1, 1000]
 * 0 <= Node.val <= 5000
 * root 是完全二叉树
 * 0 <= val <= 5000
 * 每个测试用例最多调用 insert 和 get_root 操作 104 次
 */
public class Code7 {

    public static class TreeNode {
        private int val;
        private TreeNode left;
        private TreeNode right;

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

    private TreeNode root;

    //节点列表
    private List<List<TreeNode>> nodeList;

    public Code7(TreeNode root) {
        this.root = root;
        //初始化节点列表
        this.nodeList = new ArrayList<>();
        //初始化第0层
        this.nodeList.add(new ArrayList<>());
        //初始化递归
        next(root, 1);
    }

    //初始化递归
    private void next(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果不够深度
        if (this.nodeList.size() == deep) {
            //初始化
            this.nodeList.add(new ArrayList<>());
        }
        //记录本次节点
        this.nodeList.get(deep).add(node);
        //递归
        next(node.left, deep + 1);
        next(node.right, deep + 1);
    }

    //插入
    public int insert(int val) {
        //初始化新节点
        TreeNode newNode = new TreeNode(val);
        //最后一层层级
        int lastDeep = this.nodeList.size() - 1;
        //获取最后一层节点
        List<TreeNode> lastNodeList = this.nodeList.get(lastDeep);
        //获取最后二层节点
        List<TreeNode> secondNodeList = this.nodeList.get(lastDeep - 1);
        //如果最后一层满了(最后一层是最后二层的2倍),扩展新的,否则是现有
        if (lastNodeList.size() == secondNodeList.size() * 2 || this.nodeList.size() == 2) {
            //初始化新的一层
            this.nodeList.add(new ArrayList<>());
            //获取其父亲
            TreeNode fatherNode = lastNodeList.get(0);
            //关联
            fatherNode.left = newNode;
            //插入新节点
            this.nodeList.get(lastDeep + 1).add(newNode);
            //返回父节点值
            return fatherNode.val;
        } else {
            //计算父级的索引
            int targetIndex = lastNodeList.size() / 2;
            //获取父级
            TreeNode fatherNode = secondNodeList.get(targetIndex);
            //判断关联左右
            if (fatherNode.left == null) {
                //关联
                fatherNode.left = newNode;
            } else {
                //关联
                fatherNode.right = newNode;
            }
            //插入新节点
            lastNodeList.add(newNode);
            //返回父节点值
            return fatherNode.val;
        }
    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);

        node1.left = node2;

        Code7 code7 = new Code7(node1);
        code7.insert(3);
        code7.insert(4);
        System.out.println();
    }

}
