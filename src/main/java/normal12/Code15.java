package normal12;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-03-05
 * 1609. 奇偶树
 * 如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：
 * <p>
 * 二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
 * 偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
 * 奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
 * 给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：root = [1,10,4,3,null,7,9,12,8,6,null,null,2]
 * 输出：true
 * 解释：每一层的节点值分别是：
 * 0 层：[1]
 * 1 层：[10,4]
 * 2 层：[3,7,9]
 * 3 层：[12,8,6,2]
 * 由于 0 层和 2 层上的节点值都是奇数且严格递增，而 1 层和 3 层上的节点值都是偶数且严格递减，因此这是一棵奇偶树。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,4,2,3,3,7]
 * 输出：false
 * 解释：每一层的节点值分别是：
 * 0 层：[5]
 * 1 层：[4,2]
 * 2 层：[3,3,7]
 * 2 层上的节点值不满足严格递增的条件，所以这不是一棵奇偶树。
 * 示例 3：
 * <p>
 * <p>
 * <p>
 * 输入：root = [5,9,1,3,5,7]
 * 输出：false
 * 解释：1 层上的节点值应为偶数。
 * 示例 4：
 * <p>
 * 输入：root = [1]
 * 输出：true
 * 示例 5：
 * <p>
 * 输入：root = [11,8,6,1,3,9,11,30,20,18,16,12,10,4,2,17]
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数在范围 [1, 105] 内
 * 1 <= Node.val <= 106
 */
public class Code15 {

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

    public boolean check(TreeNode root, int deep) {
        //判空
        if (root != null) {
            //如果是偶数
            if (deep % 2 == 0) {
                //如果不是
                if (root.val % 2 == 0) {
                    //返回
                    return false;
                }
                //如果有当前深度
                if (map.containsKey(deep)) {
                    //如果不满足条件
                    if (root.val <= map.get(deep)) {
                        //返回
                        return false;
                    }
                }
            } else {
                //如果不是
                if (root.val % 2 != 0) {
                    //返回
                    return false;
                }
                //如果有当前深度
                if (map.containsKey(deep)) {
                    //如果不满足条件
                    if (root.val >= map.get(deep)) {
                        //返回
                        return false;
                    }
                }
            }
            //刷新值
            map.put(deep, root.val);
            //下一级深度
            int nextDeep = deep + 1;
            //从左到有检查下一级
            if (check(root.left, nextDeep) == false || check(root.right, nextDeep) == false) {
                //
                return false;
            }
        }
        //默认
        return true;
    }

    public boolean isEvenOddTree(TreeNode root) {
        //判断
        return check(root, 0);
    }

}
