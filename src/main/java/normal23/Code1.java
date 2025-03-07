package normal23;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author ayl
 * @Date 2023-08-10
 * LCR 065. 单词的压缩编码
 * 中等
 * 47
 * 相关企业
 * 单词数组 words 的 有效编码 由任意助记字符串 s 和下标数组 indices 组成，且满足：
 * <p>
 * words.length == indices.length
 * 助记字符串 s 以 '#' 字符结尾
 * 对于每个下标 indices[i] ，s 的一个从 indices[i] 开始、到下一个 '#' 字符结束（但不包括 '#'）的 子字符串 恰好与 words[i] 相等
 * 给定一个单词数组 words ，返回成功对 words 进行编码的最小助记字符串 s 的长度 。
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
 * <p>
 * <p>
 * 注意：本题与主站 820 题相同： https://leetcode-cn.com/problems/short-encoding-of-words/
 */
public class Code1 {

    //字典树节点
    public static class Node {

        //子级map
        private Map<Character, Node> childMap = new HashMap<>();

    }

    //主节点
    private Node rootNode;

    //结果
    private int count;

    //插入新单词
    private void insert(String word) {
        //当前节点
        Node node = this.rootNode;
        //循环
        for (int i = word.length() - 1; i >= 0; i--) {
            //当前字符
            Character space = word.charAt(i);
            //如果不存在
            if (node.childMap.containsKey(space) == false) {
                //初始化
                node.childMap.put(space, new Node());
            }
            //下一个
            node = node.childMap.get(space);
        }
    }

    //统计当前单词压缩长度
    private void next(Node node, int deep) {
        //如果没有了
        if (node.childMap.size() == 0) {
            //记录节点
            count += deep + 1;
            //过
            return;
        }
        //循环
        for (Node value : node.childMap.values()) {
            //递归子节点
            next(value, deep + 1);
        }
    }

    public int minimumLengthEncoding(String[] words) {
        //初始化
        this.rootNode = new Node();
        this.count = 0;
        //循环
        for (String word : words) {
            //插入
            insert(word);
        }
        //统计结果
        next(this.rootNode, 0);
        //统计并返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minimumLengthEncoding(new String[]{"time", "me", "bell"}));
    }

}
