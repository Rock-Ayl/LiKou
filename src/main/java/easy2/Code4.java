package easy2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-09-22
 * 面试题 01.01. 判定字符是否唯一
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "leetcode"
 * 输出: false
 * 示例 2：
 * <p>
 * 输入: s = "abc"
 * 输出: true
 * 限制：
 * <p>
 * 0 <= len(s) <= 100
 * 如果你不使用额外的数据结构，会很加分。
 */
public class Code4 {

    public static boolean isUnique(String astr) {
        //用set
        Set<String> set = new HashSet<>();
        //循环
        for (char c : astr.toCharArray()) {
            //获取值
            String thisValue = c + "";
            //如果存在
            if (set.contains(thisValue)) {
                //返回
                return false;
            } else {
                //记录
                set.add(thisValue);
            }
        }
        //不存在
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isUnique("leet code"));
    }
}
