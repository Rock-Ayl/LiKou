package easy5;

import java.util.ArrayList;
import java.util.List;

/**
 * Created By Rock-Ayl on 2021-01-25
 * 796. 旋转字符串
 * 给定两个字符串, A 和 B。
 * <p>
 * A 的旋转操作就是将 A 最左边的字符移动到最右边。 例如, 若 A = 'abcde'，在移动一次之后结果就是'bcdea' 。如果在若干次旋转操作之后，A 能变成B，那么返回True。
 * <p>
 * 示例 1:
 * 输入: A = 'abcde', B = 'cdeab'
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: A = 'abcde', B = 'abced'
 * 输出: false
 * 注意：
 * <p>
 * A 和 B 长度不超过 100。
 */
public class Code25 {

    public static boolean rotateString(String A, String B) {
        //A、B长度
        int aSize = A.length();
        int bSize = B.length();
        //如果不同长度
        if (aSize != bSize) {
            //直接返回
            return false;
        }
        //如果为空
        if (aSize == 0) {
            //直接返回
            return true;
        }
        //获取初始点a
        char dotA = A.charAt(0);
        //获得两个初始点的位置
        int ap = 0, bp;
        //跳过循环位置
        io:
        //循环
        for (int i = 0; i < bSize; i++) {
            //初始点b
            char dotB = B.charAt(i);
            //如果初始点对上了
            if (dotA == dotB) {
                //更新b的初始点
                bp = i;
                //a、b的位置
                int a = 1, b = 1;
                //循环
                while (a < aSize - 1) {
                    //获取当前a值
                    char aa = A.charAt(ap + a);
                    //获取b的位置
                    int thisBp = bp + b;
                    //获取当前b值
                    char bb;
                    //如果b位置越界,回到原点
                    if (thisBp >= bSize) {
                        //越界处理
                        bb = B.charAt(thisBp - bSize);
                    } else {
                        //正常处理
                        bb = B.charAt(thisBp);
                    }
                    //如果出现问题
                    if (aa != bb) {
                        //跳过循环位置
                        continue io;
                    }
                    //递增
                    a++;
                    b++;
                }
                //会
                return true;
            }
        }
        //缺省不会
        return false;
    }

    public static void main(String[] args) {
        System.out.println(rotateString("abcde", "cdeab"));
    }
}
