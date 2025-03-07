package normal12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-02-22
 * 103. 二叉树的锯齿形层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 锯齿形层序遍历 。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [3,9,20,null,null,15,7]
 * 输出：[[3],[20,9],[15,7]]
 * 示例 2：
 * <p>
 * 输入：root = [1]
 * 输出：[[1]]
 * 示例 3：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数目在范围 [0, 2000] 内
 * -100 <= Node.val <= 100
 */
public class Code4 {

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
    Map<Integer, List<Integer>> map = new HashMap<>();

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //获取或初始化
        List<Integer> list = map.getOrDefault(deep, new ArrayList<>());
        //如果是左往右
        if (deep % 2 == 0) {
            //组装
            list.add(root.val);
        } else {
            //组装
            list.add(0, root.val);
        }
        //记录
        map.put(deep, list);
        //下一级
        next(root.left, deep + 1);
        next(root.right, deep + 1);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //开始计算
        next(root, 0);
        //指针
        int p = 0;
        //初始化
        List<List<Integer>> result = new ArrayList<>();
        //循环
        while (p < map.size()) {
            //组装
            result.add(map.get(p++));
        }
        //返回
        return result;
    }

}
