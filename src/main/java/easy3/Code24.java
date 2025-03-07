package easy3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-11-16
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1：
 * <p>
 * 输入："hello"
 * 输出："holle"
 * 示例 2：
 * <p>
 * 输入："leetcode"
 * 输出："leotcede"
 */
public class Code24 {

    public static String reverseVowels(String s) {
        //元音
        Set<Character> set = new HashSet(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        //转化
        char[] sChars = s.toCharArray();
        //左、右位置
        int x = 0, y = sChars.length - 1;
        //当两边未冲突时
        while (x < y) {
            //当前左值,如果是元音
            if (set.contains(sChars[x])) {
                //当前右值,如果是原因
                if (set.contains(sChars[y])) {
                    //初始化个z
                    char z = sChars[x];
                    //换位置
                    sChars[x] = sChars[y];
                    sChars[y] = z;
                    //都像中心靠近
                    x++;
                    y--;
                } else {
                    //移动y
                    y--;
                }
            } else {
                //移动x
                x++;
            }
        }
        //返回
        return String.valueOf(sChars);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("leetcode"));
    }
}
