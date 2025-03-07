package normal20;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2023-04-17
 * 449. 序列化和反序列化二叉搜索树
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中节点数范围是 [0, 104]
 * 0 <= Node.val <= 104
 * 题目数据 保证 输入的树是一棵二叉搜索树。
 */
public class Code1 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //初始化结果
        StringBuilder str = new StringBuilder();
        //递归
        serializeNext(root, str);
        //返回
        return str.toString();
    }

    //递归
    private void serializeNext(TreeNode root, StringBuilder str) {
        //判空
        if (root == null) {
            //过
            return;
        }
        //组装本身
        str.append(root.val);
        str.append(',');
        //先左
        serializeNext(root.left, str);
        //再右
        serializeNext(root.right, str);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //判空
        if (data == null || data.length() == 0) {
            //过
            return null;
        }
        //拆分为数组
        int[] arr = Arrays.stream(data.split(","))
                .mapToInt(p -> Integer.valueOf(p))
                .toArray();
        //实现
        return deserializeNext(arr, 0, arr.length - 1);
    }

    //递归实现
    private TreeNode deserializeNext(int[] arr, int left, int right) {
        //如果左大于右
        if (left > right) {
            //过
            return null;
        }
        //初始化主节点
        TreeNode root = new TreeNode(arr[left]);
        //如果左是右
        if (left == right) {
            //直接返回主节点
            return root;
        }
        //中间点坐标
        int midP = left + 1;
        //如果是
        while (midP <= right && arr[midP] < root.val) {
            //进位
            midP++;
        }
        //递归左右子树
        root.left = deserializeNext(arr, left + 1, midP - 1);
        root.right = deserializeNext(arr, midP, right);
        //返回
        return root;
    }

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);

        two.left = one;
        two.right = three;

        Code1 code1 = new Code1();
        String str1 = code1.serialize(two);
        System.out.println();

        TreeNode node = code1.deserialize(str1);
        System.out.println();
    }

}
