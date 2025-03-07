package easy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created By Rock-Ayl on 2020-10-04
 * 面试题 01.02. 判定是否互为字符重排
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 * 示例 2：
 * <p>
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 * 说明：
 * <p>
 * 0 <= len(s1) <= 100
 * 0 <= len(s2) <= 100
 */
public class Code15 {

    public static boolean CheckPermutation(String s1, String s2) {
        //转为List
        List list1 = new ArrayList();
        //循环
        for (char c : s1.toCharArray()) {
            //组装
            list1.add(c);
        }
        //排序
        Collections.sort(list1);
        //转为List
        List list2 = new ArrayList();
        //循环
        for (char c : s2.toCharArray()) {
            //组装
            list2.add(c);
        }
        //排序
        Collections.sort(list2);
        //对比返回
        return list1.equals(list2);
    }

    public static void main(String[] args) {
        System.out.println(CheckPermutation("abc", "bca"));
    }
}
