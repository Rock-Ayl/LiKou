package easy9;

/**
 * @Author 安永亮
 * @Date 2021-06-23
 * @Description 1903. 字符串中的最大奇数
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * <p>
 * 子字符串 是字符串中的一个连续的字符序列。
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "52"
 * 输出："5"
 * 解释：非空子字符串仅有 "5"、"2" 和 "52" 。"5" 是其中唯一的奇数。
 * 示例 2：
 * <p>
 * 输入：num = "4206"
 * 输出：""
 * 解释：在 "4206" 中不存在奇数。
 * 示例 3：
 * <p>
 * 输入：num = "35427"
 * 输出："35427"
 * 解释："35427" 本身就是一个奇数。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 105
 * num 仅由数字组成且不含前导零
 */
public class Code11 {

    public String largestOddNumber(String num) {
        //判空
        if (num.length() == 0) {
            //默认
            return "";
        }
        //从最后开始向前找
        for (int i = num.length() - 1; i >= 0; i--) {
            //如果当前位是奇数
            if ((num.charAt(i) - '0') % 2 != 0) {
                //返回
                return num.substring(0, i + 1);
            }
        }
        //结果
        return "";
    }

    public static void main(String[] args) {
        System.out.println(new Code11().largestOddNumber("354272"));
    }

}
