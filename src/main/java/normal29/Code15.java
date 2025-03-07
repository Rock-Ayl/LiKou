package normal29;

/**
 * @Author ayl
 * @Date 2024-03-05
 * 2957. 消除相邻近似相等字符
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个下标从 0 开始的字符串 word 。
 * <p>
 * 一次操作中，你可以选择 word 中任意一个下标 i ，将 word[i] 修改成任意一个小写英文字母。
 * <p>
 * 请你返回消除 word 中所有相邻 近似相等 字符的 最少 操作次数。
 * <p>
 * 两个字符 a 和 b 如果满足 a == b 或者 a 和 b 在字母表中是相邻的，那么我们称它们是 近似相等 字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aaaaa"
 * 输出：2
 * 解释：我们将 word 变为 "acaca" ，该字符串没有相邻近似相等字符。
 * 消除 word 中所有相邻近似相等字符最少需要 2 次操作。
 * 示例 2：
 * <p>
 * 输入：word = "abddez"
 * 输出：2
 * 解释：我们将 word 变为 "ybdoez" ，该字符串没有相邻近似相等字符。
 * 消除 word 中所有相邻近似相等字符最少需要 2 次操作。
 * 示例 3：
 * <p>
 * 输入：word = "zyxyxyz"
 * 输出：3
 * 解释：我们将 word 变为 "zaxaxaz" ，该字符串没有相邻近似相等字符。
 * 消除 word 中所有相邻近似相等字符最少需要 3 次操作
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 100
 * word 只包含小写英文字母。
 */
public class Code15 {

    public int removeAlmostEqualCharacters(String word) {
        //次数
        int count = 0;
        //循环
        for (int i = 1; i < word.length(); i++) {
            //如果需要处理
            if (Math.abs(word.charAt(i - 1) - word.charAt(i)) < 2) {
                //+1
                count++;
                //跳过一次,因为修改本次,可以保证右边那个也不会相同
                i++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code15().removeAlmostEqualCharacters("acba"));
    }

}
