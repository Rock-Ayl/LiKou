package easy42;

/**
 * 3813. 元音辅音得分
 * 算术评级: 2
 * 第 485 场周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1216
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s，由小写英文字母、空格和数字组成。
 * <p>
 * 令 v 表示 s 中元音字母的数量，c 表示辅音字母的数量。
 * <p>
 * 元音字母是 'a'、'e'、'i'、'o' 和 'u'，而英文字母表中除元音外的其他字母均视为辅音字母。
 * <p>
 * 字符串 s 的 得分 定义如下：
 * <p>
 * 如果 c > 0，则 score = floor(v / c)，其中 floor 表示 向下取整 到最接近的整数。
 * 否则，如果 c = 0，则 score = 0。
 * 返回一个整数，表示字符串的得分。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: s = "cooear"
 * <p>
 * 输出: 2
 * <p>
 * 解释:
 * <p>
 * 字符串 s = "cooear" 包含 v = 4 个元音字母 ('o', 'o', 'e', 'a') 和 c = 2 个辅音字母 ('c', 'r')。
 * <p>
 * 得分为 floor(v / c) = floor(4 / 2) = 2。
 * <p>
 * 示例 2：
 * <p>
 * 输入: s = "axeyizou"
 * <p>
 * 输出: 1
 * <p>
 * 解释:
 * <p>
 * 字符串 s = "axeyizou" 包含 v = 5 个元音字母 ('a', 'e', 'i', 'o', 'u') 和 c = 3 个辅音字母 ('x', 'y', 'z')。
 * <p>
 * 得分为 floor(v / c) = floor(5 / 3) = 1。
 * <p>
 * 示例 3：
 * <p>
 * 输入: s = "au 123"
 * <p>
 * 输出: 0
 * <p>
 * 解释:
 * <p>
 * 字符串 s = "au 123" 不包含辅音字母 (c = 0)，因此得分为 0。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由小写英文字母、空格和数字组成。
 */
public class Code5 {

    public int vowelConsonantScore(String s) {
        //元音数组
        int[] arr = new int[]{1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0};
        //计数器
        int left = 0;
        int right = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符串
            char letter = s.charAt(i);
            //空格
            if (letter == ' ') {
                //本轮过
                continue;
            }
            //转为数字
            int num = letter - '0';
            //如果是数字
            if (num >= 0 && num <= 9) {
                //本轮过
                continue;
            }
            //索引
            int index = letter - 'a';
            //如果是元音
            if (arr[index] == 1) {
                //+1
                left++;
            } else {
                //+1
                right++;
            }
        }
        //如果没有辅音
        if (right == 0) {
            //过
            return 0;
        }
        //结果
        return left / right;
    }

    public static void main(String[] args) {
        System.out.println(new Code5().vowelConsonantScore("axeyizou"));
    }

}
