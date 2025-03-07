package easy26;

/**
 * @Author ayl
 * @Date 2022-12-16
 * 504. 七进制数
 * 给定一个整数 num，将其转化为 7 进制，并以字符串形式输出。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num = 100
 * 输出: "202"
 * 示例 2:
 * <p>
 * 输入: num = -7
 * 输出: "-10"
 * <p>
 * <p>
 * 提示：
 * <p>
 * -107 <= num <= 107
 */
public class Code3 {


    public String convertToBase7(int num) {
        //如果是正数
        if (num >= 0) {
            //实现
            return Integer.toUnsignedString(num, 7);
        } else {
            //实现并返回
            return "-" + Integer.toUnsignedString(Math.abs(num), 7);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code3().convertToBase7(0));
    }
}
