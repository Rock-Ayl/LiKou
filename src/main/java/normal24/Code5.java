package normal24;

/**
 * @Author ayl
 * @Date 2023-09-16
 * 43. 字符串相乘
 * 中等
 * 1.3K
 * 相关企业
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 注意：不能使用任何内置的 BigInteger 库或直接将输入转换为整数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * num1 和 num2 只能由数字组成。
 * num1 和 num2 都不包含任何前导零，除了数字0本身。
 */
public class Code5 {

    //叠加和
    public String add(String num1Str, String num2Str) {
        //结果
        StringBuilder str = new StringBuilder();
        //指针
        int p1 = num1Str.length() - 1;
        int p2 = num2Str.length() - 1;
        //进位
        int other = 0;
        //循环
        while (p1 >= 0 || p2 >= 0) {
            //当前数字
            int num1;
            //如果未越界
            if (p1 >= 0) {
                //获取
                num1 = num1Str.charAt(p1--) - '0';
            } else {
                //默认
                num1 = 0;
            }
            int num2;
            //如果未越界
            if (p2 >= 0) {
                //获取
                num2 = num2Str.charAt(p2--) - '0';
            } else {
                //默认
                num2 = 0;
            }
            //和
            int sum = num1 + num2 + other;
            //重置进位
            other = 0;
            //如果有进位
            while (sum > 9) {
                //进位
                other++;
                sum -= 10;
            }
            //叠加个位的数字
            str.append(sum);
        }
        //如果最后有进位
        if (other > 0) {
            //记录
            str.append(other);
        }
        //返回结果
        return str.reverse().toString();
    }

    public String multiply(String num1, int letter, int count) {
        //解雇
        String result = "0";
        //循环
        while (letter-- > 0) {
            //叠加
            result = add(result, num1);
        }
        //循环
        while (count-- > 0) {
            //叠加0
            result = result + "0";
        }
        //返回
        return result;
    }

    public String multiply(String num1, String num2) {
        //如果有0
        if (num1.equals("0") || num2.equals("0")) {
            //默认
            return "0";
        }
        //进位
        int count = 0;
        //本次结果
        String result = "0";
        //循环
        for (int i = num2.length() - 1; i >= 0; i--) {
            //当前字符
            int letter = num2.charAt(i) - '0';
            //先乘再叠加
            result = add(result, multiply(num1, letter, count++));
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().multiply("0", "52"));
    }

}
