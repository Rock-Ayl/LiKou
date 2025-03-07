package easy28;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-03-08
 * 501. 二叉搜索树中的众数
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,null,2,2]
 * 输出：[2]
 * 示例 2：
 * <p>
 * 输入：root = [0]
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 104] 内
 * -105 <= Node.val <= 105
 * <p>
 * <p>
 * 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
 */
public class Code22 {

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
    private Map<Integer, Integer> map = new HashMap<>();

    //最大次数的结果列表
    List<Integer> maxCountList = new ArrayList<>();
    //最大次数
    private int maxCount = 0;

    //走下去
    public void next(TreeNode node) {

        //判空
        if (node == null) {
            //过
            return;
        }

        //先左
        next(node.left);

        //更新当前
        update(node.val);

        //再右
        next(node.right);

    }

    //更新
    public void update(int val) {
        //当前次数
        int count = map.getOrDefault(val, 0) + 1;

        //如果可能是结果
        if (count > maxCount) {
            //清除
            maxCountList.clear();
            //记录结果
            maxCountList.add(val);
            //更新最大
            maxCount = count;
        } else if (count == maxCount) {
            //记录结果
            maxCountList.add(val);
        }
        //记录缓存
        map.put(val, count);
    }

    public int[] findMode(TreeNode root) {
        //计算
        next(root);
        //返回结果
        return maxCountList.stream().mapToInt(Integer::intValue).toArray();
    }

}
