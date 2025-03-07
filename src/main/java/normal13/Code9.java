package normal13;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2022-03-19
 * 508. 出现次数最多的子树元素和
 * 给你一个二叉树的根结点 root ，请返回出现次数最多的子树元素和。如果有多个元素出现的次数相同，返回所有出现次数最多的子树元素和（不限顺序）。
 * <p>
 * 一个结点的 「子树元素和」 定义为以该结点为根的二叉树上所有结点的元素之和（包括结点本身）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-3]
 * 输出: [2,-3,4]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入: root = [5,2,-5]
 * 输出: [2]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 节点数在 [1, 104] 范围内
 * -105 <= Node.val <= 105
 */
public class Code9 {

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

    //最大出现次数
    int maxCount = 0;
    //最大结果出现次数
    int maxCountSize = 0;
    //<每种和,出现次数>
    Map<Integer, Integer> map = new HashMap<>();

    public int count(TreeNode root) {
        //判空
        if (root == null) {
            //默认0
            return 0;
        }
        //计算左右
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        //当前和
        int sum = root.val + leftCount + rightCount;
        //这个和的目前总数
        int count = map.getOrDefault(sum, 0) + 1;
        //组装回去
        map.put(sum, count);
        //如果更大
        if (count > maxCount) {
            //刷新
            maxCountSize = 1;
            maxCount = count;
        } else if (count == maxCount) {
            //+1
            maxCountSize++;
        }
        //返回
        return sum;
    }

    public int[] findFrequentTreeSum(TreeNode root) {
        //计算
        count(root);
        //如果没有
        if (maxCountSize == 0) {
            //默认
            return new int[]{};
        }
        //结果
        int[] result = new int[maxCountSize];
        //指针
        int p = 0;
        //循环
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            //如果目标出现次数最大
            if (entry.getValue() == maxCount) {
                //记录
                result[p++] = entry.getKey();
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(5);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(-3);
        one.left = two;
        one.right = three;
        int[] arr = new Code9().findFrequentTreeSum(one);
        System.out.println();
    }

}
