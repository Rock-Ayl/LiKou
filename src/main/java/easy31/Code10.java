package easy31;

/**
 * @Author ayl
 * @Date 2023-06-01
 * 2710. 移除字符串中的尾随零
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = "51230100"
 * 输出："512301"
 * 解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
 * 示例 2：
 * <p>
 * 输入：num = "123"
 * 输出："123"
 * 解释：整数 "123" 不含尾随零，返回整数 "123" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num.length <= 1000
 * num 仅由数字 0 到 9 组成
 * num 不含前导零
 */
public class Code10 {

    public String removeTrailingZeros(String num) {
        //指针
        int lastZero = num.length() - 1;
        //如果最后一个不是0
        if (num.charAt(lastZero) != '0') {
            //本身
            return num;
        }
        //如果还有0
        while (num.charAt(lastZero - 1) == '0') {
            //-1
            lastZero--;
        }
        //实现
        return num.substring(0, lastZero);
    }

    public static void main(String[] args) {
        System.out.println(new Code10().removeTrailingZeros("31514216007864075756059111751787923413952537015859352242147727420"));
    }
}
