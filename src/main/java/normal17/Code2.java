package normal17;

/**
 * @Author ayl
 * @Date 2022-11-03
 * 394. 字符串解码
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * <p>
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * <p>
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * <p>
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 * 示例 2：
 * <p>
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 * 示例 3：
 * <p>
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 * 示例 4：
 * <p>
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 30
 * s 由小写英文字母、数字和方括号 '[]' 组成
 * s 保证是一个 有效 的输入。
 * s 中所有整数的取值范围为 [1, 300]
 */
public class Code2 {

    public String decodeString(String s) {
        //初始化结果
        StringBuilder str = new StringBuilder();
        //指针
        int start = 0;
        //循环
        while (start < s.length()) {
            //当前
            char x = s.charAt(start);
            //如果是字母
            if (x >= 97 && x <= 122) {
                //直接组装
                str.append(x);
                //进位
                start++;
                //本轮结束
                continue;
            }
            //如果是数字,代表开始重复了
            if (x >= 48 && x <= 57) {
                //最开始的数字
                int num = x - '0';
                //右边坐标
                int end = start + 1;
                //如果是数字
                while (s.charAt(end) != '[') {
                    //叠加数字、进位
                    num = num * 10 + (s.charAt(end++) - '0');
                }
                //数字后的开始位置
                int mid = ++end;
                //开始连击,默认1
                int hit = 1;
                //循环找结尾
                while (hit != 0) {
                    //判断是+还是-
                    if (s.charAt(end) == ']') {
                        hit--;
                        //如果是0
                        if (hit == 0) {
                            //结束
                            break;
                        }
                    } else if (s.charAt(end) == '[') {
                        hit++;
                    }
                    //进位
                    end++;
                }
                //中间的部分
                String center = s.substring(mid, end);
                //先递归中间的部分
                String decodeCenter = decodeString(center);
                //循环
                while (num-- > 0) {
                    //组装
                    str.append(decodeCenter);
                }
                //结束本次判定
                start = end + 1;
            }
        }
        //返回该结果
        return str.toString();
    }

    public static void main(String[] args) {

        System.out.println(new Code2().decodeString("3[a2[c]]"));
    }

}
