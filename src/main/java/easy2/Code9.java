package easy2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Created By Rock-Ayl on 2020-09-27
 * 942. 增减字符串匹配
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 * <p>
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 * <p>
 * 如果 S[i] == "I"，那么 A[i] < A[i+1]
 * 如果 S[i] == "D"，那么 A[i] > A[i+1]
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入："IDID"
 * 输出：[0,4,1,3,2]
 * 示例 2：
 * <p>
 * 输入："III"
 * 输出：[0,1,2,3]
 * 示例 3：
 * <p>
 * 输入："DDI"
 * 输出：[3,2,0,1]
 */
public class Code9 {

    public static int[] diStringMatch(String S) {
        //N
        int n = S.length();
        //初始化返回值
        int[] result = new int[n + 1];
        //分割
        char[] charArr = S.toCharArray();
        //初始化
        Set<Integer> set = new HashSet();
        //循环
        for (int i = 0; i < charArr.length; i++) {
            //当前值
            String thisS = charArr[i] + "";
            //判断
            switch (thisS) {
                //减小
                case "D":
                    //插入
                    result[i] = n;
                    //n减少
                    n--;
                    //记录
                    set.add(i);
                    break;
            }
        }
        //翻转
        n = 0;
        //循环
        for (int i = 0; i < result.length; i++) {
            //如果没有组装过
            if (!set.contains(i)) {
                //存入
                result[i] = n;
                //叠加
                n++;
            }
        }
        //返回
        return result;
    }

    public static void main(String[] args) {
        for (int s : diStringMatch("IDID")) {
            System.out.println(s);
        }
    }
}
