package easy23;

/**
 * @Author ayl
 * @Date 2022-09-30
 * 476. 数字的补数
 * 对整数的二进制表示取反（0 变 1 ，1 变 0）后，再转换为十进制表示，可以得到这个整数的补数。
 * <p>
 * 例如，整数 5 的二进制表示是 "101" ，取反后得到 "010" ，再转回十进制表示得到补数 2 。
 * 给你一个整数 num ，输出它的补数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 5
 * 输出：2
 * 解释：5 的二进制表示为 101（没有前导零位），其补数为 010。所以你需要输出 2 。
 * 示例 2：
 * <p>
 * 输入：num = 1
 * 输出：0
 * 解释：1 的二进制表示为 1（没有前导零位），其补数为 0。所以你需要输出 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= num < 231
 * <p>
 * <p>
 * 注意：本题与 1009 https://leetcode-cn.com/problems/complement-of-base-10-integer/ 相同
 */
public class Code16 {

    public int findComplement(int num) {
        //转化为二进制
        String str = Integer.toBinaryString(num);
        //初始化补数
        StringBuilder other = new StringBuilder();
        //循环
        for (char c : str.toCharArray()) {
            //判断
            if (c == '0') {
                //组装
                other.append('1');
            } else {
                //组装
                other.append('0');
            }
        }
        //转化为10进制
        return Integer.parseInt(other.toString(), 2);
    }

    public static void main(String[] args) {
        System.out.println(new Code16().findComplement(5));
    }

}
