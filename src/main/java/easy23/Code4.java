package easy23;

/**
 * @Author ayl
 * @Date 2022-09-18
 * 2309. 兼具大小写的最好英文字母
 * 给你一个由英文字母组成的字符串 s ，请你找出并返回 s 中的 最好 英文字母。返回的字母必须为大写形式。如果不存在满足条件的字母，则返回一个空字符串。
 * <p>
 * 最好 英文字母的大写和小写形式必须 都 在 s 中出现。
 * <p>
 * 英文字母 b 比另一个英文字母 a 更好 的前提是：英文字母表中，b 在 a 之 后 出现。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lEeTcOdE"
 * 输出："E"
 * 解释：
 * 字母 'E' 是唯一一个大写和小写形式都出现的字母。
 * 示例 2：
 * <p>
 * 输入：s = "arRAzFif"
 * 输出："R"
 * 解释：
 * 字母 'R' 是大写和小写形式都出现的最好英文字母。
 * 注意 'A' 和 'F' 的大写和小写形式也都出现了，但是 'R' 比 'F' 和 'A' 更好。
 * 示例 3：
 * <p>
 * 输入：s = "AbCdEfGhIjK"
 * 输出：""
 * 解释：
 * 不存在大写和小写形式都出现的字母。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 1000
 * s 由小写和大写英文字母组成
 */
public class Code4 {

    public String greatestLetter(String s) {
        //大小缓存
        int[] small = new int[26];
        int[] big = new int[26];
        //循环
        for (int i = s.length() - 1; i >= 0; i--) {
            //当前
            char c = s.charAt(i);
            //如果是小的
            if (c > 96 && c < 123) {
                //指针
                int p = c - 'a';
                //记录
                small[p]++;
            } else if (c < 91 && c > 64) {
                //指针
                int p = c - 'A';
                //记录
                big[p]++;
            } else {
                //其他过
                continue;
            }
        }
        //找结果
        for (int i = 25; i >= 0; i--) {
            //如果是更好
            if (small[i] > 0 && big[i] > 0) {
                //返回
                return String.valueOf((char) (i + 'A'));
            }
        }
        //返回
        return "";
    }

    public static void main(String[] args) {
        String x = new Code4().greatestLetter("zaZA");
        System.out.println(x);
    }

}
