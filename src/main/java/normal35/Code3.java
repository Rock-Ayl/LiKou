package normal35;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2024-09-13
 * 2024. 考试的最大困扰度
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 一位老师正在出一场由 n 道判断题构成的考试，每道题的答案为 true （用 'T' 表示）或者 false （用 'F' 表示）。老师想增加学生对自己做出答案的不确定性，方法是 最大化 有 连续相同 结果的题数。（也就是连续出现 true 或者连续出现 false）。
 * <p>
 * 给你一个字符串 answerKey ，其中 answerKey[i] 是第 i 个问题的正确结果。除此以外，还给你一个整数 k ，表示你能进行以下操作的最多次数：
 * <p>
 * 每次操作中，将问题的正确答案改为 'T' 或者 'F' （也就是将 answerKey[i] 改为 'T' 或者 'F' ）。
 * 请你返回在不超过 k 次操作的情况下，最大 连续 'T' 或者 'F' 的数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：answerKey = "TTFF", k = 2
 * 输出：4
 * 解释：我们可以将两个 'F' 都变为 'T' ，得到 answerKey = "TTTT" 。
 * 总共有四个连续的 'T' 。
 * 示例 2：
 * <p>
 * 输入：answerKey = "TFFT", k = 1
 * 输出：3
 * 解释：我们可以将最前面的 'T' 换成 'F' ，得到 answerKey = "FFFT" 。
 * 或者，我们可以将第二个 'T' 换成 'F' ，得到 answerKey = "TFFF" 。
 * 两种情况下，都有三个连续的 'F' 。
 * 示例 3：
 * <p>
 * 输入：answerKey = "TTFTTFTT", k = 1
 * 输出：5
 * 解释：我们可以将第一个 'F' 换成 'T' ，得到 answerKey = "TTTTTFTT" 。
 * 或者我们可以将第二个 'F' 换成 'T' ，得到 answerKey = "TTFTTTTT" 。
 * 两种情况下，都有五个连续的 'T' 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == answerKey.length
 * 1 <= n <= 5 * 104
 * answerKey[i] 要么是 'T' ，要么是 'F'
 * 1 <= k <= n
 */
public class Code3 {

    //实现
    private int count(String answerKey, int k, Character target) {
        //最大长度
        int maxLength = 0;
        //双端队列
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        //循环
        for (Character letter : answerKey.toCharArray()) {
            //还是加入
            arrayDeque.addLast(letter);
            //如果是目标字符 or 如果可以替换
            if (letter.equals(target) || --k >= 0) {
                //本轮过
                continue;
            }
            //先刷新本次结果
            maxLength = Math.max(maxLength, arrayDeque.size());
            //循环
            while (k < 0) {
                //获取最后一个,如果是错误的,回收
                k += arrayDeque.pollFirst().equals(target) ? 0 : 1;
            }
        }
        //返回最大结果
        return Math.max(maxLength - 1, arrayDeque.size());
    }

    public int maxConsecutiveAnswers(String answerKey, int k) {
        //实现两种情况
        return Math.max(count(answerKey, k, 'T'), count(answerKey, k, 'F'));
    }

    public static void main(String[] args) {
        System.out.println(new Code3().maxConsecutiveAnswers("TTFTTFTT", 1));
    }

}
