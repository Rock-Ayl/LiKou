package normal9;

import java.util.Stack;

/**
 * @Author ayl
 * @Date 2022-01-04
 * 1003. 检查替换后的词是否有效
 * 给你一个字符串 s ，请你判断它是否 有效 。
 * 字符串 s 有效 需要满足：假设开始有一个空字符串 t = "" ，你可以执行 任意次 下述操作将 t 转换为 s ：
 * <p>
 * 将字符串 "abc" 插入到 t 中的任意位置。形式上，t 变为 tleft + "abc" + tright，其中 t == tleft + tright 。注意，tleft 和 tright 可能为 空 。
 * 如果字符串 s 有效，则返回 true；否则，返回 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aabcbc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "aabcbc"
 * 因此，"aabcbc" 有效。
 * 示例 2：
 * <p>
 * 输入：s = "abcabcababcc"
 * 输出：true
 * 解释：
 * "" -> "abc" -> "abcabc" -> "abcabcabc" -> "abcabcababcc"
 * 因此，"abcabcababcc" 有效。
 * 示例 3：
 * <p>
 * 输入：s = "abccba"
 * 输出：false
 * 解释：执行操作无法得到 "abccba" 。
 * 示例 4：
 * <p>
 * 输入：s = "cababc"
 * 输出：false
 * 解释：执行操作无法得到 "cababc" 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 2 * 104
 * s 由字母 'a'、'b' 和 'c' 组成
 * 通过次数12,776提交次数22,033
 */
public class Code9 {

    public boolean isValid2(String s) {
        //栈
        Stack<Character> stack = new Stack<>();
        //循环
        for (char c : s.toCharArray()) {
            //如果是前两个
            if (c == 'a' || c == 'b') {
                //直接后入
                stack.push(c);
            } else if (c == 'c') {
                //判空
                if (stack.size() == 0) {
                    //直接结束
                    return false;
                }
                //上一个
                char last = stack.pop();
                //如果上一个是b
                if (last == 'b') {
                    //判空
                    if (stack.size() == 0) {
                        //直接结束
                        return false;
                    }
                    //再弄上一个
                    Character before = stack.pop();
                    //如果是
                    if (before == 'a') {
                        //本次过
                        continue;
                    } else {
                        //回溯
                        stack.push(last);
                        stack.push(before);
                    }
                } else {
                    //回溯
                    stack.push(last);
                }
                //推进
                stack.push(c);
            }
        }
        //返回结论
        return stack.size() == 0;
    }

    public boolean next(String s) {
        //直接替换所有
        String next = s.replaceAll("abc", "");
        //根据长度进行下一步
        if (next.length() == 0) {
            //如果长度到0,视为是
            return true;
        } else if (next.length() == s.length()) {
            //如果长度和之前一致
            return false;
        } else {
            //继续
            return isValid(next);
        }
    }

    public boolean isValid(String s) {
        //如果不能被三整除
        if (s.length() % 3 != 0) {
            //肯定不行
            return false;
        }
        //不断计算
        return next(s);
    }

    public static void main(String[] args) {
        System.out.println(new Code9().isValid2("abacbcabcc"));
    }
}
