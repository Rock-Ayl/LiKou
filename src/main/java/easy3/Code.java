package easy3;

/**
 * Created By Rock-Ayl on 2020-11-09
 * 520. 检测大写字母
 * 给定一个单词，你需要判断单词的大写使用是否正确。
 * <p>
 * 我们定义，在以下情况时，单词的大写用法是正确的：
 * <p>
 * 全部字母都是大写，比如"USA"。
 * 单词中所有字母都不是大写，比如"leetcode"。
 * 如果单词不只含有一个字母，只有首字母大写， 比如 "Google"。
 * 否则，我们定义这个单词没有正确使用大写字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "USA"
 * 输出: True
 * 示例 2:
 * <p>
 * 输入: "FlaG"
 * 输出: False
 * 注意: 输入是由大写和小写拉丁字母组成的非空单词。
 */
public class Code {

    public static boolean detectCapitalUse(String word) {
        //大
        int big = 0;
        //小
        int small = 0;
        //首字母大写
        boolean firstBig;
        //拆分
        char[] words = word.toCharArray();
        //首位
        char o = words[0];
        //如果是小写
        if (o >= 97 && o <= 122) {
            //记录
            small++;
            firstBig = false;
        } else {
            //记录
            big++;
            //首位大写
            firstBig = true;
        }
        //循环
        for (int i = 1; i < words.length; i++) {
            //获取字节值
            byte x = (byte) words[i];
            //如果是小写
            if (x >= 97 && x <= 122) {
                //记录
                small++;
            } else {
                //记录
                big++;
            }
        }
        //如果全小写、全大写，
        if (big == 0 || small == 0) {
            //合理
            return true;
        }
        //如果仅仅是首位大写
        if (big == 1 && firstBig == true) {
            //合理
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("azAZc"));
    }
}
