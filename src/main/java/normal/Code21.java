package normal;

/**
 * Created By Rock-Ayl on 2021-03-27
 * 剑指 Offer 67. 把字符串转换成整数
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 * <p>
 * <p>
 * <p>
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 * <p>
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 * <p>
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 * <p>
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 * <p>
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * <p>
 * 说明：
 * <p>
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 * <p>
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 * 我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 * <p>
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 * <p>
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 * 因此无法执行有效的转换。
 * 示例 5:
 * <p>
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 * 因此返回 INT_MIN (−231) 。
 * <p>
 * <p>
 * 注意：本题与主站 8 题相同：https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class Code21 {

    public static int execute(String str, int p) {
        //如果越界了
        if (p == str.length()) {
            //返回
            return 0;
        }
        //第p个字符
        char thisChar = str.charAt(p);
        //初始化
        StringBuffer numStr = new StringBuffer();
        //是正数
        boolean isJust = true;
        //根据字符类型操作
        switch (thisChar) {
            case '-':
                //改为负数
                isJust = false;
            case '+':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                //组装
                numStr.append(thisChar);
                //循环
                for (int i = p + 1; i < str.length(); i++) {
                    //当前字符
                    char x = str.charAt(i);
                    //如果不是数字
                    if (x == '-' || x == '+') {
                        //结束
                        break;
                    } else {
                        //转为数字
                        int thisNum = x - '0';
                        //如果是数字
                        if (thisNum >= 0 && thisNum < 10) {
                            //组装
                            numStr.append(x);
                        } else {
                            //结束
                            break;
                        }
                    }
                }
                break;
            case ' ':
                //下一个
                return execute(str, p + 1);
            default:
                //结束
                return 0;
        }
        try {
            //返回结果
            return Integer.parseInt(numStr.toString());
        } catch (Exception e) {
            //如果是单个符号
            if (numStr.length() == 1) {
                //默认
                return 0;
            }
            //如果是正数
            if (isJust) {
                //结束
                return Integer.MAX_VALUE;
            } else {
                //结束
                return Integer.MIN_VALUE;
            }
        }
    }

    public static int strToInt(String str) {
        //从0开始
        return execute(str, 0);
    }

    public static void main(String[] args) {
        System.out.println(strToInt(" -91283472332"));
    }
}
