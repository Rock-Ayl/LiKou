package normal5;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2021-07-24
 * 面试题 08.07. 无重复字符串的排列组合
 * 无重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合，字符串每个字符均不相同。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qwe"
 * 输出：["qwe", "qew", "wqe", "weq", "ewq", "eqw"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Code8 {

    List<String> result = new ArrayList<>();

    public void dfs(List<Character> list, StringBuffer str) {
        if (list.size() == 0) {
            result.add(str.toString());
        }
        for (int i = 0; i < list.size(); i++) {
            char x = list.get(i);
            str.append(x);
            list.remove(i);
            dfs(list, str);
            list.add(i, x);
            str.deleteCharAt(str.length() - 1);
        }
    }

    public String[] permutation(String S) {
        List<Character> list = new ArrayList<>(S.length());
        for (char c : S.toCharArray()) {
            list.add(c);
        }
        dfs(list, new StringBuffer());
        return result.toArray(new String[]{});
    }

    public static void main(String[] args) {
        String[] arr = new Code8().permutation("qwe");
        System.out.println(arr);
    }
}
