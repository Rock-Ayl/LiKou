package normal4;

import java.util.*;

/**
 * Created By Rock-Ayl on 2021-05-15
 * 剑指 Offer 38. 字符串的排列
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * <p>
 * <p>
 * <p>
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * 输入：s = "abc"
 * 输出：["abc","acb","bac","bca","cab","cba"]
 * <p>
 * <p>
 * 限制：
 * <p>
 * 1 <= s 的长度 <= 8
 */
public class Code1 {

    //结果
    HashSet<String> set = new HashSet();

    public void set(Stack<Character> stack, StringBuffer str) {
        //如果结束了
        if (stack.size() == 0) {
            //记录
            set.add(str.toString());
        }
        //循环
        for (int i = 0; i < stack.size(); i++) {
            //当前char
            char thisChar = stack.get(i);
            //组装
            str.append(thisChar);
            //删除当前
            stack.remove(i);
            //下一级
            set(stack, str);
            //回溯
            str.deleteCharAt(str.length() - 1);
            stack.add(i, thisChar);
        }
    }

    public String[] permutation(String s) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : s.toCharArray()) {
            //组装
            stack.add(c);
        }
        //不断组装
        set(stack, new StringBuffer());
        //初始化结果
        String[] result = new String[set.size()];
        //指针
        int p = 0;
        //循环
        for (String s1 : set) {
            //组装
            result[p++] = s1;
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (String abc : new Code1().permutation("abc")) {
            System.out.println(abc);
        }
    }
}
