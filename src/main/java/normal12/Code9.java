package normal12;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-02-27
 * 1123. 最深叶节点的最近公共祖先
 * 给你一个有根节点 root 的二叉树，返回它 最深的叶节点的最近公共祖先 。
 * <p>
 * 回想一下：
 * <p>
 * 叶节点 是二叉树中没有子节点的节点
 * 树的根节点的 深度 为 0，如果某一节点的深度为 d，那它的子节点的深度就是 d+1
 * 如果我们假定 A 是一组节点 S 的 最近公共祖先，S 中的每个节点都在以 A 为根节点的子树中，且 A 的深度达到此条件下可能的最大值。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 6、0 和 8 也是叶节点，但是它们的深度是 2 ，而节点 7 和 4 的深度是 3 。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点，它是它本身的最近公共祖先。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的叶节点是 2 ，最近公共祖先是它自己。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数将在 [1, 1000] 的范围内。
 * 0 <= Node.val <= 1000
 * 每个节点的值都是 独一无二 的。
 */
public class Code9 {

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

    //子、父级缓存
    Map<TreeNode, TreeNode> map = new HashMap<>();
    //深度列表
    Map<Integer, List<TreeNode>> map2 = new HashMap<>();

    public void next(TreeNode father, TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //记录子父级
        map.put(root, father);
        //记录深度
        List<TreeNode> list = map2.getOrDefault(deep, new ArrayList<>());
        list.add(root);
        map2.put(deep, list);
        //下一个深度
        int nextDeep = deep + 1;
        //下一级
        next(root, root.left, nextDeep);
        next(root, root.right, nextDeep);
    }

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        //开始计算
        next(new TreeNode(-1), root, 1);
        //最深节点set
        Set<TreeNode> lastDeepNode = new HashSet<>(map2.get(map2.size()));
        //如果节点不对
        while (lastDeepNode.size() > 1) {
            //下一个
            Set<TreeNode> next = new HashSet<>();
            //循环
            for (TreeNode treeNode : lastDeepNode) {
                //记录
                next.add(map.get(treeNode));
            }
            //下一次
            lastDeepNode = next;
        }
        //返回最终的
        return lastDeepNode.stream().findFirst().get();
    }

}
