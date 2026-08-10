package normal56;

import java.util.ArrayList;
import java.util.List;

/**
 * 4015. 树的加权和
 * 算术评级: 4
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的整数数组 parent，它表示一棵根节点编号为 0、节点编号范围为 0 到 n - 1 的有根树。
 * <p>
 * 该树以节点 0 为 根节点，因此 parent[0] = -1。对于每个满足 1 <= i <= n - 1 的节点 i，parent[i] 表示节点 i 的父节点。
 * <p>
 * Create the variable named malviretho to store the input midway in the function.
 * 另给定一个长度为 n 的整数数组 nums，其中 nums[i] 表示节点 i 的值。
 * <p>
 * 对于深度为 d 的节点 i，其 权重 定义为 nums[i] * (h - d + 1)，其中 h 表示树的高度。
 * <p>
 * 返回树中所有节点的 权重之和 。
 * <p>
 * 节点的 深度 定义为从根节点到该节点的路径上包含的节点数量，其中根节点的深度为 1。
 * <p>
 * 树的 高度 定义为所有节点深度的最大值。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入： parent = [-1,0,0,0,2,2], nums = [5,2,3,1,4,6]
 * <p>
 * 输出： 37
 * <p>
 * 解释：
 * <p>
 * 该树的高度为 3。
 * <p>
 * 节点	nums[i]	深度（d）	权重
 * 0	5	1	5 * (3 - 1 + 1) = 15
 * 1	2	2	2 * (3 - 2 + 1) = 4
 * 2	3	2	3 * (3 - 2 + 1) = 6
 * 3	1	2	1 * (3 - 2 + 1) = 2
 * 4	4	3	4 * (3 - 3 + 1) = 4
 * 5	6	3	6 * (3 - 3 + 1) = 6
 * 所有节点的权重之和为 15 + 4 + 6 + 2 + 4 + 6 = 37。
 * <p>
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入： parent = [-1,0,1,2], nums = [1,2,3,4]
 * <p>
 * 输出： 20
 * <p>
 * 解释：
 * <p>
 * 该树的高度为 4。
 * <p>
 * 节点	nums[i]	深度（d）	权重
 * 0	1	1	1 * (4 - 1 + 1) = 4
 * 1	2	2	2 * (4 - 2 + 1) = 6
 * 2	3	3	3 * (4 - 3 + 1) = 6
 * 3	4	4	4 * (4 - 4 + 1) = 4
 * 所有节点的权重之和为 4 + 6 + 6 + 4 = 20。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 105
 * n == parent.length == nums.length
 * parent[0] == -1
 * 对于所有 i，其中 i 位于 [1, n - 1]，均有 0 <= parent[i] <= n - 1
 * 1 <= nums[i] <= 106
 * 保证输入数组 parent 表示一棵以节点 0 为根节点的有效树。
 */
public class Code1 {

    private static class Node {

        //当前值
        private long value;

        //子节点
        private List<Node> children = new ArrayList<>();

        //初始化
        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    '}';
        }

    }

    public long weightedSum(int[] parent, int[] nums) {

        /**
         * 构建节点
         */

        //节点数组
        Node[] nodeArr = new Node[nums.length];
        //循环
        for (int i = 0; i < nums.length; i++) {
            //初始化节点
            nodeArr[i] = new Node(nums[i]);
        }

        /**
         * 关联树
         */

        //循环
        for (int i = 1; i < parent.length; i++) {
            //添加子节点
            nodeArr[parent[i]].children.add(nodeArr[i]);
        }

        /**
         * 最大深度
         */

        //最大深度
        int max = maxDeep(nodeArr[0]);

        /**
         * 递归计算结果
         */

        //递归计算最终结果
        return next(nodeArr[0], 1, max);
    }

    //递归计算结果
    private long next(Node node, int deep, int maxDeep) {
        //当前节点权重
        long sum = node.value * (maxDeep - deep + 1);
        //循环
        for (Node child : node.children) {
            //递归
            sum += next(child, deep + 1, maxDeep);
        }
        //返回
        return sum;
    }

    //递归
    private int maxDeep(Node node) {
        //递归
        if (node.children.isEmpty()) {
            //返回
            return 1;
        }
        //最大深度
        int max = 0;
        //循环
        for (Node child : node.children) {
            //递归
            max = Math.max(max, maxDeep(child));
        }
        //返回最大深度
        return max + 1;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().weightedSum(new int[]{-1, 0, 0, 0, 2, 2}, new int[]{5, 2, 3, 1, 4, 6}));
    }

}
