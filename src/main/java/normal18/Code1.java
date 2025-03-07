package normal18;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-12-11
 * 2405. 子字符串的最优划分
 * 给你一个字符串 s ，请你将该字符串划分成一个或多个 子字符串 ，并满足每个子字符串中的字符都是 唯一 的。也就是说，在单个子字符串中，字母的出现次数都不超过 一次 。
 * <p>
 * 满足题目要求的情况下，返回 最少 需要划分多少个子字符串。
 * <p>
 * 注意，划分后，原字符串中的每个字符都应该恰好属于一个子字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abacaba"
 * 输出：4
 * 解释：
 * 两种可行的划分方法分别是 ("a","ba","cab","a") 和 ("ab","a","ca","ba") 。
 * 可以证明最少需要划分 4 个子字符串。
 * 示例 2：
 * <p>
 * 输入：s = "ssssss"
 * 输出：6
 * 解释：
 * 只存在一种可行的划分方法 ("s","s","s","s","s","s") 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 仅由小写英文字母组成
 */
public class Code1 {

    public int partitionString(String s) {
        //次数
        int count = 0;
        //缓存
        Set<Character> set = new HashSet<>();
        //循环
        for (char c : s.toCharArray()) {
            //如果存在了
            if (set.contains(c)) {
                //记录
                count++;
                //清除
                set.clear();
            }
            set.add(c);
        }
        //如果还有
        if (set.size() > 0) {
            //叠加
            count++;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().partitionString("hdklqkcssgxlvehva"));
    }

}
