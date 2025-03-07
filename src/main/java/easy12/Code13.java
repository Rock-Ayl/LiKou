package easy12;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-10-12
 * LCP 44. 开幕式焰火
 * 「力扣挑战赛」开幕式开始了，空中绽放了一颗二叉树形的巨型焰火。
 * 给定一棵二叉树 root 代表焰火，节点值表示巨型焰火这一位置的颜色种类。请帮小扣计算巨型焰火有多少种不同的颜色。
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [1,3,2,1,null,2]
 * <p>
 * 输出：3
 * <p>
 * 解释：焰火中有 3 个不同的颜色，值分别为 1、2、3
 * <p>
 * 示例 2：
 * <p>
 * 输入：root = [3,3,3]
 * <p>
 * 输出：1
 * <p>
 * 解释：焰火中仅出现 1 个颜色，值为 3
 * <p>
 * 提示：
 * <p>
 * 1 <= 节点个数 <= 1000
 * 1 <= Node.val <= 1000
 */
public class Code13 {

    public class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    class Solution {

        //缓存
        Set<Integer> set = new HashSet<>();

        public int numColor(TreeNode root) {
            //如果左边有
            if (root.left != null) {
                //下一级
                numColor(root.left);
            }
            //如果右边有
            if (root.right != null) {
                //等下一级
                numColor(root.right);
            }
            //记录
            set.add(root.val);
            //返回
            return set.size();
        }

    }
}
