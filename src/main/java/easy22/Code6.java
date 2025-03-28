package easy22;

/**
 * @Author ayl
 * @Date 2022-08-25
 * 2325. 解密消息
 * 给你字符串 key 和 message ，分别表示一个加密密钥和一段加密消息。解密 message 的步骤如下：
 * <p>
 * 使用 key 中 26 个英文小写字母第一次出现的顺序作为替换表中的字母 顺序 。
 * 将替换表与普通英文字母表对齐，形成对照表。
 * 按照对照表 替换 message 中的每个字母。
 * 空格 ' ' 保持不变。
 * 例如，key = "happy boy"（实际的加密密钥会包含字母表中每个字母 至少一次），据此，可以得到部分对照表（'h' -> 'a'、'a' -> 'b'、'p' -> 'c'、'y' -> 'd'、'b' -> 'e'、'o' -> 'f'）。
 * 返回解密后的消息。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：key = "the quick brown fox jumps over the lazy dog", message = "vkbs bs t suepuv"
 * 输出："this is a secret"
 * 解释：对照表如上图所示。
 * 提取 "the quick brown fox jumps over the lazy dog" 中每个字母的首次出现可以得到替换表。
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：key = "eljuxhpwnyrdgtqkviszcfmabo", message = "zwx hnfx lqantp mnoeius ycgk vcnjrdb"
 * 输出："the five boxing wizards jump quickly"
 * 解释：对照表如上图所示。
 * 提取 "eljuxhpwnyrdgtqkviszcfmabo" 中每个字母的首次出现可以得到替换表。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 26 <= key.length <= 2000
 * key 由小写英文字母及 ' ' 组成
 * key 包含英文字母表中每个字符（'a' 到 'z'）至少一次
 * 1 <= message.length <= 2000
 * message 由小写英文字母和 ' ' 组成
 */
public class Code6 {

    public String decodeMessage(String key, String message) {
        //缓存
        int[] arr = new int[123];
        //缓存2
        int[] set = new int[123];
        //指针
        int p = 0;
        //循环
        for (int i = 0; i < key.length(); i++) {
            //当前
            char letter = key.charAt(i);
            //如果是空格
            if (letter == ' ') {
                //过
                continue;
            }
            //如果是第一次出现
            if (set[letter]++ == 0) {
                //记录
                arr[letter] = p++;
            }
        }
        //结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < message.length(); i++) {
            //当前
            char letter = message.charAt(i);
            //如果是空格
            if (letter == ' ') {
                //直接组装
                str.append(letter);
                //本轮过
                continue;
            }
            //解密
            str.append((char) (arr[letter] + 'a'));
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code6().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv"));
    }

}
