package normal9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-01-09
 * 199. 二叉树的右视图
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * <p>
 * <p>
 * 输入: [1,2,3,null,5,null,4]
 * 输出: [1,3,4]
 * 示例 2:
 * <p>
 * 输入: [1,null,3]
 * 输出: [1,3]
 * 示例 3:
 * <p>
 * 输入: []
 * 输出: []
 * <p>
 * <p>
 * 提示:
 * <p>
 * 二叉树的节点个数的范围是 [0,100]
 * -100 <= Node.val <= 100
 */
public class Code14 {

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

    //缓存,记录当前深度是否找到结果
    Set<Integer> set = new HashSet<>();
    //初始化结果
    List<Integer> list = new ArrayList<>();

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //如果当前深度是最右边的
        if (set.contains(deep) == false) {
            //记录
            list.add(root.val);
            set.add(deep);
        }
        //下一级,从右边开始,然后再左边,找最右边的第一个
        next(root.right, deep + 1);
        next(root.left, deep + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        //不断计算
        next(root, 1);
        //返回
        return list;
    }

}
