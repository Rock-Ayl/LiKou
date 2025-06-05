package normal43;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author ayl
 * @Date 2025-06-05
 * 1461. 检查一个字符串是否包含所有长度为 K 的二进制子串
 * 中等
 * 相关标签
 * premium lock icon
 * 相关企业
 * 提示
 * 给你一个二进制字符串 s 和一个整数 k 。如果所有长度为 k 的二进制字符串都是 s 的子串，请返回 true ，否则请返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "00110110", k = 2
 * 输出：true
 * 解释：长度为 2 的二进制串包括 "00"，"01"，"10" 和 "11"。它们分别是 s 中下标为 0，1，3，2 开始的长度为 2 的子串。
 * 示例 2：
 * <p>
 * 输入：s = "0110", k = 1
 * 输出：true
 * 解释：长度为 1 的二进制串包括 "0" 和 "1"，显然它们都是 s 的子串。
 * 示例 3：
 * <p>
 * 输入：s = "0110", k = 2
 * 输出：false
 * 解释：长度为 2 的二进制串 "00" 没有出现在 s 中。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 5 * 105
 * s[i] 不是'0' 就是 '1'
 * 1 <= k <= 20
 */
public class Code18 {

    public boolean hasAllCodes(String s, int k) {

        /**
         * 判断是否可能存在结果
         */

        //计算目标结果数量
        int target = 2 << k - 1;
        //如果长度不够
        if (s.length() + 1 < target) {
            //过
            return false;
        }

        /**
         * 初始化第一个
         */

        //结果集合
        Set<String> set = new HashSet<>();
        //滑动右边
        int end = 0;
        //初始化数字
        StringBuilder str = new StringBuilder();
        //循环
        while (str.length() < k) {
            //叠加,+1
            str.append(s.charAt(end++));
        }
        //记录第一次结果
        set.add(str.toString());

        /**
         * 滑动剩下
         */

        //循环
        while (end < s.length()) {
            //删除一个
            str.deleteCharAt(0);
            //增加一个
            str.append(s.charAt(end++));
            //记录本次结果
            set.add(str.toString());
            //如果所有结果均出现
            if (set.size() == target) {
                //结束
                return true;
            }
        }

        //默认不行
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new Code18().hasAllCodes("00110110", 2));
    }

}
