package normal15;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-08-07
 * 2196. 根据描述创建二叉树
 * 给你一个二维整数数组 descriptions ，其中 descriptions[i] = [parenti, childi, isLefti] 表示 parenti 是 childi 在 二叉树 中的 父节点，二叉树中各节点的值 互不相同 。此外：
 * <p>
 * 如果 isLefti == 1 ，那么 childi 就是 parenti 的左子节点。
 * 如果 isLefti == 0 ，那么 childi 就是 parenti 的右子节点。
 * 请你根据 descriptions 的描述来构造二叉树并返回其 根节点 。
 * <p>
 * 测试用例会保证可以构造出 有效 的二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：descriptions = [[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]
 * 输出：[50,20,80,15,17,19]
 * 解释：根节点是值为 50 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：descriptions = [[1,2,1],[2,3,0],[3,4,1]]
 * 输出：[1,2,null,null,3,4]
 * 解释：根节点是值为 1 的节点，因为它没有父节点。
 * 结果二叉树如上图所示。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= descriptions.length <= 104
 * descriptions[i].length == 3
 * 1 <= parenti, childi <= 105
 * 0 <= isLefti <= 1
 * descriptions 所描述的二叉树是一棵有效二叉树
 */
public class Code16 {

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

    public TreeNode createBinaryTree(int[][] descriptions) {
        //没有父节点的节点
        Set<TreeNode> noFatherSet = new HashSet<>();
        //缓存
        Map<Integer, TreeNode> map = new HashMap<>();
        //循环
        for (int[] description : descriptions) {
            //父子节点值
            int fatherVal = description[0];
            int childVal = description[1];
            //父子节点
            TreeNode father;
            TreeNode child;
            //获取父子节点
            if (map.containsKey(fatherVal)) {
                //获取
                father = map.get(fatherVal);
            } else {
                //初始化
                father = new TreeNode(fatherVal);
                //组装
                map.put(fatherVal, father);
                //记录其可能为父节点
                noFatherSet.add(father);
            }
            //获取父子节点
            if (map.containsKey(childVal)) {
                //获取
                child = map.get(childVal);
            } else {
                //初始化
                child = new TreeNode(childVal);
                //组装
                map.put(childVal, child);
            }
            //判断方向
            if (description[2] == 1) {
                //连接
                father.left = child;
            } else {
                //连接
                father.right = child;
            }
            //其不可能为父
            noFatherSet.remove(child);
        }
        //返回父亲
        return noFatherSet.stream().findFirst().get();
    }

    public static void main(String[] args) {
        TreeNode tree = new Code16().createBinaryTree(new int[][]{
                new int[]{20, 15, 1},
                new int[]{20, 17, 0},
                new int[]{50, 20, 1},
                new int[]{50, 80, 0},
                new int[]{80, 19, 1}
        });
    }

}
