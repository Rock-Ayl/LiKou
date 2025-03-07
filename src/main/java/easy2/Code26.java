package easy2;

/**
 * Created By Rock-Ayl on 2020-10-15
 * 1317. 将整数转换为两个无零整数的和
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * <p>
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [A, B]，满足：
 * <p>
 * A 和 B 都是无零整数
 * A + B = n
 * 题目数据保证至少有一个有效的解决方案。
 * <p>
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：A = 1, B = 1. A + B = n 并且 A 和 B 的十进制表示形式都不包含任何 0 。
 * 示例 2：
 * <p>
 * 输入：n = 11
 * 输出：[2,9]
 * 示例 3：
 * <p>
 * 输入：n = 10000
 * 输出：[1,9999]
 * 示例 4：
 * <p>
 * 输入：n = 69
 * 输出：[1,68]
 * 示例 5：
 * <p>
 * 输入：n = 1010
 * 输出：[11,999]
 */
public class Code26 {

    public static int[] getNoZeroIntegers(int n) {
        //初始化返回值
        int[] x = new int[2];
        //1
        int a = 1;
        //b
        int b = n - a;
        //转化
        String as = a + "";
        //转化
        String bs = b + "";
        //判断
        while (as.contains("0") || bs.contains("0")) {
            //递增
            a++;
            //递减
            b--;
            //赋值
            as = a + "";
            bs = b + "";
        }
        //赋值
        x[0] = a;
        x[1] = b;
        //返回
        return x;
    }

    public static void main(String[] args) {
        for (int noZeroInteger : getNoZeroIntegers(5)) {
            System.out.println(noZeroInteger);
        }
    }
}
