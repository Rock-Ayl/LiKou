package normal27;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-01-13
 * LCR 043. 完全二叉树插入器
 * 尝试过
 * 中等
 * 相关标签
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
public class Code20 {

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

    //主节点 缓存
    private TreeNode root;
    //当前 完全二叉树 缓存
    private List<List<TreeNode>> nodeList;

    public Code20(TreeNode root) {
        //初始化缓存
        this.root = null;
        this.nodeList = new ArrayList<>();
        //如果有默认的节点传入
        if (root != null) {
            //记录节点
            this.root = root;
            //初始化构建
            build(Collections.singletonList(root));
        }
    }

    //初始化构建 递归实现
    private void build(List<TreeNode> nodeList) {
        //判空
        if (nodeList.isEmpty()) {
            //过
            return;
        }
        //加入当前节点列表至缓存
        this.nodeList.add(nodeList);
        //初始化下一层节点列表
        List<TreeNode> nextNodeList = new ArrayList<>();
        //循环
        for (TreeNode node : nodeList) {
            //判空
            if (node.left == null) {
                //跳出
                break;
            }
            //组装
            nextNodeList.add(node.left);
            //判空
            if (node.right == null) {
                //跳出
                break;
            }
            //组装
            nextNodeList.add(node.right);
        }
        //递归下一层级
        build(nextNodeList);
    }

    //插入实现
    public int insert(int v) {

        //初始化当前节点(子节点)
        TreeNode newChildNode = new TreeNode(v);

        /**
         * 第一个节点特殊处理
         */

        //判空
        if (this.root == null) {
            //第一个节点
            this.root = newChildNode;
            //初始化第一层
            this.nodeList.add(Collections.singletonList(newChildNode));
            //没有父级,默认返回
            return -1;
        }

        /**
         * 判断是否要扩展新的列表层级
         */

        //如果只有一层 or [最下一层列表长度]正好是[上一层列表长度]的2倍
        if (this.nodeList.size() == 1 || this.nodeList.get(this.nodeList.size() - 1).size() == this.nodeList.get(this.nodeList.size() - 2).size() * 2) {
            //初始化新的列表
            this.nodeList.add(new ArrayList<>());
        }

        /**
         * 获取其父级节点
         */

        //子节点列表
        List<TreeNode> childNodeList = this.nodeList.get(this.nodeList.size() - 1);
        //父节点列表
        List<TreeNode> fatherNodeList = this.nodeList.get(this.nodeList.size() - 2);
        //获取父级节点
        TreeNode fatherNode = fatherNodeList.get(childNodeList.size() / 2);

        /**
         * 彻底插入节点
         */

        //子节点加入到列表
        childNodeList.add(newChildNode);
        //如果没有左节点
        if (fatherNode.left == null) {
            //关联
            fatherNode.left = newChildNode;
        } else {
            //关联
            fatherNode.right = newChildNode;
        }

        /**
         * 返回目标 父节点值
         */

        //返回父节点内容
        return fatherNode.val;
    }

    //获取当前主节点
    public TreeNode get_root() {
        //返回
        return this.root;
    }

}
