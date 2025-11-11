package normal47;

import java.util.*;

/**
 * @Author ayl
 * @Date 2025-11-11
 * 2476. 二叉搜索树最近节点查询
 * 尝试过
 * 算术评级: 4
 * 第 320 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1597
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * <p>
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * <p>
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 * <p>
 * <p>
 * <p>
 * 示例 1 ：
 * <p>
 * <p>
 * <p>
 * 输入：root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]
 * 输出：[[2,2],[4,6],[15,-1]]
 * 解释：按下面的描述找出并返回查询的答案：
 * - 树中小于等于 2 的最大值是 2 ，且大于等于 2 的最小值也是 2 。所以第一个查询的答案是 [2,2] 。
 * - 树中小于等于 5 的最大值是 4 ，且大于等于 5 的最小值是 6 。所以第二个查询的答案是 [4,6] 。
 * - 树中小于等于 16 的最大值是 15 ，且大于等于 16 的最小值不存在。所以第三个查询的答案是 [15,-1] 。
 * 示例 2 ：
 * <p>
 * <p>
 * <p>
 * 输入：root = [4,null,9], queries = [3]
 * 输出：[[-1,4]]
 * 解释：树中不存在小于等于 3 的最大值，且大于等于 3 的最小值是 4 。所以查询的答案是 [-1,4] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点的数目在范围 [2, 105] 内
 * 1 <= Node.val <= 106
 * n == queries.length
 * 1 <= n <= 105
 * 1 <= queries[i] <= 106
 */
public class Code23 {

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

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        //初始化缓存
        List<Integer> nodeList = new ArrayList<>();
        //转为列表
        next(root, nodeList);
        //转为集合
        Set<Integer> nodeSet = new HashSet<>(nodeList);
        //初始化结果
        List<List<Integer>> resultList = new ArrayList<>(queries.size());
        //循环
        for (Integer target : queries) {
            //如果存在
            if (nodeSet.contains(target)) {
                //组装结果
                resultList.add(Arrays.asList(target, target));
            } else {
                //二分查找
                int[] targetResult = find(nodeList, target);
                //组装结果
                resultList.add(Arrays.asList(targetResult[0], targetResult[1]));
            }
        }
        //返回
        return resultList;
    }

    //二分查找
    private int[] find(List<Integer> nodeList, Integer target) {
        //如果目标太小了
        if (nodeList.get(0).compareTo(target) > 0) {
            //返回
            return new int[]{-1, nodeList.get(0)};
        }
        //如果目标太大了
        if (nodeList.get(nodeList.size() - 1).compareTo(target) < 0) {
            //返回
            return new int[]{nodeList.get(nodeList.size() - 1), -1};
        }
        //递归实现
        return find(nodeList, target, 0, nodeList.size() - 1);
    }

    //递归二分查找
    private int[] find(List<Integer> nodeList, Integer target, int start, int end) {
        //如果最小可能了
        if (start + 1 == end) {
            //返回
            return new int[]{nodeList.get(start), nodeList.get(end)};
        }
        //计算中间节点
        int mid = (end - start) / 2 + start;
        //判断方向
        if (nodeList.get(mid) < target) {
            //递归右边
            return find(nodeList, target, mid, end);
        } else {
            //递归左边
            return find(nodeList, target, start, mid);
        }
    }

    //递归转为列表
    private void next(TreeNode node, List<Integer> nodeList) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //先递归左边
        next(node.left, nodeList);
        //中间
        nodeList.add(node.val);
        //再递归右边
        next(node.right, nodeList);
    }

    public static void main(String[] args) {

        // root = [6,2,13,1,4,9,15,null,null,null,null,null,null,14], queries = [2,5,16]

        // 构建二叉树
        TreeNode node1 = new TreeNode(1);
        TreeNode node4 = new TreeNode(4);
        TreeNode node14 = new TreeNode(14);

        TreeNode node9 = new TreeNode(9);
        TreeNode node15 = new TreeNode(15, node14, null);

        TreeNode node2 = new TreeNode(2, node1, node4);
        TreeNode node13 = new TreeNode(13, node9, node15);

        TreeNode root = new TreeNode(6, node2, node13);

        // queries = [2,5,16]
        List<Integer> queries = Arrays.asList(2, 5, 16);

        List<List<Integer>> lists = new Code23().closestNodes(root, queries);

        // 打印结果
        System.out.println("查询结果:");
        for (int i = 0; i < queries.size(); i++) {
            System.out.println("查询 " + queries.get(i) + " -> " + lists.get(i));
        }

    }

}
