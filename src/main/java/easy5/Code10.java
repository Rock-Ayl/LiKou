package easy5;

/**
 * Created By Rock-Ayl on 2021-01-09
 * 1678. 设计 Goal 解析器
 * 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * <p>
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * <p>
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * <p>
 * 提示：
 * <p>
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */
public class Code10 {

    public static String interpret(String command) {
        //返回结果
        StringBuffer word = new StringBuffer();
        //转化为char[]
        char[] arr = command.toCharArray();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //单词
            char a = arr[i];
            //根据类型处理
            switch (a) {
                case 'G':
                    //组装
                    word.append("G");
                    break;
                case '(':
                    //如果到底了
                    if (i + 1 == arr.length) {
                        break;
                    }
                    //获取下一个char
                    char nextOne = arr[i + 1];
                    //根据类型处理
                    switch (nextOne) {
                        case ')':
                            //组装
                            word.append("o");
                            //i额外加一
                            i++;
                            break;
                        case 'a':
                            //如果越界了
                            if (i + 3 >= arr.length) {
                                break;
                            }
                            //获得后两位
                            char nextTwo = arr[i + 2], nextThree = arr[i + 3];
                            //如果满足条件
                            if (nextTwo == 'l' && nextThree == ')') {
                                //组装
                                word.append("al");
                                //i额外+3
                                i += 3;
                            }
                            break;
                    }
                    break;
            }
        }
        //返回
        return word.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()()()()(al)"));
    }
}
