package easy42;

/**
 * 3823. 反转一个字符串里的字母后反转特殊字符
 * 同步题目状态
 * <p>
 * 简单
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个由小写英文字母和特殊字符组成的字符串 s。
 * <p>
 * 你的任务是 按顺序 执行以下操作：
 * <p>
 * 反转小写字母，并将它们放回原来字母所占据的位置。
 * 反转特殊字符，并将它们放回原来特殊字符所占据的位置。
 * 返回执行反转操作后的结果字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = ")ebc#da@f("
 * <p>
 * 输出： "(fad@cb#e)"
 * <p>
 * 解释：
 * <p>
 * 字符串中的字母为 ['e', 'b', 'c', 'd', 'a', 'f']：
 * 反转它们得到 ['f', 'a', 'd', 'c', 'b', 'e']
 * s 变为 ")fad#cb@e("
 * 字符串中的特殊字符为 [')', '#', '@', '(']：
 * 反转它们得到 ['(', '@', '#', ')']
 * s 变为 "(fad@cb#e)"
 * 示例 2：
 * <p>
 * 输入： s = "z"
 * <p>
 * 输出： "z"
 * <p>
 * 解释：
 * <p>
 * 字符串仅包含一个字母，反转它不会改变字符串。没有特殊字符。
 * <p>
 * 示例 3：
 * <p>
 * 输入： s = "!@#$%^&*()"
 * <p>
 * 输出： ")(*&^%$#@!"
 * <p>
 * 解释：
 * <p>
 * 字符串不包含字母。字符串全部由特殊字符组成，因此反转特殊字符即反转整个字符串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 仅由小写英文字母和 "!@#$%^&*()" 中的特殊字符组成。
 */
public class Code7 {

    public String reverseByType(String s) {
        //两种情况缓存
        char[] oneArr = new char[s.length()];
        char[] twoArr = new char[s.length()];
        //索引
        int oneIndex = 0;
        int twoIndex = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char letter = s.charAt(i);
            //如果是字母
            if (letter >= 'a' && letter <= 'z') {
                //记录
                oneArr[oneIndex++] = letter;
            } else {
                //记录
                twoArr[twoIndex++] = letter;
            }
        }
        //字符串
        StringBuffer str = new StringBuffer();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char letter = s.charAt(i);
            //如果是字母
            if (letter >= 'a' && letter <= 'z') {
                //添加
                str.append(oneArr[--oneIndex]);
            } else {
                //添加
                str.append(twoArr[--twoIndex]);
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code7().reverseByType(")ebc#da@f("));
    }

}
