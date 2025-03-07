package easy3;

import java.util.Collections;

/**
 * Created By Rock-Ayl on 2020-10-24
 * 1556. 千位分隔数
 * 给你一个整数 n，请你每隔三位添加点（即 "." 符号）作为千位分隔符，并将结果以字符串格式返回。
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 987
 * 输出："987"
 * 示例 2：
 * <p>
 * 输入：n = 1234
 * 输出："1.234"
 * 示例 3：
 * <p>
 * 输入：n = 123456789
 * 输出："123.456.789"
 * 示例 4：
 * <p>
 * 输入：n = 0
 * 输出："0"
 */
public class Code4 {

    public static String thousandSeparator(int n) {
        //转为string
        String s = (n + "");
        //初始化返回结果
        StringBuffer result = new StringBuffer();
        //记录位置
        int num = 1;
        //循环
        for (int i = s.length() - 1; i >= 0; i--) {
            //叠加
            result.append(s.charAt(i));
            //如果到了地方并且不是最后一位
            if (num % 3 == 0 && i != 0) {
                //加个点
                result.append(".");
            }
            //叠加
            num++;
        }
        //翻转并返回
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(thousandSeparator(123456789));
    }
}
