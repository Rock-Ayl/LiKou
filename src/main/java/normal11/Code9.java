package normal11;

import java.util.*;

/**
 * @Author ayl
 * @Date 2022-02-06
 * 863. 二叉树中所有距离为 K 的结点
 * 给定一个二叉树（具有根结点 root）， 一个目标结点 target ，和一个整数值 K 。
 * <p>
 * 返回到目标结点 target 距离为 K 的所有结点的值的列表。 答案可以以任何顺序返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2
 * 输出：[7,4,1]
 * 解释：
 * 所求结点为与目标结点（值为 5）距离为 2 的结点，
 * 值分别为 7，4，以及 1
 * <p>
 * <p>
 * <p>
 * 注意，输入的 "root" 和 "target" 实际上是树上的结点。
 * 上面的输入仅仅是对这些对象进行了序列化描述。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 给定的树是非空的。
 * 树上的每个结点都具有唯一的值 0 <= node.val <= 500 。
 * 目标结点 target 是树上的结点。
 * 0 <= K <= 1000.
 */
public class Code9 {

    public static class TreeNode {
        int val;
       public TreeNode left;
       public TreeNode right;

        public TreeNode(int x) {
            val = x;
        }
    }

    //<子节点,父节点>map
    Map<TreeNode, TreeNode> fatherMap = new HashMap<>();
    //目标节点
    TreeNode target = null;
    //结果
    List<Integer> result = new ArrayList<>();

    //遍历,记录子父级关系,寻找目标节点
    public void next(TreeNode node, TreeNode father, int target) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //记录父子级关系
        fatherMap.put(node, father);
        //如果是目标节点
        if (node.val == target) {
            //记录目标节点
            this.target = node;
        }
        //下一级
        next(node.left, node, target);
        next(node.right, node, target);
    }

    //逐步计算
    public void count(TreeNode node, int k, Set<TreeNode> set) {
        //如果为空 || 如果其走过这个节点
        if (node == null || set.contains(node)) {
            //过
            return;
        }
        //记录其已经走过了该节点
        set.add(node);
        //当前路径
        int line = k - 1;
        //如果走到了寻找的节点
        if (line < 0) {
            //记录结果
            this.result.add(node.val);
        } else {
            //尝试继续走下去(左右上)
            count(node.left, line, set);
            count(node.right, line, set);
            count(fatherMap.get(node), line, set);
        }
        //回溯
        set.remove(node);
    }

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        //开始遍历,寻找并记录
        next(root, null, target.val);
        //逐步计算,从目标节点开始
        count(this.target, k, new HashSet<>());
        //返回结果
        return this.result;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(5);
        TreeNode three = new TreeNode(1);

        one.left = two;
        one.right = three;

        TreeNode four = new TreeNode(6);
        TreeNode five = new TreeNode(2);

        two.left = four;
        two.right = five;

        TreeNode six = new TreeNode(7);
        TreeNode seven = new TreeNode(4);

        five.left = six;
        five.right = seven;

        TreeNode eight = new TreeNode(0);
        TreeNode nine = new TreeNode(8);

        three.left = eight;
        three.right = nine;

        List<Integer> result = new Code9().distanceK(one, two, 2);
        System.out.println(123);
    }

}
