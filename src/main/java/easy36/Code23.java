package easy36;

/**
 * @Author ayl
 * @Date 2024-04-28
 * 3120. 统计特殊字母的数量 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word。如果 word 中同时存在某个字母的小写形式和大写形式，则称这个字母为 特殊字母 。
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
 * word 中的特殊字母是 'a'、'b' 和 'c'。
 * <p>
 * 示例 2:
 * <p>
 * 输入：word = "abc"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * word 中不存在大小写形式同时出现的字母。
 * <p>
 * 示例 3:
 * <p>
 * 输入：word = "abBCab"
 * <p>
 * 输出：1
 * <p>
 * 解释：
 * <p>
 * word 中唯一的特殊字母是 'b'。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 50
 * word 仅由小写和大写英文字母组成。
 */
public class Code23 {

    public int numberOfSpecialChars(String word) {
        //缓存
        int[] arr = new int[27];
        int[] arr2 = new int[27];
        //循环
        for (char letter : word.toCharArray()) {
            //如果是小写字符
            if (letter > 'Z') {
                //记录
                arr[letter - 'a']++;
            } else {
                //记录
                arr2[letter - 'A']++;
            }
        }
        //次数
        int count = 0;
        //循环
        for (int i = 0; i < arr.length; i++) {
            //如果满足
            if (arr[i] > 0 && arr2[i] > 0) {
                //+1
                count++;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println((byte) 'a');
        System.out.println((byte) 'z');
        System.out.println((byte) 'A');
        System.out.println((byte) 'Z');
        System.out.println(new Code23().numberOfSpecialChars("aaAbcBC"));
    }

}
