package easy11;

/**
 * @Author ayl
 * @Date 2021-08-22
 * 1957. 删除字符使字符串变好
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * <p>
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * <p>
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leeetcode"
 * 输出："leetcode"
 * 解释：
 * 从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
 * 没有连续三个相同字符，所以返回 "leetcode" 。
 * 示例 2：
 * <p>
 * 输入：s = "aaabaaaa"
 * 输出："aabaa"
 * 解释：
 * 从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
 * 从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
 * 没有连续三个相同字符，所以返回 "aabaa" 。
 * 示例 3：
 * <p>
 * 输入：s = "aab"
 * 输出："aab"
 * 解释：没有连续三个相同字符，所以返回 "aab" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 */
public class Code5 {

    public String makeFancyString(String s) {
        //结果
        StringBuffer str = new StringBuffer();
        //初始化条件
        char last = s.charAt(0);
        int size = 1;
        str.append(last);
        //转为数组
        char[] arr = s.toCharArray();
        //循环
        for (int i = 1; i < arr.length; i++) {
            //当前
            char x = arr[i];
            //如果不是
            if (x != last) {
                //组装
                str.append(x);
                //刷新
                size = 1;
                last = x;
            } else {
                //如果可以重复
                if (size < 2) {
                    //组装
                    str.append(x);
                    //刷新
                    size++;
                }
            }
        }
        //返回结果
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code5().makeFancyString("aaabaaaa"));
    }

}
