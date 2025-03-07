package easy;

/**
 * Created By Rock-Ayl on 2020-09-04
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * <p>
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class Code27 {

    //这题不用大数毫无意义.....
    public static int[] printNumbers(int n) {
        //初始化最大数
        int max = 1;
        //首先累加一位
        n++;
        //循环
        while (n > 1) {
            //进一位
            max = max * 10;
            //递减
            n--;
        }
        //初始化List
        int[] num = new int[max - 1];
        //循环
        for (int i = 1; i < max; i++) {
            //记录
            num[i - 1] = i;
        }
        //返回
        return num;
    }

    public static void main(String[] args) {
        for (int i : printNumbers(2)) {
            System.out.println(i);
        }
    }

}
