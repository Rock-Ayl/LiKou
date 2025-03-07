package easy8;

import java.util.*;

/**
 * @Description 1796. 字符串中第二大的数字
 * 给你一个混合字符串 s ，请你返回 s 中 第二大 的数字，如果不存在第二大的数字，请你返回 -1 。
 * <p>
 * 混合字符串 由小写英文字母和数字组成。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "dfa12321afd"
 * 输出：2
 * 解释：出现在 s 中的数字包括 [1, 2, 3] 。第二大的数字是 2 。
 * 示例 2：
 * <p>
 * 输入：s = "abc1111"
 * 输出：-1
 * 解释：出现在 s 中的数字只包含 [1] 。没有第二大的数字。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 500
 * s 只包含小写英文字母和（或）数字。
 * @Author 安永亮
 * @Date 2021-06-04
 */
public class Code8 {

    public int secondHighest(String s) {
        //指针
        int p = 0;
        //第一大的
        int first = -1;
        //寻找第一大的
        while (p < s.length()) {
            //获取数
            int num = s.charAt(p++) - '0';
            //如果是真的数
            if (num > -1 && num < 10) {
                //第一大的
                first = num;
                //第二大
                int second = -1;
                //寻找第二大的
                while (p < s.length()) {
                    //获取数
                    num = s.charAt(p++) - '0';
                    //如果是真的数
                    if (num > -1 && num < 10) {
                        //如果比1大
                        if (num > first) {
                            //更新
                            second = first;
                            first = num;
                        } else if (num > second && num < first) {
                            //更新
                            second = num;
                        }
                    }
                }
                //如果存在
                if (second > -1) {
                    //返回
                    return second;
                }
            }
        }
        //不存在
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Code8().secondHighest("dfa12321afd"));
    }

}
