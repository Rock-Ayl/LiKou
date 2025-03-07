package easy15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2021-11-25
 * 637. 二叉树的层平均值
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 输出：[3, 14.5, 11]
 * 解释：
 * 第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class Code10 {

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

    Map<Integer, Double> sumMap = new HashMap<>();
    Map<Integer, Integer> sizeMap = new HashMap<>();

    public void count(TreeNode root, int deep) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //叠加和
        sumMap.put(deep, sumMap.getOrDefault(deep, 0d) + root.val);
        //次数
        sizeMap.put(deep, sizeMap.getOrDefault(deep, 0) + 1);
        //下一级
        count(root.left, deep + 1);
        count(root.right, deep + 1);
    }

    public List<Double> averageOfLevels(TreeNode root) {
        //计算
        count(root, 1);
        //结果
        List<Double> result = new ArrayList<>();
        //循环
        for (int i = 1; i <= sizeMap.size(); i++) {
            //结果
            double num = sumMap.get(i) / sizeMap.get(i);
            //记录
            result.add(num);
        }
        //返回
        return result;
    }

}
