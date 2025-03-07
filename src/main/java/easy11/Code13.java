package easy11;

/**
 * @Author ayl
 * @Date 2021-09-25
 * 1844. 将所有数字用字符替换
 * 给你一个下标从 0 开始的字符串 s ，它的 偶数 下标处为小写英文字母，奇数 下标处为数字。
 * <p>
 * 定义一个函数 shift(c, x) ，其中 c 是一个字符且 x 是一个数字，函数返回字母表中 c 后面第 x 个字符。
 * <p>
 * 比方说，shift('a', 5) = 'f' 和 shift('x', 0) = 'x' 。
 * 对于每个 奇数 下标 i ，你需要将数字 s[i] 用 shift(s[i-1], s[i]) 替换。
 * <p>
 * 请你替换所有数字以后，将字符串 s 返回。题目 保证 shift(s[i-1], s[i]) 不会超过 'z' 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "a1c1e1"
 * 输出："abcdef"
 * 解释：数字被替换结果如下：
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('c',1) = 'd'
 * - s[5] -> shift('e',1) = 'f'
 * 示例 2：
 * <p>
 * 输入：s = "a1b2c3d4e"
 * 输出："abbdcfdhe"
 * 解释：数字被替换结果如下：
 * - s[1] -> shift('a',1) = 'b'
 * - s[3] -> shift('b',2) = 'd'
 * - s[5] -> shift('c',3) = 'f'
 * - s[7] -> shift('d',4) = 'h'
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含小写英文字母和数字。
 * 对所有 奇数 下标处的 i ，满足 shift(s[i-1], s[i]) <= 'z' 。
 */
public class Code13 {

    public String replaceDigits(String s) {
        //初始化结果
        StringBuilder str = new StringBuilder();
        //转化
        char[] arr = s.toCharArray();
        //第一个直接写入
        str.append(arr[0]);
        //循环
        for (int i = 1; i < arr.length; i++) {
            //当前字符
            char space = arr[i];
            //如果是数字
            if (space > 47 && space < 58) {
                //计算并组装
                str.append((char) (byte) (((byte) arr[i - 1]) + (space - '0')));
            } else {
                //直接组装
                str.append(space);
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code13().replaceDigits("a3"));
    }
}
