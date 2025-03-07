package normal40;

import java.util.Arrays;

/**
 * @Author ayl
 * @Date 2025-02-23
 * 3121. 统计特殊字母的数量 II
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
 * <p>
 * 返回 word 中 特殊字母 的数量。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：word = "aaAbcBC"
 * <p>
 * 输出：3
 * <p>
 * 解释：
 * <p>
 * 特殊字母是 'a'、'b' 和 'c'。
 * <p>
 * 示例 2:
 * <p>
 * 输入：word = "abc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在特殊字母。
 * <p>
 * 示例 3:
 * <p>
 * 输入：word = "AbBCab"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在特殊字母。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 2 * 105
 * word 仅由小写和大写英文字母组成。
 */
public class Code11 {

    public int numberOfSpecialChars(String word) {
        //大小写缓存
        int[] bigArr = new int[26];
        int[] smallArr = new int[26];
        //最终结果
        int[] resultArr = new int[26];
        //循环
        for (int i = 0; i < word.length(); i++) {
            //获取字符
            char letter = word.charAt(i);
            //如果是小写字母
            if (letter >= 'a' && letter <= 'z') {
                //转为key
                int key = letter - 'a';
                //+1
                ++smallArr[key];
                //如果之前出现了大写
                if (bigArr[key] > 0) {
                    //有结果也肯定没有结果了
                    resultArr[key] = 0;
                }
            }
            //如果是大写字母
            else {
                //转为key
                int key = letter - 'A';
                //+1,如果是第一次出现 and 如果有小写在前
                if (++bigArr[key] == 1 && smallArr[key] > 0) {
                    //视为结果
                    resultArr[key] = 1;
                }
            }
        }
        //最总结果求和
        return Arrays.stream(resultArr).sum();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().numberOfSpecialChars("AbBCab"));
    }

}
