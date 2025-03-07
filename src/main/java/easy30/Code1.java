package easy30;

/**
 * @Author ayl
 * @Date 2023-04-13
 * 面试题 04.02. 最小高度树
 * 给定一个有序整数数组，元素各不相同且按升序排列，编写一个算法，创建一棵高度最小的二叉搜索树。
 * <p>
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 * <p>
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 * <p>
 * 0
 * / \
 * -3   9
 * /   /
 * -10  5
 */
public class Code1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode next(int[] nums, int left, int right) {
        //如果左大于右
        if (left > right) {
            //过
            return null;
        }
        //如果只有一个节点
        if (left == right) {
            //直接返回
            return new TreeNode(nums[left]);
        }
        //计算中间节点
        int mid = left + ((right - left) / 2);
        //初始化
        TreeNode root = new TreeNode(nums[mid]);
        //计算子树
        root.left = next(nums, left, mid - 1);
        root.right = next(nums, mid + 1, right);
        //返回
        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        //实现
        return next(nums, 0, nums.length - 1);
    }

}
