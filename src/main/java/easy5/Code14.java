package easy5;

/**
 * Created By Rock-Ayl on 2021-01-14
 * 844. 比较含退格的字符串
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 你可以用 O(N) 的时间复杂度和 O(1) 的空间复杂度解决该问题吗？
 */
public class Code14 {

    public String optimize(String word) {
        //新单词
        StringBuffer newWord = new StringBuffer();
        //循环
        for (int i = 0; i < word.toCharArray().length; i++) {
            //获取当前字符
            char a = word.charAt(i);
            //根据类型操作
            switch (a) {
                case '#':
                    //如果还未到底
                    if (newWord.length() > 0) {
                        //删除最后一个
                        newWord.deleteCharAt(newWord.length() - 1);
                    }
                    break;
                default:
                    //累加
                    newWord.append(a);
                    break;
            }
        }
        //返回
        return newWord.toString();
    }

    public boolean backspaceCompare(String S, String T) {
        //优化
        String sWord = optimize(S);
        String tWord = optimize(T);
        //对比并返回
        return sWord.equals(tWord);
    }

    public static void main(String[] args) {
        System.out.println(new Code14().backspaceCompare("a##c", "#a#c"));
    }
}
