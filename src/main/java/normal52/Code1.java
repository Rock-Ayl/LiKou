package normal52;

/**
 * 101035. 镜像频次距离
 * 同步题目状态
 * <p>
 * 中等
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母和数字组成的字符串 s。
 * <p>
 * 对于每个字符，其 镜像字符 根据逆序定义其字符集合：
 * <p>
 * 对于字母，某字符的镜像字符是字母表中从末尾与其位置相同的字母。
 * 例如，'a' 的镜像字符是 'z'，'b' 的镜像字符是 'y'，以此类推。
 * 对于数字，某字符的镜像字符是范围 '0' 到 '9' 中从末尾与其位置相同的数字。
 * 例如，'0' 的镜像字符是 '9'，'1' 的镜像字符是 '8'，以此类推。
 * 对于字符串中每个 唯一 字符 c：
 * <p>
 * 设 m 为其 镜像字符 。
 * 设 freq(x) 表示字符 x 在字符串中出现的次数。
 * 计算其与镜像字符出现次数之间的 绝对差，定义为：|freq(c) - freq(m)|
 * 镜像对 (c, m) 和 (m, c) 被视为相同，只能被计算 一次 。
 * <p>
 * 返回一个整数，表示所有这些 不同的镜像对 的绝对差之和。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "ab1z9"
 * <p>
 * 输出： 3
 * <p>
 * 解释：
 * <p>
 * 对于每个镜像对：
 * <p>
 * c	m	freq(c)	freq(m)	|freq(c) - freq(m)|
 * a	z	1	1	0
 * b	y	1	0	1
 * 1	8	1	0	1
 * 9	0	1	0	1
 * 因此，答案是 0 + 1 + 1 + 1 = 3。
 * <p>
 * 示例 2：
 * <p>
 * 输入： s = "4m7n"
 * <p>
 * 输出： 2
 * <p>
 * 解释：
 * <p>
 * c	m	freq(c)	freq(m)	|freq(c) - freq(m)|
 * 4	5	1	0	1
 * m	n	1	1	0
 * 7	2	1	0	1
 * 因此，答案是 1 + 0 + 1 = 2。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "byby"
 * <p>
 * 输出：0
 * <p>
 * 解释：
 * <p>
 * c	m	freq(c)	freq(m)	|freq(c) - freq(m)|
 * b	y	2	2	0
 * 因此，答案是 0 。
 * <p>
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= s.length <= 5 * 105
 * s 仅由小写英文字母和数字组成。
 *
 */
public class Code1 {

    public int mirrorFrequency(String s) {
        //计数器缓存
        int[] arr = new int[123];
        //循环
        for (char letter : s.toCharArray()) {
            //+1
            arr[letter]++;
        }
        //结果
        int result = 0;
        //循环
        for (char letter : s.toCharArray()) {
            //计算另一个
            char another = anotherKey(letter);
            //叠加本次
            result += Math.abs(arr[letter] - arr[another]);
            //删除
            arr[letter] = 0;
            arr[another] = 0;
        }
        //返回
        return result;
    }

    //计算另一个key
    private char anotherKey(char c) {
        //如果是字母
        if (c >= 'a' && c <= 'z') {
            //返回
            return (char) ('z' - (c - 'a'));
        }
        //如果是数字
        if (c >= '0' && c <= '9') {
            //返回
            return (char) ('9' - (c - '0'));
        }
        //默认
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Code1().mirrorFrequency("ab1z9"));
        ;
    }

}