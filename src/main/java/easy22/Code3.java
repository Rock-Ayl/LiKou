package easy22;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2022-08-22
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：nums = [-10,-3,0,5,9]
 * 输出：[0,-3,9,-10,null,5]
 * 解释：[0,-10,5,null,-3,null,9] 也将被视为正确答案：
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * 输入：nums = [1,3]
 * 输出：[3,1]
 * 解释：[1,null,3] 和 [3,1] 都是高度平衡二叉搜索树。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 104
 * -104 <= nums[i] <= 104
 * nums 按 严格递增 顺序排列
 */
public class Code3 {

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

    public TreeNode sortedArrayToBST(int[] nums) {
        //判空
        if (nums.length < 2) {
            //如果只有一个
            if (nums.length == 1) {
                //返回
                return new TreeNode(nums[0]);
            }
            //过
            return null;
        }
        //中间节点坐标、值
        int midNum = nums[nums.length / 2];
        //初始化中间节点
        TreeNode midNode = new TreeNode(midNum);
        //计算左右并连接
        midNode.left = sortedArrayToBST(Arrays.stream(nums).filter(p -> p < midNum).toArray());
        midNode.right = sortedArrayToBST(Arrays.stream(nums).filter(p -> p > midNum).toArray());
        //返回
        return midNode;
    }

}
