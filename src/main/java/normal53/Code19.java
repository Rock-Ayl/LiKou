package normal53;

import java.util.HashMap;
import java.util.Map;

/**
 * 2131. 连接两字母单词得到的最长回文串
 * 算术评级: 5
 * 第 69 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1557
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串数组 words 。words 中每个元素都是一个包含 两个 小写英文字母的单词。
 * <p>
 * 请你从 words 中选择一些元素并按 任意顺序 连接它们，并得到一个 尽可能长的回文串 。每个元素 至多 只能使用一次。
 * <p>
 * 请你返回你能得到的最长回文串的 长度 。如果没办法得到任何一个回文串，请你返回 0 。
 * <p>
 * 回文串 指的是从前往后和从后往前读一样的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["lc","cl","gg"]
 * 输出：6
 * 解释：一个最长的回文串为 "lc" + "gg" + "cl" = "lcggcl" ，长度为 6 。
 * "clgglc" 是另一个可以得到的最长回文串。
 * 示例 2：
 * <p>
 * 输入：words = ["ab","ty","yt","lc","cl","ab"]
 * 输出：8
 * 解释：最长回文串是 "ty" + "lc" + "cl" + "yt" = "tylcclyt" ，长度为 8 。
 * "lcyttycl" 是另一个可以得到的最长回文串。
 * 示例 3：
 * <p>
 * 输入：words = ["cc","ll","xx"]
 * 输出：2
 * 解释：最长回文串是 "cc" ，长度为 2 。
 * "ll" 是另一个可以得到的最长回文串。"xx" 也是。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 105
 * words[i].length == 2
 * words[i] 仅包含小写英文字母。
 *
 */
public class Code19 {

    private static class Node {

        //正
        private String right;

        //返回
        private String left;

        //数量
        private Integer count = 0;

        //初始化
        public Node(String right) {
            this.right = right;
            this.left = new StringBuilder(right).reverse().toString();
        }

        //输出
        @Override
        public String toString() {
            return String.format("right=%s,count=%s", this.right, this.count);
        }

    }

    public int longestPalindrome(String[] words) {

        /**
         * 构建节点
         */

        //正反缓存
        Map<String, Node> rightMap = new HashMap<>();
        Map<String, Node> leftMap = new HashMap<>();
        //循环
        for (String word : words) {
            //尝试获取是否存在
            Node node = rightMap.get(word);
            //如果不存在
            if (node == null) {
                //初始化
                node = new Node(word);
                //记录
                rightMap.put(node.right, node);
                leftMap.put(node.left, node);
            }
            //+1数量
            node.count++;
        }

        /**
         * 计算
         */

        //是否有单独的
        boolean single = false;
        //结果
        int result = 0;
        //循环
        for (Node rightNode : rightMap.values()) {
            //如果 没有了
            if (rightNode.count < 1) {
                //本轮过
                continue;
            }
            //获取另一面
            Node leftNode = leftMap.get(rightNode.right);
            //如果 为空 or 没有了
            if (leftNode == null || leftNode.count < 1) {
                //本轮过
                continue;
            }
            //如果不是同一个,视为回文
            if (leftNode != rightNode) {
                //最多允许使用次数
                int used = Math.min(leftNode.count, rightNode.count);
                //使用
                leftNode.count -= used;
                rightNode.count -= used;
                //记录结果
                result += 4 * used;
            } else {
                //最多允许使用次数
                int used = leftNode.count / 2;
                //使用
                leftNode.count -= used * 2;
                //记录结果
                result = result + 4 * used;
                //如果还有单独的
                if (leftNode.count > 0) {
                    //记录之
                    single = true;
                }
            }
        }
        //如果有单独的
        if (single) {
            //单独用一个
            result += 2;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code19().longestPalindrome(new String[]{"dd", "aa", "bb", "dd", "aa", "dd", "bb", "dd", "aa", "cc", "bb", "cc", "dd", "cc"}));
    }

}
