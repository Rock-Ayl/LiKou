package normal26;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2023-12-11
 * 1261. 在受污染的二叉树中查找元素
 * 提示
 * 中等
 * 46
 * 相关企业
 * 给出一个满足下述规则的二叉树：
 * <p>
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * <p>
 * 请你先还原二叉树，然后实现 FindElements 类：
 * <p>
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["FindElements","find","find"]
 * [[[-1,null,-1]],[1],[2]]
 * 输出：
 * [null,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1]);
 * findElements.find(1); // return False
 * findElements.find(2); // return True
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["FindElements","find","find","find"]
 * [[[-1,-1,-1,-1,-1]],[1],[3],[5]]
 * 输出：
 * [null,true,true,false]
 * 解释：
 * FindElements findElements = new FindElements([-1,-1,-1,-1,-1]);
 * findElements.find(1); // return True
 * findElements.find(3); // return True
 * findElements.find(5); // return False
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：
 * ["FindElements","find","find","find","find"]
 * [[[-1,null,-1,-1,null,-1]],[2],[3],[4],[5]]
 * 输出：
 * [null,true,false,false,true]
 * 解释：
 * FindElements findElements = new FindElements([-1,null,-1,-1,null,-1]);
 * findElements.find(2); // return True
 * findElements.find(3); // return False
 * findElements.find(4); // return False
 * findElements.find(5); // return True
 * <p>
 * <p>
 * 提示：
 * <p>
 * TreeNode.val == -1
 * 二叉树的高度不超过 20
 * 节点的总数在 [1, 10^4] 之间
 * 调用 find() 的总次数在 [1, 10^4] 之间
 * 0 <= target <= 10^6
 */
public class Code21 {

    public class TreeNode {
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
    private TreeNode root;
    //节点缓存
    private Set<Integer> cache;

    public Code21(TreeNode root) {
        //记录
        this.root = root;
        //缓存
        this.cache = new HashSet<>();
        //默认
        this.root.val = 0;
        //记录默认缓存
        this.cache.add(this.root.val);
        //修复树
        reset(this.root.left, this.root, true);
        reset(this.root.right, this.root, false);
    }

    //修复递归
    private void reset(TreeNode node, TreeNode father, boolean left) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果是左节点
        if (left) {
            //计算并赋值
            node.val = 2 * father.val + 1;
        } else {
            //计算并赋值
            node.val = 2 * father.val + 2;
        }
        //记录缓存
        this.cache.add(node.val);
        //递归子节点
        reset(node.left, node, true);
        reset(node.right, node, false);
    }

    //寻找递归
    private boolean find(TreeNode node, int target) {
        //判空
        if (node == null) {
            //过
            return false;
        }
        //如果当前值已经大于目标了
        if (node.val > target) {
            //过
            return false;
        }
        //如果是目标
        if (node.val == target) {
            //返回
            return true;
        }
        //先左节点
        boolean success = find(node.left, target);
        //如果有
        if (success) {
            //返回
            return true;
        }
        //再右节点
        success = find(node.right, target);
        //如果有
        if (success) {
            //返回
            return true;
        }
        //默认
        return false;
    }

    public boolean find(int target) {
        //实现
        return this.cache.contains(target);
    }

}
