package easy4;

/**
 * Created By Rock-Ayl on 2020-12-01
 * 7. 整数反转
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class Code2 {

    public static int reverse(int x) {
        //初始化
        StringBuffer num = new StringBuffer();
        //转化为在
        char[] arr = (x + "").toCharArray();
        //初始位置
        int p;
        //如果是负号
        if (arr[0] == '-') {
            //记录
            num.append("-");
            //向右一位
            p = 1;
        } else {
            p = 0;
        }
        //第一个零过了
        boolean firstZero = false;
        //循环
        for (int i = arr.length - 1; i >= p; i--) {
            //当前
            char y = arr[i];
            //如果第一个零过了
            if (firstZero) {
                //组装
                num.append(y);
            } else {
                //如果是0
                if (y != 0) {
                    //过了
                    firstZero = true;
                    //组装
                    num.append(y);
                }
            }
        }
        try {
            //转化
            int result = Integer.parseInt(num.toString());
            //返回
            return result;
        } catch (Exception e) {
            //溢出返回0
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
    }
}
