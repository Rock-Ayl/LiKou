package easy19;

/**
 * @Author ayl
 * @Date 2022-06-01
 * 2278. 字母在字符串中的百分比
 * 给你一个字符串 s 和一个字符 letter ，返回在 s 中等于 letter 字符所占的 百分比 ，向下取整到最接近的百分比。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "foobar", letter = "o"
 * 输出：33
 * 解释：
 * 等于字母 'o' 的字符在 s 中占到的百分比是 2 / 6 * 100% = 33% ，向下取整，所以返回 33 。
 * 示例 2：
 * <p>
 * 输入：s = "jjjj", letter = "k"
 * 输出：0
 * 解释：
 * 等于字母 'k' 的字符在 s 中占到的百分比是 0% ，所以返回 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 由小写英文字母组成
 * letter 是一个小写英文字母
 */
public class Code16 {

    public int percentageLetter(String s, char letter) {
        //总数
        int size = s.length();
        //个数
        int count = 0;
        //循环
        for (char c : s.toCharArray()) {
            //如果是
            if (c == letter) {
                //+1
                count++;
            }
        }
        //返回
        return count * 100 / size;
    }

    public static void main(String[] args) {
        System.out.println(new Code16().percentageLetter("foobar", 'o'));
    }


}
