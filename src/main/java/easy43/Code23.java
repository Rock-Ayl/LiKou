package easy43;

/**
 * 3992. 重新排列字符串以避免字符对
 * 第 187 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1251
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和两个 不同 的小写英文字母 x 和 y。
 * <p>
 * 重新排列 s 中的字符来构造一个新的字符串 t，使得：
 * <p>
 * t 是 s 的一个 排列。
 * 在 t 中，所有 y 都必须在所有 x 之前。
 * 返回 任意 一个有效的字符串 t。
 * <p>
 * 排列 是对一个字符串中所有字符的重新排列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "aabc", x = "a", y = "c"
 * <p>
 * 输出： "cbaa"
 * <p>
 * 解释：
 * <p>
 * 字符串 "cbaa" 是 "aabc" 的一个排列，且每次出现的 'c' 都在每次出现的 'a' 之前。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "dcab", x = "d", y = "b"
 * <p>
 * 输出： "cabd"
 * <p>
 * 解释：
 * <p>
 * 字符串 "cabd" 是 "dcab" 的一个排列，且每次出现的 'b' 都在每次出现的 'd' 之前。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s = "axe", x = "o", y = "x"
 * <p>
 * 输出： "axe"
 * <p>
 * 解释：
 * <p>
 * 字符串 "axe" 已经有效。因为 'o' 没有在字符串中出现，所以自动满足要求的条件。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由小写英文字母组成。
 * x 和 y 都是小写英文字母。
 * x != y
 *
 */
public class Code23 {

    public String rearrangeString(String s, char x, char y) {
        //x的数量
        int xCount = 0;
        //结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char c = s.charAt(i);
            //如果是x
            if (c == x) {
                //+1
                xCount++;
            } else {
                //直接组装
                str.append(c);
            }
        }
        //循环
        while (xCount-- > 0) {
            //添加x
            str.append(x);
        }
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code23().rearrangeString("aabc", 'a', 'c'));
    }

}

