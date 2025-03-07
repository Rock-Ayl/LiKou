package normal4;

/**
 * Created By Rock-Ayl on 2021-05-25
 * 984. 不含 AAA 或 BBB 的字符串
 * 给定两个整数 A 和 B，返回任意字符串 S，要求满足：
 * <p>
 * S 的长度为 A + B，且正好包含 A 个 'a' 字母与 B 个 'b' 字母；
 * 子串 'aaa' 没有出现在 S 中；
 * 子串 'bbb' 没有出现在 S 中。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：A = 1, B = 2
 * 输出："abb"
 * 解释："abb", "bab" 和 "bba" 都是正确答案。
 * 示例 2：
 * <p>
 * 输入：A = 4, B = 1
 * 输出："aabaa"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= A <= 100
 * 0 <= B <= 100
 * 对于给定的 A 和 B，保证存在满足要求的 S。
 */
public class Code11 {

    public String strWithout3a3b(int a, int b) {
        //结果
        StringBuilder str = new StringBuilder();
        //先一起玩
        while (a > 0 && b > 0) {
            //如果a比b大
            if (a > b) {
                //组装
                str.append("aab");
                //计算
                a -= 2;
                b--;
            } else if (a == b) {
                //组装
                str.append("ab");
                //计算
                a--;
                b--;
            } else {
                //组装
                str.append("bba");
                //计算
                a--;
                b -= 2;
            }
        }
        //循环
        while (a > 0) {
            //组装
            str.append("a");
            //计算
            a--;
        }
        //循环
        while (b > 0) {
            //组装
            str.append("b");
            //计算
            b--;
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code11().strWithout3a3b(4, 1));
    }

}
