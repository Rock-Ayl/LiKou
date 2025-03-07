package easy11;

/**
 * @Author ayl
 * @Date 2021-09-26
 * 1374. 生成每种字符都是奇数个的字符串
 * 给你一个整数 n，请你返回一个含 n 个字符的字符串，其中每种字符在该字符串中都恰好出现 奇数次 。
 * <p>
 * 返回的字符串必须只含小写英文字母。如果存在多个满足题目要求的字符串，则返回其中任意一个即可。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 4
 * 输出："pppz"
 * 解释："pppz" 是一个满足题目要求的字符串，因为 'p' 出现 3 次，且 'z' 出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ohhh" 和 "love"。
 * 示例 2：
 * <p>
 * 输入：n = 2
 * 输出："xy"
 * 解释："xy" 是一个满足题目要求的字符串，因为 'x' 和 'y' 各出现 1 次。当然，还有很多其他字符串也满足题目要求，比如："ag" 和 "ur"。
 * 示例 3：
 * <p>
 * 输入：n = 7
 * 输出："holasss"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 500
 */
public class Code14 {

    public String generateTheString(int n) {
        //初始化
        StringBuilder str = new StringBuilder();
        //如果是偶数
        if (n % 2 == 0) {
            //额外+1
            str.append('a');
            //-1
            n--;
        }
        //无限循环
        while (n-- > 0) {
            //一直写
            str.append('b');
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code14().generateTheString(3));
    }

}
