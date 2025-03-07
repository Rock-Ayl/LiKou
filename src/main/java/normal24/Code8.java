package normal24;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-09-20
 * LCR 043. 完全二叉树插入器
 * 中等
 * 61
 * 相关企业
 * 完全二叉树是每一层（除最后一层外）都是完全填充（即，节点数达到最大，第 n 层有 2n-1 个节点）的，并且所有的节点都尽可能地集中在左侧。
 * <p>
 * 设计一个用完全二叉树初始化的数据结构 CBTInserter，它支持以下几种操作：
 * <p>
 * CBTInserter(TreeNode root) 使用根节点为 root 的给定树初始化该数据结构；
 * CBTInserter.insert(int v)  向树中插入一个新节点，节点类型为 TreeNode，值为 v 。使树保持完全二叉树的状态，并返回插入的新节点的父节点的值；
 * CBTInserter.get_root() 将返回树的根节点。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","get_root"], inputs = [[[1]],[2],[]]
 * 输出：[null,1,[1,2]]
 * 示例 2：
 * <p>
 * 输入：inputs = ["CBTInserter","insert","insert","get_root"], inputs = [[[1,2,3,4,5,6]],[7],[8],[]]
 * 输出：[null,3,4,[1,2,3,4,5,6,7,8]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 最初给定的树是完全二叉树，且包含 1 到 1000 个节点。
 * 每个测试用例最多调用 CBTInserter.insert  操作 10000 次。
 * 给定节点或插入节点的每个值都在 0 到 5000 之间。
 * <p>
 * <p>
 * 注意：本题与主站 919 题相同： https://leetcode-cn.com/problems/complete-binary-tree-inserter/
 */
public class Code8 {

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

    //主节点
    private TreeNode root;

    //节点列表
    private List<List<TreeNode>> nodeList;

    public Code8(TreeNode root) {
        //初始化
        this.root = root;
        this.nodeList = new ArrayList<>();
        //默认第一层节点
        this.nodeList.add(Arrays.asList(root));
        //初始化子体
        List<TreeNode> chilren = new ArrayList<>();
        //判空
        if (root.left != null) {
            //组装
            chilren.add(root.left);
        }
        //判空
        if (root.right != null) {
            //组装
            chilren.add(root.right);
        }
        //循环
        while (chilren.size() > 0) {
            //初始化新层级
            this.nodeList.add(new ArrayList<>());
            //加入所有
            this.nodeList.get(this.nodeList.size() - 1).addAll(chilren);
            //初始化子体
            List<TreeNode> nextChildren = new ArrayList<>();
            //循环
            for (TreeNode treeNode : chilren) {
                //判空
                if (treeNode.left != null) {
                    //组装
                    nextChildren.add(treeNode.left);
                }
                //判空
                if (treeNode.right != null) {
                    //组装
                    nextChildren.add(treeNode.right);
                }
            }
            //下一级
            chilren = nextChildren;
        }
    }

    public int insert(int v) {
        //新节点
        TreeNode treeNode = new TreeNode(v);
        //如果当前层级满了
        if (this.nodeList.size() == 1 || (this.nodeList.get(this.nodeList.size() - 1).size() == 2 * this.nodeList.get(this.nodeList.size() - 2).size())) {
            //初始化新一层
            this.nodeList.add(new ArrayList<>());
            //加入该节点
            this.nodeList.get(this.nodeList.size() - 1).add(treeNode);
            //获取父节点(上一层第一个节点)
            TreeNode father = this.nodeList.get(this.nodeList.size() - 2).get(0);
            //关联二者
            father.left = treeNode;
            //返回
            return father.val;
        } else {
            //获取最上一层节点列表
            List<TreeNode> lastNodeList = this.nodeList.get(this.nodeList.size() - 1);
            //记录当前节点
            lastNodeList.add(treeNode);
            //获取父节点坐标
            int fatherP = lastNodeList.size() / 2 + lastNodeList.size() % 2;
            //获取父亲
            TreeNode father = this.nodeList.get(this.nodeList.size() - 2).get(fatherP);
            //判断左右
            if (lastNodeList.size() % 2 == 0) {
                //关联二者
                father.right = treeNode;
            } else {
                //关联二者
                father.left = treeNode;
            }
            //返回
            return father.val;
        }
    }

    public TreeNode get_root() {
        return this.root;
    }

    public static void main(String[] args) {
        Code8 code8 = new Code8(new TreeNode(1));
        System.out.println(code8.insert(2));
        System.out.println(code8.get_root());
    }

}
