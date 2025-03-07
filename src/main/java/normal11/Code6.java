package normal11;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-02-03
 * 865. 具有所有最深节点的最小子树
 * 给定一个根为 root 的二叉树，每个节点的深度是 该节点到根的最短距离 。
 * <p>
 * 返回包含原始树中所有 最深节点 的 最小子树 。
 * <p>
 * 如果一个节点在 整个树 的任意节点之间具有最大的深度，则该节点是 最深的 。
 * <p>
 * 一个节点的 子树 是该节点加上它的所有后代的集合。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4]
 * 输出：[2,7,4]
 * 解释：
 * 我们返回值为 2 的节点，在图中用黄色标记。
 * 在图中用蓝色标记的是树的最深的节点。
 * 注意，节点 5、3 和 2 包含树中最深的节点，但节点 2 的子树最小，因此我们返回它。
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 解释：根节点是树中最深的节点。
 * 示例 3：
 * <p>
 * 输入：root = [0,1,3,null,2]
 * 输出：[2]
 * 解释：树中最深的节点为 2 ，有效子树为节点 2、1 和 0 的子树，但节点 2 的子树最小。
 */
public class Code6 {

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

    //所有子父级的缓存
    Map<TreeNode, TreeNode> map = new HashMap<>();
    //按照深度的缓存
    Map<Integer, List<TreeNode>> map2 = new HashMap<>();

    public void next(TreeNode root, TreeNode father, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //记录父子级关系
        map.put(root, father);
        //当前深度所有同级节点
        List<TreeNode> list = map2.getOrDefault(deep, new ArrayList<>());
        //记录其
        list.add(root);
        //组装回去
        map2.put(deep, list);
        //下一级
        next(root.left, root, deep + 1);
        next(root.right, root, deep + 1);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        //遍历,记录缓存
        next(root, null, 1);
        //最深深度
        int deep = map2.size();
        //最深深度节点列表,转化为set
        Set<TreeNode> set = new HashSet<>(map2.get(deep));
        //一直循环
        while (set.size() > 1) {
            //新的set
            Set<TreeNode> nextSet = new HashSet<>();
            //循环
            for (TreeNode treeNode : set) {
                //获取父级并组装
                nextSet.add(map.get(treeNode));
            }
            //更换set
            set = nextSet;
        }
        //返回最终结果
        return set.stream().findFirst().get();
    }

}
