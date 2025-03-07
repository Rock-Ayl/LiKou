package easy23;

/**
 * @Author ayl
 * @Date 2022-10-12
 * 868. 二进制间距
 * 给定一个正整数 n，找到并返回 n 的二进制表示中两个 相邻 1 之间的 最长距离 。如果不存在两个相邻的 1，返回 0 。
 * <p>
 * 如果只有 0 将两个 1 分隔开（可能不存在 0 ），则认为这两个 1 彼此 相邻 。两个 1 之间的距离是它们的二进制表示中位置的绝对差。例如，"1001" 中的两个 1 的距离为 3 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 22
 * 输出：2
 * 解释：22 的二进制是 "10110" 。
 * 在 22 的二进制表示中，有三个 1，组成两对相邻的 1 。
 * 第一对相邻的 1 中，两个 1 之间的距离为 2 。
 * 第二对相邻的 1 中，两个 1 之间的距离为 1 。
 * 答案取两个距离之中最大的，也就是 2 。
 * 示例 2：
 * <p>
 * 输入：n = 8
 * 输出：0
 * 解释：8 的二进制是 "1000" 。
 * 在 8 的二进制表示中没有相邻的两个 1，所以返回 0 。
 * 示例 3：
 * <p>
 * 输入：n = 5
 * 输出：2
 * 解释：5 的二进制是 "101" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code23 {

    public int binaryGap(int n) {
        //转化为二进制数
        String numberStr = Integer.toBinaryString(n);
        //转化为数组
        char[] arr = numberStr.toCharArray();
        //指针
        int p = -1;
        //循环,找到第一个1
        while (++p < arr.length && arr[p] == '1') {
            //跳出
            break;
        }
        //如果找到头了,哪怕最后一个是1,也不存在结果
        if (p == arr.length - 1) {
            //不存在
            return 0;
        }
        //初始化结果
        int max = 0;
        //上一个1
        int lastP = p;
        //循环
        for (int i = lastP + 1; i < arr.length; i++) {
            //如果当前是
            if (arr[i] == '1') {
                //刷新最大距离
                max = Math.max(max, i - lastP);
                //记录新距离
                lastP = i;
            }
        }
        //返回
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code23().binaryGap(5));
    }

}
