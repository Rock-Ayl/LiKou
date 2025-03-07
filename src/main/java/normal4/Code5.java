package normal4;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-19
 * 面试题 08.08. 有重复字符串的排列组合
 * 有重复字符串的排列组合。编写一种方法，计算某字符串的所有排列组合。
 * <p>
 * 示例1:
 * <p>
 * 输入：S = "qqe"
 * 输出：["eqq","qeq","qqe"]
 * 示例2:
 * <p>
 * 输入：S = "ab"
 * 输出：["ab", "ba"]
 * 提示:
 * <p>
 * 字符都是英文字母。
 * 字符串长度在[1, 9]之间。
 */
public class Code5 {

    //结果
    Set<String> set = new HashSet<>();

    public void set(Stack<Character> stack, StringBuilder str) {
        //如果结尾了
        if (stack.size() == 0) {
            //记录结果
            set.add(str.toString());
        }
        //循环
        for (int i = 0; i < stack.size(); i++) {
            //当前字符
            char thisChar = stack.get(i);
            //组装
            str.append(thisChar);
            //删除
            stack.remove(i);
            //下一级
            set(stack, str);
            //回溯
            str.deleteCharAt(str.length() - 1);
            stack.add(i, thisChar);
        }
    }

    public String[] permutation(String S) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : S.toCharArray()) {
            //组装
            stack.add(c);
        }
        //不断填充
        set(stack, new StringBuilder());
        //结果初始化
        String[] result = new String[set.size()];
        //指针
        int p = 0;
        //循环
        for (String s : set) {
            //组装
            result[p++] = s;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String qqe : new Code5().permutation("qqe")) {
            System.out.println(qqe);
        }
    }

}
