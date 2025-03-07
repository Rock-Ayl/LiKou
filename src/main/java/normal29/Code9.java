package normal29;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2024-02-24
 * 937. 重新排列日志文件
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个日志数组 logs。每条日志都是以空格分隔的字串，其第一个字为字母与数字混合的 标识符 。
 * <p>
 * 有两种不同类型的日志：
 * <p>
 * 字母日志：除标识符之外，所有字均由小写字母组成
 * 数字日志：除标识符之外，所有字均由数字组成
 * 请按下述规则将日志重新排序：
 * <p>
 * 所有 字母日志 都排在 数字日志 之前。
 * 字母日志 在内容不同时，忽略标识符后，按内容字母顺序排序；在内容相同时，按标识符排序。
 * 数字日志 应该保留原来的相对顺序。
 * 返回日志的最终顺序。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * 输出：["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * 解释：
 * 字母日志的内容都不同，所以顺序为 "art can", "art zero", "own kit dig" 。
 * 数字日志保留原来的相对顺序 "dig1 8 1 5 1", "dig2 3 6" 。
 * 示例 2：
 * <p>
 * 输入：logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * 输出：["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] 中，字与字之间都用 单个 空格分隔
 * 题目数据保证 logs[i] 都有一个标识符，并且在标识符之后至少存在一个字
 */
public class Code9 {

    //日志节点
    private class Node {

        //日志源
        private String log;
        //日志类型
        private Integer type;
        //日志标识符
        private String key;
        //日志内容
        private String value;

        /**
         * 初始化方法
         *
         * @param log
         */
        public Node(String log) {
            //根据空格拆分日志为数组
            String[] logArr = log.split(" ");
            //拆分出第一个字符,尝试转为数字
            int typeNumber = logArr[1].charAt(0) - '0';
            //初始化对应内容
            this.log = log;
            this.type = typeNumber >= 0 && typeNumber <= 9 ? 1 : 0;
            this.key = logArr[0];
            this.value = log.substring(this.key.length());
        }

        /**
         * 自定义节点之前的排序规则
         *
         * @param anotherNode 传入另一个节点
         * @return
         */
        public int compareTo(Node anotherNode) {
            //如果类型不同
            if (this.type.equals(anotherNode.type) == false) {
                //按照类型去排序
                return this.type - anotherNode.type;
            }
            //如果二者是数字
            if (this.type == 1) {
                //按照原有顺序排序
                return 0;
            }
            //如果二者是 字母 and 根据内容相同决定如何判断
            if (this.value.equals(anotherNode.value)) {
                //用标识符排序
                return this.key.compareTo(anotherNode.key);
            } else {
                //按照内容排列
                return this.value.compareTo(anotherNode.value);
            }
        }

    }

    public String[] reorderLogFiles(String[] logs) {
        //实现
        return Arrays
                //流
                .stream(logs)
                //日志转节点
                .map(Node::new)
                //按照节点的规则排序
                .sorted(Node::compareTo)
                //拆箱为原日志
                .map(p -> p.log)
                //转回数组
                .toArray(String[]::new);
    }

    public static void main(String[] args) {
        String[] strings = new Code9().reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"});
        System.out.println();
    }

}
