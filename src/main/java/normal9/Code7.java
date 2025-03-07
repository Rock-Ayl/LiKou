package normal9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-01-02
 * 515. 在每个树行中找最大值
 * 给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。
 * <p>
 * <p>
 * <p>
 * 示例1：
 * <p>
 * 输入: root = [1,3,2,5,3,null,9]
 * 输出: [1,3,9]
 * 解释:
 * 1
 * / \
 * 3   2
 * / \   \
 * 5   3   9
 * 示例2：
 * <p>
 * 输入: root = [1,2,3]
 * 输出: [1,3]
 * 解释:
 * 1
 * / \
 * 2   3
 * 示例3：
 * <p>
 * 输入: root = [1]
 * 输出: [1]
 * 示例4：
 * <p>
 * 输入: root = [1,null,2]
 * 输出: [1,2]
 * 解释:
 * 1
 * \
 * 2
 * 示例5：
 * <p>
 * 输入: root = []
 * 输出: []
 * <p>
 * <p>
 * 提示：
 * <p>
 * 二叉树的节点个数的范围是 [0,104]
 * -231 <= Node.val <= 231 - 1
 */
public class Code7 {

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
    //最大深度
    int maxDeep = 0;

    public void next(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //当前深度
        int thisDeep = deep + 1;
        //如果更深
        if (thisDeep > maxDeep) {
            //刷新
            maxDeep = thisDeep;
        }
        //当前深度默认值
        int thisDeepMax = map.getOrDefault(thisDeep, Integer.MIN_VALUE);
        //如果有更新
        if (root.val >= thisDeepMax) {
            //更新
            map.put(thisDeep, root.val);
        }
        //下一级
        next(root.left, thisDeep);
        next(root.right, thisDeep);
    }

    public List<Integer> largestValues(TreeNode root) {
        //开始计算
        next(root, 0);
        //缓存
        List<Integer> result = new ArrayList<>(maxDeep);
        //指针
        int p = 1;
        //循环
        while (p <= maxDeep) {
            //组装
            result.add(map.get(p++));
        }
        //返回
        return result;
    }

}
