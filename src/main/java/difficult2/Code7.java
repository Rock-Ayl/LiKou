package difficult2;

import java.util.ArrayDeque;

/**
 * @Author ayl
 * @Date 2024-04-08
 * 76. 最小覆盖子串
 * 困难
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
 * 如果 s 中存在这样的子串，我们保证它是唯一的答案。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "ADOBECODEBANC", t = "ABC"
 * 输出："BANC"
 * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
 * 示例 2：
 * <p>
 * 输入：s = "a", t = "a"
 * 输出："a"
 * 解释：整个字符串 s 是最小覆盖子串。
 * 示例 3:
 * <p>
 * 输入: s = "a", t = "aa"
 * 输出: ""
 * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
 * 因此没有符合条件的子字符串，返回空字符串。
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == s.length
 * n == t.length
 * 1 <= m, n <= 105
 * s 和 t 由英文字母组成
 * <p>
 * <p>
 * 进阶：你能设计一个在 o(m+n) 时间内解决此问题的算法吗？
 */
public class Code7 {

    public String minWindow(String s, String t) {
        //如果长度不满足
        if (s.length() < t.length()) {
            //过
            return "";
        }
        //如果相同
        if (s.equals(t)) {
            //返回
            return t;
        }
        //初始化目标字符数量缓存
        int[] targetArr = new int[130];
        //循环
        for (char letter : t.toCharArray()) {
            //记录
            targetArr[letter]++;
        }
        //当前字符量
        int[] currentArr = new int[130];
        //符合条件字符总数
        int count = 0;
        //初始化双端队列
        ArrayDeque<Character> arrayDeque = new ArrayDeque<>();
        //初始化最终结果
        String minResult = s;
        //是否有结果,默认没有
        boolean hadResult = false;
        //循环
        for (char letter : s.toCharArray()) {
            //记录本次
            arrayDeque.addLast(letter);
            //如果是有效的数量
            if (++currentArr[letter] <= targetArr[letter]) {
                //记录数量
                count++;
            }
            //如果是目标结果长度
            while (count == t.length()) {
                //获取最后一个字符
                Character last = arrayDeque.pollFirst();
                //判断最后一个的目标值,如果减少这个将会中断连续
                if (--currentArr[last] < targetArr[last]) {
                    //回滚该操作,因为不可以删除最左边字符
                    currentArr[last]++;
                    arrayDeque.addFirst(last);
                    //如果要刷新本次结果
                    if (arrayDeque.size() < minResult.length()) {
                        //合并本次结果为string,并覆盖原有结果
                        minResult = arrayDeque
                                .stream()
                                .map(p -> p + "")
                                .map(StringBuffer::new)
                                .reduce(StringBuffer::append)
                                .map(StringBuffer::toString)
                                .orElse(null);
                    }
                    //到了这里,说明一定有结果
                    hadResult = true;
                    //跳出
                    break;
                }
            }
        }
        //如果有结果,返回结果
        return hadResult == true ? minResult : "";
    }

    public static void main(String[] args) {
        System.out.println(new Code7().minWindow("coobdafceeaxab", "abc"));
    }

}
