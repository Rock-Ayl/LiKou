package easy2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-09-20
 * 1309. 解码字母到整数映射
 * 给你一个字符串 s，它由数字（'0' - '9'）和 '#' 组成。我们希望按下述规则将 s 映射为一些小写英文字符：
 * <p>
 * 字符（'a' - 'i'）分别用（'1' - '9'）表示。
 * 字符（'j' - 'z'）分别用（'10#' - '26#'）表示。
 * 返回映射之后形成的新字符串。
 * <p>
 * 题目数据保证映射始终唯一。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "10#11#12"
 * 输出："jkab"
 * 解释："j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * 示例 2：
 * <p>
 * 输入：s = "1326#"
 * 输出："acz"
 * 示例 3：
 * <p>
 * 输入：s = "25#"
 * 输出："y"
 * 示例 4：
 * <p>
 * 输入：s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * 输出："abcdefghijklmnopqrstuvwxyz"
 */
public class code2 {

    public static String freqAlphabets(String s) {
        //长度
        int size = s.length();
        //拆分
        char[] charArr = s.toCharArray();
        //记录转化后的s
        StringBuffer result = new StringBuffer();
        //循环
        for (int i = size - 1; i >= 0; i--) {
            //当前char
            char thisChar = charArr[i];
            //转化为string
            String thisValue = thisChar + "";
            //如果是大于10的
            if ("#".equals(thisValue)) {
                //获取#的编码
                String coding = (charArr[i - 2] + "") + (charArr[i - 1] + "");
                //解码
                String decode = (char) (byte) (Integer.parseInt((coding)) + 48 + 48) + "";
                //组装
                result.append(decode);
                //额外快速减少俩位置
                i = i - 2;
            } else {
                //解码
                String decode = (char) (byte) (Integer.parseInt((byte) thisChar + "") + 48) + "";
                //组装
                result.append(decode);
            }
        }
        //翻转下
        result = result.reverse();
        //返回
        return result.toString();
    }

    // 1=49 a=97
    public static void main(String[] args) {
        System.out.println(freqAlphabets("26#"));
    }
}
