package difficult4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-11-12
 * 2246. 相邻字符不同的最长路径
 * 算术评级: 7
 * 第 289 场周赛
 * Q4
 * 同步题目状态
 * <p>
 * 2126
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一棵 树（即一个连通、无向、无环图），根节点是节点 0 ，这棵树由编号从 0 到 n - 1 的 n 个节点组成。用下标从 0 开始、长度为 n 的数组 parent 来表示这棵树，其中 parent[i] 是节点 i 的父节点，由于节点 0 是根节点，所以 parent[0] == -1 。
 * <p>
 * 另给你一个字符串 s ，长度也是 n ，其中 s[i] 表示分配给节点 i 的字符。
 * <p>
 * 请你找出路径上任意一对相邻节点都没有分配到相同字符的 最长路径 ，并返回该路径的长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：parent = [-1,0,0,1,1,2], s = "abacbe"
 * 输出：3
 * 解释：任意一对相邻节点字符都不同的最长路径是：0 -> 1 -> 3 。该路径的长度是 3 ，所以返回 3 。
 * 可以证明不存在满足上述条件且比 3 更长的路径。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：parent = [-1,0,0,0], s = "aabc"
 * 输出：3
 * 解释：任意一对相邻节点字符都不同的最长路径是：2 -> 0 -> 3 。该路径的长度为 3 ，所以返回 3 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == parent.length == s.length
 * 1 <= n <= 105
 * 对所有 i >= 1 ，0 <= parent[i] <= n - 1 均成立
 * parent[0] == -1
 * parent 表示一棵有效的树
 * s 仅由小写英文字母组成
 */
public class Code16 {

    private static class Node {

        //字符
        private char letter;

        //子节点
        private Set<Node> children;

        //初始化
        public Node(char letter) {
            this.letter = letter;
            this.children = new HashSet<>();
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("letter=%s,children=%s", this.letter, this.children.size());
        }

    }

    //最大长度
    private int maxLength = 0;

    public int longestPath(int[] parent, String s) {
        //节点数组
        Node[] nodeArr = new Node[s.length()];
        //循环
        for (int i = 0; i < s.length(); i++) {
            //初始化
            nodeArr[i] = new Node(s.charAt(i));
        }
        //循环
        for (int i = 1; i < nodeArr.length; i++) {
            //获取父亲
            Node father = nodeArr[parent[i]];
            //获取孩子
            Node child = nodeArr[i];
            //关联
            father.children.add(child);
        }
        //从头结点开始
        next(nodeArr[0]);
        //返回
        return this.maxLength;
    }

    //递归计算不同节点路径
    private int next(Node node) {
        //判空
        if (node == null) {
            //过
            return 0;
        }
        //不同的数组
        List<Integer> notSameList = new ArrayList<>();
        //循环子节点
        for (Node child : node.children) {
            //递归子节点
            int next = next(child);
            //如果字母不同
            if (child.letter != node.letter) {
                //记录
                notSameList.add(next);
            }
        }
        //排序
        notSameList.sort((a, b) -> b.compareTo(a));
        //本次返回结果
        int result;
        //判断有没有
        if (notSameList.size() > 0) {
            //使用最大的
            result = notSameList.get(0) + 1;
        } else {
            //默认
            result = 1;
        }
        //刷新最大
        this.maxLength = Math.max(this.maxLength, result);
        //如果有2个
        if (notSameList.size() > 1) {
            //2个其他点连接
            int ab = notSameList.get(0) + notSameList.get(1) + 1;
            //刷新最大
            this.maxLength = Math.max(this.maxLength, ab);
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().longestPath(new int[]{-1, 0, 0, 1, 1, 2}, "abacbe"));
    }

}
