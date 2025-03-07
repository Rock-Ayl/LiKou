package easy27;

/**
 * @Author ayl
 * @Date 2023-01-24
 * 2544. 交替数字和
 * 给你一个正整数 n 。n 中的每一位数字都会按下述规则分配一个符号：
 * <p>
 * 最高有效位 上的数字分配到 正 号。
 * 剩余每位上数字的符号都与其相邻数字相反。
 * 返回所有数字及其对应符号的和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：n = 521
 * 输出：4
 * 解释：(+5) + (-2) + (+1) = 4
 * 示例 2：
 * <p>
 * 输入：n = 111
 * 输出：1
 * 解释：(+1) + (-1) + (+1) = 1
 * 示例 3：
 * <p>
 * 输入：n = 886996
 * 输出：0
 * 解释：(+8) + (-8) + (+6) + (-9) + (+9) + (-6) = 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= n <= 109
 */
public class Code6 {

    public int alternateDigitSum(int n) {
        //和
        int sum = 0;
        //是否为正
        boolean plus = true;
        //代表正副位数
        int count = 0;
        //循环
        while (n > 0) {
            //如果是正
            if (plus) {
                //叠加
                sum += n % 10;
            } else {
                //递减
                sum -= n % 10;
            }
            //下一个
            n = n / 10;
            //符号反转
            plus = !plus;
            //记录
            count++;
        }
        //如果应该镜面
        if (count % 2 == 0) {
            //反转
            sum = sum * -1;
        }
        //返回结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().alternateDigitSum(886996));
    }

}
