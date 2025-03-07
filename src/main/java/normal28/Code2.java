package normal28;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @Author ayl
 * @Date 2024-01-16
 * 1513. 仅含 1 的子串数
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s（仅由 '0' 和 '1' 组成的字符串）。
 * <p>
 * 返回所有字符都为 1 的子字符串的数目。
 * <p>
 * 由于答案可能很大，请你将它对 10^9 + 7 取模后返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "0110111"
 * 输出：9
 * 解释：共有 9 个子字符串仅由 '1' 组成
 * "1" -> 5 次
 * "11" -> 3 次
 * "111" -> 1 次
 * 示例 2：
 * <p>
 * 输入：s = "101"
 * 输出：2
 * 解释：子字符串 "1" 在 s 中共出现 2 次
 * 示例 3：
 * <p>
 * 输入：s = "111111"
 * 输出：21
 * 解释：每个子字符串都仅由 '1' 组成
 * 示例 4：
 * <p>
 * 输入：s = "000"
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * s[i] == '0' 或 s[i] == '1'
 * 1 <= s.length <= 10^5
 */
public class Code2 {

    //实现
    public int numSub(String s) {
        //根据0拆分,按照长度分组
        return Arrays
                //拆分
                .stream(s.split("0"))
                //只需要>0的数据
                .filter(p -> p.length() > 0)
                //按照1的长度分组
                .collect(Collectors.groupingBy(String::length, Collectors.counting()))
                //转化为集合
                .entrySet()
                //集合转化为流
                .stream()
                //每个节点计算和
                .map(p ->  ((1 + p.getKey().longValue()) * (p.getKey().longValue() / 2) + (p.getKey().longValue() % 2 == 0 ? 0 : ((1 + p.getKey().longValue()) / 2))) * p.getValue())
                //求和
                .reduce((a, b) -> a + b)
                //取模
                .map(p -> p % 1000000007L)
                //转化为int
                .map(Long::intValue)
                //默认0
                .orElse(0);
    }

    public static void main(String[] args) {
        System.out.println(new Code2().numSub("0110111"));
    }

}
