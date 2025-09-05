package normal46;

/**
 * @Author ayl
 * @Date 2025-09-05
 * 1759. 统计同质子字符串的数目
 * 算术评级: 3
 * 第 228 场周赛
 * Q2
 * 同步题目状态
 * <p>
 * 1491
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个字符串 s ，返回 s 中 同质子字符串 的数目。由于答案可能很大，只需返回对 109 + 7 取余 后的结果。
 * <p>
 * 同质字符串 的定义为：如果一个字符串中的所有字符都相同，那么该字符串就是同质字符串。
 * <p>
 * 子字符串 是字符串中的一个连续字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "abbcccaa"
 * 输出：13
 * 解释：同质子字符串如下所列：
 * "a"   出现 3 次。
 * "aa"  出现 1 次。
 * "b"   出现 2 次。
 * "bb"  出现 1 次。
 * "c"   出现 3 次。
 * "cc"  出现 2 次。
 * "ccc" 出现 1 次。
 * 3 + 1 + 2 + 1 + 3 + 2 + 1 = 13
 * 示例 2：
 * <p>
 * 输入：s = "xy"
 * 输出：2
 * 解释：同质子字符串是 "x" 和 "y" 。
 * 示例 3：
 * <p>
 * 输入：s = "zzzzz"
 * 输出：15
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s 由小写字符串组成。
 */
public class Code4 {

    public int countHomogenous(String s) {
        //结果
        long count = 0L;
        //索引
        int index = 0;
        //循环
        while (index < s.length()) {
            //记录开始索引
            int start = index;
            //第一个
            char first = s.charAt(index);
            //如果还有后续
            while (index + 1 < s.length() && s.charAt(index + 1) == first) {
                //+1
                index++;
            }
            //计算本次结果
            count = (count + count(start, index)) % 1000000007L;
            //下一组
            index++;
        }
        //返回
        return (int) count;
    }

    //本次结果
    private long count(int start, int end) {
        //数字数量
        long count = end - start + 1;
        //返回结果
        return (count + 1) * (count / 2) + (count % 2 != 0 ? (count + 1) / 2 : 0);
    }

    public static void main(String[] args) {
        System.out.println(new Code4().countHomogenous("abbcccaa"));
    }

}
