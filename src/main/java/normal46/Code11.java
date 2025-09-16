package normal46;

/**
 * @Author ayl
 * @Date 2025-09-16
 * 3106. 满足距离约束且字典序最小的字符串
 * 算术评级: 4
 * 第 392 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1515
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 k 。
 * <p>
 * 定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
 * <p>
 * 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和 。
 * 例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
 * <p>
 * 你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
 * <p>
 * 返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "zbbz", k = 3
 * 输出："aaaz"
 * 解释：在这个例子中，可以执行以下操作：
 * 将 s[0] 改为 'a' ，s 变为 "abbz" 。
 * 将 s[1] 改为 'a' ，s 变为 "aabz" 。
 * 将 s[2] 改为 'a' ，s 变为 "aaaz" 。
 * "zbbz" 和 "aaaz" 之间的距离等于 k = 3 。
 * 可以证明 "aaaz" 是在任意次操作后能够得到的字典序最小的字符串。
 * 因此，答案是 "aaaz" 。
 * 示例 2：
 * <p>
 * 输入：s = "xaxcd", k = 4
 * 输出："aawcd"
 * 解释：在这个例子中，可以执行以下操作：
 * 将 s[0] 改为 'a' ，s 变为 "aaxcd" 。
 * 将 s[2] 改为 'w' ，s 变为 "aawcd" 。
 * "xaxcd" 和 "aawcd" 之间的距离等于 k = 4 。
 * 可以证明 "aawcd" 是在任意次操作后能够得到的字典序最小的字符串。
 * 因此，答案是 "aawcd" 。
 * 示例 3：
 * <p>
 * 输入：s = "lol", k = 0
 * 输出："lol"
 * 解释：在这个例子中，k = 0，更改任何字符都会使得距离大于 0 。
 * 因此，答案是 "lol" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * 0 <= k <= 2000
 * s 只包含小写英文字母。
 */
public class Code11 {

    public String getSmallestString(String s, int k) {
        //初始化结果
        StringBuilder str = new StringBuilder();
        //索引
        int index = 0;
        //如果还有距离
        while (k > 0 && index < s.length()) {
            //当前字符串
            char letter = s.charAt(index);
            //利益最大化目标
            char target = 'a';
            //获取距离
            int away = away(letter, target);
            //判断是否够距离抵扣
            if (k >= away) {
                //组装
                str.append(target);
            } else {
                //距离为k
                away = k;
                //组装新单词
                str.append(toAway(letter, away));
            }
            //抵扣
            k -= away;
            //+1
            index++;
        }
        //剩余的
        while (index < s.length()) {
            //组装并+1
            str.append(s.charAt(index++));
        }
        //返回
        return str.toString();
    }

    /**
     * 计算两个单词之间的距离
     *
     * @param a 单词1
     * @param b 单词2
     * @return
     */
    private int away(char a, char b) {
        //如果相同
        if (a == b) {
            //过
            return 0;
        }
        //如果a更大
        if (a > b) {
            //返回
            return Math.min(a - b, b - (a - 26));
        } else {
            //返回
            return Math.min(b - a, a - (b - 26));
        }
    }

    /**
     * 根据距离,计算新的单词
     *
     * @param letter 原单词
     * @param away   距离
     * @return
     */
    private char toAway(char letter, int away) {
        //数字
        int num = letter - 'a';
        //两种情况
        int a = (num + away) % 26;
        int b = (num - away) % 26;
        //返回
        return (char) (Math.min(a, b) + 'a');
    }

    public static void main(String[] args) {
        System.out.println(new Code11().getSmallestString("uo", 5));
    }

}
