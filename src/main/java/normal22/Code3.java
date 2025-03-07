package normal22;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-07-17
 * 820. 单词的压缩编码
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * <p>
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给你一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["time", "me", "bell"]
 * 输出：10
 * 解释：一组有效编码为 s = "time#bell#" 和 indices = [0, 2, 5] 。
 * words[0] = "time" ，s 开始于 indices[0] = 0 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[1] = "me" ，s 开始于 indices[1] = 2 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * words[2] = "bell" ，s 开始于 indices[2] = 5 到下一个 '#' 结束的子字符串，如加粗部分所示 "time#bell#"
 * 示例 2：
 * <p>
 * 输入：words = ["t"]
 * 输出：2
 * 解释：一组有效编码为 s = "t#" 和 indices = [0] 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * words[i] 仅由小写字母组成
 */
public class Code3 {

    //节点实体
    private static class Node {

        //下一层结构
        private Map<Character, Node> children;

        //初始化节点
        public Node() {
            this.children = new HashMap<>();
        }

    }

    //为节点加入单词
    private void insertNode(String word) {
        //获取当前节点
        Node node = this.rootNode;
        //循环
        for (int i = word.length() - 1; i >= 0; i--) {
            //当前字母
            char letter = word.charAt(i);
            //如果不存在
            if (node.children.containsKey(letter) == false) {
                //初始化并组装
                node.children.put(letter, new Node());
            }
            //下一个
            node = node.children.get(letter);
        }
    }

    //统计节点数
    private void next(Node node, int lastDeep) {
        //判空
        if (node == null) {
            //过
            return;
        }
        //计算当前深度
        int thisDeep = lastDeep + 1;
        //如果该节点下没有子结构
        if (node.children.isEmpty()) {
            //叠加该节点结果
            this.result += thisDeep;
            //过
            return;
        }
        //循环
        for (Node nextNode : node.children.values()) {
            //递归实现
            next(nextNode, thisDeep);
        }
    }

    //主节点
    private Node rootNode;

    //结果
    private Integer result;

    public int minimumLengthEncoding(String[] words) {
        //初始化主节点
        this.rootNode = new Node();
        //默认结果
        this.result = 0;
        //循环
        for (String word : words) {
            //插入至节点
            insertNode(word);
        }
        //统计结果,从0开始
        next(this.rootNode, 0);
        //返回结果o
        return this.result;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().minimumLengthEncoding(new String[]{"time", "atime", "btime"}));
    }

}
