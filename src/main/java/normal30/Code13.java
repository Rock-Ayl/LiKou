package normal30;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2024-04-06
 * 3043. 最长公共前缀的长度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你两个 正整数 数组 arr1 和 arr2 。
 * <p>
 * 正整数的 前缀 是其 最左边 的一位或多位数字组成的整数。例如，123 是整数 12345 的前缀，而 234 不是 。
 * <p>
 * 设若整数 c 是整数 a 和 b 的 公共前缀 ，那么 c 需要同时是 a 和 b 的前缀。例如，5655359 和 56554 有公共前缀 565 ，而 1223 和 43456 没有 公共前缀。
 * <p>
 * 你需要找出属于 arr1 的整数 x 和属于 arr2 的整数 y 组成的所有数对 (x, y) 之中最长的公共前缀的长度。
 * <p>
 * 返回所有数对之中最长公共前缀的长度。如果它们之间不存在公共前缀，则返回 0 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr1 = [1,10,100], arr2 = [1000]
 * 输出：3
 * 解释：存在 3 个数对 (arr1[i], arr2[j]) ：
 * - (1, 1000) 的最长公共前缀是 1 。
 * - (10, 1000) 的最长公共前缀是 10 。
 * - (100, 1000) 的最长公共前缀是 100 。
 * 最长的公共前缀是 100 ，长度为 3 。
 * 示例 2：
 * <p>
 * 输入：arr1 = [1,2,3], arr2 = [4,4,4]
 * 输出：0
 * 解释：任何数对 (arr1[i], arr2[j]) 之中都不存在公共前缀，因此返回 0 。
 * 请注意，同一个数组内元素之间的公共前缀不在考虑范围内。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= arr1.length, arr2.length <= 5 * 104
 * 1 <= arr1[i], arr2[i] <= 108
 */
public class Code13 {

    //节点
    private static class Node {

        //深度
        private int deep;

        //子节点
        private Map<Character, Node> children;

        //初始化
        public Node(int deep) {
            this.deep = deep;
            this.children = new HashMap<>();
        }

    }

    //字典树主节点
    private Node rootNode = new Node(0);

    //构造树
    private void add(String num) {
        //当前节点
        Node node = this.rootNode;
        //循环
        for (int i = 0; i < num.length(); i++) {
            //当前字符
            char letter = num.charAt(i);
            //如果不存在
            if (node.children.containsKey(letter) == false) {
                //初始化
                node.children.put(letter, new Node(i + 1));
            }
            //下一级
            node = node.children.get(letter);
        }
    }

    //寻找最大深度
    private int find(Node node, String num, int index) {
        //如果寻找目标本身越界
        if (index >= num.length()) {
            //返回
            return node.deep;
        }
        //获取当前
        Character letter = num.charAt(index);
        //如果匹配不到任何子节点,到头了
        if (node.children.containsKey(letter) == false) {
            //返回结果
            return node.deep;
        }
        //递归下一级
        return find(node.children.get(letter), num, index + 1);
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        //循环
        for (Integer num : arr1) {
            //构造树
            add(num.toString());
        }
        //最大结果
        int maxDeep = 0;
        //循环
        for (Integer num : arr2) {
            //寻找该数字的最大深度,从0开始
            maxDeep = Math.max(maxDeep, find(this.rootNode, num.toString(), 0));
        }
        //返回
        return maxDeep;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().longestCommonPrefix(new int[]{1, 26}, new int[]{22, 2}));
    }

}
