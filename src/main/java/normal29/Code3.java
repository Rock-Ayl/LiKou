package normal29;

/**
 * @Author ayl
 * @Date 2024-02-18
 * 2645. 构造有效字符串的最少插入数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
 * <p>
 * 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：word = "b"
 * 输出：2
 * 解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
 * 示例 2：
 * <p>
 * 输入：word = "aaa"
 * 输出：6
 * 解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
 * 示例 3：
 * <p>
 * 输入：word = "abc"
 * 输出：0
 * 解释：word 已经是有效字符串，不需要进行修改。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= word.length <= 50
 * word 仅由字母 "a"、"b" 和 "c" 组成。
 */
public class Code3 {

    public int addMinimum(String word) {
        //数字
        int count = 0;
        //跳出标记
        out:
        //循环
        for (int i = 0; i < word.length(); i++) {
            //当前字符
            char letter = word.charAt(i);
            //根据字符特殊处理
            switch (letter) {
                case 'a':

                    /**
                     * 判断接b or c
                     */

                    //如果到头了
                    if (i + 1 >= word.length()) {
                        //清算
                        count = count + 2;
                        //本轮过
                        continue out;
                    }
                    //判断下一个
                    switch (word.charAt(i+1)){
                        case 'a':

                            //清算
                            count = count + 2;
                            //本轮过
                            continue out;

                        case 'b':

                            //进位
                            i++;

                            /**
                             * 判断接c
                             */

                            //如果到头了
                            if (i + 1 >= word.length()) {
                                //清算
                                count = count + 1;
                                //本轮过
                                continue out;
                            }
                            //如果不能接c
                            if (word.charAt(i + 1) != 'c') {
                                //清算
                                count = count + 1;
                                //本轮过
                                continue out;
                            }

                            //进位
                            i++;


                            break;
                        case 'c':

                            //进位
                            i++;
                            //清算
                            count = count +1;
                            //本轮过
                            continue out;
                    }

                    break;
                case 'b':

                    //固定清算a
                    count++;

                    /**
                     * 判断接c
                     */

                    //如果到头了
                    if (i + 1 >= word.length()) {
                        //清算
                        count = count + 1;
                        //本轮过
                        continue;
                    }
                    //如果不能接c
                    if (word.charAt(i + 1) != 'c') {
                        //清算
                        count = count + 1;
                        //本轮过
                        continue;
                    }

                    //进位
                    i++;

                    break;
                case 'c':

                    /**
                     * 直接计算
                     */

                    //清算
                    count = count + 2;
                    break;
            }
        }
        //返回
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Code3().addMinimum("aaacca"));
    }

}
