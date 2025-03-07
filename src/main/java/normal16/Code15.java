package normal16;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-10-06
 * 2385. 感染二叉树需要的总时间
 * 给你一棵二叉树的根节点 root ，二叉树中节点的值 互不相同 。另给你一个整数 start 。在第 0 分钟，感染 将会从值为 start 的节点开始爆发。
 * <p>
 * 每分钟，如果节点满足以下全部条件，就会被感染：
 * <p>
 * 节点此前还没有感染。
 * 节点与一个已感染节点相邻。
 * 返回感染整棵树需要的分钟数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,5,3,null,4,10,6,9,2], start = 3
 * 输出：4
 * 解释：节点按以下过程被感染：
 * - 第 0 分钟：节点 3
 * - 第 1 分钟：节点 1、10、6
 * - 第 2 分钟：节点5
 * - 第 3 分钟：节点 4
 * - 第 4 分钟：节点 9 和 2
 * 感染整棵树需要 4 分钟，所以返回 4 。
 * 示例 2：
 * <p>
 * <p>
 * 输入：root = [1], start = 1
 * 输出：0
 * 解释：第 0 分钟，树中唯一一个节点处于感染状态，返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 内
 * 1 <= Node.val <= 105
 * 每个节点的值 互不相同
 * 树中必定存在值为 start 的节点
 */
public class Code15 {

    public static class TreeNode {
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

    //子、父关系缓存
    private Map<TreeNode, TreeNode> map = new HashMap<>();
    //节点总数
    private int nodeCount = 0;
    //开始节点
    private TreeNode startNode = null;

    public void next(TreeNode node, TreeNode father, int start) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //记录子父关系
        map.put(node, father);
        //记录节点数
        nodeCount++;
        //如果是开始节点
        if (node.val == start) {
            //记录
            startNode = node;
        }
        //下一级
        next(node.left, node, start);
        next(node.right, node, start);
    }

    public int amountOfTime(TreeNode root, int start) {
        //记录子父节点,寻找开始节点
        next(root, null, start);
        //初始化感染时间
        int infectTime = 0;
        //判空
        if (this.startNode == null) {
            //直接返回
            return infectTime;
        }
        //所有已经被感染的节点
        Set<TreeNode> allNodeSet = new HashSet<>();
        //当前已经被感染的节点
        Set<TreeNode> nodeSet = new HashSet<>();
        //初始化下一批节点
        Set<TreeNode> nextNodeSet = new HashSet<>();
        //从开始节点开始
        nodeSet.add(this.startNode);
        allNodeSet.add(this.startNode);
        //循环
        while (allNodeSet.size() < nodeCount) {
            //循环,组装没有感染过的左右子节点、父节点
            for (TreeNode treeNode : nodeSet) {
                //左子树
                TreeNode left = treeNode.left;
                //如果没有感染过左子树
                if (left != null && allNodeSet.contains(left) == false) {
                    //组装
                    nextNodeSet.add(left);
                }
                //右子树
                TreeNode right = treeNode.right;
                //如果没有感染过右子树
                if (right != null && allNodeSet.contains(right) == false) {
                    //组装
                    nextNodeSet.add(right);
                }
                //获取父亲节点
                TreeNode father = map.get(treeNode);
                //如果没有感染过父节点
                if (father != null && allNodeSet.contains(father) == false) {
                    //组装
                    nextNodeSet.add(father);
                }
            }
            //如果没有可感染
            if (nodeSet.size() < 1) {
                //彻底结束循环
                break;
            }
            //记录感染
            allNodeSet.addAll(nextNodeSet);
            //记录
            Set<TreeNode> thirdSet = nodeSet;
            //下一个
            nodeSet = nextNodeSet;
            nextNodeSet = thirdSet;
            thirdSet.clear();
            //增加感染时间
            infectTime++;
        }
        //返回结果
        return infectTime;
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);

        one.left = five;
        one.right = three;

        three.left = ten;
        three.right = six;

        five.right = four;

        four.left = nine;
        four.right = two;

        int count = new Code15().amountOfTime(one, 3);
        System.out.println();

    }


}
