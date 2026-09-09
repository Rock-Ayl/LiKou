package easy44;

/**
 * 4043. 恰好有 K 对相等相邻字符的循环移位数量
 * 算术评级: 2
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个长度为 n 的字符串 s 和一个整数 k。
 * <p>
 * s 的一次 循环移位 可以通过以下方式得到：选择 s 的一个长度在 0 到 n - 1（包含两端）之间的 前缀 ，并将其移动到字符串末尾，同时保持所有字符的相对顺序不变。
 * <p>
 * 对于 s 的 每一种 循环移位，定义其 得分 为满足以下条件的下标 i 的数量：0 <= i < n - 1，且位置 i 和 i + 1 处的字符相同。
 * <p>
 * 返回得分等于 k 的循环移位数量。
 * <p>
 * 字符串的 前缀 是指从字符串开头开始，并延伸到字符串中某个位置的子串。
 * <p>
 * 子串 是字符串中一段连续的字符序列，可以为空。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "aab", k = 1
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * s 的所有循环移位为：
 * <p>
 * "aab"：位置 0 和 1 处的字符相同，因此 score = 1。
 * "aba"：不存在两个相邻且相同的字符，因此 score = 0。
 * "baa"：位置 1 和 2 处的字符相同，因此 score = 1。
 * 共有 2 种 s 的循环移位，其 score 等于 k，因此答案为 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "abca", k = 0
 * <p>
 * 输出： 1
 * <p>
 * 解释：
 * <p>
 * s 的所有循环移位为：
 * <p>
 * "abca"：不存在两个相邻且相同的字符，因此 score = 0。
 * "bcaa"：位置 2 和 3 处的字符相同，因此 score = 1。
 * "caab"：位置 1 和 2 处的字符相同，因此 score = 1。
 * "aabc"：位置 0 和 1 处的字符相同，因此 score = 1。
 * 只有 1 种 s 的循环移位，其 score 等于 k，因此答案为 1。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= n == s.length <= 100
 * s 仅由小写英文字母组成。
 * 0 <= k <= n - 1
 */
public class Code5 {

    public int countRotations(String s, int k) {
        //最大分数的次数
        int count = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //本次
            int score = count(i, s);
            //如果是
            if (score == k) {
                //+1
                count++;
            }
        }
        //返回
        return count;
    }

    //计算本次
    private int count(int start, String s) {
        //分数
        int score = 0;
        //操作次数
        int change = s.length() - 1;
        //循环
        while (change-- > 0) {
            //本次索引
            int left = start;
            int right = start + 1;
            //下一个,如果越界了
            if (right >= s.length()) {
                //重置
                right -= s.length();
            }
            //获取对应字符
            char a = s.charAt(left);
            char b = s.charAt(right);
            //如果相同
            if (a == b) {
                //+1
                score++;
            }
            //下一个,如果越界了
            if (++start >= s.length()) {
                //重置
                start -= s.length();
            }
        }
        //返回
        return score;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().countRotations("abcd", 0));
    }

}
