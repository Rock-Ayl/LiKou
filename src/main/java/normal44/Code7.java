package normal44;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-06-24
 * 2471. 逐层排序二叉树所需的最少操作数目
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 值互不相同 的二叉树的根节点 root 。
 * <p>
 * 在一步操作中，你可以选择 同一层 上任意两个节点，交换这两个节点的值。
 * <p>
 * 返回每一层按 严格递增顺序 排序所需的最少操作数目。
 * <p>
 * 节点的 层数 是该节点和根节点之间的路径的边数。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * 输入：root = [1,4,3,7,6,8,5,null,null,null,null,9,null,10]
 * 输出：3
 * 解释：
 * - 交换 4 和 3 。第 2 层变为 [3,4] 。
 * - 交换 7 和 5 。第 3 层变为 [5,6,8,7] 。
 * - 交换 8 和 7 。第 3 层变为 [5,6,7,8] 。
 * 共计用了 3 步操作，所以返回 3 。
 * 可以证明 3 是需要的最少操作数目。
 * 示例 2 ：
 * <p>
 * <p>
 * 输入：root = [1,3,2,7,6,5,4]
 * 输出：3
 * 解释：
 * - 交换 3 和 2 。第 2 层变为 [2,3] 。
 * - 交换 7 和 4 。第 3 层变为 [4,6,5,7] 。
 * - 交换 6 和 5 。第 3 层变为 [4,5,6,7] 。
 * 共计用了 3 步操作，所以返回 3 。
 * 可以证明 3 是需要的最少操作数目。
 * 示例 3 ：
 * <p>
 * <p>
 * 输入：root = [1,2,3,4,5,6]
 * 输出：0
 * 解释：每一层已经按递增顺序排序，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [1, 105] 。
 * 1 <= Node.val <= 105
 * 树中的所有值 互不相同 。
 */
public class Code7 {

    private static class TreeNode {
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

    //每层节点
    private List<List<Integer>> deepList = new ArrayList<>();
    //最终结果操作次数
    private int result = 0;

    public int minimumOperations(TreeNode root) {

        /**
         * step 1.递归出每层数字
         */

        //递归
        deep(root, 0);

        /**
         * step 2.每层计算排序次数
         */

        //循环
        for (List<Integer> sortList : this.deepList) {
            //计算、叠加本次
            this.result += sort(sortList);
        }

        //返回
        return this.result;
    }

    //递归整理层级数字
    private void deep(TreeNode node, int deep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //如果不够
        if (this.deepList.size() <= deep) {
            //初始化
            this.deepList.add(new ArrayList<>());
        }
        //记录最近的结果
        this.deepList.get(deep).add(node.val);
        //继续递归
        deep(node.left, deep + 1);
        deep(node.right, deep + 1);
    }

    //排序并返回操作次数
    private int sort(List<Integer> sortList) {

        /**
         * 特殊
         */

        //如果太少
        if (sortList.size() < 2) {
            //过
            return 0;
        }

        /**
         * 构造节点
         */

        //初始化节点列表
        List<SortNum> sortNumList = new ArrayList<>();
        //循环
        for (int i = 0; i < sortList.size(); i++) {
            //初始化节点
            sortNumList.add(new SortNum(sortList.get(i), i));
        }

        /**
         * 计算其目标位置
         */

        //目标位置对应节点
        Map<Integer, SortNum> targetMap = new HashMap<>();
        //初始化另一个列表
        List<SortNum> targetList = new ArrayList<>(sortNumList);
        //排序
        targetList.sort((a, b) -> a.num - b.num);
        //循环
        for (int i = 0; i < targetList.size(); i++) {
            //记录目标位置
            targetList.get(i).target = i;
            //关联
            targetMap.put(i, targetList.get(i));
        }

        /**
         * 计算具体操作次数
         */

        //操作次数
        int change = 0;
        //循环
        for (int i = 0; i < sortNumList.size(); i++) {

            /**
             * 获取、判断是否交换
             */

            //获取该位置当前节点
            SortNum left = sortNumList.get(i);
            //获取该位置目标节点
            SortNum right = targetMap.get(i);
            //如果是一个
            if (right == left) {
                //本轮过
                continue;
            }

            /**
             * 交换二者
             */

            //交换索引
            left.index = right.index;
            right.index = i;

            //交换节点
            sortNumList.set(right.index, right);
            sortNumList.set(left.index, left);

            //交换一次
            change++;

        }
        //返回
        return change;
    }

    //排序数字
    private static class SortNum {

        //数字
        private int num;

        //当前索引
        private int index;

        //目标索引位置,默认-1
        private int target = -1;

        //初始化
        public SortNum(int num, int index) {
            this.num = num;
            this.index = index;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("num=%s,index=%s,target=%s", this.num, this.index, this.target);
        }

    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(3);

        TreeNode treeNode4 = new TreeNode(7);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode6 = new TreeNode(8);
        TreeNode treeNode7 = new TreeNode(5);

        TreeNode treeNode8 = new TreeNode(9);
        TreeNode treeNode9 = new TreeNode(10);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;

        treeNode3.left = treeNode6;
        treeNode3.right = treeNode7;

        treeNode6.left = treeNode8;
        treeNode7.left = treeNode9;

        int i = new Code7().minimumOperations(treeNode1);
        System.out.println(i);

    }

}