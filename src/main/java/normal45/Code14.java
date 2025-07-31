package normal45;

import java.util.PriorityQueue;

/**
 * @Author ayl
 * @Date 2025-07-31
 * 3081. 替换字符串中的问号使分数最小
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 。s[i] 要么是小写英文字母，要么是问号 '?' 。
 * <p>
 * 对于长度为 m 且 只 含有小写英文字母的字符串 t ，我们定义函数 cost(i) 为下标 i 之前（也就是范围 [0, i - 1] 中）出现过与 t[i] 相同 字符出现的次数。
 * <p>
 * 字符串 t 的 分数 为所有下标 i 的 cost(i) 之 和 。
 * <p>
 * 比方说，字符串 t = "aab" ：
 * <p>
 * cost(0) = 0
 * cost(1) = 1
 * cost(2) = 0
 * 所以，字符串 "aab" 的分数为 0 + 1 + 0 = 1 。
 * 你的任务是用小写英文字母 替换 s 中 所有 问号，使 s 的 分数最小 。
 * <p>
 * 请你返回替换所有问号 '?' 之后且分数最小的字符串。如果有多个字符串的 分数最小 ，那么返回字典序最小的一个。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "???"
 * <p>
 * 输出： "abc"
 * <p>
 * 解释：这个例子中，我们将 s 中的问号 '?' 替换得到 "abc" 。
 * <p>
 * 对于字符串 "abc" ，cost(0) = 0 ，cost(1) = 0 和 cost(2) = 0 。
 * <p>
 * "abc" 的分数为 0 。
 * <p>
 * 其他修改 s 得到分数 0 的字符串为 "cba" ，"abz" 和 "hey" 。
 * <p>
 * 这些字符串中，我们返回字典序最小的。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "a?a?"
 * <p>
 * 输出： "abac"
 * <p>
 * 解释：这个例子中，我们将 s 中的问号 '?' 替换得到 "abac" 。
 * <p>
 * 对于字符串 "abac" ，cost(0) = 0 ，cost(1) = 0 ，cost(2) = 1 和 cost(3) = 0 。
 * <p>
 * "abac" 的分数为 1 。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 要么是小写英文字母，要么是 '?' 。
 */
public class Code14 {

    private static class Node {

        //字符
        private char letter;

        //计数器
        private int count = 0;

        //非?的计数器
        private int startCount = 0;

        //初始化
        public Node(char letter) {
            this.letter = letter;
        }

        //方便调试
        @Override
        public String toString() {
            return String.format("letter=%s,count=%s", this.letter, this.count);
        }

    }

    public String minimizeStringValue(String s) {

        /**
         * 构建节点、统计
         */

        //问号计数器
        int askCount = 0;
        //计数器
        Node[] arr = new Node[26];
        //循环
        for (int i = 0; i < arr.length; i++) {
            //初始化
            arr[i] = new Node((char) (i + 'a'));
        }
        //循环
        for (char letter : s.toCharArray()) {
            //如果是?
            if (letter == '?') {
                //+1
                askCount++;
                //本轮过
                continue;
            }
            //索引
            int index = letter - 'a';
            //+1
            arr[index].count++;
            arr[index].startCount++;
        }

        /**
         * 消耗?
         */

        //优先队列,按照题意,先出count小的,再出排序小的
        PriorityQueue<Node> queue = new PriorityQueue<>((a, b) -> a.count != b.count ? a.count - b.count : a.letter - b.letter);
        //循环
        for (Node node : arr) {
            //加入队列
            queue.add(node);
        }
        //循环
        while (askCount > 0) {
            //拉取优先级最高的
            Node first = queue.poll();
            //偷窥第二
            Node second = queue.peek();
            //可以增加的
            int other = second.count - first.count;
            //如果没有
            if (other == 0) {
                //+1
                other++;
            }
            //判断是否可以足够消耗
            if (other <= askCount) {
                //消耗
                askCount -= other;
                first.count += other;
            } else {
                //消耗
                first.count += askCount;
                askCount = 0;
            }
            //重新加入
            queue.add(first);
        }

        /**
         * 构建新字符串
         */

        //索引
        int index = 0;
        //初始化结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //如果是?
            if (s.charAt(i) == '?') {
                //如果不够
                while ((arr[index].count - arr[index].startCount) == 0) {
                    //+1
                    index++;
                }
                //使用
                str.append(arr[index].letter);
                arr[index].count--;
            } else {
                //直接组装
                str.append(s.charAt(i));
            }
        }
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code14().minimizeStringValue("???"));
    }

}
