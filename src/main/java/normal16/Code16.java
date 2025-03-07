package normal16;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2022-10-07
 * 784. 字母大小写全排列
 * 给定一个字符串 s ，通过将字符串 s 中的每个字母转变大小写，我们可以获得一个新的字符串。
 * <p>
 * 返回 所有可能得到的字符串集合 。以 任意顺序 返回输出。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1b2"
 * 输出：["a1b2", "a1B2", "A1b2", "A1B2"]
 * 示例 2:
 * <p>
 * 输入: s = "3z4"
 * 输出: ["3z4","3Z4"]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 12
 * s 由小写英文字母、大写英文字母和数字组成
 */
public class Code16 {

    //初始化结果集合
    private Set<String> result = new HashSet<>();

    public void next(String s, int p, StringBuilder str) {

        //如果到头了
        if (p == s.length()) {
            //记录结果
            result.add(str.toString());
            //过
            return;
        }

        //获取对应字符
        String letter = String.valueOf(s.charAt(p++));

        //大写走下去
        next(s, p, str.append(letter.toUpperCase()));
        //回溯
        str.deleteCharAt(str.length() - 1);

        //小写走下去
        next(s, p, str.append(letter.toLowerCase()));
        //回溯
        str.deleteCharAt(str.length() - 1);

    }

    public List<String> letterCasePermutation(String s) {
        //走下去
        next(s, 0, new StringBuilder());
        //转化为list并返回
        return result.stream().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        List<String> result = new Code16().letterCasePermutation("a1b2");
        System.out.println();
    }

}
