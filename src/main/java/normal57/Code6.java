package normal57;

import java.util.Arrays;

/**
 * 1387. 将整数按权重排序
 * 算术评级: 6
 * 第 22 场双周赛
 * Q3
 * 同步题目状态
 * <p>
 * 1507
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 我们将整数 x 的 权重 定义为按照下述规则将 x 变成 1 所需要的步数：
 * <p>
 * 如果 x 是偶数，那么 x = x / 2
 * 如果 x 是奇数，那么 x = 3 * x + 1
 * 比方说，x=3 的权重为 7 。因为 3 需要 7 步变成 1 （3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）。
 * <p>
 * 给你三个整数 lo， hi 和 k 。你的任务是将区间 [lo, hi] 之间的整数按照它们的权重 升序排序 ，如果大于等于 2 个整数有 相同 的权重，那么按照数字自身的数值 升序排序 。
 * <p>
 * 请你返回区间 [lo, hi] 之间的整数按权重排序后的第 k 个数。
 * <p>
 * 注意，题目保证对于任意整数 x （lo <= x <= hi） ，它变成 1 所需要的步数是一个 32 位有符号整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：lo = 12, hi = 15, k = 2
 * 输出：13
 * 解释：12 的权重为 9（12 --> 6 --> 3 --> 10 --> 5 --> 16 --> 8 --> 4 --> 2 --> 1）
 * 13 的权重为 9
 * 14 的权重为 17
 * 15 的权重为 17
 * 区间内的数按权重排序以后的结果为 [12,13,14,15] 。对于 k = 2 ，答案是第二个整数也就是 13 。
 * 注意，12 和 13 有相同的权重，所以我们按照它们本身升序排序。14 和 15 同理。
 * 示例 2：
 * <p>
 * 输入：lo = 7, hi = 11, k = 4
 * 输出：7
 * 解释：区间内整数 [7, 8, 9, 10, 11] 对应的权重为 [16, 3, 19, 6, 14] 。
 * 按权重排序后得到的结果为 [8, 10, 11, 7, 9] 。
 * 排序后数组中第 4 个数字为 7 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= lo <= hi <= 1000
 * 1 <= k <= hi - lo + 1
 *
 */
public class Code6 {

    private static class Node {

        //数字
        private int val;
        //权重
        private int weight;

        //初始化
        public Node(int val, int weight) {
            this.val = val;
            this.weight = weight;
        }

        //排序
        public int compareTo(Node o) {
            //如果权重相同
            if (this.weight == o.weight) {
                //返回数字的比较
                return this.val - o.val;
            }
            //返回权重的比较
            return this.weight - o.weight;
        }

        //方便调试
        @Override
        public String toString() {
            return "Node{" +
                    "val=" + val +
                    ", weight=" + weight +
                    '}';
        }

    }

    public int getKth(int lo, int hi, int k) {
        //节点数组
        Node[] nodeArr = new Node[hi - lo + 1];
        //索引
        int index = 0;
        //循环
        for (int i = lo; i <= hi; i++) {
            //初始化
            nodeArr[index++] = new Node(i, getWeight(i));
        }
        //排序
        Arrays.sort(nodeArr, Node::compareTo);
        //返回第k个
        return nodeArr[k - 1].val;
    }

    //获取权重
    private int getWeight(int num) {
        //权重
        int weight = 0;
        //循环
        while (num != 1) {
            //如果是偶数
            if (num % 2 == 0) {
                //除以2
                num /= 2;
            } else {
                //乘以3加1
                num = 3 * num + 1;
            }
            //+1
            weight++;
        }
        //返回
        return weight;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().getKth(7, 11, 4));
    }

}
