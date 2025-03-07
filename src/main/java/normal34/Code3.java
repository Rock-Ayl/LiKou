package normal34;

/**
 * @Author ayl
 * @Date 2024-08-08
 * 3228. 将 1 移动到末尾的最大操作次数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个
 * 二进制字符串
 * s。
 * <p>
 * 你可以对这个字符串执行 任意次 下述操作：
 * <p>
 * 选择字符串中的任一下标 i（ i + 1 < s.length ），该下标满足 s[i] == '1' 且 s[i + 1] == '0'。
 * 将字符 s[i] 向 右移 直到它到达字符串的末端或另一个 '1'。例如，对于 s = "010010"，如果我们选择 i = 1，结果字符串将会是 s = "000110"。
 * 返回你能执行的 最大 操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "1001101"
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 可以执行以下操作：
 * <p>
 * 选择下标 i = 0。结果字符串为 s = "0011101"。
 * 选择下标 i = 4。结果字符串为 s = "0011011"。
 * 选择下标 i = 3。结果字符串为 s = "0010111"。
 * 选择下标 i = 2。结果字符串为 s = "0001111"。
 * 示例 2：
 * <p>
 * 输入： s = "00111"
 * <p>
 * 输出： 0
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'。
 */
public class Code3 {

    public int maxOperations(String s) {
        //执行次数
        int count = 0;
        //1的连击次数
        int hitOne = 0;
        //上一个字符,默认1
        char lastLetter = '1';
        //循环
        for (int i = 0; i < s.length(); i++) {
            //获取字符
            char letter = s.charAt(i);
            //如果当前是0 and 上一个也是0
            if (letter == '0' && lastLetter == '0') {
                //本轮过
                continue;
            }
            //如果是1
            if (letter == '1') {
                //记录连击次数
                hitOne++;
            } else {
                //之前的1统统移动
                count += hitOne;
            }
            //记录本次字符
            lastLetter = letter;
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().maxOperations("1001101"));
    }

}
