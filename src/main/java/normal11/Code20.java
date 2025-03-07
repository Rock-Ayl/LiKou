package normal11;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-02-18
 * 1161. 最大层内元素和
 * 给你一个二叉树的根节点 root。设根节点位于二叉树的第 1 层，而根节点的子节点位于第 2 层，依此类推。
 * <p>
 * 请返回层内元素之和 最大 的那几层（可能只有一层）的层号，并返回其中 最小 的那个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,7,0,7,-8,null,null]
 * 输出：2
 * 解释：
 * 第 1 层各元素之和为 1，
 * 第 2 层各元素之和为 7 + 0 = 7，
 * 第 3 层各元素之和为 7 + -8 = -1，
 * 所以我们返回第 2 层的层号，它的层内元素之和最大。
 * 示例 2：
 * <p>
 * 输入：root = [989,null,10250,98693,-89388,null,null,null,-32127]
 * 输出：2
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中的节点数在 [1, 104]范围内
 * -105 <= Node.val <= 105
 */
public class Code20 {

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
    Map<Integer, Integer> map = new HashMap<>();

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //记录每次和
        map.put(deep, map.getOrDefault(deep, 0) + root.val);
        //下一级
        next(root.left, deep + 1);
        next(root.right, deep + 1);
    }

    public int maxLevelSum(TreeNode root) {
        //开始计算
        next(root, 1);
        //最小值
        int max = Integer.MIN_VALUE;
        //初始化列表
        List<Integer> list = new ArrayList<>();
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //判断更大还是相等
            if (entry.getValue() > max) {
                //清楚
                list.clear();
                //记录
                max = entry.getValue();
                list.add(entry.getKey());
            } else if (entry.getValue() == max) {
                //记录
                list.add(entry.getKey());
            }
        }
        //判空
        if (list.isEmpty()) {
            //默认
            return 1;
        }
        //排序
        Collections.sort(list);
        //返回
        return list.get(0);
    }

}
