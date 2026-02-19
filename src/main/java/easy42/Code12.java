package easy42;

/**
 * 3838. 带权单词映射
 * 算术评级: 2
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串数组 words，其中每个字符串表示一个由小写英文字母组成的单词。
 * <p>
 * 同时给你一个长度为 26 的整数数组 weights，其中 weights[i] 表示第 i 个小写英文字母的权重。
 * <p>
 * 单词的 权重 定义为其所有字符权重的 总和。
 * <p>
 * 对于每个单词，将其权重对 26 取模，并将结果按字母倒序映射到一个小写英文字母（0 -> 'z', 1 -> 'y', ..., 25 -> 'a'）。
 * <p>
 * 返回一个由所有单词映射后的字符按顺序连接而成的字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： words = ["abcd","def","xyz"], weights = [5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2]
 * <p>
 * 输出： "rij"
 * <p>
 * 解释：
 * <p>
 * "abcd" 的权重是 5 + 3 + 12 + 14 = 34。对 26 取模的结果是 34 % 26 = 8，映射为 'r'。
 * "def" 的权重是 14 + 1 + 2 = 17。对 26 取模的结果是 17 % 26 = 17，映射为 'i'。
 * "xyz" 的权重是 7 + 7 + 2 = 16。对 26 取模的结果是 16 % 26 = 16，映射为 'j'。
 * 因此，连接映射字符后形成的字符串是 "rij"。
 * <p>
 * 示例 2：
 * <p>
 * 输入： words = ["a","b","c"], weights = [1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1]
 * <p>
 * 输出： "yyy"
 * <p>
 * 解释：
 * <p>
 * 每个单词的权重均为 1。对 26 取模的结果是 1 % 26 = 1，映射为 'y'。
 * <p>
 * 因此，连接映射字符后形成的字符串是 "yyy"。
 * <p>
 * 示例 3：
 * <p>
 * 输入： words = ["abcd"], weights = [7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5]
 * <p>
 * 输出： "g"
 * <p>
 * 解释：
 * <p>
 * "abcd" 的权重是 7 + 5 + 3 + 4 = 19。对 26 取模的结果是 19 % 26 = 19，映射为 'g'。
 * <p>
 * 因此，连接映射字符后形成的字符串是 "g"。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 10
 * weights.length == 26
 * 1 <= weights[i] <= 100
 * words[i] 仅由小写英文字母组成。
 */
public class Code12 {

    public String mapWordWeights(String[] words, int[] weights) {
        //字符串
        StringBuffer str = new StringBuffer();
        //循环
        for (String word : words) {
            //求和
            int sum = 0;
            //循环
            for (char letter : word.toCharArray()) {
                //叠加
                sum += weights[letter - 'a'];
            }
            //取余,倒序,转为本次字符串,叠加
            str.append((char) (25 - sum % 26 + 'a'));
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code12().mapWordWeights(
                new String[]{"abcd", "def", "xyz"},
                new int[]{5, 3, 12, 14, 1, 2, 3, 2, 10, 6, 6, 9, 7, 8, 7, 10, 8, 9, 6, 9, 9, 8, 3, 7, 7, 2}
        ));
    }

}
