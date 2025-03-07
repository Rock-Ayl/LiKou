package easy9;

/**
 * @Author 安永亮
 * @Date 2021-06-18
 * @Description 1816. 截断句子
 * 句子 是一个单词列表，列表中的单词之间用单个空格隔开，且不存在前导或尾随空格。每个单词仅由大小写英文字母组成（不含标点符号）。
 * <p>
 * 例如，"Hello World"、"HELLO" 和 "hello world hello world" 都是句子。
 * 给你一个句子 s​​​​​​ 和一个整数 k​​​​​​ ，请你将 s​​ 截断 ​，​​​使截断后的句子仅含 前 k​​​​​​ 个单词。返回 截断 s​​​​​​ 后得到的句子。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "Hello how are you Contestant", k = 4
 * 输出："Hello how are you"
 * 解释：
 * s 中的单词为 ["Hello", "how" "are", "you", "Contestant"]
 * 前 4 个单词为 ["Hello", "how", "are", "you"]
 * 因此，应当返回 "Hello how are you"
 * 示例 2：
 * <p>
 * 输入：s = "What is the solution to this problem", k = 4
 * 输出："What is the solution"
 * 解释：
 * s 中的单词为 ["What", "is" "the", "solution", "to", "this", "problem"]
 * 前 4 个单词为 ["What", "is", "the", "solution"]
 * 因此，应当返回 "What is the solution"
 * 示例 3：
 * <p>
 * 输入：s = "chopper is not a tanuki", k = 5
 * 输出："chopper is not a tanuki"
 */
public class Code6 {

    public String truncateSentence(String s, int k) {
        //总共有多少个单词了
        int words = 0;
        //当前字符
        int p = 0;
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前字符
            char space = s.charAt(i);
            //如果不是空格
            if (space != ' ') {
                //计算为字符
                p++;
            } else {
                //如果有单词
                if (p > 0) {
                    //记录
                    words++;
                    //如果到目标长度了
                    if (words == k) {
                        //返回结果
                        return s.substring(0, i);
                    }
                    //重置
                    p = 0;
                }
            }
        }
        //默认
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Code6().truncateSentence("What is the solution to this problem", 5));
    }

}
