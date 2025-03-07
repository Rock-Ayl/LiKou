package easy38;

/**
 * @Author ayl
 * @Date 2024-10-05
 * 3304. 找出第 K 个字符 I
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * Alice 和 Bob 正在玩一个游戏。最初，Alice 有一个字符串 word = "a"。
 * <p>
 * 给定一个正整数 k。
 * <p>
 * 现在 Bob 会要求 Alice 执行以下操作 无限次 :
 * <p>
 * 将 word 中的每个字符 更改 为英文字母表中的 下一个 字符来生成一个新字符串，并将其 追加 到原始的 word。
 * 例如，对 "c" 进行操作生成 "cd"，对 "zb" 进行操作生成 "zbac"。
 * <p>
 * 在执行足够多的操作后， word 中 至少 存在 k 个字符，此时返回 word 中第 k 个字符的值。
 * <p>
 * 注意，在操作中字符 'z' 可以变成 'a'。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入：k = 5
 * <p>
 * 输出："b"
 * <p>
 * 解释：
 * <p>
 * 最初，word = "a"。需要进行三次操作:
 * <p>
 * 生成的字符串是 "b"，word 变为 "ab"。
 * 生成的字符串是 "bc"，word 变为 "abbc"。
 * 生成的字符串是 "bccd"，word 变为 "abbcbccd"。
 * 示例 2:
 * <p>
 * 输入：k = 10
 * <p>
 * 输出："c"
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= k <= 500
 */
public class Code15 {

    //计算下一个字符
    private char next(char letter) {
        //如果是
        if (letter == 'z') {
            //重铸
            return 'a';
        } else {
            //返回
            return (char) (letter + 1);
        }
    }

    public char kthCharacter(int k) {
        //指定位数
        StringBuilder str = new StringBuilder("a");
        //如果不够
        while (str.length() < k) {
            //初始化
            StringBuilder newStr = new StringBuilder();
            //循环
            for (int i = 0; i < str.length(); i++) {
                //获取当前字符,转化为下一个字符
                newStr.append(next(str.charAt(i)));
            }
            //组装本次
            str.append(newStr);
        }
        //返回
        return str.charAt(k - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Code15().kthCharacter(5));
    }

}
