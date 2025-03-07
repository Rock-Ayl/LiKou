package normal39;

/**
 * @Author ayl
 * @Date 2025-01-31
 * 3325. 字符至少出现 K 次的子字符串 I
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个字符串 s 和一个整数 k，在 s 的所有子字符串中，请你统计并返回 至少有一个 字符 至少出现 k 次的子字符串总数。
 * <p>
 * 子字符串 是字符串中的一个连续、 非空 的字符序列。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入： s = "abacb", k = 2
 * <p>
 * 输出： 4
 * <p>
 * 解释：
 * <p>
 * 符合条件的子字符串如下：
 * <p>
 * "aba"（字符 'a' 出现 2 次）。
 * "abac"（字符 'a' 出现 2 次）。
 * "abacb"（字符 'a' 出现 2 次）。
 * "bacb"（字符 'b' 出现 2 次）。
 * 示例 2：
 * <p>
 * 输入： s = "abcde", k = 1
 * <p>
 * 输出： 15
 * <p>
 * 解释：
 * <p>
 * 所有子字符串都有效，因为每个字符至少出现一次。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 3000
 * 1 <= k <= s.length
 * s 仅由小写英文字母组成。
 */
public class Code20 {

    public int numberOfSubstrings(String s, int k) {
        //数组缓存
        int[] arr = new int[127];
        //满足条件的数据数量
        int count = 0;
        //开始索引
        int start = 0;
        //结束索引
        int end = 0;
        //结果
        int result = 0;
        //循环
        while (true) {
            //如果不够
            while (count == 0 && end < s.length()) {
                //+1，并判断是否符合条件
                if (++arr[s.charAt(end++)] == k) {
                    //符合条件+1
                    count++;
                }
            }
            //如果到这里都匹配不上
            if (count == 0) {
                //跳出
                break;
            }
            //叠加本次结果
            result += s.length() - end + 1;
            //滑动、下一个、-1，并判断是否符合条件
            if (arr[s.charAt(start++)]-- == k) {
                //符合条件-1
                count--;
            }
            //如果彻底结束了
            if (start == s.length()) {
                //跳出
                break;
            }
        }
        //返回结果
        return result;
    }

    public static void main(String[] args) {
        System.out.println(new Code20().numberOfSubstrings("abacb", 2));
    }

}
