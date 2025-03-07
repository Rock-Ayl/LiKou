package normal;

/**
 * Created By Rock-Ayl on 2021-03-22
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 * <p>
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 * <p>
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 * <p>
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 * <p>
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num <= 3999
 */
public class Code17 {

    public static String intToRoman(int num) {
        //结果
        StringBuffer result = new StringBuffer();
        //千
        int thousand = num / 1000;
        //如果有千位
        if (thousand > 0) {
            //循环
            while (thousand > 0) {
                //组装
                result.append("M");
                //递减
                thousand--;
            }
            //取出剩下的
            num = num % 1000;
        }
        //百
        int hundred = num / 100;
        //如果有百位
        if (hundred > 0) {
            //如果是标准
            if (hundred == 4) {
                //组装
                result.append("CD");
            } else if (hundred == 9) {
                //组装
                result.append("CM");
            } else {
                //如果大于5
                if (hundred >= 5) {
                    //实现
                    hundred = hundred - 5;
                    //组装
                    result.append("D");
                }
                //循环
                while (hundred > 0) {
                    //组装
                    result.append("C");
                    //递减
                    hundred--;
                }
            }
            //取出剩下的
            num = num % 100;
        }
        //十
        int ten = num / 10;
        //如果有十位
        if (ten > 0) {
            //如果是标准
            if (ten == 4) {
                //组装
                result.append("XL");
            } else if (ten == 9) {
                //组装
                result.append("XC");
            } else {
                //如果大于5
                if (ten >= 5) {
                    //实现
                    ten = ten - 5;
                    //组装
                    result.append("L");
                }
                //循环
                while (ten > 0) {
                    //组装
                    result.append("X");
                    //递减
                    ten--;
                }
            }
            //取出剩下的
            num = num % 10;
        }
        //个位
        if (num > 0) {
            //如果是标准
            if (num == 4) {
                //组装
                result.append("IV");
            } else if (num == 9) {
                //组装
                result.append("IX");
            } else {
                //如果大于5
                if (num >= 5) {
                    //实现
                    num = num - 5;
                    //组装
                    result.append("V");
                }
                //循环
                while (num > 0) {
                    //组装
                    result.append("I");
                    //递减
                    num--;
                }
            }
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(3999));
    }
}
