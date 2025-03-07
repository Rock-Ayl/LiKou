package easy21;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2022-07-24
 * 859. 亲密字符串
 * 给你两个字符串 s 和 goal ，只要我们可以通过交换 s 中的两个字母得到与 goal 相等的结果，就返回 true ；否则返回 false 。
 * <p>
 * 交换字母的定义是：取两个下标 i 和 j （下标从 0 开始）且满足 i != j ，接着交换 s[i] 和 s[j] 处的字符。
 * <p>
 * 例如，在 "abcd" 中交换下标 0 和下标 2 的元素可以生成 "cbad" 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ab", goal = "ba"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 相等。
 * 示例 2：
 * <p>
 * 输入：s = "ab", goal = "ab"
 * 输出：false
 * 解释：你只能交换 s[0] = 'a' 和 s[1] = 'b' 生成 "ba"，此时 s 和 goal 不相等。
 * 示例 3：
 * <p>
 * 输入：s = "aa", goal = "aa"
 * 输出：true
 * 解释：你可以交换 s[0] = 'a' 和 s[1] = 'a' 生成 "aa"，此时 s 和 goal 相等。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length, goal.length <= 2 * 104
 * s 和 goal 由小写英文字母组成
 */
public class Code12 {

    public boolean buddyStrings(String s, String goal) {
        //如果长度不同
        if (s.length() != goal.length()) {
            //不行
            return false;
        }
        //是否重复,默认不
        boolean exist = false;
        //字符
        Set<Character> letter = new HashSet();
        //缓存
        List<Integer> list = new ArrayList<>(3);
        //循环
        for (int i = 0; i < s.length(); i++) {
            //左右
            char x = s.charAt(i);
            char y = goal.charAt(i);
            //如果存在了
            if (letter.contains(x)) {
                //是
                exist = true;
            }
            //记录
            letter.add(x);
            //如果相同
            if (x == y) {
                //本轮过
                continue;
            }
            //记录
            list.add(i);
            //如果太多了
            if (list.size() > 2) {
                //不行
                return false;
            }
        }
        //如果只有一个
        if (list.size() == 1) {
            //不行
            return false;
        }
        //如果需要交换
        if (list.size() == 2) {
            //两个坐标
            int first = list.get(0);
            int second = list.get(1);
            //如果可以交换
            if (s.charAt(first) == goal.charAt(second) && s.charAt(second) == goal.charAt(first)) {
                //是
                return true;
            }
            //默认
            return false;
        }
        //默认可以
        return exist;
    }

    public static void main(String[] args) {
        System.out.println(new Code12().buddyStrings("abcd", "acbd"));
    }

}
