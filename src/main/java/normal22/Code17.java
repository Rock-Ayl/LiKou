package normal22;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2023-08-03
 * 1209. 删除字符串中的所有相邻重复项 II
 * 给你一个字符串 s，「k 倍重复项删除操作」将会从 s 中选择 k 个相邻且相等的字母，并删除它们，使被删去的字符串的左侧和右侧连在一起。
 * <p>
 * 你需要对 s 重复进行无限次这样的删除操作，直到无法继续为止。
 * <p>
 * 在执行完所有删除操作后，返回最终得到的字符串。
 * <p>
 * 本题答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abcd", k = 2
 * 输出："abcd"
 * 解释：没有要删除的内容。
 * 示例 2：
 * <p>
 * 输入：s = "deeedbbcccbdaa", k = 3
 * 输出："aa"
 * 解释：
 * 先删除 "eee" 和 "ccc"，得到 "ddbbbdaa"
 * 再删除 "bbb"，得到 "dddaa"
 * 最后删除 "ddd"，得到 "aa"
 * 示例 3：
 * <p>
 * 输入：s = "pbbcggttciiippooaais", k = 2
 * 输出："ps"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 10^5
 * 2 <= k <= 10^4
 * s 中只含有小写英文字母。
 */
public class Code17 {

    //节点实体
    public static class Node {

        //该字符连击数量
        public Integer count;

        //字符
        private Character space;

        public Node(Character space) {
            this.space = space;
            this.count = 1;
        }

    }

    public String removeDuplicates(String s, int k) {
        //栈
        Stack<Node> stack = new Stack<>();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前
            char c = s.charAt(i);
            //如果为空 or 与前一个字符不同
            if (stack.isEmpty() || stack.peek().space.equals(c) == false) {
                //初始化一个新的节点
                stack.push(new Node(c));
                //本轮过
                continue;
            }
            //记录数量,并判断是否满足目标,如果满足,删除节点
            if (++stack.peek().count == k) {
                //删除
                stack.pop();
            }
        }
        //初始化结果
        StringBuilder str = new StringBuilder();
        //循环
        for (Node node : stack) {
            //当前数量
            int count = node.count;
            //如果有
            while (count-- > 0) {
                //组装
                str.append(node.space);
            }
        }
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code17().removeDuplicates("deeedbbcccbdaa", 3));
    }

}
