package easy21;

/**
 * @Author ayl
 * @Date 2022-07-21
 * 1047. 删除字符串中的所有相邻重复项
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * <p>
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * <p>
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class Code10 {

    public String removeDuplicates(String s) {
        //初始化str,模拟栈
        StringBuilder result = new StringBuilder();
        //循环
        for (char c : s.toCharArray()) {
            //如果栈不为空 并且 当前与上一个相同
            if (result.length() > 0 && result.charAt(result.length() - 1) == c) {
                //删除上一个
                result.deleteCharAt(result.length() - 1);
                //本轮过
                continue;
            }
            //默认push
            result.append(c);
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code10().removeDuplicates("abbaca"));
    }

}
