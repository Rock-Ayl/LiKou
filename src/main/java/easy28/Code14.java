package easy28;

/**
 * @Author ayl
 * @Date 2023-02-25
 * 953. 验证外星语词典
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
 */
public class Code14 {

    public boolean isAlienSorted(String[] words, String order) {
        //缓存
        int[] cacheArr = new int[123];
        //循环
        for (int i = 0; i < order.length(); i++) {
            //记录缓存
            cacheArr[order.charAt(i)] = i;
        }
        //跳出标记
        out:
        //循环
        for (int i = 1; i < words.length; i++) {
            //获取左右
            String left = words[i - 1];
            String right = words[i];
            //二者最小长度
            int p = Math.min(left.length(), right.length());
            //循环
            for (int j = 0; j < p; j++) {
                //按照字典权重比较
                int sortNum = cacheArr[left.charAt(j)] - cacheArr[right.charAt(j)];
                //如果前者需要和后者换位置了
                if (sortNum > 0) {
                    //不对
                    return false;
                }
                //如果相同
                if (sortNum == 0) {
                    //本轮过
                    continue;
                }
                //最后,说明单词排序正确,本轮跳出
                continue out;
            }
            //到这里,说明一个是另一个前缀,那么就比较长度
            if (left.length() - right.length() > 0) {
                //如果前者和后者换位置了,不是
                return false;
            }
        }
        //默认是
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().isAlienSorted(new String[]{"hello", "leetcode"}, "hlabcdefgijkmnopqrstuvwxyz"));
    }

}