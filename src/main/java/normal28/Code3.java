package normal28;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2024-01-17
 * 2049. 统计最高分的节点数目
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一棵根节点为 0 的 二叉树 ，它总共有 n 个节点，节点编号为 0 到 n - 1 。同时给你一个下标从 0 开始的整数数组 parents 表示这棵树，其中 parents[i] 是节点 i 的父节点。由于节点 0 是根，所以 parents[0] == -1 。
 * <p>
 * 一个子树的 大小 为这个子树内节点的数目。每个节点都有一个与之关联的 分数 。求出某个节点分数的方法是，将这个节点和与它相连的边全部 删除 ，剩余部分是若干个 非空 子树，这个节点的 分数 为所有这些子树 大小的乘积 。
 * <p>
 * 请你返回有 最高得分 节点的 数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * example-1
 * <p>
 * 输入：parents = [-1,2,0,2,0]
 * 输出：3
 * 解释：
 * - 节点 0 的分数为：3 * 1 = 3
 * - 节点 1 的分数为：4 = 4
 * - 节点 2 的分数为：1 * 1 * 2 = 2
 * - 节点 3 的分数为：4 = 4
 * - 节点 4 的分数为：4 = 4
 * 最高得分为 4 ，有三个节点得分为 4 （分别是节点 1，3 和 4 ）。
 * 示例 2：
 * <p>
 * example-2
 * <p>
 * 输入：parents = [-1,2,0]
 * 输出：2
 * 解释：
 * - 节点 0 的分数为：2 = 2
 * - 节点 1 的分数为：2 = 2
 * - 节点 2 的分数为：1 * 1 = 1
 * 最高分数为 2 ，有两个节点分数为 2 （分别为节点 0 和 1 ）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == parents.length
 * 2 <= n <= 105
 * parents[0] == -1
 * 对于 i != 0 ，有 0 <= parents[i] <= n - 1
 * parents 表示一棵二叉树。
 */
public class Code3 {

    //节点
    private class Node {

        //子节点列表
        private Set<Node> nodeSet = new HashSet<>();

    }

    //节点缓存
    private Map<Integer, Node> nodeMap;
    //节点数量
    private int nodeSize;
    //最大结果
    private long max = 0;
    //最大结果的数量
    private int maxSize = 0;

    //计算结果
    private void count(long num) {
        //如果结果更大
        if (num > this.max) {
            //重置
            this.max = num;
            this.maxSize = 1;
        } else if (num == this.max) {
            //+1
            this.maxSize++;
        }
    }

    //构件树
    private void build(int[] parents) {
        //初始化缓存
        this.nodeMap = new HashMap<>();
        //节点数量
        this.nodeSize = parents.length;
        //循环
        for (int i = 0; i < parents.length; i++) {
            //初始化当前节点
            this.nodeMap.put(i, new Node());
        }
        //循环2
        for (int i = 1; i < parents.length; i++) {
            //获取其父级
            Node father = this.nodeMap.get(parents[i]);
            //获取子级
            Node child = this.nodeMap.get(i);
            //关联父子
            father.nodeSet.add(child);
        }
    }

    //递归
    private int next(Node node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //如果没有子节点
        if (node.nodeSet.isEmpty()) {
            //记录本次结果
            count(this.nodeSize - 1);
            //返回结果数量
            return 1;
        }
        //子节点数量和
        int sizeSum = 0;
        //本次结果初始化
        long target = 1L;
        //循环
        for (Node nextNode : node.nodeSet) {
            //当前下一级节点size
            int nextSize = next(nextNode);
            //叠加
            sizeSum += nextSize;
            //计算本次结果
            target = target * nextSize;
        }
        //上级节点值
        int upSize = this.nodeSize - 1 - sizeSum;
        //如果有上级节点
        if (upSize > 0) {
            //计算
            target = target * upSize;
        }
        //记录本次结果
        count(target);
        //返回结果数量
        return sizeSum + 1;
    }

    //实现
    public int countHighestScoreNodes(int[] parents) {
        //step 1. 构件树
        build(parents);
        //step 2. 从主节点开始递归计算每个节点的结果
        next(this.nodeMap.get(0));
        //返回最大结果
        return this.maxSize;
    }

}
