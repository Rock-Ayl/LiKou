package easy11;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2021-08-05
 * 1941. 检查是否所有字符出现次数相同
 * 给你一个字符串 s ，如果 s 是一个 好 字符串，请你返回 true ，否则请返回 false 。
 * <p>
 * 如果 s 中出现过的 所有 字符的出现次数 相同 ，那么我们称字符串 s 是 好 字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abacbc"
 * 输出：true
 * 解释：s 中出现过的字符为 'a'，'b' 和 'c' 。s 中所有字符均出现 2 次。
 * 示例 2：
 * <p>
 * 输入：s = "aaabb"
 * 输出：false
 * 解释：s 中出现过的字符为 'a' 和 'b' 。
 * 'a' 出现了 3 次，'b' 出现了 2 次，两者出现次数不同。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 只包含小写英文字母。
 */
public class Code1 {

    public boolean areOccurrencesEqual(String s) {
        //桶
        int[] arr = new int[123];
        //用来看种类
        Set<Character> set = new HashSet<>(s.length());
        //循环
        for (char c : s.toCharArray()) {
            //桶++
            arr[c]++;
            set.add(c);
        }
        //如果只有一种
        if (set.size() == 1) {
            //必然
            return true;
        }
        //指针
        int p = 97;
        //大家都应该是
        int size = 0;
        //循环
        for (int i = 97; i < arr.length; i++) {
            //当前
            int num = arr[i];
            //如果找到值
            if (num != 0) {
                //赋予
                size = num;
                //指针
                p = 97;
                //结束
                break;
            }
        }
        //循环
        for (int i = p + 1; i < arr.length; i++) {
            //当前
            int num = arr[i];
            //如果不同
            if (size != arr[i] && num != 0) {
                //不是了
                return false;
            }
        }
        //可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code1().areOccurrencesEqual("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwww"));
    }

}
