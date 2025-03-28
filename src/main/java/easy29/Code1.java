package easy29;

/**
 * @Author ayl
 * @Date 2023-03-10
 * 1544. 整理字符串
 * 给你一个由大小写英文字母组成的字符串 s 。
 * <p>
 * 一个整理好的字符串中，两个相邻字符 s[i] 和 s[i+1]，其中 0<= i <= s.length-2 ，要满足如下条件:
 * <p>
 * 若 s[i] 是小写字符，则 s[i+1] 不可以是相同的大写字符。
 * 若 s[i] 是大写字符，则 s[i+1] 不可以是相同的小写字符。
 * 请你将字符串整理好，每次你都可以从字符串中选出满足上述条件的 两个相邻 字符并删除，直到字符串整理好为止。
 * <p>
 * 请返回整理好的 字符串 。题目保证在给出的约束条件下，测试样例对应的答案是唯一的。
 * <p>
 * 注意：空字符串也属于整理好的字符串，尽管其中没有任何字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leEeetcode"
 * 输出："leetcode"
 * 解释：无论你第一次选的是 i = 1 还是 i = 2，都会使 "leEeetcode" 缩减为 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "abBAcC"
 * 输出：""
 * 解释：存在多种不同情况，但所有的情况都会导致相同的结果。例如：
 * "abBAcC" --> "aAcC" --> "cC" --> ""
 * "abBAcC" --> "abBA" --> "aA" --> ""
 * 示例 3：
 * <p>
 * 输入：s = "s"
 * 输出："s"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写和大写英文字母
 */
public class Code1 {

    public String makeGood(String s) {
        //模拟栈
        StringBuilder str = new StringBuilder();
        //循环
        for (char c : s.toCharArray()) {
            //如果没有任何内容
            if (str.length() == 0) {
                //直接组装
                str.append(c);
                //本轮过
                continue;
            }
            //如果和前者比一个是大写一个是小写
            if (Math.abs(str.charAt(str.length() - 1) - c) == 32) {
                //删除前者,不组装后者
                str.deleteCharAt(str.length() - 1);
                //本轮过
                continue;
            }
            //默认加入栈
            str.append(c);
        }
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code1().makeGood("bB"));
    }

}
