package normal3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-05-04
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入：digits = "23"
 * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 示例 2：
 * <p>
 * 输入：digits = ""
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：digits = "2"
 * 输出：["a","b","c"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= digits.length <= 4
 * digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class Code12 {

    //按键组
    char[] two = new char[]{'a', 'b', 'c'};
    char[] three = new char[]{'d', 'e', 'f'};
    char[] four = new char[]{'g', 'h', 'i'};
    char[] five = new char[]{'j', 'k', 'l'};
    char[] six = new char[]{'m', 'n', 'o'};
    char[] seven = new char[]{'p', 'q', 'r', 's'};
    char[] eight = new char[]{'t', 'u', 'v'};
    char[] nine = new char[]{'w', 'x', 'y', 'z'};

    //结果
    List<String> result = new ArrayList<>();

    public void execute(String thisDigits, String pre) {
        //如果到底了
        if (thisDigits.length() == 0) {
            //记录
            result.add(pre);
            //结束
            return;
        }
        //当前字符
        char x = thisDigits.charAt(0);
        //根据x
        switch (x) {
            case '2':
                //循环
                for (char c : two) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '3':
                for (char c : three) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '4':
                for (char c : four) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '5':
                for (char c : five) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '6':
                for (char c : six) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '7':
                for (char c : seven) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '8':
                for (char c : eight) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
            case '9':
                for (char c : nine) {
                    //分割
                    execute(thisDigits.substring(1), pre + c);
                }
                break;
        }
    }

    /**
     * 懒得修剪
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        //判空
        if (digits.length() == 0) {
            //返回
            return result;
        }
        //不断解析
        execute(digits, "");
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String letterCombination : new Code12().letterCombinations("23")) {
            System.out.println(letterCombination);
        }
    }

}
