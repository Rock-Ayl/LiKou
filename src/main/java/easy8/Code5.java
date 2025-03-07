package easy8;

/**
 * Created By Rock-Ayl on 2021-06-01
 * 1832. 判断句子是否为全字母句
 * 全字母句 指包含英语字母表中每个字母至少一次的句子。
 * <p>
 * 给你一个仅由小写英文字母组成的字符串 sentence ，请你判断 sentence 是否为 全字母句 。
 * <p>
 * 如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：sentence = "thequickbrownfoxjumpsoverthelazydog"
 * 输出：true
 * 解释：sentence 包含英语字母表中每个字母至少一次。
 * 示例 2：
 * <p>
 * 输入：sentence = "leetcode"
 * 输出：false
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= sentence.length <= 1000
 * sentence 由小写英语字母组成
 */
public class Code5 {

    public boolean checkIfPangram(String sentence) {
        //如果小于26个字母
        if (sentence.length() < 26) {
            //肯定不行
            return false;
        }
        //数组
        int[] arr = new int[26];
        //循环
        for (char c : sentence.toCharArray()) {
            //记录
            arr[c - 'a']++;
        }
        //循环
        for (int i : arr) {
            //如果存在未使用的空间
            if (i == 0) {
                //不是
                return false;
            }
        }
        //默认可以
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
    }

}
