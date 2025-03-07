package normal18;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author ayl
 * @Date 2022-12-23
 * 988. 从叶结点开始的最小字符串
 * 给定一颗根结点为 root 的二叉树，树中的每一个结点都有一个 [0, 25] 范围内的值，分别代表字母 'a' 到 'z'。
 * <p>
 * 返回 按字典序最小 的字符串，该字符串从这棵树的一个叶结点开始，到根结点结束。
 * <p>
 * 注：字符串中任何较短的前缀在 字典序上 都是 较小 的：
 * <p>
 * 例如，在字典序上 "ab" 比 "aba" 要小。叶结点是指没有子结点的结点。
 * 节点的叶节点是没有子节点的节点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [0,1,2,3,4,3,4]
 * 输出："dba"
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [25,1,3,1,3,0,2]
 * 输出："adz"
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,2,1,null,1,0,null,0]
 * 输出："abc"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定树的结点数在 [1, 8500] 范围内
 * 0 <= Node.val <= 25
 */
public class Code3 {

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

    //排序
    private List<String> sortList = new ArrayList<>();

    public String smallestFromLeaf(TreeNode root) {
        //走一遍
        next(root, new StringBuffer());
        //排序
        Collections.sort(sortList);
        //返回第一个
        return sortList.stream().findFirst().get();
    }

    public void next(TreeNode root, StringBuffer str) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //获取单词
        char letter = getLetter(root);
        //组装
        str.insert(0, letter);
        //如果是根
        if (root.left == null && root.right == null) {
            //反转、记录结果
            sortList.add(str.toString());
            //回溯
            str.deleteCharAt(0);
            //结束
            return;
        }
        //下一级
        next(root.left, str);
        next(root.right, str);
        //回溯
        str.deleteCharAt(0);
    }

    //转化为单词
    private char getLetter(TreeNode root) {
        //实现
        return (char) (root.val + 'a');
    }

    public static void main(String[] args) {
        TreeNode three = new TreeNode(3);

        TreeNode two = new TreeNode(2);
        three.left = two;

        TreeNode one = new TreeNode(4);
        three.right = one;

        System.out.println(new Code3().smallestFromLeaf(three));
    }

}
