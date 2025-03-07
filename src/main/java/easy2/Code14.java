package easy2;

/**
 * Created By Rock-Ayl on 2020-10-03
 * 258. 各位相加
 * 给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 * <p>
 * 示例:
 * <p>
 * 输入: 38
 * 输出: 2
 * 解释: 各位相加的过程为：3 + 8 = 11, 1 + 1 = 2。 由于 2 是一位数，所以返回 2。
 */
public class Code14 {

    public static int addDigits(int num) {
        //转为String
        String str = num + "";
        //如果是1位
        while (str.length() == 1) {
            //直接返回
            return num;
        }
        //和
        int sum = 0;
        //循环
        for (char c : str.toCharArray()) {
            //获取数
            int x = Integer.parseInt(c + "");
            //相加
            sum = x + sum;
        }
        //递归返回
        return addDigits(sum);
    }

    public static void main(String[] args) {
        System.out.println(addDigits(38));
    }
}
