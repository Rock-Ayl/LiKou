package difficult2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-05-10
 * 297. 二叉树的序列化与反序列化
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 */
public class Code15 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //判空
    private StringBuilder leftNext(TreeNode node, Map<TreeNode, Integer> nodeNumberMap, Map<Integer, Integer> numberCountMap) {
        //判空
        if (node == null) {
            //过
            return new StringBuilder();
        }
        //初始化本次结果
        StringBuilder space = new StringBuilder();
        //获取当前节点数字出现次数
        int count = numberCountMap.getOrDefault(node.val, 0) + 1;
        //记录缓存
        numberCountMap.put(node.val, count);
        nodeNumberMap.put(node, count);
        //组装
        space.append(node.val);
        space.append('_');
        space.append(count);
        space.append(',');
        //递归左右子节点
        space.append(leftNext(node.left, nodeNumberMap, numberCountMap));
        space.append(leftNext(node.right, nodeNumberMap, numberCountMap));
        //返回
        return space;
    }

    //判空
    private StringBuilder rightNext(TreeNode node, Map<TreeNode, Integer> nodeNumberMap) {
        //判空
        if (node == null) {
            //过
            return new StringBuilder();
        }
        //初始化本次结果
        StringBuilder space = new StringBuilder();
        //递归左子节点
        space.append(rightNext(node.left, nodeNumberMap));
        //获取该节点对应count
        int count = nodeNumberMap.get(node);
        //组装
        space.append(node.val);
        space.append('_');
        space.append(count);
        space.append(',');
        //递归右子节点
        space.append(rightNext(node.right, nodeNumberMap));
        //返回
        return space;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //如果不够长
        if (root == null) {
            //过
            return "";
        }
        //节点编号map
        Map<TreeNode, Integer> nodeNumberMap = new HashMap<>();
        //数字出现次数
        Map<Integer, Integer> numberCountMap = new HashMap<>();
        //实现序列化
        return leftNext(root, nodeNumberMap, numberCountMap).append("&").append(rightNext(root, nodeNumberMap)).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //如果不够长
        if (data.length() < 1) {
            //过
            return null;
        }
        //拆分左右
        String[] leftAndRightArr = data.split("&");
        //解析拆分
        String[] leftArr = leftAndRightArr[0].split(",");
        String[] rightArr = leftAndRightArr[1].split(",");
        //右部分节点索引缓存
        Map<String, Integer> rightIndexMap = new HashMap<>();
        //循环
        for (int i = 0; i < rightArr.length; i++) {
            //记录缓存
            rightIndexMap.put(rightArr[i], i);
        }
        //递归实现
        return next(leftArr, rightArr, 0, leftArr.length - 1, 0, rightArr.length - 1, rightIndexMap);
    }

    //递归反序列化
    private TreeNode next(String[] leftArr, String[] rightArr, int ll, int lr, int rl, int rr, Map<String, Integer> rightIndexMap) {
        //判空
        if (ll > lr) {
            //过
            return null;
        }
        //初始化当前节点
        TreeNode root = new TreeNode(Integer.valueOf(leftArr[ll].split("_")[0]));
        //获取对应索引
        Integer rightRootIndex = rightIndexMap.get(leftArr[ll]);
        //左树节点数量
        int leftNodeCount = rightRootIndex - rl;
        //右树节点数量
        int rightNodeCount = lr - ll - leftNodeCount;
        //如果有左节点
        if (leftNodeCount > 0) {
            //递归
            root.left = next(leftArr, rightArr, ll + 1, ll + leftNodeCount, rl, rightRootIndex - 1, rightIndexMap);
        }
        //如果有右节点
        if (rightNodeCount > 0) {
            //递归
            root.right = next(leftArr, rightArr, ll + 1 + leftNodeCount, lr, rightRootIndex + 1, rr, rightIndexMap);
        }
        //返回本节点
        return root;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;

        String serialize = new Code15().serialize(null);

        TreeNode resultNode = new Code15().deserialize(serialize);

        System.out.println();

    }

}
