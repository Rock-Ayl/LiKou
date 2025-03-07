package normal7;

import java.util.*;

/**
 * @Author ayl
 * @Date 2021-09-09
 * 1807. 替换字符串中的括号内容
 * 给你一个字符串 s ，它包含一些括号对，每个括号中包含一个 非空 的键。
 * <p>
 * 比方说，字符串 "(name)is(age)yearsold" 中，有 两个 括号对，分别包含键 "name" 和 "age" 。
 * 你知道许多键对应的值，这些关系由二维字符串数组 knowledge 表示，其中 knowledge[i] = [keyi, valuei] ，表示键 keyi 对应的值为 valuei 。
 * <p>
 * 你需要替换 所有 的括号对。当你替换一个括号对，且它包含的键为 keyi 时，你需要：
 * <p>
 * 将 keyi 和括号用对应的值 valuei 替换。
 * 如果从 knowledge 中无法得知某个键对应的值，你需要将 keyi 和括号用问号 "?" 替换（不需要引号）。
 * knowledge 中每个键最多只会出现一次。s 中不会有嵌套的括号。
 * <p>
 * 请你返回替换 所有 括号对后的结果字符串。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
 * 输出："bobistwoyearsold"
 * 解释：
 * 键 "name" 对应的值为 "bob" ，所以将 "(name)" 替换为 "bob" 。
 * 键 "age" 对应的值为 "two" ，所以将 "(age)" 替换为 "two" 。
 * 示例 2：
 * <p>
 * 输入：s = "hi(name)", knowledge = [["a","b"]]
 * 输出："hi?"
 * 解释：由于不知道键 "name" 对应的值，所以用 "?" 替换 "(name)" 。
 * 示例 3：
 * <p>
 * 输入：s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
 * 输出："yesyesyesaaa"
 * 解释：相同的键在 s 中可能会出现多次。
 * 键 "a" 对应的值为 "yes" ，所以将所有的 "(a)" 替换为 "yes" 。
 * 注意，不在括号里的 "a" 不需要被替换。
 * 示例 4：
 * <p>
 * 输入：s = "(a)(b)", knowledge = [["a","b"],["b","a"]]
 * 输出："ba"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * 0 <= knowledge.length <= 105
 * knowledge[i].length == 2
 * 1 <= keyi.length, valuei.length <= 10
 * s 只包含小写英文字母和圆括号 '(' 和 ')' 。
 * s 中每一个左圆括号 '(' 都有对应的右圆括号 ')' 。
 * s 中每对括号内的键都不会为空。
 * s 中不会有嵌套括号对。
 * keyi 和 valuei 只包含小写英文字母。
 * knowledge 中的 keyi 不会重复。
 */
public class Code11 {

    public String evaluate(String s, List<List<String>> knowledge) {
        //结果
        StringBuffer str = new StringBuffer();
        //缓存
        Map<String, String> map = new HashMap<>(knowledge.size());
        //循环
        for (List<String> list : knowledge) {
            //组装
            map.put(list.get(0), list.get(1));
        }
        //转化为组
        char[] arr = s.toCharArray();
        //循环
        for (int i = 0; i < arr.length; i++) {
            //当前
            char x = arr[i];
            //如果是组
            if (x == '(') {
                //key
                StringBuffer space = new StringBuffer();
                //循环2
                for (int j = i + 1; j < arr.length; j++) {
                    //当前
                    char y = arr[j];
                    //如果是
                    if (y == ')') {
                        //组装替换值,默认?
                        str.append(map.getOrDefault(space.toString(), "?"));
                        //下一位
                        i = j ;
                        //结束本次
                        break;
                    } else {
                        //否则直接组装
                        space.append(y);
                    }
                }
            } else {
                //否则直接组装
                str.append(x);
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        List<List<String>> knowledge = new ArrayList<>();
        knowledge.add(Arrays.asList("name", "bob"));
        knowledge.add(Arrays.asList("age", "two"));
        System.out.println(new Code11().evaluate("(name)is(age)yearsold", knowledge));
    }
}
