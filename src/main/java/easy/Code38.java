package easy;

/**
 * Created By Rock-Ayl on 2020-09-18
 * LCP 17. 速算机器人
 * 小扣在秋日市集发现了一款速算机器人。店家对机器人说出两个数字（记作 x 和 y），请小扣说出计算指令：
 * <p>
 * "A" 运算：使 x = 2 * x + y；
 * "B" 运算：使 y = 2 * y + x。
 * 在本次游戏中，店家说出的数字为 x = 1 和 y = 0，小扣说出的计算指令记作仅由大写字母 A、B 组成的字符串 s，字符串中字符的顺序表示计算顺序，请返回最终 x 与 y 的和为多少。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "AB"
 * <p>
 * 输出：4
 * <p>
 * 解释：
 * 经过一次 A 运算后，x = 2, y = 0。
 * 再经过一次 B 运算，x = 2, y = 2。
 * 最终 x 与 y 之和为 4。
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 10
 * s 由 'A' 和 'B' 组成
 */
public class Code38 {

    public static int calculate(String s) {
        //店家说出的数字
        int x = 1, y = 0;
        //循环
        for (char c : s.toCharArray()) {
            //转成String
            String thisMath = c + "";
            //运算
            switch (thisMath) {
                case "A":
                    x = 2 * x + y;
                    break;
                case "B":
                    y = 2 * y + x;
                    break;
            }
        }
        //返回二者之和
        return (x + y);
    }

    public static void main(String[] args) {
        System.out.println(calculate("AB"));
    }
}
