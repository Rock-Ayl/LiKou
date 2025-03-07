package normal30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-04-05
 * 652. 寻找重复的子树
 * 中等
 * 相关标签
 * 相关企业
 * 给你一棵二叉树的根节点 root ，返回所有 重复的子树 。
 * <p>
 * 对于同一类的重复子树，你只需要返回其中任意 一棵 的根结点即可。
 * <p>
 * 如果两棵树具有 相同的结构 和 相同的结点值 ，则认为二者是 重复 的。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,null,2,4,null,null,4]
 * 输出：[[2,4],[4]]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,1,1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [2,2,2,3,null,3,null]
 * 输出：[[2,3],[3]]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的结点数在 [1, 5000] 范围内。
 * -200 <= Node.val <= 200
 */
public class Code12 {

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
    private Map<String, List<TreeNode>> map = new HashMap<>();

    //递归
    private String next(TreeNode node) {
        //判空
        if (node == null) {
            //过
            return "";
        }
        //先递归子节点
        String leftResult = next(node.left);
        String rightResult = next(node.right);
        //生成key
        String key = "|" + node.val + "[" + leftResult + "]{" + rightResult + "}";
        //如果不存在
        if (this.map.containsKey(key) == false) {
            //初始化
            this.map.put(key, new ArrayList<>());
        }
        //记录本节点
        this.map.get(key).add(node);
        //返回
        return key;
    }

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        //递归每个节点
        next(root);
        //返回结果
        return this.map
                .values()
                .stream()
                //只需要有重复的结果
                .filter(p -> p.size() > 1)
                //随意拿一个
                .map(p -> p.stream().findFirst().orElse(null))
                .collect(Collectors.toList());
    }

}
