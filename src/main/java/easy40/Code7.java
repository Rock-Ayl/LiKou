package easy40;

/**
 * @Author ayl
 * @Date 2025-03-21
 * LCR 034. 验证外星语词典
 * 简单
 * 相关标签
 * 相关企业
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * 输出：true
 * 解释：在该语言的字母表中，'h' 位于 'l' 之前，所以单词序列是按字典序排列的。
 * 示例 2：
 * <p>
 * 输入：words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * 输出：false
 * 解释：在该语言的字母表中，'d' 位于 'l' 之后，那么 words[0] > words[1]，因此单词序列不是按字典序排列的。
 * 示例 3：
 * <p>
 * 输入：words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * 输出：false
 * 解释：当前三个字符 "app" 匹配时，第二个字符串相对短一些，然后根据词典编纂规则 "apple" > "app"，因为 'l' > '∅'，其中 '∅' 是空白字符，定义为比任何其他字符都小（更多信息）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * 在 words[i] 和 order 中的所有字符都是英文小写字母。
 * <p>
 * <p>
 * 注意：本题与主站 953 题相同： https://leetcode-cn.com/problems/verifying-an-alien-dictionary/
 */
public class Code7 {

    public boolean isAlienSorted(String[] words, String order) {
        //原始排序
        char[] arr = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
        //新原始排序
        char[] newSortArr = new char[123];
        //循环
        for (int i = 0; i < order.length(); i++) {
            //记录配对关系
            newSortArr[order.charAt(i)] = arr[i];
        }
        //循环
        for (int i = 0; i < words.length; i++) {
            //初始化新单词
            StringBuilder newWord = new StringBuilder();
            //单词
            String word = words[i];
            //循环
            for (char letter : word.toCharArray()) {
                //转换组合
                newWord.append(newSortArr[letter]);
            }
            //转换
            words[i] = newWord.toString();
            //与前面的对比,如果不符合目标
            if (i > 0 && words[i - 1].compareTo(words[i]) > 0) {
                //不是
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code7().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

}
