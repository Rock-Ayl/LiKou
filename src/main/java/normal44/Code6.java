package normal44;

/**
 * @Author ayl
 * @Date 2025-06-23
 * 537. 复数乘法
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 复数 可以用字符串表示，遵循 "实部+虚部i" 的形式，并满足下述条件：
 * <p>
 * 实部 是一个整数，取值范围是 [-100, 100]
 * 虚部 也是一个整数，取值范围是 [-100, 100]
 * i2 == -1
 * 给你两个字符串表示的复数 num1 和 num2 ，请你遵循复数表示形式，返回表示它们乘积的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num1 = "1+1i", num2 = "1+1i"
 * 输出："0+2i"
 * 解释：(1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i ，你需要将它转换为 0+2i 的形式。
 * 示例 2：
 * <p>
 * 输入：num1 = "1+-1i", num2 = "1+-1i"
 * 输出："0+-2i"
 * 解释：(1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i ，你需要将它转换为 0+-2i 的形式。
 * <p>
 * <p>
 * 提示：
 * <p>
 * num1 和 num2 都是有效的复数表示。
 */
public class Code6 {

    //节点
    private static class Node {

        //数字
        private int num;

        //i的数量
        private int i;

        //初始化
        public Node(String num) {
            //拆分
            String[] arr = num.split("\\+");
            //转为数字
            this.num = Integer.valueOf(arr[0]);
            //拆除i,转为数字
            this.i = Integer.valueOf(arr[1].substring(0, arr[1].length() - 1));
        }

        //初始化2
        public Node(int num, int i) {
            this.num = num;
            this.i = i;
        }

        //重新转为str
        @Override
        public String toString() {
            return String.format("%s+%si", this.num, this.i);
        }

    }

    public String complexNumberMultiply(String num1, String num2) {
        //初始化为节点
        Node node1 = new Node(num1);
        Node node2 = new Node(num2);
        //分别计算
        int first = node1.num * node2.num;
        int second = node1.i * node2.num;
        int third = node1.num * node2.i;
        int four = node1.i * node2.i;
        //特殊情况:如果 相同 and 不为0
        if (node1.i != 0 && node1.i == node2.i) {
            //-1
            four = 1;
        }
        //转为新节点
        Node node = new Node(first - four, second + third);
        //实现
        return node.toString();
    }

    public static void main(String[] args) {

        //输出:-6709+12152i
        //预期结果 :-1236+12152i

        //System.out.println(new Code6().complexNumberMultiply("1+-1i", "1+-1i"));
        System.out.println(new Code6().complexNumberMultiply("78+-76i", "-86+72i"));
    }

}
