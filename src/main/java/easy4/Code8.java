package easy4;

/**
 * Created By Rock-Ayl on 2020-12-10
 * 415. 字符串相加
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * <p>
 * 提示：
 * <p>
 * num1 和num2 的长度都小于 5100
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 * 你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式
 */
public class Code8 {

    public static String addStrings(String num1, String num2) {
        //初始化返回值
        StringBuffer num = new StringBuffer();
        //1数起始位置
        int ap = num1.length() - 1;
        //2数起始位置
        int bp = num2.length() - 1;
        //转化为char[]
        char[] a = num1.toCharArray();
        char[] b = num2.toCharArray();
        //
        int lastNum = 0;
        //循环
        while (ap >= 0 || bp >= 0) {
            //当前位置总和
            int thisSum = 0;
            //如果还可以取1
            if (ap >= 0) {
                //叠加
                thisSum += a[ap] - '0';
            }
            //如果还可以取2
            if (bp >= 0) {
                //叠加
                thisSum += b[bp] - '0';
            }
            //如果有进位
            if (lastNum > 0) {
                //叠加
                thisSum += lastNum;
            }
            //如果没有达到进位
            if (thisSum < 10) {
                //记录
                num.append(thisSum);
                //重置进位
                lastNum = 0;
            } else {
                //记录
                num.append(thisSum % 10);
                //记录进位
                lastNum = (thisSum / 10);
            }
            //递减
            ap--;
            bp--;
        }
        //如果还有进位
        if (lastNum > 0) {
            //记录
            num.append(lastNum);
        }
        //翻转并返回
        return num.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
    }
}
