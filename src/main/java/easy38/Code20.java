package easy38;

/**
 * @Author ayl
 * @Date 2024-10-27
 * 3330. 找到初始输入字符串 I
 * 简单
 * 相关企业
 * 提示
 * Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
 * <p>
 * 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
 * <p>
 * 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
 * <p>
 * 请你返回 Alice 一开始可能想要输入字符串的总方案数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "abbcccc"
 * <p>
 * 输出：5
 * <p>
 * 解释：
 * <p>
 * 可能的字符串包括："abbcccc" ，"abbccc" ，"abbcc" ，"abbc" 和 "abcccc" 。
 * <p>
 * 示例 2：
 * <p>
 * 输入：word = "abcd"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * 唯一可能的字符串是 "abcd" 。
 * <p>
 * 示例 3：
 * <p>
 * 输入：word = "aaaa"
 * <p>
 * 输出：4
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 100
 * word 只包含小写英文字母。
 */
public class Code20 {

    public int possibleStringCount(String word) {
        //默认
        int count = 1;
        //循环
        for (int i = 1; i < word.length(); i++) {
            //+1
            count += word.charAt(i) == word.charAt(i - 1) ? 1 : 0;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().possibleStringCount("abbcccc"));
    }

}
