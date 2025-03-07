package easy4;

/**
 * Created By Rock-Ayl on 2020-12-08
 * 67. 二进制求和
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 */
public class Code6 {

    public static String addBinary(String a, String b) {
        //两个数的位置
        int ap = a.length() - 1;
        int bp = b.length() - 1;
        //上一级进位
        int lastNum = 0;
        //返回结果
        StringBuffer num = new StringBuffer();
        //循环
        for (int i = 0; i < Math.max(a.length(), b.length()); i++) {
            //当前
            int thisSum = 0;
            //如果还有a
            if (ap >= 0) {
                switch (a.charAt(ap)) {
                    case '0':
                        break;
                    case '1':
                        //叠加
                        thisSum += 1;
                        break;
                }
            }
            //如果还有b
            if (bp >= 0) {
                switch (b.charAt(bp)) {
                    case '0':
                        break;
                    case '1':
                        //叠加
                        thisSum += 1;
                        break;
                }
            }
            //如果上一层进了
            if (lastNum == 1) {
                //叠加
                thisSum += lastNum;
            }
            //判断
            switch (thisSum) {
                case 0:
                    num.append(0);
                    lastNum = 0;
                    break;
                case 1:
                    num.append(1);
                    lastNum = 0;
                    break;
                case 2:
                    num.append(0);
                    lastNum = 1;
                    break;
                case 3:
                    num.append(1);
                    lastNum = 1;
                    break;
            }
            ap--;
            bp--;
            //如果是最终了
            if (ap < 0 && bp < 0) {
                //如果最终还进了一位
                if (lastNum == 1) {
                    //记录
                    num.append(1);
                }
            }
        }
        //翻转并返回
        return num.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addBinary("1010", "1011"));
    }
}
