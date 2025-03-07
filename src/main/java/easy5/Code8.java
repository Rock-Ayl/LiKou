package easy5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-01-07
 * 821. 字符的最短距离
 * 给定一个字符串 S 和一个字符 C。返回一个代表字符串 S 中每个字符到字符串 S 中的字符 C 的最短距离的数组。
 * <p>
 * 示例：
 * <p>
 * 输入：S = "loveleetcode", C = 'e'
 * 输出：[3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 字符串 S 的长度范围为 [1, 10000]。
 * C 是一个单字符，且保证是字符串 S 里的字符。
 * S 和 C 中的所有字母均为小写字母。
 */
public class Code8 {

    public static int[] shortestToChar(String S, char C) {
        //初始化返回值
        int[] result = new int[S.length()];
        //转化为char[]
        char[] arr = S.toCharArray();
        //记录C的位置
        List<Integer> list = new ArrayList<>();
        //循环1
        for (int i = 0; i < arr.length; i++) {
            //当前字符
            char x = arr[i];
            //如果是寻找的字符
            if (x == C) {
                //记录
                list.add(i);
            }
        }
        //循环2
        for (int i = 0; i < arr.length; i++) {
            //当前字符
            char x = arr[i];
            //如果不是特殊字符
            if (x != C) {
                //距离
                Integer dis = null;
                //循环特殊字符位置
                for (Integer integer : list) {
                    //当前距离
                    int thisDis = Math.abs(i - integer);
                    //判空
                    if (dis == null) {
                        //赋予
                        dis = thisDis;
                    } else {
                        //对比并赋予
                        dis = Math.min(dis, thisDis);
                    }
                }
                //记录
                result[i] = dis;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int i : shortestToChar("loveleetcode", 'e')) {
            System.out.println(i);
        }
    }
}
