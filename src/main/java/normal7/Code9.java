package normal7;

/**
 * @Author ayl
 * @Date 2021-09-07
 * 1410. HTML 实体解析器
 * 「HTML 实体解析器」 是一种特殊的解析器，它将 HTML 代码作为输入，并用字符本身替换掉所有这些特殊的字符实体。
 * <p>
 * HTML 里这些特殊字符和它们对应的字符实体包括：
 * <p>
 * 双引号：字符实体为 &quot; ，对应的字符是 " 。
 * 单引号：字符实体为 &apos; ，对应的字符是 ' 。
 * 与符号：字符实体为 &amp; ，对应对的字符是 & 。
 * 大于号：字符实体为 &gt; ，对应的字符是 > 。
 * 小于号：字符实体为 &lt; ，对应的字符是 < 。
 * 斜线号：字符实体为 &frasl; ，对应的字符是 / 。
 * 给你输入字符串 text ，请你实现一个 HTML 实体解析器，返回解析器解析后的结果。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：text = "&amp; is an HTML entity but &ambassador; is not."
 * 输出："& is an HTML entity but &ambassador; is not."
 * 解释：解析器把字符实体 &amp; 用 & 替换
 * 示例 2：
 * <p>
 * 输入：text = "and I quote: &quot;...&quot;"
 * 输出："and I quote: \"...\""
 * 示例 3：
 * <p>
 * 输入：text = "Stay home! Practice on Leetcode :)"
 * 输出："Stay home! Practice on Leetcode :)"
 * 示例 4：
 * <p>
 * 输入：text = "x &gt; y &amp;&amp; x &lt; y is always false"
 * 输出："x > y && x < y is always false"
 * 示例 5：
 * <p>
 * 输入：text = "leetcode.com&frasl;problemset&frasl;all"
 * 输出："leetcode.com/problemset/all"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= text.length <= 10^5
 * 字符串可能包含 256 个ASCII 字符中的任意字符。
 */
public class Code9 {

    public String entityParser(String text) {
        //结果
        StringBuffer result = new StringBuffer();
        //拆分
        char[] arr = text.toCharArray();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前
            char x = arr[i];
            //如果是&
            if (x == '&') {
                //初始化可转换空间
                StringBuffer space = new StringBuffer();
                space.append('&');
                //当前指针
                int p = i + 1;
                //如果
                while (space.length() < 3 && p < arr.length) {
                    //当前
                    char y = arr[p++];
                    //如果有新的
                    if (y == '&') {
                        //组装
                        result.append(space.toString());
                        space = new StringBuffer();
                        space.append('&');
                    } else {
                        //不断往上叠加
                        space.append(y);
                    }
                }
                //如果到头了
                if (p == arr.length) {
                    //组装
                    result.append(space);
                    //返回
                    return result.toString();
                }
                //组装
                space.append(arr[p]);
                //如果结尾了
                if (arr[p] == ';') {
                    //对比
                    if (space.toString().equals("&gt;")) {
                        //记录转换值
                        result.append(">");
                        //i变更
                        i = p;
                    } else if (space.toString().equals("&lt;")) {
                        //记录转换值
                        result.append("<");
                        //i变更
                        i = p;
                    } else {
                        result.append(space);
                        //i变更
                        i = p;
                    }
                } else {
                    //如果到头了
                    if (++p == arr.length) {
                        //组装
                        result.append(space);
                        //返回
                        return space.toString();
                    }
                    //组装下一个
                    space.append(arr[p]);
                    //如果是本次
                    if (space.toString().equals("&amp;")) {
                        //记录转换值
                        result.append("&");
                        //i变更
                        i = p;
                    } else {
                        //如果到头了
                        if (++p == arr.length) {
                            //组装
                            result.append(space);
                            //返回
                            return space.toString();
                        }
                        //组装下一个
                        space.append(arr[p]);
                        //对比
                        if (space.toString().equals("&quot;")) {
                            //记录转换值
                            result.append("\"");
                            //i变更
                            i = p;
                        } else if (space.toString().equals("&apos;")) {
                            //记录转换值
                            result.append("\'");
                            //i变更
                            i = p;
                        } else {
                            //如果到头了
                            if (++p == arr.length) {
                                //组装
                                result.append(space);
                                //返回
                                return result.toString();
                            }
                            //组装下一个
                            space.append(arr[p]);
                            //对比
                            if (space.toString().equals("&frasl;")) {
                                //记录转换值
                                result.append("/");
                                //i变更
                                i = p;
                            } else {
                                result.append(space);
                                //i变更
                                i = p;
                            }
                        }
                    }
                }
            } else {
                //组装
                result.append(x);
            }
        }
        //返回
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code9().entityParser("&&&amp&&"));
    }

}
