package easy28;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author ayl
 * @Date 2023-02-24
 * 696. 计数二进制子串
 * 给定一个字符串 s，统计并返回具有相同数量 0 和 1 的非空（连续）子字符串的数量，并且这些子字符串中的所有 0 和所有 1 都是成组连续的。
 * <p>
 * 重复出现（不同位置）的子串也要统计它们出现的次数。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110011"
 * 输出：6
 * 解释：6 个子串满足具有相同数量的连续 1 和 0 ："0011"、"01"、"1100"、"10"、"0011" 和 "01" 。
 * 注意，一些重复出现的子串（不同位置）要统计它们出现的次数。
 * 另外，"00110011" 不是有效的子串，因为所有的 0（还有 1 ）没有组合在一起。
 * 示例 2：
 * <p>
 * 输入：s = "10101"
 * 输出：4
 * 解释：有 4 个子串："10"、"01"、"10"、"01" ，具有相同数量的连续 1 和 0 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 105
 * s[i] 为 '0' 或 '1'
 */
public class Code13 {

    public int countBinarySubstrings(String s) {
        //缓存
        List<Integer> list = new ArrayList<>();
        //连击char
        char hitChar = s.charAt(0);
        //次数
        int hit = 1;
        //循环
        for (int i = 1; i < s.length(); i++) {
            //当前char
            char thisChar = s.charAt(i);
            //如果是
            if (thisChar == hitChar) {
                //记录
                hit++;
                //本轮过
                continue;
            }
            //记录连击
            list.add(hit);
            //换
            hitChar = thisChar;
            hit = 1;
        }
        //最后加入
        list.add(hit);
        //结果
        int sum = 0;
        //循环
        for (int i = 1; i < list.size(); i++) {
            //记录本次结果
            sum += Math.min(list.get(i - 1), list.get(i));
        }
        //结果
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Code13().countBinarySubstrings("00110"));
    }

}
