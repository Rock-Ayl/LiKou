package easy43;

/**
 * 2062. 统计字符串中的元音子字符串
 * 算术评级: 2
 * 第 266 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1458
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 子字符串 是字符串中的一个连续（非空）的字符序列。
 * <p>
 * 元音子字符串 是 仅 由元音（'a'、'e'、'i'、'o' 和 'u'）组成的一个子字符串，且必须包含 全部五种 元音。
 * <p>
 * 给你一个字符串 word ，统计并返回 word 中 元音子字符串的数目 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "aeiouu"
 * 输出：2
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "aeiouu"
 * - "aeiouu"
 * 示例 2：
 * <p>
 * 输入：word = "unicornarihan"
 * 输出：0
 * 解释：word 中不含 5 种元音，所以也不会存在元音子字符串。
 * 示例 3：
 * <p>
 * 输入：word = "cuaieuouac"
 * 输出：7
 * 解释：下面列出 word 中的元音子字符串（斜体加粗部分）：
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * - "cuaieuouac"
 * 示例 4：
 * <p>
 * 输入：word = "bbaeixoubb"
 * 输出：0
 * 解释：所有包含全部五种元音的子字符串都含有辅音，所以不存在元音子字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 100
 * word 仅由小写英文字母组成
 */
public class Code10 {

    public int countVowelSubstrings(String word) {
        //元音数组
        int[] vowelArr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //结果
        int result = 0;
        //循环
        for (int i = 0; i < word.length(); i++) {
            //计数器
            int[] countArr = new int[26];
            //元音数量
            int count = 0;
            //循环2
            for (int j = i; j < word.length(); j++) {
                //计算索引
                int index = word.charAt(j) - 'a';
                //如果不是元音
                if (vowelArr[index] == 0) {
                    //结束
                    break;
                }
                //计数,如果是第一次
                if (++countArr[index] == 1) {
                    //+1
                    count++;
                }
                //如果满足条件
                if (count == 5) {
                    //结果+1
                    result++;
                }
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code10().countVowelSubstrings("cuaieuouac"));
    }

}
