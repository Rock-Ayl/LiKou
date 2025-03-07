package easy;

/**
 * Created By Rock-Ayl on 2020-08-09
 * 58. 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * <p>
 * 如果不存在最后一个单词，请返回 0 。
 * <p>
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: "Hello World"
 * 输出: 5
 */
public class Code7 {

    public static int lengthOfLastWord(String s) {
        //切
        String[] values = s.split(" ");
        //倒叙
        for (int i = values.length - 1; i >= 0; i--) {
            //分割
            char[] arr = values[i].toCharArray();
            //判断长度
            if (arr.length > 0) {
                //返回
                return arr.length;
            }
        }
        //缺省
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
    }
}
