package easy44;

/**
 * 3407. 子字符串匹配模式
 * 尝试过
 * 算术评级: 3
 * 第 147 场双周赛
 * Q1
 * 同步题目状态
 * <p>
 * 1473
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个模式字符串 p ，其中 p 恰好 包含 一个 '*' 符号。
 * <p>
 * p 中的 '*' 符号可以被替换为零个或多个字符组成的任意字符序列。
 * <p>
 * 如果 p 可以变成 s 的 子字符串，那么返回 true ，否则返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "leetcode", p = "ee*e"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 将 '*' 替换为 "tcod" ，子字符串 "eetcode" 匹配模式串。
 * <p>
 * 示例 2：
 * <p>
 * 输入：s = "car", p = "c*v"
 * <p>
 * 输出：false
 * <p>
 * 解释：
 * <p>
 * 不存在匹配模式串的子字符串。
 * <p>
 * 示例 3：
 * <p>
 * 输入：s = "luck", p = "u*"
 * <p>
 * 输出：true
 * <p>
 * 解释：
 * <p>
 * 子字符串 "u" ，"uc" 和 "uck" 都匹配模式串。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 50
 * 1 <= p.length <= 50
 * s 只包含小写英文字母。
 * p 只包含小写英文字母和一个 '*' 符号。
 */
public class Code6 {

    public boolean hasMatch(String s, String p) {
        //获取索引
        int mid = p.indexOf("*");
        //如果是头 or 尾部
        if (mid == 0 || mid == p.length() - 1) {
            //删除*
            String key = p.replaceFirst("\\*", "");
            //判断是否存在
            return s.contains(key);
        } else {
            //分割
            String a = p.substring(0, mid);
            String b = p.substring(mid + 1);
            //获取a的索引位置
            int first = s.indexOf(a);
            //如果不存在
            if (first == -1) {
                //不行
                return false;
            }
            //第二块最近的位置
            int secondFirst = first + a.length();
            //获取b的索引位置
            int last = s.indexOf(b, secondFirst);
            //如果不存在
            if (last == -1) {
                //不行
                return false;
            }
            //默认
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Code6().hasMatch("leetcode", "ee*e"));
    }

}
