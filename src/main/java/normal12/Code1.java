package normal12;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-02-19
 * 1249. 移除无效的括号
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')' （可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下 任意一条 要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作 AB（A 连接 B）的字符串，其中 A 和 B 都是有效「括号字符串」
 * 可以被写作 (A) 的字符串，其中 A 是一个有效的「括号字符串」
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "lee(t(c)o)de)"
 * 输出："lee(t(c)o)de"
 * 解释："lee(t(co)de)" , "lee(t(c)ode)" 也是一个可行答案。
 * 示例 2：
 * <p>
 * 输入：s = "a)b(c)d"
 * 输出："ab(c)d"
 * 示例 3：
 * <p>
 * 输入：s = "))(("
 * 输出：""
 * 解释：空字符串也是有效的
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 可能是 '('、')' 或英文小写字母
 */
public class Code1 {

    public String minRemoveToMakeValid(String s) {
        //队列
        Stack<Integer> stack = new Stack<>();
        //要被删除的set
        Set<Integer> deleteSet = new HashSet<>();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前
            char current = s.charAt(i);
            //如果是目标字符
            if (current == '(' || current == ')') {
                //如果是左
                if (current == '(') {
                    //直接记录
                    stack.push(i);
                } else {
                    //如果队列没有值
                    if (stack.isEmpty()) {
                        //直接记录其被删除
                        deleteSet.add(i);
                    } else {
                        //如果可配对
                        if (s.charAt(stack.peek()) == '(') {
                            //删除最后一个
                            stack.pop();
                            //本次过
                            continue;
                        } else {
                            //记录其删除
                            deleteSet.add(i);
                        }
                    }
                }
            }
        }
        //最后,剩下的都归为要删除的
        deleteSet.addAll(stack);
        //初始化结果
        StringBuilder str = new StringBuilder();
        //循环
        for (int i = 0; i < s.length(); i++) {
            //当前
            char current = s.charAt(i);
            //如果是正常字符
            if (current != '(' && current != ')') {
                //组装
                str.append(current);
            } else {
                //如果不需要删除
                if (deleteSet.contains(i) == false) {
                    //组装
                    str.append(current);
                }
            }
        }
        //返回
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Code1().minRemoveToMakeValid("))(("));
    }

}
