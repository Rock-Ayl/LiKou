package normal36;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2024-10-15
 * 816. 模糊坐标
 * 中等
 * 相关标签
 * 相关企业
 * 我们有一些二维坐标，如 "(1, 3)" 或 "(2, 0.5)"，然后我们移除所有逗号，小数点和空格，得到一个字符串S。返回所有可能的原始字符串到一个列表中。
 * <p>
 * 原始的坐标表示法不会存在多余的零，所以不会出现类似于"00", "0.0", "0.00", "1.0", "001", "00.01"或一些其他更小的数来表示坐标。此外，一个小数点前至少存在一个数，所以也不会出现“.1”形式的数字。
 * <p>
 * 最后返回的列表可以是任意顺序的。而且注意返回的两个数字中间（逗号之后）都有一个空格。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * 输入: "(123)"
 * 输出: ["(1, 23)", "(12, 3)", "(1.2, 3)", "(1, 2.3)"]
 * 示例 2:
 * 输入: "(00011)"
 * 输出:  ["(0.001, 1)", "(0, 0.011)"]
 * 解释:
 * 0.0, 00, 0001 或 00.01 是不被允许的。
 * 示例 3:
 * 输入: "(0123)"
 * 输出: ["(0, 123)", "(0, 12.3)", "(0, 1.23)", "(0.1, 23)", "(0.1, 2.3)", "(0.12, 3)"]
 * 示例 4:
 * 输入: "(100)"
 * 输出: [(10, 0)]
 * 解释:
 * 1.0 是不被允许的。
 * <p>
 * <p>
 * 提示:
 * <p>
 * 4 <= S.length <= 12.
 * S[0] = "(", S[S.length - 1] = ")", 且字符串 S 中的其他元素都是数字。
 */
public class Code5 {

    //将一个单词,解析出N种情况
    private List<String> countWord(StringBuilder word) {
        //初始化结果列表
        List<String> result = new ArrayList<>();
        //如果只有一个
        if (word.length() == 1) {
            //直接使用
            result.add(word.toString());
            //返回
            return result;
        }
        //如果第一个是0
        if (word.charAt(0) == '0') {
            //固定插入.
            word.insert(1, '.');
            //默认就是数字
            result.add(word.toString());
            //回溯
            word.deleteCharAt(1);
            //返回
            return result;
        }
        //默认就是数字
        result.add(word.toString());
        //如果最后一个是0
        if (word.charAt(word.length() - 1) == '0') {
            //无法插入小数点,直接返回
            return result;
        }
        //初始化索引
        int index = 0;
        //循环
        while (++index < word.length()) {
            //固定插入.
            word.insert(index, '.');
            //默认就是数字
            result.add(word.toString());
            //回溯
            word.deleteCharAt(index);
        }
        //返回
        return result;
    }

    //将一种匹配,解析出N种情况
    private List<String> count(StringBuilder left, StringBuilder right) {
        //初始化结果列表
        List<String> result = new ArrayList<>();
        //循环1
        for (String leftWord : countWord(left)) {
            //循环
            for (String rightWord : countWord(right)) {
                //初始化本次结果
                StringBuilder str = new StringBuilder();
                //组合
                str.append('(');
                str.append(leftWord);
                str.append(',');
                str.append(' ');
                str.append(rightWord);
                str.append(')');
                //组装结果
                result.add(str.toString());
            }
        }
        //返回结果
        return result;
    }

    //判断数字str是否为合法数字
    private boolean rightWord(StringBuilder numberStr) {
        //如果没有长度
        if (numberStr.length() < 1) {
            //不是
            return false;
        }
        //如果只有一位数字
        if (numberStr.length() == 1) {
            //肯定可以
            return true;
        }
        //如果开始结尾都是0
        if (numberStr.charAt(0) == '0' && numberStr.charAt(numberStr.length() - 1) == '0') {
            //不是
            return false;
        }
        //默认是
        return true;
    }

    public List<String> ambiguousCoordinates(String s) {
        //初始化结果列表
        List<String> result = new ArrayList<>();
        //初始化左右字符
        StringBuilder leftStr = new StringBuilder();
        StringBuilder rightStr = new StringBuilder(s);
        //删除括号
        rightStr.deleteCharAt(0);
        rightStr.deleteCharAt(rightStr.length() - 1);
        //如果右边还有
        while (rightStr.length() > 0) {
            //交换
            leftStr.append(rightStr.charAt(0));
            rightStr.deleteCharAt(0);
            //如果均是数字
            if (rightWord(leftStr) && rightWord(rightStr)) {
                //实现,并记录结果
                result.addAll(count(leftStr, rightStr));
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        List<String> strings = new Code5().ambiguousCoordinates("(100)");
        System.out.println();
    }

}
