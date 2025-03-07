package easy25;

/**
 * @Author ayl
 * @Date 2022-12-12
 * 6261. 数组中字符串的最大值
 * 一个由字母和数字组成的字符串的 值 定义如下：
 * <p>
 * 如果字符串 只 包含数字，那么值为该字符串在 10 进制下的所表示的数字。
 * 否则，值为字符串的 长度 。
 * 给你一个字符串数组 strs ，每个字符串都只由字母和数字组成，请你返回 strs 中字符串的 最大值 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：strs = ["alic3","bob","3","4","00000"]
 * 输出：5
 * 解释：
 * - "alic3" 包含字母和数字，所以值为长度 5 。
 * - "bob" 只包含字母，所以值为长度 3 。
 * - "3" 只包含数字，所以值为 3 。
 * - "4" 只包含数字，所以值为 4 。
 * - "00000" 只包含数字，所以值为 0 。
 * 所以最大的值为 5 ，是字符串 "alic3" 的值。
 * 示例 2：
 * <p>
 * 输入：strs = ["1","01","001","0001"]
 * 输出：1
 * 解释：
 * 数组中所有字符串的值都是 1 ，所以我们返回 1 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= strs.length <= 100
 * 1 <= strs[i].length <= 9
 * strs[i] 只包含小写英文字母和数字。
 */
public class Code14 {

    public int maximumValue(String[] strs) {
        //最大
        int max = 0;
        //跳出
        out:
        //循环
        for (String str : strs) {
            //初始化当前结果
            int num = 0;
            //循环
            for (char letter : str.toCharArray()) {
                //如果是数字
                if (letter <= 57 && letter >= 48) {
                    //继续叠加叠加数字
                    num = num * 10 + (letter - '0');
                } else {
                    //否则直接使用长度尝试判断最大
                    max = Math.max(max, str.length());
                    //跳出本轮
                    continue out;
                }
            }
            //使用数字
            max = Math.max(max, num);
        }
        //返回结果
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Code14().maximumValue(new String[]{"alic3", "bob", "3", "4", "00000"}));
    }

}
