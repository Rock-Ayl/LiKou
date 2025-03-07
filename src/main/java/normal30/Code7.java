package normal30;

/**
 * @Author ayl
 * @Date 2024-03-28
 * 2526. 找到数据流中的连续整数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个整数数据流，请你实现一个数据结构，检查数据流中最后 k 个整数是否 等于 给定值 value 。
 * <p>
 * 请你实现 DataStream 类：
 * <p>
 * DataStream(int value, int k) 用两个整数 value 和 k 初始化一个空的整数数据流。
 * boolean consec(int num) 将 num 添加到整数数据流。如果后 k 个整数都等于 value ，返回 true ，否则返回 false 。如果少于 k 个整数，条件不满足，所以也返回 false 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["DataStream", "consec", "consec", "consec", "consec"]
 * [[4, 3], [4], [4], [4], [3]]
 * 输出：
 * [null, false, false, true, false]
 * <p>
 * 解释：
 * DataStream dataStream = new DataStream(4, 3); // value = 4, k = 3
 * dataStream.consec(4); // 数据流中只有 1 个整数，所以返回 False 。
 * dataStream.consec(4); // 数据流中只有 2 个整数
 * // 由于 2 小于 k ，返回 False 。
 * dataStream.consec(4); // 数据流最后 3 个整数都等于 value， 所以返回 True 。
 * dataStream.consec(3); // 最后 k 个整数分别是 [4,4,3] 。
 * // 由于 3 不等于 value ，返回 False 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= value, num <= 109
 * 1 <= k <= 105
 * 至多调用 consec 次数为 105 次。
 */
public class Code7 {

    private static class Node {

        //值
        private int value;

        //数量
        private int count;

        //初始化
        public Node(int value, int count) {
            this.value = value;
            this.count = count;
        }

    }

    //最后一个节点
    private Node lastNode;
    //目标值
    private int value;
    //目标数量
    private int k;

    //初始化
    public Code7(int value, int k) {
        this.value = value;
        this.k = k;
        this.lastNode = new Node(value, 0);
    }

    public boolean consec(int num) {
        //如果是相同数字
        if (this.lastNode.value == num) {
            //+1
            this.lastNode.count++;
        } else {
            //初始化新的
            this.lastNode = new Node(num, 1);
        }
        //返回结果
        return this.lastNode.value == value && this.lastNode.count >= k;
    }

    public static void main(String[] args) {
        Code7 code7 = new Code7(4, 3);
        System.out.println(code7.consec(4));
        System.out.println(code7.consec(4));
        System.out.println(code7.consec(4));
        System.out.println(code7.consec(3));
    }

}
