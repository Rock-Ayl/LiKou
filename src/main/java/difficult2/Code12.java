package difficult2;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-04-25
 * LCR 048. 二叉树的序列化与反序列化
 * 尝试过
 * 困难
 * 相关标签
 * 相关企业
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
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
 * 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅 LeetCode 序列化二叉树的格式。你并非必须采取这种方式，也可以采用其他的方法解决这个问题。
 * 树中结点数在范围 [0, 104] 内
 * -1000 <= Node.val <= 1000
 * <p>
 * <p>
 * 注意：本题与主站 297 题相同：https://leetcode-cn.com/problems/serialize-and-deserialize-binary-tree/
 */
public class Code12 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //递归前序遍历
    private StringBuilder forwardToString(TreeNode node, Map<Integer, Integer> cacheMap, Map<TreeNode, Integer> nodeCacheMap) {
        //判空
        if (node == null) {
            //过
            return new StringBuilder();
        }
        //初始化str
        StringBuilder result = new StringBuilder();
        //该数字出现的次数
        int count = cacheMap.getOrDefault(node.val, 0) + 1;
        //组装本身节点
        result.append(node.val);
        result.append("+");
        result.append(count);
        result.append(',');
        //记录出现次数,节点内容1
        nodeCacheMap.put(node, count);
        cacheMap.put(node.val, count);
        //递归左边
        result.append(forwardToString(node.left, cacheMap, nodeCacheMap));
        //递归右边
        result.append(forwardToString(node.right, cacheMap, nodeCacheMap));
        //返回
        return result;
    }

    //递归中序遍历
    private StringBuilder midToString(TreeNode node, Map<TreeNode, Integer> nodeCacheMap) {
        //判空
        if (node == null) {
            //过
            return new StringBuilder();
        }
        //初始化str
        StringBuilder result = new StringBuilder();
        //递归左边
        result.append(midToString(node.left, nodeCacheMap));
        //直接获取该节点的出现次数
        int count = nodeCacheMap.get(node);
        //组装本身节点
        result.append(node.val);
        result.append("+");
        result.append(count);
        result.append(',');
        //递归右边
        result.append(midToString(node.right, nodeCacheMap));
        //返回
        return result;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        //判空
        if (root == null) {
            //过
            return "";
        }
        //统一节点缓存
        Map<TreeNode, Integer> nodeCacheMap = new HashMap<>();
        //前+后 序遍历组合为string
        return forwardToString(root, new HashMap<>(), nodeCacheMap)
                .append("&")
                .append(midToString(root, nodeCacheMap))
                .toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //判空
        if ("".equals(data)) {
            //过
            return null;
        }
        //分割前后遍历字符
        String[] arr = data.split("&");
        //转化为对应前后组
        String[] forwardArr = arr[0].split(",");
        String[] backArr = arr[1].split(",");
        //初始化前序索引缓存
        Map<String, Integer> backIndexMap = new HashMap<>();
        //循环
        for (int i = 0; i < backArr.length; i++) {
            //记录索引
            backIndexMap.put(backArr[i], i);
        }
        //递归复原
        return deserialize(forwardArr, backArr, 0, forwardArr.length - 1, 0, backArr.length - 1, backIndexMap);
    }

    //递归反序列树
    private TreeNode deserialize(String[] forwardArr, String[] backArr, int fl, int fr, int bl, int br, Map<String, Integer> backIndexMap) {
        //如果没有任何节点了
        if (fl > fr) {
            //过
            return null;
        }
        //初始化当前节点
        TreeNode node = new TreeNode(unboxing(forwardArr[fl]));
        //如果只有一个节点
        if (fl == fr) {
            //直接返回
            return node;
        }
        //中序遍历中,主节点位置
        Integer midNodeIndex = backIndexMap.get(forwardArr[fl]);
        //右树节点数
        int rightNodeCount = br - midNodeIndex;
        //左树节点数
        int leftNodeCount = fr - fl - rightNodeCount;
        //如果有左树节点
        if (leftNodeCount > 0) {
            //递归左树
            node.left = deserialize(forwardArr, backArr, fl + 1, fl + leftNodeCount, bl, bl + leftNodeCount - 1, backIndexMap);
        }
        //如果有右树节点
        if (rightNodeCount > 0) {
            //递归右树
            node.right = deserialize(forwardArr, backArr, fl + leftNodeCount + 1, fr, midNodeIndex + 1, midNodeIndex + rightNodeCount, backIndexMap);
        }
        //返回
        return node;
    }

    //为字符串拆箱
    private Integer unboxing(String space) {
        return Integer.valueOf(space.split("\\+")[0]);
    }

    public static void main(String[] args) {

        TreeNode one = new TreeNode(3);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(4);

        TreeNode four = new TreeNode(3);


        one.left = two;
        one.right = three;

        two.left = four;

        //序列化
        String serialize = new Code12().serialize(one);
        System.out.println(serialize);

        //反序列化
        TreeNode deserializeTreeNode = new Code12().deserialize(serialize);
        System.out.println();

    }

}
