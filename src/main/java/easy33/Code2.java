package easy33;

/**
 * @Author ayl
 * @Date 2023-08-24
 * LCR 002. 二进制求和
 * 简单
 * 76
 * 相关企业
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * <p>
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "10"
 * 输出: "101"
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 * <p>
 * <p>
 * 注意：本题与主站 67 题相同：https://leetcode-cn.com/problems/add-binary/
 */
public class Code2 {

    public void add(StringBuilder str, String a, String b, int p1, int p2, int other) {
        //如果到头了
        if (p1 < 0 && p2 < 0) {
            //如果有进位
            if (other == 1) {
                //额外加1
                str.append(1);
            }
            //结束
            return;
        }
        //当前
        int one;
        int two;
        //如果越界
        if (p1 < 0) {
            //默认
            one = 0;
        } else {
            //获取
            one = a.charAt(p1) - '0';
        }
        //如果越界
        if (p2 < 0) {
            //默认
            two = 0;
        } else {
            //获取
            two = b.charAt(p2) - '0';
        }
        //计算和
        int number = one + two + other;
        //下一个进位
        int nextOther = 0;
        //如果有进位
        if (number > 1) {
            //进位
            nextOther = 1;
            number -= 2;
        }
        //记录
        str.append(number);
        //递归
        add(str, a, b, p1 - 1, p2 - 1, nextOther);
    }

    public String addBinary(String a, String b) {
        //默认
        if ("0".equals(a)) {
            //过
            return b;
        }
        //默认
        if ("0".equals(b)) {
            //过
            return a;
        }
        //初始化结果
        StringBuilder str = new StringBuilder();
        //递归
        add(str, a, b, a.length() - 1, b.length() - 1, 0);
        //递归s
        return str.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code2().addBinary("1010", "1011"));
    }

}
