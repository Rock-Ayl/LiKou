package normal52;

import java.util.HashSet;
import java.util.Set;

/**
 * LCR 096. 交错字符串
 * 同步题目状态
 * <p>
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 给定三个字符串 s1、s2、s3，请判断 s3 能不能由 s1 和 s2 交织（交错） 组成。
 * <p>
 * 两个字符串 s 和 t 交织 的定义与过程如下，其中每个字符串都会被分割成若干 非空 子字符串：
 * <p>
 * s = s1 + s2 + ... + sn
 * t = t1 + t2 + ... + tm
 * |n - m| <= 1
 * 交织 是 s1 + t1 + s2 + t2 + s3 + t3 + ... 或者 t1 + s1 + t2 + s2 + t3 + s3 + ...
 * 提示：a + b 意味着字符串 a 和 b 连接。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac"
 * 输出：true
 * 示例 2：
 * <p>
 * 输入：s1 = "aabcc", s2 = "dbbca", s3 = "aadbbbaccc"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "", s2 = "", s3 = ""
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s1.length, s2.length <= 100
 * 0 <= s3.length <= 200
 * s1、s2、和 s3 都由小写英文字母组成
 * <p>
 * <p>
 * 注意：本题与主站 97 题相同：  https://leetcode.cn/problems/interleaving-string/
 */
public class Code20 {

    public boolean isInterleave(String s1, String s2, String s3) {
        //如果长度不同
        if (s1.length() + s2.length() != s3.length()) {
            //过
            return false;
        }
        //实现
        return next(s1, s2, s3, 0, 0, 0, new int[s1.length() + 1][s2.length() + 1]);
    }

    //递归
    private boolean next(String s1, String s2, String s3, int index1, int index2, int index3, int[][] keySet) {
        //如果到头了
        if (index3 == s3.length()) {
            //如果到头了，说明匹配成功
            return true;
        }
        //如果走过了
        if (++keySet[index1][index2] > 1) {
            //过
            return false;
        }
        //添加
        //获取当前目标
        char target = s3.charAt(index3);
        //可能1
        if (index1 < s1.length() && s1.charAt(index1) == target) {
            //递归
            boolean success = next(s1, s2, s3, index1 + 1, index2, index3 + 1, keySet);
            //如果是
            if (success) {
                //返回
                return true;
            }
        }
        //可能2
        if (index2 < s2.length() && s2.charAt(index2) == target) {
            //递归
            boolean success = next(s1, s2, s3, index1, index2 + 1, index3 + 1, keySet);
            //如果是
            if (success) {
                //返回
                return true;
            }
        }
        //默认不是
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().isInterleave("aabcc", "dbbca", "aadbbcbcac"));
    }

}
