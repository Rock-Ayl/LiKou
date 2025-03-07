package easy18;

/**
 * @Author ayl
 * @Date 2022-05-01
 * 2129. 将标题首字母大写
 * 给你一个字符串 title ，它由单个空格连接一个或多个单词组成，每个单词都只包含英文字母。请你按以下规则将每个单词的首字母 大写 ：
 * <p>
 * 如果单词的长度为 1 或者 2 ，所有字母变成小写。
 * 否则，将单词首字母大写，剩余字母变成小写。
 * 请你返回 大写后 的 title 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：title = "capiTalIze tHe titLe"
 * 输出："Capitalize The Title"
 * 解释：
 * 由于所有单词的长度都至少为 3 ，将每个单词首字母大写，剩余字母变为小写。
 * 示例 2：
 * <p>
 * 输入：title = "First leTTeR of EACH Word"
 * 输出："First Letter of Each Word"
 * 解释：
 * 单词 "of" 长度为 2 ，所以它保持完全小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * 示例 3：
 * <p>
 * 输入：title = "i lOve leetcode"
 * 输出："i Love Leetcode"
 * 解释：
 * 单词 "i" 长度为 1 ，所以它保留小写。
 * 其他单词长度都至少为 3 ，所以其他单词首字母大写，剩余字母小写。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= title.length <= 100
 * title 由单个空格隔开的单词组成，且不含有任何前导或后缀空格。
 * 每个单词由大写和小写英文字母组成，且都是 非空 的。
 */
public class Code11 {

    public String improve(String word) {
        //判断长度
        if (word.length() < 3) {
            //返回所有小写
            return word.toLowerCase();
        } else {
            //只有第一个大写
            return String.valueOf(word.charAt(0)).toUpperCase() + word.substring(1).toLowerCase();
        }
    }

    public String capitalizeTitle(String title) {
        //数组
        String[] words = title.split(" ");
        //结果
        StringBuilder result = new StringBuilder();
        //第一个
        result.append(improve(words[0]));
        //循环
        for (int i = 1; i < words.length; i++) {
            //组装改变后的
            result.append(" " + improve(words[i]));
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().capitalizeTitle("First leTTeR of EACH Word"));
    }

}
