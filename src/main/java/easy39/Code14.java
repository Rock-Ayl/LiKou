package easy39;

/**
 * @Author ayl
 * @Date 2025-01-15
 * 整数转换。编写一个函数，确定需要改变几个位才能将整数A转成整数B。
 * <p>
 * 示例1:
 * <p>
 * 输入：A = 29 （或者0b11101）, B = 15（或者0b01111）
 * 输出：2
 * 示例2:
 * <p>
 * 输入：A = 1，B = 2
 * 输出：2
 * 提示:
 * <p>
 * A，B范围在[-2147483648, 2147483647]之间
 */
public class Code14 {

    public int convertInteger(int A, int B) {
        //异或、然后求1的数量
        return Integer.bitCount(A ^ B);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().convertInteger(29, 15));
    }

}
