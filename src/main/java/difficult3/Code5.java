package difficult3;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2025-01-04
 * LCR 156. 序列化与反序列化二叉树
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
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Code5 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //默认空
    private StringBuilder NONE = new StringBuilder();

    //左递归
    private StringBuilder serializeLeftNext(TreeNode node, Map<Integer, Integer> cacheNumberCountMap, Map<TreeNode, String> nodeKeyMap) {
        //判空
        if (node == null) {
            //过
            return NONE;
        }
        //当前数字编号
        Integer numberCount = cacheNumberCountMap.getOrDefault(node.val, 0) + 1;
        //计算key
        String key = String.format("%s_%s", node.val, numberCount);
        //记录缓存
        cacheNumberCountMap.put(node.val, numberCount);
        nodeKeyMap.put(node, key);
        //初始化返回值
        StringBuilder result = new StringBuilder(key);
        //判空
        if (node.left != null) {
            //递归
            result.append(',').append(serializeLeftNext(node.left, cacheNumberCountMap, nodeKeyMap));
        }
        //判空
        if (node.right != null) {
            //递归
            result.append(',').append(serializeLeftNext(node.right, cacheNumberCountMap, nodeKeyMap));
        }
        //返回
        return result;
    }

    //中递归
    private StringBuilder serializeMidNext(TreeNode node, Map<TreeNode, String> nodeKeyMap) {
        //判空
        if (node == null) {
            //过
            return NONE;
        }
        //获取缓存key
        String key = nodeKeyMap.get(node);
        //初始化返回值
        StringBuilder result = new StringBuilder();
        //判空
        if (node.left != null) {
            //递归
            result.append(serializeMidNext(node.left, nodeKeyMap)).append(',');
        }
        //组装
        result.append(key);
        //判空
        if (node.right != null) {
            //递归
            result.append(',').append(serializeMidNext(node.right, nodeKeyMap));
        }
        //返回
        return result;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return null;
        }
        //缓存
        Map<TreeNode, String> cacheNodeKeyMap = new HashMap<>();
        Map<Integer, Integer> cacheNumberCountMap = new HashMap<>();
        //先递归左递归
        StringBuilder leftStr = serializeLeftNext(root, cacheNumberCountMap, cacheNodeKeyMap);
        //再递归右递归
        StringBuilder rightStr = serializeMidNext(root, cacheNodeKeyMap);
        //返回
        return leftStr.append('&').append(rightStr).toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //判空
        if (data == null) {
            //过
            return null;
        }
        //拆分左右数组
        String[] split = data.split("&");
        //继续拆分
        String[] leftArr = split[0].split(",");
        String[] rightArr = split[1].split(",");
        //递归实现
        return deserializeNext(leftArr, rightArr, 0, leftArr.length - 1, 0, rightArr.length - 1);
    }

    //递归
    private TreeNode deserializeNext(String[] leftArr, String[] rightArr, int ls, int le, int rs, int re) {
        //如果越界
        if (ls > le) {
            //过
            return null;
        }
        //获取主节点key
        String nodeKey = leftArr[ls];
        //初始化当前节点
        TreeNode node = new TreeNode(keyToNumber(nodeKey));
        //如果只有一个节点
        if (ls == le) {
            //返回
            return node;
        }
        //搜索右数组中，主节点key的位置
        int index = arrIndex(rightArr, nodeKey);
        //左树的节点数量
        int leftCount = index - rs;
        //右树的节点数量
        int rightCount = le - ls - leftCount;
        //如果有左树
        if (leftCount > 0) {
            //递归
            node.left = deserializeNext(leftArr, rightArr, ls + 1, ls + leftCount, rs, index - 1);
        }
        //如果有右树
        if (rightCount > 0) {
            //递归
            node.right = deserializeNext(leftArr, rightArr, le - rightCount + 1, le, index + 1, re);
        }
        //返回
        return node;
    }

    //key转数字
    private int keyToNumber(String key) {
        //实现
        return Integer.valueOf(key.split("_")[0]);
    }

    //获取数组中对应key的索引
    private int arrIndex(String[] arr, String key) {
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果是
            if (arr[i].equals(key)) {
                //返回
                return i;
            }
        }
        //默认
        return -1;
    }

    public static void main(String[] args) {

        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        String serialize = new Code5().serialize(treeNode1);
        System.out.println(serialize);

        TreeNode deserialize = new Code5().deserialize(serialize);
        System.out.println();

    }

}
