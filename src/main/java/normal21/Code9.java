package normal21;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-07-01
 * 剑指 Offer II 055. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * <p>
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * <p>
 * 可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * <p>
 * <p>
 * 输入
 * inputs = ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * inputs = [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * <p>
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 0 <= Node.val <= 106
 * 最多调用 105 次 hasNext 和 next 操作
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。
 * <p>
 * <p>
 * 注意：本题与主站 173 题相同： https://leetcode-cn.com/problems/binary-search-tree-iterator/
 */
public class Code9 {

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

    //缓存
    private Stack<TreeNode> stack;

    public Code9(TreeNode root) {
        //初始化
        this.stack = new Stack<>();
        //加入主节点至缓存
        push(root);
    }

    public int next() {
        //获取并从缓存中删除当前节点
        TreeNode node = stack.pop();
        //本次结果
        int targetValue = node.val;
        //寻找下一个节点
        push(node.right);
        //返回本次节点
        return targetValue;
    }

    //判断
    public boolean hasNext() {
        //如果还有就是
        return this.stack.size() > 0;
    }

    //往缓存里加
    private void push(TreeNode node) {
        //如果有左节点
        while (node != null) {
            //记录路径
            stack.push(node);
            //下一个节点
            node = node.left;
        }
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        TreeNode twelve = new TreeNode(12);
        twelve.left = six;

        six.right = nine;
        six.left = one;

        Code9 code9 = new Code9(twelve);

        System.out.println(code9.next());

        System.out.println(code9.next());

        System.out.println(code9.next());

        System.out.println(code9.next());

        System.out.println(code9.next());

        System.out.println();
    }

}
